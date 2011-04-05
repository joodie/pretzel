(ns pretzel.combine
  {:doc "Combine predicates"})

(defn combine-p
  "Combine predicates using collection function f.
Returns a new predicate that tests the collection of predicates
against the given value(s) using f."
  [f predicates]
  (fn [& values]
    (f #(apply % values) predicates)))

(defn every-p?
  "Create a new predicate which is true if every predicate is true"
  [& predicates]
  (combine-p every? predicates))

(defn some-p
  "Create a new predicate returning the first true value of predicates"
  [& predicates]
  (combine-p some predicates))

(defn not-any-p?
  "Create a new predicate returning false if all predicates return true"
  [& predicates]
  (combine-p not-any? predicates))

(defn not-every-p?
  "Create a new predicate returning true if any predicate returns false"
  [& predicates]
  (combine-p not-every? predicates))


