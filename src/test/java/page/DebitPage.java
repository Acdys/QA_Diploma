package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DebitPage {

    /*для полей*/
    private final SelenideElement heading = $$("h3").find(text("Оплата по карте"));
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("[placeholder='08']");
    private final SelenideElement yearField = $("[placeholder='22']");
    private final SelenideElement holderField = $(byText("Владелец")).parent().$(".input__control");
    private final SelenideElement cvcField = $("[placeholder='999']");
    private final SelenideElement buttonContinue = $$("button").find(exactText("Продолжить"));

    /*для вывода сообщений*/
    private final SelenideElement successNOTIF = $(".notification_status_ok");
    private final SelenideElement errorNOTIF = $(".notification_status_error");
    private final SelenideElement requiredField = $(byText("Поле обязательно для заполнения"));
    private final SelenideElement invalidFormat = $(byText("Неверный формат"));
    private final SelenideElement invalidCharMessage = $(byText("Поле содержит недопустимые символы"));
    private final SelenideElement invalidCardExpirationDateMessage = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpiredMessage = $(byText("Истёк срок действия карты"));

    public DebitPage() {
        heading.shouldBe(visible);
    }

    public void fillInCardInfo(DataHelper.CardInfo cardInfo) {
        cardNumberField.sendKeys(cardInfo.getCardNumber());
        monthField.sendKeys(cardInfo.getMonth());
        yearField.sendKeys(cardInfo.getYear());
        holderField.sendKeys(cardInfo.getHolder());
        cvcField.sendKeys(cardInfo.getCvc());
        buttonContinue.click();
    }

    /*для проверки пустого поля*/
    public void textValidationForTheCardNumberField(String text) {
        cardNumberField.shouldHave(text(text)).shouldBe(visible);
    }

    public void textValidationForTheMonthField(String text) {
        monthField.shouldHave(text(text)).shouldBe(visible);
    }

    public void textValidationForTheYearField(String text) {
        yearField.shouldHave(text(text)).shouldBe(visible);
    }

    public void textValidationForTheHolderField(String text) {
        holderField.shouldHave(text(text)).shouldBe(visible);
    }

    public void textValidationForTheCVCField(String text) {
        cvcField.shouldHave(text(text)).shouldBe(visible);
    }

    /*методы для вывода сообщений*/
    public void setSuccessNotificationVisible() {
        successNOTIF.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void setErrorNotificationVisible() {
        errorNOTIF.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void setRequiredFieldVisible() {
        requiredField.shouldBe(visible, Duration.ofSeconds(12));
    }

    public void setInvalidFormatVisible() {
        invalidFormat.shouldBe(visible, Duration.ofSeconds(12));
    }

    public void setInvalidCharMessageVisible() {
        invalidCharMessage.shouldBe(visible, Duration.ofSeconds(12));
    }

    public void setInvalidCardExpirationDateMessageVisible() {
        invalidCardExpirationDateMessage.shouldBe(visible, Duration.ofSeconds(12));
    }

    public void setCardExpiredMessageVisible() {
        cardExpiredMessage.shouldBe(visible, Duration.ofSeconds(12));
    }
}