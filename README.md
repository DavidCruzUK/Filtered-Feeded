# Filtered-Feeded (Twitter client)
Android client to filter worldwide tweets by a specific words. 

Writed in Kotlin 1.7.32

###Steps:
1. Create an account in: [Twitter developer](https://developer.twitter.com/)

2. Then change the following parameters in *build.gradle*:
```
            buildConfigField "String", "CONSUMER_KEY", "\"myj9bbBcrfNS4YQ0XFm4156qG\""
            buildConfigField "String", "CONSUMER_SECRET_KEY", "\"5CgA0l7gGDbsXVzvMAywT0BaZ7eYSwLIwvfS34gMmZVWZHIp6f\""
            buildConfigField "String", "ACCESS_TOKEN", "\"1000837614541398017-FwaUrGSwu9vSbT8yiEeAmnyiqJRnvG\""
            buildConfigField "String", "ACCESS_SECRET_TOKEN", "\"gytiF01wwYNRzHddkdkSntt3afOqR8NfIXh2yUJC0ZNkn\""
```
            

### Dependencies:
* twitter4j > 4.0.7
* Dagger2 > 2.27
* Room > 2.2.5
* Coroutines > 1.3.6
And more, Please check: [Dependencies](https://github.com/DavidCruzUK/Filtered-Feeded/blob/master/buildsystem/dependencies.gradle)

Developed by [David Cruz](https://www.davidcruz.co.uk/)
Contactme [Email](mailto:me@davidcruz.co.uk)
