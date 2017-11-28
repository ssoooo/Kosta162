package storeTest;

import org.junit.Before;

import GeneralAffairs.store.MessageStore;
import GeneralAffairs.store.logic.MessageStoreLogic;

public class MessgeStoreLogicTest {

	private MessageStore messageStore;
	
	@Before
	public void setUp() {
		messageStore = new MessageStoreLogic();
	}

//	@Test
//	public void testRegistMessage() {
//		Message message = new Message();
//		message.setEventId(2);
//		message.setMemberId("민지짱");
//		message.setTitle("모금액");
//		message.setContent("짱짱");
//		assertNotNull(message);
//		assertEquals("모금액", message.getTitle());
//		messageStore.registMessage(message);
//	}

//	@Test
//	public void testDeleteMessage() {
//		Message message = new Message();
//		message.setMessageId(1);
//		messageStore.deleteMessage(message.getMessageId());
//	}

//	@Test
//	public void testRetrieveMessageById() {
//		Message message = messageStore.retrieveMessageById(2);
//		assertEquals(2, message.getEventId());
//	}
//
//	@Test
//	public void testRegistMessageWithMember() {
//		Message message = new Message();
//		message.setMemberId("민지짱");
//		message.setMessageId(3);
//		messageStore.registMessageWithMember(message.getMemberId(), message.getMessageId());
//	}
//
//	@Test
//	public void testDeleteMessageWithMember() {
//		Message message = new Message();
//		message.setMemberId("이호정");
//		message.setMessageId(2);
//		messageStore.deleteMessageWithMember(message.getMemberId(), message.getMessageId());
//	}
//
//	@Test
//	public void testRetrieveAllMyMessages() {
//		List<Message> list = messageStore.retrieveAllMyMessages("민지짱");
//		assertEquals(3, list.size());
//	
//	}

}
