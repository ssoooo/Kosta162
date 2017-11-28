package GeneralAffairs.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import GeneralAffairs.domain.Event;

public interface EventMapper {
	void registEvent(Event event);
	int updateEvent(Event event);
	void deleteEvent(int eventId);
	Event retrieveEventById(int eventId);
	List<Event> retrieveAllEventsByGroupId(int groupId);
	void deleteMemberFromEvent(@Param("memberId") String memberId,@Param("eventId") int eventId);
	void registMemberToEvent(@Param("memberId") String memberId,@Param("eventId") int eventId);
	int updatePayment(@Param("eventId") int eventId, @Param("memberId") String memberId, @Param("payment") String payment);
	void updateEventBalance(Event event);
	
}
