package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FillingDataComponent {

    public void verifyTextModalForm(String textHeader) {
        $(".modal-header").shouldHave(text(textHeader));
    }

    public void verifyResultsFillingForm(String label, String values) {
        $(".table-responsive").$(byText(label)).sibling(0).shouldHave(text(values));
    }

}
