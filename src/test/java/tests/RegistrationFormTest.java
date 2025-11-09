
package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.ModalComponent;

@Tag("demoqa")
public class RegistrationFormTest extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ModalComponent modalComponent = new ModalComponent();

    @Test
    void applicationFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Alexandra")
                .setLastName("Chirkova")
                .setEmail("sashulik_angelzz@mail.ru")
                .setGender("Female")
                .setUserNumber("87051813123")
                .setDateOfBirth("12", "August", "1988")
                .setSubject("Math")
                .setHobby("Reading")
                .setPicture("images/img1.jpeg")
                .setAddress("Almaty")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Alexandra Chirkova")
                .checkResult("Student Email", "sashulik_angelzz@mail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8705181312")
                .checkResult("Date of Birth", "12 August,1988")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "img1.jpeg")
                .checkResult("Address", "Almaty")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void applicationMinFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Alexandra")
                .setLastName("Chirkova")
                .setEmail("sashulik_angelzz@mail.ru")
                .setGender("Female")
                .setUserNumber("87051813123")
                .setDateOfBirth("12", "August", "1988")
                .submitForm();

        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", "Alexandra Chirkova")
                .checkResult("Student Email", "sashulik_angelzz@mail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8705181312")
                .checkResult("Date of Birth", "12 August,1988");
    }

    @Test
    void negativeFormTest() {
        registrationFormPage.openPage()
                .setLastName("Chirkova")
                .setGender("Female")
                .setUserNumber("87051813123")
                .setDateOfBirth("12", "August", "1988")
                .setSubject("Math")
                .setHobby("Reading")
                .setPicture("images/img1.jpeg")
                .setAddress("Almaty")
                .submitForm();
        modalComponent.checkModalNotOpen();

    }
}
