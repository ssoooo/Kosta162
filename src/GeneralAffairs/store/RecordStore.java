package GeneralAffairs.store;

import java.sql.Date;
import java.util.List;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Record;

public interface RecordStore {
	
	void registRecord(Record record);
	void registRecordFromMessage(Record record);
	int updateRecord(Record record);
	void deleteRecord(int recordId);
	Record retrieveRecordById(int recordId);
	List<Record> retrieveAllRecordsByEventId(int eventId);
	List<Record> retrieveAllRecordsByGroupId(int groupId);
	
	List<Record> retrieveRecordsByDay(Date sDate,Date fDate,String accounting);
	List<Record> retrieveRecordsByWeek(Date sDate,Date fDate,String accounting);
	List<Record> retrieveRecordsByMonth(Date sDate,Date fDate,String accounting);
	
	List<Record> retrieveRecordsByCategoryDay(String category,String accounting,Date sDate,Date fDate);
	List<Record> retrieveRecordsByCategoryWeek(String category,String accounting,Date sDate,Date fDate);
	List<Record> retrieveRecordsByCategoryMonth(String category,String accounting,Date sDate,Date fDate);
	
	int retrieveGroupAccountingResultDay(String accounting,int groupId,Date sDate,Date fDate);
	int retrieveGroupAccountingResultWeek(String accounting,int groupId,Date sDate,Date fDate);
	int retrieveGroupAccountingResultMonth(String accounting,int groupId,Date sDate,Date fDate);
	
	
	
	int retrieveEventAccountingResult(String accounting,int eventId,Date sDate,Date fDate);
	List<Record> retrieveGroupStatsRecordByEvent(String accounting,Date sDate,Date fDate,int groupId);
	List<Record> retrieveGroupStatsRecordByCategory(String category,Date sDate,Date fDate,String accounting,int groupId);
	List<Record> retrieveGroupStatsRecordByPeriod(Date sDate,Date fDate,String accounting,int groupId);
	List<Record> retrieveGroupStatsRecordByAccounting(int groupId,String accounting);
	List<Record> retrieveEventStatsRecordByPeriod(String accounting,Date sDate,Date fDate,int eventId);
	List<Record> retrieveEventStatsRecordByCategory(String category,String accounting,Date sDate,Date fDate,int eventId);
	List<Record> retrieveEventStatsRecordByAccounting(String accounting,int eventId);
	
}
