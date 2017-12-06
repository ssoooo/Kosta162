package GeneralAffairs.service;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Record;

public interface RecordService {

	void createRecord(Record record);
	boolean modifyRecord(Record record);
	void removeRecord(int recordId);
	Record findRecordById(int recordId);
	List<Record> findAllRecordsByEventId(int eventId);
	List<Record> findAllRecordsByGroupId(int groupId);
	void modifyCaution(Record record);
	List<Record> findRecordsByMonth(Date sDate,Date fDate,String accounting,int groupId);
	List<Record> findRecordsByYear(Date sDate,Date fDate,String accounting,int groupId);
//	List<Record> findRecordsByCategory(String category,String accounting,Date sDate,Date fDate);
	Integer findGroupAccountingResult(String accounting,int groupId,Date sDate,Date fDate);
	int findEventAccountingResult(String accounting,int eventId,Date sDate,Date fDate);
	List<Record> findGroupStatsRecordByEvent(String accounting,int groupId);
	Integer findGroupStatsRecordByCategory(String category,String accounting,int groupId);
//	List<Record> findGroupStatsRecordByPeriod(Date sDate,Date fDate,String accounting,int groupId);
	int findGroupStatsRecordByAccounting(int groupId,String accounting);
	int findEventStatsRecordByYear(String accounting,String year,int eventId);
	Integer findEventStatsRecordByCategory(String category,String accounting,int eventId);
	Integer findEventStatsRecordByAccounting(String accounting,int eventId);
	void addBalanceToGroup(Group group);
}
