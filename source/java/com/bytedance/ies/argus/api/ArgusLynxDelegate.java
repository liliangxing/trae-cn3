package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.api.interfaces.IArgusLynxAspect;
import com.bytedance.ies.argus.api.params.AboutToRequestLynxSSRUrlParams;
import com.bytedance.ies.argus.api.params.JSBCallParams;
import com.bytedance.ies.argus.api.params.JSBCallRewritePayload;
import com.bytedance.ies.argus.api.params.LoadTemplateParams;
import com.bytedance.ies.argus.api.params.LynxSignVerifyCallerParams;
import com.bytedance.ies.argus.aspect.ArgusBaseViewDelegate;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.GlobalEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.LynxViewContext;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusContainerAspect;
import com.bytedance.ies.argus.bean.ArgusJSBCallVerifyReason;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.security.ILynxSecurityService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusLynxDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001eB\u0007\b\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u001a\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00172\u0006\u0010\u0011\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00152\u0006\u0010\u0011\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00172\u0006\u0010\u0011\u001a\u00020\u001dR\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusLynxDelegate;", "Lcom/bytedance/ies/argus/api/interfaces/IArgusLynxAspect;", "Lcom/bytedance/ies/argus/aspect/ArgusBaseViewDelegate;", "Lcom/lynx/tasm/LynxView;", "()V", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/LynxViewContext;", "getViewContext$anniex_release", "()Lcom/bytedance/ies/argus/aspect/eventCenter/LynxViewContext;", "attachContainerDelegate", "delegate", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "innerAttachView", "", "view", "innerAttachView$anniex_release", "monitorLoadTemplate", "params", "Lcom/bytedance/ies/argus/api/params/LoadTemplateParams;", "monitorViewDestroy", "verifyAboutToRequestLynxSSRUrl", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "", "Lcom/bytedance/ies/argus/bean/AspectVerifyResultWithoutRewrite;", "Lcom/bytedance/ies/argus/api/params/AboutToRequestLynxSSRUrlParams;", "verifyJSBCall", "Lcom/bytedance/ies/argus/api/params/JSBCallRewritePayload;", "Lcom/bytedance/ies/argus/api/params/JSBCallParams;", "verifyLoadTemplate", "Lcom/bytedance/ies/argus/api/params/LynxSignVerifyCallerParams;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusLynxDelegate extends ArgusBaseViewDelegate<LynxView> implements IArgusLynxAspect {
    public static final String TAG = "ArgusLynxDelegate";
    private final LynxViewContext viewContext = new LynxViewContext();

    @Override // com.bytedance.ies.argus.aspect.ArgusBaseViewDelegate
    public BaseViewContext<LynxView> getViewContext$anniex_release() {
        return this.viewContext;
    }

    @Override // com.bytedance.ies.argus.aspect.ArgusBaseViewDelegate
    public void innerAttachView$anniex_release(LynxView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        GlobalEventCenter.INSTANCE.getInstance().recordContext(this);
    }

    public final ArgusLynxDelegate attachContainerDelegate(ArgusContainerDelegate delegate) {
        if (delegate != null) {
            attachContainerDelegate(delegate);
        }
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ies.argus.aspect.eventCenter.LynxViewContext] */
    @Override // com.bytedance.ies.argus.api.interfaces.IArgusLynxAspect
    public void monitorLoadTemplate(LoadTemplateParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        getViewContext$anniex_release().recordTemplateInfo(params, ArgusLynxViewAspect.ABOUT_TO_LOAD_TEMPLATE);
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusViewAspect
    public AspectVerifyResult<JSBCallRewritePayload> verifyJSBCall(JSBCallParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (ArgusConfigManager.INSTANCE.getInstance().disableByRecovery(ArgusContainerAspect.JSB_CALL)) {
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusJSBCallVerifyReason.RECOVERY_DISABLE_LYNX_JSB_AUTH, null, null, 6, null);
        }
        BaseEventCenter.VerifyHandler<PARAMS, REWRITE_PAYLOAD> initVerifyHandler$anniex_release = initVerifyHandler$anniex_release(ArgusContainerAspect.JSB_CALL, params);
        initVerifyHandler$anniex_release.getContext().setUseAsync(false);
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = initVerifyHandler$anniex_release.getContext();
        initVerifyHandler$anniex_release.getVerifyResult();
        calculate$anniex_release(context);
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        initVerifyHandler$anniex_release.executeReportTask(null);
        return initVerifyHandler$anniex_release.getVerifyResult();
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusViewAspect
    public void monitorViewDestroy() {
        String viewId = getViewContext$anniex_release().getViewId();
        if (viewId != null) {
            GlobalEventCenter.INSTANCE.getInstance().removeContext(viewId);
        }
        super.onViewDestroy();
    }

    public final AspectVerifyResult verifyLoadTemplate(LynxSignVerifyCallerParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BaseEventCenter.VerifyHandler<PARAMS, REWRITE_PAYLOAD> initVerifyHandler$anniex_release = initVerifyHandler$anniex_release(ArgusLynxViewAspect.LOAD_TEMPLATE, params);
        initVerifyHandler$anniex_release.getContext().setUseAsync(false);
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = initVerifyHandler$anniex_release.getContext();
        initVerifyHandler$anniex_release.getVerifyResult();
        calculate$anniex_release(context);
        if (!params.getIsSigned()) {
            context.getReportParams().setForceHighFrequency(true);
        }
        if (params.getTasmType() == ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE) {
            getContainerContext$anniex_release().setLastOpenFePge(params);
        }
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        initVerifyHandler$anniex_release.executeReportTask(null);
        return initVerifyHandler$anniex_release.getVerifyResult();
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusLynxAspect
    public AspectVerifyResult verifyAboutToRequestLynxSSRUrl(AboutToRequestLynxSSRUrlParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (ArgusConfigManager.INSTANCE.getInstance().disableByRecovery(ArgusLynxViewAspect.ABOUT_TO_REQUEST_LYNX_SSR_URL)) {
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusCommonVerifyReason.DISABLE_BY_RECOVERY, null, null, 6, null);
        }
        BaseEventCenter.VerifyHandler<PARAMS, REWRITE_PAYLOAD> initVerifyHandler$anniex_release = initVerifyHandler$anniex_release(ArgusLynxViewAspect.ABOUT_TO_REQUEST_LYNX_SSR_URL, params);
        initVerifyHandler$anniex_release.getContext().setUseAsync(false);
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = initVerifyHandler$anniex_release.getContext();
        initVerifyHandler$anniex_release.getVerifyResult();
        calculate$anniex_release(context);
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        initVerifyHandler$anniex_release.executeReportTask(null);
        return initVerifyHandler$anniex_release.getVerifyResult();
    }
}
