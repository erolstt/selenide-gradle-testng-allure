# Selenide Allure Example
This example demonstrates how to use Allure [TestNG](http://testng.org/) adapter with [Gradle](http://www.gradle.org/) build tool.

## Usage
To launch this example install Gradle and run the following command from the root directory:
```bash
$ gradle
```
You should see failed tests and generated Allure XML files in **build/allure-results** directory.

## Report
To generate report [allure-cli](https://github.com/allure-framework/allure-cli) can be used.

Report generation example:
```bash
# Run from the root directory
$ allure generate build
```
Open report example:
```bash
# Run from the root directory
$ allure report open
```
