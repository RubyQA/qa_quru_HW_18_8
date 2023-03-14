package qa.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {

    public SelenideElement firstNameInput = $("#firstName");
    public SelenideElement lastNameInput = $("#lastName");
    public SelenideElement userEmailInput = $("#userEmail");
    public SelenideElement genderRadioButton = $("#genterWrapper");
    public SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    public SelenideElement userNumberInput = $("#userNumber");
    public SelenideElement subjectsInput = $("#subjectsInput");
    public SelenideElement hobbiesCheckbox = $("#hobbiesWrapper");
    public SelenideElement uploadPictureInput = $("#uploadPicture");
    public SelenideElement currentAddressInput = $("#currentAddress");
    public SelenideElement stateDropdown = $("#state");
    public SelenideElement cityDropdown = $("#city");
    public SelenideElement submitButton = $("#submit");
    public SelenideElement tableResponsive = $(".table-responsive");


    public void setFirstName(String name) {
        firstNameInput.setValue(name);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setUserEmail(String email) {
        userEmailInput.setValue(email);
    }

    public void selectGender(String gender) {
        genderRadioButton.$(byText(gender)).click();
    }

    public void setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }

    public void setUserNumber(String number) {
        userNumberInput.setValue(number);
    }

    public void setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
    }

    public void selectHobby(String hobby) {
        hobbiesCheckbox.$(byText(hobby)).click();
    }

    public void uploadPicture(String filePath) {
        uploadPictureInput.uploadFromClasspath(filePath);
    }

    public void setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
    }

    public void selectState(String state) {
        stateDropdown.click();
        stateDropdown.$(byText(state)).click();
    }

    public void selectCity(String city) {
        cityDropdown.click();
        cityDropdown.$(byText(city)).click();
    }

    public void submitForm() {
        submitButton.click();
    }

    public void checkTable(String text) {
        tableResponsive.shouldHave(text(text));
    }


    public void removeElements() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
