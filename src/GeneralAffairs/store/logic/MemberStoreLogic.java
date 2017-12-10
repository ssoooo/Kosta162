package GeneralAffairs.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import GeneralAffairs.domain.Member;
import GeneralAffairs.store.MemberStore;
import GeneralAffairs.store.factory.SessionFactory;
import GeneralAffairs.store.mapper.MemberMapper;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public void registMember(Member member) {

		SqlSession session = SessionFactory.getInstance().getSession();

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.registMember(member);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public int updateMember(Member member) {

		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			check = mapper.updateMember(member);
			if (check > 0) {
				session.commit();
			}

		} finally {
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
		} finally {
			session.close();
		}

	}

	@Override
	public Member retrieveMemberById(String memberId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		Member member = null;

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			member = mapper.retrieveMemberById(memberId);

		} finally {
			session.close();
		}

		return member;
	}

	@Override
	public List<Member> retrieveAllMembersByGroup(int groupId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members = null;

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members = mapper.retrieveAllMembersByGroup(groupId);
		} finally {
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
			members = mapper.retrieveMembersByEvent(eventId);
		} finally {
			session.close();
		}

		return members;
	}

	@Override
	public int updateGrade(String memberId, int groupId, String grade) {
		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			check = mapper.updateGrade(memberId, groupId, grade);
			if (check > 0) {
				session.commit();
			}

		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public void registReqSignInMember(String memberId, int groupId) {

		SqlSession session = SessionFactory.getInstance().getSession();

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.registReqSignInMember(memberId, groupId);
			session.commit();
		} finally {
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
		} finally {
			session.close();
		}

	}

	@Override
	public ArrayList<Integer> checkMemberHasGroup(String memberId) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list = mapper.checkMemberHasGroup(memberId);
			if (list.size() > 0) {
				session.commit();
			}
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Member> retrieveAllSignInGroupReq(int groupId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members = null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members = mapper.retrieveAllSignInGroupReq(groupId);
		} finally {
			session.close();
		}

		return members;
	}

	@Override
	public List<Member> retrieveAllMembersExceptEventMembers(int groupId, int eventId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members = null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members = mapper.retrieveAllMembersExceptEventMembers(groupId, eventId);
		} finally {
			session.close();
		}

		return members;
	}

	@Override
	public List<Member> retrieveAllMembersExceptManager(int groupId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members = null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members = mapper.retrieveAllMembersExceptManager(groupId);
		} finally {
			session.close();
		}

		return members;
	}

	@Override
	public List<Member> retrieveAllUnPaidMembers(String memberId, int eventId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members = null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members = mapper.retrieveAllUnPaidMembers(memberId, eventId);
		} finally {
			session.close();
		}

		return members;
	}

	@Override
	public List<Member> retrieveAllPaidMembers(String memberId, int eventId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		List<Member> members = null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			members = mapper.retrieveAllPaidMembers(memberId, eventId);
		} finally {
			session.close();
		}

		return members;
	}

}
