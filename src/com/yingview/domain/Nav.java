package com.yingview.domain;

public class Nav {
	private int navId;
	private int navindex;
	private String navname;
	private String navurl;
	private int navstatus;
	private int navlevel;
	private String navtarget;
	public Nav() {
		super();
	}
	public Nav(int navId, int navindex, String navname, String navurl, int navstatus, int navlevel, String navtarget) {
		super();
		this.navId = navId;
		this.navindex = navindex;
		this.navname = navname;
		this.navurl = navurl;
		this.navstatus = navstatus;
		this.navlevel = navlevel;
		this.navtarget = navtarget;
	}
	public int getNavId() {
		return navId;
	}
	public void setNavId(int navId) {
		this.navId = navId;
	}
	public int getNavindex() {
		return navindex;
	}
	public void setNavindex(int navindex) {
		this.navindex = navindex;
	}
	public String getNavname() {
		return navname;
	}
	public void setNavname(String navname) {
		this.navname = navname;
	}
	public String getNavurl() {
		return navurl;
	}
	public void setNavurl(String navurl) {
		this.navurl = navurl;
	}
	public int getNavstatus() {
		return navstatus;
	}
	public void setNavstatus(int navstatus) {
		this.navstatus = navstatus;
	}
	public int getNavlevel() {
		return navlevel;
	}
	public void setNavlevel(int navlevel) {
		this.navlevel = navlevel;
	}
	public String getNavtarget() {
		return navtarget;
	}
	public void setNavtarget(String navtarget) {
		this.navtarget = navtarget;
	}
	
}
