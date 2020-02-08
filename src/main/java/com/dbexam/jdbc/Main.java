package com.dbexam.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "select * from users";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));

                System.out.println(user);
            }

            worker.getConnection().close();
            System.out.println(worker.getConnection().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

