package com.bytedance.ies.bullet.lynx.init;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.ThreadStrategyForRendering;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: LynxSdkMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u001a\u001a\u00020\u00142\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitor;", "", "()V", PrefetchRequestConfig.ENV_TYPE_AID, "", "globalConfig", "Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitorConfig;", "getGlobalConfig", "()Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitorConfig;", "setGlobalConfig", "(Lcom/bytedance/ies/bullet/lynx/init/LynxSdkMonitorConfig;)V", "handler", "Landroid/os/Handler;", "sdkMonitor", "Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "getSdkMonitor", "()Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "setSdkMonitor", "(Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;)V", "initSDKMonitor", "", "context", "Landroid/content/Context;", "isDebug", "", "_config", "onReportComponentInfo", "mComponentSet", "", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxSdkMonitor {
    private static final String AID = "7059";
    public static final LynxSdkMonitor INSTANCE = new LynxSdkMonitor();
    private static LynxSdkMonitorConfig globalConfig;
    private static Handler handler;
    private static SDKMonitor sdkMonitor;

    private LynxSdkMonitor() {
    }

    public final SDKMonitor getSdkMonitor() {
        return sdkMonitor;
    }

    public final void setSdkMonitor(SDKMonitor sDKMonitor) {
        sdkMonitor = sDKMonitor;
    }

    static {
        LynxSdkMonitorConfig lynxSdkMonitorConfig = new LynxSdkMonitorConfig();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("host_aid", AID);
        jSONObject.put("app_version", LynxEnv.inst().getLynxVersion());
        jSONObject.put("update_version_code", LynxEnv.inst().getLynxVersion());
        lynxSdkMonitorConfig.setHeader(jSONObject);
        lynxSdkMonitorConfig.setOversea(false);
        lynxSdkMonitorConfig.setConfigUrls(CollectionsKt.listOf("https://mon.snssdk.com/monitor/appmonitor/v2/settings"));
        lynxSdkMonitorConfig.setReportUrls(CollectionsKt.listOf("https://mon.snssdk.com/monitor/collect"));
        globalConfig = lynxSdkMonitorConfig;
    }

    public final LynxSdkMonitorConfig getGlobalConfig() {
        return globalConfig;
    }

    public final void setGlobalConfig(LynxSdkMonitorConfig lynxSdkMonitorConfig) {
        Intrinsics.checkNotNullParameter(lynxSdkMonitorConfig, "<set-?>");
        globalConfig = lynxSdkMonitorConfig;
    }

    @JvmStatic
    public static final void initSDKMonitor(Context context, boolean isDebug, LynxSdkMonitorConfig _config) {
        Intrinsics.checkNotNullParameter(context, "context");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = globalConfig;
        if (_config != null) {
            objectRef.element = _config;
        }
        JSONObject header = ((LynxSdkMonitorConfig) objectRef.element).getHeader();
        if (header != null) {
            String did = ResourceLoader.with$default(ResourceLoader.INSTANCE, "default_bid", null, 2, null).getConfig().getDid();
            header.put("channel", isDebug ? "lynx_debug_channel" : "lynx_channel");
            header.put(CommonConstants.KEY_DID, did);
        }
        List<String> configUrls = ((LynxSdkMonitorConfig) objectRef.element).getConfigUrls();
        if (configUrls != null) {
            SDKMonitorUtils.setConfigUrl(AID, configUrls);
        }
        List<String> reportUrls = ((LynxSdkMonitorConfig) objectRef.element).getReportUrls();
        if (reportUrls != null) {
            SDKMonitorUtils.setDefaultReportUrl(AID, reportUrls);
        }
        final JSONObject header2 = ((LynxSdkMonitorConfig) objectRef.element).getHeader();
        if (header2 == null) {
            header2 = new JSONObject();
        }
        header2.put(CommonConstants.SDK_VERSION, "9.0.0");
        SDKMonitorUtils.initMonitor(context, AID, header2, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.ies.bullet.lynx.init.LynxSdkMonitor$initSDKMonitor$4
            public String getSessionId() {
                return null;
            }

            public Map<String, String> getCommonParams() {
                HashMap hashMap = new HashMap();
                String optString = header2.optString("host_aid");
                Intrinsics.checkNotNullExpressionValue(optString, "header.optString(\"host_aid\")");
                hashMap.put("host_aid", optString);
                if (((LynxSdkMonitorConfig) objectRef.element).getOversea()) {
                    hashMap.put("oversea", "1");
                }
                return hashMap;
            }
        });
        sdkMonitor = SDKMonitorUtils.getInstance(AID);
        HandlerThread handlerThread = new HandlerThread("lynx_sdk_monitor");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    @JvmStatic
    public static final void onReportLynxConfigInfo(final LynxConfigInfo info) {
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: com.bytedance.ies.bullet.lynx.init.LynxSdkMonitor$onReportLynxConfigInfo$1
                @Override // java.lang.Runnable
                public final void run() {
                    SDKMonitor sdkMonitor2;
                    LynxConfigInfo lynxConfigInfo = info;
                    if (lynxConfigInfo == null || (sdkMonitor2 = LynxSdkMonitor.INSTANCE.getSdkMonitor()) == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pageVersion", lynxConfigInfo.getPageVersion());
                    jSONObject.put("pageType", lynxConfigInfo.getPageType());
                    jSONObject.put("cliVersion", lynxConfigInfo.getCliVersion());
                    jSONObject.put("customData", lynxConfigInfo.getCustomData());
                    jSONObject.put("templateUrl", lynxConfigInfo.getTemplateUrl());
                    jSONObject.put("targetSdkVersion", lynxConfigInfo.getTargetSdkVersion());
                    jSONObject.put("lepusVersion", lynxConfigInfo.getLepusVersion());
                    ThreadStrategyForRendering threadStrategyForRendering = lynxConfigInfo.getThreadStrategyForRendering();
                    jSONObject.put("threadStrategyForRendering", threadStrategyForRendering != null ? Integer.valueOf(threadStrategyForRendering.id()) : null);
                    jSONObject.put("isEnableLepusNG", lynxConfigInfo.isEnableLepusNG());
                    jSONObject.put("radonMode", lynxConfigInfo.getRadonMode());
                    sdkMonitor2.monitorEvent("lynx_config_info", jSONObject, (JSONObject) null, (JSONObject) null);
                }
            });
        }
    }

    @JvmStatic
    public static final void onReportComponentInfo(final Set<String> mComponentSet) {
        Handler handler2 = handler;
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: com.bytedance.ies.bullet.lynx.init.LynxSdkMonitor$onReportComponentInfo$1
                @Override // java.lang.Runnable
                public final void run() {
                    SDKMonitor sdkMonitor2;
                    String sb;
                    Set<String> set = mComponentSet;
                    if (set == null || (sdkMonitor2 = LynxSdkMonitor.INSTANCE.getSdkMonitor()) == null) {
                        return;
                    }
                    if (set.isEmpty()) {
                        sb = "";
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        Iterator<String> it = set.iterator();
                        sb2.append(it.next());
                        while (it.hasNext()) {
                            sb2.append(",");
                            sb2.append(it.next());
                        }
                        sb = sb2.toString();
                        Intrinsics.checkNotNullExpressionValue(sb, "{\n                      …g()\n                    }");
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("components", sb);
                    sdkMonitor2.monitorEvent("lynx_component_info", jSONObject, (JSONObject) null, (JSONObject) null);
                }
            });
        }
    }
}
