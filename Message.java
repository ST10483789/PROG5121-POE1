/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author Student
 */
public class Message {

    public String messageID;
    public int messageNumber;
    public String recipient;
    public String messageText;
    public String messageHash;

    public static int totalMessages = 0;

    // Generate random 10 digit ID
    public void generateMessageID() {

        Random random = new Random();

        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);

        messageID = String.valueOf(number);
    }

    // Check message ID
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Check recipient number
    public String checkRecipientCell() {

        if (recipient.startsWith("+27") && recipient.length() <= 12) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Check message length
    public String checkMessageLength() {

        if (messageText.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extra = messageText.length() - 250;

            return "Message exceeds 250 characters by " + extra + ", please reduce the size.";
        }
    }

    // Create hash
    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String firstTwo = messageID.substring(0, 2);

        messageHash = firstTwo + ":" + messageNumber + ":" +
                firstWord.toUpperCase() + lastWord.toUpperCase();

        return messageHash;
    }

    // Send / store / delete
    public String sentMessage() {

        String option = JOptionPane.showInputDialog(
                "Choose option:\n" +
                "1. Send Message\n" +
                "2. Disregard Message\n" +
                "3. Store Message");

        if (option.equals("1")) {

            totalMessages++;

            return "Message successfully sent.";

        } else if (option.equals("2")) {

            return "Press 0 to delete the message.";

        } else if (option.equals("3")) {

            return "Message successfully stored.";

        } else {

            return "Invalid option.";
        }
    }

    // Print message
    public String printMessages() {

        return "Message ID: " + messageID +
                "\nMessage Hash: " + messageHash +
                "\nRecipient: " + recipient +
                "\nMessage: " + messageText;
    }

    // Return total
    public int returnTotalMessages() {

        return totalMessages;
    }
}