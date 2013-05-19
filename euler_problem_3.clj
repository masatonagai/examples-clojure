;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn factor? [num, of]
  (== 0 (mod of num)))

(defn prime? [num]
  (loop [n num, x 2]
    (if (>= x n) true
      (if (factor? x n) false
        (recur n (+ x 1))))))

(defn prime-factor? [num, of]
  (if (factor? num of) (prime? num)
    false))

(defn prime-factors [of]
  (loop [n of, x 2, prv []]
    (if (>= x (/ n x)) prv
      (recur n (+ x 1) (if (prime-factor? x n) (conj prv x) prv)))))

(assert (= (prime-factors 13195) [5 7 13 29]))

(println (last (prime-factors 600851475143)))
