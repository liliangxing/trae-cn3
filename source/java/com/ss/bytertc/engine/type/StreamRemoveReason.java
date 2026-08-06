package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum StreamRemoveReason {
    STREAM_REMOVE_REASON_UNPUBLISH(0),
    STREAM_REMOVE_REASON_PUBLISH_FAILED(1),
    STREAM_REMOVE_REASON_KEEP_LIVE_FAILED(2),
    STREAM_REMOVE_REASON_CLIENT_DISCONNECTED(3),
    STREAM_REMOVE_REASON_REPUBLISH(4),
    STREAM_REMOVE_REASON_OTHER(5),
    STREAM_REMOVE_REASON_PUBLISH_PRIVILEGE_TOKEN_EXPIRED(6);

    private final int value;

    StreamRemoveReason() {
        this.value = 0;
    }

    public int value() {
        return this.value;
    }

    StreamRemoveReason(int value) {
        this.value = value;
    }

    public static StreamRemoveReason fromId(int type) {
        for (StreamRemoveReason streamRemoveReason : values()) {
            if (streamRemoveReason.value() == type) {
                return streamRemoveReason;
            }
        }
        return STREAM_REMOVE_REASON_UNPUBLISH;
    }
}
