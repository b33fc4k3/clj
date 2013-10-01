(ns clj.core
  (require [net.cgrand.enlive-html :as html])
  (:use clojure.algo.monads))

; (foo "blub")
(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

; as seen here: http://onclojure.com/2009/03/05/a-monad-tutorial-for-clojure-programmers-part-1/
; (macroexpand-1 '(domonad identity-m [a 1 b (inc a)] (* a b)))
(domonad identity-m
  [a  1
   b  (inc a)]
  (* a b))

; (parse-tds "http://127.0.0.1")
(defn parse-tds [url] 
 (html/select (html/html-resource (java.net.URL. url)) [:li]))
