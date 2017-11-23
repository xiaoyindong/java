package com.yingview.toweb;

import java.util.HashMap;
import java.util.Map;

public class ReturnData {
	boolean hasError = false;
	boolean success = true;
	Map<String,Object> content;
	public boolean isHasError() {
		return hasError;
	}
	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map<String, Object> getContent() {
		return content;
	}
	public void setContent(Map<String, Object> content) {
		this.content = content;
	}
}
