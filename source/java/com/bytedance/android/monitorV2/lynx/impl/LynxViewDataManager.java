package com.bytedance.android.monitorV2.lynx.impl;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.SettingsParseManager;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.blank.LynxBlankDetect;
import com.bytedance.android.monitorV2.lynx.config.LynxViewMonitorConfig;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxCommonData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxPerfData;
import com.bytedance.android.monitorV2.settings.MonitorConfig;
import com.bytedance.android.monitorV2.settings.MonitorSettingsCenter;
import com.bytedance.android.monitorV2.util.ActivityUtil;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.TouchUtil;
import com.bytedance.android.monitorV2.util.Utilities;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.methods.JsCallParser;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxPerfMetric;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: LynxViewDataManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 p2\u00020\u00012\u00020\u0002:\u0001pB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0018\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0019J\u0012\u00106\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020\u0013H\u0002J1\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020<2!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110?¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u0002020>J\u0006\u0010C\u001a\u00020DJ\b\u0010E\u001a\u0004\u0018\u00010\u0004J\b\u0010F\u001a\u00020\u0013H\u0002J\b\u0010G\u001a\u000202H\u0016J\b\u0010H\u001a\u000202H\u0016J\"\u0010I\u001a\u0002022\u0018\u0010J\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010L\u0018\u00010KH\u0016J\u0018\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020LH\u0016J\b\u0010P\u001a\u000202H\u0016J\u0010\u0010Q\u001a\u0002022\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u0002022\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u000202H\u0016J\u001e\u0010X\u001a\u0002022\u0014\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020L\u0018\u00010KH\u0016J\b\u0010Z\u001a\u000202H\u0016J\u0012\u0010[\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010]\u001a\u0002022\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u0002022\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u000202H\u0016J\u001e\u0010d\u001a\u0002022\u0014\u0010e\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020L\u0018\u00010fH\u0016J\u001e\u0010g\u001a\u0002022\u0014\u0010e\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020L\u0018\u00010fH\u0016J\u0010\u0010h\u001a\u0002022\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u0002022\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010l\u001a\u0002022\u0006\u00107\u001a\u000208H\u0016J\u0006\u0010m\u001a\u00020\rJ\b\u0010n\u001a\u000202H\u0002J\u0006\u0010o\u001a\u000202R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017¨\u0006q"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewDataManager;", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxIntegration;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Lcom/lynx/tasm/LynxView;", "(Lcom/lynx/tasm/LynxView;)V", "commonProps", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxCommonData;", "getCommonProps", "()Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxCommonData;", "commonProps$delegate", "Lkotlin/Lazy;", "currentNavigation", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewNavigationDataManager;", "getCurrentNavigation", "()Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewNavigationDataManager;", "setCurrentNavigation", "(Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewNavigationDataManager;)V", "navigationCreatedInViewAttached", "", "getNavigationCreatedInViewAttached", "()Z", "setNavigationCreatedInViewAttached", "(Z)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "viewAttached", "getViewAttached", "setViewAttached", "viewClientRef", "Ljava/lang/ref/WeakReference;", "Lcom/lynx/tasm/LynxViewClient;", "getViewClientRef", "()Ljava/lang/ref/WeakReference;", "setViewClientRef", "(Ljava/lang/ref/WeakReference;)V", "viewConf", "Lcom/bytedance/android/monitorV2/lynx/config/LynxViewMonitorConfig;", "getViewConf", "()Lcom/bytedance/android/monitorV2/lynx/config/LynxViewMonitorConfig;", "setViewConf", "(Lcom/bytedance/android/monitorV2/lynx/config/LynxViewMonitorConfig;)V", "viewVisible", "getViewVisible", "setViewVisible", "detectBlankByOuter", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/monitorV2/lynx/blank/LynxBlankDetect$OnLynxBlankCallback;", "detectFrom", "disableFinalDetectWhenDetached", "v", "Landroid/view/View;", "enableNavigationFix", "getPerformance", "waitCompleteData", "", "performanceCallback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "performanceResult", "getUnifyInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "getView", "isEnable", "onAttachedToView", "onBeforeDestroy", "onCallJSBFinished", "jsbTiming", "", "", "onConfig", Api.KEY_ENCRYPT_RESP_KEY, "value", "onDestroy", "onEventPost", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "onFirstLoadPerfReady", "lynxPerf", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxPerfData;", "onFirstScreen", "onJSBInvoked", "jsbInfo", "onLoadSuccess", "onPageStart", "url", "onReceivedError", "data", "Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "onReportLynxConfigInfo", "info", "Lcom/lynx/tasm/LynxConfigInfo;", "onRuntimeReady", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "onUpdatePerfReady", "metric", "Lcom/lynx/tasm/LynxPerfMetric;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "preCreateNavigation", "recreateNavigation", "reportNavigationStart", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewDataManager extends LynxIntegration implements View.OnAttachStateChangeListener {
    public static final String TAG = "LynxViewDataManager";

    /* renamed from: commonProps$delegate, reason: from kotlin metadata */
    private final Lazy commonProps;
    private LynxViewNavigationDataManager currentNavigation;
    private boolean navigationCreatedInViewAttached;
    private String sessionId;
    private boolean viewAttached;
    private WeakReference<LynxViewClient> viewClientRef;
    private LynxViewMonitorConfig viewConf;
    private boolean viewVisible;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<LynxViewDataManager> defaultLynxViewDataManager$delegate = LazyKt.lazy(new Function0<LynxViewDataManager>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager$Companion$defaultLynxViewDataManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LynxViewDataManager m367invoke() {
            LynxViewDataManager createDefaultLynxViewDataManager;
            createDefaultLynxViewDataManager = LynxViewDataManager.INSTANCE.createDefaultLynxViewDataManager();
            return createDefaultLynxViewDataManager;
        }
    });
    private static final WeakHashMap<View, LynxViewDataManager> mPreCreateLVDMCache = new WeakHashMap<>();
    private static final WeakHashMap<View, LynxViewDataManager> mLynxViewDataManagers = new WeakHashMap<>();
    private static final WeakHashMap<String, LynxViewDataManager> mManagersBySessionId = new WeakHashMap<>();

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onBeforeDestroy() {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
    }

    public LynxViewDataManager(LynxView lynxView) {
        super(lynxView);
        LynxView view;
        String str = BidInfo.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(str, "DEFAULT");
        this.viewConf = new LynxViewMonitorConfig(str);
        this.commonProps = LazyKt.lazy(new Function0<LynxCommonData>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager$commonProps$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final LynxCommonData m368invoke() {
                LynxCommonData lynxCommonData = new LynxCommonData();
                LynxViewDataManager lynxViewDataManager = LynxViewDataManager.this;
                lynxCommonData.setTemplateState(999);
                LynxView view2 = lynxViewDataManager.getView();
                Activity activityByContext = ActivityUtil.getActivityByContext(view2 != null ? view2.getContext() : null);
                if (activityByContext != null) {
                    Intrinsics.checkNotNullExpressionValue(activityByContext, "getActivityByContext(getView()?.context)");
                    lynxCommonData.nativePage = activityByContext.getClass().getName();
                }
                return lynxCommonData;
            }
        });
        if (enableNavigationFix() || (view = getView()) == null) {
            return;
        }
        view.addOnAttachStateChangeListener(this);
    }

    /* compiled from: LynxViewDataManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015J*\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewDataManager$Companion;", "", "()V", "TAG", "", "defaultLynxViewDataManager", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewDataManager;", "getDefaultLynxViewDataManager", "()Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewDataManager;", "defaultLynxViewDataManager$delegate", "Lkotlin/Lazy;", "mLynxViewDataManagers", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "mManagersBySessionId", "mPreCreateLVDMCache", "createDefaultLynxViewDataManager", "getBySessionId", "sessionId", "getOrCreate", "view", "Lcom/lynx/tasm/LynxView;", "hitSample", "", "eventType", "postEvent", "", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "preCreate", "remove", "updateUnifyError", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", AlogMonitor.ALOG_RESULT_CODE, "", "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final LynxViewDataManager getDefaultLynxViewDataManager() {
            return (LynxViewDataManager) LynxViewDataManager.defaultLynxViewDataManager$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final LynxViewDataManager createDefaultLynxViewDataManager() {
            LynxEventHandler dataHandler;
            Unit unit = null;
            LynxViewDataManager lynxViewDataManager = new LynxViewDataManager(null);
            try {
                Result.Companion companion = Result.Companion;
                lynxViewDataManager.setCurrentNavigation(new LynxViewNavigationDataManager(lynxViewDataManager));
                LynxViewNavigationDataManager currentNavigation = lynxViewDataManager.getCurrentNavigation();
                if (currentNavigation != null && (dataHandler = currentNavigation.getDataHandler()) != null) {
                    dataHandler.notifyAllEvents();
                    unit = Unit.INSTANCE;
                }
                Result.constructor-impl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
            return lynxViewDataManager;
        }

        public final LynxViewDataManager getBySessionId(String sessionId) {
            return (LynxViewDataManager) LynxViewDataManager.mManagersBySessionId.get(sessionId);
        }

        public final void preCreate(LynxView view) {
            LynxEventHandler dataHandler;
            Intrinsics.checkNotNullParameter(view, "view");
            LynxViewDataManager lynxViewDataManager = new LynxViewDataManager(view);
            lynxViewDataManager.setCurrentNavigation(new LynxViewNavigationDataManager(lynxViewDataManager, true));
            LynxViewNavigationDataManager currentNavigation = lynxViewDataManager.getCurrentNavigation();
            if (currentNavigation != null && (dataHandler = currentNavigation.getDataHandler()) != null) {
                dataHandler.notifyAllEvents();
            }
            LynxViewDataManager.mPreCreateLVDMCache.put(view, lynxViewDataManager);
        }

        public final LynxViewDataManager getOrCreate(LynxView view, String sessionId) {
            LynxViewDataManager lynxViewDataManager;
            if (view == null) {
                return getDefaultLynxViewDataManager();
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            LynxViewDataManager lynxViewDataManager2 = (LynxViewDataManager) LynxViewDataManager.mPreCreateLVDMCache.get(view);
            if (lynxViewDataManager2 == null) {
                lynxViewDataManager2 = (LynxViewDataManager) LynxViewDataManager.mLynxViewDataManagers.get(view);
            }
            objectRef.element = lynxViewDataManager2;
            if (objectRef.element == null) {
                synchronized (this) {
                    if (objectRef.element == null) {
                        LynxViewDataManager lynxViewDataManager3 = new LynxViewDataManager(view);
                        lynxViewDataManager3.setSessionId(sessionId);
                        objectRef.element = lynxViewDataManager3;
                        LynxViewDataManager lynxViewDataManager4 = (LynxViewDataManager) objectRef.element;
                        boolean z = false;
                        if (lynxViewDataManager4 != null && lynxViewDataManager4.enableNavigationFix()) {
                            z = true;
                        }
                        if (z && (lynxViewDataManager = (LynxViewDataManager) objectRef.element) != null) {
                            lynxViewDataManager.onAttachedToView();
                        }
                        LynxViewDataManager.mLynxViewDataManagers.put(view, objectRef.element);
                        if (sessionId != null) {
                            LynxViewDataManager.mManagersBySessionId.put(sessionId, objectRef.element);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            LynxViewDataManager lynxViewDataManager5 = (LynxViewDataManager) objectRef.element;
            return lynxViewDataManager5 == null ? getDefaultLynxViewDataManager() : lynxViewDataManager5;
        }

        public final LynxViewDataManager getOrCreate(LynxView view) {
            return getOrCreate(view, null);
        }

        public final void remove(LynxView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            LynxViewDataManager lynxViewDataManager = (LynxViewDataManager) LynxViewDataManager.mLynxViewDataManagers.remove(view);
            LynxViewDataManager.mManagersBySessionId.remove(lynxViewDataManager != null ? lynxViewDataManager.getSessionId() : null);
        }

        public final void postEvent(LynxView view, HybridEvent event) {
            LynxViewNavigationDataManager currentNavigation;
            Intrinsics.checkNotNullParameter(event, "event");
            if (view == null) {
                currentNavigation = getDefaultLynxViewDataManager().getCurrentNavigation();
            } else {
                currentNavigation = getOrCreate(view).getCurrentNavigation();
            }
            if (currentNavigation != null) {
                currentNavigation.onEventPost(event);
            } else {
                MonitorLog.m28e(LynxViewDataManager.TAG, "Failed to get current navigation!", new Throwable());
            }
        }

        public final void updateUnifyError(LynxView view, CommonEvent event, int code, String message) {
            LynxViewNavigationDataManager currentNavigation;
            Intrinsics.checkNotNullParameter(event, "event");
            if (view == null) {
                currentNavigation = getDefaultLynxViewDataManager().getCurrentNavigation();
            } else {
                currentNavigation = getOrCreate(view).getCurrentNavigation();
            }
            if (currentNavigation != null) {
                if (message == null) {
                    message = "";
                }
                currentNavigation.updateUnifyError(event, code, message);
            }
        }

        public final boolean hitSample(LynxView view, String eventType) {
            LynxViewNavigationDataManager currentNavigation;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            if (HostExperimentManager.INSTANCE.getEnablePreSample() && (currentNavigation = getOrCreate(view).getCurrentNavigation()) != null && currentNavigation.getBidExactly()) {
                return ConvertUtil.isSampleForLynx(eventType, currentNavigation.getNavigationBidConfig());
            }
            return true;
        }
    }

    public final LynxViewMonitorConfig getViewConf() {
        return this.viewConf;
    }

    public final void setViewConf(LynxViewMonitorConfig lynxViewMonitorConfig) {
        Intrinsics.checkNotNullParameter(lynxViewMonitorConfig, "<set-?>");
        this.viewConf = lynxViewMonitorConfig;
    }

    public final WeakReference<LynxViewClient> getViewClientRef() {
        return this.viewClientRef;
    }

    public final void setViewClientRef(WeakReference<LynxViewClient> weakReference) {
        this.viewClientRef = weakReference;
    }

    public final LynxViewNavigationDataManager getCurrentNavigation() {
        return this.currentNavigation;
    }

    public final void setCurrentNavigation(LynxViewNavigationDataManager lynxViewNavigationDataManager) {
        this.currentNavigation = lynxViewNavigationDataManager;
    }

    public final boolean getNavigationCreatedInViewAttached() {
        return this.navigationCreatedInViewAttached;
    }

    public final void setNavigationCreatedInViewAttached(boolean z) {
        this.navigationCreatedInViewAttached = z;
    }

    public final boolean getViewAttached() {
        return this.viewAttached;
    }

    public final void setViewAttached(boolean z) {
        this.viewAttached = z;
    }

    public final boolean getViewVisible() {
        return this.viewVisible;
    }

    public final void setViewVisible(boolean z) {
        this.viewVisible = z;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final LynxCommonData getCommonProps() {
        return (LynxCommonData) this.commonProps.getValue();
    }

    public final LynxView getView() {
        LynxView lynxView = getHostViewRef$anniex_release().get();
        if (lynxView == null) {
            MonitorLog.m27e(TAG, "get webView from weakRef: null");
        }
        return lynxView;
    }

    private final boolean isEnable() {
        return (Switches.monitor.isEnabled() && Switches.lynxMonitor.isEnabled()) && this.viewConf.getEnableMonitor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean enableNavigationFix() {
        MonitorConfig monitorConfig;
        MonitorSettingsCenter settingsCenter = SettingsParseManager.INSTANCE.getSettingsCenter();
        return (settingsCenter == null || (monitorConfig = (MonitorConfig) settingsCenter.obtainSettings(MonitorConfig.class)) == null || !monitorConfig.getEnableLynxNavigationFix()) ? false : true;
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onLoadSuccess() {
        if (isEnable()) {
            LynxProxy.INSTANCE.updateExtraTiming(getView());
            LynxCommonData commonProps = getCommonProps();
            LynxView view = getView();
            String pageVersion = view != null ? view.getPageVersion() : null;
            if (pageVersion == null) {
                pageVersion = "";
            }
            commonProps.setPageVersion(pageVersion);
            LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
            if (lynxViewNavigationDataManager != null) {
                lynxViewNavigationDataManager.onLoadSuccess();
            }
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onEventPost(HybridEvent event) {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        Intrinsics.checkNotNullParameter(event, "event");
        if (isEnable() && (lynxViewNavigationDataManager = this.currentNavigation) != null) {
            lynxViewNavigationDataManager.onEventPost(event);
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onAttachedToView() {
        if (isEnable()) {
            recreateNavigation();
            this.navigationCreatedInViewAttached = true;
            LynxView view = getView();
            if (view != null) {
                view.addOnAttachStateChangeListener(this);
            }
            LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
            if (lynxViewNavigationDataManager != null) {
                lynxViewNavigationDataManager.onAttachedToView();
            }
        }
    }

    private final void recreateNavigation() {
        LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
        if (lynxViewNavigationDataManager != null && lynxViewNavigationDataManager != null) {
            lynxViewNavigationDataManager.onDestroy();
        }
        this.currentNavigation = new LynxViewNavigationDataManager(this);
    }

    public final LynxViewNavigationDataManager preCreateNavigation() {
        LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
        if (lynxViewNavigationDataManager != null && lynxViewNavigationDataManager != null) {
            lynxViewNavigationDataManager.onDestroy();
        }
        LynxViewNavigationDataManager lynxViewNavigationDataManager2 = new LynxViewNavigationDataManager(this);
        this.currentNavigation = lynxViewNavigationDataManager2;
        Intrinsics.checkNotNull(lynxViewNavigationDataManager2);
        return lynxViewNavigationDataManager2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        if (r0.booleanValue() != false) goto L14;
     */
    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageStart(String url) {
        if (!isEnable() || url == null) {
            return;
        }
        getCommonProps().containerReuse = Boolean.valueOf(getCommonProps().url != null);
        getCommonProps().url = url;
        getCommonProps().clickStart = TouchUtil.getLastTouchTime();
        if (this.navigationCreatedInViewAttached) {
            Boolean bool = getCommonProps().containerReuse;
            Intrinsics.checkNotNullExpressionValue(bool, "commonProps.containerReuse");
        }
        recreateNavigation();
        LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
        if (lynxViewNavigationDataManager != null) {
            lynxViewNavigationDataManager.onAttachedToView();
        }
        getCommonProps().navigationId = Utilities.INSTANCE.uuid();
        this.navigationCreatedInViewAttached = false;
        LynxViewNavigationDataManager lynxViewNavigationDataManager2 = this.currentNavigation;
        if (lynxViewNavigationDataManager2 != null) {
            lynxViewNavigationDataManager2.onPageStart(url);
        }
        final LynxView view = getView();
        if (view != null) {
            this.viewAttached = view.isAttachedToWindow();
            this.viewVisible = view.getVisibility() == 0;
            LynxProxy.INSTANCE.updateExtraTiming(view);
            Utilities utilities = Utilities.INSTANCE;
            HybridMonitorSingleExecutor.INSTANCE.execute(new Function0<Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager$onPageStart$lambda$1$$inlined$runAsyncQuietly$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m366invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m366invoke() {
                    try {
                        HybridMultiMonitor.getInstance().wrapTouchTraceCallback(ActivityUtil.getActivityByContext(view));
                    } catch (Throwable th) {
                        ExceptionUtil.handleException(th);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onDestroy() {
        if (isEnable()) {
            LynxView view = getView();
            if (view != null) {
                LynxProxy.INSTANCE.updateExtraTiming(view);
            }
            LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
            if (lynxViewNavigationDataManager != null) {
                lynxViewNavigationDataManager.onDestroy();
            }
            LynxView view2 = getView();
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        Intrinsics.checkNotNullParameter(v, "v");
        if (!isEnable() || disableFinalDetectWhenDetached(v) || (lynxViewNavigationDataManager = this.currentNavigation) == null) {
            return;
        }
        lynxViewNavigationDataManager.onDestroy();
    }

    private final boolean disableFinalDetectWhenDetached(View v) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            LynxView lynxView = v instanceof LynxView ? (LynxView) v : null;
            obj = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(Uri.parse(lynxView != null ? lynxView.getTemplateUrl() : null).getQueryParameter("disable_final_detect_when_detached"), "1")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onUpdatePerfReady(LynxPerfMetric metric) {
        Object invoke;
        Intrinsics.checkNotNullParameter(metric, "metric");
        if (isEnable()) {
            LynxProxy.INSTANCE.updateExtraTiming(getView());
            if (LynxProxy.INSTANCE.isHasActualFMP().exist() && (invoke = LynxProxy.INSTANCE.isHasActualFMP().with(metric).invoke(new Object[0])) != null && ((Boolean) invoke).booleanValue()) {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.safePut(jSONObject, "actualFMPDuration", Double.valueOf(metric.getActualFMPDuration()));
                JsonUtils.safePut(jSONObject, "actualFirstScreenEndTimeStamp", Double.valueOf(metric.getActualFirstScreenEndTimeStamp()));
                CustomInfo build = new CustomInfo.Builder("lynx_actual_fmp").setMetric(jSONObject).build();
                LynxViewMonitor instance = LynxViewMonitor.INSTANCE.getINSTANCE();
                LynxView view = getView();
                Intrinsics.checkNotNullExpressionValue(build, "customInfo");
                instance.reportCustom(view, build);
            }
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onReportLynxConfigInfo(LynxConfigInfo info) {
        if (isEnable() && info != null) {
            CustomInfo build = new CustomInfo.Builder("hybrid_lynx_config_info").setCategory(info.toJson()).build();
            LynxViewMonitor instance = LynxViewMonitor.INSTANCE.getINSTANCE();
            LynxView view = getView();
            Intrinsics.checkNotNullExpressionValue(build, "customInfo");
            instance.reportCustom(view, build);
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onConfig(String key, Object value) {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        if (isEnable() && (lynxViewNavigationDataManager = this.currentNavigation) != null) {
            lynxViewNavigationDataManager.onConfig(key, value);
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onFirstLoadPerfReady(LynxPerfData lynxPerf) {
        Intrinsics.checkNotNullParameter(lynxPerf, "lynxPerf");
        if (isEnable()) {
            LynxProxy.INSTANCE.updateExtraTiming(getView());
            JSONObject sourceJsonObj = lynxPerf.getSourceJsonObj();
            if (sourceJsonObj != null) {
                Utilities utilities = Utilities.INSTANCE;
                try {
                    getCommonProps().containerInitTs = sourceJsonObj.getJSONObject("timing").getLong("init_end");
                } catch (Throwable th) {
                    ExceptionUtil.handleException(th);
                }
            }
            LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
            if (lynxViewNavigationDataManager != null) {
                lynxViewNavigationDataManager.onFirstLoadPerfReady(lynxPerf);
            }
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onRuntimeReady() {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        if (isEnable() && (lynxViewNavigationDataManager = this.currentNavigation) != null) {
            lynxViewNavigationDataManager.onRuntimeReady();
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onFirstScreen() {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        if (isEnable() && (lynxViewNavigationDataManager = this.currentNavigation) != null) {
            lynxViewNavigationDataManager.onFirstScreen();
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onTimingSetup(Map<String, Object> timingInfo) {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        if (isEnable() && (lynxViewNavigationDataManager = this.currentNavigation) != null) {
            lynxViewNavigationDataManager.onTimingSetup(timingInfo);
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onTimingUpdate(Map<String, Object> timingInfo) {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        if (isEnable() && (lynxViewNavigationDataManager = this.currentNavigation) != null) {
            lynxViewNavigationDataManager.onTimingUpdate(timingInfo);
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onReceivedError(LynxNativeErrorData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (isEnable()) {
            String str = getCommonProps().url;
            if (str == null || str.length() == 0) {
                getCommonProps().url = JsonUtils.safeOptStr(JsonUtils.safeToJsonOb(data.getErrorMsg()), "url");
            }
            LynxView view = getView();
            if (view != null) {
                LynxViewMonitor.INSTANCE.getINSTANCE().reportError(view, data, CommonEvent.INSTANCE.create("nativeError", data));
            }
            if (data.getErrorCode() == 100 || data.getErrorCode() == 103) {
                if (this.currentNavigation == null) {
                    this.currentNavigation = new LynxViewNavigationDataManager(this);
                }
                LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
                if (lynxViewNavigationDataManager != null) {
                    lynxViewNavigationDataManager.onReceivedError(data);
                }
            }
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onCallJSBFinished(Map<String, ? extends Object> jsbTiming) {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        if (isEnable() && (lynxViewNavigationDataManager = this.currentNavigation) != null) {
            lynxViewNavigationDataManager.onCallJSBFinished(jsbTiming);
        }
    }

    @Override // com.bytedance.android.monitorV2.lynx.impl.LynxIntegration
    public void onJSBInvoked(Map<String, ? extends Object> jsbInfo) {
        LynxViewNavigationDataManager lynxViewNavigationDataManager;
        if (isEnable() && (lynxViewNavigationDataManager = this.currentNavigation) != null) {
            lynxViewNavigationDataManager.onJSBInvoked(jsbInfo);
        }
    }

    public final void detectBlankByOuter(LynxBlankDetect.OnLynxBlankCallback callback, String detectFrom) {
        Intrinsics.checkNotNullParameter(detectFrom, "detectFrom");
        LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
        if (lynxViewNavigationDataManager == null) {
            LynxView view = getView();
            if (view != null) {
                if (callback != null) {
                    callback.onDetectCost((View) view, "0", 0L, 0L);
                }
                if (callback != null) {
                    callback.onDetectResult((View) view, "0", 0.0f);
                    return;
                }
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(lynxViewNavigationDataManager);
        lynxViewNavigationDataManager.invokeBlankDetect(callback, detectFrom);
    }

    public final void getPerformance(int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
        if (lynxViewNavigationDataManager != null) {
            lynxViewNavigationDataManager.getPerformance(waitCompleteData, performanceCallback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            performanceCallback.invoke(new JSONObject());
        }
    }

    public final EngineInfo getUnifyInfo() {
        EngineInfo engineInfo;
        LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
        return (lynxViewNavigationDataManager == null || (engineInfo = lynxViewNavigationDataManager.getEngineInfo()) == null) ? new EngineInfo(new NativeCommon()) : engineInfo;
    }

    public final void reportNavigationStart() {
        if (!getCommonProps().getAnnieXContainerReuse()) {
            getCommonProps().setAnnieXContainerReuse(true);
            return;
        }
        getCommonProps().containerReuse = true;
        getCommonProps().navigationId = Utilities.INSTANCE.uuid();
        LynxViewNavigationDataManager lynxViewNavigationDataManager = this.currentNavigation;
        if (lynxViewNavigationDataManager != null) {
            lynxViewNavigationDataManager.onPageStart(getCommonProps().url);
        }
    }
}
