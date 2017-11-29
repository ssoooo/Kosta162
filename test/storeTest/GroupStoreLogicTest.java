package storeTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.domain.Record;
import GeneralAffairs.store.GroupStore;
import GeneralAffairs.store.logic.GroupStoreLogic;

public class GroupStoreLogicTest {
	private GroupStore store;

	@Before
	public void setUp() {
		store = new GroupStoreLogic();
	}
	//testOK
//	@Test
//	public void testRegistGroup() {
//		Group group = new Group();
//		group.setAccount("1223-34");
//		
//		
//		group.setGroupIntroduce("store화이팅");
//		group.setGroupName("woo우형이그룹");
//		group.setMemberId("양희수");
//		store.registGroup(group);
//	}
//	//testOK
//	@Test
//	public void testRegistMemberToGroup() {
//
//		
//		Member m = new Member();
//		Group g = new Group();
//		
//		g.setGroupId(1);
//		m.setMemberId("백민지");
//		
//		store.registMemberToGroup(m.getMemberId(),g.getGroupId());
//		
//		
//	}
//	//testOK
//	@Test
//	public void testUpdateGroup() {
//		Group group = new Group();
//		group.setGroupId(3);
//		group.setAccount("123-1230");
//		group.setGroupIntroduce("store화이팅");
//		group.setGroupName("우형이그룹");
//		group.setMemberId("양희수");
//		store.updateGroup(group);
//		assertEquals("123-1230", group.getAccount());
//	}
//	//testOk
//	@Test
//	public void testDeleteGroup() {
//		store.deleteGroup(3);
//	}
//	//testOK
//	@Test
//	public void testRetrieveGroupById() {
//		Group group = new Group();
//		group = store.retrieveGroupById(2);
//		assertNotNull(group);
//		assertEquals("store화이팅", group.getGroupIntroduce());
//	}
//	//testOK
//	@Test
//	public void testRetrieveAllGroupsByMemberId() {
//		List<Group> list = new ArrayList<Group>();
//		list = store.retrieveAllmyGroups("양희수");
//
//		assertEquals(2, list.size());
//	}
//
//	//testOk
//	@Test
//	public void testRetrieveAllGroupsByName() {
//		List<Group> list = new ArrayList<Group>();
//		list = store.retrieveAllGroupsByName("우형이그룹");
//		assertEquals(3, list.size());
//		
//	}
//
//	//test Ok
//	@Test
//	public void testDeleteMemberFromGroup() {
//		String memberId = "양희수";
//		int groupId = 1;
//		
//		store.deleteMemberFromGroup(memberId, groupId);
//	}
//	//testOk
//	@Test
//	public void testRegistInvite() {
//		int groupId = 2;
//		String receivedMemberId = "이호정";
//		store.registInvite(receivedMemberId, groupId);
//		
//	}
//	//testOk
//	@Test
//	public void testDeleteInvite() {
//		int groupId = 1;
//		String receivedMemberId = "백민지";
//		store.deleteInvite(receivedMemberId, groupId);
//	}
//
//	// 지우기
//	@Test
//	public void testRetrieveAllmyGroups() {
//		List<Group> list = new ArrayList<Group>();
//		list = store.retrieveAllGroupsByMemberId("양희수");
//		assertEquals(3, list.size());
//	}
//
//	//testOk
//	@Test
//	public void testRetrieveMyInvitationsByMyMemberId() {
//		String receiveMemberId = "이호정";
//		List<Group> list = new ArrayList<Group>();
//		list = store.retrieveMyInvitationsByMyMemberId(receiveMemberId);
//		assertEquals(2, list.size());
//	}
//
//	
//	@Test
//	public void testRetrieveAllRecordsByGroupId() {
//		List<Record> list = new ArrayList<Record>();
//		list = store.retrieveAllRecordsByGroupId(1);
//		assertEquals(2, list.size());
//		
//		
//	}
//
// 	//testOK
//	@Test
//	public void testUpdateGroupBalance() {
//		Group group = new Group();
//		group.setGroupId(1);
//		group.setBalance(12300000);
//		store.updateGroupBalance(group);
//		
//	}

}
