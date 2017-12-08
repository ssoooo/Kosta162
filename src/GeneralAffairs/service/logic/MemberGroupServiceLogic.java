package GeneralAffairs.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.service.MemberGroupService;
import GeneralAffairs.store.GroupStore;
import GeneralAffairs.store.MemberStore;

@Service
public class MemberGroupServiceLogic implements MemberGroupService{
	@Autowired
	private MemberStore mStore;
	@Autowired
	private GroupStore gStore;
	
	@Override
	public void createMember(Member member) {
		mStore.registMember(member);
		
	}

	@Override
	public boolean modifyMember(Member member) {
		int check = 0;
		check = mStore.updateMember(member);
		return check > 0;
	}

	@Override
	public void removeMember(String memberId) {
		mStore.deleteMember(memberId);
		
	}

	@Override
	public Member findMemberById(String memberId) {
		return mStore.retrieveMemberById(memberId);
	}

	@Override
	public List<Member> findAllMembersByGroup(int groupId) {
		
		return mStore.retrieveAllMembersByGroup(groupId);
	}

	@Override
	public List<Member> findAllMembersByEvent(int eventId) {
	
		return mStore.retrieveMembersByEvent(eventId);
	}

	@Override
	public List<Member> findAllSignInGroupReq(int groupId) {
		
		return mStore.retrieveAllSignInGroupReq(groupId);
	}

	@Override
	public void tradeGrade(String memberId, int groupId, String grade) {
		mStore.updateGrade(memberId, groupId, grade);
		
	}

	@Override
	public void reqSignInGroup(String memberId, int groupId) {
		mStore.registReqSignInMember(memberId, groupId);
		
	}

	@Override
	public void denySignInGroupReq(String memberId, int groupId) {
		mStore.deleteSignInGroupReq(memberId, groupId);
		
	}

	@Override
	public void createGroup(Group group) {
		gStore.registGroup(group);
	}

	@Override
	public boolean createMemberToGroup(String memberId, int groupId) {
		int check = 0;
		check = gStore.registMemberToGroup(memberId, groupId);
		return check > 0;
	}
	
	@Override
	public boolean createManagerToGroup(String memberId, int groupId) {
		int check = 0;
		check = gStore.registManagerToGroup(memberId, groupId);
		return check > 0;
	}

	@Override
	public boolean modifyGroup(Group group) {
		int check = 0;
		check = gStore.updateGroup(group);
		
		return check>0;
	}

	@Override
	public void removeGroup(int groupId) {
		gStore.deleteGroup(groupId);
		
		List<Member> members = mStore.retrieveAllMembersByGroup(groupId);
		
		for(Member member: members) {
			gStore.deleteMemberFromGroup(member.getMemberId(), groupId);
		}
	}
	
	@Override
	public boolean leaveGroup(String memberId, int groupId) {
		List<Integer> groupIds = mStore.checkMemberHasGroup(memberId);
		
		if(groupIds.size() > 1) {
			gStore.deleteMemberFromGroup(memberId, groupId);
			return true;
			
		} else {
			gStore.deleteMemberFromGroup(memberId, groupId);
			mStore.deleteMember(memberId);
			return false;
		}
	}
	
	@Override
	public void kickMember(String memberId, int groupId) {
		List<Integer> groupIds = mStore.checkMemberHasGroup(memberId);
		
		if(groupIds.size() > 1) {
			gStore.deleteMemberFromGroup(memberId, groupId);
			
		} else {
			gStore.deleteMemberFromGroup(memberId, groupId);
			mStore.deleteMember(memberId);
		}
	}
	
//	@Override
//	public List<Group> findAllMyGroups(String memberId) {
//		
//		return null;
//	}

	@Override
	public Group findGroupById(int groupId) {
		return gStore.retrieveGroupById(groupId);
	}

	@Override
	public List<Group> findAllGroupsByMemberId(String memberId) {
		return gStore.retrieveAllGroupsByMemberId(memberId);
	}

	@Override
	public List<Group> findAllGroupsByGroupName(String groupName) {
		return gStore.retrieveAllGroupsByName(groupName);
	}

	@Override
	public List<Group> findMyInvitationsByMemberId(String memberId) {
		
		return gStore.retrieveMyInvitationsByMyMemberId(memberId);
	}

	@Override
	public void removeMemberFromGroup(String memberId, int groupId) {
		gStore.deleteMemberFromGroup(memberId, groupId);
		
	}

	@Override
	public void createInvite(String memberId, int groupId) {
		gStore.registInvite(memberId, groupId);
	}

	@Override
	public void deleteInvite(String memberId, int groupId) {
		gStore.deleteInvite(memberId, groupId);
	}

	@Override
	public void acceptInvite(String memberId, int groupId) {
		gStore.registMemberToGroup(memberId, groupId);
		gStore.deleteInvite(memberId, groupId);
	}
	
	@Override
	public void modifyGroupBalance(Group group) {
		gStore.updateGroupBalance(group);
		
	}

	@Override
	public List<Member> findAllMembersExceptEventMembers(int groupId, int eventId) {
		return mStore.retrieveAllMembersExceptEventMembers(groupId, eventId);
	}

	@Override
	public List<Member> findAllMembersExceptManager(int groupId) {
		return mStore.retrieveAllMembersExceptManager(groupId);
	}

	@Override
	public List<Member> findAllUnPaidMembers(String memberId, int eventId) {
		return mStore.retrieveAllUnPaidMembers(memberId, eventId);
	}

	@Override
	public List<Member> findAllPaidMembers(String memberId, int eventId) {
		return mStore.retrieveAllPaidMembers(memberId, eventId);
	}

	@Override
	public Group findGroupBygroupName(String groupName) {
		return gStore.searchGroupByGroupName(groupName);
	}

	@Override
	public List<Integer> checkMemberHasGroup(String memberId) {
		return mStore.checkMemberHasGroup(memberId);
	}
	

}
