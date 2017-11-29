package GeneralAffairs.store.logic;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import GeneralAffairs.domain.Message;
import GeneralAffairs.store.MessageStore;
import GeneralAffairs.store.factory.SessionFactory;
import GeneralAffairs.store.mapper.MessageMapper;

@Repository
public class MessageStoreLogic implements MessageStore{

	@Override
	public void registMessage(Message message) {

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		MessageMapper mapper =session.getMapper(MessageMapper.class);	
		mapper.registMessage(message);
		session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteMessage(int messageId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		MessageMapper mapper =session.getMapper(MessageMapper.class);	
		mapper.deleteMessage(messageId);
		session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public Message retrieveMessageById(int messageId) {
		Message message =null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		MessageMapper mapper =session.getMapper(MessageMapper.class);	
		message=mapper.retrieveMessageById(messageId);
		}finally {
			session.close();
		}
		
		return message;
	}

	@Override
	public void registMessageWithMember(String memberId, int messageId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		MessageMapper mapper =session.getMapper(MessageMapper.class);	
		mapper.registMessageWithMember(memberId, messageId);
		session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteMessageWithMember(String memberId, int messageId) {
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		MessageMapper mapper =session.getMapper(MessageMapper.class);	
		mapper.deleteMessageWithMember(memberId, messageId);
		session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Message> retrieveAllMyMessages(String memberId) {
		List<Message> messages=null;
		SqlSession sqlSession = SessionFactory.getInstance().getSession();
		try {
		MessageMapper mapper =sqlSession.getMapper(MessageMapper.class);	
		messages=mapper.retrieveAllMyMessages(memberId);
		}finally {
			sqlSession.close();
		}
		
		return messages;
	}

	
}
