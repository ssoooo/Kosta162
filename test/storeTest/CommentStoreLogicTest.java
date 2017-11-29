package storeTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GeneralAffairs.domain.Comment;
import GeneralAffairs.store.CommentStore;
import GeneralAffairs.store.logic.CommentStoreLogic;

public class CommentStoreLogicTest {
	private CommentStore store;
	
	@Before
	public void setUp() {
		store = new CommentStoreLogic();
	}
	//testOK -- *setRecordId를 안해도 0으로 입력된다. int형일때는 아무값도없으면 0인건지
//	@Test
//	public void testRegistComment() {
//		Date date = new Date(20071127);
//		Comment com = new Comment();
//		
//		com.setContent("커맨트12Test1");
//		com.setRecordId(1);
//		com.setMemberId("양희수");
//		
//		store.registComment(com);
//	}

	//testOK
//	@Test
//	public void testUpdateComment() {
//		Comment com = new Comment();
//		com.setCommentId(1);
//		com.setContent("커맨트Test111");
//		
//		store.updateComment(com);
//	}

	//testOK
//	@Test
//	public void testDeleteComment() {
//		Comment com = new Comment();
//		com.setCommentId(2);
//		store.deleteComment(2);
//	}
	//testOK
	@Test
	public void testRetrieveCommentById() {
		Comment com = new Comment();
		com = store.retrieveCommentById(1);
		assertNotNull(com);
		assertEquals("양희수", com.getMemberId());
		assertEquals("커맨트Test111", com.getContent());
	}
//testOK
	@Test
	public void testRetrieveAllCommentsByRecordId() {
		List<Comment> list = new ArrayList<Comment>();
		list = store.retrieveAllCommentsByRecordId(1);
		assertEquals(2, list.size());
	}

}
