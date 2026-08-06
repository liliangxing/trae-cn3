package com.bytedance.sdk.xbridge.cn.monitor;

import android.net.Uri;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeCall;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ThreadPool;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeLogger;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.im.model.MessagePart;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: XBridgeCallMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u000f2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013J\u0014\u0010\u0017\u001a\u00020\u000f2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J\u0014\u0010\u0018\u001a\u00020\u000f2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/monitor/XBridgeCallMonitor;", "", "()V", "EVENT_BRIDGE_AUTH", "", "EVENT_BRIDGE_PV", "EVENT_JSB_AUTH_ERROR", "SAMPLE_LEVEL", "", "getReportPlatform", DBData.FIELD_TYPE, "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "parseNamespace", LynxBridgeCall.NAME_SPACE, "putCommonJSBAuthCategory", "", "category", "Lorg/json/JSONObject;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "removeQuery", IWeixinService.ResponseConstants.URL, "reportJSBCall", "reportJSBPV", "reportJsbAuthError", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridgeCallMonitor {
    public static final String EVENT_BRIDGE_AUTH = "bdx_monitor_bridge_auth";
    public static final String EVENT_BRIDGE_PV = "bdx_monitor_bridge_pv";
    public static final String EVENT_JSB_AUTH_ERROR = "bdx_jsb_auth_error";
    public static final XBridgeCallMonitor INSTANCE = new XBridgeCallMonitor();
    private static final int SAMPLE_LEVEL = 2;

    /* compiled from: XBridgeCallMonitor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlatformType.values().length];
            try {
                iArr[PlatformType.LYNX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlatformType.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlatformType.WORKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private XBridgeCallMonitor() {
    }

    public final void reportJSBCall(final BaseBridgeCall<?> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        ThreadPool.INSTANCE.runInBackGround(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.monitor.XBridgeCallMonitor$reportJSBCall$1
            @Override // java.lang.Runnable
            public void run() {
                XBridgeCallMonitor.INSTANCE.reportJSBPV(call);
                XBridgeCallMonitor.INSTANCE.reportJsbAuthError(call);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportJSBPV(BaseBridgeCall<?> call) {
        IMonitorReportService monitorService;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("biz", call.getBid());
        jSONObject.put("method", call.getMethodName());
        jSONObject.put("bridge_name", call.getMethodName());
        jSONObject.put("bridge_type", "bdxbridge");
        XBridgeCallMonitor xBridgeCallMonitor = INSTANCE;
        jSONObject.put("container_type", xBridgeCallMonitor.getReportPlatform(call.getPlatformType()));
        jSONObject.put("success", call.getSuccess());
        jSONObject.put("code", call.getCode());
        jSONObject.put("message", call.getMessage());
        IDLXBridgeMethod.XBridgeThreadType threadType = call.getThreadType();
        jSONObject.put("thread_type", threadType != null ? threadType.getValue() : null);
        jSONObject.put("is_latch", call.getIsLatch());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_execute_duration", call.getNativeCallbackTime() - call.getNativeCallStartTime());
        jSONObject2.put("auth_execute_duration", call.getAuthEndTime() - call.getAuthStartTime());
        Long methodHandleStartTime = call.getMethodHandleStartTime();
        if (methodHandleStartTime != null) {
            jSONObject2.put("method_execute_duration", call.getNativeCallbackTime() - methodHandleStartTime.longValue());
        }
        Long beforeMethodHandleStartTime = call.getBeforeMethodHandleStartTime();
        if (beforeMethodHandleStartTime != null) {
            jSONObject2.put("before_method_execute_duration", beforeMethodHandleStartTime.longValue() - call.getNativeCallStartTime());
        }
        jSONObject2.put("native_callback_duration", call.getNativeCallbackTime() - call.getNativeCallbackStartTime());
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ReportConstant.COMMON_INIT_DURATION, call.getAuthEndTime() - call.getAuthStartTime());
        JSONObject jSONObject4 = new JSONObject();
        xBridgeCallMonitor.putCommonJSBAuthCategory(jSONObject4, call);
        jSONObject4.put("auth_status", call.getIsAuthAllow() ? 1 : 0);
        if (XBridge.INSTANCE.getConfig().getMonitorService() != null) {
            IMonitorReportService monitorService2 = XBridge.INSTANCE.getConfig().getMonitorService();
            if (monitorService2 != null) {
                BridgeReportInfo bridgeReportInfo = new BridgeReportInfo(EVENT_BRIDGE_PV);
                bridgeReportInfo.setCategory(jSONObject);
                bridgeReportInfo.setMetrics(jSONObject2);
                bridgeReportInfo.setHighFrequency(true);
                bridgeReportInfo.setUrl(call.getUrl());
                monitorService2.report(bridgeReportInfo);
            }
            if (!call.getNeedReportAuth() || (monitorService = XBridge.INSTANCE.getConfig().getMonitorService()) == null) {
                return;
            }
            BridgeReportInfo bridgeReportInfo2 = new BridgeReportInfo(EVENT_BRIDGE_AUTH);
            bridgeReportInfo2.setCategory(jSONObject4);
            bridgeReportInfo2.setMetrics(jSONObject3);
            bridgeReportInfo2.setHighFrequency(true);
            bridgeReportInfo2.setUrl(call.getUrl());
            monitorService.report(bridgeReportInfo2);
            return;
        }
        HybridMultiMonitor.getInstance().customReport(new CustomInfo.Builder(EVENT_BRIDGE_PV).setCategory(jSONObject).setMetric(jSONObject2).setUrl(call.getUrl()).setSample(2).build());
        if (call.getNeedReportAuth()) {
            HybridMultiMonitor.getInstance().customReport(new CustomInfo.Builder(EVENT_BRIDGE_AUTH).setCategory(jSONObject4).setMetric(jSONObject3).setUrl(call.getUrl()).setSample(2).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportJsbAuthError(BaseBridgeCall<?> call) {
        if (call.getNeedReportAuth() && !call.getIsAuthAllow()) {
            XBridgeLogger logger = XBridge.INSTANCE.getConfig().getLogger();
            if (logger != null) {
                logger.log("bdx auth failed, method: " + call.getMethodName() + ", stage: jsb_auth, url: " + call.getUrl());
            }
            JSONObject jSONObject = new JSONObject();
            INSTANCE.putCommonJSBAuthCategory(jSONObject, call);
            jSONObject.put(DBData.FIELD_TYPE, "bdxbridge");
            jSONObject.put("failed_reason", call.getMessage());
            jSONObject.put("original_method_auth_type", AuthBridgeAccess.INSTANCE.getAccess(call.getMethodAccess()).getValue());
            jSONObject.put(Constant.KEY_APP_ID, call.getAppId());
            jSONObject.put("fe_auth_group", call.getFeGroupAuthType());
            if (XBridge.INSTANCE.getConfig().getMonitorService() != null) {
                IMonitorReportService monitorService = XBridge.INSTANCE.getConfig().getMonitorService();
                if (monitorService != null) {
                    BridgeReportInfo bridgeReportInfo = new BridgeReportInfo(EVENT_JSB_AUTH_ERROR);
                    bridgeReportInfo.setCategory(jSONObject);
                    bridgeReportInfo.setSampleLevel(3);
                    monitorService.report(bridgeReportInfo);
                    return;
                }
                return;
            }
            HybridMultiMonitor.getInstance().customReport(new CustomInfo.Builder(EVENT_JSB_AUTH_ERROR).setCategory(jSONObject).setSample(3).build());
        }
    }

    private final String removeQuery(String url) {
        try {
            Uri parse = Uri.parse(url);
            if (!parse.isHierarchical()) {
                return url;
            }
            String uri = parse.buildUpon().clearQuery().build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "newUri.toString()");
            return uri;
        } catch (Exception unused) {
            return url;
        }
    }

    private final String getReportPlatform(PlatformType type) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return "lynx";
        }
        if (i == 2) {
            return MessagePart.TYPE_WEBVIEW;
        }
        if (i == 3) {
            return "worker";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String parseNamespace(String namespace) {
        return (namespace == null || !Intrinsics.areEqual(namespace, "")) ? namespace == null ? "unset" : namespace : PermissionConfigParser.WEBCAST_HOST_NAMESPACE;
    }

    private final void putCommonJSBAuthCategory(JSONObject category, BaseBridgeCall<?> call) {
        XBridgeCallMonitor xBridgeCallMonitor = INSTANCE;
        category.put("container_type", xBridgeCallMonitor.getReportPlatform(call.getPlatformType()));
        category.put("bridge_name", call.getMethodName());
        String authUrl = call.getAuthUrl();
        if (authUrl == null && (authUrl = call.getUrl()) == null) {
            authUrl = "";
        }
        category.put("auth_url", xBridgeCallMonitor.removeQuery(authUrl));
        String authUrl2 = call.getAuthUrl();
        if (authUrl2 == null && (authUrl2 = call.getUrl()) == null) {
            authUrl2 = "";
        }
        category.put("origin_auth_url", authUrl2);
        category.put("auth_code", call.getAuthCode());
        category.put("fe_id", call.getAuthFeId());
        category.put("fe_id_mapper", call.getAuthFeIdMapper());
        category.put("method_auth_type", call.getMethodAuthType());
        category.put("auth_mode", call.getAuthMode());
        category.put("auth_config_source", call.getFeAuthConfigSource());
        category.put(LynxBridgeCall.NAME_SPACE, xBridgeCallMonitor.parseNamespace(call.getNamespace()));
        category.put("package_version", call.getPackageVersion());
        if (call instanceof WebBridgeCall) {
            category.put("frame_url", ((WebBridgeCall) call).getFrameUrl());
        }
        if (call.getPlatformType() == PlatformType.LYNX) {
            category.put("tasm_fe_id", call.getLynxTasmFeId());
        } else if (call.getPlatformType() == PlatformType.WEB) {
            category.put("auth_url_type", call.getWebAuthUrlType());
        }
        JSONObject requestTrackings = call.getRequestTrackings();
        category.put("request_trackings", requestTrackings != null ? requestTrackings : "");
    }
}
