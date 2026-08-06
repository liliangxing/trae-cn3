package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope;
import com.bytedance.ies.bullet.core.kit.bridge.IIDLGenericBridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ:\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\fH\u0016J(\u0010\u001b\u001a\u00020\r2\u001e\u0010\u001c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J \u0010#\u001a\u00020\r2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH\u0016R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeScope;", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScope;", "name", "", "subScopeMap", "", "bridgeMap", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getBridgeMap", "()Ljava/util/Map;", "bridgePreInvokeHandler", "Lkotlin/Function1;", "", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePreInvokeHandler;", "getName", "()Ljava/lang/String;", "getSubScopeMap", "handle", "scopeNames", "", "params", "", "callback", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "reject", "", "iterate", "handler", "Lkotlin/Function2;", "merge", "otherScope", "useOthersOnConflict", "", "release", "setBridgePreInvokeHandler", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BridgeScope implements IBridgeScope {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, IGenericBridgeMethod> bridgeMap;
    private Function1<? super IGenericBridgeMethod, Unit> bridgePreInvokeHandler;
    private final String name;
    private final Map<String, IBridgeScope> subScopeMap;

    public /* synthetic */ BridgeScope(String str, Map map, Map map2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, map2);
    }

    private BridgeScope(String str, Map<String, IBridgeScope> map, Map<String, IGenericBridgeMethod> map2) {
        this.name = str;
        this.subScopeMap = map;
        this.bridgeMap = map2;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public Map<String, IBridgeScope> getSubScopeMap() {
        return this.subScopeMap;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public Map<String, IGenericBridgeMethod> getBridgeMap() {
        return this.bridgeMap;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public void setBridgePreInvokeHandler(Function1<? super IGenericBridgeMethod, Unit> bridgePreInvokeHandler) {
        Intrinsics.checkNotNullParameter(bridgePreInvokeHandler, "bridgePreInvokeHandler");
        this.bridgePreInvokeHandler = bridgePreInvokeHandler;
    }

    /* compiled from: BridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeScope$Companion;", "", "()V", "newInstance", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScope;", "scopeProviderFactory", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScopeProviderFactory;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IBridgeScope newInstance(IBridgeScopeProviderFactory scopeProviderFactory, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(scopeProviderFactory, "scopeProviderFactory");
            Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
            String name = scopeProviderFactory.getName();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (IBridgeScopeProviderFactory iBridgeScopeProviderFactory : (Iterable) scopeProviderFactory.getSubScopesProvider().invoke(contextProviderFactory)) {
                linkedHashMap.put(iBridgeScopeProviderFactory.getName(), BridgeScope.INSTANCE.newInstance(iBridgeScopeProviderFactory, contextProviderFactory));
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (IGenericBridgeMethod iGenericBridgeMethod : (Iterable) scopeProviderFactory.getBridgesProvider().invoke(contextProviderFactory)) {
                linkedHashMap2.put(iGenericBridgeMethod.getName(), iGenericBridgeMethod);
            }
            Unit unit = Unit.INSTANCE;
            return new BridgeScope(name, linkedHashMap, linkedHashMap2, null);
        }
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public void handle(List<String> scopeNames, Object params, IGenericBridgeMethod.ICallback callback, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(scopeNames, "scopeNames");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(reject, "reject");
        int size = scopeNames.size();
        if (size == 0) {
            reject.invoke(new IBridgeScope.BridgeNotFoundException("[unknown]"));
            return;
        }
        if (size == 1) {
            String str = (String) CollectionsKt.first(scopeNames);
            IGenericBridgeMethod iGenericBridgeMethod = getBridgeMap().get(str);
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
        IBridgeScope iBridgeScope = getSubScopeMap().get(str2);
        if (iBridgeScope == null) {
            reject.invoke(new IBridgeScope.BridgeNotFoundException(str2));
        } else {
            this.bridgePreInvokeHandler = this.bridgePreInvokeHandler;
            iBridgeScope.handle(scopeNames.subList(1, scopeNames.size()), params, callback, reject);
        }
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public void iterate(final Function2<? super List<? extends IBridgeScope>, ? super IGenericBridgeMethod, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Iterator<Map.Entry<String, IBridgeScope>> it = getSubScopeMap().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().iterate(new Function2<List<? extends IBridgeScope>, IGenericBridgeMethod, Unit>() { // from class: com.bytedance.ies.bullet.core.kit.bridge.BridgeScope$iterate$1$1
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
                    Intrinsics.checkNotNullParameter(list, "list");
                    Intrinsics.checkNotNullParameter(iGenericBridgeMethod, "bridge");
                    Function2<List<? extends IBridgeScope>, IGenericBridgeMethod, Unit> function2 = handler;
                    List mutableListOf = CollectionsKt.mutableListOf(new IBridgeScope[]{this});
                    mutableListOf.addAll(list);
                    function2.invoke(mutableListOf, iGenericBridgeMethod);
                }
            });
        }
        Iterator<Map.Entry<String, IGenericBridgeMethod>> it2 = getBridgeMap().entrySet().iterator();
        while (it2.hasNext()) {
            handler.invoke(CollectionsKt.listOf(this), it2.next().getValue());
        }
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public void merge(IBridgeScope otherScope, boolean useOthersOnConflict) {
        Intrinsics.checkNotNullParameter(otherScope, "otherScope");
        for (Map.Entry<String, IGenericBridgeMethod> entry : otherScope.getBridgeMap().entrySet()) {
            if (!getBridgeMap().containsKey(entry.getKey())) {
                getBridgeMap().put(entry.getKey(), entry.getValue());
            } else if (useOthersOnConflict) {
                IGenericBridgeMethod iGenericBridgeMethod = getBridgeMap().get(entry.getKey());
                if (iGenericBridgeMethod != null) {
                    iGenericBridgeMethod.release();
                }
                getBridgeMap().put(entry.getKey(), entry.getValue());
            } else {
                entry.getValue().release();
            }
        }
        for (Map.Entry<String, IBridgeScope> entry2 : otherScope.getSubScopeMap().entrySet()) {
            if (getSubScopeMap().containsKey(entry2.getKey())) {
                IBridgeScope iBridgeScope = getSubScopeMap().get(entry2.getKey());
                if (iBridgeScope != null) {
                    iBridgeScope.merge(entry2.getValue(), useOthersOnConflict);
                }
            } else {
                getSubScopeMap().put(entry2.getKey(), entry2.getValue());
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
        Iterator<Map.Entry<String, IBridgeScope>> it = getSubScopeMap().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().release();
        }
        Iterator<Map.Entry<String, IGenericBridgeMethod>> it2 = getBridgeMap().entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().release();
        }
    }
}
