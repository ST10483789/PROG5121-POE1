/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.poe.POE;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class POETest {
    POE app = new POE();

    // -------- USERNAME TESTS --------

    @Test
    public void testUsernameCorrect() {
        app.username = "Vin_2";
      boolean result = app.checkUserName();
        assertTrue(result);
    }

    @Test
    public void testUsernameIncorrect() {
        app.username = "Vinny";
        boolean result = app.checkUserName();
        assertFalse(result);
    }

    // -------- PASSWORD TESTS --------

    @Test
    public void testPasswordCorrect() {
        boolean result = app.checkPasswordComplexity("Vinny@02");
        assertTrue(result);
    }

    @Test
    public void testPasswordIncorrect() {
        boolean result = app.checkPasswordComplexity("password");
        assertFalse(result);
    }

    // -------- CELLPHONE TESTS --------

    @Test
    public void testCellphoneCorrect() {
        boolean result = app.checkCellPhoneNumber("+27736562556");
        assertTrue(result);
    }

    @Test
    public void testCellphoneIncorrect() {
        boolean result = app.checkCellPhoneNumber("0736562556");
        assertFalse(result);
    }

    // -------- LOGIN TESTS --------

    @Test
    public void testLoginSuccess() {
        app.username = "Vin_2";
        app.password = "Vinny@02";

        boolean result = app.loginUser("Vin_2", "Vinny@02");
        assertTrue(result);
    }

    @Test
    public void testLoginFail() {
        app.username = "Vin_2";
        app.password = "Vinny@02";

        boolean result = app.loginUser("wrong", "wrong");
        assertFalse(result);
    }
}