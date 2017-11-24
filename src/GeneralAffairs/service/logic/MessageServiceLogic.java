package GeneralAffairs.service.logic;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Message;
import GeneralAffairs.service.MessageService;
import GeneralAffairs.store.MessageStore;

@Service
public class MessageServiceLogic implements MessageService{
	
	@Autowired
	private MessageStore store;

	@Override
	public void createMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMessage(int messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message findMessageById(int messageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(String memberId, int messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMyMessage(String memberId, int messageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Message> findAllMyMessages(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
