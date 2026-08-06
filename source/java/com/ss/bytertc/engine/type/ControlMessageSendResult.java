package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum ControlMessageSendResult {
    CONTROL_MESSAGE_SEND_RESULT_SUCCESS(0),
    CONTROL_MESSAGE_SEND_RESULT_TIMEOUT(1),
    CONTROL_MESSAGE_SEND_RESULT_POST_PROCESS_PARSE_ERROR(2),
    CONTROL_MESSAGE_SEND_RESULT_NOT_JOIN(100),
    CONTROL_MESSAGE_SEND_RESULT_EXCEED_MAX_LENGTH(103),
    USER_MESSAGE_SEND_RESULT_UNKNOWN(1000);

    private int value;

    ControlMessageSendResult(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static ControlMessageSendResult fromId(int id) {
        for (ControlMessageSendResult controlMessageSendResult : values()) {
            if (controlMessageSendResult.value() == id) {
                return controlMessageSendResult;
            }
        }
        return null;
    }
}
