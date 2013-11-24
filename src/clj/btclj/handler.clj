(ns btclj.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [taoensso.timbre :as timbre]
            [environ.core :refer [env]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(defn init
  "init will be called once when
   app is deployed as a servlet on
   an app server such as Tomcat
   put any initialization code here"
  []
  (timbre/info "btclj started successfully"))

(defn destroy
  "destroy will be called when your application
   shuts down, put any clean up code here"
  []
  (timbre/info "btclj is shutting down..."))

(def app
  (handler/site app-routes))
