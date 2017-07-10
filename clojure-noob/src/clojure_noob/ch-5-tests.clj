((comp inc *) 2 3)

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(defn attr [attrkey]
  (comp attrkey :attributes))

(def c-int (attr :intelligence))
(def c-str (attr :strength))
(def c-dex (attr :dexterity))

(defn spell-slots [char]
  (int (inc (/ (c-int char) 2))))

(def spell-slots-comp (comp int inc #(/ % 2) c-int))

(c-int character)

(c-str character)

(c-dex character)

(spell-slots character)
(spell-slots-comp character)

(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))

((two-comp inc *) 2 3)

(defn sleepy-identity [x]
  (Thread/sleep 1000)
  x)


(def memo-sleepy-identity (memoize sleepy-identity))

(time (memo-sleepy-identity "Mr. Fantastico"))
(time (memo-sleepy-identity "Mr. Fantastico"))


(defn my-comp [& fns]
  (reduce (fn [current-fn rest-fns]
            #(current-fn (apply rest-fns %&)))
          fns))


(def my-spell-slots-comp (my-comp int inc #(/ % 2) c-int))

(my-spell-slots-comp character)

(defn my-assoc-in [map [first-key & rest-keys] value]
  (if (empty? rest-keys)
    (assoc map first-key value)
    (assoc map first-key (my-assoc-in (first-key map) rest-keys value))))

(my-assoc-in {} [:a :b :c] 1)

(update-in {:a 4 :b 2} [:a] * 2)

(update-in {:a {:b 4} :b 2} [:a :c] (fnil * 0) 2)

(apply (partial * 2) [1 2 3])

(defn my-update-in [map keys functor & args]
  (my-assoc-in map keys (apply (partial functor (get-in map keys)) args)))

(my-update-in {:a {:b 4 :c 12} :b 2} [:a :c] (fnil * 0) 2)
