package kth.chem.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseHandler {
	public static final String SUCCESS = "Success";
	public static final String FAIL = "Fail";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static JsonServerResponse<?> createSuccessResponse(Object object) {
		JsonServerResponse<?> jsonResponse = new JsonServerResponse<>();
		jsonResponse.setMessage(SUCCESS);
		jsonResponse.setStatus(HttpStatus.OK.value());
		List dataList = new ArrayList<>();
		dataList.add(object);
		jsonResponse.setData(dataList);
		jsonResponse.setError(new ArrayList<>());
		return jsonResponse;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static JsonServerResponse<?> createErrorResponse(int statusCode,HashMap<String, String> errors) {
		JsonServerResponse<?> jsonResponse = new JsonServerResponse<>();
		jsonResponse.setMessage(FAIL);
		jsonResponse.setStatus(statusCode);
		List dataList = new ArrayList<>();
		jsonResponse.setData(dataList);
		List errorList = new ArrayList<>();
		errorList.add(errors);
		jsonResponse.setError(errorList);
		return jsonResponse;
	}

}