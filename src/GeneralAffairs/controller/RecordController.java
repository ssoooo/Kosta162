package GeneralAffairs.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import GeneralAffairs.domain.Event;
import GeneralAffairs.domain.Message;
import GeneralAffairs.domain.Record;
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
	private MemberGroupService msService;
	
	
	@RequestMapping(value="/registGroupRecord.do",method=RequestMethod.POST)
	public String registGroupRecord(Record record,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("/registEventRecord.do")
	public String registEventRecord(Record record,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("/deleteGroupRecord.do")
	public String deleteGroupRecord(int recordId,int groupId) {
		
		return "";
	}
	
	@RequestMapping("/deleteEventRecord.do")
	public String deleteEventRecord(int recordId,int eventId) {
		
		return "";
	}
	
	@RequestMapping("/modifyGroupRecord.do")
	public String modifyGroupRecord(Record record) {
		
		return "";
	}
	
	@RequestMapping("/modifyEventRecord.do")
	public String modifyEventRecord(Record record) {
		
		return "";
	}
	
	@RequestMapping("/checkRecord.do")
	public String checkRecord(Record record) {
		
		return "";
	}
	
	@RequestMapping("/showRegistGroupRecord.do")
	public String showRegistGroupRecord(int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/showRegistEventRecord.do")
	public String showRegistEventRecord(int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/showRegistRecordByMessage.do")
	public String showRegistRecordByMessage(Message message,Model model) {
		
		return "";
	}
	
	@RequestMapping("/showRecordDetail.do")
	public String showRecordDetail(int recordId,Model model) {
		
		return"";
	}
	
	@RequestMapping("/showModifyEventRecord.do")
	public String showModifyEventRecord(int recordId,int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping("/showModifyGroupRecord.do")
	public String showModifyGroupRecord(int recordId,int groupId,Model model) {
		
		return "";
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
	
	@RequestMapping("groupStatsByCategory.do")
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
		model.addAttribute("income",groupIncome);
		model.addAttribute("outlay",groupOutlay);
		model.addAttribute("groupBalance",groupBalance);
		
		//기간별
		
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
		List<Event> event = eventService.findAllEventsByGroupId(groupId);
		model.addAttribute("event",event);
		int eventIncome =0;
		int eventOutlay =0;
		int eventBalance = 0;
		for(int i=0;i<event.size();i++) {
		eventIncome=recordService.findEventStatsRecordByAccounting("수입",event.get(i).getEventId());
		eventOutlay = recordService.findEventStatsRecordByAccounting("지출",event.get(i).getEventId());
		eventBalance = eventIncome-eventOutlay;
		model.addAttribute("eventIncome",eventIncome);
		model.addAttribute("eventOutlay",eventOutlay);
		model.addAttribute("eventBalance",eventBalance);
		}
		
		
		
		
		
		
//		
//		List<Record> eventsIncome = new ArrayList<>();
//		List<Record> eventsOutlay = new ArrayList<>();
//		eventsIncome = recordService.findGroupStatsRecordByEvent("수입", groupId);
//		eventsOutlay = recordService.findGroupStatsRecordByEvent("지출", groupId);
//		Integer i = 0;
//		List<Event> event = new ArrayList<>();
//		for (Record record : eventsIncome) {
//			
//				event.add(eventService.findEventById(eventsIncome.indexOf(record)));
//				
//				model.addAttribute("eventName",event.get(i-1).getEventName());
//				model.addAttribute("eventIncome",eventsIncome.get(i-1).getPrice());
////				model.addAttribute("eventOutlay",eventsOutlay.get(i-1).getPrice());
//				System.out.println(event.get(i-1).getEventName());
//				System.out.println(eventsIncome.get(i-1).getPrice());
//				System.out.println(eventsOutlay.get(i-1).getPrice());
//				
//		}
		
		
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
