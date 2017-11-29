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
		return check>0;
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
	public void acceptInvite(String memberId, int groupId) {
		gStore.registInvite(memberId, groupId);
		
	}

	@Override
	public void denyInvite(String memberId, int groupId) {
		gStore.deleteInvite(memberId, groupId);
		
	}

	@Override
	public void modifyGroupBalance(Group group) {
		gStore.updateGroupBalance(group);
		
	}
	
	

}
