package GeneralAffairs.service;

import java.util.List;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;

public interface MemberGroupService {
	
	void createMember(Member member);
	boolean modifyMember(Member member);
	void removeMember(String memberId);
	Member findMemberById(String memberId);
	List<Member> findAllMembersByGroup(int groupId);
	List<Member> findAllMembersByEvent(int eventId);
	List<Member> findAllSignInGroupReq(int groupId);
	void tradeGrade(String memberId,int groupId,String grade);
	void reqSignInGroup(String memberId,int groupId);
	void denySignInGroupReq(String memberId,int groupId);
	
	void createGroup(Group group);
	boolean createMemberToGroup(String memberId,int groupId);
	boolean createManagerToGroup(String memberId,int groupId);
	boolean modifyGroup(Group group);
	void removeGroup(int groupId);
//	List<Group> findAllMyGroups(String memberId);
	Group findGroupById(int groupId);
	List<Group> findAllGroupsByMemberId(String memberId);
	List<Group> findAllGroupsByGroupName(String groupName);
	List<Group> findMyInvitationsByMemberId(String memberId);
	void removeMemberFromGroup(String memberId,int groupId);
	void acceptInvite(String memberId,int groupId);
	void denyInvite(String memberId,int groupId);
	void modifyGroupBalance(Group group);
	

}
