package ru.netology.test;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DBInteractionPage;
import ru.netology.page.LoginPage;

import java.sql.SQLException;

public class LoginTest {

    @BeforeEach
    void openBrowser() { DataHelper.openBrowser(); }

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

}
