package kr.co.rehash.api.common.response;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    // 403: 권한 없음
    FORBIDDEN(HttpStatus.FORBIDDEN, "권한이 없습니다."),
    // 404: Not Found
    NOT_FOUND(HttpStatus.NOT_FOUND, "데이터가 없습니다."),
    // 503: 서버 오류
    SERVER_ERROR(HttpStatus.SERVICE_UNAVAILABLE, "예상치 못한 서버 오류가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
