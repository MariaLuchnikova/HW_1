package com.demoqa.pages;

import org.junit.jupiter.api.Test;

public class TextBoxTest extends BaseTest {
    @Test
    void fillingTextBoxTest() {
        registrationPage.openPageTextBox()
                .setUserName("Alex Egorov")
                .setUserEmailInput("alex@egorov.com")
                .setCurrentAddressInput("Some address 1")
                .setPermanentAddressInput("Another address 1")
                .performSubmit();

        registrationPage.verifyResultFillingTextBox("name", "Alex Egorov");
        registrationPage.verifyResultFillingTextBox("email", "alex@egorov.com");
        registrationPage.verifyResultFillingTextBox("currentAddress", "Some address 1");
        registrationPage.verifyResultFillingTextBox("permanentAddress", "Another address 1");
    }
}
