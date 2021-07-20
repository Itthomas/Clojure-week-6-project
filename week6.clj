;;PROJECT DESCRIPTION: Remember that scene from National Treasure
;; (https://www.youtube.com/watch?v=coUTu4ucZ8Y) when Nick Cage 
;; shines a black light on a keyboard to see what keys have been
;; pressed recently and his tech guy puts those letters into an
;; anagram program to try to find the password? I'm gonna make that
;; program, but better.
;; FEATURES:
;; -User enters a string of characters
;; -Program calculates all possible words (one word) for those letters
;; -results are sorted by most commonly used first

(defn main []
  (println (count dictionary))
  (println (count (get_anagrams "asifr")))
)

(defn get_anagrams [givenString]
  (def charVector (set (clojure.string/split (clojure.string/replace givenString #"[ ,.'-?!\"]" "") #"")))
  (if (< (count charVector) 6) (do
    (def anagrams (for [a charVector b charVector] [a b]))
    (def anagrams (concat anagrams (for [a charVector b charVector c charVector] [a b   c])))
    (def anagrams (concat anagrams (for [a charVector b charVector c charVector d   charVector] [a b c d ])))
    (def anagrams (concat anagrams (for [a charVector b charVector c charVector d   charVector e charVector] [a b c d e])))
    (def anagrams (concat anagrams (for [a charVector b charVector c charVector d   charVector e charVector f charVector] [a b c d e f])))
    (def anagrams (concat anagrams (for [a charVector b charVector c charVector d   charVector e charVector f charVector g charVector] [a b c d e f g])))
    anagrams
    (for [x anagrams] (clojure.string/join "" x))
    )
    (do
    (throw (Exception. "You can only enter up to 5 unique letters"))
    ))
)

;; good 2

(main)
