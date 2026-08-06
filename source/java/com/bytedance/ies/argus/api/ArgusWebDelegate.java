package com.bytedance.ies.argus.api;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.argus.api.interfaces.IArgusWebAspect;
import com.bytedance.ies.argus.api.interfaces.service.IArgusWebSecureService;
import com.bytedance.ies.argus.api.params.ArgusMotionEventParams;
import com.bytedance.ies.argus.api.params.ArgusOnWebViewCreatedParams;
import com.bytedance.ies.argus.api.params.ArgusOnWebViewCreatedRewritePayload;
import com.bytedance.ies.argus.api.params.ArgusWebResourceRequestParams;
import com.bytedance.ies.argus.api.params.ArgusWebResourceRequestRewritePayload;
import com.bytedance.ies.argus.api.params.ContainerCreatedParams;
import com.bytedance.ies.argus.api.params.JSBCallParams;
import com.bytedance.ies.argus.api.params.JSBCallRewritePayload;
import com.bytedance.ies.argus.api.params.WebLoadPageType;
import com.bytedance.ies.argus.api.params.WebLoadRiskTag;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.api.params.WebLoadVerifySource;
import com.bytedance.ies.argus.aspect.ArgusBaseViewDelegate;
import com.bytedance.ies.argus.aspect.ArgusWebDefaultDelegateKt;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.WebViewContext;
import com.bytedance.ies.argus.base.ArgusDelegateHelper;
import com.bytedance.ies.argus.base.ArgusReportParams;
import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.base.ArgusServiceManager;
import com.bytedance.ies.argus.bean.ArgusContainerAspect;
import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.ArgusWebLoadVerifyReason;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.plugin.PluginManager;
import com.bytedance.ies.argus.plugin.SecLinkPluginHandler;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.json.JSONObject;

/* compiled from: ArgusWebDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u001b0\u001aj\u0002`\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0015\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0003H\u0010¢\u0006\u0002\b J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0003J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010#\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0014H\u0016J\u001c\u0010(\u001a\u00020\u00142\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010/\u001a\f\u0012\u0004\u0012\u00020\u001b0\u001aj\u0002`\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u0002010\u001a2\u0006\u0010#\u001a\u000202H\u0016J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001a2\u0006\u0010#\u001a\u000206H\u0016J \u00107\u001a\b\u0012\u0004\u0012\u0002080\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u000209H\u0016J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020\"0\u001a2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006;"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusWebDelegate;", "Lcom/bytedance/ies/argus/api/interfaces/IArgusWebAspect;", "Lcom/bytedance/ies/argus/aspect/ArgusBaseViewDelegate;", "Landroid/webkit/WebView;", "()V", "isHighRiskScene", "", "()Z", "secLinkHandler", "Lcom/bytedance/ies/argus/plugin/SecLinkPluginHandler;", "getSecLinkHandler$anniex_release", "()Lcom/bytedance/ies/argus/plugin/SecLinkPluginHandler;", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/WebViewContext;", "getViewContext$anniex_release", "()Lcom/bytedance/ies/argus/aspect/eventCenter/WebViewContext;", "attachContainerDelegate", "containerDelegate", "Lcom/bytedance/ies/argus/api/ArgusContainerDelegate;", "ensureCheckRouterRisk", "", "originSecLinkScene", "", "containerCreatedParams", "Lcom/bytedance/ies/argus/api/params/ContainerCreatedParams;", "handleGoBack", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "", "Lcom/bytedance/ies/argus/bean/AspectVerifyResultWithoutRewrite;", "webView", "innerAttachView", "view", "innerAttachView$anniex_release", "innerVerifyLoadUrl", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlRewritePayload;", "params", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams;", "monitorOnMotionEvent", "Lcom/bytedance/ies/argus/api/params/ArgusMotionEventParams;", "monitorViewDestroy", "transmitJsbAuthResult", "bridgeCall", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "Lorg/json/JSONObject;", "authResult", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "verifyAboutToLoadUrl", "verifyCanGoBack", "verifyJSBCall", "Lcom/bytedance/ies/argus/api/params/JSBCallRewritePayload;", "Lcom/bytedance/ies/argus/api/params/JSBCallParams;", "verifyLoadUrl", "verifyOnWebViewCreated", "Lcom/bytedance/ies/argus/api/params/ArgusOnWebViewCreatedRewritePayload;", "Lcom/bytedance/ies/argus/api/params/ArgusOnWebViewCreatedParams;", "verifyShouldInterceptRequest", "Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestRewritePayload;", "Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestParams;", "verifyShouldOverrideUrlLoading", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusWebDelegate extends ArgusBaseViewDelegate<WebView> implements IArgusWebAspect {
    private final WebViewContext viewContext = new WebViewContext();

    @Override // com.bytedance.ies.argus.aspect.ArgusBaseViewDelegate
    public BaseViewContext<WebView> getViewContext$anniex_release() {
        return this.viewContext;
    }

    public final SecLinkPluginHandler getSecLinkHandler$anniex_release() {
        return (SecLinkPluginHandler) PluginManager.INSTANCE.getInstance().getPlugin(SecLinkPluginHandler.class, getContainerContext$anniex_release().getArgusBizId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isHighRiskScene() {
        return ArgusDelegateHelper.INSTANCE.isHighRiskScene(this);
    }

    @Override // com.bytedance.ies.argus.aspect.ArgusBaseViewDelegate
    public void innerAttachView$anniex_release(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R.id.argus_secure_webview, true);
    }

    public final ArgusWebDelegate attachContainerDelegate(ArgusContainerDelegate containerDelegate) {
        if (containerDelegate != null) {
            attachContainerDelegate(containerDelegate);
        }
        return this;
    }

    public final void ensureCheckRouterRisk(String originSecLinkScene, ContainerCreatedParams containerCreatedParams) {
        WebView view;
        Intrinsics.checkNotNullParameter(containerCreatedParams, "containerCreatedParams");
        getContainerContext$anniex_release().setOriginSecLinkScene(originSecLinkScene);
        if (getEventCenter$anniex_release().hasTriggerEvent(ArgusContainerAspect.CONTAINER_CREATED) || (view = getViewContext$anniex_release().getView()) == null) {
            return;
        }
        Context context = view.getContext();
        Activity activity = null;
        Activity activity2 = context instanceof Activity ? (Activity) context : null;
        if (activity2 == null) {
            Context context2 = view.getContext();
            MutableContextWrapper mutableContextWrapper = context2 instanceof MutableContextWrapper ? (MutableContextWrapper) context2 : null;
            Object baseContext = mutableContextWrapper != null ? mutableContextWrapper.getBaseContext() : null;
            if (baseContext instanceof Activity) {
                activity = (Activity) baseContext;
            }
        } else {
            activity = activity2;
        }
        getContainerDelegate().asyncCalculateRouterRisk$anniex_release(activity, containerCreatedParams);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    @Override // com.bytedance.ies.argus.api.interfaces.IArgusWebAspect
    public AspectVerifyResult<WebLoadUrlRewritePayload> verifyAboutToLoadUrl(WebView webView, WebLoadUrlParams params) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(params, "params");
        AspectVerifyResult<WebLoadUrlRewritePayload> innerVerifyLoadUrl = innerVerifyLoadUrl(webView, params);
        ?? viewContext$anniex_release = getViewContext$anniex_release();
        WebLoadUrlRewritePayload rewritePayload = innerVerifyLoadUrl.getRewritePayload();
        viewContext$anniex_release.setReloadUrl(rewritePayload != null ? rewritePayload.getUrl() : null);
        return innerVerifyLoadUrl;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    @Override // com.bytedance.ies.argus.api.interfaces.IArgusWebAspect
    public AspectVerifyResult<WebLoadUrlRewritePayload> verifyLoadUrl(WebView webView, WebLoadUrlParams params) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(params, "params");
        getViewContext$anniex_release().recordUrlInfo(params, null);
        Pair<WebLoadUrlParams, AspectVerifyResult<?>> lastCheckHttpUrlInfo = getViewContext$anniex_release().getLastCheckHttpUrlInfo();
        if (lastCheckHttpUrlInfo != null) {
            WebLoadUrlParams webLoadUrlParams = (WebLoadUrlParams) lastCheckHttpUrlInfo.component1();
            if (Intrinsics.areEqual(webLoadUrlParams.getOriginUrl(), params.getOriginUrl())) {
                Map<String, String> requestHeaders = params.getRequestHeaders();
                if ((requestHeaders == null || requestHeaders.isEmpty()) || Intrinsics.areEqual(webLoadUrlParams.getRequestHeaders(), params.getRequestHeaders())) {
                    return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusWebLoadVerifyReason.HAS_TRIGGER_CHECK, null, null, 6, null);
                }
            }
        }
        if (Intrinsics.areEqual(getViewContext$anniex_release().getReloadUrl(), params.getOriginUrl())) {
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusWebLoadVerifyReason.RELOAD_SEC_URL, null, null, 6, null);
        }
        return innerVerifyLoadUrl(webView, params);
    }

    /* JADX WARN: Type inference failed for: r1v20, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    private final AspectVerifyResult<WebLoadUrlRewritePayload> innerVerifyLoadUrl(WebView webView, WebLoadUrlParams params) {
        ArgusWebViewAspect argusWebViewAspect = ArgusWebViewAspect.LOAD_URL;
        BaseEventCenter.VerifyHandler<PARAMS, REWRITE_PAYLOAD> initVerifyHandler$anniex_release = initVerifyHandler$anniex_release(argusWebViewAspect, params);
        initVerifyHandler$anniex_release.getContext().setUseAsync(false);
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = initVerifyHandler$anniex_release.getContext();
        initVerifyHandler$anniex_release.getVerifyResult();
        if (params.getIsEntryUrl()) {
            BuildersKt.launch$default(getEventCenter$anniex_release().getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new ArgusWebDelegate$innerVerifyLoadUrl$finalResult$1$1$1(this, params, null), 3, (Object) null);
            getEventCenter$anniex_release().awaitEvent(ArgusContainerAspect.CONTAINER_CREATED);
        }
        if (!isHighRiskScene()) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Deferred<?> async$default = BuildersKt.async$default(getEventCenter$anniex_release().getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new C1158x6729853(initVerifyHandler$anniex_release, webView, params, this, objectRef, context, null), 3, (Object) null);
            initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
            calculate$anniex_release(context);
            WebLoadUrlRewritePayload webLoadUrlRewritePayload = (WebLoadUrlRewritePayload) context.getVerifyResult().getRewritePayload();
            objectRef.element = webLoadUrlRewritePayload != null ? webLoadUrlRewritePayload.getSecLinkScene() : null;
            initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
            if (initVerifyHandler$anniex_release.getVerifyResult().getHasSetRealResult()) {
                initVerifyHandler$anniex_release.setAsyncReportAwaitTask(async$default);
                context.getVerifyResult().addExtra("service_async", "1");
            } else {
                CommonUtils.INSTANCE.safelyAwait(async$default);
            }
        } else {
            Iterator<IArgusWebSecureService> it = ArgusServiceManager.INSTANCE.getInstance().getWebServiceList().iterator();
            while (it.hasNext()) {
                IArgusWebSecureService next = it.next();
                String serviceName = next.serviceName();
                initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.START, serviceName);
                Intrinsics.checkNotNullExpressionValue(next, "service");
                next.verifyLoadUrl(webView, params.getOriginUrl(), initVerifyHandler$anniex_release.getVerifyResult());
                AspectContext.recordVerifyResult$default(initVerifyHandler$anniex_release.getContext(), serviceName, initVerifyHandler$anniex_release.getVerifyResult().toString(), null, 4, null);
                initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.END, serviceName);
                if (initVerifyHandler$anniex_release.getVerifyResult().isBlock()) {
                    break;
                }
            }
            initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
            calculate$anniex_release(context);
            initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
        }
        if (!initVerifyHandler$anniex_release.getVerifyResult().isBlock()) {
            if (params.getIsHttp()) {
                Function0<String> usePluginVerifyLoadUrl = ArgusWebDefaultDelegateKt.usePluginVerifyLoadUrl(this, context);
                if (usePluginVerifyLoadUrl != null) {
                    ((BaseEventCenter.VerifyHandler) initVerifyHandler$anniex_release).reportAwaitTask.add(BuildersKt.async$default(((BaseEventCenter.VerifyHandler) initVerifyHandler$anniex_release).this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new C1152x2575f0ee(null, usePluginVerifyLoadUrl, this), 3, (Object) null));
                }
            } else if (params.getReservedProtocol() || StringsKt.contains$default(params.getLoadUrl(), "    window.reactId = ", false, 2, (Object) null)) {
                context.getReportParams().setReportPlatform(ArgusReportPlatform.NONE);
            }
        }
        CopyOnWriteArrayList<IArgusWebSecureService> webServiceList = ArgusServiceManager.INSTANCE.getInstance().getWebServiceList();
        if (!webServiceList.isEmpty()) {
            ((BaseEventCenter.VerifyHandler) initVerifyHandler$anniex_release).reportAwaitTask.add(BuildersKt.async$default(((BaseEventCenter.VerifyHandler) initVerifyHandler$anniex_release).this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new C1151xbbf99035(null, webServiceList, this, argusWebViewAspect, initVerifyHandler$anniex_release), 3, (Object) null));
        }
        initVerifyHandler$anniex_release.getVerifyResult().addExtra("view_class", getViewContext$anniex_release().getViewClassName());
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        initVerifyHandler$anniex_release.executeReportTask(null);
        AspectVerifyResult<WebLoadUrlRewritePayload> verifyResult = initVerifyHandler$anniex_release.getVerifyResult();
        getViewContext$anniex_release().recordUrlInfo(params, verifyResult);
        return verifyResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ae  */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    /* JADX WARN: Type inference failed for: r1v46, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    @Override // com.bytedance.ies.argus.api.interfaces.IArgusWebAspect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AspectVerifyResult<WebLoadUrlRewritePayload> verifyShouldOverrideUrlLoading(WebView webView, WebLoadUrlParams params) {
        Function0<String> usePluginVerifyLoadUrl;
        boolean z;
        Pair<WebLoadUrlParams, AspectVerifyResult<?>> lastCheckHttpUrlInfo;
        WebLoadUrlParams webLoadUrlParams;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(params, "params");
        ArgusWebViewAspect argusWebViewAspect = ArgusWebViewAspect.WEB_REDIRECT;
        WebLoadUrlParams lastLoadHttpUrlInfo = getViewContext$anniex_release().getLastLoadHttpUrlInfo();
        Boolean valueOf = lastLoadHttpUrlInfo != null ? Boolean.valueOf(lastLoadHttpUrlInfo.isSecLinkPage()) : null;
        getViewContext$anniex_release().recordUrlInfo(params, null);
        if (Intrinsics.areEqual(valueOf, true) && (lastCheckHttpUrlInfo = getViewContext$anniex_release().getLastCheckHttpUrlInfo()) != null && (webLoadUrlParams = (WebLoadUrlParams) lastCheckHttpUrlInfo.getFirst()) != null && (webLoadUrlParams.isSecLinkPage() || webLoadUrlParams.getPageType() == WebLoadPageType.GREY_SEC_LINK)) {
            params.updateWebLoadVerifyResult$anniex_release(WebLoadVerifySource.SecLink, WebLoadRiskTag.ShowRiskGrey, WebLoadPageType.GREY_SEC_LINK);
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusWebLoadVerifyReason.REDIRECT_LAST_URL_IS_SEC_LINK_PAGE, null, null, 6, null);
        }
        BaseEventCenter.VerifyHandler<PARAMS, REWRITE_PAYLOAD> initVerifyHandler$anniex_release = initVerifyHandler$anniex_release(argusWebViewAspect, params);
        initVerifyHandler$anniex_release.getContext().setUseAsync(false);
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = initVerifyHandler$anniex_release.getContext();
        initVerifyHandler$anniex_release.getVerifyResult();
        if (!isHighRiskScene()) {
            Deferred<?> async$default = BuildersKt.async$default(getEventCenter$anniex_release().getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new C1159xd4289448(initVerifyHandler$anniex_release, webView, params, null), 3, (Object) null);
            initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
            calculate$anniex_release(context);
            initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
            if (initVerifyHandler$anniex_release.getVerifyResult().getHasSetRealResult()) {
                initVerifyHandler$anniex_release.setAsyncReportAwaitTask(async$default);
                context.getVerifyResult().addExtra("service_async", "1");
            } else {
                CommonUtils.INSTANCE.safelyAwait(async$default);
            }
        } else {
            Iterator<IArgusWebSecureService> it = ArgusServiceManager.INSTANCE.getInstance().getWebServiceList().iterator();
            while (it.hasNext()) {
                IArgusWebSecureService next = it.next();
                String serviceName = next.serviceName();
                initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.START, serviceName);
                Intrinsics.checkNotNullExpressionValue(next, "service");
                next.verifyShouldOverrideUrlLoading(webView, params.getOriginUrl(), initVerifyHandler$anniex_release.getVerifyResult());
                AspectContext.recordVerifyResult$default(initVerifyHandler$anniex_release.getContext(), serviceName, initVerifyHandler$anniex_release.getVerifyResult().toString(), null, 4, null);
                initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.END, serviceName);
                if (initVerifyHandler$anniex_release.getVerifyResult().isBlock()) {
                    break;
                }
            }
            initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
            calculate$anniex_release(context);
            initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
        }
        if (initVerifyHandler$anniex_release.getVerifyResult().isBlock()) {
            WebLoadUrlRewritePayload webLoadUrlRewritePayload = (WebLoadUrlRewritePayload) initVerifyHandler$anniex_release.getVerifyResult().getRewritePayload();
            String url = webLoadUrlRewritePayload != null ? webLoadUrlRewritePayload.getUrl() : null;
            if (url != null) {
                if (url.length() > 0) {
                    z = true;
                    if (!z) {
                        ArgusWebDefaultDelegateKt.reloadMiddlePageInMain$default(this, url, null, 2, null);
                    } else {
                        ArgusWebDefaultDelegateKt.showBlockToast(this, "命中安全拦截", "检测到跳转存在安全风险，已被拦截: " + params.getOriginUrl());
                    }
                }
            }
            z = false;
            if (!z) {
            }
        } else if (params.getIsHttp() && (usePluginVerifyLoadUrl = ArgusWebDefaultDelegateKt.usePluginVerifyLoadUrl(this, context)) != null) {
            ((BaseEventCenter.VerifyHandler) initVerifyHandler$anniex_release).reportAwaitTask.add(BuildersKt.async$default(((BaseEventCenter.VerifyHandler) initVerifyHandler$anniex_release).this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new C1157xebdbfa10(null, usePluginVerifyLoadUrl, this), 3, (Object) null));
        }
        CopyOnWriteArrayList<IArgusWebSecureService> webServiceList = ArgusServiceManager.INSTANCE.getInstance().getWebServiceList();
        if (!webServiceList.isEmpty()) {
            ((BaseEventCenter.VerifyHandler) initVerifyHandler$anniex_release).reportAwaitTask.add(BuildersKt.async$default(((BaseEventCenter.VerifyHandler) initVerifyHandler$anniex_release).this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new C1156xbcf7c2e8(null, webServiceList, this, argusWebViewAspect, initVerifyHandler$anniex_release), 3, (Object) null));
        }
        if (params.getReservedProtocol()) {
            context.getReportParams().setReportPlatform(ArgusReportPlatform.NONE);
        }
        initVerifyHandler$anniex_release.getVerifyResult().addExtra("view_class", getViewContext$anniex_release().getViewClassName());
        initVerifyHandler$anniex_release.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        initVerifyHandler$anniex_release.executeReportTask(null);
        AspectVerifyResult<WebLoadUrlRewritePayload> verifyResult = initVerifyHandler$anniex_release.getVerifyResult();
        getViewContext$anniex_release().recordUrlInfo(params, verifyResult);
        return verifyResult;
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusWebAspect
    public AspectVerifyResult verifyCanGoBack(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return ArgusWebDefaultDelegateKt.innerVerifyCanGoBack(this);
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusWebAspect
    public AspectVerifyResult handleGoBack(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        return ArgusWebDefaultDelegateKt.innerHandleGoBack(this);
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    @Override // com.bytedance.ies.argus.api.interfaces.IArgusWebAspect
    public AspectVerifyResult<ArgusWebResourceRequestRewritePayload> verifyShouldInterceptRequest(WebView webView, ArgusWebResourceRequestParams params) {
        ArgusWebResourceRequestRewritePayload argusWebResourceRequestRewritePayload;
        Intrinsics.checkNotNullParameter(params, "params");
        if (isHighRiskScene() && !params.getCanIgnoreVerify$anniex_release()) {
            WebLoadUrlParams lastLoadHttpUrlInfo = getViewContext$anniex_release().getLastLoadHttpUrlInfo();
            params.setViewUrl$anniex_release(lastLoadHttpUrlInfo != null ? lastLoadHttpUrlInfo.getOriginUrl() : null);
            BaseEventCenter.VerifyHandler updateDefaultReportPlatform = initVerifyHandler$anniex_release(ArgusWebViewAspect.SHOULD_INTERCEPT_REQUEST, params).updateDefaultReportPlatform(ArgusReportPlatform.ALL);
            updateDefaultReportPlatform.getContext().setUseAsync(false);
            updateDefaultReportPlatform.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
            AspectContext<?, ?> context = updateDefaultReportPlatform.getContext();
            AspectVerifyResult verifyResult = updateDefaultReportPlatform.getVerifyResult();
            calculate$anniex_release(context);
            if (verifyResult.isBlock() && (argusWebResourceRequestRewritePayload = (ArgusWebResourceRequestRewritePayload) verifyResult.getRewritePayload()) != null) {
                argusWebResourceRequestRewritePayload.setResponse(ArgusWebDefaultDelegateKt.createBlockResponse(this));
            }
            updateDefaultReportPlatform.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
            updateDefaultReportPlatform.executeReportTask(null);
            return updateDefaultReportPlatform.getVerifyResult();
        }
        return new AspectVerifyResult<>(null, null, 3, null);
    }

    public final void transmitJsbAuthResult(BaseBridgeCall<JSONObject> bridgeCall, final AuthResult authResult) {
        Intrinsics.checkNotNullParameter(bridgeCall, "bridgeCall");
        Intrinsics.checkNotNullParameter(authResult, "authResult");
        if (isHighRiskScene()) {
            String methodName = bridgeCall.getMethodName();
            AuthBridgeAccess methodAuthType = authResult.getMethodAuthType();
            if (methodAuthType == null) {
                methodAuthType = AuthBridgeAccess.UNKNOWN;
            }
            AspectContext aspectContext = new AspectContext(ArgusContainerAspect.JSB_CALL, new JSBCallParams(methodName, methodAuthType, bridgeCall.getNamespace(), ArgusContainerType.WEB, bridgeCall.getAuthUrl()));
            ArgusReportParams reportParams = aspectContext.getReportParams();
            reportParams.setReportPlatform(ArgusReportPlatform.ONLY_TEA);
            reportParams.setAddReportDataBlock(new Function0<JSONObject>() { // from class: com.bytedance.ies.argus.api.ArgusWebDelegate$transmitJsbAuthResult$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final JSONObject invoke() {
                    JSONObject jSONObject = new JSONObject();
                    AuthResult authResult2 = authResult;
                    JSONUtilsKt.safelyPut(jSONObject, "auth_result", Boolean.valueOf(authResult2.getPassed()));
                    JSONUtilsKt.safelyPut(jSONObject, "auth_code", Integer.valueOf(authResult2.getAuthCode()));
                    JSONUtilsKt.safelyPut(jSONObject, "fe_id", authResult2.getAuthFeId());
                    JSONUtilsKt.safelyPut(jSONObject, "auth_url", authResult2.getAuthUrl());
                    JSONUtilsKt.safelyPut(jSONObject, "request_trackings", authResult2.getRequestTrackings());
                    return jSONObject;
                }
            });
            ArgusWebDefaultDelegateKt.triggerAsyncReport(this, aspectContext);
        }
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusViewAspect
    public AspectVerifyResult<JSBCallRewritePayload> verifyJSBCall(JSBCallParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return new AspectVerifyResult<>(null, null, 3, null);
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusViewAspect
    public void monitorViewDestroy() {
        super.onViewDestroy();
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusWebAspect
    public void monitorOnMotionEvent(ArgusMotionEventParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        params.setPageInfo(getViewContext$anniex_release().getMainPageInfo());
        BaseEventCenter.VerifyHandler updateDefaultReportPlatform = initVerifyHandler$anniex_release(ArgusGlobalAspect.MOTION_ON_TOUCH, params).updateDefaultReportPlatform(ArgusReportPlatform.NONE);
        updateDefaultReportPlatform.getContext().setUseAsync(false);
        updateDefaultReportPlatform.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> context = updateDefaultReportPlatform.getContext();
        updateDefaultReportPlatform.getVerifyResult();
        calculate$anniex_release(context);
        updateDefaultReportPlatform.getContext().recordCost(AspectContext.Companion.TraceType.ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, null);
        updateDefaultReportPlatform.executeReportTask(null);
        updateDefaultReportPlatform.getVerifyResult();
    }

    @Override // com.bytedance.ies.argus.api.interfaces.IArgusWebAspect
    public AspectVerifyResult<ArgusOnWebViewCreatedRewritePayload> verifyOnWebViewCreated(ArgusOnWebViewCreatedParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BaseEventCenter.VerifyHandler<PARAMS, REWRITE_PAYLOAD> initVerifyHandler$anniex_release = initVerifyHandler$anniex_release(ArgusWebViewAspect.ON_WEBVIEW_CREATED, params);
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
