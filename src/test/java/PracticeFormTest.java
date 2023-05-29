import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    private final String textModalForm = "Thanks for submitting the form";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillingStudentRegistrationFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Luchnikova");
        $("#userEmail").setValue("luchnikova@gmail.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("8123456790");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__month-container").$(byText("14")).click();

        $("#subjectsInput").setValue("Co").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("AutoTesting.png");
        $("#currentAddress").setValue("Istanbul");

        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

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
        $("#closeLargeModal").click();
    }
}
