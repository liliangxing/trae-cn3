package com.bytedance.pitaya.api;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: PTYSettingsCallback.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/pitaya/api/PTYSettingsCallback;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", WebViewContainer.EVENT_getSettings, "Lorg/json/JSONObject;", "key", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface PTYSettingsCallback extends ReflectionCall {
    JSONObject getSettings(String key);
}
