package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.core.model.pipeline.IProcessor;
import com.bytedance.ies.bullet.service.base.IReleasable;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: BridgeRegistry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0004H&J4\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001fH&J:\u0010\u0018\u001a\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001fH&J\b\u0010#\u001a\u00020$H&J(\u0010%\u001a\u00020\u00142\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140'H&J\"\u0010(\u001a\u00020\u00142\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140'H&J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020$H&J \u0010,\u001a\u00020\u00142\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u001fj\u0002`.H&R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R&\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "Lcom/bytedance/ies/bullet/service/base/IReleasable;", "bridges", "", "", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "getBridges", "()Ljava/util/Map;", "scopes", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeScope;", "getScopes", "transformer", "Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeHandleUnit;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeRegistryTransformer;", "getTransformer", "()Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;", "setTransformer", "(Lcom/bytedance/ies/bullet/core/model/pipeline/IProcessor;)V", "addBridge", "", "bridge", "getBridgeInstance", "func", "handle", "funcName", "params", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "reject", "Lkotlin/Function1;", "", "scopeNames", "", "hasReleased", "", "iterate", "handler", "Lkotlin/Function2;", "iterateWithFuncName", "merge", "otherRegistry", "useOthersOnConflict", "setBridgePreInvokeHandler", "bridgePreInvokeHandler", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgePreInvokeHandler;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBridgeRegistry extends IReleasable {
    void addBridge(IGenericBridgeMethod bridge);

    IGenericBridgeMethod getBridgeInstance(String func);

    Map<String, IGenericBridgeMethod> getBridges();

    Map<String, IBridgeScope> getScopes();

    IProcessor<BridgeHandleUnit> getTransformer();

    void handle(String funcName, Object params, IGenericBridgeMethod.ICallback callback, Function1<? super Throwable, Unit> reject);

    void handle(List<String> scopeNames, Object params, IGenericBridgeMethod.ICallback callback, Function1<? super Throwable, Unit> reject);

    boolean hasReleased();

    void iterate(Function2<? super List<? extends IBridgeScope>, ? super IGenericBridgeMethod, Unit> handler);

    void iterateWithFuncName(Function2<? super String, ? super IGenericBridgeMethod, Unit> handler);

    void merge(IBridgeRegistry otherRegistry, boolean useOthersOnConflict);

    void setBridgePreInvokeHandler(Function1<? super IGenericBridgeMethod, Unit> bridgePreInvokeHandler);

    void setTransformer(IProcessor<BridgeHandleUnit> iProcessor);
}
