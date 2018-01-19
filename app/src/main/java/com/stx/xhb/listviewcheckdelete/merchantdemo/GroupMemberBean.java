package com.stx.xhb.listviewcheckdelete.merchantdemo;

public class GroupMemberBean {


	private String id ;
	private String logoPath;
	private String merName ;
	private String PinYin;
	private String FirstPinYin;
	private Boolean checked;

	public GroupMemberBean(String id, String logoPath, String merName ,Boolean checked) {
		this.id = id;
		this.logoPath = logoPath;
		this.merName = merName;
		this.checked = checked;
	}

	public GroupMemberBean() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public String getPinYin() {
		return PinYin;
	}

	public void setPinYin(String pinYin) {
		PinYin = pinYin;
	}

	public String getFirstPinYin() {
		return FirstPinYin;
	}

	public void setFirstPinYin(String firstPinYin) {
		FirstPinYin = firstPinYin;
	}
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}
