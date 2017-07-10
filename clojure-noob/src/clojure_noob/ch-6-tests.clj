(def great-books ["East of Eden" "Booobs"])

(ns-interns *ns*)

(get (ns-interns *ns*) 'great-books)

(ns-map *ns*)

(deref #'great-books)

(def great-books ["The Power of Bees" "Journey to Upstairs"])

(deref #'great-books)

(create-ns 'cheese.taxonomy)

(ns-name (create-ns 'cheese.taxonomy))

(in-ns 'cheese.analysis)
(in-ns 'cheese.taxonomy)
(def cheddars ["mild" "medium" "strong" "sharp" "extra sharp"])
(def bries ["Wisconsin" "Somerset" "Brie de Meaux" "Brie de Melun"])
(in-ns 'cheese.analysis)

cheese.taxonomy/cheddars

(clojure.core/refer 'cheese.taxonomy)
bries
cheddars

(clojure.core/get (clojure.core/ns-map clojure.core/*ns*) 'bries)

(in-ns 'cheese.taxonomy)
cheddars

(in-ns 'cheese.other)
(clojure.core/refer 'cheese.taxonomy :only ['bries])
bries
;cheddars

(in-ns 'cheese-poop)
(clojure.core/refer 'cheese.taxonomy :exclude ['bries])
;bries
cheddars

(clojure.core/refer 'cheese.taxonomy :rename {'bries 'yummy-bries})
yummy-bries
;bries

(clojure.core/refer-clojure)
(refer 'cheese.taxonomy :rename {'bries 'tasty-bries})
tasty-bries
(alias 'taxonomy 'cheese.taxonomy)
taxonomy/cheddars
