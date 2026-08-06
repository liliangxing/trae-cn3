package com.bytedance.android.monitorV2.checker;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.PiaEvent;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.standard.ContainerStandardConst;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.forest.model.PreloadConfig;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DoubleReportChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/monitorV2/checker/DoubleReportChecker;", "", "()V", "method", "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "reportAllCase", "", "eventName", "", "bid", "reportAllCaseBeforeSample", "reportJsbPvV2", "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "reportPiaEventCase", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "jsonObj", "Lorg/json/JSONObject;", "reportPvEventCase", "data", "hitSample", "", "reportSampleCase", "reportSampleCaseBeforeSend", "reportSlardar", "reportTea", "params", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DoubleReportChecker {
    public static final DoubleReportChecker INSTANCE = new DoubleReportChecker();
    private static Method method;

    private DoubleReportChecker() {
    }

    public final Method getMethod() {
        return method;
    }

    public final void setMethod(Method method2) {
        method = method2;
    }

    static {
        try {
            method = Class.forName("com.ss.android.common.lib.AppLogNewUtils").getMethod("onEventV3", String.class, JSONObject.class);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    public final void reportPvEventCase(CommonEvent data, String bid, boolean hitSample) {
        String optString;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (HybridMultiMonitor.getInstance().getHybridSettingManager().getSwitch().isEnableTeaReport() && Intrinsics.areEqual("navigationStart", data.getEventType())) {
            JSONObject jSONObject = new JSONObject();
            if (data.getNativeBase() == null || data.getContainerBase() == null) {
                return;
            }
            JSONObject jsonObject = data.getNativeBase().toJsonObject();
            if (jsonObject != null) {
                Intrinsics.checkNotNullExpressionValue(jsonObject, "nativeBaseJO");
                JsonUtils.safePut(jSONObject, "url", JsonUtils.safeOptStr(jsonObject, "url"));
                String safeOptStr = JsonUtils.safeOptStr(jsonObject, "container_type");
                JsonUtils.safePut(jSONObject, "engine_type", safeOptStr);
                if (Intrinsics.areEqual("lynx", safeOptStr)) {
                    optString = jsonObject.optString("lynx_version", null);
                } else {
                    optString = Intrinsics.areEqual("web", safeOptStr) ? jsonObject.optString(ReportConst.WEB_VERSION, null) : null;
                }
                if (optString != null) {
                    JsonUtils.safePut(jSONObject, "engine_version", optString);
                }
                String optString2 = jsonObject.optString("native_page", null);
                if (optString2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"native_page\", null)");
                    JsonUtils.safePut(jSONObject, "native_page", optString2);
                }
                JsonUtils.safePut(jSONObject, "sdk_version", JsonUtils.safeOptStr(jsonObject, "sdk_version"));
            }
            ContainerBase containerBase = data.getContainerBase();
            JSONObject jsonObject2 = containerBase != null ? containerBase.toJsonObject() : null;
            if (jsonObject2 != null) {
                String optString3 = jsonObject2.optString("schema", null);
                if (optString3 != null) {
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(ContainerStand…Const.FIELD_SCHEMA, null)");
                    JsonUtils.safePut(jSONObject, "schema", optString3);
                }
                JsonUtils.safePut(jSONObject, "container_name", jsonObject2.optString("container_name", PreloadConfig.KEY_OTHER));
                String optString4 = jsonObject2.optString(ContainerStandardConst.FIELD_CONTAINER_VERSION, null);
                if (optString4 != null) {
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(ContainerStand…_CONTAINER_VERSION, null)");
                    JsonUtils.safePut(jSONObject, ContainerStandardConst.FIELD_CONTAINER_VERSION, optString4);
                }
            }
            JsonUtils.safePut(jSONObject, "bid", bid);
            JsonUtils.safePut(jSONObject, "is_hybrid_sample", hitSample ? 1 : 0);
            HybridSettingInitConfig initConfig = HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig();
            JsonUtils.safePut(jSONObject, "origin_appid", initConfig != null ? initConfig.getAid() : "");
            reportTea("bd_hybrid_monitor_pv", jSONObject);
        }
    }

    public final void reportPiaEventCase(CustomEvent event, JSONObject jsonObj) {
        CustomInfo customInfo;
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        try {
            if (!(event instanceof PiaEvent) || (customInfo = event.getCustomInfo()) == null) {
                return;
            }
            JSONObject safeOptJsonObj = JsonUtils.safeOptJsonObj(jsonObj, ReportConst.Params.BID_INFO);
            JSONObject safeOptJsonObj2 = JsonUtils.safeOptJsonObj(jsonObj, "nativeBase");
            JSONObject safeOptJsonObj3 = JsonUtils.safeOptJsonObj(jsonObj, "containerBase");
            JSONObject jSONObject = new JSONObject();
            String safeOptStr = JsonUtils.safeOptStr(safeOptJsonObj, ReportConst.Params.SETTING_BID);
            String safeOptStr2 = JsonUtils.safeOptStr(safeOptJsonObj, "bid");
            String safeOptStr3 = JsonUtils.safeOptStr(safeOptJsonObj2, "navigation_id");
            String safeOptStr4 = JsonUtils.safeOptStr(safeOptJsonObj2, "url");
            boolean safeOptBool = JsonUtils.safeOptBool(safeOptJsonObj2, "container_reuse", false);
            String safeOptStr5 = JsonUtils.safeOptStr(safeOptJsonObj2, ReportConst.WEB_VERSION);
            CustomInfo customInfo2 = event.getCustomInfo();
            String safeOptStr6 = JsonUtils.safeOptStr(customInfo2 != null ? customInfo2.getCommon() : null, "virtual_aid");
            JsonUtils.safePut(jSONObject, "common_protocol_version", 1);
            JsonUtils.safePut(jSONObject, "common_original_aid", safeOptStr6);
            JsonUtils.safePut(jSONObject, "common_bid", safeOptStr2);
            JsonUtils.safePut(jSONObject, "common_bid_setting", safeOptStr);
            JsonUtils.safePut(jSONObject, "common_sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
            JsonUtils.safePut(jSONObject, "common_url", safeOptStr4);
            JsonUtils.safePut(jSONObject, "common_navigation_id", safeOptStr3);
            JsonUtils.safePut(jSONObject, "common_container_reuse", Boolean.valueOf(safeOptBool));
            JsonUtils.safePut(jSONObject, "common_web_engine_version", safeOptStr5);
            String safeOptStr7 = JsonUtils.safeOptStr(safeOptJsonObj2, "native_page", null);
            String safeOptStr8 = JsonUtils.safeOptStr(safeOptJsonObj3, "container_name", null);
            String safeOptStr9 = JsonUtils.safeOptStr(safeOptJsonObj3, "schema", null);
            JsonUtils.putIfNotNull(jSONObject, "common_native_page", safeOptStr7);
            JsonUtils.putIfNotNull(jSONObject, "common_container_name", safeOptStr8);
            JsonUtils.putIfNotNull(jSONObject, "common_schema", safeOptStr9);
            JSONObject jSONObject2 = new JSONObject();
            CustomInfo customInfo3 = event.getCustomInfo();
            JsonUtils.merge(jSONObject2, customInfo3 != null ? customInfo3.getCategory() : null);
            CustomInfo customInfo4 = event.getCustomInfo();
            JsonUtils.merge(jSONObject2, customInfo4 != null ? customInfo4.getMetric() : null);
            JsonUtils.merge(jSONObject2, jSONObject);
            INSTANCE.reportTea("bd_hybrid_monitor_" + customInfo.getEventName(), jSONObject2);
        } catch (JSONException e) {
            ExceptionUtil.handleException(e);
        }
    }

    public final void reportAllCase(String eventName, String bid) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (!TextUtils.isEmpty(eventName) && ConvertUtil.isSampleForTea(bid)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "event_name", eventName);
            JsonUtils.safePut(jSONObject, "bid", bid);
            reportTea("hybridmonitor_report_all", jSONObject);
            reportSlardar(eventName, bid);
        }
    }

    public final void reportAllCaseBeforeSample(String eventName, String bid) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (!TextUtils.isEmpty(eventName) && ConvertUtil.isSampleForTea(bid)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "event_name", eventName);
            JsonUtils.safePut(jSONObject, "bid", bid);
            reportTea("hybridmonitor_report_all_before_sample", jSONObject);
        }
    }

    public final void reportSampleCase(String eventName, String bid) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (!TextUtils.isEmpty(eventName) && ConvertUtil.isSampleForTea(bid)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "event_name", eventName);
            JsonUtils.safePut(jSONObject, "bid", bid);
            reportTea("hybridmonitor_report_sample", jSONObject);
        }
    }

    public final void reportJsbPvV2(CommonEvent event, String bid) {
        String optString;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (HybridMultiMonitor.getInstance().getHybridSettingManager().getSwitch().isEnableTeaReport()) {
            if (event.getContainerBase() == null || !Intrinsics.areEqual(ReportConst.Event.JSB_PAGE_VISIT, event.getEventType())) {
                return;
            }
            JSONObject jsonObject = event.getNativeBase().toJsonObject();
            String safeOptStr = JsonUtils.safeOptStr(jsonObject, "container_type");
            if (Intrinsics.areEqual(safeOptStr, "lynx")) {
                optString = jsonObject.optString("lynx_version", null);
            } else {
                optString = Intrinsics.areEqual(safeOptStr, "web") ? jsonObject.optString(ReportConst.WEB_VERSION, null) : null;
            }
            ContainerBase containerBase = event.getContainerBase();
            JSONObject jsonObject2 = containerBase != null ? containerBase.toJsonObject() : null;
            BaseNativeInfo nativeInfo = event.getNativeInfo();
            JSONObject jsonObject3 = nativeInfo != null ? nativeInfo.toJsonObject() : null;
            HybridSettingInitConfig initConfig = HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig();
            String aid = initConfig != null ? initConfig.getAid() : "";
            String safeOptStr2 = JsonUtils.safeOptStr(jsonObject, "url", "");
            String safeOptStr3 = JsonUtils.safeOptStr(jsonObject2, "container_name", PreloadConfig.KEY_OTHER);
            String safeOptStr4 = JsonUtils.safeOptStr(jsonObject2, "schema", null);
            String safeOptStr5 = JsonUtils.safeOptStr(jsonObject2, ContainerStandardConst.FIELD_CONTAINER_VERSION, null);
            JSONObject merge = JsonUtils.merge(null, jsonObject3);
            JsonUtils.putIfNotNull(merge, "url", safeOptStr2);
            JsonUtils.putIfNotNull(merge, "engine_version", optString);
            JsonUtils.putIfNotNull(merge, "engine_type", safeOptStr);
            JsonUtils.putIfNotNull(merge, "schema", safeOptStr4);
            JsonUtils.putIfNotNull(merge, ContainerStandardConst.FIELD_CONTAINER_VERSION, safeOptStr5);
            JsonUtils.putIfNotNull(merge, "container_name", safeOptStr3);
            JsonUtils.putIfNotNull(merge, "bid", bid);
            JsonUtils.putIfNotNull(merge, "origin_appid", aid);
            Intrinsics.checkNotNullExpressionValue(merge, "params");
            reportTea("bd_hybrid_monitor_jsb_pv", merge);
            event.onEventUploaded();
        }
    }

    public final void reportSampleCaseBeforeSend(String eventName, String bid) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (!TextUtils.isEmpty(eventName) && ConvertUtil.isSampleForTea(bid)) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "event_name", eventName);
            JsonUtils.safePut(jSONObject, "bid", bid);
            reportTea("hybridmonitor_report_sample_before_send", jSONObject);
        }
    }

    private final void reportSlardar(String eventName, String bid) {
        ApmAgent.monitorEvent("bd_hybrid_monitor_service_all_in_one", null, null, new JSONObject("{\"extra\":{\"client_category\":{\"bid\":\"" + bid + "\",\"event_type\":\"" + eventName + "\"},\"client_extra\":{\"event_name\":\"hybridmonitor_report_all\"},\"ev_type\":\"custom\"}}"));
    }

    public final void reportTea(String eventName, JSONObject params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        Method method2 = method;
        if (method2 == null || method2 == null) {
            return;
        }
        try {
            method2.invoke(null, eventName, params);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }
}
