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
//	//testOK
//	@Test
//	public void testRegistMember() {
//		Member member = new Member();
//		member.setAccount("111-233");
//		member.setEmail("e1111f@nsdfe.com");
//		member.setMemberId("성우형");
//		member.setName("우형");
//		member.setNickname("닉네임");
//		member.setPassword("1234");
//		member.setPhoneNumber("010-1119-2209");
//		
//		store.registMember(member);
//	}
//
//	//testOk
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
//
//	//testOK
//	@Test
//	public void testDeleteMember() {
//		store.deleteMember("양희수");
//	}
//
//	//testOk
//	@Test
//	public void testRetrieveMemberById() {
//		Member member = new Member();
//		member = store.retrieveMemberById("수정양희수");
//		assertEquals("수정닉네임", member.getNickname());
//	}
//	//testOK
	@Test
	public void testRetrieveAllMembersByGroup() {
		List<Member> list = new ArrayList<Member>();
		list = store.retrieveAllMembersByGroup(1);
		assertEquals(4, list.size());
	}

	//testOK
	@Test
	public void testRetrieveMembersByEvent() {
		List<Member> list = new ArrayList<Member>();
		list = store.retrieveMembersByEvent(8);
		
//		assertEquals(3, list.size());
	}
// //testOK(파라미터값변경)
//	@Test
//	public void testUpdateGrade() {
//		String memberId = "양희수";
//		int groupId = 1;
//		String grade = "총무";
//		
//		
//		assertTrue(store.updateGrade(memberId, groupId, grade)>0);
//		
//	}
//	//testOK
	@Test
	public void testRegistReqSignInMember() {
		String memberId = "민지";
		int groupId = 5;
		store.registReqSignInMember(memberId, groupId);
		
	}
//	//testOk
//	@Test
//	public void testDeleteSignInGroupReq() {
//		String memberId = "성우형";
//		int groupId = 1;
//		store.deleteSignInGroupReq(memberId, groupId);
//	}
//
//	//testOk 리턴값 arrayList<Integer>로 바꿈. 
//	@Test
//	public void testCheckMemberHasGroup() {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		String memberId = "양희수";
//		list = store.checkMemberHasGroup(memberId);
//		assertEquals(2, list.size());
//		
//	}
//	//testOk
	@Test
	public void testRetrieveAllSignInGroupReq() {
		List<Member> list = new ArrayList<Member>();
		list = store.retrieveAllSignInGroupReq(5);
		assertEquals(3, list.size());
	}

}
