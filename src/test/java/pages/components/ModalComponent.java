package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {

    private SelenideElement
            modalTitle = $(".modal-title"),
            modalForm = $(".modal-content"),
            resultsTable = $(".table-responsive");

    @Step("Проверить форму")
    public ModalComponent checkModalIsOpen() {
        modalForm.shouldBe(visible);
        modalTitle.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    @Step("Проверить поля формы")
    public ModalComponent checkResult(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    public ModalComponent checkModalNotOpen() {
        modalForm.shouldNot(appear);

        return this;
    }

}
