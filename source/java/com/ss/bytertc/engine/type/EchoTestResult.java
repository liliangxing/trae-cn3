package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum EchoTestResult {
    ECHO_TEST_SUCCESS(0),
    ECHO_TEST_TIMEOUT(1),
    ECHO_TEST_INTERVAL_SHORT(2),
    ECHO_TEST_AUDIO_DEVICE_ERROR(3),
    ECHO_TEST_VIDEO_DEVICE_ERROR(4),
    ECHO_TEST_AUDIO_RECEIVE_ERROR(5),
    ECHO_TEST_VIDEO_RECEIVE_ERROR(6),
    ECHO_TEST_INTERNAL_ERROR(7);

    private final int value;

    public static EchoTestResult fromId(int type) {
        for (EchoTestResult echoTestResult : values()) {
            if (echoTestResult.value() == type) {
                return echoTestResult;
            }
        }
        return ECHO_TEST_SUCCESS;
    }

    public int value() {
        return this.value;
    }

    EchoTestResult(int value) {
        this.value = value;
    }
}
