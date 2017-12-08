package GeneralAffairs.store.mapper;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import GeneralAffairs.domain.Message;

public interface MessageMapper {
	void registMessage(Message message);

	void deleteMessage(int messageId);

	Message retrieveMessageById(int messageId);
	List<Message> retrieveAllMyMessages(@Param("memberId") String memberId, @Param("groupId") int groupId);
	void registMessageWithMember(@Param("memberId") String memberId, @Param("messageId") int messageId);
	void deleteMessageWithMember(@Param("memberId") String memberId, @Param("messageId") int messageId);
	List<Message> retrieveAllMyMessages(String memberId);
	List<Message> retrieveAllSendMessages(@Param("memberId") String memberId);

}
