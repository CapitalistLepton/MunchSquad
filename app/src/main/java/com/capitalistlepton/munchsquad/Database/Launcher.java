package com.capitalistlepton.munchsquad.Database;


public class Launcher {

    private DBConnect mConnect;

    public Launcher() {
        mConnect = new DBConnect();
    }

//    public static void main(String[] args) {
//        mConnect = new DBConnect();
//
//        System.out.println("Creating account");
//        createAccount("admin", "password", "Josh", "Lichty");
//
//        checkUsername("admin");
//        checkUsername("notAdmin");
//
//        login("lichtyj", "pass");
//        login("lichtyj", "password");
//
//        mConnect.getNames();
//
//    }

    public void createAccount(String username, String password, String Fname, String Lname) {
        switch (mConnect.createAccount(username, password, Fname, Lname)) {
            case 0:
                System.out.println("Account creation failed");
                break;
            case 1:
                System.out.println("Account created");
                break;
            case 2:
                System.out.println("Username already taken");
                break;
        }


        System.out.println("");
    }

    public void login(String username, String password) {
        if (mConnect.login(username, password)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }

    public void checkUsername(String username) {
        System.out.println("Checking username: " + username);

        if (mConnect.usernameAvailable(username)) {
            System.out.println("Available");
        } else {
            System.out.println("Taken");
        }
    }

}

