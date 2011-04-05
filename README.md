# pretzel

General predicate functions.
Combine predicates into new ones, plus a bunch of predicates on strings.

## Usage

Get the code from clojars: http://clojars.org/pretzel

    (require '[pretzel.strings :as str])
    
    (str/looks-like-email? "foo@example.com")
    (str/natural? "1234")
    (str/integer? "-123213")             
    (str/hex? "deadb33f")
    (str/length? 3 "bla")
    (str/length? 2 4 "bla")
    (str/web-url? "http://foo.bar/somewhere")
    (str/looks-like-email? "bla@example.com")
    (str/looks-like-phone? "+ (020) 213213-2323")

    (use 'pretzel.combine)
    
    ((every-p?
      str/natural?
      (partial str/length 2 3))
     "123")
      
## License

Copyright (C) 2010 Joost Diepenmaat, Zeekat Softwareontwikkeling
joost@zeekat.nl - http://joost.zeekat.nl/

Distributed under the Eclipse Public License, the same as Clojure.
