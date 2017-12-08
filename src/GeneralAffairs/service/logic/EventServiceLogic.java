package GeneralAffairs.service.logic;
 
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Group;
import GeneralAffairs.service.EventService;
import GeneralAffairs.store.EventStore;
import GeneralAffairs.store.GroupStore;
 
 @Service
 public class EventServiceLogic implements EventService{
 	
 	@Autowired
	private EventStore eventStore;
	private GroupStore groupStore;
 
 	@Override
 	public void createEvent(Event event) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		event.setDate(today);
		eventStore.registEvent(event);
 	}
 
 	@Override
 	public void modifyEvent(Event event) {
		eventStore.updateEvent(event);

 	}
 
 	@Override
 	public void removeEvent(int eventId) {
		eventStore.deleteEvent(eventId);
 	}
 
 	@Override
 	public Event findEventById(int eventId) {
		return eventStore.retrieveEventById(eventId);
 	}
 
 	@Override
 	public List<Event> findAllEventsByGroupId(int groupId) {
		return eventStore.retrieveAllEventsByGroupId(groupId);
 	}
 
 	@Override
	public void exceptMemberFromEvent(String memberId, int eventId) {
		eventStore.deleteMemberFromEvent(memberId, eventId);
 	}
 
 	@Override
 	public void addMemberToEvent(String memberId, int eventId) {
		eventStore.registMemberToEvent(memberId, eventId);
 	}
 
 	@Override
	public boolean addEventBalanceToGroupBalance(int eventId, int groupId) {
		int check = 0;
		Event event = eventStore.retrieveEventById(eventId);
		Group group = groupStore.retrieveGroupById(groupId);

		
//		double eventB = event.getBalance();
//		double groupB = group.getBalance();
//		
//		eventB += groupB;
//		group.setBalance(groupB);
 		
		double sum = event.getBalance() + group.getBalance();
		group.setBalance(sum);
		
		check = groupStore.updateGroupBalance(group);
		return check > 0;
 	}
 
 	@Override
	public void changePayment(String memberId, int eventId) {
		eventStore.updatePayment(eventId, memberId);
 	}
 
 	@Override
	public void removeFromEvent(String memberId, int eventId) {
		eventStore.deleteMemberFromEvent(memberId, eventId);
 	}
 
 	@Override
	public void modifyEventBalance(Event event) {
		eventStore.updateEventBalance(event);
 	}

	@Override
	public void changeUnPayment(String memberId, int eventId) {
		eventStore.updateUnPayment(eventId, memberId);
		
	}

	@Override
	public void modifyEventBalance(Event event, int price) {
		eventStore.updateEventBalance(event);
		
	}
	
 }