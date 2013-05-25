;; The sum of the squares of the first ten natural numbers is,
;; 1^2 + 2^2 + ... + 10^2 = 385
;; The square of the sum of the first ten natural numbers is,
;; (1 + 2 + ... + 10)^2 = 55^2 = 3025
;; Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
;; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

(defn square [n]
  (* n n))

(defn sum-of-squares [coll]
  (reduce + (map square coll)))

(assert (== 385 (sum-of-squares (range 1 11))))

(defn square-of-sum [coll]
  (square (reduce + coll)))

(assert (== 3025 (square-of-sum (range 1 11))))

(defn answer [coll]
  (- (square-of-sum coll) (sum-of-squares coll)))

(assert (== 2640 (answer (range 1 11))))

(println (answer (range 1 101)))
