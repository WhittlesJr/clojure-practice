(defmacro backwards
  [form]
  (reverse form))


(backwards (" backwards" " am" "I" str))

(def addition-list (list + 1 2))
(eval addition-list)

(eval (concat addition-list [10]))

(eval (list 'def 'lucky-number (concat addition-list [10])))

lucky-number

(read-string "(+ 1 2)")

(list? (read-string "(+ 1 2)"))

(conj (read-string "(+ 1 2)") :zagglewag)

(eval (read-string "(+ 1 2)"))

(read-string "#(+ 1 %)")

(read-string "'(a b c)")

(read-string "@var")

(read-string "; ignore!\n(+ 1 2)")

;if

(read-string "(1 + 1)")

(eval (let [infix (read-string "(1 + 1)")]
  (list (second infix) (first infix) (last infix))))

(defmacro ignore-last-operand
  [function-call]
  (butlast function-call))

(ignore-last-operand (+ 1 2 10))

(ignore-last-operand (+ 1 2 (println "look at me!!")))

(macroexpand '(ignore-last-operand (+ 1 2 10)))

(macroexpand '(ignore-last-operand (+ 1 2 (println "look at me!!"))))

(defmacro infix
  [infixed]
  (list (second infixed)
        (first infixed)
        (last infixed)))

(infix (1 + 2))


; Exercise 1
(eval (let [name-movie (read-string "(\"Alex\" \"Blade Runner\")")]
  (list str "Name: " (first name-movie) "; Movie: " (second name-movie))))

; Exercise 2
(defn group-infixed-operation-in-list
  [operator infixed-list list-position]
  (let [first-item (nth infixed-list list-position nil)
        second-item (nth infixed-list (+ list-position 1) nil)
        third-item (nth infixed-list (+ list-position 2) nil)
        list-head (take list-position infixed-list)
        list-tail (nthrest infixed-list (+ list-position 3))]

    (if (= second-item operator)
      (let [grouped-operation (list second-item first-item third-item)
            updated-list (concat list-head (conj list-tail grouped-operation))]

        (group-all-infixed-operations-in-list updated-list operator))

      infixed-list)))

(defn group-all-infixed-operations-in-list
  [original-list operator]
  (reduce (partial group-infixed-operation-in-list operator)
          original-list
          (range (count original-list))))

(defn transform-infixed-list
  [infixed-list]
  (reduce group-all-infixed-operations-in-list
          infixed-list
          ['* '/ '+ '-]))


(def infixed-list '(1 + 2 - 3 / 4 * 3))
(transform-infixed-list infixed-list)
