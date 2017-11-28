package GeneralAffairs.service.logic;

import java.util.List;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.service.MemberGroupService;

public class MemberGroupServiceLogic implements MemberGroupService{

	@Override
	public void createMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyMember(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMember(String memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member findMemberById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllMembersByGroup(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllMembersByEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllSignInGroupReq(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tradeGrade(String memberId, int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reqSignInGroup(String memberId, int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void denySignInGroupReq(String memberId, int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createMemberToGroup(String memberId, int groupId, String grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGroup(Group group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeGroup(int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Group> findAllMyGroups(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group findGroupById(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> findAllGroupsByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> findAllGroupsByGroupName(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> findMyInvitationsByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeMemberFromGroup(String memberId, int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptInvite(String memberId, int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void denyInvite(String memberId, int groupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGroupBalance(Group group) {
		// TODO Auto-generated method stub
		
	}

	
	

}
