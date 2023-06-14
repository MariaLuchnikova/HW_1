package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class TextBoxTest extends BaseTest {
    @Test
    void fillingTextBoxTest() {
        textBoxPage.openPageTextBox()
                .setFullName("Alex Egorov")
                .setEmailInput("alex@egorov.com")
                .setCurrentAddressInput("Some address 1")
                .setPermanentAddressInput("Another address 1")
                .performSubmit();

        textBoxPage.verifyResultsTextBox("name", "Alex Egorov")
                .verifyResultsTextBox("email", "alex@egorov.com")
                .verifyResultsTextBox("currentAddress", "Some address 1")
                .verifyResultsTextBox("permanentAddress", "Another address 1");
    }
}
