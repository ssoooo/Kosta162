package GeneralAffairs.store;

import java.util.List;

import javax.servlet.http.HttpSession;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Record;

public interface GroupStore {
	
	void registGroup(Group group);
	int registMemberToGroup(String memberId,int groupId);
	int updateGroup(Group group);
	void deleteGroup(int groupId);
	List<Group> retrieveAllmyGroups(String memberId);
	Group retrieveGroupById(int groupId);
	List<Group> retrieveAllGroupsByMemberId(String memberId);
	List<Group> retrieveAllGroupsByName(String GroupName);
	List<Group> retrieveMyInvitationsByMyMemberId(int memberId);
	List<Record> retrieveAllRecordsByGroupId(int groupId);
	void deleteMemberFromGroup(String memberId,int groupId);
	void registInvite(String memberId,int groupId);
	void deleteInvite(String memberId,int groupId);
	void updateGroupBalance(Group group);//

}
