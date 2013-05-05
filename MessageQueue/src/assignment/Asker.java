package assignment;


public class Asker {
	
		//=====================================================================
		//	=>	CLASS
		//=====================================================================
		public static int nextId = 1;
		
		
		
		//=====================================================================
		//	=>	PROPERTIES
		//=====================================================================
		private int id;
		
		
		
		//=====================================================================
		//	=>	CONSTRUCTOR
		//=====================================================================
		public Asker() {
			this.id = Asker.nextId++;
		}
		
		
		//=====================================================================
		//	=>	PUBLIC API
		//=====================================================================
		public int getId() { return this.id; }
		
		
		//=====================================================================
		//	=>	QUEUE INTERACTION
		//=====================================================================
		public String readQueue(MessageQueue q) {
			Message msg = q.popMessageIfForRecipient(this.id);
			
			if (msg instanceof ReplyMsg) {
				return msg.getContents().toString();
			}
			
			return "cannot read message";
			
		}
		
		
		
		public void putQueryOnQueue(QueryMsg m, MessageQueue q) {
			q.pushMessage(m);
		}
	
	
	
	

}
