package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MainPage {
    private ElementsCollection catalogFilter = $$(".catalog-section__filter > div[data-section]");
    private SelenideElement
            phoneInput = $("#phone-number"),
            submitConnectButton = $("#MANAGER_FEEDBACK .form__btn.btn"),
            emailInput = $("#email"),
            checkBoxForMailing = $("#ibloks"),
            checkBoxForMailingList = $(".form__select-list"),
            submitMailButton = $("#SUBSCRIBE_MAILING .form__btn.btn"),
            requiredInfoDropDown = $(".info-text__title");


    @Step("Открыть главную страницу {baseUrl}")
    public MainPage openPage() {
        open(Configuration.baseUrl);
        return this;
    }


    @Step("Выбрать категорию '{value}'")
    public MainPage setСatalogFilter(String value) {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();",
                catalogFilter.find(text(value)));
        return this;
    }


    @Step("Ввести номер телефона '{value}'")
    public MainPage setPhone(String value) {
        phoneInput.scrollTo();
        phoneInput.setValue(value);
        return this;
    }


    @Step("Отправить форму связи")
    public MainPage submitConnect() {
        submitConnectButton.click();
        return this;
    }


    @Step("Ввести электронную почту '{value}'")
    public MainPage setEmail(String value) {
        emailInput.scrollTo();
        emailInput.setValue(value);
        return this;
    }


    @Step("Отправить форму подписки")
    public MainPage submitEmail() {
        submitMailButton.click();
        return this;
    }


    @Step("Выбрать раздел рассылки '{value}'")
    public MainPage setCheckBoxForMailing(String value) {
        checkBoxForMailing.click();
        checkBoxForMailingList.$(byText(value)).click();
        return this;
    }


    @Step("Получить обязательную информацию из футера")
    public MainPage getRequiredInfoDropDown() {
        requiredInfoDropDown.scrollTo();
        executeJavaScript("arguments[0].click()", requiredInfoDropDown);
        return this;
    }

}