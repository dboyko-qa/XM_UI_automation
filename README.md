# Sample UI test automation project for XM.com site

## <a name="ToolsUsed">Tools Used</a>

The autotests in this project are written in `Java` using `Selenide` framework.\
`Gradle` - is used as a build tool.  \
`JUnit5` - testing framework.\
`Allure Report` - for test results visualisation.\

## <a name="Decription">Description</a>
- [x] `Page Object` with steps using `Chain of Invocations`
- [x] `Factory method` design pattern used for changed adaptive site pages
- [x] Different configuration files for test running depending on build parameters
- [x] Extract config information into .properties files with `Owner` library
- [x] `Allure` reports
- [x] Flaky tests retries


## <a name="Tests">Implemented scenario</a>
1. Open Home page
2. Click the <Research and Education> link located at the top menu
3. Click <Economic Calendar> link in the opened menu
4. Select <Today> on Slider and check that the date is correct.
5. Select <Tomorrow> on Slider and check that the date is correct.
6. Select <Next Week> on Slider and check that the date is correct.
7. Click <Educational Videos> link under <Research and Education>
8. Click the Lesson 1.1 “Introduction to the Financial Markets.”
9. Educational video should play for a minimum of 5 seconds


## <a name="HowToRun">How To Run</a>
To run all tests with maximized browser run in terminal

```bash
gradle clean test -Dapp=chromemax
```


To run all tests with browser size 800x600 run in terminal

```bash
gradle clean test -Dapp=chrome800x600
```

To run all tests with browser size 1024x768 run in terminal

```bash
gradle clean test -Dapp=chrome1024x768
```


To view Allure report run the command after each run:
```bash
gradle AllureServe
```
