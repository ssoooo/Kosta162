package storeTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GeneralAffairs.domain.Member;
import GeneralAffairs.store.MemberStore;
import GeneralAffairs.store.logic.MemberStoreLogic;

public class MemberStoreLogicTest {

	
	private MemberStore store;
	
	@Before
	public void setUp() {
		store = new MemberStoreLogic();
	}
	//testOK
//	@Test
//	public void testRegistMember() {
//		Member member = new Member();
//		member.setAccount("111-23");
//		member.setEmail("easf@nsdfe.com");
//		member.setMemberId("양희수");
//		member.setName("희수");
//		member.setNickname("닉네임");
//		member.setPassword("123");
//		member.setPhoneNumber("010-0909-0909");
//		
//		store.registMember(member);
//	}

	//testOk
//	@Test
//	public void testUpdateMember() {
//		Member member = new Member();
//		member.setAccount("111231-23");
//		member.setEmail("test@nsdfe.com");
//		member.setMemberId("수정양희수");
//		member.setName("수정희수111");
//		member.setNickname("수정닉네임");
//		member.setPassword("수정123");
//		member.setPhoneNumber("수정010-0909-0909");
//		
//		store.updateMember(member);
//		assertEquals("수정희수111", member.getName());
//	}

	//testOK
//	@Test
//	public void testDeleteMember() {
//		store.deleteMember("양희수");
//	}

	//testOk
//	@Test
//	public void testRetrieveMemberById() {
//		Member member = new Member();
//		member = store.retrieveMemberById("수정양희수");
//		assertEquals("수정닉네임", member.getNickname());
//	}

	@Test
	public void testRetrieveAllMembersByGroup() {
//		List<Member> list = new ArrayList<Member>();
//		list = store.retrieveAllMembersByGroup(groupId)
	}

	@Test
	public void testRetrieveMembersByEvent() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateGrade() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistReqSignInMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSignInGroupReq() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckMemberHasGroup() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllSignInGroupReq() {
		fail("Not yet implemented");
	}

}
