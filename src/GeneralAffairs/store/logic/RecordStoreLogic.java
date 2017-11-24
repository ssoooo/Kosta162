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
	public List<Record> retrieveRecordsByPeriod(Date date, String accounting) {
		List<Record> records=null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByPeriod(date, accounting);
		}finally {
			session.close();
		}
		
		return records;
	}

	@Override
	public List<Record> retrieveRecordsByCategory(String category, String accounting, Date date) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByCategory(category, accounting, date);
		}finally {
			session.close();
		}
		
		return records;
	}

	@Override
	public int retrieveGroupAccountingResult(String accounting, int groupId, Date date) {
		int groupAccounting=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		groupAccounting=mapper.retrieveGroupAccountingResult(accounting, groupId, date);
		}finally {
			session.close();
		}
		return groupAccounting;
	}

	@Override
	public int retrieveEventAccountingResult(String accounting, int eventId, Date date) {
		int eventAccounting=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		eventAccounting=mapper.retrieveEventAccountingResult(accounting, eventId, date);
		}finally {
			session.close();
		}
		
		return eventAccounting;
	}

	@Override
	public List<Record> retrieveGroupStatsRecordByEvent(String accounting, Date date, int groupId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveGroupStatsRecordByEvent(accounting, date, groupId);
		}finally {
			session.close();
		}
		return records;
	}

	@Override
	public List<Record> retrieveGroupStatsRecordByCategory(String category, Date date, String accounting, int groupId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveGroupStatsRecordByCategory(category, date, accounting, groupId);
		}finally {
			session.close();
		}
		
		
		return records;
	}

	@Override
	public List<Record> retrieveGroupStatsRecordByPeriod(Date date, String accounting, int groupId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveGroupStatsRecordByPeriod(date, accounting, groupId);
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
	public List<Record> retrieveEventStatsRecordByPeriod(String accounting, Date date, int eventId) {
		
		List<Record> records=null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveEventStatsRecordByPeriod(accounting, date, eventId);
		}finally {
			session.close();
		}
		return records;
	}

	@Override
	public List<Record> retrieveEventStatsRecordByCategory(String category, String accounting, Date date, int eventId) {
		List<Record> records=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveEventStatsRecordByCategory(category, accounting, date, eventId);
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


	
}
