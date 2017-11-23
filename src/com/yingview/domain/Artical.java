package com.yingview.domain;

public class Artical {
	private int articalId = 0;
	private String articalcode;
	private String articaltitle;
	private int userId;
	private int typeId;
	private String articalcontent;
	private String articalphoto;
	private String articalimages;
	private Long articalcreateDate = 0L;
	private String articaltype;
	private int articalview;
	private int articalmark;
	private int articalcommentNum;
	private int articalstatus = 0;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articalId;
		result = prime * result + ((articalcode == null) ? 0 : articalcode.hashCode());
		result = prime * result + articalcommentNum;
		result = prime * result + ((articalcontent == null) ? 0 : articalcontent.hashCode());
		result = prime * result + ((articalcreateDate == null) ? 0 : articalcreateDate.hashCode());
		result = prime * result + ((articalimages == null) ? 0 : articalimages.hashCode());
		result = prime * result + articalmark;
		result = prime * result + ((articalphoto == null) ? 0 : articalphoto.hashCode());
		result = prime * result + articalstatus;
		result = prime * result + ((articaltitle == null) ? 0 : articaltitle.hashCode());
		result = prime * result + ((articaltype == null) ? 0 : articaltype.hashCode());
		result = prime * result + articalview;
		result = prime * result + typeId;
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artical other = (Artical) obj;
		if (articalId != other.articalId)
			return false;
		if (articalcode == null) {
			if (other.articalcode != null)
				return false;
		} else if (!articalcode.equals(other.articalcode))
			return false;
		if (articalcommentNum != other.articalcommentNum)
			return false;
		if (articalcontent == null) {
			if (other.articalcontent != null)
				return false;
		} else if (!articalcontent.equals(other.articalcontent))
			return false;
		if (articalcreateDate == null) {
			if (other.articalcreateDate != null)
				return false;
		} else if (!articalcreateDate.equals(other.articalcreateDate))
			return false;
		if (articalimages == null) {
			if (other.articalimages != null)
				return false;
		} else if (!articalimages.equals(other.articalimages))
			return false;
		if (articalmark != other.articalmark)
			return false;
		if (articalphoto == null) {
			if (other.articalphoto != null)
				return false;
		} else if (!articalphoto.equals(other.articalphoto))
			return false;
		if (articalstatus != other.articalstatus)
			return false;
		if (articaltitle == null) {
			if (other.articaltitle != null)
				return false;
		} else if (!articaltitle.equals(other.articaltitle))
			return false;
		if (articaltype == null) {
			if (other.articaltype != null)
				return false;
		} else if (!articaltype.equals(other.articaltype))
			return false;
		if (articalview != other.articalview)
			return false;
		if (typeId != other.typeId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public Artical() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getArticalId() {
		return articalId;
	}
	public void setArticalId(int articalId) {
		this.articalId = articalId;
	}
	public String getArticalcode() {
		return articalcode;
	}
	public void setArticalcode(String articalcode) {
		this.articalcode = articalcode;
	}
	public String getArticaltitle() {
		return articaltitle;
	}
	public void setArticaltitle(String articaltitle) {
		this.articaltitle = articaltitle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getArticalcontent() {
		return articalcontent;
	}
	public void setArticalcontent(String articalcontent) {
		this.articalcontent = articalcontent;
	}
	public String getArticalphoto() {
		return articalphoto;
	}
	public void setArticalphoto(String articalphoto) {
		this.articalphoto = articalphoto;
	}
	public String getArticalimages() {
		return articalimages;
	}
	public void setArticalimages(String articalimages) {
		this.articalimages = articalimages;
	}
	public Long getArticalcreateDate() {
		return articalcreateDate;
	}
	public void setArticalcreateDate(Long articalcreateDate) {
		this.articalcreateDate = articalcreateDate;
	}
	public String getArticaltype() {
		return articaltype;
	}
	public void setArticaltype(String articaltype) {
		this.articaltype = articaltype;
	}
	public int getArticalview() {
		return articalview;
	}
	public void setArticalview(int articalview) {
		this.articalview = articalview;
	}
	public int getArticalmark() {
		return articalmark;
	}
	public void setArticalmark(int articalmark) {
		this.articalmark = articalmark;
	}
	public int getArticalcommentNum() {
		return articalcommentNum;
	}
	public void setArticalcommentNum(int articalcommentNum) {
		this.articalcommentNum = articalcommentNum;
	}
	public int getArticalstatus() {
		return articalstatus;
	}
	public void setArticalstatus(int articalstatus) {
		this.articalstatus = articalstatus;
	}
	
	
}