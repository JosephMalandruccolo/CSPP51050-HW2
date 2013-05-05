package assignment;

import java.util.HashMap;


/**
 * Responds to Query Messages
 * @author Joseph Malandruccolo
 *
 */
public class Responder {
	
	//=====================================================================
	//	=>	CLASS
	//=====================================================================
	public static int nextId = 1;
	private static HashMap<Integer, String> presidentialData;
	
	static {
		presidentialData = new HashMap<Integer, String>();
		presidentialData.put(1, "George Washington");
		presidentialData.put(2, "John Adams");
		presidentialData.put(3, "Thomas Jefferson");
		presidentialData.put(4, "James Madison");
		presidentialData.put(5, "James Monroe");
		presidentialData.put(6, "John Qunicy Adams");
		presidentialData.put(7, "Andrew Jackson");
		presidentialData.put(8, "Martin Van Buren");
		presidentialData.put(9, "William Henry Harrison");
		presidentialData.put(10, "John Tyler");
	}
	
	
	//=====================================================================
	//	=>	PROPERTIES
	//=====================================================================
	private int id;
	
	
	
	//=====================================================================
	//	=>	CONSTRUCTOR
	//=====================================================================
	public Responder() {
		this.id = Responder.nextId++;
	}
	
	
	//=====================================================================
	//	=>	PUBLIC API
	//=====================================================================
	public int getId() { return this.id; }
	
	
	//=====================================================================
	//	=>	QUEUE INTERACTION
	//=====================================================================
	public void readQueue(MessageQueue q) {
		Message msg = q.popMessageIfForRecipient(this.id);
		
		if (msg instanceof QueryMsg) {
			int request = (Integer) msg.getContents();
			ReplyMsg reply = new ReplyMsg(this.id, msg.getSenderId(), Responder.presidentialData.get(request), ((QueryMsg) msg).getQueryId());
			q.pushMessage(reply);
		}
		else {
			q.pushMessage(new ReplyMsg(this.id, msg.getSenderId(), new String("Invalid message type"), -1));
		}
	}
	
	
	

}
