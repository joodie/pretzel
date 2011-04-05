(ns test-pretzel
  (:require [pretzel.strings :as str])
  (:use clojure.test)
  (:import java.net.URL))

(deftest test-ok
  (is (every? true?
              [(str/looks-like-email? "foo@example.com")
               (str/natural? "1234")
               (str/integer? "-123213")             
               (str/hex? "deadb33f")
               (str/length? 3 "bla")
               (str/length? 2 4 "bla")
               (str/web-url? "http://foo.bar/somewhere")
               (str/looks-like-email? "bla@example.com")
               (str/looks-like-phone? "+ (020) 213213-2323")])))




