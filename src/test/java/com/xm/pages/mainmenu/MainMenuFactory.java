package com.xm.pages.mainmenu;

public final class MainMenuFactory {
        public static MainMenu createMainMenu(String browserSize)
        {
            if (browserSize == null || browserSize.isEmpty())
                return null;
            switch (browserSize) {
                case "800x600":
                    return new MainMenuLowResolutionScreen();
                case "max":
                case "1024x768":
                    return new MainMenuFullScreen();
                default:
                    throw new IllegalArgumentException("Unknown browsersize " + browserSize);
            }
        }
}
