# pretzel

General predicate functions.
Combine predicates into new ones, plus a bunch of predicates on strings.

## Usage

Get the code from clojars: http://clojars.org/pretzel

    (use 'pretzel.strings)
    
    (looks-like-email? "foo@example.com")
    (natural? "1234")
    (integer? "-123213")
    (web-url "http://foo.bar/somewhere")
    (hex? "deadb33f")
    (length? 3 "bla")
    (length? 2 4 "bla)

    (use 'pretzel.combine)
    
    ((every-p?
      natural
      (partial length 2 3))
     "123")
      
## License

Copyright (C) 2010 Joost Diepenmaat, Zeekat Softwareontwikkeling
joost@zeekat.nl - http://joost.zeekat.nl/

Distributed under the Eclipse Public License, the same as Clojure.
