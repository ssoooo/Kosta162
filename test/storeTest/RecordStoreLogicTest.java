package storeTest;

import static org.junit.Assert.*;

import org.junit.Test;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GeneralAffairs.domain.Record;
import GeneralAffairs.store.RecordStore;
import GeneralAffairs.store.logic.RecordStoreLogic;

public class RecordStoreLogicTest {
	
	private RecordStore recordStore;
	
	@Before
	public void setUp() {
		recordStore = new RecordStoreLogic();
		
	}
	
	@Test
	public void testRegistRecord() {

//		
//		Record record = new Record();
//		record.setEventId(1);
//		record.setGroupId(2);
//		record.setMemberId("우형님");
//		record.setImage("woo.jpg");
//		record.setTitle("11월 체육대회");
//		record.setContent("빨랑납부좀");
//		record.setAccounting("지출");
//		record.setPrice(50000);
//		record.setCategory("식비");
//		recordStore.registRecord(record);
		
	}

	@Test
	public void testUpdateRecord() {
//		
//		Record record = new Record();
//		record.setRecordId(21);
//		record.setImage("bro.jpg");
//		record.setTitle("우형이동산");
//		record.setContent("우형이짱");
//		record.setPrice(99999);
//		record.setCategory("유흥비");
//		recordStore.updateRecord(record);
//		
//		
	}

	@Test
	public void testDeleteRecord() {
		
//		recordStore.deleteRecord(42);
	}

	@Test
	public void testRetrieveRecordById() {

//		Record record = new Record();
//		record = recordStore.retrieveRecordById(21);
//		assertNotNull(record);
//		assertEquals("우형님", record.getMemberId());
//		assertEquals("bro.jpg", record.getImage());
//	
	}

	@Test
	public void testRetrieveAllRecordsByEventId() {
//		List<Record> records = new ArrayList<>();
//		records= recordStore.retrieveAllRecordsByEventId(2);
//		assertEquals(2, records.size());
		
	}

	@Test
	public void testRetrieveAllRecordsByGroupId() {
//		List<Record> records = new ArrayList<>();
//		records= recordStore.retrieveAllRecordsByGroupId(2);
//		assertEquals("지출", records.get(1).getAccounting());
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
		
	}

	@Test
	public void testRetrieveRecordsByCategoryDay() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveRecordsByCategoryWeek() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveRecordsByCategoryMonth() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveGroupAccountingResultDay() {

		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveGroupAccountingResultWeek() {
		fail("Not yet implemented");
		}
	

	public void testRetrieveRecordsByCategory() {

		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveGroupAccountingResultMonth() {
		fail("Not yet implemented");
		}
	

	public void testRetrieveGroupAccountingResult() {

		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventAccountingResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveGroupStatsRecordByEvent() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveGroupStatsRecordByCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveGroupStatsRecordByPeriod() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveGroupStatsRecordByAccounting() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventStatsRecordByPeriod() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventStatsRecordByCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveEventStatsRecordByAccounting() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegistRecordFromMessage() {
		fail("Not yet implemented");
	}

}
