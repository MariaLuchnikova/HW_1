package com.demoqa.pages;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTest extends BaseTest {
    @Test
    void fillingStudentRegistrationFormTest() {
        registrationPage.openPage()
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
                .verifyResult("Student Name", "Maria Luchnikova")
                .verifyResult("Student Email", "luchnikova@gmail.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "8123456790")
                .verifyResult("Date of Birth", "06 June,2012")
                .verifyResult("Subjects", "Computer Science")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "AutoTesting.png")
                .verifyResult("Address", "Istanbul")
                .verifyResult("State and City", "Haryana Karnal");
    }
}
