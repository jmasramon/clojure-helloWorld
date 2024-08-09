(ns get-started.tictactoe
  #_(:require ['clojure.core.matrix.transpose :as transpose]))

(comment
  (apply = '(:x :x :x))
  (defn all-equal? [line]
    (do
      (println (str "all-equal? for  " line))
      (apply = line)))

  (defn horizontal? [board]
    (do
      (println (pr-str "horizontal? for " board))
      (cond
        (some true? (map all-equal? board)) true
        :else false)))

  (defn vertical? [board]
    (let [literalized (for [x (first board)
                            y (second board)
                            z (nth board 2)]
            [x y z])
          transposed (take-nth 10 literalized)]
      (do
        (println (pr-str "vertical? for = " board))
        (cond
          (horizontal? transposed) true
          :else false))))

  (defn win? [board]
    (do
      (println (str "win? for " board))
      (cond
        (horizontal? board) true
        :else false)))

;; try it out
  (def board '((:x :y :x) (:x :x :x) (:y :y :x)))
  (first board)
  (all-equal? (first board))
  (horizontal? board)
  (println (every? true? (map all-equal? board)))
  (def newMatrix (for [x (first board)
                       y (second board)
                       z (nth board 2)]
                   [x y z]))
  (take-nth 10 newMatrix)
  (vertical? board)
  (win? board))
