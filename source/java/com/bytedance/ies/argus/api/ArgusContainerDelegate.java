package com.bytedance.ies.argus.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.interfaces.IArgusContainerAspect;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.argus.api.params.ArgusMotionEventParams;
import com.bytedance.ies.argus.api.params.ContainerCreatedParams;
import com.bytedance.ies.argus.api.params.IFePageInfo;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusContainerAspect;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.ies.argus.strategy.ContainerStrategyEngine;
import com.bytedance.ies.bullet.secure.IArgusSafeContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* compiled from: ArgusContainerDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0006\u0010\u001a\u001a\u00020\u0014J\u001a\u0010\u001b\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\"H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "Lcom/bytedance/ies/argus/api/interfaces/IArgusContainerAspect;", "()V", "argusContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "getArgusContext$anniex_release", "()Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "contextProvider", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate$ContextProvider;", "eventCenter", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "getEventCenter", "()Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "strategyEngine", "Lcom/bytedance/ies/argus/strategy/ContainerStrategyEngine;", "getStrategyEngine$anniex_release", "()Lcom/bytedance/ies/argus/strategy/ContainerStrategyEngine;", "strategyEngine$delegate", "Lkotlin/Lazy;", "asyncCalculateRouterRisk", "", "activity", "Landroid/app/Activity;", "params", "Lcom/bytedance/ies/argus/api/params/ContainerCreatedParams;", "asyncCalculateRouterRisk$anniex_release", "clear", "monitorContainerCreated", "monitorCreateContainer", "openContext", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "monitorOnMotionEvent", "Lcom/bytedance/ies/argus/api/params/ArgusMotionEventParams;", "ContextProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusContainerDelegate implements IArgusContainerAspect {
    private final ContainerContext argusContext = new ContainerContext();
    private final ContextProvider contextProvider = new ContextProvider();

    /* renamed from: strategyEngine$delegate, reason: from kotlin metadata */
    private final Lazy strategyEngine = LazyKt.lazy(new Function0<ContainerStrategyEngine>() { // from class: com.bytedance.ies.argus.api.ArgusContainerDelegate$strategyEngine$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ContainerStrategyEngine m578invoke() {
            ArgusContainerDelegate.ContextProvider contextProvider;
            contextProvider = ArgusContainerDelegate.this.contextProvider;
            return new ContainerStrategyEngine(contextProvider);
        }
    });

    /* renamed from: getArgusContext$anniex_release, reason: from getter */
    public final ContainerContext getArgusContext() {
        return this.argusContext;
    }

    private final BaseEventCenter getEventCenter() {
        return this.argusContext.getEventCenter();
    }

    public final ContainerStrategyEngine getStrategyEngine$anniex_release() {
        return (ContainerStrategyEngine) this.strategyEngine.getValue();
    }

    /* compiled from: ArgusContainerDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusContainerDelegate$ContextProvider;", "", "(Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;)V", "context", "Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class ContextProvider {
        public ContextProvider() {
        }

        public final ContainerContext context() {
            return ArgusContainerDelegate.this.getArgusContext();
        }
    }

    public final void clear() {
        getEventCenter().destroy();
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusContainerAspect
    public void monitorCreateContainer(Context openContext, Bundle bundle) {
        Intrinsics.checkNotNullParameter(openContext, "openContext");
        this.argusContext.setOpenContainerClass(openContext.getClass().getSimpleName());
        this.argusContext.setOpenContainerBundle(bundle);
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusContainerAspect
    public void monitorContainerCreated(Activity activity, ContainerCreatedParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        asyncCalculateRouterRisk$anniex_release(activity, params);
        if (activity instanceof IArgusSafeContainer) {
            ((IArgusSafeContainer) activity).setSecureMonitorEventListener(new IArgusSafeContainer.IArgusSafeMotionEventListener() { // from class: com.bytedance.ies.argus.api.ArgusContainerDelegate$monitorContainerCreated$1
                public void onTouchEvent(MotionEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    ArgusContainerDelegate.this.monitorOnMotionEvent(new ArgusMotionEventParams(event, null, null, 6, null));
                }
            });
        }
    }

    public final void asyncCalculateRouterRisk$anniex_release(Activity activity, ContainerCreatedParams params) {
        Bundle bundle;
        Class<?> cls;
        Intent intent;
        Intrinsics.checkNotNullParameter(params, "params");
        if (!getEventCenter().hasTriggerEvent(ArgusContainerAspect.CONTAINER_CREATED)) {
            BaseEventCenter.VerifyHandler enableSaveEvent = new BaseEventCenter.VerifyHandler(getEventCenter(), ArgusContainerAspect.CONTAINER_CREATED, params).enableSaveEvent();
            AspectConfigItem aspectConfig = enableSaveEvent.getContext().getAspectConfig();
            boolean z = !(aspectConfig != null ? Intrinsics.areEqual(aspectConfig.getAsync(), false) : false);
            enableSaveEvent.getContext().setUseAsync(z);
            if (z) {
                enableSaveEvent.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
                BaseEventCenter baseEventCenter = enableSaveEvent.this$0;
                IArgusAspect iArgusAspect = enableSaveEvent.aspect;
                boolean z2 = enableSaveEvent.saveEvent;
                Deferred async$default = BuildersKt.async$default(baseEventCenter.getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new C1143xc19ac7b3(z2, baseEventCenter, iArgusAspect, null, enableSaveEvent, params, activity, this), 3, (Object) null);
                if (z2) {
                    baseEventCenter.awaitEventJobs.put(iArgusAspect, async$default);
                }
                enableSaveEvent.executeReportTask(async$default);
                enableSaveEvent.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
                AspectVerifyResult.onPass$default(enableSaveEvent.getVerifyResult(), ArgusCommonVerifyReason.ASYNC_PASS_FIRST, null, null, 6, null);
            } else {
                enableSaveEvent.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
                AspectContext<?, ?> context = enableSaveEvent.getContext();
                enableSaveEvent.getVerifyResult();
                if (params.getCreateType() != ArgusContainerCreateType.Activity) {
                    bundle = params.getBundle();
                } else if (activity == null || (intent = activity.getIntent()) == null || (bundle = intent.getExtras()) == null) {
                    bundle = params.getBundle();
                }
                String simpleName = (activity == null || (cls = activity.getClass()) == null) ? null : cls.getSimpleName();
                ContainerContext argusContext = getArgusContext();
                argusContext.getOrRecordActivity(simpleName, bundle);
                argusContext.getOrRecordSchemaMap(params.getSchema());
                getStrategyEngine$anniex_release().calculate(context);
                context.getReportParams().setAddReportDataBlock(new ArgusContainerDelegate$asyncCalculateRouterRisk$1$2(this, context));
                enableSaveEvent.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
                enableSaveEvent.executeReportTask(null);
                enableSaveEvent.getVerifyResult();
            }
        }
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusContainerAspect
    public void monitorOnMotionEvent(ArgusMotionEventParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        IFePageInfo lastOpenFePge = this.argusContext.getLastOpenFePge();
        if (lastOpenFePge != null) {
            params.setPageInfo(lastOpenFePge);
            params.setLoadUrl(lastOpenFePge.getLoadUrl());
        }
        BaseEventCenter.VerifyHandler updateDefaultReportPlatform = new BaseEventCenter.VerifyHandler(getEventCenter(), ArgusGlobalAspect.MOTION_ON_TOUCH, params).updateDefaultReportPlatform(ArgusReportPlatform.NONE);
        updateDefaultReportPlatform.getContext().setUseAsync(false);
        updateDefaultReportPlatform.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = updateDefaultReportPlatform.getContext();
        updateDefaultReportPlatform.getVerifyResult();
        getStrategyEngine$anniex_release().calculate(context);
        updateDefaultReportPlatform.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        updateDefaultReportPlatform.executeReportTask(null);
        updateDefaultReportPlatform.getVerifyResult();
    }
}
