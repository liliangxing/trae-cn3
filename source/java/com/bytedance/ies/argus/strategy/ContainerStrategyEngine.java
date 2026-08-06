package com.bytedance.ies.argus.strategy;

import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.HttpsDomainStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.JSBCallStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.LynxLoadWhiteListStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.LynxSSRUrlVerifyStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.LynxSignVerifyStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.MotionStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.WebLoadStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.WebViewCSRFUAStrategyProvider;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContainerStrategyEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013J\"\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015J\u0016\u0010\u0016\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0002J\u0016\u0010\u0017\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/argus/strategy/ContainerStrategyEngine;", "", "contextProvider", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate$ContextProvider;", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "(Lcom/bytedance/ies/argus/api/ArgusContainerDelegate$ContextProvider;)V", "containerHandler", "Lcom/bytedance/ies/argus/strategy/StrategyCalculateHandler;", "statelessHandler", "getStatelessHandler", "()Lcom/bytedance/ies/argus/strategy/StrategyCalculateHandler;", "statelessHandler$delegate", "Lkotlin/Lazy;", "viewHandlerCacheStorage", "Ljava/util/concurrent/ConcurrentHashMap;", "", "calculate", "", "context", "Lcom/bytedance/ies/argus/bean/AspectContext;", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "getOrInitViewHandler", "initHandler", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerStrategyEngine {
    private final StrategyCalculateHandler containerHandler;
    private final ArgusContainerDelegate.ContextProvider contextProvider;

    /* renamed from: statelessHandler$delegate, reason: from kotlin metadata */
    private final Lazy statelessHandler;
    private final ConcurrentHashMap<String, StrategyCalculateHandler> viewHandlerCacheStorage;

    public ContainerStrategyEngine(ArgusContainerDelegate.ContextProvider contextProvider) {
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        this.contextProvider = contextProvider;
        this.containerHandler = initHandler(null);
        this.viewHandlerCacheStorage = new ConcurrentHashMap<>();
        this.statelessHandler = LazyKt.lazy(new Function0<StrategyCalculateHandler>() { // from class: com.bytedance.ies.argus.strategy.ContainerStrategyEngine$statelessHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final StrategyCalculateHandler m619invoke() {
                StrategyCalculateHandler initHandler;
                initHandler = ContainerStrategyEngine.this.initHandler(null);
                return initHandler;
            }
        });
    }

    private final StrategyCalculateHandler getStatelessHandler() {
        return (StrategyCalculateHandler) this.statelessHandler.getValue();
    }

    private final StrategyCalculateHandler getOrInitViewHandler(BaseViewContext<?> viewContext) {
        String traceId;
        if (viewContext == null || (traceId = viewContext.getTraceId()) == null) {
            return getStatelessHandler();
        }
        ConcurrentHashMap<String, StrategyCalculateHandler> concurrentHashMap = this.viewHandlerCacheStorage;
        StrategyCalculateHandler strategyCalculateHandler = concurrentHashMap.get(traceId);
        if (strategyCalculateHandler == null) {
            StrategyCalculateHandler initHandler = initHandler(viewContext);
            StrategyCalculateHandler putIfAbsent = concurrentHashMap.putIfAbsent(traceId, initHandler);
            strategyCalculateHandler = putIfAbsent == null ? initHandler : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(strategyCalculateHandler, "viewHandlerCacheStorage.…nitHandler(viewContext) }");
        return strategyCalculateHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrategyCalculateHandler initHandler(BaseViewContext<?> viewContext) {
        final List listOf = CollectionsKt.listOf(new BaseStrategyProvider[]{new WebLoadStrategyProvider(), new JSBCallStrategyProvider(), new LynxSignVerifyStrategyProvider(), new LynxLoadWhiteListStrategyProvider(), new MotionStrategyProvider(), new HttpsDomainStrategyProvider(), new LynxSSRUrlVerifyStrategyProvider(), new WebViewCSRFUAStrategyProvider()});
        return new StrategyCalculateHandler(new ICalculateHandlerDepend() { // from class: com.bytedance.ies.argus.strategy.ContainerStrategyEngine$initHandler$1
            @Override // com.bytedance.ies.argus.strategy.ICalculateHandlerDepend
            public List<BaseStrategyProvider> getClientStrategyProvider() {
                return listOf;
            }

            @Override // com.bytedance.ies.argus.strategy.ICalculateHandlerDepend
            public ContainerContext getContainerContext() {
                ArgusContainerDelegate.ContextProvider contextProvider;
                contextProvider = this.contextProvider;
                return contextProvider.context();
            }
        });
    }

    public final void calculate(AspectContext<?, ?> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.containerHandler.calculate(context);
    }

    public final void calculate(AspectContext<?, ?> context, BaseViewContext<?> viewContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewContext, "viewContext");
        getOrInitViewHandler(viewContext).calculate(context);
    }
}
