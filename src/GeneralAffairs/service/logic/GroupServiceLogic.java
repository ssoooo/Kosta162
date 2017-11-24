package GeneralAffairs.service.logic;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Group;
import GeneralAffairs.service.GroupService;
import GeneralAffairs.store.GroupStore;

@Service
public class GroupServiceLogic implements GroupService{
	
	@Autowired
	private GroupStore store;

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
	public List<Group> findGroupByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> findGroupByGroupName(String groupName) {
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
	public boolean modifyGroupBalance(Group group, int price) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
