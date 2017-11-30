package GeneralAffairs.store;

import java.util.List;

import javax.servlet.http.HttpSession;

import GeneralAffairs.domain.Message;

public interface MessageStore {
	
	void registMessage(Message message);
	void deleteMessage(int messageId);
	Message retrieveMessageById(int messageId);
	void registMessageWithMember(String memberId,int messageId);
	void deleteMessageWithMember(String memberId,int messageId);
	List<Message> retrieveAllMyMessages(String memberId);
}
