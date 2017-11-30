package GeneralAffairs.store;

import java.sql.Date;
import java.util.List;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Record;

public interface RecordStore {
	
	void registRecord(Record record);//
	void registRecordFromMessage(Record record);
	int updateRecord(Record record);//
	void deleteRecord(int recordId);//
	Record retrieveRecordById(int recordId);//
	
	List<Record> retrieveAllRecordsByEventId(int eventId);
	List<Record> retrieveAllRecordsByGroupId(int groupId);

	List<Record> retrieveRecordsByMonth(Date sDate,Date fDate,String accounting,int groupId);//지출,수입에 따른 달별 모임내역 가져오기
	List<Record> retrieveRecordsByYear(Date sDate,Date fDate,String accounting,int groupId);//지출,수입에 따른연별 모임내역 가져오기

//	List<Record> retrieveRecordsByCategoryMonth(String category,String accounting,Date sDate,Date fDate);
//	List<Record> retrieveRecordsByCategoryYear(String category,String accounting,Date sDate,Date fDate);
	
	int retrieveGroupAccountingResult(String accounting,int groupId,Date sDate,Date fDate);//지출,수입 조건에 따른 모임의 일정기간 금액 가져오기
	int retrieveEventAccountingResult(String accounting,int eventId,Date sDate,Date fDate);//지출,수입 조건에 따른 이벤트의 일정기간 금액 가져오기

	
//	List<Record> retrieveGroupStatsRecordByEventMonth(String accounting,Date sDate,Date fDate,int groupId,int eventId);
//	List<Record> retrieveGroupStatsRecordByEventYear(String accounting,Date sDate,Date fDate,int groupId,int eventId);
	
	
	
	int retrieveGroupStatsRecordByEventMonth(String accounting,Date sDate,Date fDate,int groupId,int eventId);//기간에 따른 이벤트별 수입 혹은 지출 합계 가져오기(월)
	int retrieveGroupStatsRecordByEventYear(String accounting,Date sDate,Date fDate,int groupId,int eventId);//기간에 따른 이벤트별 수입 혹은 지출 합계 가져오기(년)
	
	int retrieveGroupStatsRecordByCategoryMonth(String category,Date sDate,Date fDate,String accounting,int groupId);//수입,지출에 따른 카테고리별 모임의 달금액합계 가져오기
	int retrieveGroupStatsRecordByCategoryYear(String category,Date sDate,Date fDate,String accounting,int groupId);//수입,지출에 따른 카테고리별 모임의 달금액합계 가져오기
	
	int retrieveGroupStatsRecordByMonth(Date sDate,Date fDate,String accounting,int groupId);//수입,지출에 따른  달별 모임의 금액합계 가져오기
	int retrieveGroupStatsRecordByYear(Date sDate,Date fDate,String accounting,int groupId);//수입,지출에 따른  년별 모임의 금액합계 가져오기
	
	int retrieveGroupStatsRecordByAccounting(int groupId,String accounting); //수입 혹은 지츨 합계 가져오기
	
	int retrieveEventStatsRecordByMonth(String accounting,Date sDate,Date fDate,int eventId);//월별 이벤트 수입 혹은 지출 합계가져오기
	int retrieveEventStatsRecordByYear(String accounting,Date sDate,Date fDate,int eventId);//년별 이벤트 수입 혹은 지출 합계가져오기
	
	int retrieveEventStatsRecordByCategory(String category,String accounting,Date sDate,Date fDate,int eventId);//카테고리와 기간에 따른 수입 혹은 지출 합계가져오기
	int retrieveEventStatsRecordByAccounting(String accounting,int eventId); //이벤트의 수입 혹은 지출 합계 가져오기
	
}
