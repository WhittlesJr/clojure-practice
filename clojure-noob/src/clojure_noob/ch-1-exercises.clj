(str "hello" (+ 1 5))

(let [stufflist '(1 2 3)]
  (map vector stufflist))


(vector 1 2 3 4)

(list 2 3 4 5)

(hash-map :a :b :c :D)

(hash-set :a :a :b :B :c :d :e)


(defn inc100 [x] (+ x 100))

(inc100 5)

(defn dec-maker [decrement]
  (fn [x] (- x decrement)))

(defn dec50 [x] ((dec-maker 50) x))

(def dec50 (dec-maker 50))

(dec50 100)
