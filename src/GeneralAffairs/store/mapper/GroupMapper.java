package GeneralAffairs.store.mapper;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Record;

public interface GroupMapper {
	void registGroup(Group group);
	int registMemberToGroup(@Param("memberId") String memberId,@Param("groupId")int groupId);
	int registManagerToGroup(@Param("memberId") String memberId,@Param("groupId")int groupId);
	int updateGroup(Group group);

	void deleteGroup(int groupId);

	// List<Group> retrieveAllmyGroups(String memberId);
	Group retrieveGroupById(int groupId);

	List<Group> retrieveAllGroupsByMemberId(String memberId);

	List<Group> retrieveAllGroupsByName(String GroupName);

	List<Group> retrieveMyInvitationsByMyMemberId(String memberId);

	List<Record> retrieveAllRecordsByGroupId(int groupId);

	void deleteMemberFromGroup(@Param("memberId") String memberId, @Param("groupId") int groupId);

	void registInvite(@Param("memberId") String memberId, @Param("groupId") int groupId);

	void deleteInvite(@Param("memberId") String memberId, @Param("groupId") int groupId);

	void updateGroupBalance(Group group);
	
	Group findGroupByGroupName(String GroupName);//
}
