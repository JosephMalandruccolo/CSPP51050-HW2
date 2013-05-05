package assignment;

/**
 * A message that asks a destination for an Object based on a unique identifier
 * @author Joseph Malandruccolo
 *
 */
public class QueryMsg extends Message {
	
	//=====================================================================
	//	=>	CLASS PROPERTIES
	//=====================================================================
	public static int nextQueryId = 1;
	
	
	//=====================================================================
	//	=>	PROPERTIES
	//=====================================================================
	private int queryId;
	
	
	
	//=====================================================================
	//	=>	CONSTRUCTOR
	//=====================================================================
	public QueryMsg(int senderId, int destinationId, int uniqueIdentifier) {
		super(senderId, destinationId, uniqueIdentifier);
		this.queryId = QueryMsg.nextQueryId++;
	}
	
	
	//=====================================================================
	//	=>	PUBLIC API
	//=====================================================================
	public int getQueryId() { return this.queryId; }
	

}
