package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        // Замените эти значения на данные для подключения к вашей базе данных
        String url = "jdbc:postgresql://85.159.27.110:5432/test_enu";
        String user = "test_role";
        String password = "qwerty123@";

        // SQL запрос для получения количества записей в таблице
        String query = "SELECT COUNT(*) AS rowcount FROM account";

        // Попытка соединения с базой данных и выполнения запроса
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                int count = rs.getInt("rowcount");
                System.out.println("Количество записей в таблице 'account': " + count);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
