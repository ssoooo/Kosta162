package GeneralAffairs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.service.EventService;
import GeneralAffairs.service.MemberGroupService;

@Controller
@RequestMapping("event")
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private MemberGroupService msService;

	@RequestMapping(value = "/registEvent.do", method = RequestMethod.POST)
	public String registEvent(Event event, HttpSession session, Model model) {
		event.setMemberId((String) session.getAttribute("loginedMemberId"));
		eventService.createEvent(event);
//		eventService.addMemberToEvent(event.getMemberId(), event.getEventId());
		
		model.addAttribute("event", event);
		return "redirect:/group/group.do?groupId=" + event.getGroupId();
	}

	@RequestMapping(value = "/registEvent.do", method = RequestMethod.GET)
	public String showRegistEvent(HttpSession session, int groupId, Model model) {
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		model.addAttribute("events", events);
		model.addAttribute("groupId", groupId);

		return "event/registEvent";
	}

	@RequestMapping(value = "/modifyEvent.do", method = RequestMethod.POST)
	public String modifyEvent(Event event, Model model) {
		eventService.modifyEvent(event);
		model.addAttribute("event", event);
		model.addAttribute("groupId", event.getGroupId());
		
		return "redirect:/event/eventDetail.do?eventId=" + event.getEventId();
	}

	@RequestMapping(value = "/modifyEvent.do", method = RequestMethod.GET)
	public String showModifyEvent(int eventId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		
		return "event/modifyEvent";
	}

	@RequestMapping("/remove.do")
	public String deleteEvent(int eventId, int groupId) {
		eventService.removeEvent(eventId);
		
		return "redirect:/memberGroup/group.do?groupId=" + groupId;
	}

	@RequestMapping(value = "/addMemberToEvent.do", method = RequestMethod.GET)
	public String showAddMemberToEvent(int eventId, Model model)  {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		
		return "event/eventMember";
	}
	
	@RequestMapping(value = "/addMemberToEvent.do", method = RequestMethod.POST)
	public String showAddMemberToEvent(int groupId, int eventId, Model model) {
		Group group = msService.findGroupById(groupId);
		model.addAttribute("group", group);
		
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		model.addAttribute("events",events);
		
		List<Member> groupMembers = msService.findAllMembersByGroup(groupId);
		model.addAttribute("groupMembers", groupMembers);
		
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		
		List<Member> eventMembers = msService.findAllMembersByEvent(eventId);
		model.addAttribute("eventMembers", eventMembers);
		
		return "event/eventMember";
	}

	@RequestMapping("/exceptFromMember.do")
	public String exceptMemberFromEvent(String memberId) {

		return "";
	}

	@RequestMapping("/addEventBalance.do")
	public String addEventBalanceToGroupBalance(int eventId) {

		return "";
	}

	@RequestMapping("/changePayment.do")
	public String changePayment(int eventId, String memberId) {

		return "";
	}

	@RequestMapping("/eventDetail.do")
	public String showEventDetail(int eventId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		
		List<Member> members = msService.findAllMembersByEvent(eventId);
		model.addAttribute("members",members);
		
		return "event/eventDetail";
	}

	@RequestMapping("/event.do")
	public String showEvent(int eventId, int groupId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		model.addAttribute("events", events);
		model.addAttribute("groupId", groupId);

		return "event/event";
	}

}
