/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poe;

import javax.swing.JOptionPane;
import java.util.Random;


/**
 *
 * @author Student
 */

public class POE {
    public String username;
    public String password;
    public String cellphone;

    public boolean isLoggedIn = false;

    // Username check
    public boolean checkUserName() {

        return username.contains("_") && username.length() >= 5;
    }

    // Password check
    public boolean checkPasswordComplexity(String password) {

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        String special = "!@#$%^&*";

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            }

            if (Character.isDigit(ch)) {
                hasNumber = true;
            }

            if (special.contains(String.valueOf(ch))) {
                hasSpecial = true;
            }
        }

        return password.length() >= 8 &&
                hasCapital &&
                hasNumber &&
                hasSpecial;
    }

    // Cell number check
    public boolean checkCellPhoneNumber(String number) {

        return number.startsWith("+27") &&
                number.length() <= 12;
    }

    // Register user
    public void registerUser() {

        username = JOptionPane.showInputDialog("Enter username:");

        while (!checkUserName()) {

            JOptionPane.showMessageDialog(null,
                    "Username incorrectly formatted.");

            username = JOptionPane.showInputDialog("Enter username again:");
        }

        password = JOptionPane.showInputDialog("Enter password:");

        while (!checkPasswordComplexity(password)) {

            JOptionPane.showMessageDialog(null,
                    "Password incorrectly formatted.");

            password = JOptionPane.showInputDialog("Enter password again:");
        }

        cellphone = JOptionPane.showInputDialog("Enter cellphone number:");

        while (!checkCellPhoneNumber(cellphone)) {

            JOptionPane.showMessageDialog(null,
                    "Cell phone number incorrectly formatted.");

            cellphone = JOptionPane.showInputDialog("Enter cellphone again:");
        }

        JOptionPane.showMessageDialog(null,
                "Registration successful.");

        isLoggedIn = true;
    }

    // Login
    public void login() {

        JOptionPane.showMessageDialog(null,
                "Welcome to QuickChat.");

        int messages = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "How many messages would you like to send?"));

        for (int i = 0; i < messages; i++) {

            Message msg = new Message();

            msg.messageNumber = i;

            msg.generateMessageID();

            JOptionPane.showMessageDialog(null,
                    "Message ID generated: " + msg.messageID);

            msg.recipient = JOptionPane.showInputDialog(
                    "Enter recipient number:");

            JOptionPane.showMessageDialog(null,
                    msg.checkRecipientCell());

            msg.messageText = JOptionPane.showInputDialog(
                    "Enter message:");

            JOptionPane.showMessageDialog(null,
                    msg.checkMessageLength());

            msg.createMessageHash();

            JOptionPane.showMessageDialog(null,
                    "Message Hash: " + msg.messageHash);

            JOptionPane.showMessageDialog(null,
                    msg.sentMessage());

            JOptionPane.showMessageDialog(null,
                    msg.printMessages());
        }

        JOptionPane.showMessageDialog(null,
                "Total messages sent: " + Message.totalMessages);
    }

    // Main method
    public static void main(String[] args) {

        POE app = new POE();

        app.registerUser();

        if (app.isLoggedIn) {

            app.login();
        }
    }
} 
