package GeneralAffairs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		System.out.println("레코드아이디"+recordId);
		comment.setMemberId((String) session.getAttribute("loginedMemberId"));
		comment.setRecordId(recordId);
		cService.createComment(comment);
		
		
		return "redirect:/record/showRecordDetail.do?recordId="+recordId;
	}
	@ResponseBody
	@RequestMapping(value="/commentModify.do",method=RequestMethod.POST)
	public String modifyComment(HttpSession session, Comment comment,Model model) {
		System.out.println("커맨트 = "+comment);
		System.out.println("커맨트아이디="+comment.getCommentId());
		System.out.println("커멘트내용 = "+comment.getContent());
		System.out.println("커맨트레코드아이디"+comment.getRecordId());
		String original = comment.getContent();
		cService.modifyComment(comment);
		String change = comment.getContent();
		if(original.equals(change)){
			return "success";	
		} else{
			return "fail";
		}
		
//		return "redirect:/record/showRecordDetail.do?recordId="+comment.getRecordId();
	}
	
	@RequestMapping("/commentDelete.do")
	public String deleteComment(int commentId,Model model) {
		Comment comment = cService.findCommentById(commentId);
		cService.removeComment(commentId);
		
		
		return "redirect:/record/showRecordDetail.do?recordId="+comment.getRecordId();
	}
	

}
