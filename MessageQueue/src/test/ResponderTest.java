package test;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment.MessageQueue;
import assignment.QueryMsg;
import assignment.Responder;

public class ResponderTest {

	@Test
	public void testReadQueue() {
		Responder r = new Responder();
		QueryMsg m = new QueryMsg(-1, r.getId(), 3);
		MessageQueue q = new MessageQueue();
		
		q.pushMessage(m);
		
		r.readQueue(q);
		
		assertTrue(q.popMessage().getContents() == "Thomas Jefferson");
		
	}

}
