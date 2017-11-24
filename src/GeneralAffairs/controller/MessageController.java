package GeneralAffairs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import GeneralAffairs.domain.Message;
import GeneralAffairs.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService service;

	
	@RequestMapping("/sendCollection.do")
	public String sendCollectionMessage(HttpServletRequest req,List<String> receivedMember,Message message) {
		
		return "";
	}
	
	@RequestMapping("/sendStats.do")
	public String sendStatsMessage(HttpServletRequest req,List<String> receivedMember,Message message) {
		
		return "";
	}
	
	@RequestMapping("/deleteMyMessage.do")
	public String deleteMyMessage(int messageId,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("/sendMessage.do")
	public String showSendMessage(HttpSession session,List<String> receivedMember,Model model) {
		
		return "";
	}
	
	@RequestMapping("/receivedMessage.do")
	public String showReceivedMessage(Message message,Model model) {
		
		return "";
	}
	
	@RequestMapping("/allMyMessage.do")
	public String showAllMyMessage(HttpSession session,Model model) {
		
		return "";
	}
}
