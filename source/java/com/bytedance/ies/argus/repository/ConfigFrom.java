package com.bytedance.ies.argus.repository;

import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import kotlin.Metadata;

/* compiled from: ArgusConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/repository/ConfigFrom;", "", "strValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStrValue", "()Ljava/lang/String;", "EMPTY", "SETTING", "GECKO", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ConfigFrom {
    EMPTY(VoiceAttemptMetricsTracker.FINAL_SOURCE_EMPTY),
    SETTING("setting"),
    GECKO("gecko");

    private final String strValue;

    ConfigFrom(String str) {
        this.strValue = str;
    }

    public final String getStrValue() {
        return this.strValue;
    }
}
