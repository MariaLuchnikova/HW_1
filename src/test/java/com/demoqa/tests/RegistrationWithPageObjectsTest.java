package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTest extends BaseTest {
    @Test
    void fillingStudentRegistrationFormTest() {
        registrationPage.openPagePracticeForm()
                .setFirstNameInput("Maria")
                .setLastNameInput("Luchnikova")
                .setUserEmailInput("luchnikova@gmail.com")
                .setGenderInput("Female")
                .setUserNumber("8123456790")
                .setBirthDay("6", "June", "2012")
                .setSubjects("Co")
                .setHobbiesInput("Sports")
                .uploadPicture("AutoTesting.png")
                .setAddressInput("Istanbul")
                .setStateInput("Haryana")
                .setCityInput("Karnal")
                .performSubmit();

        registrationPage.verifyModalForm("Thanks for submitting the form")
                .verifyResults("Student Name", "Maria Luchnikova")
                .verifyResults("Student Email", "luchnikova@gmail.com")
                .verifyResults("Gender", "Female")
                .verifyResults("Mobile", "8123456790")
                .verifyResults("Date of Birth", "06 June,2012")
                .verifyResults("Subjects", "Computer Science")
                .verifyResults("Hobbies", "Sports")
                .verifyResults("Picture", "AutoTesting.png")
                .verifyResults("Address", "Istanbul")
                .verifyResults("State and City", "Haryana Karnal");
    }
}
