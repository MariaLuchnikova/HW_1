package com.demoqa.pages;

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

        registrationPage.verifyTextModalForm("Thanks for submitting the form")
                .verifyResultFillingForm("Student Name", "Maria Luchnikova")
                .verifyResultFillingForm("Student Email", "luchnikova@gmail.com")
                .verifyResultFillingForm("Gender", "Female")
                .verifyResultFillingForm("Mobile", "8123456790")
                .verifyResultFillingForm("Date of Birth", "06 June,2012")
                .verifyResultFillingForm("Subjects", "Computer Science")
                .verifyResultFillingForm("Hobbies", "Sports")
                .verifyResultFillingForm("Picture", "AutoTesting.png")
                .verifyResultFillingForm("Address", "Istanbul")
                .verifyResultFillingForm("State and City", "Haryana Karnal");
    }
}
