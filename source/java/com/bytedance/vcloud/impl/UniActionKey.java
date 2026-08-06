package com.bytedance.vcloud.impl;

import kotlin.Metadata;

/* compiled from: UniInternal.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/vcloud/impl/UniActionKey;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CHANGE_MUTE_STATUS", "CHANGE_PLAY_SPEED", "CHANGE_LOOP_STATUS", "CHANGE_AUDIO_VOLUME", "CHANGE_RADIO_MODE", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum UniActionKey {
    CHANGE_MUTE_STATUS(0),
    CHANGE_PLAY_SPEED(1),
    CHANGE_LOOP_STATUS(2),
    CHANGE_AUDIO_VOLUME(4),
    CHANGE_RADIO_MODE(5);

    private final int value;

    UniActionKey(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
