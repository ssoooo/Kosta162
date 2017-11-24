package GeneralAffairs.service;

import java.util.List;

import GeneralAffairs.domain.Member;

public interface MemberService {
	
	void createMember(Member member);
	boolean modifyMember(Member member);
	void removeMember(String memberId);
	Member findMemberById(String memberId);
	List<Member> findAllMemberByGroup(int groupId);
	List<Member> findAllMemberByEvent(int eventId);
	List<Member> findAllSignInGroupReq(int groupId);
	void tradeGrade(String memberId,int groupId);
	void reqSignInGroup(String memberId,int groupId);
	void denySignInGroupReq(String memberId,int groupId);
	
	
}
