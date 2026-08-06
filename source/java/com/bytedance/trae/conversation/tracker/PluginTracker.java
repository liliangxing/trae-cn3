package com.bytedance.trae.conversation.tracker;

import android.util.Log;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IXiguaService;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.platform.service.ApmService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PluginTracker.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J*\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u001e\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J&\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J$\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/tracker/PluginTracker;", "", "<init>", "()V", "TAG", "", "SLARDAR_EVENT", "trackAuthStart", "", "platform", "entry", "trackAuthResult", "itemId", "connectorId", "result", AccountMonitorConstants.CommonParameter.ERROR, "trackAuthSuccess", "durationMs", "", "authMethod", "trackAuthFail", "failReason", "trackPluginInclude", "itemType", "mode", "trackPluginInvoked", "invokeType", "reportEvent", Fields.EVENT, "params", "Lorg/json/JSONObject;", "metric", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginTracker {
    public static final PluginTracker INSTANCE = new PluginTracker();
    private static final String SLARDAR_EVENT = "plugin_connector_funnel";
    private static final String TAG = "PluginTracker";

    private PluginTracker() {
    }

    public final void trackAuthStart(String platform, String entry) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(entry, "entry");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", platform);
        jSONObject.put("entry", entry);
        reportEvent$default(this, PluginEvent.CONNECTOR_AUTH_START, jSONObject, null, 4, null);
    }

    public static /* synthetic */ void trackAuthResult$default(PluginTracker pluginTracker, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = null;
        }
        pluginTracker.trackAuthResult(str, str2, str3, str4);
    }

    public final void trackAuthResult(String itemId, String connectorId, String result, String errorCode) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(connectorId, "connectorId");
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_id", itemId);
        jSONObject.put("connector_id", connectorId);
        jSONObject.put("result", result);
        if (errorCode != null) {
            jSONObject.put("error_code", errorCode);
        }
        reportEvent$default(this, PluginEvent.CONNECTOR_AUTH_RESULT, jSONObject, null, 4, null);
    }

    public final void trackAuthSuccess(String platform, long durationMs, String authMethod) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(authMethod, "authMethod");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", platform);
        jSONObject.put("duration_ms", durationMs);
        jSONObject.put(IXiguaService.ResponseConstants.AUTH_METHOD, authMethod);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("duration_ms", durationMs);
        reportEvent(PluginEvent.CONNECTOR_AUTH_SUCCESS, jSONObject, jSONObject2);
    }

    public final void trackAuthFail(String platform, String failReason) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(failReason, "failReason");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", platform);
        jSONObject.put("fail_reason", failReason);
        reportEvent$default(this, PluginEvent.CONNECTOR_AUTH_FAIL, jSONObject, null, 4, null);
    }

    public final void trackPluginInclude(String itemId, String itemType, String mode) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_id", itemId);
        jSONObject.put("item_type", itemType);
        jSONObject.put("mode", mode);
        reportEvent$default(this, PluginEvent.CHAT_PLUGIN_INCLUDE, jSONObject, null, 4, null);
    }

    public final void trackPluginInvoked(String itemId, String itemType, String invokeType, String mode) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(invokeType, "invokeType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_id", itemId);
        jSONObject.put("item_type", itemType);
        jSONObject.put("invoke_type", invokeType);
        jSONObject.put("mode", mode);
        reportEvent$default(this, PluginEvent.CHAT_PLUGIN_INVOKED, jSONObject, null, 4, null);
    }

    static /* synthetic */ void reportEvent$default(PluginTracker pluginTracker, String str, JSONObject jSONObject, JSONObject jSONObject2, int i, Object obj) {
        if ((i & 4) != 0) {
            jSONObject2 = null;
        }
        pluginTracker.reportEvent(str, jSONObject, jSONObject2);
    }

    private final void reportEvent(String event, JSONObject params, JSONObject metric) {
        Iterator<String> keys;
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: " + event + ", params: " + params);
        }
        IApplog.INSTANCE.reportEvent(event, params);
        JSONObject jSONObject = new JSONObject(params.toString());
        jSONObject.put("stage", event);
        if (metric != null && (keys = metric.keys()) != null) {
            while (keys.hasNext()) {
                jSONObject.remove(keys.next());
            }
        }
        ApmService.INSTANCE.monitorEventForSlardar(SLARDAR_EVENT, jSONObject, metric, (JSONObject) null);
    }
}
