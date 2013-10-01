(ns clj.core
  (require [net.cgrand.enlive-html :as html])
  (:use clojure.algo.monads)
  (:use clojure.java.shell)
  ;(:use '[clojure.java.shell :only [sh]])
  ;(require [clojure.java.shell :refer [sh]])
)
;(use 'clojure.repl)
; imenu
; euler: http://clojure-euler.wikispaces.com/Problem+001

; (foo "blub")
(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

; as seen here: http://onclojure.com/2009/03/05/a-monad-tutorial-for-clojure-programmers-part-1/
; also http://www.intensivesystems.net/tutorials/monads_101.html
; (macroexpand-1 '(domonad identity-m [a 1 b (inc a)] (* a b)))
(domonad identity-m
  [a  1
   b  (inc a)]
  (* a b))

; (parse-tds "http://127.0.0.1")
(defn parse-tds [url] 
 (html/select (html/html-resource (java.net.URL. url)) [:li]))

; bla bla only vector
;; (defn blub
;;   (sh "free"))

(sh "free")

(defn echo [& args]
  (apply sh "echo" args))

(defn echo-version []
  (-> "--version" call-external-prog :out println))

(defn call-external-prog [& args]
  (apply sh "ps" args))
