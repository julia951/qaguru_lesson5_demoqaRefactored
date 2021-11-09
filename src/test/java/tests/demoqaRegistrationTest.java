package tests;

import org.junit.jupiter.api.Test;
import pages.registrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static tests.testData.*;


public class demoqaRegistrationTest extends testBase {

    registrationPage RegistrationPage = new registrationPage();

    @Test
    void positiveFillTest() {
        RegistrationPage.openPage();

        //filling the form
        RegistrationPage.typeFirstName(firstName);
        RegistrationPage.typeLastName(lastName);
        RegistrationPage.typeEmailAddress(email);
        RegistrationPage.chooseFemaleGender();
        RegistrationPage.typePhoneNumber(phoneNumber);
        RegistrationPage.calendar.setDate("21","March","1990");
        RegistrationPage.chooseSubject(subjectMath);
        RegistrationPage.chooseHobby(hobbyReading);
        RegistrationPage.uploadPicture(picture);
        RegistrationPage.typeCurrentAddress(address);
        RegistrationPage.scrollPage();
        RegistrationPage.chooseState(state);
        RegistrationPage.chooseCity(city);
        RegistrationPage.submitForm();

        //checking the form
        RegistrationPage.checkResultsValue("Student Name", firstName + " " + lastName);
        RegistrationPage.checkResultsValue("Student Email", email);
        RegistrationPage.checkResultsValue("Gender", gender);
        RegistrationPage.checkResultsValue("Mobile", phoneNumber);
        RegistrationPage.checkResultsValue("Date of Birth", "21 March,1990");
        RegistrationPage.checkResultsValue("Subjects", subjectMath);
        RegistrationPage.checkResultsValue("Hobbies", hobbyReading);
        RegistrationPage.checkResultsValue("Address", address);
        RegistrationPage.checkResultsValue("State and City", state + " " + city);
    }
}
