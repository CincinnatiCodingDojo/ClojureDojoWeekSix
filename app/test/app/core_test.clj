(ns app.core-test
  (:require [clojure.test :refer :all]
            [app.core :refer :all]))

(deftest can-get-cell-contents
	(is (= ( get-cell 2 2) 1)))