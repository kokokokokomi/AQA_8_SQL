package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public VerificationPage() { codeField.shouldBe(Condition.visible); }

    public DashboardPage validVerify() throws SQLException {
        codeField.setValue(DBInteractionPage.getCode());
        verifyButton.click();
        return new DashboardPage();
    }

    public void invalidVerify(){
        codeField.setValue("111");
        verifyButton.click();
        errorNotification.shouldBe(Condition.visible);
    }
}
