package GeneralAffairs.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Comment;
import GeneralAffairs.service.CommentService;
import GeneralAffairs.store.CommentStore;

@Service
public class CommentServiceLogic implements CommentService {
	
	@Autowired
	private CommentStore store;

	@Override
	public void createComment(Comment comment) {
		store.registComment(comment);
		
	}

	@Override
	public void modifyComment(Comment comment) {
		store.updateComment(comment);
		
	}

	@Override
	public void removeComment(int commentId) {
		store.deleteComment(commentId);
	}

	@Override
	public Comment findCommentById(int commentId) {
		
		return store.retrieveCommentById(commentId);
	}

	@Override
	public List<Comment> findAllCommentsByRecordId(int recordId) {
		
		return store.retrieveAllCommentsByRecordId(recordId);
	}

	
	
}
