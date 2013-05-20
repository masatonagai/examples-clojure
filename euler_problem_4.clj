;; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn num-to-digits [num]
  (loop [n num, d []]
    (if (< n 1) d
      (recur (int (/ n 10)) (conj d (mod n 10))))))

(assert (num-to-digits 1234) [1 2 3 4])

(defn palindromic? [num]
  (let [d (num-to-digits num)]
    (let [[up lo] (partition (/ (.size d) 2) d)]
      (= (reverse up) lo))))

(assert (palindromic? 9009))
(assert (not (palindromic? 9008)))

(defn palindromics-from-prd [digits]
  (let [less-than (int (Math/pow 10 digits))
        eq-more-than (int (Math/pow 10 (- digits 1)))]
    (for [x (range eq-more-than less-than)
          y (range eq-more-than less-than)
          :let [prd (* x y)]
          :when (palindromic? prd)]
      prd)))

(assert (= (reduce max (palindromics-from-prd 2)) 9009))

(println (reduce max (palindromics-from-prd 3)))


