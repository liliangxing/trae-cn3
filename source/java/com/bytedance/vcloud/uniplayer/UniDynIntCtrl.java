package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;

/* compiled from: UniAbKeys.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniDynIntCtrl;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOOP_START_TIME_MS", "LOOP_END_TIME_MS", "VIDEO_AF_PROCESSOR_CTL", "TARGET_VOICE_TYPE", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum UniDynIntCtrl {
    LOOP_START_TIME_MS(25345),
    LOOP_END_TIME_MS(25346),
    VIDEO_AF_PROCESSOR_CTL(22015),
    TARGET_VOICE_TYPE(22006);

    private final int value;

    UniDynIntCtrl(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
