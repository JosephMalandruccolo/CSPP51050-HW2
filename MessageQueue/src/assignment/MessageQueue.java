package assignment;

import java.util.LinkedList;

/**
 * Representation of a queue of Messages
 * @author Joseph Malandruccolo
 *
 */
public class MessageQueue {
	
	
	//=====================================================================
	//	=>	PROPERTIES
	//=====================================================================
	LinkedList<Message> messages;
	
	
	//=====================================================================
	//	=>	CONSTRUCTORS
	//=====================================================================
	public MessageQueue() {
		this.messages = new LinkedList<Message>();
	}
	
	
	//=====================================================================
	//	=>	PUBLIC API
	//=====================================================================
	/**
	 * Add a message to the queue
	 * @param msg - the message to add
	 */
	public void pushMessage(Message msg) { this.messages.addFirst(msg); }
	
	
	/**
	 * Grab the next available message from the queue
	 * @return - remove and return the next available message on the Queue
	 */
	public Message popMessage() { return this.messages.removeLast(); }
	
	
	/**
	 * Test whether the queue is empty
	 * @return - true if the queue is empty, false otherwise
	 */
	public boolean isEmpty() { return this.messages.size() <= 0; }
	
	
	/**
	 * @return - the number of messages in the queue
	 */
	public int size() { return this.messages.size(); }
	
	
	/**
	 * Check the recipient of the next message
	 * @return
	 */
	public int nextRecipient() { return this.messages.getLast().getDestinationId(); }
	
	
	/**
	 * Conditionally get the next message on the queue, if is intended for a specific recipient
	 * @param recipientId - the intended recipient
	 * @return - the message, if intended for the requested recipient, null otherwise
	 */
	public Message popMessageIfForRecipient(int recipientId) {
		if (this.nextRecipient() == recipientId) {
			return this.popMessage();
		}
		
		return null;
		
	}
	
	
}
