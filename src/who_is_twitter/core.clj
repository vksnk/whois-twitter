(ns who-is-twitter.core)

(require '(twitter [oauth :as oauth]))
(require '(twitter.api [restful :as twitter]))
(require '(clojure.data [json :as json]))


(def ^:dynamic *creds* (oauth/make-oauth-creds 
						"fKxjEt5kGvr1UOPJEHsuVQ"
						"joQHXFhCShNIllhmfd0RIg7GZ8mWagf6VnDnXL1cqw"
						"223136824-JfB6BQjqejeIeNRI3i6uHoCHFkKy8bz1dH3MR0qd"
						"9tOV64pxiI96SLCELl2nYqjv4PieLXPjnCmP1cMY")
)

(def ^:dynamic *read-from-json* true)
(def ^:dynamic *dump-json* true)

(defn show-base-info [user-info]
		(println "Full name:        " (user-info :name))
		(println "Screen name:      " (user-info :screen_name))
		(println "Self description: " (user-info :description))
		(println "Location :        " (user-info :location))
		(println "Web :             " (user-info :url))
)

(defn -main [& args]
	(println "Starting whois for twitter")
	(let 
		[user-info 
			(if-not *read-from-json*
				((twitter/show-user 
					:oauth-creds *creds* 
					:params {:screen-name "AdamJWynne"}
				) :body)
				(json/read-json (slurp "info.txt"))
			)
		]

		(show-base-info user-info)
		(when *dump-json*
			(spit "info.txt" (json/json-str user-info)))
	)
	(System/exit 0)
)