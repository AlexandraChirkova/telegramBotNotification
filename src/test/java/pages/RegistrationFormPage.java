package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    private final SelenideElement titleForm = $("div[class='practice-form-wrapper'] h5");
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName=$("#lastName");
    private final SelenideElement userEmail= $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userPhoneNumber = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();


    @Step("Открыть форму регистрации")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        titleForm.shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Ввести Имя")
    public RegistrationFormPage setFirstName(String name) {
        firstName.setValue(name);

        return this;
    }

    @Step("Ввести Фамилию")
    public RegistrationFormPage setLastName(String lastName) {
        this.lastName.setValue(lastName);

        return this;
    }

    @Step("Заполнить email")
    public RegistrationFormPage setEmail(String email) {
        userEmail.setValue(email);

        return this;
    }

    @Step("Заполнить пол")
    public RegistrationFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    @Step("Заполнить номер телефона")
    public RegistrationFormPage setUserNumber(String number) {
        userPhoneNumber.setValue(number);

        return this;
    }

    @Step("Заполнить дату рождения")
    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.scrollTo().click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Заполнить предмет")
    public RegistrationFormPage setSubject (String subject) {
        subjectsInput.scrollTo().setValue(subject).pressEnter();

        return this;
    }

    @Step("Заполнить хобби")
    public RegistrationFormPage setHobby(String hobby) {
        $(byText(hobby)).click();

        return this;
    }

    @Step("Загрузить картинку")
    public RegistrationFormPage setPicture(String path) {
        uploadPicture.uploadFromClasspath(path);

        return this;
    }

    @Step("Заполнить адрес")
    public RegistrationFormPage setAddress(String address) {
        currentAddress.setValue(address);

        return this;
    }

    @Step("Выбрать штат")
    public RegistrationFormPage setState(String state) {
        stateInput.click();
        $(byText(state)).click();

        return this;
    }

    @Step("Выбрать город")
    public RegistrationFormPage setCity(String city) {
        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    @Step("Нажать submit")
    public void submitForm() {
        submitButton.scrollTo().click();

    }

}
