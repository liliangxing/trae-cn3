package com.bytedance.vcloud.uniplayer;

import androidx.webkit.Profile;
import kotlin.Metadata;

/* compiled from: UniAVEngine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/BufferingReason;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", Profile.DEFAULT_PROFILE_NAME, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum BufferingReason {
    Default(0);

    private final int value;

    BufferingReason(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
