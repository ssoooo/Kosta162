package GeneralAffairs.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Member;
import GeneralAffairs.domain.Message;
import GeneralAffairs.domain.Record;
import GeneralAffairs.service.EventService;
import GeneralAffairs.service.MemberGroupService;
import GeneralAffairs.service.MessageService;
import GeneralAffairs.service.RecordService;

@Controller
@RequestMapping("memberGroup")
public class MemberGroupController {
	
	@Autowired
	private MemberGroupService mgService; 
	
	@Autowired
	private MessageService messageService;

	@Autowired
	private EventService eventService;
	
	@Autowired
	private RecordService recordService;
	
	@RequestMapping(value= "/memberList.do", method=RequestMethod.GET)
	public String showMemberListByGroup(int groupId, Model model) {
		List<Member> members = mgService.findAllMembersExceptManager(groupId);
		model.addAttribute("members", members);
		
		Group group = mgService.findGroupById(groupId);
		model.addAttribute("group", group);
		System.out.println("///////" + members.size());
		return "event/eventMember";
	}
	
	@RequestMapping(value= "/memberList.do", method=RequestMethod.POST)
	public String findMemberListByGroup(int groupId, String memberId, Model model) {
		Group group = mgService.findGroupById(groupId);
		model.addAttribute("group", group);
		
		List<Member> members = mgService.findAllMembersByGroup(groupId);
		model.addAttribute("members", members);

		return "redirect:/event/registEvent.do?memberId=" + memberId;
	}
	
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
		return "redirect:/views/member/login.jsp";

	}
	
	@RequestMapping("/modifyMember.do")
	public String modifyMember(Member member) {
		mgService.modifyMember(member);
		return "redirect:/memberGroup/myDetail.do";
	}
	
	@RequestMapping("/showModifyMember.do")
	public String showModifyMember(String memberId,Model model) {
		Member member = new Member();
		member = mgService.findMemberById(memberId);
		
		String account = member.getAccount();
		String phone = member.getPhoneNumber();
		
		int sep = account.indexOf("/");
		int sepP = phone.indexOf("/");
		
        String bank = account.substring(0, sep);
        String accountNum = account.substring(sep+1);
        String mobileCarrier = phone.substring(0, sepP);
        String phoneNum = phone.substring(sepP+1);
        
        model.addAttribute("member", member);
        model.addAttribute("mobileCarrier", mobileCarrier);
        model.addAttribute("phoneNum", phoneNum);
	    model.addAttribute("bank", bank);
	    model.addAttribute("accountNum", accountNum);
		return "member/modifyMember";
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(String memberId) {
		mgService.removeMember(memberId);
		return "redirect:/views/member/login.jsp";
	}
	
	@RequestMapping("/tradeGrade.do")
	public String tradeGrade(String managerId,String memberId,String grade1,String grade2,int groupId) {
		Group group = new Group();
		group = mgService.findGroupById(groupId);
		group.setMemberId(memberId);
		mgService.modifyGroup(group);
		mgService.tradeGrade(memberId, groupId, grade1);
		mgService.tradeGrade(managerId, groupId, grade2);
		System.out.println("매니저아이디 :"+managerId);
		return "redirect:/views/member/login.jsp";
	}
	
	@RequestMapping("/showTradeGrade.do")
	public String showTradeGrade(int groupId,String managerId, Model model) {
		List<Member> list = new ArrayList<Member>();
		List<Member> newList = new ArrayList<Member>();
		Group group = new Group();
		group = mgService.findGroupById(groupId);
		list = mgService.findAllMembersByGroup(groupId);
		for(int i=0; i<list.size(); i++){
			Member member = new Member();
			member = list.get(i);
			if(!member.getMemberId().equals(group.getMemberId())){
				newList.add(member);
			} 
		}
		model.addAttribute("group", group);
		model.addAttribute("managerId", managerId);
		
		model.addAttribute("memberList", newList);
		
		return "group/tradeGrade";
	}
	
	@RequestMapping(value="/myDetail.do", method=RequestMethod.GET)
	public String showMyDetail(HttpSession session,Model model) {
		Member member = new Member();
		List<Group> list = new ArrayList<Group>();
		String myId = (String)session.getAttribute("loginedMemberId");
		list = mgService.findAllGroupsByMemberId(myId);
		List<Group> groupsInvited = mgService.findMyInvitationsByMemberId(myId);
		member = mgService.findMemberById(myId);
		
		model.addAttribute("groupsInvited", groupsInvited);
		model.addAttribute("list", list);
		model.addAttribute("member", member);
		return "member/memberDetail";
	}	
	
	@RequestMapping("/memberDetail.do")
	public String showMemberDetail(String memberId,Model model) {
		Member member = new Member();
		List<Group> list = new ArrayList<Group>();
		list = mgService.findAllGroupsByMemberId(memberId);
		member = mgService.findMemberById(memberId);
		
		model.addAttribute("list", list);
		model.addAttribute("member", member);
		
		return "member/memberDetail";
	}
	
	@RequestMapping("/joinMemberAndSignIn.do")
	public String joinMemberAndReqSignInGroup(Member member,int groupId) {
		
		mgService.createMember(member);
		mgService.reqSignInGroup(member.getMemberId(), groupId);
		
		return "redirect:/views/member/login.jsp";
	}
	
	@RequestMapping("/reqSignInAlreadyJoined.do")
	public String reqSignInGroupWhenAlreadyJoined(int groupId,HttpSession session, Model model) {
		String myId = (String)session.getAttribute("loginedMemberId");
		mgService.reqSignInGroup(myId, groupId);
		
		
		return "redirect:/views/group/searchGroup.jsp";
	}
	
	@RequestMapping("/acceptSignIn.do")
	public String acceptSignInGroup(int groupId,String memberId, Model model) {
		
		mgService.createMemberToGroup(memberId, groupId);
		mgService.denySignInGroupReq(memberId, groupId);
		
		model.addAttribute("groupId", groupId);
		return "redirect:/views/group/groupDetail.jsp";
	}
	
	@RequestMapping("/denySignIn.do")
	public String denySignInGroupReq(int groupId,String memberId,Model model) {
		mgService.denySignInGroupReq(memberId, groupId);
		model.addAttribute("groupId", groupId);
		
		return "redirect:/views/group/groupDetail.jsp";
	}
	
	@RequestMapping("/join.do")
	public String showJoinFrom() {
		
		return "member/join.jsp";
	}
	
	@RequestMapping("/allSignInGroupReq.do")
	public String showAllSignInGroupReq(int groupId,Model model) {
		List<Member> list =mgService.findAllSignInGroupReq(groupId);
		model.addAttribute("data", list);
		System.out.println("돼고있나?"+list.size());
		System.out.println("돼고있나?그룹아이디"+groupId);
		return "member/reqSingInMemberByGroupId";
	}
	
	///
	
	@RequestMapping("/registGroup.do")
	public String registGroup(Group group, HttpSession session, @RequestParam("imgFile") MultipartFile imgFile, Model model) {
		
//		String currentPath = request.getSession().getServletContext().getRealPath("/");
//		String savePath = currentPath + "WebContent" + File.separator + "upload";
		String myId = (String)session.getAttribute("loginedMemberId");
		
		String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
	    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
	    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
	    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
		
		if(!imgFile.isEmpty()) {
			try {
				byte [] bytes = imgFile.getBytes();
				File dir = new File("c:\\" + File.separator + "tempFiles");
				
				if(!dir.exists()) {
					dir.mkdirs();
				}
				
				File saveFile = new File(dir.getAbsolutePath() + File.separator + rename);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(bytes);
				out.close();
				
//			    group.setGroupImage(dir.getAbsolutePath() + File.separator + rename);
				group.setGroupImage("/images/" + rename);

				
			} catch (IOException e) {
				e.printStackTrace();
//				model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
			}
		} else {
			
//			랜덤한 이미지 세팅
			group.setGroupImage("/images/" + rename);
			
//	        model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}
		
		group.setMemberId(myId);
		group.setBalance(0);
		
		mgService.createGroup(group);
		mgService.createManagerToGroup(myId, group.getGroupId());
		
//		model.addAttribute("resultMsg", "파일을 업로드 성공!");
		model.addAttribute("img", "/images/" + rename);
		
		return "redirect:/memberGroup/main.do";
	}
	
	@RequestMapping("/registGroupAndJoinMember.do")
	public String registGroupAndJoinMember(Member member,Group group, @RequestParam("imgFile")MultipartFile imgFile) {
		System.out.println(member.getAccount());
		String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
	    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
	    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
	    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
	    System.out.println(originalFilename);
		
		if(!imgFile.isEmpty()) {
			try {
				byte [] bytes = imgFile.getBytes();
				File dir = new File("c:\\" + File.separator + "tempFiles");
				
				if(!dir.exists()) {
					dir.mkdirs();
				}
				
				File saveFile = new File(dir.getAbsolutePath() + File.separator + rename);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(bytes);
				out.close();
				group.setGroupImage("/images/" + rename);
				
		mgService.createMember(member);
		mgService.createGroup(group);
		mgService.createManagerToGroup(member.getMemberId(), group.getGroupId());
//		model.addAttribute("img", "/images/" + rename);
		
		return "redirect:/views/member/login.jsp";
			} catch (IOException e) {
				e.printStackTrace();
//				model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
			}
		} else {
//	        model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}


		return "redirect:/views/member/login.jsp";
	}
	
	@RequestMapping("/showRegistGroup.do")
	public String showRegistGroup(String memberId,Model model) {
		
		return "redirect:/views/group/registGroup.jsp";
	}
	
	@RequestMapping("/modifyGroup.do")
	public String modifyGroup(Group group, HttpSession session, @RequestParam("imgFile") MultipartFile imgFile) {
		
		if(!imgFile.isEmpty()) {

			String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
		    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
		    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
		    
			group.setGroupImage("/images/" + rename);
		}

		group.setMemberId((String)session.getAttribute("loginedMemberId"));
		
		mgService.modifyGroup(group);
		
		return "redirect:/memberGroup/groupDetail.do?groupId=" + group.getGroupId();
	}
	
	@RequestMapping("/showModifyGroup.do")
	public String showModifyGroup(int groupId,Model model) {
		
		Group group = mgService.findGroupById(groupId);
		
		String account = group.getAccount();
		
		int sep = account.indexOf("/");
		
        String bank = account.substring(0, sep);
        String accountNum = account.substring(sep+1);
        
	    model.addAttribute("group", group);
	    model.addAttribute("bank", bank);
	    model.addAttribute("accountNum", accountNum);
		
		return "group/modifyGroup";
	}
	
	@RequestMapping("/deleteGroup.do")
	public String deleteGroup(int groupId) {
		
		mgService.removeGroup(groupId);	// removeFromGroup까지 됨
		
		return "redirect:/memberGroup/main.do";
	}
	
	@RequestMapping("/leaveGroup.do")
	public String leaveGroup(HttpSession session, int groupId) {
		
		String myId = (String)session.getAttribute("loginedMemberId");
		boolean checkMemberHasOtherGroup = mgService.leaveGroup(myId, groupId);
		
		if(checkMemberHasOtherGroup) {
			return "redirect:/memberGroup/main.do";
		} else {
			return "redirect:/views/member/login.jsp";
		}
	}
	
	@RequestMapping("/showKickMember.do")
	public String showGroupMembersForKick(HttpSession session, int groupId, Model model) {
		
		List<Member> members = mgService.findAllMembersByGroup(groupId);
		
		Group group = mgService.findGroupById(groupId);

		for(int i=0; i < members.size(); i++) {
			
			if(members.get(i).getMemberId().equals(group.getMemberId())) {
				members.remove(i);
			}
		}
		
		model.addAttribute("members", members);
		model.addAttribute("group", group);
		
		return "group/kickMember";
	}
	
	@RequestMapping("/kickMember.do")
	public String kickMemberFromGroup(String memberId,int groupId) {
		
		mgService.kickMember(memberId, groupId);
		
		return "redirect:/memberGroup/showKickMember.do?groupId=" + groupId;
	}
	
	@RequestMapping("/inviteMember.do")
	public String inviteMember(int groupId, String memberId, Model model) {
		
//		이미 초대한 경우 다시 초대하지 못하도록
		
		mgService.createInvite(memberId, groupId);
		
		return "redirect:/memberGroup/showSearchMember.do?groupId=" + groupId;
	}
	
	@RequestMapping("/acceptInvite.do")
	public String acceptInvite(HttpSession session, int groupId, Model model) {
		
		String myId = (String)session.getAttribute("loginedMemberId");
		
		mgService.acceptInvite(myId, groupId);
		
		List<Group> groupsInvited = mgService.findMyInvitationsByMemberId(myId);
		
		model.addAttribute("result", "success");
		
		return "member/main";
	}
	
	@RequestMapping("/denyInvite.do")
	public void denyInvite(String memberId,int groupId,Model model) {
		
		mgService.deleteInvite(memberId, groupId);
		
//		return "member/main"; // 처리한 화면으로... ajax필요!
	}
/*	
	@RequestMapping("/myInvitations.do")
	public String showMyInvitations(String memberId,Model model) {
		
		return "";
	}
*/
	@RequestMapping("/searchMember.do")
	public String searchMember(String memberId, int groupId, Model model) {
		
		Member member = mgService.findMemberById(memberId);
		Group group = mgService.findGroupById(groupId);
		List<Member> groupMembers = mgService.findAllMembersByGroup(groupId);
		
		boolean isGroupMember = false;
		
		for(Member groupMember: groupMembers) {
			if(groupMember.getMemberId().equals(memberId)) {
				isGroupMember = true;
			}
		}
		
		model.addAttribute("isGroupMember", isGroupMember);
		model.addAttribute("member", member);
		model.addAttribute("group", group);
		model.addAttribute("groupMembers", groupMembers);
		
		return "group/inviteMember";
	}

	@RequestMapping("/showSearchMember.do")
	public String showSearchMember(int groupId, Model model) {
		
		Group group = mgService.findGroupById(groupId);
		
		model.addAttribute("group", group);
		
		return "group/searchMember";
	}
	
	@RequestMapping("/searchGroupsByGroupName.do")
	public String SearchGroupsByGroupName(String groupName, Model model){
		
		List<Group> groupList = mgService.findAllGroupsByGroupName(groupName);
		
		model.addAttribute("groupList", groupList);
		return"member/selectGroup";
	}
	
	@RequestMapping("/searchAllGroups.do")
	public String SearchAllGroups(HttpSession session, @RequestParam("groupNameInput") String groupName, Model model) {
		
		String myId = (String) session.getAttribute("loginedMemberId");

		List<Group> groupsInvited = mgService.findMyInvitationsByMemberId(myId);
        
		List<Group> myGroups = mgService.findAllGroupsByMemberId(myId);
		List<Group> allGroups = mgService.findAllGroupsByGroupName(groupName);
		
//	    copy1은 for 교집합, copy2는 for 차집합
		
		List<Integer> myGroupsCopy1 = new ArrayList<Integer>();
		 
		for(Group group: myGroups) {
			myGroupsCopy1.add(group.getGroupId());
		}
		 
	    List<Integer> myGroupsCopy2 = new ArrayList<Integer>();
	    myGroupsCopy2.addAll(myGroupsCopy1);
	         
//	    copy1은 for 교집합, copy2는 for 차집합
	    
	    List<Integer> searchGroupsCopy1 = new ArrayList<Integer>();
	        
		for(Group group: allGroups) {
			searchGroupsCopy1.add(group.getGroupId());
		}
			 
		List<Integer> searchGroupsCopy2 = new ArrayList<Integer>();
		searchGroupsCopy2.addAll(searchGroupsCopy1);


		searchGroupsCopy1.retainAll(myGroupsCopy1);	// intersect
	    searchGroupsCopy2.removeAll(myGroupsCopy2);	// difference
	    
	    List<Group> onlyMyGroups = new ArrayList<>();
	    List<Group> otherGroups = new ArrayList<>();
	    
// 		intersect 결과
	    for (Integer groupIdsByIntersect : searchGroupsCopy1) {
	    	onlyMyGroups.add(mgService.findGroupById(groupIdsByIntersect));
	    }
	    
//	    difference 결과
	    for (Integer groupNamesByDifference : searchGroupsCopy2) {
	    	otherGroups.add(mgService.findGroupById(groupNamesByDifference));
	    }
	    
        if(otherGroups.size() > 0) {
            if(onlyMyGroups.size() > 0) {
            	model.addAttribute("otherGroups", otherGroups);
            	model.addAttribute("myGroups", onlyMyGroups);
            } else {
            	model.addAttribute("otherGroups", otherGroups);
            	model.addAttribute("myGroups", null);
            }
        } else {
        	 if(onlyMyGroups.size() > 0) {
             	model.addAttribute("otherGroups", null);
             	model.addAttribute("myGroups", onlyMyGroups);
             } else {
             	model.addAttribute("otherGroups", null);
             	model.addAttribute("myGroups", null);
             }
        }
        
		model.addAttribute("groupsInvited", groupsInvited);
		model.addAttribute("groupName", groupName);

		return "group/searchGroup";
	}
	
	@RequestMapping("/main.do")
	public String showMain(HttpSession session, Model model) {
				
		String myId = (String) session.getAttribute("loginedMemberId");
		List<Group> groups = mgService.findAllGroupsByMemberId(myId);
		List<Group> groupsInvited = mgService.findMyInvitationsByMemberId(myId);
		
		model.addAttribute("groupsInvited", groupsInvited);
		model.addAttribute("groups", groups);
		
		return "member/main";
	}
	
	@RequestMapping("/group.do")
	public String showGroup(HttpSession session, int groupId, Model model) {
		
		String myId = (String) session.getAttribute("loginedMemberId");
		
		Group group = mgService.findGroupById(groupId);	
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		List<Message> messages = messageService.findAllMyMessages(myId, groupId);
		List<Record> records = recordService.findAllRecordsByGroupId(groupId);

		
		model.addAttribute("events", events);
		model.addAttribute("group", group);
		model.addAttribute("messages", messages);
		model.addAttribute("groupId", groupId);
		model.addAttribute("records",records);
		
		return "group/group";
	}
	
	@RequestMapping("/groupDetail.do")
	public String showGroupDetail(HttpSession session, int groupId, Model model) {
		
		String myId = (String) session.getAttribute("loginedMemberId");
		
		Group group = mgService.findGroupById(groupId);
		List<Member> signIns = mgService.findAllSignInGroupReq(groupId);
		List<Message> messages = messageService.findAllMyMessages(myId, groupId);
		List<Member> members = mgService.findAllMembersByGroup(groupId);
		Member manager = mgService.findMemberById(group.getMemberId());
		
		
		model.addAttribute("group", group);
		model.addAttribute("signIns", signIns);
		model.addAttribute("memberNum", members.size());
		model.addAttribute("members", members);
		model.addAttribute("manager", manager);
		model.addAttribute("messages", messages);
		
		return "group/groupDetail";
	}

}