package storeTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
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
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteGroup() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveGroupById() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllGroupsByMemberId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllGroupsByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMemberFromGroup() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistInvite() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteInvite() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllmyGroups() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveMyInvitationsByMyMemberId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllRecordsByGroupId() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateGroupBalance() {
		fail("Not yet implemented");
	}

}
