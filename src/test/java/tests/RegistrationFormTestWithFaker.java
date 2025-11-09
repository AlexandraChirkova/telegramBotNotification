package tests;

import data.DataGenerator;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.ModalComponent;


public class RegistrationFormTestWithFaker extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ModalComponent modalComponent = new ModalComponent();
    DataGenerator dataGenerator = new DataGenerator();

    @Test
    void applicationFormTest() {
       registrationFormPage.openPage()
               .setFirstName(dataGenerator.firstName)
               .setLastName(dataGenerator.lastName)
               .setEmail(dataGenerator.email)
               .setGender(dataGenerator.gender)
               .setUserNumber(dataGenerator.phone)
               .setDateOfBirth(dataGenerator.day, dataGenerator.month, dataGenerator.year)
               .setSubject(dataGenerator.subject)
               .setHobby(dataGenerator.hobby)
               .setPicture(dataGenerator.image)
               .setAddress(dataGenerator.address)
               .setState(dataGenerator.state)
               .setCity(dataGenerator.city)
               .submitForm();

       modalComponent.checkModalIsOpen()
               .checkResult("Student Name", dataGenerator.firstName + " " + dataGenerator.lastName)
               .checkResult("Student Email", dataGenerator.email)
               .checkResult("Gender", dataGenerator.gender)
               .checkResult("Mobile", dataGenerator.phone)
               .checkResult("Date of Birth", dataGenerator.day + " " +dataGenerator.month + "," + dataGenerator.year)
               .checkResult("Subjects", dataGenerator.subject)
               .checkResult("Hobbies", dataGenerator.hobby)
               .checkResult("Picture", "img1.jpeg")
               .checkResult("Address", dataGenerator.address)
               .checkResult("State and City", dataGenerator.state+ " " + dataGenerator.city);
    }

    @Test
    void applicationMinFormTest() {
        registrationFormPage.openPage()
                .setFirstName(dataGenerator.firstName)
                .setLastName(dataGenerator.lastName)
                .setEmail(dataGenerator.email)
                .setGender(dataGenerator.gender)
                .setUserNumber(dataGenerator.phone)
                .setDateOfBirth(dataGenerator.day, dataGenerator.month, dataGenerator.year)
                .submitForm();

        modalComponent.checkModalIsOpen()
                .checkResult("Student Name", dataGenerator.firstName + " " + dataGenerator.lastName)
                .checkResult("Student Email", dataGenerator.email)
                .checkResult("Gender", dataGenerator.gender)
                .checkResult("Mobile", dataGenerator.phone)
                .checkResult("Date of Birth", dataGenerator.day + " " +dataGenerator.month + "," + dataGenerator.year);
    }

    @Test
    void negativeFormTest() {
        registrationFormPage.openPage()
                .setFirstName(dataGenerator.firstName)
                .setLastName(dataGenerator.lastName)
                .setUserNumber(dataGenerator.phone)
                .setDateOfBirth(dataGenerator.day, dataGenerator.month, dataGenerator.year)
                .setSubject(dataGenerator.subject)
                .setHobby(dataGenerator.hobby)
                .setPicture(dataGenerator.image)
                .setAddress(dataGenerator.address)
                .submitForm();
        modalComponent.checkModalNotOpen();

    }
}
