package com.bytedance.android.monitorV2.webview.util;

import com.bytedance.android.monitorV2.entity.JSBError;
import com.bytedance.android.monitorV2.entity.JSBInfo;
import com.bytedance.android.monitorV2.util.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: EventTransUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J?\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/util/EventTransUtils;", "", "()V", "getJSBInfoJsonObj", "Lorg/json/JSONObject;", "jsbInfo", "Lcom/bytedance/android/monitorV2/entity/JSBInfo;", "getJsbErrorJsonObj", "jsbError", "Lcom/bytedance/android/monitorV2/entity/JSBError;", "getNativeErrorJsonObj", "url", "", "isMainFrame", "", "errorCode", "", "message", "httpCode", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class EventTransUtils {
    public static final EventTransUtils INSTANCE = new EventTransUtils();

    private EventTransUtils() {
    }

    @JvmStatic
    public static final JSONObject getNativeErrorJsonObj(String url, Boolean isMainFrame, Integer errorCode, String message, Integer httpCode) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "event_type", "nativeError");
        if (errorCode != null) {
            errorCode.intValue();
            JsonUtils.safePut(jSONObject, "error_code", errorCode.intValue());
        }
        if (message != null) {
            JsonUtils.safePut(jSONObject, "error_msg", message);
        }
        if (isMainFrame == null) {
            JsonUtils.safePut(jSONObject, "scene", "web_process_terminate");
        } else {
            JsonUtils.safePut(jSONObject, "scene", isMainFrame.booleanValue() ? "main_frame" : "child_resource");
        }
        if (url != null) {
            JsonUtils.safePut(jSONObject, "error_url", url);
        }
        if (httpCode != null) {
            httpCode.intValue();
            JsonUtils.safePut(jSONObject, "http_status", httpCode.intValue());
        }
        return jSONObject;
    }

    @JvmStatic
    public static final JSONObject getJsbErrorJsonObj(JSBError jsbError) {
        Intrinsics.checkNotNullParameter(jsbError, "jsbError");
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "event_type", "jsbError");
        JsonUtils.safePut(jSONObject, "bridge_name", jsbError.bridgeName);
        JsonUtils.safePut(jSONObject, "error_activity", jsbError.errorActivity);
        JsonUtils.safePut(jSONObject, "error_code", jsbError.errorCode);
        JsonUtils.safePut(jSONObject, "error_message", jsbError.errorMessage);
        JsonUtils.safePut(jSONObject, "js_type", jsbError.eventType);
        JsonUtils.safePut(jSONObject, "error_url", jsbError.errorUrl);
        JsonUtils.safePut(jSONObject, "is_sync", jsbError.isSync);
        return jSONObject;
    }

    @JvmStatic
    public static final JSONObject getJSBInfoJsonObj(JSBInfo jsbInfo) {
        Intrinsics.checkNotNullParameter(jsbInfo, "jsbInfo");
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "event_type", "jsbPerf");
        JsonUtils.safePut(jSONObject, "bridge_name", jsbInfo.bridgeName);
        JsonUtils.safePut(jSONObject, "status_code", jsbInfo.statusCode);
        JsonUtils.safePut(jSONObject, "status_description", jsbInfo.statusDescription);
        JsonUtils.safePut(jSONObject, "protocol_version", jsbInfo.protocolVersion);
        JsonUtils.safePut(jSONObject, "cost_time", jsbInfo.costTime);
        JsonUtils.safePut(jSONObject, "invoke_ts", jsbInfo.invokeTime);
        JsonUtils.safePut(jSONObject, "callback_ts", jsbInfo.callbackTime);
        JsonUtils.safePut(jSONObject, "fireEvent_ts", jsbInfo.fireEventTime);
        JsonUtils.safePut(jSONObject, "request_url", jsbInfo.requestUrl);
        return jSONObject;
    }
}
