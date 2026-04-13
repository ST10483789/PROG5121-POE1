/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe;
import javax.swing.JOptionPane;

/**
 *
 * @author Student
 */
public class POE {

    public String username;
    public String password;
    public boolean isLoggedIn = false;

    public boolean checkUserName() {
        boolean hasUnderscore = username.contains("_");
        return hasUnderscore && username.length() <= 5;
    }

    //PASSWORD
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        String special = "!@#$%^&*()";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            if (Character.isDigit(ch)) {
                hasNumber = true;
            }
            if (special.contains("" + ch)) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8 && hasUpper && hasNumber && hasSpecial;
    }

    //CELLPHONE
    public boolean checkCellPhoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() <= 13;
    }

    //REGISTER USER
    public String registerUser() {

        username = JOptionPane.showInputDialog("Enter username:");
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure it contains an underscore and is no more than 5 characters.";
        }

        password = JOptionPane.showInputDialog("Enter password:");
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure it has at least 8 characters, a capital letter, a number and a special character.";
        }

        String phone = JOptionPane.showInputDialog("Enter cellphone number:");
        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number is incorrectly formatted or does not contain international code.";
        }

        return "User registered successfully.";
    }

    //LOGIN 
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + username + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    //MAIN
    public static void main(String[] args) {

        POE app = new POE();

        // Register user
        String message = app.registerUser();
        JOptionPane.showMessageDialog(null, message);

        if (message.equals("User registered successfully.")) {

            String loginUser = JOptionPane.showInputDialog("Enter username:");
            String loginPass = JOptionPane.showInputDialog("Enter password:");

            boolean status = app.loginUser(loginUser, loginPass);

            JOptionPane.showMessageDialog(null, app.returnLoginStatus(status));
        }
    }
}