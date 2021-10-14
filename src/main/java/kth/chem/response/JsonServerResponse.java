package kth.chem.response;

import java.util.HashMap;
import java.util.List;

public class JsonServerResponse<T> {
	private String message;
	private int status;
	private List<T> data;
	private Long timestamp;
	private List<HashMap<String, String>> error;

	public JsonServerResponse() {
		timestamp = System.currentTimeMillis();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public List<HashMap<String, String>> getError() {
		return error;
	}

	public void setError(List<HashMap<String, String>> errors) {
		this.error = errors;
	}

	public long getTimestamp() {
		return timestamp;
	}

}