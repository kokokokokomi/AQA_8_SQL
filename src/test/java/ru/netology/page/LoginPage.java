package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import java.sql.SQLException;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public VerificationPage validLoginSession() throws SQLException {
        loginField.setValue(DBInteractionPage.getLogin());
        passwordField.setValue(DataHelper.getPasswordUser1());
        loginButton.click();
        return new VerificationPage();
    }

    public VerificationPage validLoginSessionForDifferentUser() throws SQLException {
        loginField.setValue(DBInteractionPage.getLoginForDifferentUser());
        passwordField.setValue(DataHelper.getPasswordUser2());
        loginButton.click();
        return new VerificationPage();
    }

    public void invalidLoginSession () throws SQLException {
        loginField.setValue(DBInteractionPage.getLogin());
        passwordField.setValue(DataHelper.getPasswordUser2());
        loginButton.click();
        errorNotification.shouldBe(Condition.visible);
    }
}
