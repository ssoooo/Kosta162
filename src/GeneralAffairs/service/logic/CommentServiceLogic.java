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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeComment(int commentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Comment findCommentById(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findAllCommentsByRecordId(int recordId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
