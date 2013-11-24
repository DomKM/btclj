(ns btclj.models.db
  (:require [korma.core :refer :all]
            [korma.db :refer [defdb]]
            [btclj.models.schema :as schema]))

(defdb db schema/db-spec)
