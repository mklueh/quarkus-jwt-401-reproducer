#Generate the keys for the application according to https://quarkus.io/guides/security-jwt#generating-a-jwt
openssl genrsa -out src/main/resources/privateKey_tmp.pem 2048
openssl rsa -pubout -in src/main/resources/privateKey.pem -out src/main/resources/META-INF/resources/publicKey.pem
openssl pkcs8 -topk8 -nocrypt -inform pem -in src/main/resources/privateKey_tmp.pem -outform pem -out src/main/resources/privateKey.pem

mkdir -p src/test/resources/META-INF/resources

#Copy them into the test resources directory as well
cp src/main/resources/privateKey.pem src/test/resources/privateKey.pem
cp src/main/resources/META-INF/resources/publicKey.pem src/test/resources/META-INF/resources/publicKey.pem
