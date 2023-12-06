package com.xm.pages.frames.EconomicCalendarFrame;

import com.codeborne.selenide.Selenide;
import com.xm.helpers.CalendarSliderItem;
import org.openqa.selenium.Keys;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.xm.helpers.CalendarSliderItem.*;

public abstract class EconomicCalendarFrame {

    final private Map<String, Integer> sliderDays = Map.of(RECENT_NEXT.toString(), 0,
            TODAY.toString(), 1,
            TOMORROW.toString(), 2,
            THIS_WEEK.toString(), 3,
            NEXT_WEEK.toString(), 4,
            THIS_MONTH.toString(), 5,
            NEXT_MONTH.toString(), 6);
    final int[][] transitionMatrix = getSliderTransitionMatrix();

    private int[][] getSliderTransitionMatrix(){
        int[][] matrix = new int[sliderDays.size()][sliderDays.size()];
        matrix[sliderDays.get(RECENT_NEXT.toString())][sliderDays.get(TODAY.toString())] = 1;
        matrix[sliderDays.get(RECENT_NEXT.toString())][sliderDays.get(TOMORROW.toString())] = 2;
        matrix[sliderDays.get(TODAY.toString())][sliderDays.get(TOMORROW.toString())] = 1;
        matrix[sliderDays.get(TOMORROW.toString())][sliderDays.get(NEXT_WEEK.toString())] = 2;
        return matrix;
    }


    public EconomicCalendarFrame switchToFrame(){
        Selenide.switchTo().frame("iFrameResizer0");
        makeFullyVisible();
        return this;
    }

    public EconomicCalendarFrame makeFullyVisible(){
        $("body").scrollIntoView(true);
        return this;
    }

    public EconomicCalendarFrame switchToMain(){
        Selenide.switchTo().defaultContent();
        return this;
    }

    public EconomicCalendarFrame selectDayOnSlider(CalendarSliderItem day){
        $(".mat-slider-thumb").click();

        String currentSelectedDay = $(".tc-timeframe .ng-star-inserted").getText();
        for (int i = 1; i <= transitionMatrix[sliderDays.get(currentSelectedDay)][sliderDays.get(day.toString())]; i++){
            actions().sendKeys(Keys.ARROW_RIGHT).perform();
        }

        return this;
    }

    public EconomicCalendarFrame verifyDayOnSlider(CalendarSliderItem day, LocalDate localDate){
        $("tc-time-filter-container").shouldBe(visible, Duration.ofSeconds(20));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd").withLocale(Locale.ENGLISH);
        selectDayOnSlider(day);
        $(".tc-economic-calendar-item-header-left-title").shouldHave(text(localDate.format(formatter)));

        return this;
    }

    public EconomicCalendarFrame verifySlider(){
        LocalDate today = LocalDate.now();
        verifyDayOnSlider(TODAY, today);

        LocalDate tomorrow = today.plusDays(1);
        verifyDayOnSlider(TOMORROW, tomorrow);

        LocalDate nextWeek = today.plusDays(8).with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        verifyDayOnSlider(NEXT_WEEK, nextWeek);

        return this;
    }
}
