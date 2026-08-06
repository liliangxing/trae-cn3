package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.api.interfaces.IArgusGlobalAspect;
import com.bytedance.ies.argus.api.params.AboutToUploadFileParams;
import com.bytedance.ies.argus.api.params.InjectLoginStateParams;
import com.bytedance.ies.argus.api.params.LoadStaticResourceParams;
import com.bytedance.ies.argus.api.params.LoadStaticResourceRewritePayload;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.aspect.eventCenter.IEventCenterDepend;
import com.bytedance.ies.argus.bean.ArgusCSRFProtectVerifyReason;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.ArgusPrefetchVerifyReason;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.strategy.ICalculateHandlerDepend;
import com.bytedance.ies.argus.strategy.StrategyCalculateHandler;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.CSRFProtectStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.LoginStateSourceVerifyStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.PrefetchCallerParams;
import com.bytedance.ies.argus.strategy.provider.client.PrefetchStrategyProvider;
import com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusGlobalDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f2\u0006\u0010\r\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\f2\u0006\u0010\r\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\r\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusGlobalDelegate;", "Lcom/bytedance/ies/argus/api/interfaces/IArgusGlobalAspect;", "()V", "eventCenter", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "strategyEngine", "Lcom/bytedance/ies/argus/strategy/StrategyCalculateHandler;", "initEventCenter", "initStrategyEngine", "verifyAboutToPrefetch", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "", "Lcom/bytedance/ies/argus/bean/AspectVerifyResultWithoutRewrite;", "params", "Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchCallerParams;", "verifyAboutToUploadFile", "Lcom/bytedance/ies/argus/api/params/AboutToUploadFileParams;", "verifyInjectLoginState", "Lcom/bytedance/ies/argus/api/params/InjectLoginStateParams;", "verifyLoadStaticResource", "Lcom/bytedance/ies/argus/api/params/LoadStaticResourceRewritePayload;", "Lcom/bytedance/ies/argus/api/params/LoadStaticResourceParams;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusGlobalDelegate implements IArgusGlobalAspect {
    public static final String TAG = "ArgusGlobalDelegate";
    private final BaseEventCenter eventCenter;
    private final StrategyCalculateHandler strategyEngine;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<ArgusGlobalDelegate> instance$delegate = LazyKt.lazy(new Function0<ArgusGlobalDelegate>() { // from class: com.bytedance.ies.argus.api.ArgusGlobalDelegate$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ArgusGlobalDelegate m579invoke() {
            return new ArgusGlobalDelegate(null);
        }
    });

    public /* synthetic */ ArgusGlobalDelegate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ArgusGlobalDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusGlobalDelegate$Companion;", "", "()V", "TAG", "", "instance", "Lcom/bytedance/ies/argus/api/ArgusGlobalDelegate;", "getInstance", "()Lcom/bytedance/ies/argus/api/ArgusGlobalDelegate;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArgusGlobalDelegate getInstance() {
            return (ArgusGlobalDelegate) ArgusGlobalDelegate.instance$delegate.getValue();
        }
    }

    private ArgusGlobalDelegate() {
        this.strategyEngine = initStrategyEngine();
        this.eventCenter = initEventCenter();
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusGlobalAspect
    public AspectVerifyResult verifyAboutToPrefetch(PrefetchCallerParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (ArgusConfigManager.INSTANCE.getInstance().disableByRecovery(ArgusGlobalAspect.ABOUT_TO_PREFETCH)) {
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusPrefetchVerifyReason.RECOVERY_DISABLE_PREFETCH_VERIFY, null, null, 6, null);
        }
        BaseEventCenter.VerifyHandler verifyHandler = new BaseEventCenter.VerifyHandler(this.eventCenter, ArgusGlobalAspect.ABOUT_TO_PREFETCH, params);
        verifyHandler.getContext().setUseAsync(false);
        verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = verifyHandler.getContext();
        verifyHandler.getVerifyResult();
        this.strategyEngine.calculate(context);
        verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        verifyHandler.executeReportTask(null);
        return verifyHandler.getVerifyResult();
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusGlobalAspect
    public AspectVerifyResult<LoadStaticResourceRewritePayload> verifyLoadStaticResource(LoadStaticResourceParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (ArgusConfigManager.INSTANCE.getInstance().disableByRecovery(ArgusGlobalAspect.LOAD_STATIC_RESOURCE)) {
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusCSRFProtectVerifyReason.RECOVERY_DISABLE_LOAD_STATIC_RESOURCE, null, null, 6, null);
        }
        BaseEventCenter.VerifyHandler verifyHandler = new BaseEventCenter.VerifyHandler(this.eventCenter, ArgusGlobalAspect.LOAD_STATIC_RESOURCE, params);
        verifyHandler.getContext().setUseAsync(false);
        verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = verifyHandler.getContext();
        verifyHandler.getVerifyResult();
        this.strategyEngine.calculate(context);
        verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        verifyHandler.executeReportTask(null);
        return verifyHandler.getVerifyResult();
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusGlobalAspect
    public AspectVerifyResult verifyAboutToUploadFile(AboutToUploadFileParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BaseEventCenter.VerifyHandler verifyHandler = new BaseEventCenter.VerifyHandler(this.eventCenter, ArgusGlobalAspect.ABOUT_TO_UPLOAD_FILE, params);
        verifyHandler.getContext().setUseAsync(false);
        verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = verifyHandler.getContext();
        verifyHandler.getVerifyResult();
        this.strategyEngine.calculate(context);
        verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        verifyHandler.executeReportTask(null);
        return verifyHandler.getVerifyResult();
    }

    public final AspectVerifyResult verifyInjectLoginState(InjectLoginStateParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BaseEventCenter.VerifyHandler verifyHandler = new BaseEventCenter.VerifyHandler(this.eventCenter, ArgusGlobalAspect.INJECT_LOGIN_STATE, params);
        verifyHandler.getContext().setUseAsync(false);
        verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = verifyHandler.getContext();
        verifyHandler.getVerifyResult();
        this.strategyEngine.calculate(context);
        verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        verifyHandler.executeReportTask(null);
        return verifyHandler.getVerifyResult();
    }

    private final StrategyCalculateHandler initStrategyEngine() {
        return new StrategyCalculateHandler(new ICalculateHandlerDepend() { // from class: com.bytedance.ies.argus.api.ArgusGlobalDelegate$initStrategyEngine$1
            @Override // com.bytedance.ies.argus.strategy.ICalculateHandlerDepend
            public ContainerContext getContainerContext() {
                return null;
            }

            @Override // com.bytedance.ies.argus.strategy.ICalculateHandlerDepend
            public List<BaseStrategyProvider> getClientStrategyProvider() {
                return CollectionsKt.listOf(new BaseStrategyProvider[]{new PrefetchStrategyProvider(), new CSRFProtectStrategyProvider(), new UploadFileVerifyStrategyProvider(), new LoginStateSourceVerifyStrategyProvider()});
            }
        });
    }

    private final BaseEventCenter initEventCenter() {
        return new BaseEventCenter(new IEventCenterDepend() { // from class: com.bytedance.ies.argus.api.ArgusGlobalDelegate$initEventCenter$1
            @Override // com.bytedance.ies.argus.aspect.eventCenter.IEventCenterDepend
            /* renamed from: getContainerContext */
            public ContainerContext getThis$0() {
                return null;
            }
        });
    }
}
