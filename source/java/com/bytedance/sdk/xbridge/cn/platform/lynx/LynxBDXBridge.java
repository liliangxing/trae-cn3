package com.bytedance.sdk.xbridge.cn.platform.lynx;

import android.content.Context;
import com.bytedance.ies.argus.api.ArgusLynxDelegate;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.ArgusLynxAuthenticator;
import com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt;
import com.bytedance.sdk.xbridge.cn.optimize.ThreadOptConfig;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.BaseBridgeHandler;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeCallInterceptor;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeInterceptorCallback;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxBDXBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rB\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u0018\u0010/\u001a\u00020\u001a2\u0010\u00100\u001a\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001bJ$\u00101\u001a\u00020\u001d2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000305H\u0016J\r\u00106\u001a\u00020\u001aH\u0000¢\u0006\u0002\b7J\u0016\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u000109H\u0016J\u0018\u0010:\u001a\u0004\u0018\u00010;2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000203H\u0016J\b\u0010<\u001a\u00020\u001dH\u0016J\u000e\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020?J\u0016\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010B\u001a\u00020\u001aH\u0016J(\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\n2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010FH\u0016J\u000e\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020IJ\u001e\u0010J\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)J\u000e\u0010L\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010M\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001dJ\u000e\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020PR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`\u001b\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010'R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\n0,j\b\u0012\u0004\u0012\u00020\n`-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "Lcom/bytedance/sdk/xbridge/cn/protocol/BDXBridge;", "Lcom/lynx/react/bridge/ReadableMap;", "", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "optConfig", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeOptConfig;", "context", "Landroid/content/Context;", "containerID", "", "(Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeOptConfig;Landroid/content/Context;Ljava/lang/String;)V", LynxBridgeCall.NAME_SPACE, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/content/Context;Ljava/lang/String;)V", "bridgeHandler", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/ReadableMapBridgeHandler;", "getBridgeHandler", "()Lcom/bytedance/sdk/xbridge/cn/platform/lynx/ReadableMapBridgeHandler;", "bridgeHandler$delegate", "Lkotlin/Lazy;", "getContainerID", "()Ljava/lang/String;", "delayExecuteBlockList", "", "Lkotlin/Function0;", "", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeDelayExecuteBlock;", "isThreadOptEnable", "", "Ljava/lang/Boolean;", "lynxBridgeContext", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeContext;", "getLynxBridgeContext", "()Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeContext;", "setLynxBridgeContext", "(Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBridgeContext;)V", "getNamespace", "setNamespace", "(Ljava/lang/String;)V", "threadOptConfig", "", "Lcom/bytedance/sdk/xbridge/cn/optimize/ThreadOptConfig;", "unSupportNamespaceSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "usePiperData", "addDelayExecuteBlock", "block", "dealWithNamespace", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "callback", "Lcom/bytedance/sdk/xbridge/cn/protocol/BridgeResultCallback;", "executeDelayInitBlock", "executeDelayInitBlock$anniex_release", "getBridgeCallInterceptor", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeCallInterceptor;", "getThreadType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "hasAsyncTask", "init", "lynxView", "Lcom/lynx/tasm/LynxView;", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "onRelease", "sendJSEvent", "eventName", "params", "", "setAuthDelegate", "delegate", "Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;", "setThreadOpt", "config", "setUnSupportNamespace", "setUsePiperData", "setup", "lynxViewBuilder", "Lcom/lynx/tasm/LynxViewBuilder;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LynxBDXBridge extends BDXBridge<ReadableMap, Object> implements JSEventDelegate {

    /* renamed from: bridgeHandler$delegate, reason: from kotlin metadata */
    private final Lazy bridgeHandler;
    private final String containerID;
    private volatile List<Function0<Unit>> delayExecuteBlockList;
    private Boolean isThreadOptEnable;
    public LynxBridgeContext lynxBridgeContext;
    private String namespace;
    private LynxBridgeOptConfig optConfig;
    private List<ThreadOptConfig> threadOptConfig;
    private HashSet<String> unSupportNamespaceSet;
    private boolean usePiperData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LynxBDXBridge(Context context, String str) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "containerID");
        this.containerID = str;
        this.namespace = "";
        this.bridgeHandler = LazyKt.lazy(new Function0<ReadableMapBridgeHandler>() { // from class: com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge$bridgeHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ReadableMapBridgeHandler m900invoke() {
                return new ReadableMapBridgeHandler();
            }
        });
        this.unSupportNamespaceSet = new HashSet<>();
        this.isThreadOptEnable = false;
    }

    public final String getContainerID() {
        return this.containerID;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LynxBDXBridge(LynxBridgeOptConfig lynxBridgeOptConfig, Context context, String str) {
        this(context, str);
        Intrinsics.checkNotNullParameter(lynxBridgeOptConfig, "optConfig");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "containerID");
        this.optConfig = lynxBridgeOptConfig;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final void setNamespace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.namespace = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LynxBDXBridge(Context context, String str, String str2) {
        this(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "containerID");
        Intrinsics.checkNotNullParameter(str2, LynxBridgeCall.NAME_SPACE);
        this.namespace = str2;
    }

    public /* synthetic */ LynxBDXBridge(Context context, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? "" : str2);
    }

    public final void setAuthDelegate(ArgusLynxDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        BDXBridge.addAuthenticator$default(this, new ArgusLynxAuthenticator(delegate), null, 2, null);
    }

    public final LynxBridgeContext getLynxBridgeContext() {
        LynxBridgeContext lynxBridgeContext = this.lynxBridgeContext;
        if (lynxBridgeContext != null) {
            return lynxBridgeContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeContext");
        return null;
    }

    public final void setLynxBridgeContext(LynxBridgeContext lynxBridgeContext) {
        Intrinsics.checkNotNullParameter(lynxBridgeContext, "<set-?>");
        this.lynxBridgeContext = lynxBridgeContext;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    /* renamed from: getBridgeHandler */
    public BaseBridgeHandler<ReadableMap, Object> getBridgeHandler2() {
        return (ReadableMapBridgeHandler) this.bridgeHandler.getValue();
    }

    public final void addDelayExecuteBlock(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.delayExecuteBlockList == null) {
            this.delayExecuteBlockList = new ArrayList();
        }
        List<Function0<Unit>> list = this.delayExecuteBlockList;
        if (list != null) {
            list.add(block);
        }
    }

    public final void executeDelayInitBlock$anniex_release() {
        synchronized (this) {
            List<Function0<Unit>> list = this.delayExecuteBlockList;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                list.clear();
                this.delayExecuteBlockList = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void setUnSupportNamespace(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, LynxBridgeCall.NAME_SPACE);
        this.unSupportNamespaceSet.add(namespace);
    }

    public final void setThreadOpt(boolean isThreadOptEnable, List<ThreadOptConfig> config) {
        this.isThreadOptEnable = Boolean.valueOf(isThreadOptEnable);
        this.threadOptConfig = config;
    }

    public final boolean isThreadOptEnable() {
        Boolean bool = this.isThreadOptEnable;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public IDLXBridgeMethod.XBridgeThreadType getThreadType(BaseBridgeCall<ReadableMap> call) {
        List<ThreadOptConfig> list;
        Intrinsics.checkNotNullParameter(call, "call");
        if (Intrinsics.areEqual(this.isThreadOptEnable, false) || (list = this.threadOptConfig) == null) {
            return null;
        }
        return OptimizeConfigKt.getThreadOptType(list, call);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.sdk.xbridge.cn.platform.lynx.ReadableMapBridgeHandler] */
    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public boolean dealWithNamespace(BaseBridgeCall<ReadableMap> call, BridgeResultCallback<Object> callback) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getBridgeHandler2().setNamespace(call.getNamespace());
        if (!this.unSupportNamespaceSet.contains(call.getNamespace())) {
            return false;
        }
        callback.invoke(getBridgeHandler2().createErrorData(call, -4, "Namespace " + this.namespace + " unknown."));
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.service.JSEventDelegate
    public void sendJSEvent(String eventName, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", params != null ? new JSONObject(params) : new JSONObject());
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        javaOnlyArray.pushMap(LynxConvertUtils.INSTANCE.jsonToReact(jSONObject));
        getLynxBridgeContext().sendGlobalEvent(eventName, javaOnlyArray);
    }

    public final void setup(LynxViewBuilder lynxViewBuilder) {
        Intrinsics.checkNotNullParameter(lynxViewBuilder, "lynxViewBuilder");
        lynxViewBuilder.registerModule(XBridgeLynxModule.NAME, XBridgeLynxModule.class, this);
    }

    public final void init(LynxView lynxView) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        setLynxBridgeContext(new LynxBridgeContext(this.containerID, lynxView, this, this.namespace, null, 16, null));
        super.initialize(getLynxBridgeContext());
    }

    public final void init(LynxView lynxView, PlatformType platformType) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        setLynxBridgeContext(new LynxBridgeContext(this.containerID, lynxView, this, this.namespace, platformType));
        super.initialize(getLynxBridgeContext());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.sdk.xbridge.cn.platform.lynx.LynxPlatformDataProcessor] */
    public final void setUsePiperData(boolean usePiperData) {
        this.usePiperData = usePiperData;
        getBridgeHandler2().getProcessor2().setUsePiperData(usePiperData);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public void onRelease() {
        if (this.lynxBridgeContext != null) {
            getLynxBridgeContext().release();
        }
        List<Function0<Unit>> list = this.delayExecuteBlockList;
        if (list != null) {
            list.clear();
        }
        this.delayExecuteBlockList = null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public boolean hasAsyncTask() {
        return this.delayExecuteBlockList != null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public IBridgeCallInterceptor<ReadableMap, Object> getBridgeCallInterceptor() {
        return new IBridgeCallInterceptor<ReadableMap, Object>() { // from class: com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge$getBridgeCallInterceptor$1
            @Override // com.bytedance.sdk.xbridge.cn.protocol.IBridgeCallInterceptor
            public boolean intercept(BaseBridgeCall<ReadableMap> call, IBDXBridgeContext bridgeContext, IBridgeInterceptorCallback<Object> callBack) {
                boolean z;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
                z = LynxBDXBridge.this.usePiperData;
                call.setUsePiperData(z);
                IBridgeCallInterceptor<Object, Object> callInterceptor = XBridge.INSTANCE.getConfig().getCallInterceptor();
                if (callInterceptor == null) {
                    return false;
                }
                Intrinsics.checkNotNull(callBack, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.IBridgeInterceptorCallback<kotlin.Any>");
                return callInterceptor.intercept(call, bridgeContext, callBack);
            }
        };
    }
}
