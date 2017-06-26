(defn titleize [topic]
  (str topic " for the Brave and True"))

(map titleize ["Hamsters" "Ragnarok"])

(map titleize '("Empathy" "Decorating"))

(map titleize #{"Elbows" "Soap Carving"})

(map #(titleize (second %)) {:uncomfortable-thing "Winking"
                             :gooberboober "Slurping"})

(cons :blerp '(1 2 2 3))

(cons :blerp [1 2 2 3])


(seq '(1 2 3))
(seq '[1 2 3])

(seq #{1 2 3})
(seq {:name "Bill Compton" :occupation "Dead mopey guy"})

(into {} (seq {:a 1 :b 2 :c 3}))

(seq {:a 1 :b 2 :c 3})

;; Map
(map inc [1 2 3])
(map str ["a" "b" "c"] ["A" "B" "C"])

(def human-consumption [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])

(defn unify-diet-data [human critter]
  {:human human
   :critter critter
   :total (+ human critter)})

(map unify-diet-data human-consumption critter-consumption)

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])

(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])

(map :real identities)

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 3.9
         :bob 4.2
         :critter 4.1})


(map #(+  % 1) '(1 2 3 4))

(defn my-map [given-func given-seq]
  (seq (reduce #(conj %1 (given-func %2))
               []
               given-seq)))


(my-map #(+  % 1) #{1 2 3 4})

(map #(+  % 1) #{1 2 3 4})

(take 3 [1 2 3 4 5 6 7 8 9])

(drop 3 [1 2 3 4 5 6 7 8 9])

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 2 :day 2 :human 5.0 :critter 2.55555555555555555555}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(< (:month %) 3) food-journal)
(drop-while #(< (:month %) 3) food-journal)

;Feb and march only
(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))

(filter #(< (:human %) 5.0) food-journal)

(some #(> (:critter %) 5) food-journal)

(some #(> (:critter %) 3) food-journal)

; Actually return first matching value
(some #(and (> (:critter %) 3) %) food-journal)

(sort [3 1 2])

(sort ["1-1-2" "1-2-1" "3-2-1" "1-blah1-1"])

(sort-by count ["aaa" "," "bb"])

(concat [1 2] [3 4])

(concat '(1) '(2 3))

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details [social-security-number]
  (Thread/sleep 50)
  (get vampire-database social-security-number))

(defn vampire? [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identity-vampire [social-security-numbers]
  (first (filter vampire? (map vampire-related-details social-security-numbers))))


;(time (vampire-related-details 0))

;(time (def mapped-details (map vampire-related-details (range 0 100000000))))

;(time (first mapped-details))
;(time (first mapped-details))

;(time (identity-vampire (range 0 10000000)))

(clojure.string/join " " (concat (take 8 (repeat "na")) ["Batman!"]))

(take 3 (repeatedly (fn [] (rand-int 10))))

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(take 10 (even-numbers))

;; Collections
(empty? [])

(empty? ["no!"])

(map identity {:sunlight-reaction "Glitter!"})

(into {} (map identity {:sunlight-reaction "Glitter!"}))

(map identity [:garlic :sesame-oil :fried-eggs])

(into [] (map identity [:garlic :sesame-oil :fried-eggs]))

(into #{} (map identity [:garlic-clove :garlic-clove]))

(into {:favorite-emotion "gloomy"} [[:sunlight-reaction "Glitter!"]])

(into ["cherry"] '("pine" "spruce"))

(into {:favorite-animal "kitty"} {:least-favorite-smell "dog"
                                  :relationship-with-teenager "creepy"})

(conj [0] [1])

(into [0] [1])

(conj [0] 1)

;(into [0] 1) ;Error!

(conj [0] 1 2 3 4)

(conj {:time "midnight"} [:place "ye olde cemetarium!"])

(into {:time "midnight"} [[:place "ye olde cemetarium!"]])

(defn my-conj [into-coll & additions]
  (into into-coll additions))

(my-conj [0] 1 2 3 4)

(max 0 1 2)

(max [0 1 2])

(apply max [0 1 2])

(defn my-into [target additions]
  (apply conj target additions))

(my-into [0] [1 2 3])

(def add10 (partial + 10))

(add10 3)
(add10 3 4 5 6 )

(def add-missing-elements
  (partial conj ["water" "earth" "air"]))

(add-missing-elements "unobtainium" "adamantium")

(defn my-partial [f & args]
  (fn [& more-args]
    (apply f (into args more-args))))

(def add20 (my-partial + 20))

(add20 5)

(defn lousy-logger
  [log-level message]
  (condp = log-level
    :warn (clojure.string/lower-case message)
    :emergency (clojure.string/upper-case message)))

(def warn (partial lousy-logger :warn))
(def emergency (partial lousy-logger :emergency))
(warn "Red light ahead")
(emergency "Red light ahead")

(def not-vampire? (complement vampire?))

(defn identify-humans
  [social-security-numbers]
  (filter not-vampire?
          (map vampire-related-details social-security-numbers)))


(defn my-compliment [f]
  (fn [& args]
    (not (apply f args))))

(def my-pos? (complement neg?))

(my-pos? 1)
(my-pos? -1)

(every? #(second %) {:a true :b true})
