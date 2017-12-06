package GeneralAffairs.service;

import java.util.List;

import GeneralAffairs.domain.Event;

public interface EventService {
	
	void removeEvent(int eventId);
 	Event findEventById(int eventId);
 	List<Event> findAllEventsByGroupId(int groupId);
	void exceptMemberFromEvent(String memberId,int eventId);
 	void addMemberToEvent(String memberId,int eventId);
	boolean addEventBalanceToGroupBalance(int eventId, int groupId);
	void changePayment(String memberId,int eventId, String payment);
	void removeFromEvent(String memberId, int eventId);
	void modifyEventBalance(Event event);
	void modifyEvent(Event event);
	void createEvent(Event event);

}
