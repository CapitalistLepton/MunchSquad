package com.capitalistlepton.munchsquad.Model;

public class Session {

    private static String username;
    private static String name;
    private static boolean isActive;

    /**
     * Returns the username of the current user.
     *
     * @return the username.
     */
    public static String getUsername() {
        return username;
    }

    /**
     * Returns the full name of the current user.
     *
     * @return the full name of the user.
     */
    public static String getName() {
        return name;
    }

    /**
     * Initiates the session.
     *
     * @param _username String username of the user.
     */
    public static void login(String _username) {
        username = _username;
        name = Login.getFullName(_username);
        isActive = true;
    }

    /**
     * Closes the session.
     */
    public static void logout() {
        username = "";
        isActive = false;
    }
}
