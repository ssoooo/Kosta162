package GeneralAffairs.service.logic;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Record;
import GeneralAffairs.service.RecordService;
import GeneralAffairs.store.RecordStore;

@Service
public class RecordServiceLogic implements RecordService{
	
	@Autowired
	private RecordStore store;

	@Override
	public void createRecord(Record record) {
		store.registRecord(record);
		
	}

	@Override
	public boolean modifyRecord(Record record) {
		int check=0;
		
		check =store.updateRecord(record);
		
		return check>0;
	}

	@Override
	public void removeRecord(int recordId) {
		store.deleteRecord(recordId);
		
	}

	@Override
	public Record findRecordById(int recordId) {
		return store.retrieveRecordById(recordId);
	}

	@Override
	public List<Record> findAllRecordsByEventId(int eventId) {
		return store.retrieveAllRecordsByEventId(eventId);
	}

	@Override
	public List<Record> findAllRecordsByGroupId(int groupId) {
		return store.retrieveAllRecordsByGroupId(groupId);
	}

	@Override
	public List<Record> findRecordsByMonth(Date sDate,Date fDate, String accounting,int groupId) {
		return store.retrieveRecordsByMonth(sDate, fDate, accounting, groupId);
	}
	
	@Override
	public List<Record> findRecordsByYear(Date sDate,Date fDate, String accounting,int groupId) {
		return store.retrieveRecordsByYear(sDate, fDate, accounting, groupId);
	}

	

	@Override
	public Integer findGroupAccountingResult(String accounting, int groupId,Date sDate,Date fDate) {
		return store.retrieveGroupAccountingResult(accounting, groupId, sDate, fDate);
	}

	@Override
	public int findEventAccountingResult(String accounting, int eventId,Date sDate,Date fDate) {
		return store.retrieveEventAccountingResult(accounting, eventId, sDate, fDate);
	}

	@Override
	public List<Record> findGroupStatsRecordByEvent(String accounting, int groupId) {
		return store.retrieveGroupStatsRecordByEvent(accounting, groupId);
	}

	@Override
	public Integer findGroupStatsRecordByCategory(String category, String accounting, int groupId) {
		return store.retrieveGroupStatsRecordByCategory(category, accounting, groupId);
	}

//	@Override
//	public List<Record> findGroupStatsRecordByPeriod(Date sDate,Date fDate, String accounting, int groupId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int findGroupStatsRecordByAccounting(int groupId, String accounting) {
		return store.retrieveGroupStatsRecordByAccounting(groupId, accounting);
	}

//	@Override
//	public List<Record> findEventStatsRecordByPeriod(String accounting,Date sDate,Date fDate, int eventId) {
//		return null;
//	}

	@Override
	public Integer findEventStatsRecordByCategory(String category, String accounting, int eventId) {
		return store.retrieveEventStatsRecordByCategory(category, accounting, eventId);
	}

	@Override
	public Integer findEventStatsRecordByAccounting(String accounting, int eventId) {
		return store.retrieveEventStatsRecordByAccounting(accounting, eventId);
	}

	@Override
	public int findEventStatsRecordByYear(String accounting,String year, int eventId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addBalanceToGroup(Group group) {
		// TODO Auto-generated method stub
		store.plusBalanceToGroup(group);
	}

	@Override
	public void modifyCaution(Record record) {
		store.updateCaution(record);
		
	}

	
	
}
