(ns app.core-test
  (:require [clojure.test :refer :all]
            [app.core :refer :all]))

(def board
	[[0 1 0]
	 [1 0 1]
	 [1 1 1]])

(def alive-board
   [[0 1 0]
    [1 1 1]
    [1 1 1]])

(def under-populated-board
  [[1 0 1]
   [0 0 0]
   [1 1 1]])

(deftest can-get-cell-contents
	(is (= ( get-cell board 2 2) 1))
	(is (= ( get-cell board 2 0) 1))
	(is (= ( get-cell board 0 2) 0))
	(is (= ( get-cell board 1 1) 0)))

(deftest can-sum-neighbors
  (is (= (sum-neighbors board 1 1) 6))
  (is (= (sum-neighbors alive-board 1 1) 6))
  (is (= (sum-neighbors alive-board 0 0) 3))
)

(deftest can-get-neighbors
  (is (= (get-neighbors board 0 0) [0 0 0 0 1 0 1 0]))
  (is (= (get-neighbors board 2 2) [0 1 0 1 0 0 0 0]))
)

(deftest die-if-underpopulated
  (is (dies-if-under-populated under-populated-board 0 0))
)