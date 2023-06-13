package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateCityWrapper = $("#stateCity-wrapper"),
            stateInput = stateCityWrapper.$("#state"),
            cityInput = stateCityWrapper.$("#city"),
            buttonSubmit = $("#submit"),
            formVerification = $(".modal-header"),
            verifyTable = $(".table-responsive");

    public RegistrationPage verifyTextModalForm(String textHeader) {
        formVerification.shouldHave(text(textHeader));
        return this;
    }

    public RegistrationPage openPage() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstNameInput(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastNameInput(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmailInput(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGenderInput(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesInput(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String pictureName) {
        pictureUpload.uploadFromClasspath(pictureName);
        return this;
    }

    public RegistrationPage setAddressInput(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setStateInput(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCityInput(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public void performSubmit() {
        buttonSubmit.click();
    }

    public RegistrationPage verifyResult(String label, String values) {
        verifyTable.$(byText(label)).sibling(0).shouldHave(text(values));
        return this;
    }
}
