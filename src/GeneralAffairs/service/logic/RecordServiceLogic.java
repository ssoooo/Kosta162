package GeneralAffairs.service.logic;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import GeneralAffairs.domain.Record;
import GeneralAffairs.service.RecordService;
import GeneralAffairs.store.RecordStore;

@Service
public class RecordServiceLogic implements RecordService{
	
	@Autowired
	private RecordStore store;

	@Override
	public void createRecord(Record record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyRecord(Record record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeRecord(int recordId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Record findRecordById(int recordId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findAllRecordsByEventId(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findAllRecordsByGroupId(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findRecordsByPeriod(Date date, String accounting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findRecordsByCategory(String category, String accounting, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findGroupAccountingResult(String accounting, int groupId, Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findEventAccountingResult(String accounting, int eventId, Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Record> findGroupStatsRecordByEvent(String accounting, Date date, int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findGroupStatsRecordByCategory(String category, Date date, String accounting, int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findGroupStatsRecordByPeriod(Date date, String accounting, int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findGroupStatsRecordByAccounting(int groupId, String accounting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findEventStatsRecordByPeriod(String accounting, Date date, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findEventStatsRecordByCategory(String category, String accounting, Date date, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> findEventStatsRecordByAccounting(String accounting, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
