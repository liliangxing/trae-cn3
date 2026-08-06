package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum SubtitleErrorCode {
    SUBTITLE_ERROR_CODE_UNKNOW(-1),
    SUBTITLE_ERROR_CODE_SUCCESS(0),
    SUBTITLE_ERROR_CODE_POST_PROCESS_ERROR(1),
    SUBTITLE_ERROR_CODE_ASR_CONNECTION_ERROR(2),
    SUBTITLE_ERROR_CODE_ASR_SERVICE_ERROR(3),
    SUBTITLE_ERROR_CODE_BEFORE_JOIN_ROOM(4),
    SUBTITLE_ERROR_CODE_ALREADY_ON(5),
    SUBTITLE_ERROR_CODE_UNSUPPORTED_LANGUAGE(6),
    SUBTITLE_ERROR_CODE_POST_PROCESS_TIMEOUT(7);

    private int value;

    SubtitleErrorCode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static SubtitleErrorCode fromId(int type) {
        for (SubtitleErrorCode subtitleErrorCode : values()) {
            if (subtitleErrorCode.value() == type) {
                return subtitleErrorCode;
            }
        }
        return SUBTITLE_ERROR_CODE_UNKNOW;
    }
}
