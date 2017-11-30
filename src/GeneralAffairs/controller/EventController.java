package GeneralAffairs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import GeneralAffairs.domain.Event;
import GeneralAffairs.service.EventService;
import GeneralAffairs.service.MemberGroupService;

@Controller
@RequestMapping("event")
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private MemberGroupService msService;
	

	@RequestMapping(value="/registEvent.do", method=RequestMethod.POST)
	public String registEvent(Event event, HttpSession session) {

//		event.setMemberId((String)session.getAttribute("memberId"));
		eventService.createEvent(event);
		System.out.println(event.getGroupId());
		System.out.println(event.getEventId());
		System.out.println(event.getMemberId());
		return "redirect:/event/event.do?eventId="+event.getEventId();
	}
	
	@RequestMapping(value="/registEvent.do", method=RequestMethod.GET)
	public String showRegistEvent(int groupId, Model model, HttpSession session) {
		
		List<Event> events = eventService.findAllEventsByGroupId(groupId);		
		model.addAttribute("events", events);
		model.addAttribute("groupId", groupId);
		System.out.println(events);
		
		return "/views/event/registEvent.jsp";
	}

	@RequestMapping(value = "modifyEvent.do", method = RequestMethod.POST)
	public String modifyEvent(Event event) {

		return "";
	}

	@RequestMapping(value = "modifyEvent.do", method = RequestMethod.GET)
	public String showModifyEvent(int eventId, Model model) {

		return "";
	}

	@RequestMapping("deleteEvent.do")
	public String deleteEvent(int eventId, int groupId) {
		eventService.removeEvent(eventId);

		return "redirect:/views/event/event.do";
	}

	@RequestMapping("addMemberToEvent.do")
	public String addMemberToEvent(String memberId) {

		return "";
	}

	@RequestMapping("exceptFromMember.do")
	public String exceptMemberFromEvent(String memberId) {

		return "";
	}

	@RequestMapping("addEventBalance.do")
	public String addEventBalanceToGroupBalance(int eventId) {

		return "";
	}

	@RequestMapping("changePayment.do")
	public String changePayment(int eventId, String memberId) {

		return "";
	}

	@RequestMapping("eventDetail.do")
	public String showEventDetail(int eventId, Model model) {

		return "";
	}

	@RequestMapping("/event.do")
	public String showEvent(int eventId, int groupId, Model model) {

		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		model.addAttribute("events", events);
		
		model.addAttribute("groupId", groupId);

		// 내역 추가
		return "/views/event/event.jsp";
	}
	
	@RequestMapping("eventList.do")
	public String findAllEvents(Model model, int groupId) {
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		model.addAttribute("events", events);
		
		return "/views/event/event.jsp";
		
	}
	

}
