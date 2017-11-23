package com.yingview.domain;

public class User {
	private int userId;
	private String usercode;
	private String username;
	private String password;
	private String passcode;
	private String nickname;
	private String sax;
	private String email;
	private String tel;
	private Long birthday = 0L;
	private String photoadd = "http://127.0.0.1:8080/files/photo.jpg";
	private int userlevel = 1;
	private int userpower = 1;
	private int userstatus = 0;
	private String userjob;
	private String activecode;
	private Long usercreatetime = 0L;
	
	public User() {
		super();
	}

	public User(int userId, String usercode, String username, String password, String passcode, String nickname,
			String sax, String email, String tel, Long birthday, String photoadd, int userlevel, int userpower,
			int userstatus, String userjob, String activecode, Long usercreatetime) {
		super();
		this.userId = userId;
		this.usercode = usercode;
		this.username = username;
		this.password = password;
		this.passcode = passcode;
		this.nickname = nickname;
		this.sax = sax;
		this.email = email;
		this.tel = tel;
		this.birthday = birthday;
		this.photoadd = photoadd;
		this.userlevel = userlevel;
		this.userpower = userpower;
		this.userstatus = userstatus;
		this.userjob = userjob;
		this.activecode = activecode;
		this.usercreatetime = usercreatetime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSax() {
		return sax;
	}

	public void setSax(String sax) {
		this.sax = sax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}

	public String getPhotoadd() {
		return photoadd;
	}

	public void setPhotoadd(String photoadd) {
		this.photoadd = photoadd;
	}

	public int getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}

	public int getUserpower() {
		return userpower;
	}

	public void setUserpower(int userpower) {
		this.userpower = userpower;
	}

	public int getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}

	public String getUserjob() {
		return userjob;
	}

	public void setUserjob(String userjob) {
		this.userjob = userjob;
	}

	public String getActivecode() {
		return activecode;
	}

	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}

	public Long getUsercreatetime() {
		return usercreatetime;
	}

	public void setUsercreatetime(Long usercreatetime) {
		this.usercreatetime = usercreatetime;
	}

	
	
}
