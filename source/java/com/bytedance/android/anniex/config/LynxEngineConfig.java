package com.bytedance.android.anniex.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxEngineConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/config/LynxEngineConfig;", "", "expireMs", "", "disableCache", "", "(Ljava/lang/Long;Z)V", "getDisableCache", "()Z", "getExpireMs", "()Ljava/lang/Long;", "setExpireMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class LynxEngineConfig {
    private final boolean disableCache;
    private Long expireMs;

    public LynxEngineConfig(Long l, boolean z) {
        this.expireMs = l;
        this.disableCache = z;
    }

    public /* synthetic */ LynxEngineConfig(Long l, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, (i & 2) != 0 ? false : z);
    }

    public final Long getExpireMs() {
        return this.expireMs;
    }

    public final void setExpireMs(Long l) {
        this.expireMs = l;
    }

    public final boolean getDisableCache() {
        return this.disableCache;
    }
}
