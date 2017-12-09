package GeneralAffairs.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import GeneralAffairs.domain.Comment;
import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Message;
import GeneralAffairs.domain.Record;
import GeneralAffairs.service.CommentService;
import GeneralAffairs.service.EventService;

import GeneralAffairs.service.MemberGroupService;
import GeneralAffairs.service.RecordService;

@Controller
@RequestMapping("record")
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private MemberGroupService mgService;
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value="/registGroupRecord.do",method=RequestMethod.POST)
	public String registGroupRecord(Record record,int groupId,HttpSession session, @RequestParam("imgFile") MultipartFile imgFile,Model model) {
		
		String myId = (String)session.getAttribute("loginedMemberId");
	    
		if(!imgFile.isEmpty()) {
			try {
				
				String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
			    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
			    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
			    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
				
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
				record.setImage("/images/" + rename);
				
			} catch (IOException e) {
				e.printStackTrace();
//				model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
			}
		} else {
//	        model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}
		
		record.setMemberId(myId);
		record.setEventId(0);
		recordService.createRecord(record);
		
		Group group = mgService.findGroupById(groupId);
		double groupBalance = group.getBalance();
		int price = record.getPrice();

		if(record.getAccounting().equals("지출")) {
			groupBalance = groupBalance - price;
			group.setBalance(groupBalance);
			mgService.modifyGroupBalance(group);
		} else {
			groupBalance = groupBalance + price;
			group.setBalance(groupBalance);
			mgService.modifyGroupBalance(group);
		}
		
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		model.addAttribute("events", events);
		
		return "redirect:/memberGroup/group.do?groupId="+record.getGroupId();
	}
	
	@RequestMapping(value="/registEventRecord.do",method=RequestMethod.POST)
	public String registEventRecord(Record record,int eventId,HttpSession session, @RequestParam("imgFile") MultipartFile imgFile,Model model) {
		
		String myId = (String)session.getAttribute("loginedMemberId");
		
		if(!imgFile.isEmpty()) {
			try {
				
				String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
			    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
			    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
			    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
				
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
				record.setImage("/images/" + rename);
				
			} catch (IOException e) {
				e.printStackTrace();
//				model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
			}
		} else {
//	        model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}
		
		
		record.setEventId(eventId);
		record.setMemberId(myId);
		recordService.createRecord(record);
		
		Event event = eventService.findEventById(eventId);
		double eventBalance=event.getBalance();
		int price = record.getPrice();
		
		if(record.getAccounting().equals("지출")) {
			eventBalance = eventBalance-price;
			event.setBalance(eventBalance);
			eventService.modifyEventBalance(event);
		} else {
			eventBalance = eventBalance+price;
			event.setBalance(eventBalance);
			eventService.modifyEventBalance(event);
		}
		
		return  "redirect:/event/event.do?eventId="+record.getEventId()+"&groupId="+record.getGroupId();
	}
	
	@RequestMapping("/deleteRecord.do")
	public String deleteGroupRecord(int recordId) {
		Record record = recordService.findRecordById(recordId);
		
		int price = record.getPrice();
		String recordAccounting = record.getAccounting();
		Group group =mgService.findGroupById(record.getGroupId());
		double groupBalance= group.getBalance();
		Event event =eventService.findEventById(record.getEventId());
		
		if(record.getEventId()==0) {
			
			if(record.getAccounting().equals("수입")) {
				group.setBalance(group.getBalance()-record.getPrice());
				mgService.modifyGroupBalance(group);
			}else {
				group.setBalance(group.getBalance()+record.getPrice());
				mgService.modifyGroupBalance(group);
			}
			
		} else {
			
			if(record.getAccounting().equals("수입")) {
				event.setBalance(event.getBalance()-record.getPrice());
				eventService.modifyEventBalance(event);
			}else {
				event.setBalance(group.getBalance()+record.getPrice());
				eventService.modifyEventBalance(event);
			}
			
		}
		
		recordService.removeRecord(recordId);
		return "redirect:/memberGroup/group.do?groupId="+record.getGroupId();
	}
	
	@RequestMapping(value="/modifyRecord.do",method=RequestMethod.POST)
	public String modifyGroupRecord(Record record,String pastAccounting,int pastPrice,HttpSession session, @RequestParam("imgFile") MultipartFile imgFile) {
		System.out.println("eventId:" + record.getEventId());
		System.out.println("groupId:" + record.getGroupId());
		System.out.println("recordId:" + record.getRecordId());
		System.out.println("getTitle:" + record.getTitle());
		System.out.println("content:" + record.getContent());
		System.out.println("price:" + record.getPrice());
		System.out.println("category:" + record.getCategory());
		System.out.println("accounting:" + record.getAccounting());
		
		if(!imgFile.isEmpty()) {
			
			String originalFilename = imgFile.getOriginalFilename(); // fileName.jpg
		    String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		    String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg
		    String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
			
		    record.setImage("/images/" + rename);
		}
		
//		record.setMemberId((String)session.getAttribute("loginedMemberId"));
		
//		if(record.getEventId()==0) {
//			
//			int price = record.getPrice();
//			Group group = mgService.findGroupById(record.getGroupId());
//			double groupBalance= group.getBalance();
//		
//			if(pastAccounting.equals("수입")) {
//				double incomeBalance=groupBalance-pastPrice;
//				group.setBalance(incomeBalance);
//				mgService.modifyGroupBalance(group);
//			} else {
//				double outlayBalance = groupBalance+pastPrice;
//				group.setBalance(outlayBalance);
//				mgService.modifyGroupBalance(group);
//			}
//		
//			recordService.modifyRecord(record);
//		
//			if(record.getAccounting().equals("지출")) {
//				groupBalance=groupBalance-price;
//				group.setBalance(groupBalance);
//				mgService.modifyGroupBalance(group);
//			} else {
//				groupBalance=groupBalance+price;
//				group.setBalance(groupBalance);
//				mgService.modifyGroupBalance(group);
//			}
//		}
		
		recordService.modifyRecord(record);
		
		return "redirect:/record/showRecordDetail.do?recordId="+record.getRecordId();
	}
	
	@RequestMapping("/showModifyRecord.do")
	public String modifyEventRecord(int recordId,Model model) {
		
		Record record=recordService.findRecordById(recordId);
		Group group = mgService.findGroupById(record.getGroupId());
		Event event;
		
		if(record.getEventId() != 0) {
			event = eventService.findEventById(record.getEventId());
			model.addAttribute("event", event);
		} else {
			model.addAttribute("event", null);
		}
		
		List<Event> events = eventService.findAllEventsByGroupId(record.getGroupId());
		int pastPrice = record.getPrice();
		String pastAccounting = record.getAccounting();
		String category = record.getCategory();
		
		model.addAttribute("group", group);
		model.addAttribute("events",events);
		model.addAttribute("record",record);
		model.addAttribute("pastPrice",pastPrice);
		model.addAttribute("pastAccounting",pastAccounting);
		model.addAttribute("category", category);
		
		return "record/modifyRecord";
	}
	
	@RequestMapping("/checkRecord.do")
	public String checkRecord(int recordId,Model model) {
		Record record=recordService.findRecordById(recordId);
		if(record.getCaution().equals("정상")) {
			record.setCaution("주의");
			recordService.modifyCaution(record);
		}else {
			record.setCaution("정상");
			recordService.modifyCaution(record);
		}
		model.addAttribute("record",record);
		if(record.getEventId()==0) {
			return "redirect:/memberGroup/group.do?groupId="+record.getGroupId();
		}else {
		return "redirect:/event/event.do?eventId="+record.getEventId()+"&groupId="+record.getGroupId();
		}
	}
	
	@RequestMapping("/showRegistGroupRecord.do")
	public String showRegistGroupRecord(HttpSession session,int groupId,Model model) {
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		
		model.addAttribute("events",events);
		Group group=mgService.findGroupById(groupId);
		model.addAttribute("memberId",session.getAttribute("memberId"));
		model.addAttribute("group",group);
		
		return "record/registRecord";
	}
	
	@RequestMapping("/showRegistEventRecord.do")
	public String showRegistEventRecord(HttpSession session,int eventId,Model model) {
		Event event = eventService.findEventById(eventId);
		List<Event> events=eventService.findAllEventsByGroupId(event.getGroupId());
		model.addAttribute("events",events);
		model.addAttribute("event",event);
		model.addAttribute("memberId",session.getAttribute("memberId"));
		model.addAttribute("groupId",event.getGroupId());
		
		return "record/registEventRecord";
	}
	
	@RequestMapping("/showRegistRecordByMessage.do")
	public String showRegistRecordByMessage(Message message,Model model) {
		
		return "";
	}
	
	@RequestMapping("/showRecordDetail.do")
	public String showRecordDetail(int recordId,Model model) {
		
		Record record = recordService.findRecordById(recordId);
		Group group = mgService.findGroupById(record.getGroupId());
		
		Event event;
		
		if(record.getEventId() != 0) {
			event = eventService.findEventById(record.getEventId());
			model.addAttribute("event", event);
		} else {
			model.addAttribute("event", null);
		}
		
		List<Comment> comments = commentService.findAllCommentsByRecordId(recordId);
		for (Comment comment : comments) {
			System.out.println(comment.getDate());
		}
		
		List<Event> events = eventService.findAllEventsByGroupId(record.getGroupId());
		
		model.addAttribute("group", group);
		model.addAttribute("record",record);
		model.addAttribute("comments",comments);
		model.addAttribute("events",events);
		return "record/recordDetail";
	}
	
	@RequestMapping("/eventStatsByPeriod.do")
	public String showEventStatsByPeriod(Date date,String accounting,int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/eventStatsByAccounting.do")
	public String showEventStatsByAccounting(String accounting,int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/eventStatsByCategory.do")
	public String showEventStatsByCategory(String category,String accounting,int eventId,Date date) {
		
		return "";
	}
	
	@RequestMapping("/groupStatsByAccounting.do")
	public String showGroupStatsByAccounting(String accounting,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/groupStatsByPeriod.do")
	public String showGroupStatsByPeriod(Date date,String accounting,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/groupStatsByCategory.do")
	public String showGroupStatsByCategory(String category,String accounting,int groupId,Date date) {
		
		return "";
	}
	
	@RequestMapping("/groupStatsByEvent.do")
	public String showGroupStatsByEvent(String accounting,Date date,int eventId) {
		
		return"";
	}
	
	@RequestMapping("/groupStats.do")
	public String groupStats(int groupId,Model model) {
		//그룹 전체 수입 지출
		int groupIncome = recordService.findGroupStatsRecordByAccounting(groupId,"수입"); 
		int groupOutlay= recordService.findGroupStatsRecordByAccounting(groupId,"지출");
		int groupBalance = groupIncome-groupOutlay;
		Group group = mgService.findGroupById(groupId);
		model.addAttribute("groupName",group.getGroupName());
		model.addAttribute("income",groupIncome);
		model.addAttribute("outlay",groupOutlay);
		model.addAttribute("groupBalance",groupBalance);
		
		//기간별
		LocalDate today = LocalDate.now();
		model.addAttribute("year0",LocalDate.now().getYear());
		model.addAttribute("year1",LocalDate.now().minusYears(1).getYear());
		model.addAttribute("year2",LocalDate.now().minusYears(2).getYear());
		model.addAttribute("year3",LocalDate.now().minusYears(3).getYear());
		model.addAttribute("year4",LocalDate.now().minusYears(4).getYear());
		
	
		System.out.println(LocalDate.now().minusYears(2).getYear());
		System.out.println(LocalDate.now().minusYears(3).getYear());
		System.out.println(LocalDate.now().minusYears(4).getYear());

		Date year_0_st= Date.valueOf(LocalDate.of(LocalDate.now().getYear(), 1, 1));
		Date year_0_fin= Date.valueOf(LocalDate.of(LocalDate.now().getYear(), 12, 31));
		Date year_1_st =Date.valueOf(LocalDate.of(LocalDate.now().getYear()-1, 1, 1));
		Date year_1_fin =Date.valueOf(LocalDate.of(LocalDate.now().getYear()-1,12,31));
		Date year_2_st =Date.valueOf(LocalDate.of(LocalDate.now().getYear()-2, 1, 1));
		Date year_2_fin =Date.valueOf(LocalDate.of(LocalDate.now().getYear()-2,12,31));
		Date year_3_st =Date.valueOf(LocalDate.of(LocalDate.now().getYear()-3, 1, 1));
		Date year_3_fin =Date.valueOf(LocalDate.of(LocalDate.now().getYear()-3,12,31));
		Date year_4_st =Date.valueOf(LocalDate.of(LocalDate.now().getYear()-4, 1, 1));
		Date year_4_fin =Date.valueOf(LocalDate.of(LocalDate.now().getYear()-4,12,31));
		//test2017/12/08
		
		Date month_0_st=Date.valueOf(LocalDate.now().minusMonths(0).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_0_fin=Date.valueOf(LocalDate.now().minusMonths(0).with(TemporalAdjusters.lastDayOfMonth()));
		
		
		Date month_1_st=Date.valueOf(LocalDate.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_1_fin=Date.valueOf(LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_2_st=Date.valueOf(LocalDate.now().minusMonths(2).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_2_fin=Date.valueOf(LocalDate.now().minusMonths(2).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_3_st=Date.valueOf(LocalDate.now().minusMonths(3).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_3_fin=Date.valueOf(LocalDate.now().minusMonths(3).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_4_st=Date.valueOf(LocalDate.now().minusMonths(4).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_4_fin=Date.valueOf(LocalDate.now().minusMonths(4).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_5_st=Date.valueOf(LocalDate.now().minusMonths(5).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_5_fin=Date.valueOf(LocalDate.now().minusMonths(5).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_6_st=Date.valueOf(LocalDate.now().minusMonths(6).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_6_fin=Date.valueOf(LocalDate.now().minusMonths(6).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_7_st=Date.valueOf(LocalDate.now().minusMonths(7).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_7_fin=Date.valueOf(LocalDate.now().minusMonths(7).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_8_st=Date.valueOf(LocalDate.now().minusMonths(8).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_8_fin=Date.valueOf(LocalDate.now().minusMonths(8).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_9_st=Date.valueOf(LocalDate.now().minusMonths(9).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_9_fin=Date.valueOf(LocalDate.now().minusMonths(9).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_10_st=Date.valueOf(LocalDate.now().minusMonths(10).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_10_fin=Date.valueOf(LocalDate.now().minusMonths(10).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_11_st=Date.valueOf(LocalDate.now().minusMonths(11).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_11_fin=Date.valueOf(LocalDate.now().minusMonths(11).with(TemporalAdjusters.lastDayOfMonth()));
		
		Date month_12_st=Date.valueOf(LocalDate.now().minusMonths(12).with(TemporalAdjusters.firstDayOfMonth()));
		Date month_12_fin=Date.valueOf(LocalDate.now().minusMonths(12).with(TemporalAdjusters.lastDayOfMonth()));
		
		int year_income_0 = recordService.findGroupAccountingResult("수입", groupId,year_0_st,year_0_fin);
		int year_outlay_0 = recordService.findGroupAccountingResult("지출", groupId,year_0_st,year_0_fin);
		
		int year_income_1 = recordService.findGroupAccountingResult("수입", groupId,year_1_st,year_1_fin);
		int year_outlay_1 = recordService.findGroupAccountingResult("지출", groupId,year_1_st,year_1_fin);
		
		int year_income_2 = recordService.findGroupAccountingResult("수입", groupId,year_2_st,year_2_fin);
		int year_outlay_2 = recordService.findGroupAccountingResult("지출", groupId,year_2_st,year_2_fin);

		int year_income_3 = recordService.findGroupAccountingResult("수입", groupId,year_3_st,year_3_fin);
		int year_outlay_3 = recordService.findGroupAccountingResult("지출", groupId,year_3_st,year_3_fin);
		
		int year_income_4 = recordService.findGroupAccountingResult("수입", groupId,year_4_st,year_4_fin);
		int year_outlay_4 = recordService.findGroupAccountingResult("지출", groupId,year_4_st,year_4_fin);
		
		//
		int month_income_0= recordService.findGroupAccountingResult("수입", groupId,month_0_st, month_0_fin);
		int month_outlay_0= recordService.findGroupAccountingResult("지출", groupId,month_0_st, month_0_fin);
		
		int month_income_1= recordService.findGroupAccountingResult("수입", groupId,month_1_st, month_1_fin);
		int month_outlay_1= recordService.findGroupAccountingResult("지출", groupId,month_1_st, month_1_fin);
	
		int month_income_2= recordService.findGroupAccountingResult("수입", groupId,month_2_st, month_2_fin);
		int month_outlay_2= recordService.findGroupAccountingResult("지출", groupId,month_2_st, month_2_fin);
		
		int month_income_3= recordService.findGroupAccountingResult("수입", groupId,month_3_st, month_3_fin);
		int month_outlay_3= recordService.findGroupAccountingResult("지출", groupId,month_3_st, month_3_fin);
		
		int month_income_4= recordService.findGroupAccountingResult("수입", groupId,month_4_st, month_4_fin);
		int month_outlay_4= recordService.findGroupAccountingResult("지출", groupId,month_4_st, month_4_fin);
		
		int month_income_5= recordService.findGroupAccountingResult("수입", groupId,month_5_st, month_5_fin);
		int month_outlay_5= recordService.findGroupAccountingResult("지출", groupId,month_5_st, month_5_fin);
		
		int month_income_6= recordService.findGroupAccountingResult("수입", groupId,month_6_st, month_6_fin);
		int month_outlay_6= recordService.findGroupAccountingResult("지출", groupId,month_6_st, month_6_fin);
		
		int month_income_7= recordService.findGroupAccountingResult("수입", groupId,month_7_st, month_7_fin);
		int month_outlay_7= recordService.findGroupAccountingResult("지출", groupId,month_7_st, month_7_fin);
		
		int month_income_8= recordService.findGroupAccountingResult("수입", groupId,month_8_st, month_8_fin);
		int month_outlay_8= recordService.findGroupAccountingResult("지출", groupId,month_8_st, month_8_fin);
		
		int month_income_9= recordService.findGroupAccountingResult("수입", groupId,month_9_st, month_9_fin);
		int month_outlay_9= recordService.findGroupAccountingResult("지출", groupId,month_9_st, month_9_fin);
		
		int month_income_10= recordService.findGroupAccountingResult("수입", groupId,month_10_st, month_10_fin);
		int month_outlay_10= recordService.findGroupAccountingResult("지출", groupId,month_10_st, month_10_fin);
		
		int month_income_11= recordService.findGroupAccountingResult("수입", groupId,month_11_st, month_11_fin);
		int month_outlay_11= recordService.findGroupAccountingResult("지출", groupId,month_11_st, month_11_fin);
		
		int month_income_12= recordService.findGroupAccountingResult("수입", groupId,month_12_st, month_12_fin);
		int month_outlay_12= recordService.findGroupAccountingResult("지출", groupId,month_12_st, month_12_fin);
		//
		model.addAttribute("year0Income",year_income_0);
		model.addAttribute("year0Outlay",year_outlay_0);
		
		model.addAttribute("year1Income",year_income_1);
		model.addAttribute("year1Outlay",year_outlay_1);
		
		model.addAttribute("year2Income",year_income_2);
		model.addAttribute("year2Outlay",year_outlay_2);
		
		model.addAttribute("year3Income",year_income_3);
		model.addAttribute("year3Outlay",year_outlay_3);
		
		model.addAttribute("year4Income",year_income_4);
		model.addAttribute("year4Outlay",year_outlay_4);
		//
		model.addAttribute("month0Income",month_income_0);
		model.addAttribute("month0Outlay",month_outlay_0);
		
		model.addAttribute("month1Income",month_income_1);
		model.addAttribute("month1Outlay",month_outlay_1);
		
		model.addAttribute("month2Income",month_income_2);
		model.addAttribute("month2Outlay",month_outlay_2);
		
		model.addAttribute("month3Income",month_income_3);
		model.addAttribute("month3Outlay",month_outlay_3);
		
		model.addAttribute("month4Income",month_income_4);
		model.addAttribute("month4Outlay",month_outlay_4);
		
		model.addAttribute("month5Income",month_income_5);
		model.addAttribute("month5Outlay",month_outlay_5);
		
		model.addAttribute("month6Income",month_income_6);
		model.addAttribute("month6Outlay",month_outlay_6);
		
		model.addAttribute("month7Income",month_income_7);
		model.addAttribute("month7Outlay",month_outlay_7);
		
		model.addAttribute("month8Income",month_income_8);
		model.addAttribute("month8Outlay",month_outlay_8);
		
		model.addAttribute("month9Income",month_income_9);
		model.addAttribute("month9Outlay",month_outlay_9);
		
		model.addAttribute("month10Income",month_income_10);
		model.addAttribute("month10Outlay",month_outlay_10);
		
		model.addAttribute("month11Income",month_income_11);
		model.addAttribute("month11Outlay",month_outlay_11);

		model.addAttribute("month12Income",month_income_12);
		model.addAttribute("month12Outlay",month_outlay_12);
		
		System.out.println("올해"+year_income_0);
		System.out.println("1년전"+year_income_1);
		System.out.println("2년전"+year_income_2);
		
		System.out.println(month_income_10);
		
		
		System.out.println(month_1_fin);
		System.out.println(month_2_fin);
		System.out.println(month_3_fin);
		System.out.println(month_4_fin);
		System.out.println(month_5_fin);
		System.out.println("test");
		System.out.println("이번달 수입:"+month_income_0);
		System.out.println("이번달 지출:"+month_outlay_0);
		System.out.println(month_income_1);
		System.out.println(month_income_2);
		System.out.println(month_income_3);
		System.out.println(month_income_4);
		System.out.println(month_income_5);
		System.out.println(month_income_6);
		System.out.println(month_income_7);
		System.out.println(month_income_8);
		System.out.println(month_income_9);
		
		
		//
		
		//카테고리별
		Integer foodIncome = recordService.findGroupStatsRecordByCategory("식비", "수입", groupId);
		Integer foodOutlay = recordService.findGroupStatsRecordByCategory("식비", "지출", groupId);
		
		Integer trafficIncome = recordService.findGroupStatsRecordByCategory("교통비", "수입", groupId);
		Integer trafficOutlay = recordService.findGroupStatsRecordByCategory("교통비", "지출", groupId);
		
		Integer needsIncome = recordService.findGroupStatsRecordByCategory("생필품", "수입", groupId);
		Integer needsOutlay = recordService.findGroupStatsRecordByCategory("생필품", "지출", groupId);
		
		Integer etcIncome = recordService.findGroupStatsRecordByCategory("기타", "수입", groupId);
		Integer etcOutlay = recordService.findGroupStatsRecordByCategory("기타", "지출", groupId);

		
		model.addAttribute("foodIncome",foodIncome);
		model.addAttribute("foodOutlay",foodOutlay);
		model.addAttribute("trafficIncome",trafficIncome);
		model.addAttribute("trafficOutlay",trafficOutlay);
		model.addAttribute("needsIncome",needsIncome);
		model.addAttribute("needsOutlay",needsOutlay);
		model.addAttribute("etcIncome",etcIncome);
		model.addAttribute("etcOutlay",etcOutlay);
		
		//이벤트별
		List<Event> events = eventService.findAllEventsByGroupId(groupId);
		

		model.addAttribute("events",events);
		

		
		return "group/groupStats";
	}
	
	@RequestMapping("/eventStats.do")
	public String eventStats(int eventId,Model model) {
		//이벤트전체수입지출
		int eventIncome = recordService.findEventStatsRecordByAccounting("수입",eventId);
		int eventOutlay = recordService.findEventStatsRecordByAccounting("지출",eventId);
		int eventBalance = eventIncome-eventOutlay;
		model.addAttribute("income",eventIncome);
		model.addAttribute("outlay",eventOutlay);
		model.addAttribute("eventBalance",eventBalance);
		
		//기간별
//		int thisTime = LocalDate.now().getYear();
//		String thisTimes= String.valueOf(thisTime);
		List<Date> years = new ArrayList<>();
		for(int i=0;i<4;i++) {
			Date thisTime=Date.valueOf(LocalDate.of(LocalDate.now().minusYears(i).getYear(),LocalDate.now().minusYears(i).getMonth(),LocalDate.now().minusYears(i).getDayOfMonth()));
			years.add(i,thisTime);
		}
		
		
//		Date thisTimes=Date.valueOf(LocalDate.of(LocalDate.now().minusYears(1).getYear(),LocalDate.now().minusYears(1).getMonth(),LocalDate.now().minusYears(1).getDayOfMonth()));
//		Date thisTimess=Date.valueOf(LocalDate.of(LocalDate.now().minusYears(2).getYear(),LocalDate.now().minusYears(2).getMonth(),LocalDate.now().minusYears(2).getDayOfMonth()));
//		Date thisTimesss=Date.valueOf(LocalDate.of(LocalDate.now().minusYears(3).getYear(),LocalDate.now().minusYears(3).getMonth(),LocalDate.now().minusYears(3).getDayOfMonth()));
//		Date thisTimessss=Date.valueOf(LocalDate.of(LocalDate.now().minusYears(4).getYear(),LocalDate.now().minusYears(4).getMonth(),LocalDate.now().minusYears(4).getDayOfMonth()));
		
		
		int yearIncome=recordService.findEventStatsRecordByYear("수입", years.get(0).toString().substring(0,4), eventId);
		int yearOutlay=recordService.findEventStatsRecordByYear("지출", years.get(0).toString().substring(0,4), eventId);
		model.addAttribute("thisTime",years.get(0).toString().substring(0,4));
		model.addAttribute("yearIncome",yearIncome);
		model.addAttribute("yearOutlay",yearOutlay);
		System.out.println(years.get(0));
		System.out.println(yearIncome);
		System.out.println(yearOutlay);
		
//		Calendar calssss = Calendar.getInstance();
//		calssss.add(calssss.YEAR, -4);
//		SimpleDateFormat beforeformat = new SimpleDateFormat("yyyymmdd");
//		SimpleDateFormat afterformat = new SimpleDateFormat("yyyy-mm-dd");
//		
//		String beforeYearssss = beforeformat.format(calssss.getTime()).substring(0,8);
//		java.util.Date datessss = null;
//		try {
//			datessss = beforeformat.parse(beforeYearssss);
//		}catch (ParseException e) {
//			e.printStackTrace();
//		}
//		String transDatessss =afterformat.format(datessss);
//		Date afterDatessss = Date.valueOf(transDatessss);
//		
////		Date thisTime = new Date(new java.util.Date().getTime());
//		System.out.println(afterDatessss);
		
		
		
		
		//카테고리별
		Integer foodIncome = recordService.findEventStatsRecordByCategory("식비", "수입", eventId);
		Integer foodOutlay = recordService.findEventStatsRecordByCategory("식비", "지출", eventId);
		
		Integer trafficIncome = recordService.findEventStatsRecordByCategory("교통비", "수입", eventId);
		Integer trafficOutlay = recordService.findEventStatsRecordByCategory("교통비", "지출", eventId);
		
		Integer needsIncome = recordService.findEventStatsRecordByCategory("생필품", "수입", eventId);
		Integer needsOutlay = recordService.findEventStatsRecordByCategory("생필품", "지출", eventId);
		
		Integer etcIncome = recordService.findEventStatsRecordByCategory("기타", "수입", eventId);
		Integer etcOutlay = recordService.findEventStatsRecordByCategory("기타", "지출", eventId);

		
		model.addAttribute("foodIncome",foodIncome);
		model.addAttribute("foodOutlay",foodOutlay);
		model.addAttribute("trafficIncome",trafficIncome);
		model.addAttribute("trafficOutlay",trafficOutlay);
		model.addAttribute("needsIncome",needsIncome);
		model.addAttribute("needsOutlay",needsOutlay);
		model.addAttribute("etcIncome",etcIncome);
		model.addAttribute("etcOutlay",etcOutlay);
		
		System.out.println(foodIncome);
		System.out.println(foodOutlay);
		System.out.println(trafficIncome);
		System.out.println(trafficOutlay);
		System.out.println(needsIncome);
		System.out.println(needsOutlay);
		System.out.println(etcIncome);
		System.out.println(etcOutlay);
		
		return "event/eventStats";
	}

}
