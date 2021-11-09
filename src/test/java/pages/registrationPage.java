package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static tests.testData.*;

public class registrationPage {

    private SelenideElement
            formTitle= $(".practice-form-wrapper"),
            firstNameInput= $("#firstName"),
            lastNameInput= $("#lastName"),
            emailInput= $("#userEmail"),
            phoneNumberInput= $("#userNumber"),
            subjectInputLabel= $("#subjectsInput"),
            hobbyCheckbox= $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput= $("#currentAddress"),
            stateDropdown= $("#state"),
            cityDropdown= $("#city"),
            stateWrapper= $("#stateCity-wrapper"),
            submitButton= $("#submit"),
            genderFemaleRadioButton= $("[name=gender][value=Female]")
    ;

    private final String FORM_TITLE="Student Registration Form";

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value){
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value){
        lastNameInput.val(value);
    }

    public void typeEmailAddress(String value){
        emailInput.val(value);
    }

    public void chooseFemaleGender(){
        genderFemaleRadioButton.parent().click();
    }

    public void typePhoneNumber(String value){
        phoneNumberInput.val(value);
    }

    public void chooseSubject(String value){
        subjectInputLabel.val(value).pressEnter();
    }

    public void chooseHobby(String value){
        hobbyCheckbox.$(byText(value)).click();
    }

    public void uploadPicture(String value){
        uploadPictureInput.uploadFromClasspath(value);
    }

    public void typeCurrentAddress(String value){
        addressInput.val(value);
    }

    public void chooseState(String value){
        stateDropdown.click();
        stateWrapper.$(byText(value)).click();
    }

    public void chooseCity(String value){
        cityDropdown.click();
        stateWrapper.$(byText(value)).click();
    }

    public void submitForm() {
        submitButton.click();
    }

    public void scrollPage() {
        submitButton.scrollIntoView(true);
    }

    public void checkResultsValue(String key, String value){
        $x("//td[text()='"+ key + "']").parent()
                .shouldHave(text(value));
    }
}
