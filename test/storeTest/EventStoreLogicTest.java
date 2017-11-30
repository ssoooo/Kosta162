package storeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import GeneralAffairs.domain.Event;
import GeneralAffairs.store.EventStore;
import GeneralAffairs.store.logic.EventStoreLogic;


public class EventStoreLogicTest {
	
	private EventStore eventStore;
	
	@Before
	public void setUp() {
		eventStore = new EventStoreLogic();
	}

	@Test
	public void testRegistEvent() {
		Event event = new Event();
		event.setGroupId(2);
		event.setMemberId("민지짱1");
		event.setEventName("신입생환영회1");
		event.setBudget(10000);
		event.setGroupSupport(10000);
		assertNotNull(event);
		assertEquals("민지짱1", event.getMemberId());
		eventStore.registEvent(event);
	}

//	@Test
//	public void testUpdateEvent() {
//		Event event = new Event();
//		event.setEventName("여름 MT");
//		event.setEventId(1);
//		eventStore.updateEvent(event);
//	}

//	@Test
//	public void testDeleteEvent() {
//		Event event = new Event();
//		event.setEventId(2);
//		eventStore.deleteEvent(event.getEventId());
//	}
	
//	@Test
//	public void testRetrieveEventById() {
//		Event event = eventStore.retrieveEventById(1);
//		assertEquals("보노보노", event.getMemberId());
//	}
//
//	@Test
//	public void testRetrieveAllEventsByGroupId() {
//		List<Event> list = eventStore.retrieveAllEventsByGroupId(2);
//		assertEquals(4, list.size());
//	}

//	@Test
//	public void testDeleteMemberFromEvent() {
//		Event event = new Event();
//		event.setEventId(4);
//		event.setMemberId("이호정");
//		eventStore.deleteMemberFromEvent(event.getMemberId(), event.getEventId());
//	}

//	@Test
//	public void testRegistMemberToEvent() {

//		Event event = new Event();
//		event.setEventId(3);
//		event.setMemberId("보노보노");
//		eventStore.registMemberToEvent(event.getMemberId(), event.getEventId());
		
//	}

//	@Test
//	public void testUpdatePayment() {
//		String payment = "완납";
//		int eventId = 5;
//		String memberId = "보노보노";
//		System.out.println(eventStore.updatePayment(eventId, memberId, payment));
//		assertTrue(eventStore.updatePayment(eventId, memberId, payment)>0);
//	}

//	@Test
//	public void testUpdateEventBalance() {
//		Event event = new Event();
//		event.setBalance(50000);
//		event.setEventId(3);
//		eventStore.updateEventBalance(event);
//	
//	}

}
