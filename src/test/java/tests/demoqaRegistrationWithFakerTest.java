package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.registrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testData.*;

public class demoqaRegistrationWithFakerTest extends testBase{
    Faker faker = new Faker();

    String firstName=faker.gameOfThrones().character(),
            lastName=faker.gameOfThrones().character(),
            email=faker.internet().emailAddress(),
            address=faker.gameOfThrones().quote();

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);

        $("#userEmail").val(email);
        $("[name=gender][value=" + gender + "]").parent().click();

        $("#userNumber").val(phoneNumber);
        $("#dateOfBirthInput").click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month").click();

        $("#subjectsInput").val(subjectMath).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbyReading)).click();
        $("#uploadPicture").uploadFromClasspath("./img/1.png");
        $("#currentAddress").val(address);

        $("#submit").scrollIntoView(true);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        $(".modal-title").shouldHave(text(successModalWindow));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(email),text("21 March,1990"),text(address),text(gender),text(phoneNumber),
                text(hobbyReading),text(subjectMath),text(state + " " + city));
    }
}
