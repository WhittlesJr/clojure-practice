((comp inc *) 2 3)

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

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
