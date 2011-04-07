# pretzel

General predicate functions.
Combine predicates into new ones, plus a bunch of predicates on strings.

## Usage

Get the code from clojars: http://clojars.org/pretzel

    (require '[pretzel.strings :as str])
    
    (str/natural? "1234")
    (str/integer? "-123213")             
    (str/hex? "deadb33f")
    ((str/length 3) "bla")
    ((str/length 2 4) "bla")
    (str/web-url? "http://foo.bar/somewhere")

    (str/looks-like-email? "bla@example.com")
    (str/looks-like-phone? "+ (020) 213213-2323")

    (use 'pretzel.combine)
    
    ((every-p?
      str/natural?
      (str/length 2 3))
     "123")

## API

### strings

Functions in `pretzel.strings` all operate on strings. Functions with
names ending in "?" should be real predicates - that is; they return
strictly `true` or `false`. Predicates that require additional
parameters are generated as curried functions. See
`pretzel.string/length` for an example.

Functions that are named `looks-like-*` are approximations and may
yield false positives and false negatives. The strategy is to minimize
overall false negatives in the "real world". There are currently no
equivalent functions to minimize false positives.

### combining predicates

Functions in `pretzel.combine` combine multiple predicates applying to
the same argument(s) into a new predicate. Currently, the combinations
are based on the clojure.core combinations `some`, `every?`,
`not-any?` and `not-every?`. Note that, since `some` isn't a
predicate, `some-p` is not a strict predicate either.


## Open development

Any additional predicates are welcomed, as are bug fixes or
reports. For bug fixes/reports, keep in mind that looks-like-*
predicates are meant to be roughly non-strict. If you've got
suggestions for strict counter-parts, please also suggest a naming
scheme and implementations.

The quickest way to get fixes & features in this project is to open a
pull request for a patch. See the github documentation on pull
requests on how to go about that.

## License

Copyright (C) 2011 Joost Diepenmaat, Zeekat Softwareontwikkeling
joost@zeekat.nl - http://joost.zeekat.nl/

Distributed under the Eclipse Public License, the same as Clojure.
