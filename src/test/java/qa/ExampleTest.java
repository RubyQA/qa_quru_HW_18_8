package qa;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.components.PracticeFormPage;
import static qa.testData.*;

import static com.codeborne.selenide.Selenide.open;


public class ExampleTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1700x1200";

    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        PracticeFormPage form = new PracticeFormPage();
        form.removeElements();

        // здесь используем значения переменных для заполнения формы
        form.setFirstName(firstName);
        form.setLastName(lastName);
        form.setUserEmail(userEmail);
        form.selectGender(gender);
        form.setDateOfBirth(dayOfBirth, month, yearOfBirth);
        form.setUserNumber(userNumber);
        form.setSubject(subject);
        form.selectHobby(hobby);
        form.uploadPicture(picturePath);
        form.setCurrentAddress(currentAddress);
        form.selectState(state);
        form.selectCity(city);
        form.submitForm();

        // здесь проверяем, что заполненные значения соответствуют значениям переменных
        form.checkTable(firstName + " " + lastName);
        form.checkTable(userEmail);
        form.checkTable(gender);
        form.checkTable(userNumber);
        form.checkTable(dayOfBirth + " " + month + "," + yearOfBirth);
        form.checkTable(subject);
        form.checkTable(hobby);
        form.checkTable(picturePath);
        form.checkTable(currentAddress);
        form.checkTable(state + " " + city);
    }

}
