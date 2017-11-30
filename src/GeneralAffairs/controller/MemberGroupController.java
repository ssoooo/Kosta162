package GeneralAffairs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.service.MemberGroupService;


@Controller
@RequestMapping("member") 
public class MemberGroupController {
	
	@Autowired
	private MemberGroupService msService; 
	
	
	@RequestMapping()
	public String showLoginForm() {
		
		return "";
	}
	
	@RequestMapping("login.do")
	public String login(Member member,HttpServletRequest req,Model model) {
		
		return "";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest req) {
		
		return "";
	}
	
	@RequestMapping(value = "modifyMember.do", method = RequestMethod.POST)
	public String modifyMember(Member member) {
		
		return "";
	}
	
	@RequestMapping(value = "modifyMember.do", method = RequestMethod.GET)
	public String showModifyMember(String memberId,Model model) {
		
		return "";
	}
	
	@RequestMapping("deleteMember.do")
	public String deleteMember(String memberId) {
		
		return "";
	}
	
	@RequestMapping(value = "tradeGrade.do", method = RequestMethod.POST)
	public String tradeGrade(String memberId,String managerId,int groupId) {
		
		return "";
	}
	
	@RequestMapping(value = "tradeGrade.do", method = RequestMethod.GET)
	public String showTradeGrade(int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("memberDetail.do")
	public String showMemberDetail(String memberId,Model model) {
		
		return "";
	}
	
	@RequestMapping("joinMemberAndSignIn.do")
	public String joinMemberAndReqSignInGroup(Member member,int groupId) {
		
		return "";
	}
	
	@RequestMapping("reqSignInAlreadyJoined.do")
	public String reqSignInGroupWhenAlreadyJoined(int groupId,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("denySignIn.do")
	public String denySignInGroupReq(String memberId,int groupId) {
		
		return "";
	}
	
	@RequestMapping("join.do")
	public String showJoinFrom() {
		
		return "";
	}
	
	@RequestMapping("allSignInGroupReq.do")
	public String showAllSignInGroupReq(int groupId,Model model) {
		
		return "";
	}
	
	///
	
	
	@RequestMapping(value = "registGroup.do", method = RequestMethod.POST)
	public String registGroup(Group group,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("registGroupAndJoinMember.do")
	public String registGroupAndJoinMember(Member member,Group group) {
		
		return "";
	}
	
	@RequestMapping(value = "registGroup.do", method = RequestMethod.GET)
	public String showRegistGroup(String memberId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "modifyGroup.do", method = RequestMethod.GET)
	public String modifyGroup(Group group) {
		
		return "";
	}
	
	@RequestMapping(value = "modifyGroup.do", method = RequestMethod.POST)
	public String showModifyGroup(int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("deleteGroup.do")
	public String deleteGroup(int groupId) {
		
		return "";
	}
	
	@RequestMapping("leaveGroup.do")
	public String leaveGroup(int groupId,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("kickMember.do")
	public String kickMemberFromGroup(String memberId,int groupId) {
		
		return "";
	}
	
	@RequestMapping("inviteMember.do")
	public String inviteMember(int groupId,String memberId,Model model) {
		
		return "";
	}
	
	@RequestMapping("acceptInvite.do")
	public String acceptInvite(String memberId,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("denyInvite.do")
	public String denyInvite(String memberId,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("myInvitations.do")
	public String showMyInvitations(String memberId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "searchMember.do", method = RequestMethod.POST)
	public String searchMember(String memberId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "searchMember.do", method = RequestMethod.GET)
	public String showSearchMember() {
		
		return "";
	}
	
	@RequestMapping("searchAllGroups.do")
	public String SearchAllGroups(String groupName,Model model) {
		
		return "";
	}
	
	@RequestMapping("main.do")
	public String showMain(HttpSession session,Model model) {
		
		return "";
	}
	
	@RequestMapping("group.do")
	public String showGroup(int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("groupDetail.do")
	public String showGroupDetail(int groupId,Model model) {
		
		return "";
	}
	

}
