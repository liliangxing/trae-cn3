package com.bytedance.android.monitorV2.lynx;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompatKt;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.ContainerNativeInfo;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.FallBackInfo;
import com.bytedance.android.monitorV2.entity.JsbErrorData;
import com.bytedance.android.monitorV2.entity.JsbInfoData;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.executor.HybridMonitorExecutor;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.blank.LynxBlankDetect;
import com.bytedance.android.monitorV2.lynx.config.LynxViewMonitorConfig;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxCommonData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxJsbFetchErrorData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager;
import com.bytedance.android.monitorV2.lynx_helper.CompatLynxViewClient;
import com.bytedance.android.monitorV2.lynx_helper.MonitorLynxViewClient;
import com.bytedance.android.monitorV2.standard.ContainerDataCache;
import com.bytedance.android.monitorV2.standard.ContainerError;
import com.bytedance.android.monitorV2.standard.ContainerStandardAction;
import com.bytedance.android.monitorV2.standard.ContainerStandardApi;
import com.bytedance.android.monitorV2.util.ActivityUtil;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.Utilities;
import com.bytedance.android.monitorV2.webview.HybridMonitorDefault;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.SLLynxJSExceptionParams;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxGetDataCallback;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: LynxViewMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 a2\u00020\u0001:\u0003abcB\u0007\b\u0012¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J.\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0018j\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u00192\u0006\u0010\n\u001a\u00020\u000bJ=\u0010\u001a\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u00122!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\t0\u001dH\u0016J\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010\n\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010&\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\rH\u0007J\"\u0010*\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00142\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u000fH\u0016J*\u0010-\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00142\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\"\u00103\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00142\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\u001eH\u0016J\u001e\u00103\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\u001eJ\u0010\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020:H\u0007J\u000e\u0010;\u001a\u00020:2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010<\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>J\u0018\u0010?\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016JN\u0010?\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u00106\u001a\u0004\u0018\u00010\r2\b\u0010@\u001a\u0004\u0018\u00010\r2\b\u0010A\u001a\u0004\u0018\u00010\u001e2\b\u0010B\u001a\u0004\u0018\u00010\u001e2\b\u0010C\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u001eJV\u0010?\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u00106\u001a\u0004\u0018\u00010\r2\b\u0010@\u001a\u0004\u0018\u00010\r2\b\u0010A\u001a\u0004\u0018\u00010\u001e2\b\u0010B\u001a\u0004\u0018\u00010\u001e2\b\u0010C\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u001e2\u0006\u0010E\u001a\u00020\u0012J`\u0010?\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u00106\u001a\u0004\u0018\u00010\r2\b\u0010@\u001a\u0004\u0018\u00010\r2\b\u0010A\u001a\u0004\u0018\u00010\u001e2\b\u0010B\u001a\u0004\u0018\u00010\u001e2\b\u0010C\u001a\u0004\u0018\u00010\u001e2\b\u0010F\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u001e2\u0006\u0010E\u001a\u00020\u0012J$\u0010G\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KH\u0007J\u001a\u0010L\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010M\u001a\u0004\u0018\u00010NJ:\u0010O\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010P\u001a\u0004\u0018\u00010\r2\b\u0010Q\u001a\u0004\u0018\u00010\r2\b\u0010R\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\rJ\u0016\u0010T\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020VJ\u0018\u0010W\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010U\u001a\u00020XJ\u0016\u0010Y\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020[J\u000e\u0010\\\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010]\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\r2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\rJ\u000e\u0010`\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006d"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor;", "Lcom/bytedance/android/monitorV2/standard/ContainerStandardAction;", "()V", "lifeCycleDelegate", "Lcom/bytedance/android/monitorV2/lynx/ILynxViewLifeCycleDelegate;", "getLifeCycleDelegate$annotations", "getLifeCycleDelegate", "()Lcom/bytedance/android/monitorV2/lynx/ILynxViewLifeCycleDelegate;", "addContext", "", "view", "Lcom/lynx/tasm/LynxView;", Api.KEY_ENCRYPT_RESP_KEY, "", "o", "", "addTemplateState", "state", "", "customReport", "Landroid/view/View;", "customInfo", "Lcom/bytedance/android/monitorV2/entity/CustomInfo;", "getExtraInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getPerformance", "waitCompleteData", "performanceCallback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "performanceResult", "getSwitchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "getUnifyInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "handleBlankDetect", "onLynxBlankCallback", "Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;", "detectFrom", "handleCollectEvent", "field", "value", "handleContainerError", "monitorId", TraceStatsConsts.STATS_BASE_MODULE, "Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "error", "Lcom/bytedance/android/monitorV2/standard/ContainerError;", "handleNativeInfo", "type", "jsonObject", "eventType", "inputJsonObject", "isEnableBlankCheckTool", WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE, "", "isEnableMonitor", "registerLynxViewMonitor", "config", "Lcom/bytedance/android/monitorV2/lynx/config/LynxViewMonitorConfig;", "reportCustom", "url", "category", "metric", "extra", SettingsManager.COMMON_SERVICE, "canSample", "timing", "reportError", "lynxNativeErrorData", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "reportFallbackPage", "fallBackInfo", "Lcom/bytedance/android/monitorV2/entity/FallBackInfo;", "reportGeckoInfo", "resStatus", "resType", "resUrl", "resVersion", "reportJsbError", "errorData", "Lcom/bytedance/android/monitorV2/entity/JsbErrorData;", "reportJsbFetchError", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxJsbFetchErrorData;", "reportJsbInfo", "infoData", "Lcom/bytedance/android/monitorV2/entity/JsbInfoData;", "reportNavigationStart", "reportTemplateInfo", "from", "version", "unregisterLynxViewMonitor", "Companion", "EventNativeInfo", "SingletonHolder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewMonitor implements ContainerStandardAction {
    public static final String BDX_MONITOR_SESSION_ID = "bdx_monitor_session_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final LynxViewMonitor INSTANCE;
    private static final long JVM_DIFF;
    public static final String TAG = "LynxViewMonitor";
    private final ILynxViewLifeCycleDelegate lifeCycleDelegate;

    public /* synthetic */ LynxViewMonitor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Deprecated(message = "live sdk still using...")
    public static /* synthetic */ void getLifeCycleDelegate$annotations() {
    }

    public final void handleBlankDetect(LynxView lynxView) {
        Intrinsics.checkNotNullParameter(lynxView, "view");
        handleBlankDetect$default(this, lynxView, null, null, 6, null);
    }

    public final void handleBlankDetect(LynxView lynxView, LynxBlankDetect.OnLynxBlankCallback onLynxBlankCallback) {
        Intrinsics.checkNotNullParameter(lynxView, "view");
        handleBlankDetect$default(this, lynxView, onLynxBlankCallback, null, 4, null);
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void handleCollectEvent(View view, String field, Object value) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public final void reportError(LynxView lynxView, LynxNativeErrorData lynxNativeErrorData) {
        Intrinsics.checkNotNullParameter(lynxView, "view");
        Intrinsics.checkNotNullParameter(lynxNativeErrorData, "lynxNativeErrorData");
        reportError$default(this, lynxView, lynxNativeErrorData, null, 4, null);
    }

    public final ILynxViewLifeCycleDelegate getLifeCycleDelegate() {
        return this.lifeCycleDelegate;
    }

    /* compiled from: LynxViewMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor$Companion;", "", "()V", "BDX_MONITOR_SESSION_ID", "", "INSTANCE", "Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor;", "getINSTANCE", "()Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor;", "JVM_DIFF", "", "getJVM_DIFF", "()J", "TAG", "getSystemBootTimeNS", "ErrorCodeCategory", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LynxViewMonitor getINSTANCE() {
            return LynxViewMonitor.INSTANCE;
        }

        public final long getJVM_DIFF() {
            return LynxViewMonitor.JVM_DIFF;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long getSystemBootTimeNS() {
            return SystemClock.elapsedRealtimeNanos();
        }

        /* compiled from: LynxViewMonitor.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor$Companion$ErrorCodeCategory;", "", "mainNum", "", "(Ljava/lang/String;II)V", "getMainNum", "()I", "JSError", "StaticError", "LepusError", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public enum ErrorCodeCategory {
            JSError(2),
            StaticError(3),
            LepusError(11);

            private final int mainNum;

            ErrorCodeCategory(int i) {
                this.mainNum = i;
            }

            public final int getMainNum() {
                return this.mainNum;
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        INSTANCE = SingletonHolder.INSTANCE.getHolder();
        long j = 1000;
        JVM_DIFF = ((System.currentTimeMillis() * j) * j) - companion.getSystemBootTimeNS();
    }

    /* compiled from: LynxViewMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor$SingletonHolder;", "", "()V", "holder", "Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor;", "getHolder", "()Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static final LynxViewMonitor holder = new LynxViewMonitor(null);

        private SingletonHolder() {
        }

        public final LynxViewMonitor getHolder() {
            return holder;
        }
    }

    private LynxViewMonitor() {
        this.lifeCycleDelegate = new LynxViewLifeCycleDelegate();
        ContainerStandardApi.INSTANCE.registerAction("lynx", this);
    }

    public final void registerLynxViewMonitor(LynxView view, LynxViewMonitorConfig config) {
        MonitorLynxViewClient monitorLynxViewClient;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        MonitorLog.m29i(TAG, "registerLynxViewMonitor");
        LynxViewDataManager orCreate = LynxViewDataManager.INSTANCE.getOrCreate(view, config.getSessionId());
        orCreate.setViewConf(config);
        if (config.getIsCompactMode()) {
            monitorLynxViewClient = new CompatLynxViewClient(new WeakReference(view));
        } else {
            monitorLynxViewClient = new MonitorLynxViewClient(new WeakReference(view));
        }
        view.addLynxViewClient(monitorLynxViewClient);
        String sessionId = config.getSessionId();
        if (sessionId != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(BDX_MONITOR_SESSION_ID, sessionId);
            view.putParamsForReportingEvents(hashMap);
        }
        orCreate.setViewClientRef(new WeakReference<>(monitorLynxViewClient));
    }

    public final void unregisterLynxViewMonitor(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        MonitorLog.m29i(TAG, "unregisterLynxViewMonitor");
        LynxViewDataManager orCreate = LynxViewDataManager.INSTANCE.getOrCreate(view);
        if (orCreate.getViewClientRef() != null) {
            WeakReference<LynxViewClient> viewClientRef = orCreate.getViewClientRef();
            view.removeLynxViewClient(viewClientRef != null ? viewClientRef.get() : null);
            orCreate.setViewClientRef(null);
        }
        LynxViewDataManager.INSTANCE.remove(view);
    }

    public static /* synthetic */ void reportTemplateInfo$default(LynxViewMonitor lynxViewMonitor, LynxView lynxView, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        lynxViewMonitor.reportTemplateInfo(lynxView, str, str2);
    }

    public final void reportTemplateInfo(LynxView view, String from, String version) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(from, "from");
        reportGeckoInfo(view, from, "template", view.getTemplateUrl(), version);
    }

    @Deprecated(message = "WSD auxiliary view deprecated")
    public final void isEnableBlankCheckTool(boolean r2) {
        MonitorLog.m31w(TAG, "isEnableBlankCheckTool is deprecated");
    }

    public final boolean isEnableMonitor(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return LynxViewDataManager.INSTANCE.getOrCreate(view).getViewConf().getEnableMonitor() && getSwitchConfig().isEnableMonitor() && getSwitchConfig().isLynxEnableMonitor();
    }

    private final SwitchConfig getSwitchConfig() {
        SwitchConfig switchConfig = HybridMultiMonitor.getInstance().getHybridSettingManager().getSwitch();
        Intrinsics.checkNotNullExpressionValue(switchConfig, "getInstance().hybridSettingManager.switch");
        return switchConfig;
    }

    @Deprecated(message = "Deprecated...", replaceWith = @ReplaceWith(expression = "addContext(view, key, o.toString())", imports = {}))
    public final void addContext(LynxView view, String key, Object o) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(o, "o");
        addContext(view, key, o.toString());
    }

    public final void addContext(LynxView view, String key, String o) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(o, "o");
        if (isEnableMonitor(view)) {
            LynxViewDataManager.INSTANCE.getOrCreate(view).getCommonProps().addContext(key, o);
        }
    }

    public final void addTemplateState(LynxView view, int state) {
        Intrinsics.checkNotNullParameter(view, "view");
        MonitorLog.m29i(TAG, "addTemplateState");
        if (isEnableMonitor(view)) {
            LynxViewDataManager.INSTANCE.getOrCreate(view).getCommonProps().setTemplateState(state);
        }
    }

    public final HashMap<String, Object> getExtraInfo(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("navigation_id", LynxViewDataManager.INSTANCE.getOrCreate(view).getCommonProps().navigationId)});
    }

    public static /* synthetic */ void reportError$default(LynxViewMonitor lynxViewMonitor, LynxView lynxView, LynxNativeErrorData lynxNativeErrorData, CommonEvent commonEvent, int i, Object obj) {
        if ((i & 4) != 0) {
            commonEvent = null;
        }
        lynxViewMonitor.reportError(lynxView, lynxNativeErrorData, commonEvent);
    }

    public final void reportError(LynxView view, final LynxNativeErrorData lynxNativeErrorData, CommonEvent event) {
        String sessionId;
        String errorMsg;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(lynxNativeErrorData, "lynxNativeErrorData");
        MonitorLog.m29i(TAG, "reportError: errorCode: " + lynxNativeErrorData.getErrorCode());
        if (event == null) {
            event = CommonEvent.INSTANCE.create("nativeError", lynxNativeErrorData);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "nativeError";
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.LynxViewMonitor$reportError$mappingV2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m340invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m340invoke() {
                int errorCode = LynxNativeErrorData.this.getErrorCode();
                boolean z = false;
                if (200 <= errorCode && errorCode < 300) {
                    z = true;
                }
                if (z) {
                    objectRef.element = ReportConst.Event.JS_EXCEPTION;
                } else if (LynxNativeErrorData.this.getErrorCode() == 301) {
                    objectRef.element = ReportConst.Event.STATIC;
                }
            }
        };
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 201;
        new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.LynxViewMonitor$reportError$mappingV3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m341invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m341invoke() {
                int errorCode = LynxNativeErrorData.this.getErrorCode() / 100;
                if (errorCode == LynxViewMonitor.Companion.ErrorCodeCategory.JSError.getMainNum()) {
                    objectRef.element = ReportConst.Event.JS_EXCEPTION;
                    intRef.element = 201;
                } else if (errorCode == LynxViewMonitor.Companion.ErrorCodeCategory.LepusError.getMainNum()) {
                    objectRef.element = ReportConst.Event.JS_EXCEPTION;
                    intRef.element = 1101;
                } else if (errorCode == LynxViewMonitor.Companion.ErrorCodeCategory.StaticError.getMainNum()) {
                    objectRef.element = ReportConst.Event.STATIC;
                } else {
                    function0.invoke();
                }
            }
        }.invoke();
        lynxNativeErrorData.eventType = (String) objectRef.element;
        if (event != null) {
            event.setEventType((String) objectRef.element);
        }
        if (event != null) {
            event.setNativeInfo(lynxNativeErrorData);
        }
        LynxViewDataManager.Companion companion = LynxViewDataManager.INSTANCE;
        Intrinsics.checkNotNull(event);
        companion.postEvent(view, event);
        LynxViewDataManager.INSTANCE.updateUnifyError(view, event, lynxNativeErrorData.getErrorCode(), lynxNativeErrorData.getErrorMsg());
        if (!Intrinsics.areEqual(event.getEventType(), ReportConst.Event.JS_EXCEPTION) || Intrinsics.areEqual(lynxNativeErrorData.getScene(), "lynx_error_custom") || (sessionId = LynxViewDataManager.INSTANCE.getOrCreate(view).getViewConf().getSessionId()) == null || (errorMsg = lynxNativeErrorData.getErrorMsg()) == null) {
            return;
        }
        SLAnnieXMonitor.reportLynxJSException$default(SLMonitorCompatKt.getSLMonitorManager().getMonitorWithSessionId(sessionId), new SLLynxJSExceptionParams(errorMsg, intRef.element), (Function1) null, 2, (Object) null);
    }

    public final void reportJsbInfo(LynxView view, JsbInfoData infoData) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(infoData, "infoData");
        if (LynxViewDataManager.INSTANCE.hitSample(view, "jsbPerf")) {
            MonitorLog.m29i(TAG, "reportJsbInfo");
            CommonEvent create = CommonEvent.INSTANCE.create("jsbPerf", infoData);
            if (create.terminateIf(!getSwitchConfig().isLynxEnableJsb(), HybridEvent.TerminateType.SWITCH_OFF)) {
                return;
            }
            LynxViewDataManager.INSTANCE.postEvent(view, create);
        }
    }

    /* compiled from: LynxViewMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitor$EventNativeInfo;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "eventType", "", "data", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "getEventType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "fillInJsonObject", "", "jsonObject", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class EventNativeInfo extends BaseNativeInfo {
        private final JSONObject data;
        private final String eventType;

        public static /* synthetic */ EventNativeInfo copy$default(EventNativeInfo eventNativeInfo, String str, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = eventNativeInfo.eventType;
            }
            if ((i & 2) != 0) {
                jSONObject = eventNativeInfo.data;
            }
            return eventNativeInfo.copy(str, jSONObject);
        }

        /* renamed from: component1, reason: from getter */
        public final String getEventType() {
            return this.eventType;
        }

        /* renamed from: component2, reason: from getter */
        public final JSONObject getData() {
            return this.data;
        }

        public final EventNativeInfo copy(String eventType, JSONObject data) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(data, "data");
            return new EventNativeInfo(eventType, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EventNativeInfo)) {
                return false;
            }
            EventNativeInfo eventNativeInfo = (EventNativeInfo) other;
            return Intrinsics.areEqual(this.eventType, eventNativeInfo.eventType) && Intrinsics.areEqual(this.data, eventNativeInfo.data);
        }

        public int hashCode() {
            return (this.eventType.hashCode() * 31) + this.data.hashCode();
        }

        @Override // com.bytedance.android.monitorV2.base.BaseNativeInfo
        public String toString() {
            return "EventNativeInfo(eventType=" + this.eventType + ", data=" + this.data + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EventNativeInfo(String str, JSONObject jSONObject) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "eventType");
            Intrinsics.checkNotNullParameter(jSONObject, "data");
            this.eventType = str;
            this.data = jSONObject;
        }

        public final JSONObject getData() {
            return this.data;
        }

        public final String getEventType() {
            return this.eventType;
        }

        @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
        public void fillInJsonObject(JSONObject jsonObject) {
            JsonUtils.deepCopy(jsonObject, this.data);
        }
    }

    public final void reportJsbError(final LynxView view, final JsbErrorData errorData) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(errorData, "errorData");
        MonitorLog.m29i(TAG, "reportJsbError");
        try {
            Result.Companion companion = Result.Companion;
            LynxViewMonitor lynxViewMonitor = this;
            final CommonEvent create = CommonEvent.INSTANCE.create("jsbError", errorData);
            if (create.terminateIf(Switches.lynxJsb.not(), HybridEvent.TerminateType.SWITCH_OFF)) {
                return;
            }
            if (HostExperimentManager.INSTANCE.getEnablePreSample() && Utilities.INSTANCE.isOnlineEnv()) {
                LynxViewDataManager.INSTANCE.postEvent(view, create);
                LynxViewDataManager.INSTANCE.updateUnifyError(view, create, errorData.getErrorCode(), errorData.getErrorMessage());
            } else {
                create.putExtra("jsb_error_extra", errorData.getExtra());
                HybridMonitorExecutor.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.LynxViewMonitor$reportJsbError$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m344invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m344invoke() {
                        LynxView lynxView = view;
                        final CommonEvent commonEvent = create;
                        final LynxView lynxView2 = view;
                        final JsbErrorData jsbErrorData = errorData;
                        lynxView.getCurrentData(new LynxGetDataCallback() { // from class: com.bytedance.android.monitorV2.lynx.LynxViewMonitor$reportJsbError$1$1.1
                            public void onSuccess(JavaOnlyMap data) {
                                CommonEvent.this.putExtra("state_info", data != null ? data.toJSONObject() : null);
                                LynxViewDataManager.INSTANCE.postEvent(lynxView2, CommonEvent.this);
                                LynxViewDataManager.INSTANCE.updateUnifyError(lynxView2, CommonEvent.this, jsbErrorData.getErrorCode(), jsbErrorData.getErrorMessage());
                            }

                            public void onFail(String msg) {
                                LynxViewDataManager.INSTANCE.postEvent(lynxView2, CommonEvent.this);
                                LynxViewDataManager.INSTANCE.updateUnifyError(lynxView2, CommonEvent.this, jsbErrorData.getErrorCode(), jsbErrorData.getErrorMessage());
                            }
                        });
                    }
                });
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final void reportJsbFetchError(LynxView view, LynxJsbFetchErrorData errorData) {
        Intrinsics.checkNotNullParameter(errorData, "errorData");
        MonitorLog.m29i(TAG, "reportJsbFetchError");
        CommonEvent create = CommonEvent.INSTANCE.create("fetchError", errorData);
        if (create.terminateIf(!getSwitchConfig().isLynxEnableFetch(), HybridEvent.TerminateType.SWITCH_OFF)) {
            return;
        }
        LynxViewDataManager.INSTANCE.postEvent(view, create);
        LynxViewDataManager.INSTANCE.updateUnifyError(view, create, errorData.getErrorCode(), errorData.getErrorMessage());
    }

    public final void reportCustom(LynxView view, String eventType, String url, JSONObject category, JSONObject metric, JSONObject extra, JSONObject common, int canSample) {
        reportCustom(view, eventType, url, category, metric, extra, null, common, canSample);
    }

    public final void reportCustom(LynxView view, String eventType, String url, JSONObject category, JSONObject metric, JSONObject extra, JSONObject timing, JSONObject common, int canSample) {
        MonitorLog.m29i(TAG, "reportCustom: eventType: " + eventType);
        CustomInfo build = new CustomInfo.Builder(eventType).setUrl(url).setCategory(category).setMetric(metric).setExtra(extra).setTiming(timing).setCommon(common).setSample(canSample).build();
        Intrinsics.checkNotNullExpressionValue(build, "customInfo");
        reportCustom(view, build);
    }

    public final void reportCustom(LynxView view, String eventType, String url, JSONObject category, JSONObject metric, JSONObject extra, JSONObject common) {
        reportCustom(view, eventType, url, category, metric, extra, null, common, 0);
    }

    public final void reportCustom(final LynxView view, final CustomInfo customInfo) {
        Intrinsics.checkNotNullParameter(customInfo, "customInfo");
        HybridMonitorExecutor.INSTANCE.post(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.LynxViewMonitor$reportCustom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m339invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m339invoke() {
                LynxViewDataManager.INSTANCE.postEvent(view, new CustomEvent(customInfo));
            }
        });
    }

    public static /* synthetic */ void handleBlankDetect$default(LynxViewMonitor lynxViewMonitor, LynxView lynxView, LynxBlankDetect.OnLynxBlankCallback onLynxBlankCallback, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            onLynxBlankCallback = null;
        }
        if ((i & 4) != 0) {
            str = "monitor";
        }
        lynxViewMonitor.handleBlankDetect(lynxView, onLynxBlankCallback, str);
    }

    public final void handleBlankDetect(LynxView view, LynxBlankDetect.OnLynxBlankCallback onLynxBlankCallback, String detectFrom) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detectFrom, "detectFrom");
        try {
            LynxViewDataManager.INSTANCE.getOrCreate(view).detectBlankByOuter(onLynxBlankCallback, detectFrom);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void handleContainerError(View view, String monitorId, ContainerBase base, ContainerError error) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(base, TraceStatsConsts.STATS_BASE_MODULE);
        Intrinsics.checkNotNullParameter(error, "error");
        MonitorLog.m29i(TAG, "reportContainerError, errorCode: " + error.getErrCode());
        CommonEvent create = CommonEvent.INSTANCE.create("containerError", new ContainerNativeInfo());
        create.setContainerBase(base);
        create.setContainerInfo(error.toContainerInfo());
        try {
            if (view == null) {
                new LynxViewMonitorConfig(error.getBiz(), new HybridMonitorDefault());
                LynxCommonData lynxCommonData = new LynxCommonData();
                lynxCommonData.virtualAid = error.getVirtualAid();
                lynxCommonData.setTemplateState(999);
                Activity activityByContext = ActivityUtil.getActivityByContext((Context) null);
                if (activityByContext != null) {
                    lynxCommonData.nativePage = activityByContext.getClass().getName();
                }
                create.setNativeBase(lynxCommonData);
                LynxViewDataManager.INSTANCE.postEvent((LynxView) view, create);
                return;
            }
            create.setNativeBase(LynxViewDataManager.INSTANCE.getOrCreate((LynxView) view).getCommonProps());
            create.setContainerBase(ContainerDataCache.INSTANCE.getContainerBaseByView(view));
            LynxViewDataManager.INSTANCE.postEvent((LynxView) view, create);
        } catch (Throwable th) {
            create.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void handleNativeInfo(View view, String type, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (view instanceof LynxView) {
            handleNativeInfo((LynxView) view, type, jsonObject);
        } else {
            MonitorLog.m27e(TAG, "handleNativeInfo: view not match LynxView");
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void customReport(View view, CustomInfo customInfo) {
        Intrinsics.checkNotNullParameter(customInfo, "customInfo");
        boolean z = view instanceof LynxView;
        boolean z2 = true;
        if (!z && view != null) {
            z2 = false;
        }
        if (z2) {
            reportCustom(z ? (LynxView) view : null, customInfo);
        } else {
            MonitorLog.m27e(TAG, "customReport: view not match LynxView");
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void getPerformance(View view, int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback) {
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        Unit unit = null;
        if ((view instanceof LynxView ? (LynxView) view : null) != null) {
            LynxViewDataManager.INSTANCE.getOrCreate((LynxView) view).getPerformance(waitCompleteData, performanceCallback);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            performanceCallback.invoke(new JSONObject());
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public EngineInfo getUnifyInfo(View view) {
        EngineInfo unifyInfo;
        return ((view instanceof LynxView ? (LynxView) view : null) == null || (unifyInfo = LynxViewDataManager.INSTANCE.getOrCreate((LynxView) view).getUnifyInfo()) == null) ? new EngineInfo(new NativeCommon()) : unifyInfo;
    }

    public final void handleNativeInfo(LynxView view, String eventType, JSONObject inputJsonObject) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(inputJsonObject, "inputJsonObject");
        MonitorLog.m29i(TAG, "handleNativeInfo: eventTYpe: " + eventType);
        LynxViewDataManager.INSTANCE.postEvent(view, CommonEvent.INSTANCE.create(eventType, inputJsonObject));
    }

    public static /* synthetic */ void reportGeckoInfo$default(LynxViewMonitor lynxViewMonitor, LynxView lynxView, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 16) != 0) {
            str4 = "0";
        }
        lynxViewMonitor.reportGeckoInfo(lynxView, str, str2, str3, str4);
    }

    public final void reportGeckoInfo(final LynxView view, final String resStatus, final String resType, final String resUrl, final String resVersion) {
        MonitorLog.m29i(TAG, "reportGeckoInfo");
        HybridMonitorExecutor.INSTANCE.post(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.LynxViewMonitor$reportGeckoInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m343invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m343invoke() {
                try {
                    if (view == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.safePut(jSONObject, "res_status", resStatus);
                    JsonUtils.safePut(jSONObject, "res_type", resType);
                    JsonUtils.safePut(jSONObject, "res_url", resUrl);
                    JsonUtils.safePut(jSONObject, "container", "lynx");
                    JsonUtils.safePut(jSONObject, "res_version", resVersion);
                    LynxViewMonitor lynxViewMonitor = this;
                    LynxView lynxView = view;
                    lynxViewMonitor.reportCustom(lynxView, "bd_monitor_get_resource", lynxView.getTemplateUrl(), jSONObject, null, null, null, 0);
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
    }

    public final void reportFallbackPage(final LynxView view, final FallBackInfo fallBackInfo) {
        MonitorLog.m29i(TAG, "reportFallbackPage");
        HybridMonitorExecutor.INSTANCE.post(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.LynxViewMonitor$reportFallbackPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m342invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m342invoke() {
                try {
                    if (view != null && fallBackInfo != null) {
                        JSONObject jSONObject = new JSONObject();
                        JsonUtils.safePut(jSONObject, "source_container", fallBackInfo.sourceContainer);
                        JsonUtils.safePut(jSONObject, "source_url", fallBackInfo.sourceUrl);
                        JsonUtils.safePut(jSONObject, "fallback_type", fallBackInfo.fallbackType);
                        JsonUtils.safePut(jSONObject, "target_container", fallBackInfo.targetContainer);
                        JsonUtils.safePut(jSONObject, "target_url", fallBackInfo.targetUrl);
                        LynxViewMonitor lynxViewMonitor = this;
                        LynxView lynxView = view;
                        lynxViewMonitor.reportCustom(lynxView, "bd_monitor_fallback_page", lynxView.getTemplateUrl(), jSONObject, null, null, null, 0);
                    }
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
    }

    public final void reportNavigationStart(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LynxViewDataManager.INSTANCE.getOrCreate(view).reportNavigationStart();
    }
}
