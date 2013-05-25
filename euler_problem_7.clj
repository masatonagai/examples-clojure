;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;; What is the 10001st prime number?

(defn prime? [num]
  (if (< num 2)
    false
    (loop [n 2]
      (if (== n num)
        true
        (if (== 0 (mod num n))
          false
          (recur (inc n)))))))

(defn take-primes [num]
  (take num (filter prime? (iterate inc 2))))

(assert (= (take-primes 6) [2 3 5 7 11 13]))

(println (last (take-primes 10001)))
