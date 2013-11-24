(defproject btclj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  ; :global-vars {*warn-on-reflection* true}
  :source-paths ["src/clj" "src/cljs" "target/generated/src/clj" "target/generated/src/cljs"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2069"]
                 [org.clojure/core.async "0.1.242.0-44b1e3-alpha"]
                 [com.taoensso/timbre "2.7.1"]
                 [compojure "1.1.6"]
                 [http-kit "2.1.13"]
                 [hiccup "1.0.4"]
                 [garden "1.1.4"]
                 [prismatic/dommy "0.1.1"]
                 [com.keminglabs/c2 "0.2.2"]
                 [environ "0.4.0"]]
                 [org.postgresql/postgresql "9.3-1100-jdbc41"]
                 [korma "0.3.0-RC6"]
                 [log4j "1.2.17" :exclusions [javax.mail/mail
                                              javax.jms/jms
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]
  :plugins [[com.keminglabs/cljx "0.3.1"]
            [lein-cljsbuild "1.0.0"]
            [lein-garden "0.1.0"]
            [lein-ring "0.8.8"]
            [lein-environ "0.4.0"]]
  :cljx {:builds [{:source-paths ["src/cljx"]
                   :output-path "target/generated/src/clj"
                   :rules :clj}
                  {:source-paths ["src/cljx"]
                   :output-path "target/generated/src/cljs"
                   :rules :cljs}]}
  :cljsbuild {:builds
              {:dev {:source-paths ["src/cljs" "target/generated/src/cljs"]
                     :compiler {:output-to "resources/public/js/main.js"
                                :output-dir "out"
                                :optimizations :none
                                :pretty-print true
                                :source-map true}}
               :prod {:source-paths ["src/cljs" "target/generated/src/cljs"]
                      :compiler {:output-to "resources/public/js/main.js"
                                 :optimizations :advanced
                                 :pretty-print false}}}}
  :hooks [cljx.hooks leiningen.cljsbuild]
  :ring {:handler btclj.handler/app
         :init btclj.handler/init
         :destroy btclj.handler/destroy}
  :profiles {:prod {:ring {:open-browser? false
                           :stacktraces? false
                           :auto-reload? false}}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]
                                  [spyscope "0.1.3"]]
                   :injections [(require 'spyscope.core)]
                   :plugins [[com.cemerick/austin "0.1.3"]
                             [lein-kibit "0.0.8"]]}})
