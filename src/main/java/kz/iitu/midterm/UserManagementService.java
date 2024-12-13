package kz.iitu.midterm;


import java.util.HashMap;
import java.util.Map;

/**
 * User Management Service
 *
 * This class provides functionality to register users, check if users
 * are registered, and authenticate users with valid credentials.
 */


public class UserManagementService {


    private final Map<String, String> userStore = new HashMap<>();

    /**
     * Registers a new user.
     *
     * @param username the unique username.
     * @param password the user's password.
     * @throws RuntimeException if the username is already registered.
     */
    public void registerUser(String username, String password) {
        if (userStore.containsKey(username)) {
            throw new RuntimeException("User already exists");
        }
        userStore.put(username, password);
    }

    /**
     * Checks if a user is registered.
     *
     * @param username the username to check.
     * @return true if the user is registered, false otherwise.
     */
    public boolean isUserRegistered(String username) {
        return userStore.containsKey(username);
    }

    /**
     * Logs in the user.
     *
     * @param username the username.
     * @param password the password.
     * @return true if the username and password match, false otherwise.
     */
    public boolean login(String username, String password) {
        return userStore.getOrDefault(username, "").equals(password);
    }



}
