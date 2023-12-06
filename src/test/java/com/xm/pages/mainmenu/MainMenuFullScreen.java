package com.xm.pages.mainmenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainMenuFullScreen extends MainMenu{

    public MainMenu openResearchAndEducation(){
        $(".main_nav_research").shouldBe(visible);
        $(".main_nav_research").click();

        return this;
    }

    public MainMenu openEconomicCalendar(){
        openResearchAndEducation();
        $("[href='https://www.xm.com/research/economicCalendar']").scrollIntoView(false);
        $("[href='https://www.xm.com/research/economicCalendar']").click();

        return this;
    }

    public MainMenu openEducationalVideos(){
        openResearchAndEducation();
        $("[href='https://www.xm.com/educational-videos']").scrollIntoView(false);
        $("[href='https://www.xm.com/educational-videos']").click();
        return this;
    }
}
