;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;; 
;; Find the sum of all the primes below two million.

(defn square-root [num]
  (Math/sqrt num))

(defn prime? [num]
  (let [n-sqrt (square-root num)]
  (loop [n 2]
    (if (> n n-sqrt)
      true
      (if (== 0 (mod num n))
        false
        (recur (+ n 1)))))))

(assert (prime? 3))
(assert (not (prime? 4)))

(defn answer [below]
  (loop [n 2
         sum 0]
    (if (not (> below n))
      sum
      (recur (+ 1 n) (if (prime? n) (+ n sum) sum)))))

(assert (== 17 (answer 10)))

(println (answer 2000000))
