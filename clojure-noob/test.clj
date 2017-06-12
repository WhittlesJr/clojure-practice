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
