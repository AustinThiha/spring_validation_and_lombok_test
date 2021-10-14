package kth.chem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import kth.chem.response.JsonServerResponse;
import kth.chem.response.ResponseHandler;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(BadRequestException ex, WebRequest request) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put(ResourceNotFoundException.class.getName(), ex.getMessage());
		JsonServerResponse<?> apiResponse = ResponseHandler.createErrorResponse(HttpStatus.BAD_REQUEST.value(),
				hashMap);
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put(ResourceNotFoundException.class.getName(), ex.getMessage());
		JsonServerResponse<?> apiResponse = ResponseHandler.createErrorResponse(HttpStatus.NOT_FOUND.value(), hashMap);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException exception, WebRequest request) {

		Map<String, String> errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put(ResourceNotFoundException.class.getName(), exception.getMessage());
		JsonServerResponse<?> apiResponse = ResponseHandler.createErrorResponse(HttpStatus.NOT_FOUND.value(), hashMap);
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put(ResourceNotFoundException.class.getName(), ex.getMessage());
		JsonServerResponse<?> apiResponse = ResponseHandler
				.createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), hashMap);
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}