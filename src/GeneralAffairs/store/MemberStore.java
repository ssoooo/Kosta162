package GeneralAffairs.store;

import java.util.List;

import GeneralAffairs.domain.Member;

public interface MemberStore {
	
	void registMember(Member member);
	int updateMember(Member member);
	void deleteMember(String memberId);
	Member retrieveMemberById(String memberId);
	List<Member> retrieveAllMembersByGroup(int groupId);
	List<Member> retrieveMembersByEvent(int eventId);
	int updateGrade(String memberId,int groupId);
	List<Member> retrieveAllSignInGroupReq(int groupId);
	void registReqSignInMember(String memberId,int groupId);
	void deleteSignInGroupReq(String memberId,int groupId);
	int checkMemberHasGroup(String memberId);

}
