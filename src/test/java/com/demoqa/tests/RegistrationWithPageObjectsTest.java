package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTest extends BaseTest {

    String gender = randomData.optionGenderUser(),
            subject = randomData.choiceSubject(),
            hobby = randomData.selectionHobby();

    @Test
    void fillingStudentRegistrationFormTest() {
        registrationPage.openPagePracticeForm()
                .setFirstNameInput(randomData.firstName)
                .setLastNameInput(randomData.lastName)
                .setUserEmailInput(randomData.email)
                .setGenderInput(gender)
                .setUserNumber(randomData.userNumber)
                .setBirthDay(randomData.dayBirth, randomData.monthBirth, randomData.yearBirth)
                .setSubjects(subject)
                .setHobbiesInput(hobby)
                .uploadPicture(randomData.picture)
                .setAddressInput(randomData.address)
                .setStateInput(randomData.valueState)
                .setCityInput(randomData.valueCity)
                .performSubmit();

        registrationPage.verifyModalForm("Thanks for submitting the form")
                .verifyResults("Student Name", randomData.firstName + " ".concat(randomData.lastName))
                .verifyResults("Student Email", randomData.email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", randomData.userNumber)
                .verifyResults("Date of Birth", randomData.fullDateBirth)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", randomData.picture)
                .verifyResults("Address", randomData.address)
                .verifyResults("State and City", randomData.valueState + " ".concat(randomData.valueCity));
    }
}
