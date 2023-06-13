package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ExampleForJUnitTest {
    private final String codeSoftAssertions = """
                    @ExtendWith({SoftAssertsExtension.class})
                    class Tests {
                        @Test
                        void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");

                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
              }
            }
                    """;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void searchSoftAssertionsForJUnit() {
        open("selenide/selenide/");
        $("#repository-container-header").$("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        $x("//a[text()='SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("JUnit5")).closest("div").shouldHave(text(codeSoftAssertions));
    }
}
