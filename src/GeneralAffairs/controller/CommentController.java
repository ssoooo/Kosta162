package GeneralAffairs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import GeneralAffairs.domain.Comment;
import GeneralAffairs.service.CommentService;

@Controller
public class CommentController{
	
	@Autowired
	private CommentService service;
	
	
	@RequestMapping("/commentRegist.do")
	public String registComment(Comment comment,Model model) {
		
		return "minji2.jsp";
	}
	
	@RequestMapping("/commentModify.do")
	public String modifyComment(Comment comment,Model model) {
		
		return "";
	}
	
	@RequestMapping("/commentDelete.do")
	public String deleteComment(int commentId,Model model) {
		
		return "";
	}
	

}
