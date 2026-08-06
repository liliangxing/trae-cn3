package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum HardwareEchoDetectionResult {
    HARDWARE_ECHO_RESULT_CANCELED(0),
    HARDWARE_ECHO_RESULT_UNKNOWN(1),
    HARDWARE_ECHO_RESULT_NORMAL(2),
    HARDWARE_ECHO_RESULT_POOR(3);

    private final int value;

    public static HardwareEchoDetectionResult fromId(int type) {
        for (HardwareEchoDetectionResult hardwareEchoDetectionResult : values()) {
            if (hardwareEchoDetectionResult.value() == type) {
                return hardwareEchoDetectionResult;
            }
        }
        return HARDWARE_ECHO_RESULT_NORMAL;
    }

    public int value() {
        return this.value;
    }

    HardwareEchoDetectionResult(int value) {
        this.value = value;
    }
}
