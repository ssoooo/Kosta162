package GeneralAffairs.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Group {
	
	private int groupId;
	private String memberId;
	private String groupName;
	private String account;
	private String groupIntroduce;
	private Date date;
	private double balance;

	private String groupImage;
	private MultipartFile imgFile;

	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public String getGroupImage() {
		return groupImage;
	}
	public void setGroupImage(String groupImage) {
		this.groupImage = groupImage;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getGroupIntroduce() {
		return groupIntroduce;
	}
	public void setGroupIntroduce(String groupIntroduce) {
		this.groupIntroduce = groupIntroduce;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
