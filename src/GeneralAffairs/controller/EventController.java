package GeneralAffairs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import GeneralAffairs.domain.Event;
import GeneralAffairs.service.EventService;
import GeneralAffairs.service.GroupService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private GroupService groupService;
	
	
	@RequestMapping("/eventRegist.do")
	public String registEvent(Event event,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("/eventRegist.do")
	public String showRegistEvent(HttpSession session,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/eventModify.do")
	public String modifyEvent(Event event) {
		
		return "";
	}
	
	@RequestMapping("/eventModify.do")
	public String showModifyEvent(int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/eventDelete.do")
	public String deleteEvent(int eventId) {
		
		return "";
	}
	
	@RequestMapping("/addMemberToEvnt.do")
	public String addMemberToEvent(String memberId) {
		
		return "";
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
	public String changePayment(int eventId,String memberId) {
		
		return "";
	}
	
	@RequestMapping("/eventDetail.do")
	public String showEventDetail(int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/event.do")
	public String showEvent(int eventId,Model model) {
		
		return "";
	}
	
}
