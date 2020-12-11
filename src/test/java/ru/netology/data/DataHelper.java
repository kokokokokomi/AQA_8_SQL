package ru.netology.data;

import lombok.Value;
import static com.codeborne.selenide.Selenide.open;

public class DataHelper {
    public static void openBrowser() { open("http://localhost:9999"); }

    @Value
    public static class AuthInfo {
        String passwordUser1 = "123qwerty";
        String passwordUser2 = "qwerty123";
    }

    public static String getPasswordUser1() {
        return new AuthInfo().passwordUser1;
    }

    public static String getPasswordUser2() {
        return new AuthInfo().passwordUser2;
    }
}

