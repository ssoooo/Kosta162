package GeneralAffairs.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import GeneralAffairs.domain.Event;
import GeneralAffairs.store.EventStore;
import GeneralAffairs.store.factory.SessionFactory;
import GeneralAffairs.store.mapper.EventMapper;

@Repository
public class EventStoreLogic implements EventStore {

	@Override
	public void registEvent(Event event) {

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			mapper.registEvent(event);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public int updateEvent(Event event) {
		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			check = mapper.updateEvent(event);
			if (check > 0) {
				session.commit();
			}
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public void deleteEvent(int eventId) {

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			mapper.deleteEvent(eventId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public Event retrieveEventById(int eventId) {
		Event event = null;

		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			event = mapper.retrieveEventById(eventId);
		} finally {
			session.close();
		}

		return event;
	}

	@Override
	public List<Event> retrieveAllEventsByGroupId(int groupId) {
		List<Event> events = null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			events = mapper.retrieveAllEventsByGroupId(groupId);
		} finally {
			session.close();
		}

		return events;
	}

	@Override
	public void deleteMemberFromEvent(String memberId, int eventId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			mapper.deleteMemberFromEvent(memberId, eventId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void registMemberToEvent(String memberId, int eventId) {
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			mapper.registMemberToEvent(memberId, eventId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public int updatePayment(int eventId, String memberId) {
		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			check = mapper.updatePayment(eventId, memberId);
			if (check > 0) {
				session.commit();
			}
		} finally {
			session.close();
		}

		return check;

	}

	@Override
	public void updateEventBalance(Event event) {
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			mapper.updateEventBalance(event);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public int updateUnPayment(int eventId, String memberId) {
		int check = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
			EventMapper mapper = session.getMapper(EventMapper.class);
			check = mapper.updateUnPayment(eventId, memberId);
			if (check > 0) {
				session.commit();
			}
		} finally {
			session.close();
		}

		return check;
	}

}
