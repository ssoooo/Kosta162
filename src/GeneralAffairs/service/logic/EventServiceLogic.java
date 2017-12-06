package GeneralAffairs.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Event;
import GeneralAffairs.service.EventService;
import GeneralAffairs.store.EventStore;

@Service
public class EventServiceLogic implements EventService{
	
	@Autowired
	private EventStore store;

	@Override
	public void createEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyEvent(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeEvent(int eventId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event findEventById(int eventId) {
		return store.retrieveEventById(eventId);
	}

	@Override
	public List<Event> findAllEventsByGroupId(int groupId) {
		return store.retrieveAllEventsByGroupId(groupId);
	}

	@Override
	public boolean exceptMemberFromEvent(String memberId, int eventId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addMemberToEvent(String memberId, int eventId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEventBalanceToGroupBalance(int eventId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePayment(String memberId, int eventId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromEvent(String memberId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyEventBalance(Event event, int price) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
