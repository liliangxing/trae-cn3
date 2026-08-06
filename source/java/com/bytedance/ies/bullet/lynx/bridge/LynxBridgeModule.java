package com.bytedance.ies.bullet.lynx.bridge;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import bolts.Task;
import com.bytedance.android.monitorV2.entity.JsbErrorData;
import com.bytedance.android.monitorV2.entity.JsbInfoData;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.BridgePerfData;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope;
import com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod;
import com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule;
import com.bytedance.ies.bullet.lynx.util.JsonConvertHelper;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ITestService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.BridgeExecute;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.test.TNativeEvent;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.lynx.jsbridge.Arguments;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.LynxView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LynxBridgeModule.kt */
@Deprecated(message = "XBridge3.0 is ready, XBridge2.0's Lynx Bridge Module is not recommended to continue to use", replaceWith = @ReplaceWith(expression = "XBridgeLynxModule", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 92\u00020\u0001:\u000489:;B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\rJ\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0003JW\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020\u00172\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0002\u0010/J6\u00100\u001a\u0006\u0012\u0002\b\u0003012\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010+\u001a\u00020\r2\u0006\u00102\u001a\u000203H\u0002J\u0016\u00104\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u00105\u001a\u00020\u001b*\u0002032\u0006\u0010(\u001a\u00020\tH\u0002J\u0014\u00106\u001a\u00020\u001e*\u00020\u001e2\u0006\u00107\u001a\u00020\tH\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule;", "Lcom/lynx/jsbridge/LynxModule;", "context", "Landroid/content/Context;", "param", "", "(Landroid/content/Context;Ljava/lang/Object;)V", "bridgeAsyncExecuteList", "", "", "getBridgeAsyncExecuteList", "()Ljava/util/List;", "bridgeExecuteStrategy", "", "getBridgeExecuteStrategy", "()I", "bridgeRegistry", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "getBridgeRegistry", "()Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "firstBridgeInit", "", "testService", "Lcom/bytedance/ies/bullet/service/base/ITestService;", "call", "", "func", "params", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "composeErrorMessage", "message", "code", "doMonitorInitLog", "initTime", "", "doMonitorLog", "methodName", "invokeTime", "bridgeType", "executeThread", "success", "errorCode", "errorMsg", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IZLjava/lang/Integer;Ljava/lang/String;)V", "getExecuteTask", "Ljava/util/concurrent/Callable;", "perfData", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "getExecuteThread", "onReady", "optMap", "key", "BridgeRejection", "Companion", "CompatBridgeCallback", "IDLBridgeCallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxBridgeModule extends LynxModule {
    public static final int BRIDGE_EXECUTE_STRATEGY_BACKGROUND = 1;
    public static final int BRIDGE_EXECUTE_STRATEGY_CURRENT = 2;
    public static final int BRIDGE_EXECUTE_STRATEGY_UI_THREAD = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_DATA = "data";
    public static final String KEY_USE_UI_THREAD = "useUIThread";
    public static final String NAME = "bridge";
    public static final String TAG = "LynxBridgeModule";
    private final BulletContext bulletContext;
    private boolean firstBridgeInit;
    private final ITestService testService;

    private final void doMonitorLog(String str, String str2, long j, String str3, int i) {
        doMonitorLog$default(this, str, str2, j, str3, i, false, null, null, 224, null);
    }

    private final void doMonitorLog(String str, String str2, long j, String str3, int i, boolean z) {
        doMonitorLog$default(this, str, str2, j, str3, i, z, null, null, 192, null);
    }

    private final void doMonitorLog(String str, String str2, long j, String str3, int i, boolean z, Integer num) {
        doMonitorLog$default(this, str, str2, j, str3, i, z, num, null, 128, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LynxBridgeModule(Context context, Object obj) {
        super(context, obj);
        String bid;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(obj, "param");
        BulletContext bulletContext = obj instanceof BulletContext ? (BulletContext) obj : null;
        this.bulletContext = bulletContext;
        this.testService = (ITestService) ServiceCenter.INSTANCE.instance().get((bulletContext == null || (bid = bulletContext.getBid()) == null) ? "default_bid" : bid, ITestService.class);
        BridgeDataConverterHolder.registerJSONTypeConverter$default(BridgeDataConverterHolder.PLATFORM_LYNX, new Function1<Object, JSONObject>() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$reactToJsonConverter$1
            public JSONObject invoke(Object p) {
                Intrinsics.checkNotNullParameter(p, "p");
                if (p instanceof ReadableMap) {
                    return JsonConvertHelper.INSTANCE.reactToJSON((ReadableMap) p);
                }
                return null;
            }
        }, null, 4, null);
    }

    /* compiled from: LynxBridgeModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule$Companion;", "", "()V", "BRIDGE_EXECUTE_STRATEGY_BACKGROUND", "", "BRIDGE_EXECUTE_STRATEGY_CURRENT", "BRIDGE_EXECUTE_STRATEGY_UI_THREAD", "KEY_DATA", "", "KEY_USE_UI_THREAD", "getKEY_USE_UI_THREAD$annotations", "NAME", "TAG", "BridgeExecuteStrategy", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {

        /* compiled from: LynxBridgeModule.kt */
        @Retention(RetentionPolicy.RUNTIME)
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule$Companion$BridgeExecuteStrategy;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public @interface BridgeExecuteStrategy {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "better not use")
        public static /* synthetic */ void getKEY_USE_UI_THREAD$annotations() {
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IBridgeRegistry getBridgeRegistry() {
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null) {
            return bulletContext.getBridgeRegistry();
        }
        return null;
    }

    private final int getBridgeExecuteStrategy() {
        BridgeExecute bridgeExecute;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        CommonConfig commonConfig = iBulletSettingsService != null ? (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class) : null;
        if (commonConfig == null || (bridgeExecute = commonConfig.getBridgeExecute()) == null) {
            return 0;
        }
        return bridgeExecute.getBridgeAsyncExecute();
    }

    private final List<String> getBridgeAsyncExecuteList() {
        BridgeExecute bridgeExecute;
        List<String> bridgeAsyncExecuteList;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        CommonConfig commonConfig = iBulletSettingsService != null ? (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class) : null;
        return (commonConfig == null || (bridgeExecute = commonConfig.getBridgeExecute()) == null || (bridgeAsyncExecuteList = bridgeExecute.getBridgeAsyncExecuteList()) == null) ? CollectionsKt.emptyList() : bridgeAsyncExecuteList;
    }

    @LynxMethod
    public final void call(String func, ReadableMap params, Callback callback) {
        Intrinsics.checkNotNullParameter(func, "func");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (TextUtils.isEmpty(func)) {
            return;
        }
        if (getBridgeRegistry() == null) {
            BulletLogger.INSTANCE.printLog("bridgeRegistry is null", LogLevel.E, "XLynxKit");
            return;
        }
        IBridgeRegistry bridgeRegistry = getBridgeRegistry();
        Intrinsics.checkNotNull(bridgeRegistry);
        if (bridgeRegistry.getHasReleased()) {
            BulletLogger.INSTANCE.printLog("bridgeRegistry is released", LogLevel.E, "XLynxKit");
            return;
        }
        IBridgeRegistry bridgeRegistry2 = getBridgeRegistry();
        Intrinsics.checkNotNull(bridgeRegistry2, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry");
        if (!((BridgeRegistry) bridgeRegistry2).getHasBridgesInit() && !this.firstBridgeInit) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.firstBridgeInit = true;
            BulletLogger.INSTANCE.printLog("init bridge", LogLevel.D, "XLynxKit");
            Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$call$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    IBridgeRegistry bridgeRegistry3;
                    bridgeRegistry3 = LynxBridgeModule.this.getBridgeRegistry();
                    if (bridgeRegistry3 != null) {
                        bridgeRegistry3.getBridges();
                    }
                    LynxBridgeModule.this.doMonitorInitLog(SystemClock.elapsedRealtime() - elapsedRealtime);
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
        BridgePerfData bridgePerfData = new BridgePerfData();
        BridgePerfData.onCallFromJs$default(bridgePerfData, 0L, 1, null);
        int executeThread = getExecuteThread(func, params);
        Callable<?> executeTask = getExecuteTask(func, params, callback, executeThread, bridgePerfData);
        if (executeThread == 0) {
            Task.call(executeTask, Task.UI_THREAD_EXECUTOR);
        } else if (executeThread == 1) {
            Task.callInBackground(executeTask);
        } else {
            if (executeThread != 2) {
                return;
            }
            Task.call(executeTask);
        }
    }

    public final int getExecuteThread(String func, ReadableMap params) {
        Intrinsics.checkNotNullParameter(func, "func");
        Intrinsics.checkNotNullParameter(params, "params");
        IBridgeRegistry bridgeRegistry = getBridgeRegistry();
        Intrinsics.checkNotNull(bridgeRegistry, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry");
        if (!((BridgeRegistry) bridgeRegistry).getHasBridgesInit()) {
            BulletLogger.INSTANCE.printLog(func + " use main thread", LogLevel.D, "XLynxKit");
            return 0;
        }
        if (params.hasKey("data")) {
            params = optMap(params, "data");
        }
        if (params.hasKey(KEY_USE_UI_THREAD)) {
            return !params.getBoolean(KEY_USE_UI_THREAD) ? 1 : 0;
        }
        int bridgeExecuteStrategy = getBridgeExecuteStrategy();
        if (bridgeExecuteStrategy == 0 || !getBridgeAsyncExecuteList().contains(func)) {
            return 0;
        }
        if (bridgeExecuteStrategy == 1 || bridgeExecuteStrategy == 2) {
            return bridgeExecuteStrategy;
        }
        return 0;
    }

    private final Callable<?> getExecuteTask(final String func, final ReadableMap params, final Callback callback, @Companion.BridgeExecuteStrategy final int executeThread, final BridgePerfData perfData) {
        return new Callable() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$getExecuteTask$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                ITestService iTestService;
                BulletContext bulletContext;
                IBridgeRegistry bridgeRegistry;
                IBridgeRegistry bridgeRegistry2;
                IBridgeRegistry bridgeRegistry3;
                long j;
                IBridgeRegistry bridgeRegistry4;
                IKitViewService viewService;
                BulletContext bulletContext2;
                BulletLogger.INSTANCE.printLog(func + " execute in " + Thread.currentThread().getName(), LogLevel.D, "XLynxKit");
                iTestService = this.testService;
                if (iTestService != null) {
                    LynxBridgeModule lynxBridgeModule = this;
                    String str = func;
                    int i = executeThread;
                    TNativeEvent tNativeEvent = new TNativeEvent("BridgeTest");
                    bulletContext2 = lynxBridgeModule.bulletContext;
                    String sessionId = bulletContext2 != null ? bulletContext2.getSessionId() : null;
                    if (sessionId != null) {
                        tNativeEvent.setSessionId(sessionId);
                    }
                    tNativeEvent.getExtra().put("method", str);
                    Map<String, Object> extra = tNativeEvent.getExtra();
                    String name = Thread.currentThread().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "currentThread().name");
                    extra.put("thread", name);
                    tNativeEvent.getExtra().put("strategy", String.valueOf(i));
                    iTestService.onEvent(tNativeEvent);
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                bulletContext = this.bulletContext;
                View realView = (bulletContext == null || (viewService = bulletContext.getViewService()) == null) ? null : viewService.realView();
                Intrinsics.checkNotNull(realView, "null cannot be cast to non-null type com.lynx.tasm.LynxView");
                LynxView lynxView = (LynxView) realView;
                BridgePerfData.onDecodeEnd$default(perfData, 0L, 1, null);
                bridgeRegistry = this.getBridgeRegistry();
                if (bridgeRegistry != null) {
                    final BridgePerfData bridgePerfData = perfData;
                    bridgeRegistry.setBridgePreInvokeHandler(new Function1<IGenericBridgeMethod, Unit>() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$getExecuteTask$1.2
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((IGenericBridgeMethod) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(IGenericBridgeMethod iGenericBridgeMethod) {
                            Intrinsics.checkNotNullParameter(iGenericBridgeMethod, "it");
                            BridgePerfData.onMethodCall$default(BridgePerfData.this, 0L, 1, null);
                        }
                    });
                }
                bridgeRegistry2 = this.getBridgeRegistry();
                IGenericBridgeMethod bridgeInstance = bridgeRegistry2 != null ? bridgeRegistry2.getBridgeInstance(func) : null;
                if (bridgeInstance == null || (bridgeInstance instanceof IBridgeMethod)) {
                    bridgeRegistry3 = this.getBridgeRegistry();
                    if (bridgeRegistry3 == null) {
                        return null;
                    }
                    String str2 = func;
                    JSONObject reactToJSON = JsonConvertHelper.INSTANCE.reactToJSON(params);
                    JSONObject optJSONObject = reactToJSON.optJSONObject("data");
                    if (optJSONObject != null) {
                        reactToJSON = optJSONObject;
                    }
                    LynxBridgeModule.CompatBridgeCallback compatBridgeCallback = new LynxBridgeModule.CompatBridgeCallback(this, perfData, func, callback, elapsedRealtime, executeThread, lynxView);
                    LynxBridgeModule.BridgeRejection bridgeRejection = new LynxBridgeModule.BridgeRejection(this, perfData, func, callback, elapsedRealtime, executeThread, lynxView);
                    bridgeRejection.setDiagnoseMsg("lynx bridge IBridgeMethod rejected");
                    Unit unit = Unit.INSTANCE;
                    bridgeRegistry3.handle(str2, reactToJSON, compatBridgeCallback, bridgeRejection);
                    return Unit.INSTANCE;
                }
                final IIDLGenericBridgeMethod iIDLGenericBridgeMethod = (IIDLGenericBridgeMethod) bridgeInstance;
                final Function2<Object, Class<?>, Object> provideTypeConverter = BridgeDataConverterHolder.provideTypeConverter(ReadableMap.class, Map.class);
                final Function2<Object, Class<?>, Object> provideTypeConverter2 = BridgeDataConverterHolder.provideTypeConverter(Map.class, ReadableMap.class);
                iIDLGenericBridgeMethod.setLocalInputConverter(new Function1<Object, Object>() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$getExecuteTask$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public final Object invoke(Object obj) {
                        Intrinsics.checkNotNullParameter(obj, "it");
                        Function2<Object, Class<?>, Object> function2 = provideTypeConverter;
                        if (function2 != null) {
                            Class<?> innerClassType = iIDLGenericBridgeMethod.getInnerClassType();
                            if (innerClassType == null) {
                                innerClassType = Object.class;
                            }
                            Object invoke = function2.invoke(obj, innerClassType);
                            if (invoke != null) {
                                return invoke;
                            }
                        }
                        return MapsKt.emptyMap();
                    }
                });
                iIDLGenericBridgeMethod.setLocalOutputConverter(new Function1<Object, Object>() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$getExecuteTask$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public final Object invoke(Object obj) {
                        Intrinsics.checkNotNullParameter(obj, "it");
                        Function2<Object, Class<?>, Object> function2 = provideTypeConverter2;
                        if (function2 != null) {
                            Class<?> innerClassType = iIDLGenericBridgeMethod.getInnerClassType();
                            if (innerClassType == null) {
                                innerClassType = Object.class;
                            }
                            Object invoke = function2.invoke(obj, innerClassType);
                            if (invoke != null) {
                                return invoke;
                            }
                        }
                        WritableMap createMap = Arguments.createMap();
                        Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
                        return createMap;
                    }
                });
                try {
                    bridgeRegistry4 = this.getBridgeRegistry();
                    if (bridgeRegistry4 == null) {
                        return null;
                    }
                    j = elapsedRealtime;
                    try {
                        bridgeRegistry4.handle(func, params, new LynxBridgeModule.IDLBridgeCallback(this, perfData, func, callback, elapsedRealtime, executeThread, lynxView), new LynxBridgeModule.BridgeRejection(this, perfData, func, callback, elapsedRealtime, executeThread, lynxView));
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        BridgePerfData.onCallbackStart$default(perfData, 0L, 1, null);
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("code", 0);
                        createMap.putString("message", th.toString());
                        callback.invoke(new Object[]{createMap});
                        BridgePerfData bridgePerfData2 = perfData;
                        LynxBridgeModule lynxBridgeModule2 = this;
                        String str3 = func;
                        BridgePerfData.onEncodeEnd$default(bridgePerfData2, 0L, 1, null);
                        BridgePerfData.onCallbackEnd$default(bridgePerfData2, 0L, 1, null);
                        lynxBridgeModule2.onReady(bridgePerfData2, str3);
                        String str4 = func;
                        LynxBridgeModule lynxBridgeModule3 = this;
                        LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                        JsbErrorData jsbErrorData = new JsbErrorData();
                        jsbErrorData.setBridgeName(str4);
                        jsbErrorData.setErrorCode(4);
                        jsbErrorData.setErrorMessage(lynxBridgeModule3.composeErrorMessage(th.toString(), 0));
                        Unit unit2 = Unit.INSTANCE;
                        instance.reportJsbError(lynxView, jsbErrorData);
                        this.doMonitorLog(func, "lynx bridge catch exception", j, "xbridge", executeThread, false, 4, this.composeErrorMessage(th.toString(), 0));
                        return Unit.INSTANCE;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j = elapsedRealtime;
                }
            }
        };
    }

    private final ReadableMap optMap(ReadableMap readableMap, String str) {
        try {
            ReadableMap map = readableMap.hasKey(str) ? readableMap.getMap(str) : new JavaOnlyMap();
            Intrinsics.checkNotNullExpressionValue(map, "{\n            if (this.h…e JavaOnlyMap()\n        }");
            return map;
        } catch (Exception unused) {
            return new JavaOnlyMap();
        }
    }

    public final String composeErrorMessage(String message, int code) {
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            Result.Companion companion = Result.Companion;
            String jSONObject = new JSONObject().putOpt("message", message).putOpt("code", Integer.valueOf(code)).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n           …              .toString()");
            return jSONObject;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return message;
        }
    }

    static /* synthetic */ void doMonitorLog$default(LynxBridgeModule lynxBridgeModule, String str, String str2, long j, String str3, int i, boolean z, Integer num, String str4, int i2, Object obj) {
        lynxBridgeModule.doMonitorLog(str, str2, j, str3, i, (i2 & 32) != 0 ? true : z, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doMonitorLog(final String methodName, String message, long invokeTime, final String bridgeType, final int executeThread, final boolean success, Integer errorCode, String errorMsg) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$doMonitorLog$1
            @Override // java.util.concurrent.Callable
            /* renamed from: call-xLWZpok, reason: not valid java name and merged with bridge method [inline-methods] */
            public final Result<? extends IMonitorReportService> call() {
                Object obj;
                BulletContext bulletContext;
                String str;
                BulletContext bulletContext2;
                BulletContext bulletContext3;
                BulletContext bulletContext4;
                String str2;
                BulletLoadUriIdentifier uriIdentifier;
                BulletLoadUriIdentifier uriIdentifier2;
                boolean z = success;
                LynxBridgeModule lynxBridgeModule = this;
                int i = executeThread;
                String str3 = methodName;
                String str4 = bridgeType;
                try {
                    Result.Companion companion = Result.Companion;
                    int i2 = !z ? -1 : 1;
                    IServiceCenter instance = ServiceCenter.INSTANCE.instance();
                    bulletContext = lynxBridgeModule.bulletContext;
                    if (bulletContext == null || (str = bulletContext.getBid()) == null) {
                        str = "default_bid";
                    }
                    IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(str, IMonitorReportService.class);
                    if (iMonitorReportService != null) {
                        ReportInfo reportInfo = new ReportInfo("bdx_monitor_bridge_pv", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                        bulletContext2 = lynxBridgeModule.bulletContext;
                        reportInfo.setPageIdentifier(bulletContext2 != null ? bulletContext2.getUriIdentifier() : null);
                        String str5 = "main";
                        String str6 = i == 0 ? "main" : "child";
                        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                            str5 = "child";
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("method_name", str3);
                        bulletContext3 = lynxBridgeModule.bulletContext;
                        jSONObject.put("_full_url", (bulletContext3 == null || (uriIdentifier2 = bulletContext3.getUriIdentifier()) == null) ? null : uriIdentifier2.getFullUrl());
                        jSONObject.put("type", str4);
                        jSONObject.put("call_thread", str6);
                        jSONObject.put("callback_thread", str5);
                        jSONObject.put("result", i2);
                        reportInfo.setCategory(jSONObject);
                        bulletContext4 = lynxBridgeModule.bulletContext;
                        if (bulletContext4 == null || (uriIdentifier = bulletContext4.getUriIdentifier()) == null || (str2 = uriIdentifier.getIdentifierUrl()) == null) {
                            str2 = "Unknown";
                        }
                        reportInfo.setUrl(str2);
                        reportInfo.setPlatform("lynx");
                        reportInfo.setHighFrequency(true);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("platform", 3);
                        reportInfo.setCommon(jSONObject2);
                        iMonitorReportService.report(reportInfo);
                    } else {
                        iMonitorReportService = null;
                    }
                    obj = Result.constructor-impl(iMonitorReportService);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                return Result.box-impl(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doMonitorInitLog(final long initTime) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$doMonitorInitLog$1
            @Override // java.util.concurrent.Callable
            /* renamed from: call-xLWZpok, reason: not valid java name and merged with bridge method [inline-methods] */
            public final Result<? extends Unit> call() {
                Object obj;
                BulletContext bulletContext;
                String str;
                BulletContext bulletContext2;
                BulletContext bulletContext3;
                String str2;
                BulletLoadUriIdentifier uriIdentifier;
                BulletLoadUriIdentifier uriIdentifier2;
                LynxBridgeModule lynxBridgeModule = LynxBridgeModule.this;
                long j = initTime;
                try {
                    Result.Companion companion = Result.Companion;
                    IServiceCenter instance = ServiceCenter.INSTANCE.instance();
                    bulletContext = lynxBridgeModule.bulletContext;
                    if (bulletContext == null || (str = bulletContext.getBid()) == null) {
                        str = "default_bid";
                    }
                    IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(str, IMonitorReportService.class);
                    if (iMonitorReportService != null) {
                        ReportInfo reportInfo = new ReportInfo("bdx_monitor_bridge_init_duration", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                        JSONObject jSONObject = new JSONObject();
                        bulletContext2 = lynxBridgeModule.bulletContext;
                        jSONObject.put("_full_url", (bulletContext2 == null || (uriIdentifier2 = bulletContext2.getUriIdentifier()) == null) ? null : uriIdentifier2.getFullUrl());
                        reportInfo.setCategory(jSONObject);
                        bulletContext3 = lynxBridgeModule.bulletContext;
                        if (bulletContext3 == null || (uriIdentifier = bulletContext3.getUriIdentifier()) == null || (str2 = uriIdentifier.getIdentifierUrl()) == null) {
                            str2 = "Unknown";
                        }
                        reportInfo.setUrl(str2);
                        reportInfo.setPlatform("lynx");
                        reportInfo.setHighFrequency(true);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("platform", 3);
                        reportInfo.setCommon(jSONObject2);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("init_bridge_time", j);
                        reportInfo.setMetrics(jSONObject3);
                        iMonitorReportService.report(reportInfo);
                    }
                    BulletLogger.INSTANCE.printLog("init bridge end, time use == " + j, LogLevel.D, "XLynxKit");
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                return Result.box-impl(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onReady(final BridgePerfData bridgePerfData, final String str) {
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule$onReady$1
            @Override // java.util.concurrent.Callable
            public final IMonitorReportService call() {
                BulletContext bulletContext;
                String str2;
                BulletContext bulletContext2;
                IServiceCenter instance = ServiceCenter.INSTANCE.instance();
                bulletContext = LynxBridgeModule.this.bulletContext;
                if (bulletContext == null || (str2 = bulletContext.getBid()) == null) {
                    str2 = "default_bid";
                }
                IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(str2, IMonitorReportService.class);
                if (iMonitorReportService == null) {
                    return null;
                }
                LynxBridgeModule lynxBridgeModule = LynxBridgeModule.this;
                BridgePerfData bridgePerfData2 = bridgePerfData;
                String str3 = str;
                ReportInfo reportInfo = new ReportInfo("bdx_monitor_bridge_duration", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                bulletContext2 = lynxBridgeModule.bulletContext;
                reportInfo.setPageIdentifier(bulletContext2 != null ? bulletContext2.getUriIdentifier() : null);
                reportInfo.setMetrics(bridgePerfData2.toJSON());
                JSONObject jSONObject = new JSONObject();
                try {
                    Result.Companion companion = Result.Companion;
                    Result.constructor-impl(jSONObject.put("method_name", str3));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                reportInfo.setCategory(jSONObject);
                reportInfo.setPlatform("lynx");
                reportInfo.setHighFrequency(true);
                iMonitorReportService.report(reportInfo);
                return iMonitorReportService;
            }
        });
    }

    /* compiled from: LynxBridgeModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0011\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0002H\u0096\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule$BridgeRejection;", "Lkotlin/Function1;", "", "", "perfData", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "func", "", "callback", "Lcom/lynx/react/bridge/Callback;", "bridgeInvokeTime", "", "executeThread", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "(Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule;Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;Ljava/lang/String;Lcom/lynx/react/bridge/Callback;JILcom/lynx/tasm/LynxView;)V", "getBridgeInvokeTime", "()J", "getCallback", "()Lcom/lynx/react/bridge/Callback;", "diagnoseMsg", "getDiagnoseMsg", "()Ljava/lang/String;", "setDiagnoseMsg", "(Ljava/lang/String;)V", "getExecuteThread", "()I", "getFunc", "getLynxView", "()Lcom/lynx/tasm/LynxView;", "getPerfData", "()Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "invoke", "t", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class BridgeRejection implements Function1<Throwable, Unit> {
        private final long bridgeInvokeTime;
        private final Callback callback;
        private String diagnoseMsg;
        private final int executeThread;
        private final String func;
        private final LynxView lynxView;
        private final BridgePerfData perfData;
        final /* synthetic */ LynxBridgeModule this$0;

        public BridgeRejection(LynxBridgeModule lynxBridgeModule, BridgePerfData bridgePerfData, String str, Callback callback, @Companion.BridgeExecuteStrategy long j, int i, LynxView lynxView) {
            Intrinsics.checkNotNullParameter(bridgePerfData, "perfData");
            Intrinsics.checkNotNullParameter(str, "func");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.this$0 = lynxBridgeModule;
            this.perfData = bridgePerfData;
            this.func = str;
            this.callback = callback;
            this.bridgeInvokeTime = j;
            this.executeThread = i;
            this.lynxView = lynxView;
            this.diagnoseMsg = "lynx bridge rejected";
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        public final BridgePerfData getPerfData() {
            return this.perfData;
        }

        public final String getFunc() {
            return this.func;
        }

        public final Callback getCallback() {
            return this.callback;
        }

        public final long getBridgeInvokeTime() {
            return this.bridgeInvokeTime;
        }

        public final int getExecuteThread() {
            return this.executeThread;
        }

        public final LynxView getLynxView() {
            return this.lynxView;
        }

        public final String getDiagnoseMsg() {
            return this.diagnoseMsg;
        }

        public final void setDiagnoseMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.diagnoseMsg = str;
        }

        public void invoke(Throwable t) {
            Intrinsics.checkNotNullParameter(t, "t");
            if (t instanceof IBridgeScope.BridgeNotFoundException) {
                BridgePerfData.onCallbackStart$default(this.perfData, 0L, 1, null);
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("code", -2);
                String message = t.getMessage();
                if (message == null) {
                    message = "";
                }
                createMap.putString("message", message);
                this.callback.invoke(new Object[]{createMap});
                BridgePerfData bridgePerfData = this.perfData;
                LynxBridgeModule lynxBridgeModule = this.this$0;
                BridgePerfData.onEncodeEnd$default(bridgePerfData, 0L, 1, null);
                BridgePerfData.onCallbackEnd$default(bridgePerfData, 0L, 1, null);
                lynxBridgeModule.onReady(bridgePerfData, this.func);
                LynxView lynxView = this.lynxView;
                if (lynxView != null) {
                    LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                    JsbErrorData jsbErrorData = new JsbErrorData();
                    jsbErrorData.setBridgeName(this.func);
                    jsbErrorData.setErrorCode(4);
                    jsbErrorData.setErrorMessage("bridge method not found");
                    Unit unit = Unit.INSTANCE;
                    instance.reportJsbError(lynxView, jsbErrorData);
                }
                this.this$0.doMonitorLog(this.func, this.diagnoseMsg, this.bridgeInvokeTime, "xbridge", this.executeThread, false, 4, "bridge method not found," + t);
            }
        }
    }

    /* compiled from: LynxBridgeModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0005H\u0016J \u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule$CompatBridgeCallback;", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$ICallback;", "perfData", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "func", "", "callback", "Lcom/lynx/react/bridge/Callback;", "bridgeInvokeTime", "", "executeThread", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "(Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule;Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;Ljava/lang/String;Lcom/lynx/react/bridge/Callback;JILcom/lynx/tasm/LynxView;)V", "getBridgeInvokeTime", "()J", "getCallback", "()Lcom/lynx/react/bridge/Callback;", "getExecuteThread", "()I", "getFunc", "()Ljava/lang/String;", "getLynxView", "()Lcom/lynx/tasm/LynxView;", "getPerfData", "()Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "onComplete", "", "data", "Lorg/json/JSONObject;", "onError", "code", "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class CompatBridgeCallback implements IBridgeMethod.ICallback {
        private final long bridgeInvokeTime;
        private final Callback callback;
        private final int executeThread;
        private final String func;
        private final LynxView lynxView;
        private final BridgePerfData perfData;
        final /* synthetic */ LynxBridgeModule this$0;

        public CompatBridgeCallback(LynxBridgeModule lynxBridgeModule, BridgePerfData bridgePerfData, String str, Callback callback, @Companion.BridgeExecuteStrategy long j, int i, LynxView lynxView) {
            Intrinsics.checkNotNullParameter(bridgePerfData, "perfData");
            Intrinsics.checkNotNullParameter(str, "func");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.this$0 = lynxBridgeModule;
            this.perfData = bridgePerfData;
            this.func = str;
            this.callback = callback;
            this.bridgeInvokeTime = j;
            this.executeThread = i;
            this.lynxView = lynxView;
        }

        public final BridgePerfData getPerfData() {
            return this.perfData;
        }

        public final String getFunc() {
            return this.func;
        }

        public final Callback getCallback() {
            return this.callback;
        }

        public final long getBridgeInvokeTime() {
            return this.bridgeInvokeTime;
        }

        public final int getExecuteThread() {
            return this.executeThread;
        }

        public final LynxView getLynxView() {
            return this.lynxView;
        }

        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
        public void onComplete(JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            BridgePerfData.onCallbackStart$default(this.perfData, 0L, 1, null);
            try {
                this.callback.invoke(new Object[]{JsonConvertHelper.INSTANCE.jsonToReact(data)});
            } catch (JSONException e) {
                BulletLogger.INSTANCE.printReject(e, "onComplete", "XLynxKit");
            }
            BridgePerfData bridgePerfData = this.perfData;
            LynxBridgeModule lynxBridgeModule = this.this$0;
            BridgePerfData.onEncodeEnd$default(bridgePerfData, 0L, 1, null);
            BridgePerfData.onCallbackEnd$default(bridgePerfData, 0L, 1, null);
            lynxBridgeModule.onReady(bridgePerfData, this.func);
            LynxView lynxView = this.lynxView;
            if (lynxView != null) {
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                JsbInfoData jsbInfoData = new JsbInfoData();
                jsbInfoData.setBridgeName(this.func);
                jsbInfoData.setStatusCode(0);
                jsbInfoData.setCostTime(SystemClock.elapsedRealtime() - this.bridgeInvokeTime);
                Unit unit = Unit.INSTANCE;
                instance.reportJsbInfo(lynxView, jsbInfoData);
            }
            LynxBridgeModule.doMonitorLog$default(this.this$0, this.func, "complete Lynx bridge  IBridgeMethod success", this.bridgeInvokeTime, "bdlynxbridge", this.executeThread, false, 0, null, 160, null);
        }

        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
        public void onError(int code, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            BridgePerfData.onCallbackStart$default(this.perfData, 0L, 1, null);
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("code", code);
            createMap.putString("message", message);
            this.callback.invoke(new Object[]{createMap});
            BridgePerfData bridgePerfData = this.perfData;
            LynxBridgeModule lynxBridgeModule = this.this$0;
            BridgePerfData.onEncodeEnd$default(bridgePerfData, 0L, 1, null);
            BridgePerfData.onCallbackEnd$default(bridgePerfData, 0L, 1, null);
            lynxBridgeModule.onReady(bridgePerfData, this.func);
            LynxView lynxView = this.lynxView;
            if (lynxView != null) {
                LynxBridgeModule lynxBridgeModule2 = this.this$0;
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                JsbErrorData jsbErrorData = new JsbErrorData();
                jsbErrorData.setBridgeName(this.func);
                jsbErrorData.setErrorCode(4);
                jsbErrorData.setErrorMessage(lynxBridgeModule2.composeErrorMessage(message, code));
                Unit unit = Unit.INSTANCE;
                instance.reportJsbError(lynxView, jsbErrorData);
            }
            this.this$0.doMonitorLog(this.func, "complete lynx bridge  IBridgeMethod failed", this.bridgeInvokeTime, "bdlynxbridge", this.executeThread, false, 4, this.this$0.composeErrorMessage(message, code));
        }

        @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod.ICallback
        public void onError(int code, String message, JSONObject data) {
            Object obj;
            String jSONObject;
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean z = true;
            BridgePerfData.onCallbackStart$default(this.perfData, 0L, 1, null);
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("code", code);
            createMap.putString("msg", message);
            createMap.putString("message", message);
            try {
                createMap.putMap("data", JsonConvertHelper.INSTANCE.jsonToReact(data));
            } catch (JSONException e) {
                BulletLogger.INSTANCE.printReject(e, message, "XLynxKit");
            }
            this.callback.invoke(new Object[]{createMap});
            BridgePerfData bridgePerfData = this.perfData;
            LynxBridgeModule lynxBridgeModule = this.this$0;
            BridgePerfData.onEncodeEnd$default(bridgePerfData, 0L, 1, null);
            BridgePerfData.onCallbackEnd$default(bridgePerfData, 0L, 1, null);
            lynxBridgeModule.onReady(bridgePerfData, this.func);
            LynxView lynxView = this.lynxView;
            if (lynxView != null) {
                LynxBridgeModule lynxBridgeModule2 = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    if (message.length() <= 0) {
                        z = false;
                    }
                    String str = z ? message : null;
                    if (str == null || (jSONObject = str + " with [" + data + ']') == null) {
                        jSONObject = data.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toString()");
                    }
                    obj = Result.constructor-impl(jSONObject);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = message;
                }
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                JsbErrorData jsbErrorData = new JsbErrorData();
                jsbErrorData.setBridgeName(this.func);
                jsbErrorData.setErrorCode(4);
                jsbErrorData.setErrorMessage(lynxBridgeModule2.composeErrorMessage((String) obj, code));
                Unit unit = Unit.INSTANCE;
                instance.reportJsbError(lynxView, jsbErrorData);
            }
            this.this$0.doMonitorLog(this.func, "complete lynx bridge IBridgeMethod failed", this.bridgeInvokeTime, "bdlynxbridge", this.executeThread, false, 4, this.this$0.composeErrorMessage(message, code) + createMap.getMap("data"));
        }
    }

    /* compiled from: LynxBridgeModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0006H\u0016J \u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0002H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule$IDLBridgeCallback;", "Lcom/bytedance/ies/bullet/core/kit/bridge/IIDLGenericBridgeMethod$ICallback;", "Lcom/lynx/react/bridge/ReadableMap;", "perfData", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "func", "", "callback", "Lcom/lynx/react/bridge/Callback;", "bridgeInvokeTime", "", "executeThread", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "(Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule;Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;Ljava/lang/String;Lcom/lynx/react/bridge/Callback;JILcom/lynx/tasm/LynxView;)V", "getBridgeInvokeTime", "()J", "getCallback", "()Lcom/lynx/react/bridge/Callback;", "getExecuteThread", "()I", "getFunc", "()Ljava/lang/String;", "getLynxView", "()Lcom/lynx/tasm/LynxView;", "getPerfData", "()Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePerfData;", "onComplete", "", "data", "onError", "code", "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class IDLBridgeCallback implements IIDLGenericBridgeMethod.ICallback<ReadableMap> {
        private final long bridgeInvokeTime;
        private final Callback callback;
        private final int executeThread;
        private final String func;
        private final LynxView lynxView;
        private final BridgePerfData perfData;
        final /* synthetic */ LynxBridgeModule this$0;

        public IDLBridgeCallback(LynxBridgeModule lynxBridgeModule, BridgePerfData bridgePerfData, String str, Callback callback, @Companion.BridgeExecuteStrategy long j, int i, LynxView lynxView) {
            Intrinsics.checkNotNullParameter(bridgePerfData, "perfData");
            Intrinsics.checkNotNullParameter(str, "func");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.this$0 = lynxBridgeModule;
            this.perfData = bridgePerfData;
            this.func = str;
            this.callback = callback;
            this.bridgeInvokeTime = j;
            this.executeThread = i;
            this.lynxView = lynxView;
        }

        public final BridgePerfData getPerfData() {
            return this.perfData;
        }

        public final String getFunc() {
            return this.func;
        }

        public final Callback getCallback() {
            return this.callback;
        }

        public final long getBridgeInvokeTime() {
            return this.bridgeInvokeTime;
        }

        public final int getExecuteThread() {
            return this.executeThread;
        }

        public final LynxView getLynxView() {
            return this.lynxView;
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
        public void onComplete(ReadableMap data) {
            Intrinsics.checkNotNullParameter(data, "data");
            BridgePerfData.onCallbackStart$default(this.perfData, 0L, 1, null);
            try {
                this.callback.invoke(new Object[]{data});
            } catch (Throwable th) {
                BulletLogger.INSTANCE.printReject(th, "onComplete", "XLynxKit");
            }
            BridgePerfData bridgePerfData = this.perfData;
            LynxBridgeModule lynxBridgeModule = this.this$0;
            BridgePerfData.onEncodeEnd$default(bridgePerfData, 0L, 1, null);
            BridgePerfData.onCallbackEnd$default(bridgePerfData, 0L, 1, null);
            lynxBridgeModule.onReady(bridgePerfData, this.func);
            LynxView lynxView = this.lynxView;
            if (lynxView != null) {
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                JsbInfoData jsbInfoData = new JsbInfoData();
                jsbInfoData.setBridgeName(this.func);
                jsbInfoData.setStatusCode(0);
                jsbInfoData.setCostTime(SystemClock.elapsedRealtime() - jsbInfoData.getInvokeTime());
                Unit unit = Unit.INSTANCE;
                instance.reportJsbInfo(lynxView, jsbInfoData);
            }
            LynxBridgeModule.doMonitorLog$default(this.this$0, this.func, "complete Lynx bridge success", this.bridgeInvokeTime, "xbridge", this.executeThread, false, 0, null, 160, null);
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
        public void onError(int code, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            BridgePerfData.onCallbackStart$default(this.perfData, 0L, 1, null);
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("code", code);
            createMap.putString("message", message);
            this.callback.invoke(new Object[]{createMap});
            BridgePerfData bridgePerfData = this.perfData;
            LynxBridgeModule lynxBridgeModule = this.this$0;
            BridgePerfData.onEncodeEnd$default(bridgePerfData, 0L, 1, null);
            BridgePerfData.onCallbackEnd$default(bridgePerfData, 0L, 1, null);
            lynxBridgeModule.onReady(bridgePerfData, this.func);
            LynxView lynxView = this.lynxView;
            if (lynxView != null) {
                LynxBridgeModule lynxBridgeModule2 = this.this$0;
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                JsbErrorData jsbErrorData = new JsbErrorData();
                jsbErrorData.setBridgeName(this.func);
                jsbErrorData.setErrorCode(4);
                jsbErrorData.setErrorMessage(lynxBridgeModule2.composeErrorMessage(message, code));
                Unit unit = Unit.INSTANCE;
                instance.reportJsbError(lynxView, jsbErrorData);
            }
            this.this$0.doMonitorLog(this.func, "complete lynx bridge failed", this.bridgeInvokeTime, "xbridge", this.executeThread, false, 4, this.this$0.composeErrorMessage(message, code));
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod.ICallback
        public void onError(int code, String message, ReadableMap data) {
            Object obj;
            String obj2;
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(data, "data");
            boolean z = true;
            BridgePerfData.onCallbackStart$default(this.perfData, 0L, 1, null);
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("code", code);
            createMap.putString("msg", message);
            createMap.putString("message", message);
            try {
                createMap.putMap("data", (WritableMap) data);
            } catch (JSONException e) {
                BulletLogger.INSTANCE.printReject(e, "onError:" + message, "XLynxKit");
            }
            this.callback.invoke(new Object[]{createMap});
            BridgePerfData bridgePerfData = this.perfData;
            LynxBridgeModule lynxBridgeModule = this.this$0;
            BridgePerfData.onEncodeEnd$default(bridgePerfData, 0L, 1, null);
            BridgePerfData.onCallbackEnd$default(bridgePerfData, 0L, 1, null);
            lynxBridgeModule.onReady(bridgePerfData, this.func);
            LynxView lynxView = this.lynxView;
            if (lynxView != null) {
                LynxBridgeModule lynxBridgeModule2 = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    if (message.length() <= 0) {
                        z = false;
                    }
                    String str = z ? message : null;
                    if (str == null || (obj2 = str + " with [" + data + ']') == null) {
                        obj2 = data.toString();
                    }
                    obj = Result.constructor-impl(obj2);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = message;
                }
                LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
                JsbErrorData jsbErrorData = new JsbErrorData();
                jsbErrorData.setBridgeName(this.func);
                jsbErrorData.setErrorCode(4);
                jsbErrorData.setErrorMessage(lynxBridgeModule2.composeErrorMessage((String) obj, code));
                Unit unit = Unit.INSTANCE;
                instance.reportJsbError(lynxView, jsbErrorData);
            }
            this.this$0.doMonitorLog(this.func, "complete lynx bridge failed", this.bridgeInvokeTime, "xbridge", this.executeThread, false, 4, this.this$0.composeErrorMessage(message, code) + createMap.getMap("data"));
        }
    }
}
