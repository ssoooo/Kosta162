package GeneralAffairs.store.mapper;

import java.util.List;

import GeneralAffairs.domain.Comment;

public interface CommentMapper {
	void registComment(Comment comment);

	void updateComment(Comment comment);

	void deleteComment(int commentId);

	Comment retrieveCommentById(int commentId);

	List<Comment> retrieveAllCommentsByRecordId(int recordId);

}
