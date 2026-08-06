package com.bytedance.ies.argus.aspect;

import android.view.View;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.interfaces.service.ArgusBaseBizService;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.ContainerStrategyEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusBaseViewDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010$J\u001d\u0010%\u001a\u00020 2\u000e\u0010&\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030'H\u0000¢\u0006\u0002\b(JK\u0010)\u001a\u0012\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H,0*R\u00020\u0015\"\u000e\b\u0001\u0010+*\b\u0012\u0004\u0012\u0002H,0-\"\n\b\u0002\u0010,*\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002H+H\u0000¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020 2\u0006\u0010#\u001a\u00028\u0000H\u0010¢\u0006\u0004\b5\u0010$J\b\u00106\u001a\u00020 H\u0016J\u000e\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dX \u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/bytedance/ies/argus/aspect/ArgusBaseViewDelegate;", "T", "Landroid/view/View;", "", "()V", "attachContainerDelegate", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "bizContextService", "Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseBizService;", "getBizContextService$anniex_release", "()Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseBizService;", "setBizContextService$anniex_release", "(Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseBizService;)V", "containerContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "getContainerContext$anniex_release", "()Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "containerDelegate", "getContainerDelegate", "()Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "eventCenter", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "getEventCenter$anniex_release", "()Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "strategyEngine", "Lcom/bytedance/ies/argus/strategy/ContainerStrategyEngine;", "getStrategyEngine", "()Lcom/bytedance/ies/argus/strategy/ContainerStrategyEngine;", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "getViewContext$anniex_release", "()Lcom/bytedance/ies/argus/aspect/eventCenter/BaseViewContext;", "", "delegate", "attachView", "view", "(Landroid/view/View;)V", "calculate", "context", "Lcom/bytedance/ies/argus/bean/AspectContext;", "calculate$anniex_release", "initVerifyHandler", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$VerifyHandler;", "PARAMS", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "aspect", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "params", "initVerifyHandler$anniex_release", "(Lcom/bytedance/ies/argus/bean/IArgusAspect;Lcom/bytedance/ies/argus/api/params/BaseAspectParams;)Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$VerifyHandler;", "innerAttachView", "innerAttachView$anniex_release", "onViewDestroy", "setBizContext", "service", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class ArgusBaseViewDelegate<T extends View> {
    private ArgusContainerDelegate attachContainerDelegate;
    private ArgusBaseBizService bizContextService;

    public abstract BaseViewContext<T> getViewContext$anniex_release();

    public void innerAttachView$anniex_release(T view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* renamed from: getBizContextService$anniex_release, reason: from getter */
    public final ArgusBaseBizService getBizContextService() {
        return this.bizContextService;
    }

    public final void setBizContextService$anniex_release(ArgusBaseBizService argusBaseBizService) {
        this.bizContextService = argusBaseBizService;
    }

    public final ArgusContainerDelegate getContainerDelegate() {
        ArgusContainerDelegate argusContainerDelegate = this.attachContainerDelegate;
        return argusContainerDelegate == null ? new ArgusContainerDelegate() : argusContainerDelegate;
    }

    public final ContainerContext getContainerContext$anniex_release() {
        return getContainerDelegate().getArgusContext();
    }

    public final BaseEventCenter getEventCenter$anniex_release() {
        return getContainerContext$anniex_release().getEventCenter();
    }

    private final ContainerStrategyEngine getStrategyEngine() {
        return getContainerDelegate().getStrategyEngine$anniex_release();
    }

    public final void attachView(T view) {
        if (getViewContext$anniex_release().getWeakView() != null || view == null) {
            return;
        }
        getViewContext$anniex_release().attachView(view);
        innerAttachView$anniex_release(view);
        Unit unit = Unit.INSTANCE;
    }

    public final void attachContainerDelegate(ArgusContainerDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.attachContainerDelegate = delegate;
    }

    public final void setBizContext(ArgusBaseBizService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.bizContextService = service;
        getViewContext$anniex_release().updateArgusBizId(service.bizName(), "biz service");
    }

    public void onViewDestroy() {
        if (this.attachContainerDelegate == null) {
            getContainerDelegate().clear();
        }
    }

    public final void calculate$anniex_release(AspectContext<?, ?> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getStrategyEngine().calculate(context, getViewContext$anniex_release());
    }

    public final <PARAMS extends BaseAspectParams<REWRITE_PAYLOAD>, REWRITE_PAYLOAD extends BaseRewritePayload> BaseEventCenter.VerifyHandler<PARAMS, REWRITE_PAYLOAD> initVerifyHandler$anniex_release(IArgusAspect aspect, PARAMS params) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        Intrinsics.checkNotNullParameter(params, "params");
        return new BaseEventCenter.VerifyHandler(getEventCenter$anniex_release(), aspect, params).updateViewContext(getViewContext$anniex_release());
    }
}
