package GeneralAffairs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import GeneralAffairs.domain.Group;

public interface GroupService {
	
	void createGroup(Group group);
	boolean createMemberToGroup(String memberId,int groupId,String grade);
	boolean modifyGroup(Group group);
	void removeGroup(int groupId);
	List<Group> findAllMyGroups(String memberId);
	Group findGroupById(int groupId);
	List<Group> findGroupByMemberId(String memberId);
	List<Group> findGroupByGroupName(String groupName);
	List<Group> findMyInvitationsByMemberId(String memberId);
	void removeMemberFromGroup(String memberId,int groupId);
	void acceptInvite(String memberId,int groupId);
	void denyInvite(String memberId,int groupId);
	boolean modifyGroupBalance(Group group,int price);

}
