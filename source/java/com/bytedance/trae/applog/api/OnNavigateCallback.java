package com.bytedance.trae.applog.api;

import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: OnNavigateCallback.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/applog/api/OnNavigateCallback;", "", "onResume", "", "activityName", "", "flatParams", "Lorg/json/JSONObject;", WebViewContainer.EVENT_onPause, "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface OnNavigateCallback {
    void onPause(String activityName, JSONObject flatParams);

    void onResume(String activityName, JSONObject flatParams);
}
