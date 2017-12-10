package GeneralAffairs.service.logic;
 
import java.sql.Date;
import java.util.Calendar;
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
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		message.setDate(today);
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
	public void sendMessage(String memberId, int messageId, String sendMemberId) {
		messageStore.registMessageWithMember(memberId, messageId, sendMemberId);
	}
 
	@Override
	public void removeMyMessage(String memberId, int messageId) {
		messageStore.deleteMessageWithMember(memberId, messageId);
	}
 
	@Override
	public List<Message> findAllMyMessages(String memberId, int groupId) {
		return messageStore.retrieveAllMyMessages(memberId, groupId);
	}
	
	@Override
	public List<Message> findAllSendMessages(String memberId) {
		return messageStore.retrieveAllSendMessages(memberId);
	}

	@Override
	public Message findSendedMessageById(int messageId) {
		return messageStore.retrieveSendedMessageById(messageId);
	}

	@Override
	public List<Message> findMySendMessage(String sendMemberId) {
		return messageStore.retrieveMySendMessage(sendMemberId);
	}
	
}
