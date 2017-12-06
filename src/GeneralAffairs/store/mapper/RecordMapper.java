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

	List<Record> retrieveGroupStatsRecordByAccounting(@Param("groupId") int groupId,
			@Param("accounting") String accounting);

	List<Record> retrieveEventStatsRecordByPeriod(@Param("accounting") String accounting, @Param("date") Date date,
			@Param("eventId") int eventId);

	List<Record> retrieveEventStatsRecordByCategory(@Param("category") String category,
			@Param("accounting") String accounting, Date date, @Param("eventId") int eventId);

	List<Record> retrieveEventStatsRecordByAccounting(@Param("accounting") String accounting,
			@Param("eventId") int eventId);

}
