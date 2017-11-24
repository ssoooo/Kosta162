package GeneralAffairs.store;

import java.util.List;

import GeneralAffairs.domain.Comment;

public interface CommentStore {
	
	void registComment(Comment comment);
	void updateComment(Comment comment);
	void deleteComment(int commentId);
	Comment retrieveCommentById(int commentId);
	List<Comment> retrieveAllCommentsByRecordId(int recordId);

}
