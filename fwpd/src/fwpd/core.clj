(ns fwpd.core)
(use 'clojure.java.io)

(defn str->int [str]
  (Integer. str))

(def filename "suspects.csv")
(def vamp-keys [:name :glitter-index])
(def conversions {:glitter-index str->int})

(defn convert [vamp-key value]
  ((get conversions vamp-key identity) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify [rows]
  (map #(reduce (fn [row-map [vamp-key value]]
                  (assoc row-map vamp-key (convert vamp-key value)))
                {}
                (map vector vamp-keys %))
       rows))

(defn mapify-file [filename]
  (mapify (parse (slurp filename))))

(defn get-list-of-resuls-by-key
  [result-map key-name]
  (reduce (fn [coll each] (conj coll (get each key-name)))
          []
          result-map))

(defn filter-records-by-benchmark
  [key-name comparison benchmark records]
  (filter #(comparison (key-name %) benchmark) records))

(defn filter-file-contents [filter-fn filename]
  (filter-fn (mapify-file filename)))

(defn convert-records-to-list-by-key
  [key-name records]
  (get-list-of-resuls-by-key records key-name))

(def glitter-filter (partial filter-records-by-benchmark :glitter-index))
(def vampire-level-glitter-filter (partial glitter-filter >= 3))
(def human-level-glitter-filter (partial glitter-filter < 3))
(def names-from-records (partial convert-records-to-list-by-key :name))

(defn human-names [records]
  (names-from-records (human-level-glitter-filter records)))

(defn vampire-names [records]
  (names-from-records (vampire-level-glitter-filter records)))

;; Exercises
(def validations
  {:name (fn [x] (and (string? x)
                      (< (count x) 25)))
   :glitter-index (fn [x] (and (pos? x)
                               (<= x 9000)))})

(defn validate [validations record]
  (every? #((second %) ((first %) record)) validations))

(defn append
  ([record records]
   (if (validate validations record)
     (conj records record)
     records))
  ([name glitter-index records]
   (append {:name name :glitter-index glitter-index} records)))

(defn unmapify [records]
  (reduce (fn [new-coll each-item]
            (conj new-coll (map #(second %) each-item)))
          []
          records))

(defn build-csv-contents [records]
  (clojure.string/join "\n" (map #(clojure.string/join "," %)
                                 (unmapify records))))

(defn save-records-as-csv
  [records filename]
  (spit filename (build-csv-contents records)))



;; Tests
(def csv-records (mapify-file filename))
csv-records

(human-names csv-records)
(vampire-names csv-records)
(save-records-as-csv csv-records "suspects-out.csv")

(build-csv-contents csv-records)

(unmapify csv-records)



(append "Test" 9001 csv-records)
(append "sdstndstndstndstndstndstndstndstndstndstndstndsndstnTest" 9000 csv-records)
(append 100 9000 csv-records)

(save-records-as-csv (append "Test" 9000 csv-records) "out2.csv")
