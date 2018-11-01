package com.capitalistlepton.munchsquad.Model;

public class Session {

    private static String username;
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
     * Initiates the session.
     *
     * @param _username String username of the user.
     */
    public static void login(String _username) {
        username = _username;
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
