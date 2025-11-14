package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement
            catalogFilter = $(".catalog-section__filter"),
            phoneInput = $("#phone-number"),
            submitConnectButton = $("#MANAGER_FEEDBACK .form__btn.btn"),
            emailInput = $("#email"),
            checkBoxForMailing = $("#ibloks"),
            checkBoxForMailingList = $(".form__select-list"),
            submitMailButton = $("#SUBSCRIBE_MAILING .form__btn.btn"),
            requiredInfoDropDown = $(".info-text__title");


    public MainPage openPage() {
        open(Configuration.baseUrl);

        return this;
    }

    public MainPage setСatalogFilter(String value) {
        catalogFilter.scrollTo();
        executeJavaScript("arguments[0].click()", catalogFilter);
        catalogFilter.$(byText(value)).click();

        return this;
    }

    public MainPage setPhone(String value) {
        phoneInput.scrollTo();
        phoneInput.setValue(value);

        return this;
    }

    public MainPage submitConnect() {
        submitConnectButton.click();

        return this;
    }

    public MainPage setEmail(String value) {
        emailInput.scrollTo();
        emailInput.setValue(value);

        return this;
    }

    public MainPage submitEmail() {
        submitMailButton.click();

        return this;
    }

    public MainPage setCheckBoxForMailing(String value) {
        checkBoxForMailing.click();
        checkBoxForMailingList.$(byText(value)).click();

        return this;
    }

    public MainPage getRequiredInfoDropDown() {
        requiredInfoDropDown.scrollTo();
        executeJavaScript("arguments[0].click()", requiredInfoDropDown);
        requiredInfoDropDown.click();

        return this;
    }


}