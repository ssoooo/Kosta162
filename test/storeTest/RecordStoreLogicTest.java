package storeTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import GeneralAffairs.domain.Record;
import GeneralAffairs.store.RecordStore;
import GeneralAffairs.store.logic.RecordStoreLogic;

public class RecordStoreLogicTest {

//	private FoodStore foodStore;
//	private CustomerStore customerStore;
//	private CommentStore commentStore;
//	
//	@Before
//	public void setUp() {
//		foodStore = new FoodStoreLogic();
//		customerStore = new CustomerStoreLogic();
//		commentStore = new CommentStoreLogic();
//	}
//	
//	@Test
//	public void testRegistFood() {
//		Food food = new Food();
//		food.setCustomerId("yang");
//		food.setFoodContent("chicken");	
//		food.setBound("n");
//		food.setImage("1.jpg");
//		foodStore.registFood(food);
//	}

//	@Test
//	public void testUpdateFood() {
//		Food food = new Food();
//		food.setFoodId("15");
//		food.setBound("y");
//		foodStore.updateFood(food);
//	}
	
//	@Test
//	public void testDeleteFood() {
//		Food food = new Food();
//		food.setFoodId("3");
//		foodStore.deleteFood(food.getFoodId());
//	}

//	@Test
//	public void testRetrieveFoodsByCustomerId() {
//		List<Food> list = foodStore.retrieveFoodsByCustomerId("jimin");
//
//		assertEquals("¸À³ª´Ù", list.get(0).getFoodContent());
//		assertEquals(2, list.size());
//	}

//	@Test
//	public void testRetrieveFoodByFoodId() {
//		Food food = foodStore.retrieveFoodByFoodId("2");
//		assertEquals("Â¥Àå¸é", food.getFoodContent());
//	}

//	@Test
//	public void testRetrieveAllFoods() {
//		List<Food> list = foodStore.retrieveAllFoods();
//		assertEquals(2, list.size());
//	}

//	@Test
//	public void testRetrieveLastElvFoods() {
//		List<Food> list = foodStore.retrieveLastElvFoods();
//		assertEquals(2, list.size());
//	
//	}

//	@Test
//	public void testRetrieveBattleFood() {
//		List<Food> list = foodStore.retrieveBattleFood();
//		assertNotNull(list);
//		assertEquals(4, list.size());
//	}

//	@Test
//	public void testRetrieveSixteenFoodsDesc() {
//		List<String> foodIds = foodStore.retrieveSixteenFoodsDesc();
//		assertEquals(2, foodIds.size());
//		assertEquals("1", list.get(0).getFoodId());
//		assertEquals("3", list.get(1).getFoodId());
//		assertEquals("2", list.get(2).getFoodId());
//	}

//	@Test
//	public void testRetrieveElvFoodsDesc() {
//		List<Food> list = foodStore.retrieveSixteenFoodsDesc();
//		assertEquals(2, list.size());
//	}

//	@Test
//	public void testRetrieveAllElvFoods() {
//	}
	
	private RecordStore recordStore;
	
	@Before
	public void setUp() {
		recordStore = new RecordStoreLogic();
		
	}
	
	@Test
	public void testRegistRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveRecordById() {
//		List<String> foodIds = foodStore.retrieveSixteenFoodsDesc();
//		assertEquals(2, foodIds.size());
//		assertEquals("1", list.get(0).getFoodId());
//		assertEquals("3", list.get(1).getFoodId());
//		assertEquals("2", list.get(2).getFoodId());
		int recordId=1;
		
		Record record = recordStore.retrieveRecordById(recordId);
		
		assertEquals(1, record.getEventId());
		assertEquals("³³ºÎ", record.getAccounting());
		assertEquals("Á¤»ó", record.getCaution());
	}

	@Test
	public void testRetrieveAllRecordsByEventId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllRecordsByGroupId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveRecordsByDay() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveRecordsByWeek() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveRecordsByMonth() {
//		List<String> foodIds = foodStore.retrieveSixteenFoodsDesc();
//		assertEquals(2, foodIds.size());
//		assertEquals("1", list.get(0).getFoodId());
//		assertEquals("3", list.get(1).getFoodId());
//		assertEquals("2", list.get(2).getFoodId());
		Date sDate = Date.valueOf("2017-05-01");
		Date fDate= Date.valueOf("2017-09-30");
//		try {
//		    String sDate="2017/05/01";
//		    String fDate="2017/09/01";
//		    DateFormat formatter ; 
//		 
//		    formatter = new SimpleDateFormat("yyyy/MM/dd");
//		    ssDate = (Date)formatter.parse(sDate);
//		    ffDate=(Date)formatter.parse(fDate);
//		} catch (ParseException e) {}
//		 
//		java.sql.Date sssDate = new java.sql.Date(ssDate.getTime());
//		java.sql.Date fffDate = new java.sql.Date(ffDate.getTime());
		String accounting = "³³ºÎ";
		List<Record> records= recordStore.retrieveRecordsByMonth(sDate,fDate,accounting);

		assertEquals(5, records.size());
		assertEquals(1,records.get(0).getRecordId());
		assertEquals(2, records.get(1).getEventId());
		assertEquals(2, records.get(2).getGroupId());
		
		System.out.println(sDate);
		System.out.println(fDate);
		
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

	@Test
	public void testRetrieveGroupAccountingResultMonth() {
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
