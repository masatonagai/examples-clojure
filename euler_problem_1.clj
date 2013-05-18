;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn sum [coll]
  (reduce + (filter #(if (== 0 (rem % 3)) true (== 0 (rem % 5))) coll)))
(println (sum (range 3 1000)))
