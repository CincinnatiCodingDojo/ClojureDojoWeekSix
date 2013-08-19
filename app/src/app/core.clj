(ns app.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn get-cell [board x y]
  (if (or (< x 0) (< y 0)) 0
    (if (or (>= x (count board) )
          (>= y (count (board x)))) 0 (nth (board x) y))))

(defn get-neighbors [board x y]
  [(get-cell board (dec x) (dec y))
   (get-cell board      x  (dec y))
   (get-cell board (inc x) (dec y))
   (get-cell board (dec x)      y )
   (get-cell board (inc x)      y )
   (get-cell board (dec x) (inc y))
   (get-cell board      x  (inc y))
   (get-cell board (inc x) (inc y))]
)

(defn sum-neighbors [board x y]
  (reduce + (get-neighbors board x y))
)

(defn dies-if-under-populated [board x y]
  (< (sum-neighbors board x y ) 2)
  )