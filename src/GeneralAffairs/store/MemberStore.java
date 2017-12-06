package GeneralAffairs.store;

import java.util.ArrayList;
import java.util.List;

import GeneralAffairs.domain.Member;

public interface MemberStore {

	void registMember(Member member);

	int updateMember(Member member);

	void deleteMember(String memberId);

	Member retrieveMemberById(String memberId);

	List<Member> retrieveAllMembersByGroup(int groupId);

	List<Member> retrieveMembersByEvent(int eventId);

	int updateGrade(String memberId, int groupId, String grade);

	List<Member> retrieveAllSignInGroupReq(int groupId);

	void registReqSignInMember(String memberId, int groupId);

	void deleteSignInGroupReq(String memberId, int groupId);

	ArrayList<Integer> checkMemberHasGroup(String memberId);

	List<Member> retrieveAllMembersExceptEventMembers(int groupId, int eventId);

	List<Member> retrieveAllMembersExceptManager(int groupId);

	List<Member> retrieveAllUnPaidMembers(String memberId, int eventId);

	List<Member> retrieveAllPaidMembers(String memberId, int eventId);

}
