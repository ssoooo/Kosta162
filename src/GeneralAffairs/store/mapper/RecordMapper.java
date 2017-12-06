package GeneralAffairs.store.mapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import GeneralAffairs.domain.Group;
import GeneralAffairs.domain.Record;

public interface RecordMapper {

	
	void registRecord(Record record);

	void registRecordFromMessage(Record record);

	int updateRecord(Record record);

	void deleteRecord(int recordId);

	Record retrieveRecordById(int recordId);

	List<Record> retrieveAllRecordsByEventId(int eventId);
	List<Record> retrieveAllRecordsByGroupId(int groupId);
	List<Record> retrieveRecordsByPeriod(@Param("date") Date date, @Param("accounting") String accounting);
	List<Record> retrieveRecordsByCategory(@Param("category") String category, @Param("accounting") String accounting,
			@Param("date") Date date);
	int retrieveGroupAccountingResult(@Param("accounting") String accounting, @Param("groupId") int groupId,
			@Param("date") Date date);
	int retrieveEventAccountingResult(@Param("accounting") String accounting, @Param("eventId") int eventId,
			@Param("date") Date date);
	List<Record> retrieveGroupStatsRecordByEvent(@Param("accounting") String accounting, @Param("date") Date date,
			@Param("groupId") int groupId);
	List<Record> retrieveGroupStatsRecordByCategory(@Param("category") String category, @Param("date") Date date,
			@Param("accounting") String accounting, @Param("groupId") int groupId);
	List<Record> retrieveGroupStatsRecordByPeriod(@Param("date") Date date, @Param("accounting") String accounting,
			@Param("groupId") int groupId);


	List<Record> retrieveEventStatsRecordByPeriod(@Param("accounting") String accounting, @Param("date") Date date,
			@Param("eventId") int eventId);

	List<Record> retrieveEventStatsRecordByCategory(@Param("category") String category,
			@Param("accounting") String accounting, Date date, @Param("eventId") int eventId);


	
	void updateCaution(Record record);
	List<Record> retrieveRecordsByMonth(@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting,@Param("groupId")int groupId);//지출,수입에 따른 달별 모임내역 가져오기
	List<Record> retrieveRecordsByYear(@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting,@Param("groupId")int groupId);//지출,수입에 따른연별 모임내역 가져오기


//	List<Record> retrieveRecordsByCategoryMonth(String category,String accounting,Date sDate,Date fDate);
//	List<Record> retrieveRecordsByCategoryYear(String category,String accounting,Date sDate,Date fDate);
	
	Integer retrieveGroupAccountingResult(@Param("accounting")String accounting,@Param("groupId")int groupId,@Param("sDate")Date sDate,@Param("fDate")Date fDate);//지출,수입 조건에 따른 모임의 일정기간 금액 가져오기
	int retrieveEventAccountingResult(@Param("accounting")String accounting,@Param("eventId")int eventId,@Param("sDate")Date sDate,@Param("fDate")Date fDate);//지출,수입 조건에 따른 이벤트의 일정기간 금액 가져오기

	
//	List<Record> retrieveGroupStatsRecordByEventMonth(String accounting,Date sDate,Date fDate,int groupId,int eventId);
//	List<Record> retrieveGroupStatsRecordByEventYear(String accounting,Date sDate,Date fDate,int groupId,int eventId);
	
	
	
	List<Record> retrieveGroupStatsRecordByEvent(@Param("accounting")String accounting,@Param("groupId")int groupId);//기간에 따른 이벤트별 수입 혹은 지출 합계 가져오기
	
	
	Integer retrieveGroupStatsRecordByCategory(@Param("category")String category,@Param("accounting")String accounting,@Param("groupId")int groupId);//수입,지출에 따른 카테고리별 모임의 금액합계 가져오기

	
//	int retrieveGroupStatsRecordByMonth(@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting,@Param("groupId")int groupId);//수입,지출에 따른  달별 모임의 금액합계 가져오기
//	int retrieveGroupStatsRecordByYear(@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting,@Param("groupId")int groupId);//수입,지출에 따른  년별 모임의 금액합계 가져오기
	
	int retrieveGroupStatsRecordByAccounting(@Param("groupId")int groupId,@Param("accounting")String accounting); //수입 혹은 지츨 합계 가져오기
	
//	int retrieveEventStatsRecordByMonth(@Param("accounting")String accounting,@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("eventId")int eventId);//월별 이벤트 수입 혹은 지출 합계가져오기
	int retrieveEventStatsRecordByYear(@Param("accounting")String accounting,@Param("year")String year,@Param("eventId")int eventId);//년별 이벤트 수입 혹은 지출 합계가져오기
	
	Integer retrieveEventStatsRecordByCategory(@Param("category")String category,@Param("accounting")String accounting,@Param("eventId")int eventId);//카테고리와 기간에 따른 수입 혹은 지출 합계가져오기
	Integer retrieveEventStatsRecordByAccounting(@Param("accounting")String accounting,@Param("eventId")int eventId); //이벤트의 수입 혹은 지출 합계 가져오기
}
