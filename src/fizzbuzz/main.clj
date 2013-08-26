(ns fizzbuzz.main)

; utility functions
(defn divisible? [i d] (= 0 (mod i d)))
(defn non-blank [s] (if-not (clojure.string/blank? s) s))

(defn fizzbuzz-str [n]
  "Calculate the output string."
  (let [fizz (when (divisible? n 3) "fizz")
        buzz (when (divisible? n 5) "buzz")]
    (or (non-blank (str fizz buzz))
        (str n))))

(defn fizzbuzz [nums]
  (dorun (map (comp println fizzbuzz-str) nums)))

(defn fizzbuzz-tail [nums]
  (loop [[n & ns] nums] ; this destructures the input 'nums' into the first (n) and the rest (ns) 
    (when n
      (println (fizzbuzz n))
      (recur ns))))

(fizzbuzz (range 1 101))
