(ns who-is-twitter.core
	(:use
		[twitter.oauth]
		[twitter.callbacks]
		[twitter.callbacks.handlers]
		[twitter.api.restful]
	)
	(:import
		(twitter.callbacks.protocols SyncSingleCallback)
	)
)

(def ^:dynamic *creds* (make-oauth-creds 
						"fKxjEt5kGvr1UOPJEHsuVQ"
						"joQHXFhCShNIllhmfd0RIg7GZ8mWagf6VnDnXL1cqw"
						"223136824-JfB6BQjqejeIeNRI3i6uHoCHFkKy8bz1dH3MR0qd"
						"9tOV64pxiI96SLCELl2nYqjv4PieLXPjnCmP1cMY")
)

(defn -main [& args]
	(println "Starting whois for twitter")
	; (let [user-info 
	; 		((show-user 
	; 			:oauth-creds *creds* 
	; 			:params {:screen-name "AdamJWynne"}
	; 		) :body)
	; 	]
	; )
	(def user-info {:name "Volodymyr"})
		(println "Full name:        " (user-info :name))
		(println "Screen name:      " (user-info :screen_name))
		(println "Self description: " (user-info :description))
		(println "Location :        " (user-info :location))
		(println "Web :             " (user-info :url))
	; )
)