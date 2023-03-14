package qa;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.components.PracticeFormPage;

import static com.codeborne.selenide.Selenide.open;


public class ExampleTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1700x1200";

    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        PracticeFormPage form = new PracticeFormPage();
        form.removeElements();

        // здесь используем значения переменных для заполнения формы
        form.setFirstName(qa.testData.firstName);
        form.setLastName(qa.testData.lastName);
        form.setUserEmail(qa.testData.userEmail);
        form.selectGender(qa.testData.gender);
        form.setDateOfBirth(qa.testData.dayOfBirth,qa.testData.month, qa.testData.yearOfBirth);
        form.setUserNumber(qa.testData.userNumber);
        form.setSubject(qa.testData.subject);
        form.selectHobby(qa.testData.hobby);
        form.uploadPicture(qa.testData.picturePath);
        form.setCurrentAddress(qa.testData.currentAddress);
        form.selectState(qa.testData.state);
        form.selectCity(qa.testData.city);
        form.submitForm();

        // здесь проверяем, что заполненные значения соответствуют значениям переменных
        form.checkTable(qa.testData.firstName + " " + qa.testData.lastName);
        form.checkTable(qa.testData.userEmail);
        form.checkTable(qa.testData.gender);
        form.checkTable(qa.testData.userNumber);
        form.checkTable(qa.testData.dayOfBirth+" "+ qa.testData.month+","+qa.testData.yearOfBirth);
        form.checkTable(qa.testData.subject);
        form.checkTable(qa.testData.hobby);
        form.checkTable(qa.testData.picturePath);
        form.checkTable(qa.testData.currentAddress);
        form.checkTable(qa.testData.state + " " + qa.testData.city);
    }

}
