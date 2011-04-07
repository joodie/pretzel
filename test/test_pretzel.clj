(ns test-pretzel
  (:require [pretzel.strings :as str])
  (:use clojure.test)
  (:import java.net.URL))

(deftest test-ok
  (is (str/natural? "1234"))
  (is (str/integer? "-123213"))             
  (is (str/hex? "deadb33f"))
  (is ((str/length 3) "bla"))
  (is ((str/length 2 4) "bla"))
  (is (str/web-url? "http://foo.bar/somewhere"))
  (is (str/looks-like-email? "bla@example.com"))
  (is (str/looks-like-phone? "+ (020) 213213-2323")))

(deftest test-false
  (is (not (str/looks-like-email? "fooexample.com)")))
  (is (not (str/natural? "12 34")))
  (is (not (str/integer? "- 123213")))             
  (is (not (str/hex? "deadbg3f")))
  (is (not ((str/length 3) "1234")))
  (is (not ((str/length 2 4) "12345")))
  (is (not (str/web-url? "file:///tmp/foo.txt")))
  (is (not (str/looks-like-email? "bla@example@foo.com")))
  (is (not (str/looks-like-phone? "+ (020) CALL-ME-NOW"))))




