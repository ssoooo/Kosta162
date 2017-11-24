package GeneralAffairs.service;

import java.util.List;

import GeneralAffairs.domain.Event;

public interface EventService {
	
	void createEvent(Event event);
	boolean modifyEvent(Event event);
	void removeEvent(int eventId);
	Event findEventById(int eventId);
	List<Event> findAllEventsByGroupId(int groupId);
	boolean exceptMemberFromEvent(String memberId,int eventId);
	void addMemberToEvent(String memberId,int eventId);
	void addEventBalanceToGroupBalance(int eventId);
	void changePayment(String memberId,int eventId);
	void removeFromEvent(String memberId);
	boolean modifyEventBalance(Event event,int price);
	

}
