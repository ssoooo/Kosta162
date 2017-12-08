package GeneralAffairs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.domain.Record;
import GeneralAffairs.service.EventService;
import GeneralAffairs.service.MemberGroupService;
import GeneralAffairs.service.RecordService;

@Controller
@RequestMapping("event")
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private MemberGroupService mgService;
	
	@Autowired
	private RecordService recordService;


	@RequestMapping(value = "/registEvent.do", method = RequestMethod.POST)
	public String registEvent(Event event, HttpSession session, HttpServletRequest req, Model model) {
		event.setMemberId((String) session.getAttribute("loginedMemberId"));
		eventService.createEvent(event);
		Group group = mgService.findGroupById(event.getGroupId());

		String[] members = req.getParameterValues("get");
		for (int i = 0; i < members.length; i++) {
			group.setMemberId(members[i]);
		}

		model.addAttribute("event", event);
		eventService.addMemberToEvent(event.getMemberId(), event.getEventId());
		eventService.addMemberToEvent(group.getMemberId(), event.getEventId());

		return "redirect:/event/event.do?eventId=" + event.getEventId() + "&groupId=" + event.getGroupId();
	}

	@RequestMapping(value = "/registEvent.do", method = RequestMethod.GET)
	public String showRegistEvent(HttpSession session, int groupId, Model model) {
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		Group group = mgService.findGroupById(groupId);

		model.addAttribute("events", events);
		model.addAttribute("group", group);

		return "event/registEvent";
	}

	@RequestMapping(value = "/modifyEvent.do", method = RequestMethod.POST)
	public String modifyEvent(Event event, HttpServletRequest req, Model model) {
		eventService.modifyEvent(event);
		model.addAttribute("event", event);
		model.addAttribute("groupId", event.getGroupId());

		Group group = mgService.findGroupById(event.getGroupId());

		String[] memberss = req.getParameterValues("get");
		for (int i = 0; i < memberss.length; i++) {
			group.setMemberId(memberss[i]);
		}
		eventService.addMemberToEvent(group.getMemberId(), event.getEventId());

		String[] members = req.getParameterValues("get2");
		for (int i = 0; i < members.length; i++) {
			event.setMemberId(members[i]);
		}
		eventService.removeFromEvent(event.getMemberId(), event.getEventId());

		return "redirect:/event/eventDetail.do?eventId=" + event.getEventId();
	}

	@RequestMapping(value = "/modifyEvent.do", method = RequestMethod.GET)
	public String showModifyEvent(int eventId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		List<Event> events = eventService.findAllEventsByGroupId(event.getGroupId());
		model.addAttribute("events", events);

		Group group = mgService.findGroupById(event.getGroupId());
		model.addAttribute("group", group);

		List<Member> memberss = mgService.findAllMembersByEvent(eventId);
		model.addAttribute("memberss", memberss);

		return "event/modifyEvent";
	}

	@RequestMapping("/remove.do")
	public String deleteEvent(int eventId, int groupId) {
		eventService.removeEvent(eventId);

		return "redirect:/memberGroup/group.do?groupId=" + groupId;
	}

	@RequestMapping(value = "/addMemberToEvent.do", method = RequestMethod.GET)
	public String showAddMemberToEvent(int eventId, int groupId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		Group group = mgService.findGroupById(groupId);

		List<Member> members = mgService.findAllMembersExceptEventMembers(group.getGroupId(), eventId);
		model.addAttribute("members", members);

		List<Member> memberss = mgService.findAllMembersByEvent(eventId);
		model.addAttribute("memberss", memberss);

		return "event/eventMember";
	}

	// @RequestMapping(value = "/addMemberToEvent.do", method = RequestMethod.POST)
	// public String AddMemberToEvent(String memberId, int eventId,
	// HttpServletRequest req, Model model) {
	// Event event = eventService.findEventById(eventId);
	// Group group = mgService.findGroupById(event.getGroupId());
	//
	// model.addAttribute("memberId", memberId);
	// model.addAttribute("eventId", eventId);
	//
	// String[] members = req.getParameterValues("get");
	// for (int i = 0; i < members.length; i++) {
	// group.setMemberId(members[i]);
	// System.out.println(members[i]);
	// }
	// eventService.addMemberToEvent(group.getMemberId(), event.getEventId());
	//
	// return "redirect:/event/eventDetail.do?eventId=" + eventId + "&memberId=" +
	// memberId;
	// }

	// @RequestMapping("/exceptFromMember.do")
	// public String exceptMemberFromEvent(String memberId, int eventId,
	// HttpServletRequest req) {
	// Event event = eventService.findEventById(eventId);
	// Group group = mgService.findGroupById(event.getGroupId());
	//
	// String[] members = req.getParameterValues("get2");
	// for (int i = 0; i < members.length; i++) {
	// group.setMemberId(members[i]);
	// System.out.println(members[i]);
	// }
	// eventService.exceptMemberFromEvent(memberId, eventId);
	//
	// return "redirect:/event/modifyEvent.do?eventId=" + eventId + "&memberId=" +
	// memberId;
	// }

	@RequestMapping("/addEventBalance.do")
	public String addEventBalanceToGroupBalance(int eventId) {
		Event event = eventService.findEventById(eventId);
		eventService.addEventBalanceToGroupBalance(eventId, event.getGroupId());

		return "memberGroup/group";
	}

	@RequestMapping(value = "/collectionDetail.do", method = RequestMethod.GET)
	public String showChangePayment(int eventId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		Group group = mgService.findGroupById(event.getGroupId());
		model.addAttribute("group", group);

		List<Member> members = mgService.findAllUnPaidMembers(event.getMemberId(), eventId);
		List<Member> memberss = mgService.findAllPaidMembers(event.getMemberId(), eventId);

		model.addAttribute("members", members);
		model.addAttribute("memberss", memberss);

		return "event/collectionDetail";
	}

	@RequestMapping(value = "/collectionDetail.do", method = RequestMethod.POST)
	public String ChangePayment(int eventId, HttpServletRequest req, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		String[] members = req.getParameterValues("memberId");
		for (int i = 0; i < members.length; i++) {
			event.setMemberId(members[i]);
		}
		eventService.changePayment(event.getMemberId(), eventId);

		return "redirect:/event/collectionDetail.do?eventId=" + eventId;
	}
	
	@RequestMapping(value = "/collectionDetail2.do", method = RequestMethod.POST)
	public String ChangeUnPayment(int eventId, HttpServletRequest req, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		String[] memberss = req.getParameterValues("memberId2");
		for (int i = 0; i < memberss.length; i++) {
			event.setMemberId(memberss[i]);
		}
		eventService.changeUnPayment(event.getMemberId(), eventId);
		
		return "redirect:/event/collectionDetail.do?eventId=" + eventId;
	}

	@RequestMapping("/eventDetail.do")
	public String showEventDetail(int eventId, HttpServletRequest req, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		
		Group group = mgService.findGroupById(event.getGroupId());
		model.addAttribute("group", group);

		List<Member> members = mgService.findAllMembersByEvent(eventId);
		model.addAttribute("members", members);
		
		List<Member> memberss = mgService.findAllPaidMembers(event.getMemberId(), eventId);
		model.addAttribute("memberss", memberss);
		

		List<Record> records = recordService.findAllRecordsByEventId(eventId);
		model.addAttribute("records",records);

		return "event/eventDetail";
	}

	@RequestMapping("/event.do")
	public String showEvent(int eventId, int groupId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		Group group = mgService.findGroupById(groupId);
		model.addAttribute("group", group);

		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		List<Record> records=recordService.findAllRecordsByEventId(eventId);
		
		
	
		model.addAttribute("events", events);
		model.addAttribute("groupId", groupId);
		model.addAttribute("records",records);

		return "event/event";
	}
	
	@RequestMapping(value="/addEventBalanceToGroup.do",method=RequestMethod.GET)
	public String addEventBalanceToGroup(int eventId) {
		Event event= eventService.findEventById(eventId);
		Group group =mgService.findGroupById(event.getGroupId());
		System.out.println("이벤트이름"+event.getEventName());
		System.out.println("이벤트발란스:"+event.getBalance());
		double balance=group.getBalance()+event.getBalance();
		group.setBalance(balance);
		mgService.modifyGroupBalance(group);
		
		return "redirect:/memberGroup/group.do?groupId="+event.getGroupId();
	}
	

}
