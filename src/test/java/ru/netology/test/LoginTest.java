package ru.netology.test;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DBInteractionPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @BeforeEach
    void openBrowser() { open("http://localhost:9999"); }

    @AfterAll
    static void cleanTables() throws SQLException { DBInteractionPage.deleteTable(); }

    @Test
    void shouldLoginWithDataFromDB() throws SQLException {
        LoginPage login = new LoginPage();
        val verificationPage = login.validLoginSession();
        verificationPage.validVerify();
        DBInteractionPage.deleteCodes();
    }

    @Test
    void shouldLoginDifferentUserWithDataFromDB() throws SQLException {
        LoginPage login = new LoginPage();
        val verificationPage = login.validLoginSessionForDifferentUser();
        verificationPage.validVerify();
        DBInteractionPage.deleteCodes();
    }

    @Test
    void shouldShowErrorNotificationOnLoginPage() throws SQLException {
        LoginPage login = new LoginPage();
        login.invalidLoginSession();
        DBInteractionPage.deleteCodes();
    }

    @Test
    void shouldShowErrorNotificationOnVerificationPage() throws SQLException {
        LoginPage login = new LoginPage();
        val verificationPage = login.validLoginSession();
        verificationPage.invalidVerify();
        DBInteractionPage.deleteCodes();
    }

    @Test
    void shouldShowErrorNotificationThreeTimesWrongPassword() throws SQLException {
        LoginPage login = new LoginPage();
        login.invalidThreePassword();
        DBInteractionPage.deleteCodes();
    }
}
