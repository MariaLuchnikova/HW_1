package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends BaseTest{
    private final String textModalForm = "Thanks for submitting the form";

    @Test
    void fillingStudentRegistrationFormTest() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Luchnikova");
        $("#userEmail").setValue("luchnikova@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8123456790");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("July");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__month-container").$(byText("14")).click();

        $("#subjectsInput").setValue("Co").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("AutoTesting.png");
        $("#currentAddress").setValue("Istanbul");

        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text(textModalForm));
        $(".table-responsive").$(byText("Maria Luchnikova")).closest("tr").shouldHave(text("Student Name"));
        $(".table-responsive").$(byText("luchnikova@gmail.com")).closest("tr").shouldHave(text("Student Email"));
        $(".table-responsive").$(byText("Female")).closest("tr").shouldHave(text("Gender"));
        $(".table-responsive").$(byText("8123456790")).closest("tr").shouldHave(text("Mobile"));
        $(".table-responsive").$(byText("14 July,1980")).closest("tr").shouldHave(text("Date of Birth"));
        $(".table-responsive").$(byText("Computer Science")).closest("tr").shouldHave(text("Subjects"));
        $(".table-responsive").$(byText("Sports")).closest("tr").shouldHave(text("Hobbies"));
        $(".table-responsive").$(byText("AutoTesting.png")).closest("tr").shouldHave(text("Picture"));
        $(".table-responsive").$(byText("Istanbul")).closest("tr").shouldHave(text("Address"));
        $(".table-responsive").$(byText("Haryana Karnal")).closest("tr").shouldHave(text("State and City"));
    }
}
