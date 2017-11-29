package GeneralAffairs.store.logic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import GeneralAffairs.domain.Record;
import GeneralAffairs.store.RecordStore;
import GeneralAffairs.store.factory.SessionFactory;
import GeneralAffairs.store.mapper.RecordMapper;

@Repository
public class RecordStoreLogic implements RecordStore{

	@Override
	public void registRecord(Record record) {
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		mapper.registRecord(record);
		session.commit();
		}finally {
			session.close();
		}
		
		
	}

	@Override
	public int updateRecord(Record record) {
		int check=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		check=mapper.updateRecord(record);
		if(check>0) {
			session.commit();
		}
		}finally {
			session.close();
		}
		
		return check;
	}

	@Override
	public void deleteRecord(int recordId) {
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		mapper.deleteRecord(recordId);
		session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public Record retrieveRecordById(int recordId) {
		Record record=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		record=mapper.retrieveRecordById(recordId);
		}finally {
			session.close();
		}
		
		return record;
	}

	@Override
	public List<Record> retrieveAllRecordsByEventId(int eventId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveAllRecordsByEventId(eventId);
		}finally {
			session.close();
		}
		return records;
	}

	@Override
	public List<Record> retrieveAllRecordsByGroupId(int groupId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveAllRecordsByGroupId(groupId);
		}finally {
			session.close();
		}
		return records;
	}

	@Override
	public List<Record> retrieveRecordsByDay(Date sDate,Date fDate, String accounting) {
		List<Record> records=null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByDay(sDate,fDate, accounting);
		}finally {
			session.close();
		}
		
		return records;
	}
	
	@Override
	public List<Record> retrieveRecordsByWeek(Date sDate,Date fDate, String accounting) {
		List<Record> records=null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByWeek(sDate,fDate, accounting);
		}finally {
			session.close();
		}
		
		return records;
	}
	
	@Override
	public List<Record> retrieveRecordsByMonth(Date sDate,Date fDate, String accounting) {
		List<Record> records=null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByMonth(sDate,fDate, accounting);
		}finally {
			session.close();
		}
		
		return records;
	}

	@Override
	public List<Record> retrieveRecordsByCategoryDay(String category, String accounting,Date sDate,Date fDate) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByCategoryDay(category, accounting,sDate,fDate);
		}finally {
			session.close();
		}
		
		return records;
	}
	
	@Override
	public List<Record> retrieveRecordsByCategoryWeek(String category, String accounting,Date sDate,Date fDate) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByCategoryWeek(category, accounting,sDate,fDate);
		}finally {
			session.close();
		}
		
		return records;
	}
	
	@Override
	public List<Record> retrieveRecordsByCategoryMonth(String category, String accounting,Date sDate,Date fDate) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByCategoryMonth(category, accounting,sDate,fDate);
		}finally {
			session.close();
		}
		
		return records;
	}
	
	

	@Override
	public int retrieveGroupAccountingResultDay(String accounting, int groupId,Date sDate,Date fDate) {
		int groupAccounting=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		groupAccounting=mapper.retrieveGroupAccountingResultDay(accounting, groupId,sDate,fDate);
		}finally {
			session.close();
		}
		return groupAccounting;
	}
	
	@Override
	public int retrieveGroupAccountingResultWeek(String accounting, int groupId,Date sDate,Date fDate) {
		int groupAccounting=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		groupAccounting=mapper.retrieveGroupAccountingResultWeek(accounting, groupId,sDate,fDate);
		}finally {
			session.close();
		}
		return groupAccounting;
	}
	
	@Override
	public int retrieveGroupAccountingResultMonth(String accounting, int groupId,Date sDate,Date fDate) {
		int groupAccounting=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		groupAccounting=mapper.retrieveGroupAccountingResultMonth(accounting, groupId,sDate,fDate);
		}finally {
			session.close();
		}
		return groupAccounting;
	}

	@Override
	public int retrieveEventAccountingResult(String accounting, int eventId,Date sDate,Date fDate) {
		int eventAccounting=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		eventAccounting=mapper.retrieveEventAccountingResult(accounting, eventId,sDate,fDate);
		}finally {
			session.close();
		}
		
		return eventAccounting;
	}

	@Override
	public List<Record> retrieveGroupStatsRecordByEvent(String accounting,Date sDate,Date fDate, int groupId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveGroupStatsRecordByEvent(accounting,sDate,fDate, groupId);
		}finally {
			session.close();
		}
		return records;
	}

	@Override
	public List<Record> retrieveGroupStatsRecordByCategory(String category,Date sDate,Date fDate, String accounting, int groupId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveGroupStatsRecordByCategory(category,sDate,fDate, accounting, groupId);
		}finally {
			session.close();
		}
		
		
		return records;
	}

	@Override
	public List<Record> retrieveGroupStatsRecordByPeriod(Date sDate,Date fDate, String accounting, int groupId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveGroupStatsRecordByPeriod(sDate,fDate, accounting, groupId);
		}finally {
			session.close();
		}
		
		return records;
	}

	@Override
	public List<Record> retrieveGroupStatsRecordByAccounting(int groupId, String accounting) {

		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveGroupStatsRecordByAccounting(groupId, accounting);
		}finally {
			session.close();
		}
		
		return records;
	}

	@Override
	public List<Record> retrieveEventStatsRecordByPeriod(String accounting,Date sDate,Date fDate, int eventId) {
		
		List<Record> records=null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveEventStatsRecordByPeriod(accounting,sDate,fDate, eventId);
		}finally {
			session.close();
		}
		return records;
	}

	@Override
	public List<Record> retrieveEventStatsRecordByCategory(String category, String accounting,Date sDate,Date fDate, int eventId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveEventStatsRecordByCategory(category, accounting,sDate,fDate, eventId);
		}finally {
			session.close();
		}
		
		return records;
	}

	@Override
	public List<Record> retrieveEventStatsRecordByAccounting(String accounting, int eventId) {
		
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveEventStatsRecordByAccounting(accounting, eventId);
		}finally {
			session.close();
		}
		
		return records;
	}

	@Override
	public void registRecordFromMessage(Record record) {
		
		SqlSession session = SessionFactory.getInstance().getSession();
		
		try {
			RecordMapper mapper=session.getMapper(RecordMapper.class);
			mapper.registRecordFromMessage(record);
			session.commit();
		}finally {
			session.close();
		}
		
	}


	
}
