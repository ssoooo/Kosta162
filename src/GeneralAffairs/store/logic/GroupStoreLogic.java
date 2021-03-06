package GeneralAffairs.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Record;
import GeneralAffairs.store.GroupStore;
import GeneralAffairs.store.factory.SessionFactory;
import GeneralAffairs.store.mapper.GroupMapper;

@Repository
public class GroupStoreLogic implements GroupStore {

	@Override
	public void registGroup(Group group) {

		SqlSession session = SessionFactory.getInstance().getSession();

		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			mapper.registGroup(group);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public int registMemberToGroup(String memberId, int groupId) {

		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();

		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			check = mapper.registMemberToGroup(memberId, groupId);
			if (check > 0) {
				session.commit();
			}
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public int updateGroup(Group group) {

		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			check = mapper.updateGroup(group);
			if (check > 0) {
				session.commit();
			}
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public void deleteGroup(int groupId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			mapper.deleteGroup(groupId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public Group retrieveGroupById(int groupId) {

		Group group = null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			group = mapper.retrieveGroupById(groupId);
		} finally {
			session.close();
		}

		return group;
	}

	@Override
	public List<Group> retrieveAllGroupsByMemberId(String memberId) {

		List<Group> groups = null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			groups = mapper.retrieveAllGroupsByMemberId(memberId);

		} finally {
			session.close();
		}

		return groups;
	}

	@Override
	public List<Group> retrieveAllGroupsByName(String GroupName) {
		List<Group> groups = null;

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			groups = mapper.retrieveAllGroupsByName(GroupName);

		} finally {
			session.close();
		}

		return groups;
	}

	@Override
	public void deleteMemberFromGroup(String memberId, int groupId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			mapper.deleteMemberFromGroup(memberId, groupId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void registInvite(String memberId, int groupId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			mapper.registInvite(memberId, groupId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteInvite(String memberId, int groupId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			mapper.deleteInvite(memberId, groupId);
			session.commit();
		} finally {
			session.close();
		}
	}

	// @Override
	// public List<Group> retrieveAllmyGroups(String memberId) {
	// List<Group> groups = null;
	//
	// SqlSession sqlSession = SessionFactory.getInstance().getSession();
	// try {
	// GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
	// groups = mapper.retrieveAllmyGroups(memberId);
	//
	// }finally {
	// sqlSession.close();
	// }
	//
	//
	// return groups;
	// }

	@Override
	public List<Group> retrieveMyInvitationsByMyMemberId(String memberId) {
		List<Group> groups = null;

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			groups = mapper.retrieveMyInvitationsByMyMemberId(memberId);

		} finally {
			session.close();
		}

		return groups;
	}

	@Override
	public List<Record> retrieveAllRecordsByGroupId(int groupId) {
		List<Record> records = null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			records = mapper.retrieveAllRecordsByGroupId(groupId);

		} finally {
			session.close();
		}

		return records;
	}

	@Override
	public int updateGroupBalance(Group group) {
		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			mapper.updateGroupBalance(group);
			session.commit();
			if (check > 0) {
				session.commit();
			}
		} finally {
			session.close();
		}

		return check;
	}


	@Override
	public int registManagerToGroup(String memberId,int groupId) {

		int check =0;
		SqlSession session = SessionFactory.getInstance().getSession();
		
		try {
		GroupMapper mapper = session.getMapper(GroupMapper.class);
		check = mapper.registManagerToGroup(memberId, groupId);
		if(check>0) {
		session.commit();
		}
		}finally {
			session.close();
		}
		
		return check;
	}

	@Override
	public Group searchGroupByGroupName(String GroupName) {
		Group group = null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			GroupMapper mapper = session.getMapper(GroupMapper.class);
			group = mapper.findGroupByGroupName(GroupName);

		} finally {
			session.close();
		}
		return group;
	}

}
