package GeneralAffairs.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import GeneralAffairs.domain.Message;
import GeneralAffairs.domain.Record;
import GeneralAffairs.service.EventService;
import GeneralAffairs.service.MemberGroupService;
import GeneralAffairs.service.RecordService;

@Controller
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private MemberGroupService msService;
	
	
	@RequestMapping(value = "registEventRecord.do", method = RequestMethod.POST)
	public String registGroupRecord(Record record,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping(value = "registEventRecord.do", method = RequestMethod.GET)
	public String registEventRecord(Record record,HttpSession session) {
		
		return "";
	}
	
	@RequestMapping("deleteGroupRecord.do")
	public String deleteGroupRecord(int recordId,int groupId) {
		
		return "";
	}
	
	@RequestMapping("deleteEventRecord.do")
	public String deleteEventRecord(int recordId,int eventId) {
		
		return "";
	}
	
	@RequestMapping(value = "modifyGroupRecord.do", method = RequestMethod.POST)
	public String modifyGroupRecord(Record record) {
		
		return "";
	}
	
	@RequestMapping(value = "modifyEventRecord.do", method = RequestMethod.POST)
	public String modifyEventRecord(Record record) {
		
		return "";
	}
	
	@RequestMapping("checkRecord.do")
	public String checkRecord(Record record) {
		
		return "";
	}
	
	@RequestMapping("registGroupRecord.do")
	public String showRegistGroupRecord(int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping("registEventRecord.do")
	public String showRegistEventRecord(int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping("registRecordByMessage.do")
	public String showRegistRecordByMessage(Message message,Model model) {
		
		return "";
	}
	
	@RequestMapping("recordDetail.do")
	public String showRecordDetail(int recordId,Model model) {
		
		return"";
	}
	
	@RequestMapping(value = "modifyEventRecord.do", method = RequestMethod.GET)
	public String showModifyEventRecord(int recordId,int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "modifyGroupRecord.do", method = RequestMethod.GET)
	public String showModifyGroupRecord(int recordId,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "eventStatsByPeriod.do", method = RequestMethod.GET)
	public String showEventStatsByPeriod(Date date,String accounting,int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "eventStatsByAccounting.do", method = RequestMethod.GET)
	public String showEventStatsByAccounting(String accounting,int eventId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "eventStatsByCategory.do", method = RequestMethod.GET)
	public String showEventStatsByCategory(String category,String accounting,int eventId,Date date) {
		
		return "";
	}
	
	@RequestMapping(value = "groupStatsByAccounting.do", method = RequestMethod.GET)
	public String showGroupStatsByAccounting(String accounting,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "groupStatsByPeriod.do", method = RequestMethod.GET)
	public String showGroupStatsByPeriod(Date date,String accounting,int groupId,Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "groupStatsByCategory.do", method = RequestMethod.GET)
	public String showGroupStatsByCategory(String category,String accounting,int groupId,Date date) {
		
		return "";
	}
	
	@RequestMapping(value = "groupStatsByEvent.do", method = RequestMethod.GET)
	public String showGroupStatsByEvent(String accounting,Date date,int eventId) {
		
		return"";
	}

}
