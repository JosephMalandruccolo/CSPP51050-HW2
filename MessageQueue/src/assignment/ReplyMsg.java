package assignment;

/**
 * A class that provides a response Object, as requested by a query message
 * @author Joseph Malandruccolo
 *
 */
public class ReplyMsg extends Message {
	
	//=====================================================================
	//	=>	PROPERTIES
	//=====================================================================
	private int respondingToQueryNumber;
	
	//=====================================================================
	//	=>	CONSTRUCTOR
	//=====================================================================
	public ReplyMsg(int senderId, int destinationId, Object response, int respondingToQueryNumber) {
		super(senderId, destinationId, response);
		this.respondingToQueryNumber = respondingToQueryNumber;
	}
	
	//=====================================================================
	//	=>	PUBLIC API
	//=====================================================================
	public int getRespondingToQueryNumber() { return this.respondingToQueryNumber; }
	
	
}
