package assignment;

/**
 * Representation of a message from a sender to a receiver
 * @author Joseph Malandruccolo
 *
 */
public class Message {
	
	//=====================================================================
	//	=>	PROPERTIES
	//=====================================================================
	private int senderId;
	private int destinationId;
	private Object contents;
	
	
	//=====================================================================
	//	=>	CONSTRUCTOR
	//=====================================================================
	/**
	 * Create a new Message
	 * After instantiation, the message is read-only
	 * @param senderId - identifier of a sender
	 * @param destinationId - identifier of a receiver
	 * @param contents - message payload
	 */
	public Message(int senderId, int destinationId, Object contents) {
		this.senderId = senderId;
		this.destinationId = destinationId;
		this.contents = contents;
	}
	
	
	//=====================================================================
	//	=>	PUBLIC API
	//=====================================================================
	public int getSenderId() { return this.senderId; }
	public int getDestinationId() { return this.destinationId; }
	public Object getContents() { return this.contents; }
	
}
