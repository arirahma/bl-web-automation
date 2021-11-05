# bl-web-automation


# Running
cd bl-web-automation-main

make sure chromedriver is allowed on general security and privasi

sudo chmod +x gradlew

sudo chmod +x src/test/resources/chromedriver

./gradlew clean test

# trobleshoot

1. chrome drive is not executeable 

    sudo chmod +x src/test/resources/chromedriver
