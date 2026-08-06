package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;

/* compiled from: UniAbKeys.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/InstFltKey;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "AE_TARGET_LOUDNESS", "AE_SRC_LUFS", "AE_SRC_PEAK", "ENGINE_KEY_LOW_BOUND", "AUDIO_VOLUME_FLT", "PLAYBACK_SPEED_FLT", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum InstFltKey {
    AE_TARGET_LOUDNESS(37001),
    AE_SRC_LUFS(37002),
    AE_SRC_PEAK(37003),
    ENGINE_KEY_LOW_BOUND(69000),
    AUDIO_VOLUME_FLT(69001),
    PLAYBACK_SPEED_FLT(69002);

    private final int value;

    InstFltKey(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
