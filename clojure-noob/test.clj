"a string"

1

["a" "vector" "of" "strings"]

(+ 1 2 6)

(str "It was the panda " "in the library " "with a dust buster")

(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Odin's Elbow!")



(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Success!")
      "By Aquaman's trident!"))

(when true
  (println "Success!")
  "abra cadabra!" )


(nil? 1)

(nil? nil)

(if "bears eat beets"
  "bears beets Battlestar Galactica")

(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")

(= 1 1)

(= nil nil)

(= 1 2)

(or false nil :large_I_mean_venti :why_cant_I_just_say_large)

(or (= 0 1) (= "yes" "No"))

(or nil)

(and :free_wifi :hot_coffee)

(and :feelin_super_cool nil false)

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

failed-protagonist-names

(defn error-message [severity]
  (str "OH GLOB! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOMED!")))

(error-message :mild)
(error-message :bad)

(println "This shows up in the REPL when evaluated")

;Numbers:
1/5
39
1.5

;Strings

"Lord Voldemort"
(println "\"He who must not be named\"")

"\"Great cow of Moscow!\" - Hermes Conrad"

(def guys-name "Chewbacca")
(str "\"Uglglglglggglllgl\" - " guys-name)


; Maps
{:first-name "Charlie"
 :last-name "McFishwich"}

{"string-key" +}

{:name
 {:first "John"
  :middle "Jacob"
  :last "Jingleheimerschmidt"}}


(def mymap (hash-map :a 1 :b 2 :c {:d "whoo" }))

(get mymap :a)
(get mymap :C)
(get mymap :C "unicorns")

(get-in mymap [:c :d])
(get-in mymap [:c :e] "unicorns")


(mymap :a)

(:a mymap)
(:x mymap "No gnome knows homes like Noah knows")

(def myvec [0 1 2])

(get myvec 2)

(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)

(vector "creepy" "full" "moon")

(conj myvec 3)

'(1 2 3 4)

(nth '(:a :b :c) 1)

(list 1 "two" {3 4})

(conj '(1 2 2 33) 4)

#{"kurt vonnegut" 20 :icicle}

(hash-set 1 1 2 2)

(conj #{:a :b} :b)

(set [3 3 3 4 4])

(contains? #{:a :B} :a)

(contains? #{:a :B} :3)

(contains? #{nil} nil)

(:a #{:a :b})

(:c #{:a :b})

(get #{:a :b} :a)

(get #{:a nil} nil)

(get #{:a nil} "kurt vonnegut")

(+ 1 2 3 4)

(first [1 2 3 4])

(or + -)

((or + -) 1 2 3)

((and (= 1 1) +) 1 2 3)

((first [+ 0]) 1 2 3)

(inc 1.2)

(map inc [0 1 2 3])

(map inc '(0 1 2 3))

(+ (inc 199) (/ 100 (- 7 2)))

(+ 200 (/ 100 (- 7 2)))

(defn too-enthusiastic
  "Docstring"
  [name]
  (str "WHOA" name "STUFF"))

(too-enthusiastic "Zelda" )

(defn no-params []
  "No params")

(defn one-param [x]
  (str "My one param is " x))

(defn two-params [x y]
  (str "Two params: " x y))

(defn x-chop
  "DO a chop"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

;; Return the first element of a collection
(defn my-first
  [[first-thing]]
  first-thing)

(my-first ["oven" "bike" "war-axe"])

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "First: " first-choice))
  (println (str "Second: " second-choice))
  (println (str "Rest: " (clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade" "Handsome Jack" "Pigpen" "Aquaman"])


(defn treasure-location
  [{lat :lat long :long}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure long: " long)))

(treasure-location {:lat 28.22 :long 81.33})

(str nil)


(defn treasure-location-2
  [{:keys [lat long]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure long: " long)))

(treasure-location-2 {:lat 28.22 :long 81.33})


(defn treasure-location-3
  [{:keys [lat long] :as treasure-location}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure long: " long))
  (println treasure-location))

(treasure-location-3 {:lat 28.22 :long 81.33})

(defn dosomestuff []
  (+ 1 301)
  30
  "joe")

(defn bignums [x]
  (if (> x 6)
    "So big!"
    "bleh"))

(bignums 5)

(bignums 7)

(fn [params]
  (println params))

(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. Magoo" "Doggie" "Mark" "Lisa" ])

((fn [x] (* x 3)) 8)

(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 15)

(#(* % 3) 8)

(map  #(str "Hi, " %)
     ["Darth Vader" "Mr. Magoo" "Doggie" "Mark" "Lisa" ])

(#(str %1 " and " %2) "cornbread" "butter beans")

(#(identity %&) 1 "blarg" :yip)

(defn inc-maker
  "Create custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)
