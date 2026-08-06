package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.base.IReleasable;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\"J:\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e0\u0016H&J(\u0010\u0018\u001a\u00020\u000e2\u001e\u0010\u0019\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u001aH&J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eH&J \u0010\u001f\u001a\u00020\u000e2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0016j\u0002`!H&R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007¨\u0006#"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScope;", "Lcom/bytedance/ies/bullet/service/base/IReleasable;", "bridgeMap", "", "", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "getBridgeMap", "()Ljava/util/Map;", "name", "getName", "()Ljava/lang/String;", "subScopeMap", "getSubScopeMap", "handle", "", "scopeNames", "", "params", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "reject", "Lkotlin/Function1;", "", "iterate", "handler", "Lkotlin/Function2;", "merge", "otherScope", "useOthersOnConflict", "", "setBridgePreInvokeHandler", "bridgePreInvokeHandler", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePreInvokeHandler;", "BridgeNotFoundException", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBridgeScope extends IReleasable {
    Map<String, IGenericBridgeMethod> getBridgeMap();

    String getName();

    Map<String, IBridgeScope> getSubScopeMap();

    void handle(List<String> scopeNames, Object params, IGenericBridgeMethod.ICallback callback, Function1<? super Throwable, Unit> reject);

    void iterate(Function2<? super List<? extends IBridgeScope>, ? super IGenericBridgeMethod, Unit> handler);

    void merge(IBridgeScope otherScope, boolean useOthersOnConflict);

    void setBridgePreInvokeHandler(Function1<? super IGenericBridgeMethod, Unit> bridgePreInvokeHandler);

    /* compiled from: BridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScope$BridgeNotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "scope", "", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class BridgeNotFoundException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BridgeNotFoundException(String scope) {
            super(scope + " not found");
            Intrinsics.checkNotNullParameter(scope, "scope");
        }
    }
}
