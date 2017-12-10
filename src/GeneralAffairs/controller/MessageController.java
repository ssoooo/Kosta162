package GeneralAffairs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Message;
import GeneralAffairs.domain.Record;
import GeneralAffairs.service.EventService;
import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.domain.Message;
import GeneralAffairs.service.EventService;
import org.springframework.web.bind.annotation.ResponseBody;
import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Message;
import GeneralAffairs.service.EventService;
import GeneralAffairs.service.MemberGroupService;
import GeneralAffairs.service.MessageService;
import GeneralAffairs.service.RecordService;

@Controller
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MemberGroupService mgService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private RecordService recordService;
	
	@RequestMapping(value = "/sendCollection.do", method = RequestMethod.GET) 
	public String showSendCollectionMessage(HttpServletRequest req, String memberId, int eventId, Message message, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		
		List<Member> members = mgService.findAllMembersByEvent(eventId);
		model.addAttribute("members", members);
		
		List<Member> memberss= mgService.findAllUnPaidMembers(event.getMemberId(), event.getEventId());
		model.addAttribute("memberss", memberss);
		
		return "message/writeMessage";
	}
	
	@RequestMapping(value = "/sendCollection.do", method = RequestMethod.POST) 
	public String sendCollectionMessage(HttpSession session,HttpServletRequest req, Message message, int eventId, Model model) {
		Event event = eventService.findEventById(eventId);
		model.addAttribute("event", event);
		message.setSendMemberId((String) session.getAttribute("loginedMemberId"));
		message.setGroupId(event.getGroupId());
//		String[] members = req.getParameterValues("memberId3");
//		for (int i = 0; i < members.length; i++) {
//			message.setMemberId(members[i]);
//		}
		String members = req.getParameter("memberId3");
		event.setMemberId(members);
		
		messageService.createMessage(message);
		messageService.sendMessage(event.getMemberId(), message.getMessageId(), message.getSendMemberId());
		
		return "redirect:/message/receivedMessage.do?messageId=" + message.getMessageId() + "&groupId=" + message.getGroupId();
	}
	
	@RequestMapping("/messageDetail.do")
	public String showMessageDetail(int messageId, HttpServletRequest req, Model model) {
		Message message = messageService.findMessageById(messageId);
		model.addAttribute("message", message);
		
		Message messages = messageService.findSendedMessageById(messageId);
		model.addAttribute("messages", messages);
		
		Event event = eventService.findEventById(message.getEventId());
		model.addAttribute("event", event);
		
		Group group = mgService.findGroupById(message.getGroupId());
		model.addAttribute("group", group);
		
		return "message/messageDetail2";
	}
	
	
	@RequestMapping("sendStats.do")
	public String sendStatsMessage(HttpServletRequest req, List<String> receivedMember, Message message) {
//		url 담아주기
		return "";
	}
	
	@ResponseBody
	@RequestMapping("deleteMyMessage.do")
	public String deleteMyMessage(int messageId, String myId) {
		System.out.println("메세지아이디"+messageId);
		System.out.println("내아이디"+myId);
		messageService.removeMyMessage(myId, messageId);
		
		return "success";
	}
	
//	@RequestMapping("sendMessage.do")
//	public String showSendMessage(HttpSession session,List<String> receivedMember, Model model) {
//		
//		return "";
//	}
	
	@RequestMapping("receivedMessage.do")
	public String showReceivedMessage(int messageId, int groupId, Record record, Model model) {
		
		Message message= messageService.findMessageById(messageId);
		Group group = mgService.findGroupById(groupId);
		
		Message messages = messageService.findSendedMessageById(messageId);
		model.addAttribute("messages", messages);
		
		Event event = eventService.findEventById(message.getEventId());
		
		model.addAttribute("message", message);
		model.addAttribute("group", group);
		model.addAttribute("event", event);
		
		if(event!=null) {
			model.addAttribute("event", event);
		} else {
			model.addAttribute("event", null);
		}
		
		return "message/messageDetail";
	}
	
	@RequestMapping("registMessageRecord.do")
	public String moveToRegistEventRecord(int messageId, Model model) {
		
		Message message = messageService.findMessageById(messageId);
		Event event = eventService.findEventById(message.getEventId());
		Group group = mgService.findGroupById(event.getGroupId());
		
		model.addAttribute("event", event);
		model.addAttribute("group", group);
		model.addAttribute("message", message);
		
		return "record/registMessageRecord";
	}

/*	
	@RequestMapping(value="allMyMessages.do", method=RequestMethod.GET)
	public String showAllMyMessage(HttpSession session, Model model) {
		
		String myId = (String)session.getAttribute("loginedMemberId");
		
		List<Message> messages = messageService.findAllMyMessages(myId);
		
		System.out.println(messages.size());
		
		return "group/group";
	}
*/
	
	}
