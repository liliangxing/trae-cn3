package com.bytedance.ies.bullet.service.preload;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Kt;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.IPreRenderCallback;
import com.bytedance.ies.bullet.service.base.IPreRenderService;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.web.IWebPreCreateService;
import com.bytedance.ies.bullet.service.schema.utils.SchemaUtilsKt;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.webx.core.webview.module.TTWebModule;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: WebPreloadBridge.kt */
@XBridgeMethod(name = WebPreloadBridge.DEFAULT_BRIDGE_NAME, owner = "liushaocong")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0002ABB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J(\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0002J,\u00102\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010*\u001a\u00020(2\u0006\u00103\u001a\u00020\u00112\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0002J\u0012\u00106\u001a\u00020\u00112\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\rH\u0002J\u0018\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\u0006\u0010/\u001a\u000200H\u0016J \u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\rH\u0002J\b\u0010@\u001a\u00020&H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/WebPreloadBridge;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "access", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "setAccess", "(Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;)V", "bid", "", "cacheKeys", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "defaultCacheTime", "", "isJSBReleaseCacheEnable", "", "()Z", "isJSBReleaseCacheEnable$delegate", "Lkotlin/Lazy;", "name", "getName", "()Ljava/lang/String;", "pendingPrerenderTaskList", "", "Landroid/os/MessageQueue$IdleHandler;", "preRenderService", "Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "getPreRenderService", "()Lcom/bytedance/ies/bullet/service/base/IPreRenderService;", "preRenderService$delegate", "checkMemory", "memoryThreshold", "", "doPreConnect", "", "uri", "Landroid/net/Uri;", "doPreload", "schema", "context", "Landroid/content/Context;", "strategy", "Lcom/bytedance/ies/bullet/service/preload/WebPreloadBridge$Strategy;", "callback", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$ICallback;", "doRealPreCreate", "doRealRender", "cacheTime", "getContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getFreeMemory", "getStrategy", "strategyString", "handle", "params", "Lorg/json/JSONObject;", "makeResultJson", "result", "code", "message", "release", "Companion", "Strategy", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebPreloadBridge extends BridgeMethod implements StatefulMethod {
    public static final String DEFAULT_BRIDGE_NAME = "bullet.preload";
    private IBridgeMethod.Access access;
    private final String bid;
    private final ConcurrentLinkedQueue<String> cacheKeys;
    private final long defaultCacheTime;

    /* renamed from: isJSBReleaseCacheEnable$delegate, reason: from kotlin metadata */
    private final Lazy isJSBReleaseCacheEnable;
    private final String name;
    private final List<MessageQueue.IdleHandler> pendingPrerenderTaskList;

    /* renamed from: preRenderService$delegate, reason: from kotlin metadata */
    private final Lazy preRenderService;
    private final ContextProviderFactory providerFactory;

    /* compiled from: WebPreloadBridge.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/WebPreloadBridge$Strategy;", "", "(Ljava/lang/String;I)V", "OnlyPreCreate", "PreConnect", "LoadUriOnIdle", "LoadUriRightNow", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum Strategy {
        OnlyPreCreate,
        PreConnect,
        LoadUriOnIdle,
        LoadUriRightNow
    }

    /* compiled from: WebPreloadBridge.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Strategy.values().length];
            try {
                iArr[Strategy.OnlyPreCreate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Strategy.PreConnect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Strategy.LoadUriOnIdle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Strategy.LoadUriRightNow.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebPreloadBridge(ContextProviderFactory contextProviderFactory) {
        super(contextProviderFactory);
        String bid;
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        this.providerFactory = contextProviderFactory;
        this.defaultCacheTime = 10L;
        this.pendingPrerenderTaskList = new ArrayList();
        BulletContext context = getContext();
        this.bid = (context == null || (bid = context.getBid()) == null) ? "default_bid" : bid;
        this.preRenderService = LazyKt.lazy(new Function0<IPreRenderService>() { // from class: com.bytedance.ies.bullet.service.preload.WebPreloadBridge$preRenderService$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IPreRenderService m585invoke() {
                BulletContext context2;
                String str;
                context2 = WebPreloadBridge.this.getContext();
                if (context2 == null || (str = context2.getBid()) == null) {
                    str = "default_bid";
                }
                return (IPreRenderService) StandardServiceManager.INSTANCE.get(str, IPreRenderService.class);
            }
        });
        this.cacheKeys = new ConcurrentLinkedQueue<>();
        this.isJSBReleaseCacheEnable = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.ies.bullet.service.preload.WebPreloadBridge$isJSBReleaseCacheEnable$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m584invoke() {
                BulletSettings provideBulletSettings;
                ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
                return Boolean.valueOf((iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? false : provideBulletSettings.getEnableJSBReleaseCache());
            }
        });
        this.access = IBridgeMethod.Access.PRIVATE;
        this.name = DEFAULT_BRIDGE_NAME;
    }

    private final IPreRenderService getPreRenderService() {
        return (IPreRenderService) this.preRenderService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BulletContext getContext() {
        IBulletContainer iBulletContainer = (IBulletContainer) this.providerFactory.provideInstance(IBulletContainer.class);
        if (iBulletContainer != null) {
            return iBulletContainer.getBulletContext();
        }
        return null;
    }

    private final boolean isJSBReleaseCacheEnable() {
        return ((Boolean) this.isJSBReleaseCacheEnable.getValue()).booleanValue();
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public IBridgeMethod.Access getAccess() {
        return this.access;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod
    public void setAccess(IBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "<set-?>");
        this.access = access;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public void handle(JSONObject params, IBridgeMethod.ICallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String optString = params.optString("schema");
        String optString2 = params.optString("strategy");
        Intrinsics.checkNotNullExpressionValue(optString2, "params.optString(\"strategy\")");
        Strategy strategy = getStrategy(optString2);
        boolean checkMemory = checkMemory(params.optInt("availableMemoryThreshold"));
        ContextProviderFactory contextProviderFactory = getContextProviderFactory();
        Context context = contextProviderFactory != null ? (Context) contextProviderFactory.provideInstance(Context.class) : null;
        if (checkMemory && context != null) {
            Uri parse = Uri.parse(optString);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(schema)");
            doPreload(parse, context, strategy, callback);
            return;
        }
        callback.onComplete(makeResultJson(false, -1, "memory is not allowed"));
    }

    private final void doPreload(final Uri schema, final Context context, Strategy strategy, final IBridgeMethod.ICallback callback) {
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "Start Preload for schema " + schema, null, "XPreload", 2, null);
        String queryParameterSafely = SchemaUtilsKt.getQueryParameterSafely(schema, "view_cache_time");
        final long parseLong = queryParameterSafely != null ? Long.parseLong(queryParameterSafely) : this.defaultCacheTime;
        int i = WhenMappings.$EnumSwitchMapping$0[strategy.ordinal()];
        if (i == 1) {
            doRealPreCreate(context, callback);
            return;
        }
        if (i == 2) {
            doRealPreCreate(context, callback);
            doPreConnect(schema);
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            doRealRender(context, schema, parseLong, callback);
        } else {
            MessageQueue.IdleHandler idleHandler = new MessageQueue.IdleHandler() { // from class: com.bytedance.ies.bullet.service.preload.WebPreloadBridge$doPreload$renderHandler$1
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    WebPreloadBridge.this.doRealRender(context, schema, parseLong, callback);
                    return false;
                }
            };
            this.pendingPrerenderTaskList.add(idleHandler);
            Looper.myQueue().addIdleHandler(idleHandler);
        }
    }

    private final void doRealPreCreate(Context context, IBridgeMethod.ICallback callback) {
        IWebPreCreateService iWebPreCreateService = (IWebPreCreateService) StandardServiceManager.INSTANCE.get(this.bid, IWebPreCreateService.class);
        if (iWebPreCreateService == null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "Preload fail, PreCreate service = null", null, "XPreload", 2, null);
            callback.onError(-1, "Preload Fail, PreCreate service = null");
        } else {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "Start PreCreate", null, "XPreload", 2, null);
            iWebPreCreateService.submitPreCreateWebView(context);
            callback.onComplete(makeResultJson(true, 1, "Preload Success"));
        }
    }

    private final void doPreConnect(Uri uri) {
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "Start PreConnect", null, "XPreload", 2, null);
        TTWebModule.Global.preconnectUrl(uri.toString(), 1);
    }

    static /* synthetic */ void doRealRender$default(WebPreloadBridge webPreloadBridge, Context context, Uri uri, long j, IBridgeMethod.ICallback iCallback, int i, Object obj) {
        if ((i & 8) != 0) {
            iCallback = null;
        }
        webPreloadBridge.doRealRender(context, uri, j, iCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doRealRender(Context context, Uri schema, long cacheTime, final IBridgeMethod.ICallback callback) {
        String queryParameterSafely;
        if (isJSBReleaseCacheEnable() && (queryParameterSafely = SchemaUtilsKt.getQueryParameterSafely(schema, "view_cache_key")) != null) {
            this.cacheKeys.add(queryParameterSafely);
        }
        IPreRenderService preRenderService = getPreRenderService();
        if (preRenderService != null) {
            preRenderService.preRender(schema, context, cacheTime * BytePatchException.ErrorCode.paramsError, new IPreRenderCallback() { // from class: com.bytedance.ies.bullet.service.preload.WebPreloadBridge$doRealRender$2

                /* compiled from: WebPreloadBridge.kt */
                @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[PoolResult.values().length];
                        try {
                            iArr[PoolResult.FAIL_EXISTS.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[PoolResult.FAIL_LOAD_ERROR.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[PoolResult.FAIL_INVALID.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[PoolResult.FAIL_EXCEPTION.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // com.bytedance.ies.bullet.service.base.IPreRenderCallback
                public void onSuccess(String sessionId) {
                    JSONObject makeResultJson;
                    Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "PreRender Success", null, "XPreload", 2, null);
                    makeResultJson = WebPreloadBridge.this.makeResultJson(true, 1, "Preload Success");
                    IBridgeMethod.ICallback iCallback = callback;
                    if (iCallback != null) {
                        iCallback.onComplete(makeResultJson);
                    }
                }

                @Override // com.bytedance.ies.bullet.service.base.IPreRenderCallback
                public void onFailed(PoolResult result, String errorMsg) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    int i = WhenMappings.$EnumSwitchMapping$0[result.ordinal()];
                    String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "NULL" : "FAIL_EXCEPTION" : "FAIL_INVALID" : "FAIL_LOAD_ERROR" : "FAIL_EXISTS";
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "PreRender Failed " + str + ", " + errorMsg, null, "XPreload", 2, null);
                    IBridgeMethod.ICallback iCallback = callback;
                    if (iCallback != null) {
                        StringBuilder append = new StringBuilder("PoolResult:").append(str).append(StringListParam.SPLIT_DELIMITER);
                        if (errorMsg == null) {
                            errorMsg = "Preload Fail";
                        }
                        iCallback.onError(-1, append.append(errorMsg).toString());
                    }
                }
            });
        }
        if (getPreRenderService() != null || callback == null) {
            return;
        }
        callback.onError(-1, "poolservice = null");
    }

    private final Strategy getStrategy(String strategyString) {
        String str = strategyString;
        if (str == null || str.length() == 0) {
            return Strategy.OnlyPreCreate;
        }
        switch (strategyString.hashCode()) {
            case -2001951915:
                if (strategyString.equals("PreloadImmediately")) {
                    return Strategy.LoadUriRightNow;
                }
                break;
            case -1607411300:
                if (strategyString.equals("PreloadOnIdle")) {
                    return Strategy.LoadUriOnIdle;
                }
                break;
            case -1085510111:
                if (strategyString.equals("Default")) {
                    return Strategy.OnlyPreCreate;
                }
                break;
            case 1503977306:
                if (strategyString.equals("PreconnectSocket")) {
                    return Strategy.PreConnect;
                }
                break;
        }
        return Strategy.OnlyPreCreate;
    }

    private final boolean checkMemory(int memoryThreshold) {
        ContextProviderFactory contextProviderFactory = getContextProviderFactory();
        return getFreeMemory(contextProviderFactory != null ? (Context) contextProviderFactory.provideInstance(Context.class) : null) > ((long) memoryThreshold);
    }

    private final long getFreeMemory(Context context) {
        if (context == null) {
            return -1L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / PreloadV2Kt.M_MEM_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject makeResultJson(boolean result, int code, String message) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("message", message);
        jSONObject2.put("result", result);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("data", jSONObject2);
        return jSONObject;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
        super.release();
        if (!this.pendingPrerenderTaskList.isEmpty()) {
            for (MessageQueue.IdleHandler idleHandler : this.pendingPrerenderTaskList) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "===remove pendingPrerenderTask====", null, "XPreload", 2, null);
                Looper.myQueue().removeIdleHandler(idleHandler);
            }
            this.pendingPrerenderTaskList.clear();
        }
        if ((!this.cacheKeys.isEmpty()) && isJSBReleaseCacheEnable()) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "===remove cacheKeys and cache====", null, "XPreload", 2, null);
            IPreRenderService preRenderService = getPreRenderService();
            if (preRenderService != null) {
                preRenderService.clearCaches(CollectionsKt.toHashSet(this.cacheKeys));
            }
            this.cacheKeys.clear();
        }
    }
}
