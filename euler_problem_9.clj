;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;; 
;; a^2 + b^2 = c^2
;; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;; 
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.

(defn square [n]
  (* n n))

(defn square-root [n]
  (Math/sqrt n))

(defn pytha [a b]
  (square-root (+ (square a) (square b))))

(assert (== 5 (pytha 3 4)))

(defn answer [sum]
  (reduce
    *
    (first
      (for [a (range 1 sum)
            b (range a sum)
            :let [c (pytha a b)]
            :when (== sum (reduce + [a b c]))]
        [a b (int c)]))))

(assert
  (== 60 (answer 12)))

(println
  (answer 1000))
