package test;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment.Asker;
import assignment.MessageQueue;
import assignment.QueryMsg;
import assignment.ReplyMsg;

public class AskerTest {

	@Test
	public void testReadQueue() {
		Asker a = new Asker();
		ReplyMsg m = new ReplyMsg(0, a.getId(), new String("Hello"), -1);
		MessageQueue q = new MessageQueue();
		q.pushMessage(m);
		
		assertEquals("Hello", a.readQueue(q));
		
	}
	
	@Test
	public void testReadQueueBadMessage() {
		Asker a = new Asker();
		ReplyMsg m = new ReplyMsg(0, a.getId() + 1, new String("Hello"), -1);
		MessageQueue q = new MessageQueue();
		q.pushMessage(m);
		
		assertEquals("cannot read message", a.readQueue(q));
		
	}

	@Test
	public void testPutQueryOnQueue() {
		Asker a = new Asker();
		QueryMsg m = new QueryMsg(a.getId(), a.getId() + 1, 3);
		MessageQueue q = new MessageQueue();
		a.putQueryOnQueue(m, q);
		
		assertTrue(q.size() == 1);
		
	}

}
