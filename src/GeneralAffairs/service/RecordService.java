package GeneralAffairs.service;


import java.sql.Date;
import java.util.List;


import GeneralAffairs.domain.Record;

public interface RecordService {

	void createRecord(Record record);
	boolean modifyRecord(Record record);
	void removeRecord(int recordId);
	Record findRecordById(int recordId);
	List<Record> findAllRecordsByEventId(int eventId);
	List<Record> findAllRecordsByGroupId(int groupId);
	List<Record> findRecordsByPeriod(Date date,String accounting);
	List<Record> findRecordsByCategory(String category,String accounting,Date date);
	int findGroupAccountingResult(String accounting,int groupId,Date date);
	int findEventAccountingResult(String accounting,int eventId,Date date);
	List<Record> findGroupStatsRecordByEvent(String accounting,Date date,int groupId);
	List<Record> findGroupStatsRecordByCategory(String category,Date date,String accounting,int groupId);
	List<Record> findGroupStatsRecordByPeriod(Date date,String accounting,int groupId);
	List<Record> findGroupStatsRecordByAccounting(int groupId,String accounting);
	List<Record> findEventStatsRecordByPeriod(String accounting,Date date,int eventId);
	List<Record> findEventStatsRecordByCategory(String category,String accounting,Date date,int eventId);
	List<Record> findEventStatsRecordByAccounting(String accounting,int eventId);
}
