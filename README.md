# AndroidCalculator

Android APK : 

Pre-requisities to download : 

1. Java8 
2. Appium java-client 6.1.0 jar
3. Selenium server standalone 3.1.4 jar
4. Maven
5. TestNG for tests
6. Appium Server 1.6.2

Assumptions : 

1. The device is Samsung android and OS version is 7.0.

To change the Desired capabilties . modify it in the file under  .\Hometest\src\main\resources\testdata\android\samsung\capabilities 

Run the tests through mvn command  : 

mvn clean test -DtargetDevice=samsung -DtargetPlatform=android 

Screenshot folder for failed tests : ./Screenshots/"



