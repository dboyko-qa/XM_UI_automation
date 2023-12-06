package com.xm.pages.frames.EconomicCalendarFrame;

public class EconomicCalendarFrameFactory {
    public static EconomicCalendarFrame createEconomicCalendar(String browserSize)
    {
        if (browserSize == null || browserSize.isEmpty())
            return null;
        switch (browserSize) {
            case "800x600":
                return new EconomicCalendarFrameLowResolutionScreen();
            case "max":
            case "1024x768":
                return new EconomicCalendarFrameFullScreen();
            default:
                throw new IllegalArgumentException("Unknown browsersize " + browserSize);
        }
    }
}
