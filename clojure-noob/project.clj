(defproject clojure-noob "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.typed "0.3.32"  :classifier "slim"]]

  :plugins [[lein-environ "1.0.0"]]

  :main ^:skip-aot clojure-noob.core

  :target-path "target/%s"

  :profiles {:dev {:env {:squiggly {:checkers [:eastwood :typed]
                                  :eastwood-exclude-linters [:unlimited-use]
                                  :eastwood-options {;; :builtin-config-files ["myconfigfile.clj"]
                                                     }}}}
             :uberjar {:aot :all}})
