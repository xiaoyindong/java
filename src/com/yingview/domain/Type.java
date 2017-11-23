package com.yingview.domain;

public class Type {
	private int typeId;
	private String typecode;
	private String typeName;
	private int typeparentId;
	private int typestatus = 1;
	
	public Type() {
		super();
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeparentId() {
		return typeparentId;
	}

	public void setTypeparentId(int typeparentId) {
		this.typeparentId = typeparentId;
	}

	public int getTypestatus() {
		return typestatus;
	}

	public void setTypestatus(int typestatus) {
		this.typestatus = typestatus;
	}
	
}