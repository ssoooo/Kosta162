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
		eventService.addMemberToEvent(event.getMemberId(), event.getEventId());
		
		model.addAttribute("event", event);
		System.out.println("///" + event.getEventId() + event.getGroupId());
		return "redirect:/event/event.do?eventId="+ event.getEventId() + "&groupId=" + event.getGroupId();
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
		
		Group group = msService.findGroupById(event.getGroupId());
		model.addAttribute("group", group);
		
		
		return "event/modifyEvent";
	}

	@RequestMapping("/remove.do")
	public String deleteEvent(int eventId, int groupId) {
		eventService.removeEvent(eventId);
		
		return "redirect:/memberGroup/group.do?groupId=" + groupId;
	}

	@RequestMapping(value = "/addMemberToEvent.do", method = RequestMethod.GET)
	public String showAddMemberToEvent(int eventId, int groupId, Model model)  {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		
		List<Member> members = msService.findAllMembersByGroup(groupId);
		model.addAttribute("members", members);
		
		List<Member> memberss = msService.findAllMembersByEvent(eventId);
		model.addAttribute("memberss", memberss);
		System.out.println("//" + members.size());
		System.out.println("////" + memberss.size());
		return "event/eventMember";
	}
	
	@RequestMapping(value = "/addMemberToEvent.do", method = RequestMethod.POST)
	public String AddMemberToEvent(String memberId, int eventId, Model model) {
		eventService.addMemberToEvent(memberId, eventId);
		
		System.out.println("//" + memberId);
		System.out.println("////" + eventId);
		model.addAttribute("memberId", memberId);
		model.addAttribute("eventId", eventId);
		
		return "redirect:/event/eventDetail.do?eventId=" + eventId + "&memberId=" + memberId;
	}

	@RequestMapping("/exceptFromMember.do")
	public String exceptMemberFromEvent(String memberId, int eventId) {
		eventService.exceptMemberFromEvent(memberId, eventId);
		
		return "redirect:/event/eventDetail.do?eventId=" + eventId + "&memberId=" + memberId;
	}

	@RequestMapping("/addEventBalance.do")
	public String addEventBalanceToGroupBalance(int eventId) {

		return "";
	}

	@RequestMapping("/collectionDetail.do")
	public String showChangePayment(int eventId, Model model) {
		List<Member> memberss = msService.findAllMembersByEvent(eventId);
		model.addAttribute("memberss", memberss);
		System.out.println("////" + memberss.size());
		
		return "event/collectionDetail";
	}

	@RequestMapping("/eventDetail.do")
	public String showEventDetail(int eventId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		
		Group group = msService.findGroupById(event.getGroupId());
		model.addAttribute("group", group);
		
		
		List<Member> members = msService.findAllMembersByEvent(eventId);
		model.addAttribute("members",members);
		System.out.println("//" + members.size());
		
		return "event/eventDetail";
	}

	@RequestMapping("/event.do")
	public String showEvent(int eventId, int groupId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		Group group = msService.findGroupById(groupId);
		model.addAttribute("group", group);
		
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		model.addAttribute("events", events);
		model.addAttribute("groupId", groupId);

		return "event/event";
	}

}
