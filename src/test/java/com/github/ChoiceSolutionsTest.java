package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChoiceSolutionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void choiceSolutions() {
        open("https://github.com/");
        $("[aria-label='Global']").$(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $(".enterprise-hero").shouldHave(text("Build like the best"));
    }
}
