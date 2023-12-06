package com.xm.pages.mainmenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainMenuLowResolutionScreen extends MainMenu{
    public MainMenu openResearchAndEducation(){
        $(".toggleLeftNav").shouldBe(visible);
        $(".toggleLeftNav").click();

        $("[href='#researchMenu']").shouldBe(visible);
        $("[href='#researchMenu']").click();

        return this;
    }

    public MainMenu openEconomicCalendar(){
        openResearchAndEducation();
        $(".navbar-nav__list [href='https://www.xm.com/research/economicCalendar']").shouldBe(visible);
        $(".navbar-nav__list [href='https://www.xm.com/research/economicCalendar']").scrollIntoView(false);
        $(".navbar-nav__list [href='https://www.xm.com/research/economicCalendar']").click();

        return this;
    }

    public MainMenu openEducationalVideos(){
        openResearchAndEducation();
        $(".navbar-nav__list [href='https://www.xm.com/educational-videos']").shouldBe(visible);
        $(".navbar-nav__list [href='https://www.xm.com/educational-videos']").scrollIntoView(false);
        $(".navbar-nav__list [href='https://www.xm.com/educational-videos']").click();
        return this;
    }

}
