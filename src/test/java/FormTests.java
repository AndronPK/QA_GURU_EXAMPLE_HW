import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Andrei");
        $("#lastName").setValue("Karpuk");
        $("#userEmail").setValue("AndreiKarpuk@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567892");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").val("Computer science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/QA.png");
        $("#currentAddress").setValue("Minsk, Central str.");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Noida")).click();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("Andrei Karpuk "));
        $(".table-responsive").shouldHave(text("AndreiKarpuk@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567892"));
        $(".table-responsive").shouldHave(text("13 February,1988"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("QA.png"));
        $(".table-responsive").shouldHave(text("Minsk, Central str"));
        $(".table-responsive").shouldHave(text("NCR Noida"));


    }
}
