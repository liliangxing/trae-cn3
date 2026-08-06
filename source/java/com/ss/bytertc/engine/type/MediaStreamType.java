package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum MediaStreamType {
    RTC_MEDIA_STREAM_TYPE_AUDIO(1),
    RTC_MEDIA_STREAM_TYPE_VIDEO(2),
    RTC_MEDIA_STREAM_TYPE_BOTH(3);

    public final int value;

    MediaStreamType(int value) {
        this.value = value;
    }

    public static MediaStreamType valueOf(int value) {
        if (value == 1) {
            return RTC_MEDIA_STREAM_TYPE_AUDIO;
        }
        if (value == 2) {
            return RTC_MEDIA_STREAM_TYPE_VIDEO;
        }
        if (value != 3) {
            return null;
        }
        return RTC_MEDIA_STREAM_TYPE_BOTH;
    }
}
