package com.bytedance.trae.common.apphost.time;

import kotlin.Metadata;

/* compiled from: AppClock.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/common/apphost/time/AppClock;", "", "updateTimestamp", "", "timestampMillis", "", "currentTimeMillis", "apphost_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AppClock {
    long currentTimeMillis();

    void updateTimestamp(long timestampMillis);
}
