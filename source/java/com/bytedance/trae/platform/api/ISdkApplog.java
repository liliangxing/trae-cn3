package com.bytedance.trae.platform.api;

import android.os.Bundle;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: ISdkApplog.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/platform/api/ISdkApplog;", "", "reportEvent", "", "event", "", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "addApplogIdCallback", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/trae/platform/api/IApplogIdCallback;", "getDeviceId", "getUserUniqueID", "getUserID", "getInstallId", "putCommonParams", "params", "", "changeBgSessionTask", "resume", "", "setHeaderInfo", "key", "value", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ISdkApplog {
    void addApplogIdCallback(IApplogIdCallback callback);

    void changeBgSessionTask(boolean resume);

    String getDeviceId();

    String getInstallId();

    String getUserID();

    String getUserUniqueID();

    void putCommonParams(Map<String, String> params);

    void reportEvent(String event, Bundle bundleParams);

    void reportEvent(String event, JSONObject jsonParams);

    void setHeaderInfo(String key, Object value);
}
