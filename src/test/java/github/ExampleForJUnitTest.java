package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ExampleForJUnitTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void afterAll() {
        closeWindow();
    }

    @Test
    void searchSoftAssertionsForJUnit() {
        open("selenide/selenide/");
        $("#repository-container-header").$("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        $x("//a[text()='SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("JUnit5"));
        $("#wiki-body").shouldHave(text("SoftAssertsExtension"));
    }
}
