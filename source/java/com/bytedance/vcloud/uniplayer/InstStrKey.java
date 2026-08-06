package com.bytedance.vcloud.uniplayer;

import com.bytedance.upc.cache.ApiHookRecord;
import kotlin.Metadata;

/* compiled from: UniAbKeys.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/InstStrKey;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SPADE_KEY", "DECRYPTION_KEY", "HTTP_HEADERS", "VIDEO_CHECK_INFO", "AUDIO_CHECK_INFO", "PLAY_TRACE_ID", "VOD_MEDIA_ID", "ENGINE_KEY_LOW_BOUND", "MAIN_TAG", "SUB_TAG", "CUSTOM_EVENTS", "CREATOR_LOG_ID", ApiHookRecord.KEY_DEVICE_ID, "CUSTOM_HEADERS", "DESIRED_GEAR_KEY", "FALLBACK_GEAR_LIST", "ENGINE_KEY_UPPER_BOUND", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum InstStrKey {
    SPADE_KEY(30001),
    DECRYPTION_KEY(30002),
    HTTP_HEADERS(30003),
    VIDEO_CHECK_INFO(30013),
    AUDIO_CHECK_INFO(30014),
    PLAY_TRACE_ID(30037),
    VOD_MEDIA_ID(30039),
    ENGINE_KEY_LOW_BOUND(68000),
    MAIN_TAG(68001),
    SUB_TAG(68002),
    CUSTOM_EVENTS(68003),
    CREATOR_LOG_ID(68004),
    DEVICE_ID(68005),
    CUSTOM_HEADERS(68006),
    DESIRED_GEAR_KEY(68007),
    FALLBACK_GEAR_LIST(68008),
    ENGINE_KEY_UPPER_BOUND(68999);

    private final int value;

    InstStrKey(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
