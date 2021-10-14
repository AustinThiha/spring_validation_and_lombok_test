package kth.chem.response;

import kth.chem.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {

	private String code;
	private String message;
	private T result;

	public static ApiResponse<?> create() {
		ApiResponse<?> response = new ApiResponse<>();
		response.code = Constant.OK;
		response.message = Constant.SUCCESS;
		return response;
	}
}