package com.xm.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.xm.config.App;
import com.xm.config.Attach;
import com.xm.pages.EducationalVideosPage;
import com.xm.pages.frames.EconomicCalendarFrame.EconomicCalendarFrame;
import com.xm.pages.frames.EconomicCalendarFrame.EconomicCalendarFrameFactory;
import com.xm.pages.frames.VideoFrame;
import com.xm.pages.mainmenu.MainMenu;
import com.xm.pages.mainmenu.MainMenuFactory;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.xm.helpers.Utils.acceptCookies;
import static com.xm.helpers.Utils.removeStickyBars;
import static io.qameta.allure.Allure.step;


public class EconomicCalendarTests {
    static App app = ConfigFactory.create(App.class, System.getProperties());
    MainMenu mainMenu = MainMenuFactory.createMainMenu(app.browserSize());
    EconomicCalendarFrame economicCalendarFrame = EconomicCalendarFrameFactory.createEconomicCalendar(app.browserSize());
    EducationalVideosPage educationalVideosPage = new EducationalVideosPage();
    VideoFrame videoFrame = new VideoFrame();

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = app.url();
        Configuration.browser = app.browser();
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 20000;

        if (app.browserSize().equals("max"))
            maximizeBrowser();
        else
            Configuration.browserSize = app.browserSize();
    }

    private static void maximizeBrowser() {
        open("about:blank");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @BeforeEach
    void addListener() {
        acceptCookies();
        step("1. Open Home page (make any check here if needed).", () -> open(""));
        removeStickyBars();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        Selenide.closeWebDriver();
    }


    @DisplayName("Run test use case for xm.com site")
    @Test
    public void useCaseTest() {

        step("2. Click the <Research and Education> link located at the top menu (make any check here if needed)." +
                "3. Click <Economic Calendar> link in the opened menu (make any check here if needed).<br>",
                () -> mainMenu.openEconomicCalendar());

        step("4. Select <Today> on Slider and check that the date is correct." +
                "5. Select <Tomorrow> on Slider and check that the date is correct." +
                "6. Select <Next Week> on Slider and check that the date is correct.",
                () -> economicCalendarFrame.switchToFrame()
                .verifySlider()
                .switchToMain());

        step("7. Click <Educational Videos> link under <Research and Education>",
                () -> mainMenu.openEducationalVideos());

        step("8. Click the Lesson 1.1 “Introduction to the Financial Markets.”",
                () -> educationalVideosPage.openLesson11());
        step ("9. Educational video should play for a minimum of 5 seconds",
                () -> videoFrame.swithToFrame()
                .makeFullyVisible()
                .playVideo()
                .verifyVideoPlayedForFiveSeconds()
                .switchToMain());

    }
}
