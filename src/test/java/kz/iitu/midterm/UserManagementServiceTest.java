package kz.iitu.midterm;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * User Management Service - Tests
 *
 * This test class defines the requirements for a User Management System.
 *
 * Requirements:
 * - Users should be able to register with a username and password.
 * - A user cannot register with an already existing username.
 * - Users can log in with valid credentials.
 * - Login attempts with invalid credentials should fail.
 *
 * Instructions for Developers:
 * 1. Create a class named `UserManagementService` in `src/main/java/kz/iitu/midterm`.
 * 2. Add the following methods to the `UserManagementService` class:
 *    - `registerUser(String username, String password)`
 *    - `isUserRegistered(String username)`
 *    - `login(String username, String password)`
 *
 * Libraries to Use:
 * - Use a `Map<String, String>` as an in-memory store for user data.
 *
 * How to Run the Tests:
 * 1. Ensure this test class is in `src/test/java/kz/iitu/midterm/UserManagementServiceTest.java`.
 * 2. Run the test using Maven:
 *    ```
 *    mvn test -Dtest=UserManagementServiceTest
 *    ```
 * 3. Verify that all tests pass and console output shows a "BUILD SUCCESS".
 */



public class UserManagementServiceTest {


    @Test
    void testUserRegistration() {
        // Create an instance of the UserManagementService
        UserManagementService userService = new UserManagementService();

        // Test successful user registration
        userService.registerUser("john_doe", "password123");
        assertTrue(userService.isUserRegistered("john_doe"),
                "User should be successfully registered");
    }

    @Test
    void testDuplicateUserRegistration() {
        UserManagementService userService = new UserManagementService();

        // Register the same user twice
        userService.registerUser("john_doe", "password123");
        Exception exception = assertThrows(RuntimeException.class,
                () -> userService.registerUser("john_doe", "newPassword"),
                "Duplicate registration should throw a RuntimeException");

        // Verify exception message
        assertEquals("User already exists", exception.getMessage());
    }

    @Test
    void testLoginWithValidCredentials() {
        UserManagementService userService = new UserManagementService();

        // Register and login with correct credentials
        userService.registerUser("john_doe", "password123");
        assertTrue(userService.login("john_doe", "password123"),
                "User should log in successfully with valid credentials");
    }

    @Test
    void testLoginWithInvalidCredentials() {
        UserManagementService userService = new UserManagementService();

        // Register and attempt login with incorrect credentials
        userService.registerUser("john_doe", "password123");
        assertFalse(userService.login("john_doe", "wrongPassword"),
                "Login attempt with invalid credentials should fail");
    }

    @Test
    void testLoginWithNonexistentUser() {
        UserManagementService userService = new UserManagementService();

        // Attempt login for a user who hasn't been registered
        assertFalse(userService.login("nonexistent_user", "password123"),
                "Login attempt for a non-existent user should fail");
    }


}
