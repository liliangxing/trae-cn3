package com.bytedance.trae.conversation.settings;

import kotlin.Metadata;

/* compiled from: ICNBusinessSettings.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/settings/BusinessSettings;", "", "fastPassNotifyCount", "", "fastPassNotifyInterval", "<init>", "(JJ)V", "getFastPassNotifyCount", "()J", "getFastPassNotifyInterval", "setFastPassNotifyInterval", "(J)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BusinessSettings {
    private final long fastPassNotifyCount;
    private long fastPassNotifyInterval;

    public BusinessSettings(long j, long j2) {
        this.fastPassNotifyCount = j;
        this.fastPassNotifyInterval = j2;
    }

    public final long getFastPassNotifyCount() {
        return this.fastPassNotifyCount;
    }

    public final long getFastPassNotifyInterval() {
        return this.fastPassNotifyInterval;
    }

    public final void setFastPassNotifyInterval(long j) {
        this.fastPassNotifyInterval = j;
    }
}
