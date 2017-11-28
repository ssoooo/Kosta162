package GeneralAffairs.store;

import java.util.List;

import GeneralAffairs.domain.Event;

public interface EventStore {

	void registEvent(Event event);
	int updateEvent(Event event);
	void deleteEvent(int eventId);
	Event retrieveEventById(int eventId);
	List<Event> retrieveAllEventsByGroupId(int groupId);
	void deleteMemberFromEvent(String memberId,int eventId);
	void registMemberToEvent(String memberId,int eventId);
	int updatePayment(int eventId, String memberId, String payment);
	void updateEventBalance(Event event);//

}
