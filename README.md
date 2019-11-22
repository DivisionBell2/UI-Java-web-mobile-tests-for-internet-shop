ui-java-web-mobile-tests
========================================================
 
## description
Autotests in this framework are using for functional regression UI-testing
for mobile-web version of branded clothing internet shop.
Framework uses:
1. Maven as package collector
2. Selenium WebDriver for using Web
3. Chromedriver for testing Chrome
4. TestNG as testing framework
5. Yandex Allure for logging

## folder assignment
1. /helpers/ - for all parameters
2. /pages/ - for all pages methods
3. /testData/ - for enum classes of names
4. /resources/ - for base properties and chromedriver
5. /tests/ - for all packages of test groups

## How to use
This framework is only for skills demonstrations, but for work needs:
1. Fill env.properties
2. Put chromedriver to resources
3. For launch all tests start testng.xml from ide or point to it in CI
4. For launch one test start one test from ide
