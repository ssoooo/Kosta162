package GeneralAffairs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import GeneralAffairs.domain.Comment;
import GeneralAffairs.domain.Record;
import GeneralAffairs.service.CommentService;
import GeneralAffairs.service.RecordService;

@Controller
@RequestMapping("comment")
public class CommentController{
	
	@Autowired
	private CommentService cService;
	
	@Autowired
	private RecordService rService;
	
	
	@RequestMapping(value="/commentRegist.do",method=RequestMethod.POST)
	public String registComment(Comment comment,int recordId,HttpSession session, Model model) {
		System.out.println(recordId);
		comment.setMemberId((String) session.getAttribute("loginedMemberId"));
		comment.setRecordId(recordId);
		cService.createComment(comment);
		
		
		return "redirect:/record/showRecordDetail.do?recordId="+recordId;
	}
	
	@RequestMapping(value="/commentModify.do",method=RequestMethod.POST)
	public String modifyComment(HttpSession session,Comment comment,Model model) {
		cService.modifyComment(comment);
		
		return "redirect:/record/showRecordDetail.do?recordId="+comment.getRecordId();
	}
	
	@RequestMapping("/commentDelete.do")
	public String deleteComment(int commentId,Model model) {
		Comment comment = cService.findCommentById(commentId);
		cService.removeComment(commentId);
		
		
		return "redirect:/record/showRecordDetail.do?recordId="+comment.getRecordId();
	}
	

}
