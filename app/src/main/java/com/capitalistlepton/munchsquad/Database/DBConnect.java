package com.capitalistlepton.munchsquad.Database;

import java.sql.*;

public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://uw.c8dhszpddqtz.us-west-2.rds.amazonaws.com:3306/DatabaseProject", "lichtyj", "_etzreU2xjiX3wm");
            st = con.createStatement();

        } catch (Exception ex){
            System.out.println("Error: " + ex);
        }
    }

    public int createAccount(String username, String password, String Fname, String Lname) {
        int result = 0;
        if (usernameAvailable(username)) {
            try {
                st.execute("INSERT INTO Customer VALUES (\"" + username + "\", \"" + hash(password) + "\", \"" + Fname + "\", \"" + Lname + "\");");
                result = 1;
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            result = 2;
        }
        return result;
    }

    public boolean usernameAvailable(String username) {
        boolean result = true;

        try {
            String query = "SELECT Count(UserID) FROM Customer WHERE userID = \"" + username + "\"";
            rs = st.executeQuery(query);
            if (rs.next() && rs.getString("Count(UserID)").equals("1")) {
                result = false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public boolean login(String username, String password) {
        boolean result = false;
        try {
            String query = "SELECT PasswordHash FROM Customer WHERE userID = \"" + username + "\"";
            rs = st.executeQuery(query);
            if (rs.next() && hash(password).equals(rs.getString("PasswordHash"))) {
                result = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public void getNames() {
        try {

            String query = "Select * From Customer";
            rs = st.executeQuery(query);
            System.out.println("Retrieving names...\n");

            while(rs.next()) {
                String name = "\t" + rs.getString("FName") +  " " + rs.getString("LName");
                System.out.println(name);
            }

        } catch(Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("\nDone");
    }



    private String hash(String password) {
        return "" + password.hashCode();
    }

}

