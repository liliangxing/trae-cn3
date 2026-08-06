package com.ss.bytertc.engine.aigc;

/* loaded from: classes7.dex */
public enum StartSessionResult {
    START_SESSION_RESULT_SUCCESS(0),
    START_SESSION_RESULT_HAS_IN_SESSION(1),
    START_SESSION_RESULT_JOIN_ROOM_FAILED(2),
    START_SESSION_RESULT_CONNECTION_FAILED(3),
    START_SESSION_RESULT_POST_PROCESS_ERROR(4),
    START_SESSION_RESULT_TIMEOUT(5),
    START_SESSION_RESULT_USER_CANCEL(6);

    private final int value;

    StartSessionResult() {
        this.value = 0;
    }

    public int value() {
        return this.value;
    }

    StartSessionResult(int value) {
        this.value = value;
    }

    public static StartSessionResult fromId(int type) {
        for (StartSessionResult startSessionResult : values()) {
            if (startSessionResult.value() == type) {
                return startSessionResult;
            }
        }
        return START_SESSION_RESULT_SUCCESS;
    }
}
