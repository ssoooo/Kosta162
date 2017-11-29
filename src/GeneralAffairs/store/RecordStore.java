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
	List<Record> retrieveRecordsByPeriod(Date date,String accounting);
	List<Record> retrieveRecordsByCategory(String category,String accounting,Date date);
	int retrieveGroupAccountingResult(String accounting,int groupId,Date date);
	int retrieveEventAccountingResult(String accounting,int eventId,Date date);
	List<Record> retrieveGroupStatsRecordByEvent(String accounting,Date date,int groupId);
	List<Record> retrieveGroupStatsRecordByCategory(String category,Date date,String accounting,int groupId);
	List<Record> retrieveGroupStatsRecordByPeriod(Date date,String accounting,int groupId);
	List<Record> retrieveGroupStatsRecordByAccounting(int groupId,String accounting);
	List<Record> retrieveEventStatsRecordByPeriod(String accounting,Date date,int eventId);
	List<Record> retrieveEventStatsRecordByCategory(String category,String accounting,Date date,int eventId);
	List<Record> retrieveEventStatsRecordByAccounting(String accounting,int eventId);
	
}
