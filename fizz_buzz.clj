(dorun
  (map
    (fn [n]
      (println
        (if (= 0 (rem n 15)) "fizzbuzz"
          (if (= 0 (rem n 3)) "fizz"
            (if (= 0 (rem n 5)) "buzz" n)))))
      (take 100 (iterate inc 1))))
