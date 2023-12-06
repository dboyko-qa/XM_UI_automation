package com.xm.pages.frames;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoFrame {

    public VideoFrame swithToFrame(){
        Selenide.switchTo().frame($("iframe.sproutvideo-player"));
        makeFullyVisible();
        return this;
    }

    public VideoFrame switchToMain(){
        Selenide.switchTo().defaultContent();
        return this;
    }

    public VideoFrame makeFullyVisible(){
        $("body").scrollIntoView(true);
        return this;
    }

    public VideoFrame playVideo(){
        $(".player-big-play-button").shouldBe(visible);
        $(".player-big-play-button").click();
        return this;
    }

    public VideoFrame verifyVideoPlayedForFiveSeconds(){
        Integer fiveSec = 5;
        Selenide.sleep(fiveSec*1000 + 1000); //add some time buffer
        actions().moveToElement($(".player-video-holder")).perform();

        String videoTimeText = $(".player-progress-time").text();
        Integer secondsPassed = Integer.valueOf(videoTimeText.substring(3));
        assertTrue(secondsPassed >= fiveSec);

        return this;
    }
}
