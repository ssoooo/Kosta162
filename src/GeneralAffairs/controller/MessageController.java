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
	
	@RequestMapping("sendCollection.do")
	public String sendCollectionMessage(HttpServletRequest req, List<String> receivedMember, Message message) {
//		모금액
		return "";
	}
	
	@RequestMapping("sendStats.do")
	public String sendStatsMessage(HttpServletRequest req, List<String> receivedMember, Message message) {
//		url 담아주기
		return "";
	}
	
	@RequestMapping("deleteMyMessage.do")
	public String deleteMyMessage(int messageId, HttpSession session) {
		
		messageService.removeMessage(messageId);
		
		return "";
		
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
