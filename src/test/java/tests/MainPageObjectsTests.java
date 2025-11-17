package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.CheckComponent;
import pages.MainPage;
import testData.TestData;
import helpers.AttachForAllure;

public class MainPageObjectsTests extends TestBase {

    MainPage mainPage = new MainPage();
    CheckComponent checkComponent = new CheckComponent();
    TestData testData = new TestData();

    @AfterEach
    void addAttachments() {
        AttachForAllure.screenshotAs("Last screenshot");
        AttachForAllure.pageSource();
        AttachForAllure.browserConsoleLogs();
        AttachForAllure.addVideo();
    }

    @Test
    @DisplayName("Проверка отображения главной страницы сайта")
    @Tag("MainPageTests")
    void positiveMainPageIsVisible() {
        mainPage.openPage();
        checkComponent.checkMainPageIsOpen();
    }

    @Test
    @DisplayName("Проверка отображения карточек продуктов при выборе чек-бокса")
    @Tag("MainPageTests")
    void checkBoxMainPageAndProductCardIsVisible() {
        mainPage.openPage();
        mainPage.setСatalogFilter(testData.catalogFilterOption);
        checkComponent.checkProductCardWithSelection();
    }

    @Test
    @DisplayName("Проверка невозможности отправки формы с некорректным номером телефона")
    @Tag("MainPageTests")
    void negativeTestWithConnectionFormOnMainPage() {
        mainPage.openPage();
        mainPage.setPhone(testData.userNumber);
        mainPage.submitConnect();
        checkComponent.checkConnectionFormError();
    }

    @Test
    @DisplayName("Проверка невозможности отправки формы с некорректным email")
    @Tag("MainPageTests")
    void negativeTestWithSubscribeFormOnMainPage() {
        mainPage.openPage();
        mainPage.setEmail(testData.email);
        mainPage.setCheckBoxForMailing(testData.checkBoxMailing);
        mainPage.submitEmail();
        checkComponent.checkSubscribeFormError();
    }

    @Test
    @DisplayName("Проверка содержания обязательной информации в футере сайта")
    @Tag("MainPageTests")
    void positiveFutterTestWithReqInfo() {
        mainPage.openPage();
        mainPage.getRequiredInfoDropDown();
        checkComponent.checkReqInfoInFutter();
    }

}