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
	
//	@Test
//	public void testRegistGroup() {
//		Group group = new Group();
//		group.setAccount("1223-34");
//		
//		
//		group.setGroupIntroduce("store화이팅");
//		group.setGroupName("우형이그룹");
//		group.setMemberId("양희수");
//		store.registGroup(group);
//	}

	@Test
	public void testRegistMemberToGroup() {

		
		Member m = new Member();
		Group g = new Group();
		
		g.setGroupId(6);
		m.setMemberId("양희수");
		
		store.registMemberToGroup(m.getMemberId(),g.getGroupId());
		
		
	}

	@Test
	public void testUpdateGroup() {
		Group group = new Group();
		group.setGroupId(1);
		group.setAccount("123-1230");
		store.updateGroup(group);
		assertEquals("123-1230", group.getAccount());
	}

	@Test
	public void testDeleteGroup() {
		store.deleteGroup(1);
	}

	@Test
	public void testRetrieveGroupById() {
		Group group = new Group();
		group = store.retrieveGroupById(2);
		assertNotNull(group);
//		assertEquals(expected, actual);
	}

	@Test
	public void testRetrieveAllGroupsByMemberId() {
		List<Group> list = new ArrayList<Group>();
		list = store.retrieveAllGroupsByMemberId("양희수");
		assertEquals(3, list.size());
	}

	// 이거 메소드 어떻게 구현되는거지? -> 뮤직플레이어 확인해보기
	@Test
	public void testRetrieveAllGroupsByName() {
		List<Group> list = new ArrayList<Group>();
		list = store.retrieveAllGroupsByName("우형");
		
	}

	@Test
	public void testDeleteMemberFromGroup() {
		String memberId = "양희수";
		int groupId = 1;
		
		store.deleteMemberFromGroup(memberId, groupId);
	}

	@Test
	public void testRegistInvite() {
		int groupId = 1;
		String receivedMemberId = "백민지";
		store.registInvite(receivedMemberId, groupId);
		
	}

	@Test
	public void testDeleteInvite() {
		int groupId = 1;
		String receivedMemberId = "백민지";
		store.deleteInvite(receivedMemberId, groupId);
	}

	// 지우기
	@Test
	public void testRetrieveAllmyGroups() {
		List<Group> list = new ArrayList<Group>();
		list = store.retrieveAllGroupsByMemberId("양희수");
		assertEquals(3, list.size());
	}

	// resultType가 없는데 어떻게 받나? -> 초대 도메인을 만들던지 아니면 select groupId만 해서 resultType를 int?
	// 아니면 map같은거 써서 두개를 받나? (result map)
	
	@Test
	public void testRetrieveMyInvitationsByMyMemberId() {
//		String receiveMemberId = "양희수";
		
	}

	
	@Test
	public void testRetrieveAllRecordsByGroupId() {
		List<Record> list = new ArrayList<Record>();
		list = store.retrieveAllRecordsByGroupId(1);
		assertEquals(2, list.size());
		
		
	}

	@Test
	public void testUpdateGroupBalance() {
		Group group = new Group();
		group.setGroupId(1);
		group.setBalance(12300000);
		store.updateGroupBalance(group);
		
	}

}
