package test;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment.Message;
import assignment.MessageQueue;

public class MessageQueueTest {

	@Test
	public void testPushMessage() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		Message message2 = new Message(senderId, recipientId, new String("another message"));
		q.pushMessage(message);
		q.pushMessage(message2);
		
		assertTrue(q.size() == 2);
		
	}

	@Test
	public void testPopMessage() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		q.pushMessage(message);
		Message popped = q.popMessage();
		
		assertSame(message, popped);
	}
	
	@Test
	public void testPopsLastMessage() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		Message message2 = new Message(senderId, recipientId, new String("another message"));
		Message message3 = new Message(senderId, recipientId, new String("a third message"));
		q.pushMessage(message);
		q.pushMessage(message2);
		q.pushMessage(message3);
		Message last = q.popMessage();
		
		assertSame(message, last);
		
	}

	@Test
	public void testIsEmptyOnEmptyQueue() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		Message message2 = new Message(senderId, recipientId, new String("another message"));
		q.pushMessage(message);
		q.pushMessage(message2);
		q.popMessage();
		q.popMessage();
		
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void testIsEmptyOnNonEmptyQueue() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		Message message2 = new Message(senderId, recipientId, new String("another message"));
		q.pushMessage(message);
		q.pushMessage(message2);
		
		
		assertFalse(q.isEmpty());
	}


	@Test
	public void testNextRecipient() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		int recipientId2 = 3;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		Message message2 = new Message(senderId, recipientId2, new String("another message"));
		Message message3 = new Message(senderId, recipientId, new String("a third message"));
		q.pushMessage(message);
		q.pushMessage(message2);
		q.pushMessage(message3);
		
		q.popMessage();
		
		assertTrue(q.nextRecipient() == recipientId2);
		
	}

	@Test
	public void testPopMessageIfForRecipientWithActualRecipient() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		int recipientId2 = 3;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		Message message2 = new Message(senderId, recipientId2, new String("another message"));
		Message message3 = new Message(senderId, recipientId2, new String("a third message"));
		q.pushMessage(message);
		q.pushMessage(message2);
		q.pushMessage(message3);

		
		assertSame(message, q.popMessageIfForRecipient(recipientId));
	
	}
	
	@Test
	public void testPopMessageIfForRecipientWithBadRecipient() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		int recipientId2 = 3;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		Message message2 = new Message(senderId, recipientId2, new String("another message"));
		Message message3 = new Message(senderId, recipientId2, new String("a third message"));
		q.pushMessage(message);
		q.pushMessage(message2);
		q.pushMessage(message3);
	
		
		assertNull(q.popMessageIfForRecipient(recipientId2));
		
	}
	
	@Test
	public void testSize() {
		MessageQueue q = new MessageQueue();
		int senderId = 1;
		int recipientId = 2;
		int recipientId2 = 3;
		Message message = new Message(senderId, recipientId, new String("contents of message"));
		Message message2 = new Message(senderId, recipientId2, new String("another message"));
		Message message3 = new Message(senderId, recipientId2, new String("a third message"));
		q.pushMessage(message);
		q.pushMessage(message2);
		q.pushMessage(message3);
	
		
		assertTrue(q.size() == 3);
		
	}

}
