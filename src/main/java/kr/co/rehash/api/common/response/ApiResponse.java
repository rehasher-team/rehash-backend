package kr.co.rehash.api.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // null 값은 제외
public class ApiResponse<T> {
    private final String resultType;
    private final String message;
    private final T data;

    public ApiResponse(ResponseType resultType, String message, T data) {
        this.resultType = resultType.getValue();
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(ResponseType.SUCCESS, message, data);
    }

    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(ResponseType.FAILURE, message, null);
    }

    public String getResultType() {
        return resultType;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}