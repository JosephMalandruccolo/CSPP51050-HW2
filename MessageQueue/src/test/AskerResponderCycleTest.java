package test;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment.Asker;
import assignment.Message;
import assignment.MessageQueue;
import assignment.QueryMsg;
import assignment.Responder;

public class AskerResponderCycleTest {

	@Test
	public void testCycle() {
		Asker a = new Asker();
		Responder r = new Responder();
		QueryMsg qry = new QueryMsg(a.getId(), r.getId(), 1);
		
		MessageQueue q = new MessageQueue();
		a.putQueryOnQueue(qry, q);
		r.readQueue(q);
		
		assertTrue("George Washington" == a.readQueue(q));
	}
	
	@Test
	public void testBadCycle() {
		Asker a = new Asker();
		Responder r = new Responder();
		QueryMsg qry = new QueryMsg(a.getId(), r.getId(), 1);
		QueryMsg bad = new QueryMsg(a.getId() + 1, r.getId(), 2);
		
		MessageQueue q = new MessageQueue();
		a.putQueryOnQueue(bad, q);
		a.putQueryOnQueue(qry, q);
		r.readQueue(q);
		
		assertFalse("George Washington" == a.readQueue(q));
	}
	
	
	@Test
	public void testResponseToEmptyQueue() {
		
		Responder r = new Responder();
		MessageQueue q = new MessageQueue();
		Message m = new Message(1, r.getId() + 1, new String("bad msg"));
		q.pushMessage(m);
		r.readQueue(q);
		
		//	one message will be in the queue, not two
		assertTrue(q.size() == 1);
	}

}
