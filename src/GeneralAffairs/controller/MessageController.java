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
import GeneralAffairs.domain.Message;
import GeneralAffairs.service.EventService;
import org.springframework.web.bind.annotation.ResponseBody;
import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Message;
import GeneralAffairs.service.EventService;
import GeneralAffairs.service.MemberGroupService;
import GeneralAffairs.service.MessageService;

@Controller
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MemberGroupService mgService;
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/sendCollection.do", method = RequestMethod.GET) 
	public String showSendCollectionMessage(HttpServletRequest req, String receivedMember, Message message, Model model) {

		
		return "";
	}
	
	@RequestMapping(value = "/sendCollection.do", method = RequestMethod.POST) 
	public String sendCollectionMessage(HttpServletRequest req, @RequestBody List<String> receivedMember, Message message, Model model) {
//		HttpSession session =req.getSession();
//		session.setAttribute("loginedMemberId", message.getMemberId());	
		messageService.createMessage(message);
		
		model.addAttribute("message", message);
		
		System.out.println(receivedMember);


		return "";
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
	
	@RequestMapping("sendMessage.do")
	public String showSendMessage(HttpSession session,List<String> receivedMember, Model model) {
		
		return "";
	}
	
	@RequestMapping("receivedMessage.do")
	public String showReceivedMessage(int messageId, int groupId, Model model) {
		
		Message message= messageService.findMessageById(messageId);
		Group group = mgService.findGroupById(groupId);

		Event event = eventService.findEventById(message.getEventId());
		
		model.addAttribute("message", message);
		model.addAttribute("group", group);
		
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
