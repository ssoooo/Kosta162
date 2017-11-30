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
	List<Record> findRecordsByPeriod(Date sDate,Date fDate,String accounting);
	List<Record> findRecordsByCategory(String category,String accounting,Date sDate,Date fDate);
	int findGroupAccountingResult(String accounting,int groupId,Date sDate,Date fDate);
	int findEventAccountingResult(String accounting,int eventId,Date sDate,Date fDate);
	List<Record> findGroupStatsRecordByEvent(String accounting,Date sDate,Date fDate,int groupId);
	List<Record> findGroupStatsRecordByCategory(String category,Date sDate,Date fDate,String accounting,int groupId);
	List<Record> findGroupStatsRecordByPeriod(Date sDate,Date fDate,String accounting,int groupId);
	List<Record> findGroupStatsRecordByAccounting(int groupId,String accounting);
	List<Record> findEventStatsRecordByPeriod(String accounting,Date sDate,Date fDate,int eventId);
	List<Record> findEventStatsRecordByCategory(String category,String accounting,Date sDate,Date fDate,int eventId);
	List<Record> findEventStatsRecordByAccounting(String accounting,int eventId);
}
