package kr.co.rehash.api.common.exception;

import kr.co.rehash.api.common.response.ApiResponse;
import kr.co.rehash.api.common.response.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Object>> handleCustomException(CustomException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity
                .status(errorCode.getHttpStatus()) // HttpStatus 가져오기
                .body(ApiResponse.failure(errorCode.getMessage()));
    }

    @ExceptionHandler(Exception.class) // 예상치 못한 예외 발생 처리
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(ErrorCode.SERVER_ERROR.getHttpStatus())
                .body(ApiResponse.failure(ErrorCode.SERVER_ERROR.getMessage()));
    }
}
