package assignment;

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
