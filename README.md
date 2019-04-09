# Selenoid-Sample
Manual for running the tests with Selenoid.

## Technologies
* JDK 1.8;
* Maven;
* Selenide;
* TestNG;
* Selenoid.

## Setup selenoid
1. Launch small script to simplify of setup:
```
curl -s https://aerokube.com/cm/bash | bash \
&& ./cm selenoid start --vnc
```
2. Run Selenoid and Selenoid UI type:
```
./cm selenoid start
./cm selenoid-ui start
```
3. For creation of configuration the browsers go to: ```/.aerokube/selenoid/browsers.json```
4. To open the UI panel Selenoid:
```
http://ip_address:8080/#/
```
![Selenoid_UI](https://i.ibb.co/F6863f7/809.png)
5. To make settings for tests: go to Capabilities page, select the language and browser to run the test.
6. Copy code to test.

##Project
To run this project:
1. Open Selenoid UI:
```
http://ip_address:8080/#/
```
2. To run the test, go to project directory and run the commands:
```
$ mvn clean test
