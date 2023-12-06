package com.xm.helpers;

public enum CalendarSliderItem {
        RECENT_NEXT("Recent & Next"),
        TODAY("Today"),
        TOMORROW("Tomorrow"),
        THIS_WEEK("This Week"),
        NEXT_WEEK("Next Week"),
        THIS_MONTH("This Month"),

        NEXT_MONTH("Next Month");


    private final String displayedName;

    CalendarSliderItem(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}
