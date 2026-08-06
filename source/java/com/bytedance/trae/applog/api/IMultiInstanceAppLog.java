package com.bytedance.trae.applog.api;

import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IMultiInstanceAppLogService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J,\u0010\u000f\u001a\u00020\u00032\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001`\u0012H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0001H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;", "", "init", "", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;", "reportEvent", "event", "", "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "setHeaderInfo", "custom", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "key", "value", "removeHeaderInfo", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IMultiInstanceAppLog {
    void init(Context context, MultiInstanceAppLogInitConfig config);

    void removeHeaderInfo(String key);

    void reportEvent(String event);

    void reportEvent(String event, Bundle bundleParams);

    void reportEvent(String event, JSONObject jsonParams);

    void setHeaderInfo(String key, Object value);

    void setHeaderInfo(HashMap<String, Object> custom);
}
