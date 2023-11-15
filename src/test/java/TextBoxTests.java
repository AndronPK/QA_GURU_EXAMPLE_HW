import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Andrei");
        $("#userEmail").setValue("andrei@karpuk.com");
        $("#currentAddress").setValue("Sovietkaja");
        $("#permanentAddress").setValue("Sovietskaja 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Andrei"));
        $("#output #email").shouldHave(text("andrei@karpuk.com"));
        $("#output #currentAddress").shouldHave(text("Sovietkaja"));
        $("#output #permanentAddress").shouldHave(text("Sovietskaja 1"));
    }
}
