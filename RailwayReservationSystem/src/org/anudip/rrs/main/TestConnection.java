package org.anudip.rrs.main;

import java.sql.Connection;
import org.anudip.rrs.util.DBConnection;

public class TestConnection {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("JDBC Connection Successful!");
        }
    }
}