package GeneralAffairs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.domain.Message;
import GeneralAffairs.service.MemberGroupService;
import GeneralAffairs.service.MessageService;

@Controller
@RequestMapping("memberGroup")
public class MemberGroupController {
	
	@Autowired
	private MemberGroupService mgService; 
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String showLoginForm() {
		
		return "redirect:/views/member/login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(String memberId, String userPassword, HttpServletRequest req, Model model) {
		
		Member member = new Member();
		member = mgService.findMemberById(memberId);
		if(member!=null && userPassword.equals(member.getPassword())){
		
		HttpSession session =req.getSession();
		session.setAttribute("loginedMemberId", member.getMemberId());	
		
		}else{
			HttpSession session = req.getSession();
			session.invalidate();
			return "redirect:/views/member/login.jsp";
		}
		
		return "redirect:/memberGroup/main.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/views/member/main.jsp";
	}
	
	@RequestMapping("/modifyMember.do")
	public String modifyMember(Member member) {
		
		return "";
	}
	
	@RequestMapping("/showModifyMember.do")
	public String showModifyMember(String memberId,Model model) {
		System.out.println(memberId);
		Member member = new Member();
		member = mgService.findMemberById(memberId);
		model.addAttribute("member", member);
		
		return "member/modifyMember";
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(String memberId) {
		
		return "";
	}
	
	@RequestMapping("/tradeGrade.do")
	public String tradeGrade(String memberId,String managerId,int groupId) {
		
		return "";
	}
	
	@RequestMapping("/showTradeGrade.do")
	public String showTradeGrade(int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value="/myDetail.do", method=RequestMethod.GET)
	public String showMyDetail(HttpSession session,Model model) {
		Member member = new Member();
		List<Group> list = new ArrayList<Group>();
		String myId = (String)session.getAttribute("loginedMemberId");
		list = mgService.findAllGroupsByMemberId(myId);
		
		member = mgService.findMemberById(myId);
		model.addAttribute("list", list);
		model.addAttribute("member", member);
		return "member/memberDetail";
	}	
	
	@RequestMapping("/memberDetail.do")
	public String showMemberDetail(String memberId,Model model) {
		Member member = new Member();
		mgService.findMemberById(memberId);
		return "";
	}
	
	@RequestMapping("/joinMemberAndSignIn.do")
	public String joinMemberAndReqSignInGroup(Member member,int groupId) {
		
		return "";
	}
	
	@RequestMapping("/reqSignInAlreadyJoined.do")
	public String reqSignInGroupWhenAlreadyJoined(int groupId,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("/denySignIn.do")
	public String denySignInGroupReq(String memberId,int groupId) {
		
		return "";
	}
	
	@RequestMapping("/join.do")
	public String showJoinFrom() {
		
		return "";
	}
	
	@RequestMapping("/allSignInGroupReq.do")
	public String showAllSignInGroupReq(int groupId,Model model) {
		
		return "";
	}
	
	///
	
	@RequestMapping("/registGroup.do")
	public String registGroup(Group group, HttpSession session, HttpServletRequest req) {
		
		group.setMemberId((String) session.getAttribute("loginedMemberId"));
		System.out.println("groupName:" + group.getGroupName());
		System.out.println("groupAccount:" + group.getAccount());
		System.out.println("groupIntroduce:" + group.getGroupIntroduce());
		
		return "redirect:/memberGroup/main.do";
	}
	
	@RequestMapping("/registGroupAndJoinMember.do")
	public String registGroupAndJoinMember(Member member,Group group) {
		
		return "";
	}
	
	@RequestMapping("/showRegistGroup.do")
	public String showRegistGroup(String memberId,Model model) {
		
		return "redirect:/views/group/registGroup.jsp";
	}
	
	@RequestMapping("/modifyGroup.do")
	public String modifyGroup(Group group) {
		
		return "";
	}
	
	@RequestMapping("/showModifyGroup.do")
	public String showModifyGroup(int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/deleteGroup.do")
	public String deleteGroup(int groupId) {
		
		return "";
	}
	
	@RequestMapping("/leaveGroup.do")
	public String leaveGroup(int groupId,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("/kickMember.do")
	public String kickMemberFromGroup(String memberId,int groupId) {
		
		return "";
	}
	
	@RequestMapping("/inviteMember.do")
	public String inviteMember(int groupId,String memberId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/acceptInvite.do")
	public String acceptInvite(String memberId,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/denyInvite.do")
	public String denyInvite(String memberId,int groupId,Model model) {
		
		return "";
	}
/*	
	@RequestMapping("/myInvitations.do")
	public String showMyInvitations(String memberId,Model model) {
		
		return "";
	}
*/
	@RequestMapping("/searchMember.do")
	public String searchMember(String memberId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/showSearchMember.do")
	public String showSearchMember() {
		
		return "";
	}
	
	@RequestMapping("/searchAllGroups.do")
	public String SearchAllGroups(HttpSession session, @RequestParam("groupNameInput") String groupName, Model model) {
		/*
		HttpServletRequest req 를 parameter로 받아올 경우 다음과 같이 가능
		List<Group> groups = mgService.findAllGroupsByGroupName(req.getParameter("groupNameInput"));
		 */		
		String memberId = (String) session.getAttribute("loginedMemberId");
		List<Group> groups = mgService.findAllGroupsByGroupName(groupName);
		List<Group> groupsInvited = mgService.findMyInvitationsByMemberId(memberId);
		
		model.addAttribute("groups", groups);
		model.addAttribute("groupsInvited", groupsInvited);
		model.addAttribute("groupName", groupName);

		return "group/searchGroup";
	}
	
	@RequestMapping("/main.do")
	public String showMain(HttpSession session, Model model) {
				
		String memberId = (String) session.getAttribute("loginedMemberId");
		List<Group> groups = mgService.findAllGroupsByMemberId(memberId);
		List<Group> groupsInvited = mgService.findMyInvitationsByMemberId(memberId);
		
		model.addAttribute("groupsInvited", groupsInvited);
		model.addAttribute("groups", groups);
		
		return "member/main";
	}
	
	@RequestMapping("/group.do")
	public String showGroup(int groupId, Model model) {
		Group group = mgService.findGroupById(groupId);
		List<Message> messages = messageService.findAllMyMessages("kang");
		
		model.addAttribute("group", group);
		model.addAttribute("messages", messages);
		
		return "group/group";
	}
	
	@RequestMapping("/groupDetail.do")
	public String showGroupDetail(int groupId, Model model) {
		Group group = mgService.findGroupById(groupId);
		List<Message> messages = messageService.findAllMyMessages("kang");
		List<Member> members = mgService.findAllMembersByGroup(groupId);
		Member manager = mgService.findMemberById(group.getMemberId());
		
		model.addAttribute("group", group);
		model.addAttribute("messages", messages);
		model.addAttribute("memberNum", members.size());
		model.addAttribute("members", members);
		model.addAttribute("manager", manager);
		
		return "group/groupDetail";
	}

}
