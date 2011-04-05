(ns pretzel.strings
  {:doc "Predicates on strings"}
  (:import java.net.URL
           java.net.MalformedURLException))

(defn length?
  "true if length of string s is len or within the range [min ... max]"
  ([^String s len]
     (= (.length s) len))
  ([^String s min max]
     (<= min (.length s) max)))

(defn natural?
  "s represents a natural number (0 - 9999...)"
  [^String s]
  (re-matches #"\A[0-9]+\z"))

(defn integer?
  "s represents an integer (- 999... to 999...)"
  [^String s]
  (re-matches #"\A-?[0-9]+\z"))

(defn hex?
  "s is a hexadecimal string (case-insensitive)"
  [^String s]
  (re-matches #"\A[0-9A-Fa-f]+\z" s))

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

(defn web-url
  "returns a java.net.URL if that is an http or https URL"
  [^String s]
  (if-let [u (url s)]
    (if-let [p (.getProtocol s)]
      (or (= p "http")
          (= p "https")))))

(defn looks-like-email?
  "a fairly permissive check; s should contain no whitespace, a @
  character between the name and the domain, and a dot in the domain.
People with email at a TLD probably have other mail addresses too"
  [^String s]
  (re-matches #"\A[^\s@]+@[^\s@]+\.[^\s@]+\z" s))
