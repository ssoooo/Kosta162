package GeneralAffairs.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Member;
import GeneralAffairs.service.MemberService;
import GeneralAffairs.store.MemberStore;

@Service
public class MemberServiceLogic implements MemberService{
	
	@Autowired
	private MemberStore store;

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
	public List<Member> findAllMemberByGroup(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllMemberByEvent(int eventId) {
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

	
}
