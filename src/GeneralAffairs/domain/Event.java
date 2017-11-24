package GeneralAffairs.domain;

import java.sql.Date;

public class Event {
	
	private int eventId;
	private int groupId;
	private String memberId;
	private double balance;
	private String eventName;
	private double collection;
	private double collectionPerMember;
	private Date date;
	
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public double getCollection() {
		return collection;
	}
	public void setCollection(double collection) {
		this.collection = collection;
	}
	public double getCollectionPerMember() {
		return collectionPerMember;
	}
	public void setCollectionPerMember(double collectionPerMember) {
		this.collectionPerMember = collectionPerMember;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
