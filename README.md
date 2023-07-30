# UAMP Android Automation

This repository was created to showcase the author's test automation skills.

This repo consists of a Java framework using Appium.

## Requirements:

- Java(JDK 11 or Higher)
- Appium version 1.22.0 (Any version below version 2.0.0 should be good.)
- GK-VPN (Sorry non gk peeps) 
- Android Emulator

## System under test

The SUT is _UAMP_.

_Universal Android Music Player_ (UAMP) is an example music player app for Android written in Kotlin. It supports many features including background playback, audio focus handling, multiple platforms (like Wear, TV and Auto) and assistant integration.

The app can be found here: http://artifactory.armorica.gk/artifactory/repo/com/example/android/uamp-debug/1.3.0-SNAPSHOT/uamp-debug-1.3.0-20180817.101136-1.apk
There is also a copy off the app in the base repo.
## Java Automation Framework

### Prerequisites
This automation framework only uses an Android emulator to run tests against.
- The first prerequisite is to provide the framework with your emulator details, this can be done by inputting them into the _deviceCapabilities.json_ file. This can also be found in the base of the repo.

- The second prerequisite is to run appium server. Generally this can be done by running command:`appium` in either macOS or Windows. The default port will as a result be 4723, if you are running the server on a different port update the _deviceCapabilities.json_ to your custom port.

- The app does only seem to connect to GK-Servers, so your network has to be connected to that of GK's. The app will still work it will not be able to find any music.
### Running

The java framework uses gradle as the main building tool.

On a Windows operating system, navigate to the root of the project in your file system via command line.
Then run :
`gradlew clean test`

On Mac machine you can run:
`./gradlew clean test`

### Reporting

A test report can be generated of the last completed test run. Running command:
`gradlew allureReport` or `./gradlew allureReport` respectively, will create the report.

The report can be opened on browser as a server using: `gradlew allureServe` or `./gradlew allureReport` respectively.

The report will be saved into a generated folder named _test-output_. The
index.html is the main entry-point to the report which is best viewed in Chrome browser.