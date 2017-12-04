package storeTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GeneralAffairs.domain.Record;
import GeneralAffairs.store.RecordStore;
import GeneralAffairs.store.logic.RecordStoreLogic;

public class RecordStoreLogicTest2 {
	
private RecordStore recordStore;
	
	@Before
	public void setUp() {
		recordStore = new RecordStoreLogic();
		
	}
	

	@Test
	public void testRetrieveRecordsByMonth() {

//		Date sDate = Date.valueOf("2017-05-01");
//		Date fDate= Date.valueOf("2017-09-30");
//
//		String accounting = "지출";
//		int groupId=1;
//		List<Record> records= recordStore.retrieveRecordsByMonth(sDate,fDate,accounting,groupId);
//
//		assertEquals(4, records.size());
//		assertEquals(2,records.get(0).getRecordId());
//		assertEquals(2, records.get(1).getEventId());
//		assertEquals(3, records.get(2).getGroupId());
//		
//		System.out.println(sDate.toString());
//		System.out.println(fDate.toString());
//		
//		
		
	}

	@Test
	public void testRetrieveRecordsByYear() {
//		Date sDate = Date.valueOf("2017-01-01");
//		Date fDate = Date.valueOf("2020-12-31");
//		
//		String accounting ="수입";
//		int groupId = 2;
//		List<Record> records = recordStore.retrieveRecordsByYear(sDate, fDate, accounting, groupId);
//		
//		assertEquals(2, records.size());
	}

	@Test
	public void testRetrieveGroupAccountingResult() {
//		Date sDate = Date.valueOf("2017-01-01");
//		Date fDate = Date.valueOf("2020-12-31");
//		
//		String accounting = "수입";
//		int groupId =2;
//		int sum = recordStore.retrieveGroupAccountingResult(accounting, groupId, sDate, fDate);
//		
//		assertEquals(14995, sum);
	}

	@Test
	public void testRetrieveEventAccountingResult() {
//		Date sDate = Date.valueOf("2017-01-01");
//		Date fDate = Date.valueOf("2020-12-31");
//		
//		String accounting = "수입";
//		int eventId =2;
//		int sum = recordStore.retrieveEventAccountingResult(accounting, eventId, sDate, fDate);
//		
//		assertEquals(5000, sum);
	}

	@Test
	public void testRetrieveGroupStatsRecordByEvent() {
//		Date sDate = Date.valueOf("2017-01-01");
//		Date fDate = Date.valueOf("2020-12-31");
//		
//		String accounting = "수입";
//		int groupId =1;
//		List<Record> records =recordStore.retrieveGroupStatsRecordByEvent(accounting, sDate, fDate,groupId);
//		
//		assertEquals(2, records.size());
	}

	@Test
	public void testRetrieveGroupStatsRecordByCategory() {
		Date sDate = Date.valueOf("2017-01-01");
		Date fDate = Date.valueOf("2020-12-31");
		String category="교통비";
		String accounting = "수입";
		int groupId =1;
		
		
		int sum=recordStore.retrieveGroupStatsRecordByCategory(category, sDate, fDate, accounting, groupId);
		assertEquals(57000, sum);
	}

	@Test
	public void testRetrieveGroupStatsRecordByMonth() {
		//
	}

	@Test
	public void testRetrieveGroupStatsRecordByYear() {
		//
	}

	@Test
	public void testRetrieveGroupStatsRecordByAccounting() {
		int groupId = 1;
		String accounting ="지출";
		int sum = recordStore.retrieveGroupStatsRecordByAccounting(groupId, accounting);
		assertEquals(15250, sum);
		
	}

	@Test
	public void testRetrieveEventStatsRecordByMonth() {
		//
	}

	@Test
	public void testRetrieveEventStatsRecordByYear() {
		//
	}

	@Test
	public void testRetrieveEventStatsRecordByCategory() {
		Date sDate = Date.valueOf("2017-01-01");
		Date fDate = Date.valueOf("2020-12-31");
		String category="교통비";
		String accounting = "수입";
		int eventId =1;
		
		int sum =recordStore.retrieveEventStatsRecordByCategory(category, accounting, sDate, fDate, eventId);
		
		assertEquals(2000, sum);
	}

	@Test
	public void testRetrieveEventStatsRecordByAccounting() {
		int eventId = 1;
		String accounting ="지출";
		int sum = recordStore.retrieveEventStatsRecordByAccounting(accounting, eventId);
		assertEquals(102499, sum);
	}

	@Test
	public void testRegistRecordFromMessage() {
		fail("Not yet implemented");
	}

}
