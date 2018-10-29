# AndroidCalculator

Android APK : 

Maven based java project.

Pre-requisities to download : 

1. Java8 language binding 
2. Appium java-client 6.1.0 jar
3. Selenium server standalone 3.1.4 jar
4. Maven build tool
5. TestNG for tests
6. Appium Server 1.6.2
7. Extent 2.41.2 for Reporting

Assumptions : 

1. The device is Samsung android and OS version is 7.0.

To Modify test data : 

To change the Desired capabilties . modify it in the file under  .\Hometest\src\main\resources\testdata\android\samsung\capabilities 

Important step :  include appium java-client jar and Selenium server standalone as External jars for the project

Run the tests through mvn command  : 

mvn clean test -DtargetDevice=samsung -DtargetPlatform=android 

Screenshot folder for failed tests : ./Screenshots/"



