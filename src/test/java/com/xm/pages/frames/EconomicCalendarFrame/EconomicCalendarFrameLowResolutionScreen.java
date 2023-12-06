package com.xm.pages.frames.EconomicCalendarFrame;

import static com.codeborne.selenide.Selenide.$;

public class EconomicCalendarFrameLowResolutionScreen extends EconomicCalendarFrame {
    @Override
    public EconomicCalendarFrame verifySlider() {
        $(".tc-calendar-button").click();
        super.verifySlider();

        return this;
    }
}
