package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RoomStateChangeReason {
    JOIN_ROOM(0),
    RECONNECT(1),
    LEAVE_ROOM(2),
    JOIN_ROOM_FAILED(-2001),
    INVALID_TOKEN(-1000),
    TOKEN_EXPIRED(-1009),
    UPDATE_TOKEN_WITH_INVALID_TOKEN(-1010),
    ROOM_FORBIDDEN(-1025),
    USER_FORBIDDEN(-1026),
    KICKED_OUT(-1006),
    ROOM_DISMISS(-1011),
    DUPLICATE_LOGIN(-1004),
    WITHOUT_LICENSE_AUTHENTICATE_SDK(ErrorCode.ERROR_CODE_JOIN_ROOM_WITHOUT_LICENSE_AUTHENTICATE_SDK),
    SERVER_LICENSE_EXPIRED(ErrorCode.ERROR_CODE_SERVER_LICENSE_EXPIRE),
    EXCEEDS_THE_UPPER_LIMIT(ErrorCode.ERROR_CODE_EXCEEDS_THE_UPPER_LIMIT),
    LICENSE_PARAMETER_ERROR(ErrorCode.ERROR_CODE_LICENSE_PARAMETER_ERROR),
    LICENSE_FILE_PATH_ERROR(ErrorCode.ERROR_CODE_LICENSE_FILE_PATH_ERROR),
    LICENSE_ILLEGAL(ErrorCode.ERROR_CODE_LICENSE_ILLEGAL),
    LICENSE_EXPIRED(ErrorCode.ERROR_CODE_LICENSE_EXPIRED),
    LICENSE_INFORMATION_NOT_MATCH(ErrorCode.ERROR_CODE_LICENSE_INFORMATION_NOT_MATCH),
    LICENSE_NOT_MATCH_WITH_CACHE(ErrorCode.ERROR_CODE_LICENSE_NOT_MATCH_WITH_CACHE),
    LICENSE_FUNCTION_NOT_FOUND(ErrorCode.ERROR_CODE_JOIN_ROOM_LICENSE_FUNCTION_NOT_FOUND),
    STATE_ABNORMAL_SERVER_STATUS(ErrorCode.ERROR_CODE_ABNORMAL_SERVER_STATUS),
    UNKNOWN(-1001);

    private int value;

    RoomStateChangeReason(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RoomStateChangeReason valueOf(int value) {
        if (value == -2001) {
            return JOIN_ROOM_FAILED;
        }
        if (value == -1084) {
            return STATE_ABNORMAL_SERVER_STATUS;
        }
        if (value == -1006) {
            return KICKED_OUT;
        }
        if (value == -1004) {
            return DUPLICATE_LOGIN;
        }
        if (value == -1001) {
            return UNKNOWN;
        }
        if (value == -1000) {
            return INVALID_TOKEN;
        }
        if (value == 0) {
            return JOIN_ROOM;
        }
        if (value == 1) {
            return RECONNECT;
        }
        if (value == 2) {
            return LEAVE_ROOM;
        }
        switch (value) {
            case ErrorCode.ERROR_CODE_JOIN_ROOM_LICENSE_FUNCTION_NOT_FOUND /* -1027 */:
                return LICENSE_FUNCTION_NOT_FOUND;
            case -1026:
                return USER_FORBIDDEN;
            case -1025:
                return ROOM_FORBIDDEN;
            case ErrorCode.ERROR_CODE_LICENSE_NOT_MATCH_WITH_CACHE /* -1024 */:
                return LICENSE_NOT_MATCH_WITH_CACHE;
            case ErrorCode.ERROR_CODE_LICENSE_INFORMATION_NOT_MATCH /* -1023 */:
                return LICENSE_INFORMATION_NOT_MATCH;
            case ErrorCode.ERROR_CODE_LICENSE_EXPIRED /* -1022 */:
                return LICENSE_EXPIRED;
            case ErrorCode.ERROR_CODE_LICENSE_ILLEGAL /* -1021 */:
                return LICENSE_ILLEGAL;
            case ErrorCode.ERROR_CODE_LICENSE_FILE_PATH_ERROR /* -1020 */:
                return LICENSE_FILE_PATH_ERROR;
            case ErrorCode.ERROR_CODE_LICENSE_PARAMETER_ERROR /* -1019 */:
                return LICENSE_PARAMETER_ERROR;
            case ErrorCode.ERROR_CODE_EXCEEDS_THE_UPPER_LIMIT /* -1018 */:
                return EXCEEDS_THE_UPPER_LIMIT;
            case ErrorCode.ERROR_CODE_SERVER_LICENSE_EXPIRE /* -1017 */:
                return SERVER_LICENSE_EXPIRED;
            default:
                switch (value) {
                    case ErrorCode.ERROR_CODE_JOIN_ROOM_WITHOUT_LICENSE_AUTHENTICATE_SDK /* -1012 */:
                        return WITHOUT_LICENSE_AUTHENTICATE_SDK;
                    case -1011:
                        return ROOM_DISMISS;
                    case -1010:
                        return UPDATE_TOKEN_WITH_INVALID_TOKEN;
                    case -1009:
                        return TOKEN_EXPIRED;
                    default:
                        return null;
                }
        }
    }
}
