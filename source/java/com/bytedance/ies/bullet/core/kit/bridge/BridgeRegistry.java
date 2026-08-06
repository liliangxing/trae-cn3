package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope;
import com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.model.pipeline.IProcessor;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import java.util.ArrayList;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: BridgeRegistry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 N2\u00020\u0001:\u0001NB[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\bj\u0002`\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0010¢\u0006\u0002\u0010\u0011J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\nH\u0016J\u0012\u00106\u001a\u0004\u0018\u00010\n2\u0006\u00107\u001a\u00020\u0014H\u0016J4\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u001d0\bH\u0016J:\u00108\u001a\u00020\u001d2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u001d0\bH\u0016J\u0006\u0010A\u001a\u00020*J\b\u0010+\u001a\u00020*H\u0016J\b\u0010B\u001a\u00020\u001dH\u0002J(\u0010C\u001a\u00020\u001d2\u001e\u0010D\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0EH\u0016J\"\u0010F\u001a\u00020\u001d2\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0EH\u0016J\u0018\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u00012\u0006\u0010I\u001a\u00020*H\u0016J\u0018\u0010J\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u00012\u0006\u0010I\u001a\u00020*H\u0002J\b\u0010K\u001a\u00020\u001dH\u0016J\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0002J \u0010M\u001a\u00020\u001d2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0\bj\u0002`\u001eH\u0016R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\bj\u0004\u0018\u0001`\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\bj\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020-0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020-0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010$R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\u0004\u0018\u0001`\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006O"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeRegistry;", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "scopeProviderFactories", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScopeProviderFactory;", "bridgeProvider", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeProvider;", "contextProviderFactory", "transformer", "Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeHandleUnit;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeRegistryTransformer;", "(Lcom/bytedance/ies/bullet/core/BulletContext;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;)V", "bridgeMap", "", "", "bridgeMergeOps", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMergeOperation;", "getBridgeMergeOps", "()Ljava/util/List;", "bridgeMergeOps$delegate", "Lkotlin/Lazy;", "bridgePreInvokeHandler", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePreInvokeHandler;", "getBridgeProvider", "()Lkotlin/jvm/functions/Function1;", "bridges", "", "getBridges", "()Ljava/util/Map;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "hasBridgesInit", "", "hasReleased", "scopeMap", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScope;", "scopes", "getScopes", "getTransformer", "()Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;", "setTransformer", "(Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;)V", "addBridge", "bridge", "getBridgeInstance", "func", "handle", "funcName", "params", "", "callback", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "reject", "", "scopeNames", "hasBridgeInitialized", "initBridges", "iterate", "handler", "Lkotlin/Function2;", "iterateWithFuncName", "merge", "otherRegistry", "useOthersOnConflict", "mergeOtherBridge", "release", "selectBridgeNames", "setBridgePreInvokeHandler", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BridgeRegistry implements IBridgeRegistry {
    public static final String MODULE = "BridgeRegistry";
    public static final String SCOPE_NAME_SEPERATOR = "/";
    private final Map<String, IGenericBridgeMethod> bridgeMap;

    /* renamed from: bridgeMergeOps$delegate, reason: from kotlin metadata */
    private final Lazy bridgeMergeOps;
    private Function1<? super IGenericBridgeMethod, Unit> bridgePreInvokeHandler;
    private final Function1<ContextProviderFactory, List<IGenericBridgeMethod>> bridgeProvider;
    private final BulletContext bulletContext;
    private final ContextProviderFactory contextProviderFactory;
    private boolean hasBridgesInit;
    private boolean hasReleased;
    private final Map<String, IBridgeScope> scopeMap;
    private IProcessor<BridgeHandleUnit> transformer;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<String, List<String>> SCOPE_SPLITER = new Function1<String, List<? extends String>>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry$Companion$SCOPE_SPLITER$1
        public final List<String> invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            return StringsKt.split$default(str, new String[]{"/"}, false, 0, 6, (Object) null);
        }
    };
    private static final Function1<List<String>, String> SCOPE_JOINER = new Function1<List<? extends String>, String>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry$Companion$SCOPE_JOINER$1
        public final String invoke(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "it");
            return CollectionsKt.joinToString$default(list, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public BridgeRegistry(BulletContext bulletContext, List<? extends IBridgeScopeProviderFactory> list, Function1<? super ContextProviderFactory, ? extends List<? extends IGenericBridgeMethod>> function1, ContextProviderFactory contextProviderFactory, IProcessor<BridgeHandleUnit> iProcessor) {
        Intrinsics.checkNotNullParameter(list, "scopeProviderFactories");
        Intrinsics.checkNotNullParameter(function1, "bridgeProvider");
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        this.bulletContext = bulletContext;
        this.bridgeProvider = function1;
        this.contextProviderFactory = contextProviderFactory;
        this.transformer = iProcessor;
        this.scopeMap = new LinkedHashMap();
        this.bridgeMap = new LinkedHashMap();
        this.bridgeMergeOps = LazyKt.lazy(new Function0<List<BridgeMergeOperation>>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry$bridgeMergeOps$2
            public final List<BridgeMergeOperation> invoke() {
                return new ArrayList();
            }
        });
        for (IBridgeScopeProviderFactory iBridgeScopeProviderFactory : list) {
            this.scopeMap.put(iBridgeScopeProviderFactory.getName(), BridgeScope.INSTANCE.newInstance(iBridgeScopeProviderFactory, this.contextProviderFactory));
        }
    }

    public /* synthetic */ BridgeRegistry(BulletContext bulletContext, List list, Function1 function1, ContextProviderFactory contextProviderFactory, IProcessor iProcessor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bulletContext, list, function1, contextProviderFactory, iProcessor);
    }

    public final BulletContext getBulletContext() {
        return this.bulletContext;
    }

    public final Function1<ContextProviderFactory, List<IGenericBridgeMethod>> getBridgeProvider() {
        return this.bridgeProvider;
    }

    public final ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public IProcessor<BridgeHandleUnit> getTransformer() {
        return this.transformer;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public void setTransformer(IProcessor<BridgeHandleUnit> iProcessor) {
        this.transformer = iProcessor;
    }

    /* compiled from: BridgeRegistry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeRegistry$Companion;", "", "()V", "MODULE", "", "SCOPE_JOINER", "Lkotlin/Function1;", "", "getSCOPE_JOINER", "()Lkotlin/jvm/functions/Function1;", "SCOPE_NAME_SEPERATOR", "SCOPE_SPLITER", "getSCOPE_SPLITER", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<String, List<String>> getSCOPE_SPLITER() {
            return BridgeRegistry.SCOPE_SPLITER;
        }

        public final Function1<List<String>, String> getSCOPE_JOINER() {
            return BridgeRegistry.SCOPE_JOINER;
        }
    }

    private final List<BridgeMergeOperation> getBridgeMergeOps() {
        return (List) this.bridgeMergeOps.getValue();
    }

    /* renamed from: hasBridgeInitialized, reason: from getter */
    public final boolean getHasBridgesInit() {
        return this.hasBridgesInit;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public void setBridgePreInvokeHandler(Function1<? super IGenericBridgeMethod, Unit> bridgePreInvokeHandler) {
        Intrinsics.checkNotNullParameter(bridgePreInvokeHandler, "bridgePreInvokeHandler");
        this.bridgePreInvokeHandler = bridgePreInvokeHandler;
    }

    private final void initBridges() {
        AbsBulletMonitorCallback monitorCallback;
        AbsBulletMonitorCallback monitorCallback2;
        BulletContext bulletContext = this.bulletContext;
        if (bulletContext != null && (monitorCallback2 = bulletContext.getMonitorCallback()) != null) {
            monitorCallback2.onJsbRegisterBegin();
        }
        List<IGenericBridgeMethod> list = (List) this.bridgeProvider.invoke(this.contextProviderFactory);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (IGenericBridgeMethod iGenericBridgeMethod : list) {
            StringBuilder append = sb.append(iGenericBridgeMethod.getName());
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            StringsKt.appendln(append);
            IGenericBridgeMethod iGenericBridgeMethod2 = this.bridgeMap.get(iGenericBridgeMethod.getName());
            if (iGenericBridgeMethod2 != null) {
                StringBuilder append2 = sb2.append(iGenericBridgeMethod2.getName());
                Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
                StringsKt.appendln(append2);
                iGenericBridgeMethod2.release();
            }
            this.bridgeMap.put(iGenericBridgeMethod.getName(), iGenericBridgeMethod);
        }
        for (BridgeMergeOperation bridgeMergeOperation : getBridgeMergeOps()) {
            mergeOtherBridge(bridgeMergeOperation.getOtherRegistry(), bridgeMergeOperation.getUseOthersOnConflict());
        }
        BulletContext bulletContext2 = this.bulletContext;
        if (bulletContext2 != null && (monitorCallback = bulletContext2.getMonitorCallback()) != null) {
            monitorCallback.onJsbRegisterEnd();
        }
        this.hasBridgesInit = true;
    }

    private final List<String> selectBridgeNames(List<? extends IGenericBridgeMethod> bridges) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = bridges.iterator();
        while (it.hasNext()) {
            arrayList.add(((IGenericBridgeMethod) it.next()).getName());
        }
        return arrayList;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public void addBridge(IGenericBridgeMethod bridge) {
        IGenericBridgeMethod iGenericBridgeMethod;
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        if (this.bridgeMap.containsKey(bridge.getName()) && (iGenericBridgeMethod = this.bridgeMap.get(bridge.getName())) != null) {
            iGenericBridgeMethod.release();
        }
        this.bridgeMap.put(bridge.getName(), bridge);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public Map<String, IBridgeScope> getScopes() {
        return this.scopeMap;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public Map<String, IGenericBridgeMethod> getBridges() {
        Map<String, IGenericBridgeMethod> map = this.bridgeMap;
        if (!this.hasBridgesInit) {
            initBridges();
        }
        return map;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public void handle(List<String> scopeNames, Object params, IGenericBridgeMethod.ICallback callback, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(scopeNames, "scopeNames");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(reject, "reject");
        if (getHasReleased()) {
            return;
        }
        int size = scopeNames.size();
        if (size == 0) {
            reject.invoke(new IBridgeScope.BridgeNotFoundException("[unknown]"));
            return;
        }
        if (size == 1) {
            String str = (String) CollectionsKt.first(scopeNames);
            IGenericBridgeMethod iGenericBridgeMethod = getBridges().get(str);
            if (iGenericBridgeMethod == null) {
                reject.invoke(new IBridgeScope.BridgeNotFoundException(str));
                return;
            }
            if (iGenericBridgeMethod instanceof IBridgeMethod) {
                Function1<? super IGenericBridgeMethod, Unit> function1 = this.bridgePreInvokeHandler;
                if (function1 != null) {
                    function1.invoke(iGenericBridgeMethod);
                }
                ((IBridgeMethod) iGenericBridgeMethod).handle((JSONObject) params, (IBridgeMethod.ICallback) callback);
                return;
            }
            boolean z = iGenericBridgeMethod instanceof IIDLGenericBridgeMethod;
            if (z) {
                Function1<? super IGenericBridgeMethod, Unit> function12 = this.bridgePreInvokeHandler;
                if (function12 != null) {
                    function12.invoke(iGenericBridgeMethod);
                }
                IIDLGenericBridgeMethod iIDLGenericBridgeMethod = z ? (IIDLGenericBridgeMethod) iGenericBridgeMethod : null;
                if (iIDLGenericBridgeMethod != null) {
                    BridgeMethodKt.actualHandle(iIDLGenericBridgeMethod, params, (IIDLGenericBridgeMethod.ICallback) callback);
                    return;
                }
                return;
            }
            return;
        }
        String str2 = (String) CollectionsKt.first(scopeNames);
        IBridgeScope iBridgeScope = getScopes().get(str2);
        if (iBridgeScope == null) {
            reject.invoke(new IBridgeScope.BridgeNotFoundException(str2));
        } else {
            this.bridgePreInvokeHandler = this.bridgePreInvokeHandler;
            iBridgeScope.handle(scopeNames.subList(1, scopeNames.size()), params, callback, reject);
        }
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public void handle(final String funcName, final Object params, final IGenericBridgeMethod.ICallback callback, final Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(reject, "reject");
        if (getHasReleased()) {
            return;
        }
        final Function4<String, Object, IGenericBridgeMethod.ICallback, Function1<? super Throwable, ? extends Unit>, Unit> function4 = new Function4<String, Object, IGenericBridgeMethod.ICallback, Function1<? super Throwable, ? extends Unit>, Unit>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry$handle$impl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((String) obj, obj2, (IGenericBridgeMethod.ICallback) obj3, (Function1<? super Throwable, Unit>) obj4);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, Object obj, IGenericBridgeMethod.ICallback iCallback, Function1<? super Throwable, Unit> function1) {
                Intrinsics.checkNotNullParameter(str, "funcName");
                Intrinsics.checkNotNullParameter(obj, "params");
                Intrinsics.checkNotNullParameter(iCallback, "callback");
                Intrinsics.checkNotNullParameter(function1, "reject");
                BridgeRegistry.this.handle((List<String>) BridgeRegistry.INSTANCE.getSCOPE_SPLITER().invoke(str), obj, iCallback, function1);
            }
        };
        if (getTransformer() == null) {
            function4.invoke(funcName, params, callback, reject);
            return;
        }
        IProcessor<BridgeHandleUnit> transformer = getTransformer();
        Intrinsics.checkNotNull(transformer);
        transformer.process(new BridgeHandleUnit(funcName, params, callback, reject), new Function1<BridgeHandleUnit, Unit>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry$handle$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BridgeHandleUnit) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(BridgeHandleUnit bridgeHandleUnit) {
                Intrinsics.checkNotNullParameter(bridgeHandleUnit, "it");
                function4.invoke(bridgeHandleUnit.getFuncName(), bridgeHandleUnit.getParams(), bridgeHandleUnit.getCallback(), bridgeHandleUnit.getReject());
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry$handle$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                function4.invoke(funcName, params, callback, reject);
            }
        });
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public void iterate(Function2<? super List<? extends IBridgeScope>, ? super IGenericBridgeMethod, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Iterator<Map.Entry<String, IBridgeScope>> it = getScopes().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().iterate(handler);
        }
        Iterator<Map.Entry<String, IGenericBridgeMethod>> it2 = getBridges().entrySet().iterator();
        while (it2.hasNext()) {
            handler.invoke(CollectionsKt.emptyList(), it2.next().getValue());
        }
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public IGenericBridgeMethod getBridgeInstance(String func) {
        Intrinsics.checkNotNullParameter(func, "func");
        return getBridges().get(func);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public void iterateWithFuncName(final Function2<? super String, ? super IGenericBridgeMethod, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        iterate(new Function2<List<? extends IBridgeScope>, IGenericBridgeMethod, Unit>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry$iterateWithFuncName$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((List<? extends IBridgeScope>) obj, (IGenericBridgeMethod) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends IBridgeScope> list, IGenericBridgeMethod iGenericBridgeMethod) {
                String str;
                Intrinsics.checkNotNullParameter(list, "list");
                Intrinsics.checkNotNullParameter(iGenericBridgeMethod, "bridge");
                Function2<String, IGenericBridgeMethod, Unit> function2 = handler;
                if (list.isEmpty()) {
                    str = iGenericBridgeMethod.getName();
                } else {
                    List<? extends IBridgeScope> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((IBridgeScope) it.next()).getName());
                    }
                    List mutableList = CollectionsKt.toMutableList(arrayList);
                    mutableList.add(iGenericBridgeMethod.getName());
                    str = (String) BridgeRegistry.INSTANCE.getSCOPE_JOINER().invoke(mutableList);
                }
                function2.invoke(str, iGenericBridgeMethod);
            }
        });
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    public void merge(IBridgeRegistry otherRegistry, boolean useOthersOnConflict) {
        Intrinsics.checkNotNullParameter(otherRegistry, "otherRegistry");
        for (Map.Entry<String, IBridgeScope> entry : otherRegistry.getScopes().entrySet()) {
            if (this.scopeMap.containsKey(entry.getKey())) {
                IBridgeScope iBridgeScope = this.scopeMap.get(entry.getKey());
                if (iBridgeScope != null) {
                    iBridgeScope.merge(entry.getValue(), useOthersOnConflict);
                }
            } else {
                this.scopeMap.put(entry.getKey(), entry.getValue());
            }
        }
        getBridgeMergeOps().add(new BridgeMergeOperation(otherRegistry, useOthersOnConflict));
        if (getTransformer() == null) {
            setTransformer(otherRegistry.getTransformer());
            return;
        }
        IProcessor<BridgeHandleUnit> transformer = getTransformer();
        Intrinsics.checkNotNull(transformer);
        IProcessor<BridgeHandleUnit> transformer2 = otherRegistry.getTransformer();
        if (transformer2 != null) {
            if (useOthersOnConflict) {
                CollectionsKt.listOf(new IProcessor[]{transformer2, transformer});
            } else {
                CollectionsKt.listOf(new IProcessor[]{transformer, transformer2});
            }
        }
    }

    private final void mergeOtherBridge(IBridgeRegistry otherRegistry, boolean useOthersOnConflict) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, IGenericBridgeMethod> entry : otherRegistry.getBridges().entrySet()) {
            if (this.bridgeMap.containsKey(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), MapsKt.mapOf(new Pair[]{TuplesKt.to("has_been_registered", true), TuplesKt.to("useOthersOnConflict", Boolean.valueOf(useOthersOnConflict))}));
                if (useOthersOnConflict) {
                    IGenericBridgeMethod iGenericBridgeMethod = this.bridgeMap.get(entry.getKey());
                    if (iGenericBridgeMethod != null) {
                        iGenericBridgeMethod.release();
                    }
                    this.bridgeMap.put(entry.getKey(), entry.getValue());
                } else {
                    entry.getValue().release();
                }
            } else {
                linkedHashMap.put(entry.getKey(), MapsKt.mapOf(TuplesKt.to("has_been_registered", false)));
                this.bridgeMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
        Iterator<Map.Entry<String, IBridgeScope>> it = this.scopeMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().release();
        }
        Iterator<Map.Entry<String, IGenericBridgeMethod>> it2 = this.bridgeMap.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().release();
        }
        this.scopeMap.clear();
        this.bridgeMap.clear();
        this.hasReleased = true;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry
    /* renamed from: hasReleased, reason: from getter */
    public boolean getHasReleased() {
        return this.hasReleased;
    }
}
