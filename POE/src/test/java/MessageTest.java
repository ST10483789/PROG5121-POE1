/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.poe.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTest {

    Message msg = new Message();

    @Test
    public void testMessageLengthSuccess() {

        msg.messageText = "Hi Mike, can you join us for dinner tonight?";

        String result = msg.checkMessageLength();

        assertEquals("Message ready to send.", result);
    }

    @Test
    public void testRecipientSuccess() {

        msg.recipient = "+27718693002";

        String result = msg.checkRecipientCell();

        assertEquals("Cell phone number successfully captured.", result);
    }

    @Test
    public void testMessageHash() {

        msg.messageID = "0012345678";

        msg.messageNumber = 0;

        msg.messageText = "Hi tonight";

        String result = msg.createMessageHash();

        assertEquals("00:0:HITONIGHT", result);
    }

    @Test
    public void testMessageID() {

        msg.generateMessageID();

        assertTrue(msg.checkMessageID());
    }
}