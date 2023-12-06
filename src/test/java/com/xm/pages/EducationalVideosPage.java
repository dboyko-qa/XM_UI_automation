package com.xm.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.xm.helpers.Utils.removeStickyBars;

public class EducationalVideosPage {

    public EducationalVideosPage waitForVideoFrame(){
        $("iframe[src*='https://videos.sproutvideo.com']").shouldBe(visible);
        return this;
    }
    public EducationalVideosPage openIntroToMarkets(){
        removeStickyBars();
        $(byText("Intro to the Markets")).scrollIntoView(false);
        $(byText("Intro to the Markets")).click();
        return this;
    }

    public EducationalVideosPage openLesson11(){
        waitForVideoFrame();
        openIntroToMarkets();
        $(byText("Lesson 1.1")).click();
        return this;
    }
}
