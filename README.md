# Quarkus JWT 401 http status issue

This project is not functional and is used to describe Issue https://github.com/quarkusio/quarkus/issues/14450


#### Usage

Just execute the tests or generate a new ssh keypair running **generate-keys.sh**

##### Issue
Tests failing with http status 401 instead of the expected 200

##### Cause

Wrong key format?
- Commands used from the config

Public key not loaded?
- Nothing suspicious in the logs and application startup not failing