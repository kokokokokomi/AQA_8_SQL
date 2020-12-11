package ru.netology.page;

import lombok.val;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInteractionPage {

    public static String getLogin() throws SQLException {
        val loginSQL = "SELECT login FROM users;";
        String login = "";

        try (
                val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val loginStmt = connection.createStatement();) {
            try (val rs = loginStmt.executeQuery(loginSQL)) {
                if (rs.next()) { login = rs.getString(1); }
            }
        }
        return login;
    }

    public static String getLoginForDifferentUser() throws SQLException {
        val loginSQL = "SELECT login FROM users WHERE login !='petya';";
        String login = "";

        try (
                val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val loginStmt = connection.createStatement();) {
            val rs = (loginStmt.executeQuery(loginSQL));
            if(rs.next()) { login = rs.getString(1); }
        }
        return login;
    }

    public static String getCode() throws SQLException {
        val codeSQL = "SELECT code FROM auth_codes;";
        String code = "";

        try (
                val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
                val codeStmt = connection.createStatement();) {
            try (val rs = codeStmt.executeQuery(codeSQL)) {
                if (rs.next()) { code = rs.getString(1); }
            }
        }
        return code;
    }

    public static void deleteCodes() throws SQLException {
        val deleteSQL = "DELETE FROM auth_codes;";

        try (
                val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")) {
            val deleteStmt = connection.prepareStatement(deleteSQL);
            deleteStmt.execute();
        }
        catch (SQLException e) { e.printStackTrace(); }
    }

    public static void deleteTable() throws SQLException {
        val deleteUsers = "DELETE FROM users;";
        val deletionCards = "DELETE FROM cards;";

        try (
                val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")) {
            val deleteStmt2 = connection.prepareStatement(deletionCards);
            deleteStmt2.execute();
            val deleteStmt = connection.prepareStatement(deleteUsers);
            deleteStmt.execute();
        }
        catch (SQLException e) { e.printStackTrace(); }
    }
}
