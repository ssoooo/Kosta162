package GeneralAffairs.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import GeneralAffairs.domain.Member;
import GeneralAffairs.store.MemberStore;
import GeneralAffairs.store.factory.SessionFactory;
import GeneralAffairs.store.mapper.MemberMapper;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public void registMember(Member member) {

		SqlSession session = SessionFactory.getInstance().getSession();

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.registMember(member);
			session.commit();
		}finally {
			session.close();
		}

	}

	@Override
	public int updateMember(Member member) {

		int check=0;
		SqlSession session = SessionFactory.getInstance().getSession();

		try {	
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			check=mapper.updateMember(member);
			if(check>0) {
				session.commit();
			}

		}finally {
			session.close();
		}


		return check;
	}

	@Override
	public void deleteMember(String memberId) {
		SqlSession session = SessionFactory.getInstance().getSession();

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.deleteMember(memberId);
			session.commit();
		}finally {
			session.close();
		}

	}

	@Override
	public Member retrieveMemberById(String memberId) {

		SqlSession session =SessionFactory.getInstance().getSession();
		Member member = null;

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			member = mapper.retrieveMemberById(memberId);

		}finally {
			session.close();
		}

		return member;
	}

	@Override
	public List<Member> retrieveAllMembersByGroup(int groupId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members =null;

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members = mapper.retrieveAllMembersByGroup(groupId);
		}finally {
			session.close();
		}

		return members;
	}

	@Override
	public List<Member> retrieveMembersByEvent(int eventId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members = null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members= mapper.retrieveMembersByEvent(eventId);
		}finally {
			session.close();
		}

		return members;
	}

	@Override
	public int updateGrade(String memberId, int groupId) {
		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			MemberMapper mapper =session.getMapper(MemberMapper.class);
			check=mapper.updateGrade(memberId, groupId);
			if(check>0) {
				session.commit();
			}
			
		}finally {
			session.close();
		}
		
		
		return check;
	}

	@Override
	public void registReqSignInMember(String memberId, int groupId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		
		try {
			MemberMapper mapper= session.getMapper(MemberMapper.class);
			mapper.registReqSignInMember(memberId, groupId);
			session.commit();
		}finally {
			session.close();
		}
	}

	@Override
	public void deleteSignInGroupReq(String memberId, int groupId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.deleteSignInGroupReq(memberId, groupId);
			session.commit();
		}finally {
			session.close();
		}

	}

	@Override
	public int checkMemberHasGroup(String memberId) {
		int check=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			check=mapper.checkMemberHasGroup(memberId);
			if(check>0) {
				session.commit();
			}
		}finally {
			session.close();
		}

		
		System.out.println("member");
		return check;
	}

	@Override
	public List<Member> retrieveAllSignInGroupReq(int groupId) {
		
		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members=null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members=mapper.retrieveAllSignInGroupReq(groupId);
		}finally {
			session.close();
		}

		return members;
	}


}
