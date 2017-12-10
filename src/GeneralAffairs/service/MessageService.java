package GeneralAffairs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import GeneralAffairs.domain.Message;

public interface MessageService {
	
	void createMessage(Message message);
	void removeMessage(int messageId);
	Message findMessageById(int messageId);
	void sendMessage(String memberId,int messageId);
	void removeMyMessage(String memberId,int messageId);
	List<Message> findAllMyMessages(String memberId, int groupId);
	List<Message> findAllSendMessages(String memberId);
	Message findSendedMessageById(int messageId);
}
