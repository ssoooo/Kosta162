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
		
		Record record = new Record();
		
		record.setEventId(event.getEventId());
		record.setGroupId(event.getGroupId());
		record.setMemberId(event.getMemberId());
		record.setImage("none");
		record.setTitle("지원금)"+event.getEventName());
		record.setContent("모임"+event.getGroupId()+"의 지원금입니다.");
		record.setCategory("지원금");
		record.setPrice((int)event.getGroupSupport());
		record.setCaution("정상");
		record.setAccounting("수입");
		recordService.createRecord(record);
		
		event.setBalance(record.getPrice());
		eventService.modifyEventBalance(event);
		
		record.setEventId(0);
		record.setGroupId(event.getGroupId());
		record.setMemberId(event.getMemberId());
		record.setImage("none");
		record.setTitle("지원금)"+event.getEventName());
		record.setContent("이벤트"+event.getEventName()+"의 지원금으로 지출되었습니다.");
		record.setCategory("지원금");
		record.setPrice((int)event.getGroupSupport());
		record.setCaution("정상");
		record.setAccounting("지출");
		recordService.createRecord(record);
		Group groups=new Group();
		groups =mgService.findGroupById(event.getGroupId());
		double balance= groups.getBalance()-event.getBalance();
		groups.setBalance(balance);
		mgService.modifyGroupBalance(groups);
		
		
//		Record record = new Record();
//		record.setEventId(0);
//		record.setGroupId(group.getGroupId());
//		record.setMemberId(event.getMemberId());
//		record.setImage("none");
//		record.setTitle("이)"+event.getEventName());
//		record.setContent("이벤트 "+event.getEventName()+"의 합산결과");
//		record.setCategory("이벤트");
//		record.setPrice((int)event.getBalance());
//		record.setAccounting("정상");
//		recordService.createRecord(record);
		
		Group group = mgService.findGroupById(event.getGroupId());

		String[] members = req.getParameterValues("get");
		for (int i = 0; i < members.length; i++) {
			group.setMemberId(members[i]);
			
		}

		model.addAttribute("event", event);
		model.addAttribute("group", group);
		eventService.addMemberToEvent(event.getMemberId(), event.getEventId());
		eventService.addMemberToEvent(group.getMemberId(), event.getEventId());

		return "redirect:/event/event.do?eventId=" + event.getEventId() + "&groupId=" + group.getGroupId();
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
	public String modifyEvent(Event event,double groupSupports, HttpServletRequest req, Model model) {
		eventService.modifyEvent(event);
		double suportBalance=groupSupports-event.getGroupSupport();

		
		
		
		
			Group gro = mgService.findGroupById(event.getGroupId());
			gro.setBalance(gro.getBalance()+suportBalance);
			mgService.modifyGroupBalance(gro);
			Record record=	recordService.findRecordByTitle("지원금)"+event.getEventName(),0);
			int priceModify=(int) (record.getPrice()-suportBalance); 
			record.setPrice(priceModify);
			record.setCategory("이벤트");
			recordService.modifyPrice(record);
		
		 
			Event eve = eventService.findEventById(event.getEventId());
			eve.setBalance(eve.getBalance()-suportBalance);
			eventService.modifyEventBalance(eve);
			Record records = recordService.findRecordByTitle("지원금)"+eve.getEventName(),eve.getEventId());
			records.setPrice((int) (records.getPrice()-suportBalance));
			records.setCategory("이벤트");
			recordService.modifyPrice(records);
		
		
		
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
		double groupSupports=event.getGroupSupport();
		model.addAttribute("groupSupports",groupSupports);
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
		model.addAttribute("group", group);

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

	// @RequestMapping("/addEventBalance.do")
	// public String addEventBalanceToGroupBalance(int eventId) {
	// Event event = eventService.findEventById(eventId);
	// eventService.addEventBalanceToGroupBalance(eventId, event.getGroupId());
	//
	// return "memberGroup/group";
	// }

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
	public String ChangePayment(int eventId, HttpServletRequest req, Model model, String memberId) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);

		String member = req.getParameter("memberId");
		// for (int i = 0; i < members.length(); i++) {
		// event.setMemberId(members);
		// }
		event.setMemberId(member);
		eventService.changePayment(event.getMemberId(), eventId);

		return "redirect:/event/collectionDetail.do?eventId=" + eventId;
	}

	@RequestMapping(value = "/collectionDetail2.do", method = RequestMethod.POST)
	public String ChangeUnPayment(int eventId, HttpServletRequest req, Model model, String memberId) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		System.out.println("멤버아이디체크" + memberId);
		String memberss = req.getParameter("memberId2");

		eventService.changeUnPayment(memberId, eventId);
		System.out.println("?//" + event.getMemberId());

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
		model.addAttribute("records", records);

		return "event/eventDetail";
	}

	@RequestMapping("/event.do")
	public String showEvent(int eventId, int groupId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		Group group = mgService.findGroupById(groupId);
		model.addAttribute("group", group);

		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		List<Record> records = recordService.findAllRecordsByEventId(eventId);

		model.addAttribute("events", events);
		model.addAttribute("groupId", groupId);
		model.addAttribute("records", records);

		return "event/event";
	}

	@RequestMapping(value = "/addEventBalanceToGroup.do", method = RequestMethod.GET)
	public String addEventBalanceToGroup(int eventId) {
<<<<<<< HEAD
		Event event = eventService.findEventById(eventId);
		Group group = mgService.findGroupById(event.getGroupId());
		System.out.println("이벤트이름" + event.getEventName());
		System.out.println("이벤트발란스:" + event.getBalance());
		double balance = group.getBalance() + event.getBalance();
		group.setBalance(balance);
		mgService.modifyGroupBalance(group);

		return "redirect:/memberGroup/group.do?groupId=" + event.getGroupId();
=======
		
		
		Event event= eventService.findEventById(eventId);
		Group group =mgService.findGroupById(event.getGroupId());
		Record checkRecord= recordService.findRecordByTitleAndCategory("합산)"+event.getEventName());
		double balance=group.getBalance()+event.getBalance();
		
		if(checkRecord==null) {
			
			
			Record record = new Record();
			record.setEventId(0);
			record.setGroupId(group.getGroupId());
			record.setMemberId(event.getMemberId());
			record.setImage("none");
			record.setTitle("합산)"+event.getEventName());
			record.setContent("이벤트 "+event.getEventName()+"의 합산결과");
			record.setCategory("이벤트합산");
			
			if(event.getBalance()<0) {
				record.setAccounting("지출");
				record.setPrice(Math.abs((int)event.getBalance()));
			}else {
			record.setAccounting("수입");
			record.setPrice((int)event.getBalance());
			}
			recordService.createRecord(record);
			group.setBalance(balance);
			mgService.modifyGroupBalance(group);
			
		}else {
			
			double nextBalance =checkRecord.getPrice()-event.getBalance();
			group.setBalance(group.getBalance()-nextBalance);
			mgService.modifyGroupBalance(group);
			if(event.getBalance()<0) {
			checkRecord.setPrice(Math.abs((int) event.getBalance()));
			checkRecord.setAccounting("지출");
			}else {
				checkRecord.setPrice((int) event.getBalance());
				checkRecord.setAccounting("수입");
			}
			
			recordService.modifyPrice(checkRecord);
			
		}
	
		
		
		return "redirect:/memberGroup/group.do?groupId="+event.getGroupId();
>>>>>>> 8ba14b1a394c8eb247ac311a8415f8209e74d58c
	}

}
