(ns pretzel.strings
  {:doc "Predicates on strings"}
  (:refer-clojure :exclude [integer?])
  (:import java.net.URL
           java.net.MalformedURLException
           java.util.regex.Pattern))

(defn length
  "return a predicate that's true if length of string s is len
 or within the range [min ... max]"
  ([len]
     (fn [^String s] (= (.length s) len)))
  ([min max]
     (fn [^String s]
       (<= min (.length s) max))))

(defn- re-matches?
  "Like re-matches, only returns true or false"
  [^Pattern r ^String s]
  (if (re-matches r s)
    true
    false))

(defn natural?
  "s represents a natural number (0 - 9999...)"
  [^String s]
  (re-matches? #"\A[0-9]+\z" s))

(defn integer?
  "s represents an integer (- 999... to 999...)"
  [^String s]
  (re-matches? #"\A-?[0-9]+\z" s))

(defn hex?
  "s is a hexadecimal string (case-insensitive)"
  [^String s]
  (re-matches? #"\A[0-9A-Fa-f]+\z" s))

(defn blank?
  "s contains only whitespace"
  [^String s]
  (every? #(Character/isWhitespace %) s))

(defn url
  "return a java.net.URL from string or nil if s is malformed.
Note that this will mean any URL valid according to java.net.URL"
  [^String s]
  (try
    (URL. s)
    (catch MalformedURLException e
      nil)))

(defn web-url?
  "returns true if s is an http or https URL"
  [^String s]
  (if-let [u (url s)]
    (if-let [p (.getProtocol u)]
      (or (= p "http")
          (= p "https")))))

(defn looks-like-email?
  "a fairly permissive check; s should contain no whitespace, a @
  character between the name and the domain, and a dot in the domain.
People with email at a TLD probably have other mail addresses too"
  [^String s]
  (re-matches? #"\A[^\s@]+@[^\s@]+\.[^\s@]+\z" s))

(defn looks-like-phone?
  "a phone number may start with a + sign, followed by
any number of digits, spaces, dashes and parentheses."
  [^String s]
  (re-matches? #"\A\+?[\s\d\(\)-]+\z" s))
