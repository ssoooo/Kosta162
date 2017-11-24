package GeneralAffairs.service;

import java.util.List;

import GeneralAffairs.domain.Comment;

public interface CommentService {
	
	void createComment(Comment comment);
	void modifyComment(Comment comment);
	void removeComment(int commentId);
	Comment findCommentById(int commentId);
	List<Comment> findAllCommentsByRecordId(int recordId);
	

}
