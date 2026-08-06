package com.bytedance.trae.applog.api;

import kotlin.Metadata;

/* compiled from: OnLaunchCallback.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/applog/api/OnLaunchCallback;", "", "onLaunch", "", "sessionId", "", "timestamp", "", "isBackground", "", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface OnLaunchCallback {
    void onLaunch(String sessionId, long timestamp, boolean isBackground);
}
