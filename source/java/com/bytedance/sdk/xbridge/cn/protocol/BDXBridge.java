package com.bytedance.sdk.xbridge.cn.protocol;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.AbsBridgeLifecycleHandler;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.XBridgeMonitorReporter;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthMode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.optimize.RuntimeConfig;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator;
import com.bytedance.sdk.xbridge.cn.protocol.auth.XBridgeAuthManager;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.BaseBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.BridgeCallContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.RefType;
import com.bytedance.sdk.xbridge.cn.service.BridgeLoader;
import com.bytedance.sdk.xbridge.cn.utils.ThreadPool;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;

/* compiled from: BDXBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020\u001aJ\u001d\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010A¢\u0006\u0002\u0010BJ\u001a\u0010C\u001a\u0002092\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020-0EJ\u001e\u0010F\u001a\u0002092\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u00070/j\b\u0012\u0004\u0012\u00020\u0007`0J$\u0010H\u001a\u00020$2\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00010LH\u0016J\u001a\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0007H\u0016J\"\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007H\u0016J\u0016\u0010R\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010SH\u0016JG\u0010T\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010U2\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010V\u001a\u00028\u00002\u0006\u0010G\u001a\u00020N2\u0006\u0010W\u001a\u00020X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00010L¢\u0006\u0002\u0010ZJ$\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010-0E2\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000JH\u0002J\u0010\u0010\\\u001a\u0004\u0018\u00010-2\u0006\u0010]\u001a\u00020\u0007J\u0018\u0010^\u001a\u0004\u0018\u00010_2\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000JH\u0016J\"\u0010`\u001a\u0002092\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00010LJ\"\u0010a\u001a\u0002092\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00010LJ\b\u0010b\u001a\u00020$H\u0016J\u000e\u0010c\u001a\u0002092\u0006\u0010d\u001a\u00020\u0014J\b\u0010e\u001a\u000209H\u0002J\b\u0010f\u001a\u000209H&J$\u0010g\u001a\u0002092\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00010LH\u0002J'\u0010h\u001a\u000209\"\u0004\b\u0002\u0010i2\f\u0010j\u001a\b\u0012\u0004\u0012\u0002Hi0k2\u0006\u0010l\u001a\u0002Hi¢\u0006\u0002\u0010mJ/\u0010h\u001a\u000209\"\u0004\b\u0002\u0010i2\f\u0010j\u001a\b\u0012\u0004\u0012\u0002Hi0k2\u0006\u0010l\u001a\u0002Hi2\u0006\u0010n\u001a\u00020o¢\u0006\u0002\u0010pJ\u000e\u0010q\u001a\u0002092\u0006\u0010G\u001a\u00020NJ\u0006\u0010r\u001a\u000209J\u001a\u0010s\u001a\u0002092\u0012\u0010t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&J#\u0010u\u001a\u0002092\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010v\u001a\u00020wH\u0010¢\u0006\u0002\bxJ\u001a\u0010y\u001a\u000209\"\u0004\b\u0002\u0010i2\f\u0010j\u001a\b\u0012\u0004\u0012\u0002Hi0kJ\"\u0010z\u001a\u000209*\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010v\u001a\u00020w2\u0006\u0010G\u001a\u00020NH\u0002R\u001b\u0010\t\u001a\u00020\n8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00070/j\b\u0012\u0004\u0012\u00020\u0007`08BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u00107¨\u0006{"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/BDXBridge;", "INPUT", "OUTPUT", "Lcom/bytedance/sdk/xbridge/cn/service/BridgeLoader;", "context", "Landroid/content/Context;", "containerId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "authManager", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/XBridgeAuthManager;", "getAuthManager", "()Lcom/bytedance/sdk/xbridge/cn/protocol/auth/XBridgeAuthManager;", "authManager$delegate", "Lkotlin/Lazy;", "bridgeHandler", "Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "getBridgeHandler", "()Lcom/bytedance/sdk/xbridge/cn/protocol/BaseBridgeHandler;", "containerContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;", "getContainerId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "internalMethodFinder", "Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "getInternalMethodFinder", "()Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;", "internalMethodFinder$delegate", "methodFinders", "", "getMethodFinders", "()Ljava/util/List;", "methodFinders$delegate", "releaseStatus", "", "resultIntercept", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeResultIntercept;", "runtimeConfig", "Lcom/bytedance/sdk/xbridge/cn/optimize/RuntimeConfig;", "getRuntimeConfig", "()Lcom/bytedance/sdk/xbridge/cn/optimize/RuntimeConfig;", "settingsMap", "", "", "unSupportMethod", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUnSupportMethod", "()Ljava/util/HashSet;", "unSupportMethod$delegate", IWeixinService.ResponseConstants.URL, "getUrl", "setUrl", "(Ljava/lang/String;)V", "addAuthenticator", "", "authenticator", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/Authenticator;", "priority", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthPriority;", "addCustomMethodFinder", "finder", "index", "", "(Lcom/bytedance/sdk/xbridge/cn/protocol/MethodFinder;Ljava/lang/Integer;)V", "addSettings", "settings", "", "addUnSupportMethod", "method", "dealWithNamespace", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "callback", "Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "findMethod", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "bizId", "methodName", "sessionId", "getBridgeCallInterceptor", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeCallInterceptor;", "getInterceptorCallBack", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeInterceptorCallback;", "params", "callContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/BridgeCallContext;", "resultCallBack", "(Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;Ljava/lang/Object;Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;Lcom/bytedance/sdk/xbridge/cn/registry/core/BridgeCallContext;Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;)Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeInterceptorCallback;", "getParamsMap", "getSettings", "key", "getThreadType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "handleCall", "handleCallV2", "hasAsyncTask", "initialize", "bridgeContext", "internalRelease", "onRelease", "realHandleCall", "registerService", "T", "clazz", "Ljava/lang/Class;", "t", "(Ljava/lang/Class;Ljava/lang/Object;)V", "refType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/RefType;", "(Ljava/lang/Class;Ljava/lang/Object;Lcom/bytedance/sdk/xbridge/cn/registry/core/RefType;)V", "registerStatefulMethod", "release", "setBridgeResultIntercept", "intercept", "transmitJsbAuthResult", "authResult", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "transmitJsbAuthResult$anniex_release", "unRegisterService", "putAuthResult", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BDXBridge<INPUT, OUTPUT> implements BridgeLoader {

    /* renamed from: authManager$delegate, reason: from kotlin metadata */
    private final Lazy authManager;
    private BaseBDXBridgeContext containerContext;
    private final String containerId;
    private final Context context;

    /* renamed from: internalMethodFinder$delegate, reason: from kotlin metadata */
    private final Lazy internalMethodFinder;

    /* renamed from: methodFinders$delegate, reason: from kotlin metadata */
    private final Lazy methodFinders;
    private volatile boolean releaseStatus;
    private IBridgeResultIntercept<INPUT, OUTPUT> resultIntercept;
    private final RuntimeConfig runtimeConfig;
    private final Map<String, Object> settingsMap;

    /* renamed from: unSupportMethod$delegate, reason: from kotlin metadata */
    private final Lazy unSupportMethod;
    private String url;

    /* compiled from: BDXBridge.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IDLXBridgeMethod.XBridgeThreadType.values().length];
            try {
                iArr[IDLXBridgeMethod.XBridgeThreadType.SYNC_THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IDLXBridgeMethod.XBridgeThreadType.ASYNC_THREAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IDLXBridgeMethod.XBridgeThreadType.MAIN_THREAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IDLXBridgeMethod.XBridgeThreadType.MAIN_THREAD_OPT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean dealWithNamespace(BaseBridgeCall<INPUT> call, BridgeResultCallback<OUTPUT> callback) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return false;
    }

    public IBridgeCallInterceptor<INPUT, OUTPUT> getBridgeCallInterceptor() {
        return null;
    }

    /* renamed from: getBridgeHandler */
    public abstract BaseBridgeHandler<INPUT, OUTPUT> getBridgeHandler2();

    public IDLXBridgeMethod.XBridgeThreadType getThreadType(BaseBridgeCall<INPUT> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return null;
    }

    public boolean hasAsyncTask() {
        return false;
    }

    public abstract void onRelease();

    public void transmitJsbAuthResult$anniex_release(BaseBridgeCall<INPUT> call, AuthResult authResult) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(authResult, "authResult");
    }

    public BDXBridge(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "containerId");
        this.context = context;
        this.containerId = str;
        this.authManager = LazyKt.lazy(new Function0<XBridgeAuthManager>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$authManager$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final XBridgeAuthManager m905invoke() {
                return new XBridgeAuthManager();
            }
        });
        this.internalMethodFinder = LazyKt.lazy(new Function0<XBridge3MethodFinder>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$internalMethodFinder$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final XBridge3MethodFinder m907invoke() {
                return new XBridge3MethodFinder();
            }
        });
        this.methodFinders = LazyKt.lazy(new Function0<List<MethodFinder>>(this) { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$methodFinders$2
            final /* synthetic */ BDXBridge<INPUT, OUTPUT> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            public final List<MethodFinder> invoke() {
                MethodFinder internalMethodFinder;
                internalMethodFinder = this.this$0.getInternalMethodFinder();
                return CollectionsKt.mutableListOf(new MethodFinder[]{internalMethodFinder});
            }
        });
        this.settingsMap = new LinkedHashMap();
        this.unSupportMethod = LazyKt.lazy(new Function0<HashSet<String>>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$unSupportMethod$2
            public final HashSet<String> invoke() {
                return new HashSet<>();
            }
        });
        this.runtimeConfig = new RuntimeConfig();
    }

    public final String getContainerId() {
        return this.containerId;
    }

    public final Context getContext() {
        return this.context;
    }

    protected final XBridgeAuthManager getAuthManager() {
        return (XBridgeAuthManager) this.authManager.getValue();
    }

    protected final String getUrl() {
        return this.url;
    }

    protected final void setUrl(String str) {
        this.url = str;
    }

    public final MethodFinder getInternalMethodFinder() {
        return (MethodFinder) this.internalMethodFinder.getValue();
    }

    private final List<MethodFinder> getMethodFinders() {
        return (List) this.methodFinders.getValue();
    }

    private final HashSet<String> getUnSupportMethod() {
        return (HashSet) this.unSupportMethod.getValue();
    }

    public final RuntimeConfig getRuntimeConfig() {
        return this.runtimeConfig;
    }

    public final void registerStatefulMethod(IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        getInternalMethodFinder().registerStatefulMethod(method);
    }

    public final void addSettings(Map<String, ? extends Object> settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settingsMap.putAll(settings);
    }

    public final Object getSettings(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.settingsMap.get(key);
    }

    public final void addUnSupportMethod(HashSet<String> method) {
        Intrinsics.checkNotNullParameter(method, "method");
        getUnSupportMethod().addAll(method);
    }

    public final void handleCall(final BaseBridgeCall<INPUT> call, final BridgeResultCallback<OUTPUT> callback) {
        Object obj;
        UGLogger.Context context;
        int i;
        AuthResult doAuth;
        AuthResult authResult;
        boolean z;
        IBridgeResultIntercept<INPUT, OUTPUT> iBridgeResultIntercept;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseBDXBridgeContext baseBDXBridgeContext = this.containerContext;
        if (baseBDXBridgeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerContext");
            baseBDXBridgeContext = null;
        }
        final BridgeCallContext bridgeCallContext = new BridgeCallContext(baseBDXBridgeContext, call);
        callback.setContainerID$anniex_release(bridgeCallContext.getContainerID());
        if (dealWithNamespace(call, callback)) {
            return;
        }
        if (call.getNamespace().length() == 0) {
            BaseBDXBridgeContext baseBDXBridgeContext2 = this.containerContext;
            if (baseBDXBridgeContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerContext");
                baseBDXBridgeContext2 = null;
            }
            call.setNamespace(baseBDXBridgeContext2.getNamespace());
        }
        if (!call.getIsLatch() || Intrinsics.areEqual(this.settingsMap.get(OptimizeConfigKt.getLATCH_SKIP_BPEA()), false)) {
            AbsBridgeLifecycleHandler bridgeLifecycle = XBridge.INSTANCE.getConfig().getBridgeLifecycle();
            if (Intrinsics.areEqual(bridgeLifecycle != null ? Boolean.valueOf(bridgeLifecycle.onHandleStart(call, bridgeCallContext, callback)) : null, true)) {
                return;
            }
        }
        String methodName = call.getMethodName();
        final IDLXBridgeMethod findMethod = findMethod(call.getNamespace(), methodName, bridgeCallContext.getContainerID());
        final INPUT params = call.getParams();
        UGLogger.Context context2 = new UGLogger.Context();
        context2.pushStage(XBridgeInjectLogger.SESSION_ID, bridgeCallContext.getContainerID());
        context2.pushStage(XBridgeInjectLogger.CALL_ID, call.getId());
        if (findMethod == null) {
            i = 2;
            obj = "methodName";
            context = context2;
            UGLogger.INSTANCE.m162i(XBridgeInjectLogger.BULLET_SDK_TAG, "BDXBridge findMethod namespace: " + call.getNamespace() + " methodName: " + methodName + " instance: " + findMethod, XBridgeInjectLogger.BRIDGE_PREPARE, MapsKt.mapOf(new Pair[]{TuplesKt.to("methodName", methodName), TuplesKt.to("findMethod", false), TuplesKt.to(XBridgeInjectLogger.CALL_ID, call.getId())}), context);
        } else {
            obj = "methodName";
            context = context2;
            i = 2;
        }
        if (findMethod == null) {
            call.setAuthAllow(true);
            call.setAuthCode(AuthSuccessCode.METHOD_NOT_FOUND.getCode());
            call.setAuthMessage("JSB method not found, return early without JSB auth.");
            if (IConditionCallKt.enableBridgeReleaseCode() && this.releaseStatus) {
                callback.invoke(getBridgeHandler2().createErrorData(call, -12, "The JSBridge method is not found, and the container has been destroyed. Please check the timing of the call."));
                return;
            } else {
                callback.invoke(getBridgeHandler2().createErrorData(call, -2, "The JSBridge method is not found, please register"));
                return;
            }
        }
        call.setAuthStartTime(System.currentTimeMillis());
        if (call.getIsLatch() && Intrinsics.areEqual(this.settingsMap.get(OptimizeConfigKt.getLATCH_SKIP_AUTH()), true)) {
            doAuth = new AuthResult(true, false, null, null, null, false, 62, null);
        } else {
            doAuth = getAuthManager().doAuth(call, findMethod);
        }
        AuthResult authResult2 = doAuth;
        call.setAuthEndTime(System.currentTimeMillis());
        if (authResult2.getPassed()) {
            authResult = authResult2;
            z = false;
        } else {
            UGLogger uGLogger = UGLogger.INSTANCE;
            String str = "auth to call JsBridge method " + methodName;
            Pair[] pairArr = new Pair[i];
            z = false;
            pairArr[0] = TuplesKt.to("bridge auth", Boolean.valueOf(authResult2.getPassed()));
            pairArr[1] = TuplesKt.to(obj, methodName);
            authResult = authResult2;
            uGLogger.m162i(XBridgeInjectLogger.BULLET_SDK_TAG, str, XBridgeInjectLogger.BRIDGE_PREPARE, MapsKt.mapOf(pairArr), context);
        }
        putAuthResult(call, authResult, findMethod);
        call.getExtraMap().put(OptimizeConfigKt.getLOKI_JSB_LOG_DROP_SWITCH(), Boolean.valueOf(Intrinsics.areEqual(getSettings(OptimizeConfigKt.getLOKI_JSB_LOG_DROP_SWITCH()), true)));
        call.getExtraMap().put(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT(), Boolean.valueOf(Intrinsics.areEqual(getSettings(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT()), true)));
        if (!authResult.getPassed()) {
            callback.invoke(getBridgeHandler2().createErrorData(call, call.getCode(), call.getMessage()));
            return;
        }
        SecurityContextUtils securityContextUtils = SecurityContextUtils.INSTANCE;
        BaseBDXBridgeContext baseBDXBridgeContext3 = this.containerContext;
        if (baseBDXBridgeContext3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerContext");
            baseBDXBridgeContext3 = null;
        }
        securityContextUtils.registerSecurityContext(baseBDXBridgeContext3, call);
        if (this.runtimeConfig.getAllowUseCache()) {
            IBridgeResultIntercept<INPUT, OUTPUT> iBridgeResultIntercept2 = this.resultIntercept;
            if (((iBridgeResultIntercept2 == null || !iBridgeResultIntercept2.resultIntercept(bridgeCallContext)) ? z : true) && (iBridgeResultIntercept = this.resultIntercept) != null && iBridgeResultIntercept.invokeCache(call, bridgeCallContext, findMethod, callback)) {
                return;
            }
        }
        call.setThreadType(getThreadType(call));
        call.setBeforeMethodHandleStartTime(Long.valueOf(System.currentTimeMillis()));
        boolean canRunInBackground = findMethod.canRunInBackground();
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$handleCall$handleMethod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x009a A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #0 {all -> 0x00a8, blocks: (B:2:0x0000, B:4:0x0020, B:6:0x0029, B:10:0x0047, B:11:0x008e, B:13:0x009a, B:18:0x0078), top: B:1:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:17:0x00a6 A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke() {
                XBridgeMonitorReporter monitorReporter;
                Map<String, ? extends Object> paramsMap;
                try {
                    call.setMethodHandleStartTime(Long.valueOf(System.currentTimeMillis()));
                    bridgeCallContext.setCallId(call.getId());
                    if (this.getBridgeCallInterceptor() != null) {
                        IBridgeCallInterceptor bridgeCallInterceptor = this.getBridgeCallInterceptor();
                        boolean z2 = false;
                        if (bridgeCallInterceptor != null) {
                            Object obj2 = call;
                            BridgeCallContext bridgeCallContext2 = bridgeCallContext;
                            if (bridgeCallInterceptor.intercept(obj2, bridgeCallContext2, this.getInterceptorCallBack(obj2, params, findMethod, bridgeCallContext2, callback))) {
                                z2 = true;
                            }
                        }
                        if (z2) {
                            UGLogger uGLogger2 = UGLogger.INSTANCE;
                            paramsMap = this.getParamsMap(call);
                            UGLogger.Context context3 = new UGLogger.Context();
                            BridgeCallContext bridgeCallContext3 = bridgeCallContext;
                            BaseBridgeCall<INPUT> baseBridgeCall = call;
                            context3.pushStage(XBridgeInjectLogger.SESSION_ID, bridgeCallContext3.getContainerID());
                            context3.pushStage(XBridgeInjectLogger.CALL_ID, baseBridgeCall.getId());
                            Unit unit = Unit.INSTANCE;
                            uGLogger2.m162i(XBridgeInjectLogger.BULLET_SDK_TAG, "BDXBridge intercept by open", "BridgeProcessing", paramsMap, context3);
                            monitorReporter = XBridge.INSTANCE.getConfig().getMonitorReporter();
                            if (monitorReporter != null) {
                                return null;
                            }
                            monitorReporter.report(call, bridgeCallContext);
                            return Unit.INSTANCE;
                        }
                    }
                    this.getBridgeHandler2().handle(call, params, findMethod, bridgeCallContext, callback);
                    monitorReporter = XBridge.INSTANCE.getConfig().getMonitorReporter();
                    if (monitorReporter != null) {
                    }
                } catch (Throwable th) {
                    BridgeResultCallback<OUTPUT> bridgeResultCallback = callback;
                    BaseBridgeHandler bridgeHandler2 = this.getBridgeHandler2();
                    Object obj3 = call;
                    String message = th.getMessage();
                    if (message == null) {
                        message = "Exception thrown in method handle";
                    }
                    bridgeResultCallback.invoke(bridgeHandler2.createErrorData(obj3, -999, message));
                    return Unit.INSTANCE;
                }
            }
        };
        IDLXBridgeMethod.XBridgeThreadType threadType = call.getThreadType();
        int i2 = threadType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[threadType.ordinal()];
        if (i2 == 1) {
            return;
        }
        if (i2 == 2) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, ExecutorsKt.from(OptimizeConfigKt.m897getSerialThreadPool()), (CoroutineStart) null, new BDXBridge$handleCall$2(function0, null), 2, (Object) null);
            return;
        }
        if (i2 == 3) {
            if (ThreadPool.INSTANCE.isInMainThread()) {
                function0.invoke();
                return;
            } else {
                ThreadPool.INSTANCE.runInMain(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$handleCall$3
                    @Override // java.lang.Runnable
                    public final void run() {
                        function0.invoke();
                    }
                });
                return;
            }
        }
        if (i2 != 4) {
            if (!canRunInBackground) {
                ThreadPool.INSTANCE.runInMain(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$handleCall$5
                    @Override // java.lang.Runnable
                    public final void run() {
                        function0.invoke();
                    }
                });
                return;
            } else {
                function0.invoke();
                return;
            }
        }
        if (ThreadPool.INSTANCE.isInMainThread()) {
            function0.invoke();
        } else if (!canRunInBackground) {
            ThreadPool.INSTANCE.runInMain(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$handleCall$4
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
        } else {
            function0.invoke();
        }
    }

    public final void handleCallV2(final BaseBridgeCall<INPUT> call, final BridgeResultCallback<OUTPUT> callback) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callback, "callback");
        call.setThreadType(getThreadType(call));
        IDLXBridgeMethod.XBridgeThreadType threadType = call.getThreadType();
        int i = threadType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[threadType.ordinal()];
        if (i == 1) {
            realHandleCall(call, callback);
            return;
        }
        if (i == 2) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, ExecutorsKt.from(OptimizeConfigKt.m897getSerialThreadPool()), (CoroutineStart) null, new BDXBridge$handleCallV2$1(this, call, callback, null), 2, (Object) null);
            return;
        }
        if (i == 3) {
            if (ThreadPool.INSTANCE.isInMainThread()) {
                realHandleCall(call, callback);
                return;
            } else {
                ThreadPool.INSTANCE.runInMain(new Runnable(this) { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$handleCallV2$2
                    final /* synthetic */ BDXBridge<INPUT, OUTPUT> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.this$0.realHandleCall(call, callback);
                    }
                });
                return;
            }
        }
        if (Intrinsics.areEqual(getSettings(OptimizeConfigKt.getCAN_RUN_IN_BACKGROUND_FIX()), false)) {
            ThreadPool.INSTANCE.runInMain(new Runnable(this) { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$handleCallV2$3
                final /* synthetic */ BDXBridge<INPUT, OUTPUT> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.realHandleCall(call, callback);
                }
            });
        } else {
            realHandleCall(call, callback);
        }
    }

    public final void realHandleCall(final BaseBridgeCall<INPUT> call, final BridgeResultCallback<OUTPUT> callback) {
        Boolean bool;
        Object obj;
        UGLogger.Context context;
        int i;
        AuthResult doAuth;
        INPUT input;
        IBridgeResultIntercept<INPUT, OUTPUT> iBridgeResultIntercept;
        BaseBDXBridgeContext baseBDXBridgeContext = this.containerContext;
        if (baseBDXBridgeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerContext");
            baseBDXBridgeContext = null;
        }
        final BridgeCallContext bridgeCallContext = new BridgeCallContext(baseBDXBridgeContext, call);
        callback.setContainerID$anniex_release(bridgeCallContext.getContainerID());
        if (dealWithNamespace(call, callback)) {
            return;
        }
        if (call.getNamespace().length() == 0) {
            BaseBDXBridgeContext baseBDXBridgeContext2 = this.containerContext;
            if (baseBDXBridgeContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerContext");
                baseBDXBridgeContext2 = null;
            }
            call.setNamespace(baseBDXBridgeContext2.getNamespace());
        }
        if (!call.getIsLatch() || Intrinsics.areEqual(this.settingsMap.get(OptimizeConfigKt.getLATCH_SKIP_BPEA()), false)) {
            AbsBridgeLifecycleHandler bridgeLifecycle = XBridge.INSTANCE.getConfig().getBridgeLifecycle();
            if (bridgeLifecycle != null) {
                Intrinsics.checkNotNull(call, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback<kotlin.Any>");
                bool = Boolean.valueOf(bridgeLifecycle.onHandleStart(call, bridgeCallContext, callback));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, true)) {
                return;
            }
        }
        String methodName = call.getMethodName();
        final IDLXBridgeMethod findMethod = findMethod(call.getNamespace(), methodName, bridgeCallContext.getContainerID());
        INPUT params = call.getParams();
        UGLogger.Context context2 = new UGLogger.Context();
        context2.pushStage(XBridgeInjectLogger.SESSION_ID, bridgeCallContext.getContainerID());
        context2.pushStage(XBridgeInjectLogger.CALL_ID, call.getId());
        if (findMethod == null) {
            obj = "methodName";
            i = 2;
            context = context2;
            UGLogger.INSTANCE.m162i(XBridgeInjectLogger.BULLET_SDK_TAG, "BDXBridge findMethod namespace: " + call.getNamespace() + " methodName: " + methodName + " instance: " + findMethod, XBridgeInjectLogger.BRIDGE_PREPARE, MapsKt.mapOf(new Pair[]{TuplesKt.to("methodName", methodName), TuplesKt.to("findMethod", false), TuplesKt.to(XBridgeInjectLogger.CALL_ID, call.getId())}), context);
        } else {
            obj = "methodName";
            context = context2;
            i = 2;
        }
        if (findMethod == null) {
            call.setAuthAllow(true);
            call.setAuthCode(AuthSuccessCode.METHOD_NOT_FOUND.getCode());
            call.setAuthMessage("JSB method not found, return early without JSB auth.");
            if (IConditionCallKt.enableBridgeReleaseCode() && this.releaseStatus) {
                callback.invoke(getBridgeHandler2().createErrorData(call, -12, "The JSBridge method is not found, and the container has been destroyed. Please check the timing of the call."));
                return;
            } else {
                callback.invoke(getBridgeHandler2().createErrorData(call, -2, "The JSBridge method is not found, please register"));
                return;
            }
        }
        call.setAuthStartTime(System.currentTimeMillis());
        if (call.getIsLatch() && Intrinsics.areEqual(this.settingsMap.get(OptimizeConfigKt.getLATCH_SKIP_AUTH()), true)) {
            doAuth = new AuthResult(true, false, null, null, null, false, 62, null);
        } else {
            doAuth = getAuthManager().doAuth(call, findMethod);
        }
        transmitJsbAuthResult$anniex_release(call, doAuth);
        call.setAuthEndTime(System.currentTimeMillis());
        if (doAuth.getPassed()) {
            input = params;
        } else {
            Pair[] pairArr = new Pair[i];
            input = params;
            pairArr[0] = TuplesKt.to("bridge auth", Boolean.valueOf(doAuth.getPassed()));
            pairArr[1] = TuplesKt.to(obj, methodName);
            UGLogger.INSTANCE.m162i(XBridgeInjectLogger.BULLET_SDK_TAG, "auth to call JsBridge method " + methodName, XBridgeInjectLogger.BRIDGE_PREPARE, MapsKt.mapOf(pairArr), context);
        }
        putAuthResult(call, doAuth, findMethod);
        call.getExtraMap().put(OptimizeConfigKt.getLOKI_JSB_LOG_DROP_SWITCH(), Boolean.valueOf(Intrinsics.areEqual(getSettings(OptimizeConfigKt.getLOKI_JSB_LOG_DROP_SWITCH()), true)));
        call.getExtraMap().put(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT(), Boolean.valueOf(Intrinsics.areEqual(getSettings(OptimizeConfigKt.getXBRIDGE_MODEL_PROXY_ENHANCEMENT()), true)));
        if (!doAuth.getPassed()) {
            callback.invoke(getBridgeHandler2().createErrorData(call, call.getCode(), call.getMessage()));
            return;
        }
        if (this.runtimeConfig.getAllowUseCache()) {
            IBridgeResultIntercept<INPUT, OUTPUT> iBridgeResultIntercept2 = this.resultIntercept;
            if ((iBridgeResultIntercept2 != null && iBridgeResultIntercept2.resultIntercept(bridgeCallContext)) && (iBridgeResultIntercept = this.resultIntercept) != null && iBridgeResultIntercept.invokeCache(call, bridgeCallContext, findMethod, callback)) {
                return;
            }
        }
        SecurityContextUtils securityContextUtils = SecurityContextUtils.INSTANCE;
        BaseBDXBridgeContext baseBDXBridgeContext3 = this.containerContext;
        if (baseBDXBridgeContext3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerContext");
            baseBDXBridgeContext3 = null;
        }
        securityContextUtils.registerSecurityContext(baseBDXBridgeContext3, call);
        call.setThreadType(getThreadType(call));
        call.setBeforeMethodHandleStartTime(Long.valueOf(System.currentTimeMillis()));
        boolean canRunInBackground = findMethod.canRunInBackground();
        final INPUT input2 = input;
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$realHandleCall$handleMethod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x009a A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #0 {all -> 0x00a8, blocks: (B:2:0x0000, B:4:0x0020, B:6:0x0029, B:10:0x0047, B:11:0x008e, B:13:0x009a, B:18:0x0078), top: B:1:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:17:0x00a6 A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke() {
                XBridgeMonitorReporter monitorReporter;
                Map<String, ? extends Object> paramsMap;
                try {
                    call.setMethodHandleStartTime(Long.valueOf(System.currentTimeMillis()));
                    bridgeCallContext.setCallId(call.getId());
                    if (this.getBridgeCallInterceptor() != null) {
                        IBridgeCallInterceptor bridgeCallInterceptor = this.getBridgeCallInterceptor();
                        boolean z = false;
                        if (bridgeCallInterceptor != null) {
                            Object obj2 = call;
                            BridgeCallContext bridgeCallContext2 = bridgeCallContext;
                            if (bridgeCallInterceptor.intercept(obj2, bridgeCallContext2, this.getInterceptorCallBack(obj2, input2, findMethod, bridgeCallContext2, callback))) {
                                z = true;
                            }
                        }
                        if (z) {
                            UGLogger uGLogger = UGLogger.INSTANCE;
                            paramsMap = this.getParamsMap(call);
                            UGLogger.Context context3 = new UGLogger.Context();
                            BridgeCallContext bridgeCallContext3 = bridgeCallContext;
                            BaseBridgeCall<INPUT> baseBridgeCall = call;
                            context3.pushStage(XBridgeInjectLogger.SESSION_ID, bridgeCallContext3.getContainerID());
                            context3.pushStage(XBridgeInjectLogger.CALL_ID, baseBridgeCall.getId());
                            Unit unit = Unit.INSTANCE;
                            uGLogger.m162i(XBridgeInjectLogger.BULLET_SDK_TAG, "BDXBridge intercept by open", "BridgeProcessing", paramsMap, context3);
                            monitorReporter = XBridge.INSTANCE.getConfig().getMonitorReporter();
                            if (monitorReporter != null) {
                                return null;
                            }
                            monitorReporter.report(call, bridgeCallContext);
                            return Unit.INSTANCE;
                        }
                    }
                    this.getBridgeHandler2().handle(call, input2, findMethod, bridgeCallContext, callback);
                    monitorReporter = XBridge.INSTANCE.getConfig().getMonitorReporter();
                    if (monitorReporter != null) {
                    }
                } catch (Throwable th) {
                    BridgeResultCallback<OUTPUT> bridgeResultCallback = callback;
                    BaseBridgeHandler bridgeHandler2 = this.getBridgeHandler2();
                    Object obj3 = call;
                    String message = th.getMessage();
                    if (message == null) {
                        message = "Exception thrown in method handle";
                    }
                    bridgeResultCallback.invoke(bridgeHandler2.createErrorData(obj3, -999, message));
                    return Unit.INSTANCE;
                }
            }
        };
        if (Intrinsics.areEqual(getSettings(OptimizeConfigKt.getCAN_RUN_IN_BACKGROUND_FIX()), false) || call.getThreadType() != null) {
            function0.invoke();
        } else if (!canRunInBackground) {
            ThreadPool.INSTANCE.runInMain(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$realHandleCall$2
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
        } else {
            function0.invoke();
        }
    }

    public final Map<String, Object> getParamsMap(BaseBridgeCall<INPUT> call) {
        if (XBridge.INSTANCE.getConfig().getDebuggable()) {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("methodName", call.getMethodName()), TuplesKt.to(IWeixinService.ResponseConstants.URL, call.getUrl()), TuplesKt.to("params", call.convertParamsToJSONObject().toString())});
        }
        return MapsKt.mapOf(TuplesKt.to("methodName", call.getMethodName()));
    }

    public static /* synthetic */ void addAuthenticator$default(BDXBridge bDXBridge, Authenticator authenticator, AuthPriority authPriority, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addAuthenticator");
        }
        if ((i & 2) != 0) {
            authPriority = AuthPriority.LOW;
        }
        bDXBridge.addAuthenticator(authenticator, authPriority);
    }

    public final void addAuthenticator(Authenticator authenticator, AuthPriority priority) {
        Intrinsics.checkNotNullParameter(authenticator, "authenticator");
        Intrinsics.checkNotNullParameter(priority, "priority");
        getAuthManager().addAuthenticator(authenticator, priority);
    }

    public final void initialize(BaseBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        this.containerContext = bridgeContext;
        bridgeContext.registerService(BridgeLoader.class, this);
    }

    public final <T> void registerService(Class<T> clazz, T t) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        BaseBDXBridgeContext baseBDXBridgeContext = this.containerContext;
        if (baseBDXBridgeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerContext");
            baseBDXBridgeContext = null;
        }
        baseBDXBridgeContext.registerService(clazz, t);
    }

    public final <T> void registerService(Class<T> clazz, T t, RefType refType) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(refType, "refType");
        BaseBDXBridgeContext baseBDXBridgeContext = this.containerContext;
        if (baseBDXBridgeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerContext");
            baseBDXBridgeContext = null;
        }
        baseBDXBridgeContext.registerService(clazz, t, refType);
    }

    public final <T> void unRegisterService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        BaseBDXBridgeContext baseBDXBridgeContext = this.containerContext;
        if (baseBDXBridgeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerContext");
            baseBDXBridgeContext = null;
        }
        baseBDXBridgeContext.unRegisterService(clazz);
    }

    public final void addCustomMethodFinder(MethodFinder finder) {
        Intrinsics.checkNotNullParameter(finder, "finder");
        getMethodFinders().add(finder);
    }

    public final void addCustomMethodFinder(MethodFinder finder, Integer index) {
        Intrinsics.checkNotNullParameter(finder, "finder");
        if (index == null) {
            addCustomMethodFinder(finder);
        } else {
            getMethodFinders().add(index.intValue(), finder);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.service.BridgeLoader
    public IDLXBridgeMethod findMethod(String bizId, String methodName) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        IDLXBridgeMethod iDLXBridgeMethod = StatelessMethodRepository.INSTANCE.get(bizId, methodName);
        if (iDLXBridgeMethod != null) {
            return iDLXBridgeMethod;
        }
        Iterator<MethodFinder> it = getMethodFinders().iterator();
        while (it.hasNext()) {
            IDLXBridgeMethod findMethod = it.next().findMethod(bizId, methodName);
            if (findMethod != null) {
                return findMethod;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.service.BridgeLoader
    public IDLXBridgeMethod findMethod(String bizId, String methodName, String sessionId) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (getUnSupportMethod().contains(methodName)) {
            return null;
        }
        IDLXBridgeMethod iDLXBridgeMethod = StatelessMethodRepository.INSTANCE.get(bizId, methodName);
        if (iDLXBridgeMethod != null) {
            return iDLXBridgeMethod;
        }
        Iterator<MethodFinder> it = getMethodFinders().iterator();
        while (it.hasNext()) {
            IDLXBridgeMethod findMethod = it.next().findMethod(bizId, methodName);
            if (findMethod != null) {
                return findMethod;
            }
        }
        return null;
    }

    public final void release() {
        if (hasAsyncTask()) {
            synchronized (this) {
                internalRelease();
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        internalRelease();
    }

    private final void internalRelease() {
        Iterator<T> it = getMethodFinders().iterator();
        while (it.hasNext()) {
            ((MethodFinder) it.next()).release();
        }
        BaseBDXBridgeContext baseBDXBridgeContext = this.containerContext;
        if (baseBDXBridgeContext != null) {
            if (baseBDXBridgeContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerContext");
                baseBDXBridgeContext = null;
            }
            baseBDXBridgeContext.release();
        }
        onRelease();
        this.releaseStatus = true;
    }

    public final void setBridgeResultIntercept(IBridgeResultIntercept<INPUT, OUTPUT> intercept) {
        Intrinsics.checkNotNullParameter(intercept, "intercept");
        this.resultIntercept = intercept;
    }

    public final IBridgeInterceptorCallback<OUTPUT> getInterceptorCallBack(final BaseBridgeCall<INPUT> call, final INPUT params, final IDLXBridgeMethod method, final BridgeCallContext callContext, final BridgeResultCallback<OUTPUT> resultCallBack) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(resultCallBack, "resultCallBack");
        return new IBridgeInterceptorCallback<OUTPUT>() { // from class: com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$getInterceptorCallBack$1
            @Override // com.bytedance.sdk.xbridge.cn.protocol.IBridgeInterceptorCallback
            public void invokeJsCallback(OUTPUT data) {
                resultCallBack.invoke(data);
            }

            @Override // com.bytedance.sdk.xbridge.cn.protocol.IBridgeInterceptorCallback
            public void invokeOrigin() {
                this.getBridgeHandler2().handle(call, params, method, callContext, resultCallBack);
            }
        };
    }

    private final void putAuthResult(BaseBridgeCall<INPUT> baseBridgeCall, AuthResult authResult, IDLXBridgeMethod iDLXBridgeMethod) {
        String value;
        String str;
        String value2;
        baseBridgeCall.setAuthAllow(authResult.getPassed());
        AuthErrorCode errorCode = authResult.getErrorCode();
        if (errorCode == null) {
            errorCode = AuthErrorCode.UN_KNOWN;
        }
        baseBridgeCall.setAuthErrorCode(errorCode);
        baseBridgeCall.setPackageVersion(authResult.getPackageVersion());
        baseBridgeCall.setAuthUrl(authResult.getAuthUrl());
        baseBridgeCall.setAuthCode(authResult.getAuthCode());
        String authFeId = authResult.getAuthFeId();
        if (authFeId == null) {
            authFeId = "0";
        }
        baseBridgeCall.setAuthFeId(authFeId);
        String authFeIdMapper = authResult.getAuthFeIdMapper();
        if (authFeIdMapper == null) {
            authFeIdMapper = "0";
        }
        baseBridgeCall.setAuthFeIdMapper(authFeIdMapper);
        AuthBridgeAccess methodAuthType = authResult.getMethodAuthType();
        if (methodAuthType == null || (value = methodAuthType.getValue()) == null) {
            value = iDLXBridgeMethod.getAccess().getValue();
        }
        baseBridgeCall.setMethodAuthType(value);
        AuthMode authMode = authResult.getAuthMode();
        String str2 = "unset";
        if (authMode == null || (str = authMode.getDesc()) == null) {
            str = "unset";
        }
        baseBridgeCall.setAuthMode(str);
        baseBridgeCall.setFeAuthConfigSource(authResult.getFeAuthConfigSource().getCode());
        String lynxTasmFeId = authResult.getLynxTasmFeId();
        baseBridgeCall.setLynxTasmFeId(lynxTasmFeId != null ? lynxTasmFeId : "0");
        AuthBridgeAccess feAuthGroup = authResult.getFeAuthGroup();
        if (feAuthGroup != null && (value2 = feAuthGroup.getValue()) != null) {
            str2 = value2;
        }
        baseBridgeCall.setFeGroupAuthType(str2);
        baseBridgeCall.setRequestTrackings(authResult.getRequestTrackings());
        baseBridgeCall.setNeedReportAuth(authResult.getNeedReport());
    }
}
