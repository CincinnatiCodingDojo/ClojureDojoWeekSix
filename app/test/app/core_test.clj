(ns app.core-test
  (:require [clojure.test :refer :all]
            [app.core :refer :all]))

(def board
	[[0 1 0]
	 [1 0 1]
	 [1 1 1]])

(deftest can-get-cell-contents
	(is (= ( get-cell board 2 2) 1)))