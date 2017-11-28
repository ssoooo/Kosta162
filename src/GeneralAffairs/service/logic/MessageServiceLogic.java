package GeneralAffairs.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Message;
import GeneralAffairs.service.MessageService;
import GeneralAffairs.store.MessageStore;

@Service
public class MessageServiceLogic implements MessageService{
	
	@Autowired
	private MessageStore messageStore;

	@Override
	public void createMessage(Message message) {
		messageStore.registMessage(message);
	}

	@Override
	public void removeMessage(int messageId) {
		messageStore.deleteMessage(messageId);
	}

	@Override
	public Message findMessageById(int messageId) {
		return messageStore.retrieveMessageById(messageId);
	}

	@Override
	public void sendMessage(String memberId, int messageId) {
		messageStore.registMessageWithMember(memberId, messageId);
	}

	@Override
	public void removeMyMessage(String memberId, int messageId) {
		messageStore.deleteMessageWithMember(memberId, messageId);
	}

	@Override
	public List<Message> findAllMyMessages(String memberId) {
		return messageStore.retrieveAllMyMessages(memberId);
	}
	
}
