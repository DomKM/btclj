(ns btclj.models.schema
  (:require [clojure.java.jdbc :as sql]))

(def db-spec
  {:subprotocol "postgresql"
   :subname "//localhost/btclj"
   :user "admin"
   :password "admin"})

(defn initialized? []
  (throw (new Exception "TODO: initialize the database schema!")))
