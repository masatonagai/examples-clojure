;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

; (== (* (lcm a b) (gcd a b)) (* a b)
; (== (lcm a b) (/ (* a b) (gcd a b)))

(defn gcd [a, b]
  (loop [_a (max a b)
         _b (min a b)]
    (if (== _b 0)
      _a
      (recur _b (mod _a _b)))))

(assert (== 4 (gcd 12 8)))

(defn lcm [a, b]
  (/ (* a b) (gcd a b)))

(defn llcm [coll]
  (loop [_coll coll]
    (println _coll)
    (if (== 1 (.size _coll))
      (first _coll)
      (recur
        (map
          #(if (== 1 (.size %))
            (first %)
            (apply lcm %))
          (partition-all 2 _coll))))))

(assert (== 2520 (llcm (range 1 (+ 10 1)))))

(println (llcm (range 1 (+ 20 1))))
