package com.martinsking.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DbUtils {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){

        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS Records");
            statement.executeUpdate(
                    "CREATE TABLE Records(" +
                            "ID INTEGER Primary key, " +
                            "NAME varchar(30) not null)"
            );

            statement.executeUpdate("INSERT INTO Records (NAME) VALUES ('Queen Greatest Hits 1')"
            );
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

}
