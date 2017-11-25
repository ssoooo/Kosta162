package GeneralAffairs.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import GeneralAffairs.domain.Comment;
import GeneralAffairs.store.CommentStore;
import GeneralAffairs.store.factory.SessionFactory;
import GeneralAffairs.store.mapper.CommentMapper;

@Repository
public class CommentStoreLogic implements CommentStore{

	@Override
	public void registComment(Comment comment) {

		SqlSession session = SessionFactory.getInstance().getSession();
		
		try {
			System.out.println("123");
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		mapper.registComment(comment);
		session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void updateComment(Comment comment) {
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		mapper.updateComment(comment);
		session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void deleteComment(int commentId) {
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		mapper.deleteComment(commentId);
		session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public Comment retrieveCommentById(int commentId) {
		Comment comment =null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		comment= mapper.retrieveCommentById(commentId);	
		}finally {
			session.close();
		}
		
		return comment;
	}

	@Override
	public List<Comment> retrieveAllCommentsByRecordId(int recordId) {
		List<Comment> comments = null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		comments=mapper.retrieveAllCommentsByRecordId(recordId);	
		}finally {
			session.close();
		}
		
		return comments;
	}

	
}
