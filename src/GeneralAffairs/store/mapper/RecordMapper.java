package GeneralAffairs.store.mapper;

import java.sql.Date;
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
	
	List<Record> retrieveRecordsByDay(@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting);
	List<Record> retrieveRecordsByWeek(@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting);
	List<Record> retrieveRecordsByMonth(@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting);
	
	List<Record> retrieveRecordsByCategoryDay(@Param("category")String category,@Param("accounting")String accounting,@Param("sDate")Date sDate,@Param("fDate")Date fDate);
	List<Record> retrieveRecordsByCategoryWeek(@Param("category")String category,@Param("accounting")String accounting,@Param("sDate")Date sDate,@Param("fDate")Date fDate);
	List<Record> retrieveRecordsByCategoryMonth(@Param("category")String category,@Param("accounting")String accounting,@Param("sDate")Date sDate,@Param("fDate")Date fDate);
	
	int retrieveGroupAccountingResultDay(@Param("accounting")String accounting,@Param("groupId")int groupId,@Param("sDate")Date sDate,@Param("fDate")Date fDate);
	int retrieveGroupAccountingResultWeek(@Param("accounting")String accounting,@Param("groupId")int groupId,@Param("sDate")Date sDate,@Param("fDate")Date fDate);
	int retrieveGroupAccountingResultMonth(@Param("accounting")String accounting,@Param("groupId")int groupId,@Param("sDate")Date sDate,@Param("fDate")Date fDate);
	
	int retrieveEventAccountingResult(@Param("accounting")String accounting,@Param("eventId")int eventId,@Param("sDate")Date sDate,@Param("fDate")Date fDate);
	List<Record> retrieveGroupStatsRecordByEvent(@Param("accounting")String accounting,@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("groupId")int groupId);
	List<Record> retrieveGroupStatsRecordByCategory(@Param("category")String category,@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting,@Param("groupId")int groupId);
	List<Record> retrieveGroupStatsRecordByPeriod(@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("accounting")String accounting,@Param("groupId")int groupId);
	List<Record> retrieveGroupStatsRecordByAccounting(@Param("groupId")int groupId,@Param("accounting")String accounting);
	List<Record> retrieveEventStatsRecordByPeriod(@Param("accounting")String accounting,@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("eventId")int eventId);
	List<Record> retrieveEventStatsRecordByCategory(@Param("category")String category,@Param("accounting")String accounting,@Param("sDate")Date sDate,@Param("fDate")Date fDate,@Param("eventId")int eventId);
	List<Record> retrieveEventStatsRecordByAccounting(@Param("accounting")String accounting,@Param("eventId")int eventId);

}
