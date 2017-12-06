package GeneralAffairs.store.logic;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import GeneralAffairs.domain.Group;
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
	public List<Record> retrieveRecordsByMonth(Date sDate,Date fDate, String accounting,int groupId) {
		List<Record> records=null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByMonth(sDate,fDate, accounting,groupId);
		}finally {
			session.close();
		}
		
		return records;
	}
	
	@Override
	public List<Record> retrieveRecordsByYear(Date sDate,Date fDate, String accounting,int groupId) {
		List<Record> records=null;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveRecordsByYear(sDate,fDate, accounting,groupId);
		}finally {
			session.close();
		}
		
		return records;
	}

//	@Override
//	public List<Record> retrieveRecordsByCategoryDay(String category, String accounting,Date sDate,Date fDate) {
//		List<Record> records=null;
//		SqlSession session = SessionFactory.getInstance().getSession();
//		try {
//		RecordMapper mapper =session.getMapper(RecordMapper.class);	
//		records=mapper.retrieveRecordsByCategoryDay(category, accounting,sDate,fDate);
//		}finally {
//			session.close();
//		}
//		
//		return records;
//	}
//	
//	@Override
//	public List<Record> retrieveRecordsByCategoryWeek(String category, String accounting,Date sDate,Date fDate) {
//		List<Record> records=null;
//		SqlSession session = SessionFactory.getInstance().getSession();
//		try {
//		RecordMapper mapper =session.getMapper(RecordMapper.class);	
//		records=mapper.retrieveRecordsByCategoryWeek(category, accounting,sDate,fDate);
//		}finally {
//			session.close();
//		}
//		
//		return records;
//	}
//	
//	@Override
//	public List<Record> retrieveRecordsByCategoryMonth(String category, String accounting,Date sDate,Date fDate) {
//		List<Record> records=null;
//		SqlSession session = SessionFactory.getInstance().getSession();
//		try {
//		RecordMapper mapper =session.getMapper(RecordMapper.class);	
//		records=mapper.retrieveRecordsByCategoryMonth(category, accounting,sDate,fDate);
//		}finally {
//			session.close();
//		}
//		
//		return records;
//	}
	
	

	
	@Override
	public Integer retrieveGroupAccountingResult(String accounting, int groupId,Date sDate,Date fDate) {
		Integer groupAccounting=null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		groupAccounting=mapper.retrieveGroupAccountingResult(accounting, groupId,sDate,fDate);
		}finally {
			session.close();
		}
		if(groupAccounting ==null) {
		return 0;
		}else {
			return groupAccounting;
		}
		
	}
	


	@Override
	public int retrieveEventAccountingResult(String accounting, int eventId,Date sDate,Date fDate) {
		int sum=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		sum=mapper.retrieveEventAccountingResult(accounting, eventId,sDate,fDate);
		}finally {
			session.close();
		}
		
		return sum;
	}

	@Override
	public List<Record> retrieveGroupStatsRecordByEvent(String accounting,int groupId) {
		List<Record> records = null;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		records=mapper.retrieveGroupStatsRecordByEvent(accounting,groupId);
		}finally {
			session.close();
		}
		
		return records;
	}
	
	
	

	@Override
	public Integer retrieveGroupStatsRecordByCategory(String category, String accounting, int groupId) {
		Integer sum=0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		sum=mapper.retrieveGroupStatsRecordByCategory(category, accounting, groupId);
		}finally {
			session.close();
		}
		if(sum==null) {
			return 0;
		}else {
		return sum;
		}
	}
	

		
	
	

//	@Override
//	public int retrieveGroupStatsRecordByMonth(Date sDate,Date fDate, String accounting, int groupId) {
//		int sum=0;
//		SqlSession session = SessionFactory.getInstance().getSession();
//		try {
//		RecordMapper mapper =session.getMapper(RecordMapper.class);	
//		sum=mapper.retrieveGroupStatsRecordByMonth(sDate,fDate, accounting, groupId);
//		}finally {
//			session.close();
//		}
//		
//		return sum;
//	}
	
	
//	@Override
//	public int retrieveGroupStatsRecordByYear(Date sDate,Date fDate, String accounting, int groupId) {
//		int sum=0;
//		SqlSession session = SessionFactory.getInstance().getSession();
//		try {
//		RecordMapper mapper =session.getMapper(RecordMapper.class);	
//		sum=mapper.retrieveGroupStatsRecordByYear(sDate,fDate, accounting, groupId);
//		}finally {
//			session.close();
//		}
//		
//		return sum;
//	}
	
	

	@Override
	public int retrieveGroupStatsRecordByAccounting(int groupId, String accounting) {

		int sum = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		sum=mapper.retrieveGroupStatsRecordByAccounting(groupId, accounting);
		}finally {
			session.close();
		}
		
		return sum;
	}

//	@Override
//	public int retrieveEventStatsRecordByMonth(String accounting,Date sDate,Date fDate, int eventId) {
//		
//		int sum=0;
//		
//		SqlSession session = SessionFactory.getInstance().getSession();
//		try {
//		RecordMapper mapper =session.getMapper(RecordMapper.class);	
//		sum=mapper.retrieveEventStatsRecordByMonth(accounting,sDate,fDate, eventId);
//		}finally {
//			session.close();
//		}
//		return sum;
//	}
	
	
	@Override
	public int retrieveEventStatsRecordByYear(String accounting,String year, int eventId) {
		
		int sum=0;
		
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		sum=mapper.retrieveEventStatsRecordByYear(accounting,year, eventId);
		}finally {
			session.close();
		}
		return sum;
	}
	
	

	@Override
	public Integer retrieveEventStatsRecordByCategory(String category, String accounting, int eventId) {
		Integer sum =0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		sum=mapper.retrieveEventStatsRecordByCategory(category, accounting, eventId);
		}finally {
			session.close();
		}
		if(sum==null) {
			return 0;
		}else {
			return sum;
		}
		
	}

	@Override
	public Integer retrieveEventStatsRecordByAccounting(String accounting, int eventId) {
		
		Integer sum = 0;
		SqlSession session = SessionFactory.getInstance().getSession();
		try {
		RecordMapper mapper =session.getMapper(RecordMapper.class);	
		sum=mapper.retrieveEventStatsRecordByAccounting(accounting, eventId);
		}finally {
			session.close();
		}
		if(sum == null) {
			return 0;
		}else {
			return sum;
		}
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

	@Override
	public void plusBalanceToGroup(Group group) {
		SqlSession session = SessionFactory.getInstance().getSession();
		
		try {
			RecordMapper mapper=session.getMapper(RecordMapper.class);
			mapper.plusBalanceToGroup(group);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void updateCaution(Record record) {
		SqlSession session = SessionFactory.getInstance().getSession();
		
		try {
			RecordMapper mapper=session.getMapper(RecordMapper.class);
			mapper.updateCaution(record);
			session.commit();
		}finally {
			session.close();
		}
		
	}


	
}
