package com.bytedance.ies.argus.aspect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.base.ArgusMonitor;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusFeId;
import com.bytedance.ies.argus.bean.ArgusSwitch;
import com.bytedance.ies.argus.bean.ArgusWebLoadVerifyReason;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.plugin.SecLinkPluginHandler;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigV1Bean;
import com.bytedance.webx.seclink.base.ISecLinkStrategy;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusWebDefaultDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0016\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006*\u00020\u0002H\u0000\u001a\u0016\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006*\u00020\u0002H\u0000\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a,\u0010\f\u001a\u00020\t*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0000\u001a\u001c\u0010\u0011\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0000\u001a\u001c\u0010\u0014\u001a\u00020\t*\u00020\u00022\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0016H\u0000\u001a*\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0018*\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00190\u0016H\u0000¨\u0006\u001a"}, d2 = {"createBlockResponse", "Landroid/webkit/WebResourceResponse;", "Lcom/bytedance/ies/argus/api/ArgusWebDelegate;", "innerHandleGoBack", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "", "Lcom/bytedance/ies/argus/bean/AspectVerifyResultWithoutRewrite;", "innerVerifyCanGoBack", "matchPageFeId", "", "params", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams;", "reloadMiddlePageInMain", "url", "", "additionalHeaders", "", "showBlockToast", "title", "msg", "triggerAsyncReport", "context", "Lcom/bytedance/ies/argus/bean/AspectContext;", "usePluginVerifyLoadUrl", "Lkotlin/Function0;", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlRewritePayload;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusWebDefaultDelegateKt {
    public static /* synthetic */ void reloadMiddlePageInMain$default(ArgusWebDelegate argusWebDelegate, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        reloadMiddlePageInMain(argusWebDelegate, str, map);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    public static final void reloadMiddlePageInMain(ArgusWebDelegate argusWebDelegate, final String str, final Map<String, String> map) {
        Intrinsics.checkNotNullParameter(argusWebDelegate, "<this>");
        Intrinsics.checkNotNullParameter(str, "url");
        if (Intrinsics.areEqual(argusWebDelegate.getViewContext$anniex_release().getReloadUrl(), str)) {
            return;
        }
        argusWebDelegate.getViewContext$anniex_release().setReloadUrl(str);
        final WebView view = argusWebDelegate.getViewContext$anniex_release().getView();
        if (view != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ies.argus.aspect.ArgusWebDefaultDelegateKt$reloadMiddlePageInMain$1$1
                @Override // java.lang.Runnable
                public final void run() {
                    view.stopLoading();
                    Map<String, String> map2 = map;
                    if (map2 == null) {
                        view.loadUrl(str);
                    } else {
                        view.loadUrl(str, map2);
                    }
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    public static final AspectVerifyResult innerVerifyCanGoBack(ArgusWebDelegate argusWebDelegate) {
        ISecLinkStrategy iSecLinkStrategy;
        Intrinsics.checkNotNullParameter(argusWebDelegate, "<this>");
        Pair<ISecLinkStrategy, String> secLinkStrategy = argusWebDelegate.getViewContext$anniex_release().getSecLinkStrategy();
        if (secLinkStrategy != null && (iSecLinkStrategy = (ISecLinkStrategy) secLinkStrategy.getFirst()) != null) {
            if (iSecLinkStrategy.canGoBack()) {
                return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusCommonVerifyReason.PASS_BY_SEC_LINK_HANDLE, null, null, 6, null);
            }
            return AspectVerifyResult.onBlock$default(new AspectVerifyResult(null, null, 3, null), ArgusCommonVerifyReason.BLOCK_BY_SEC_LINK_HANDLE, null, null, 6, null);
        }
        return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusCommonVerifyReason.SEC_LINK_STRATEGY_IS_NULL, null, null, 6, null);
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    public static final AspectVerifyResult innerHandleGoBack(ArgusWebDelegate argusWebDelegate) {
        ISecLinkStrategy iSecLinkStrategy;
        Intrinsics.checkNotNullParameter(argusWebDelegate, "<this>");
        Pair<ISecLinkStrategy, String> secLinkStrategy = argusWebDelegate.getViewContext$anniex_release().getSecLinkStrategy();
        if (secLinkStrategy != null && (iSecLinkStrategy = (ISecLinkStrategy) secLinkStrategy.getFirst()) != null) {
            if (iSecLinkStrategy.handleGoBack()) {
                return AspectVerifyResult.onBlock$default(new AspectVerifyResult(null, null, 3, null), ArgusCommonVerifyReason.BLOCK_BY_SEC_LINK_HANDLE, null, null, 6, null);
            }
            return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusCommonVerifyReason.PASS_BY_SEC_LINK_HANDLE, null, null, 6, null);
        }
        return AspectVerifyResult.onPass$default(new AspectVerifyResult(null, null, 3, null), ArgusCommonVerifyReason.SEC_LINK_STRATEGY_IS_NULL, null, null, 6, null);
    }

    public static final Function0<String> usePluginVerifyLoadUrl(final ArgusWebDelegate argusWebDelegate, final AspectContext<WebLoadUrlParams, WebLoadUrlRewritePayload> aspectContext) {
        Intrinsics.checkNotNullParameter(argusWebDelegate, "<this>");
        Intrinsics.checkNotNullParameter(aspectContext, "context");
        SecLinkPluginHandler secLinkHandler$anniex_release = argusWebDelegate.getSecLinkHandler$anniex_release();
        if (secLinkHandler$anniex_release == null) {
            AspectVerifyResult.onError$default(aspectContext.getVerifyResult(), ArgusWebLoadVerifyReason.SEC_LINK_HANDLER_IS_NULL, null, null, 6, null);
        } else {
            Pair<ArgusSwitch, String> shouldVerify = secLinkHandler$anniex_release.shouldVerify(aspectContext);
            final ArgusSwitch argusSwitch = (ArgusSwitch) shouldVerify.component1();
            final String str = (String) shouldVerify.component2();
            if (argusSwitch.getEnable()) {
                boolean z = !aspectContext.getUseAsync() && secLinkHandler$anniex_release.shouldUseSync(aspectContext.getCallingAspect());
                final boolean z2 = z;
                Function0<String> function0 = new Function0<String>() { // from class: com.bytedance.ies.argus.aspect.ArgusWebDefaultDelegateKt$usePluginVerifyLoadUrl$verifyBlock$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r5v10, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
                    public final String invoke() {
                        String str2;
                        AspectContext.CalculateContext calculateContext = new AspectContext.CalculateContext(aspectContext, argusSwitch);
                        AspectContext.Companion.TraceType traceType = AspectContext.Companion.TraceType.PLUGIN_VERIFY;
                        SecLinkPluginHandler secLinkHandler$anniex_release2 = argusWebDelegate.getSecLinkHandler$anniex_release();
                        if (secLinkHandler$anniex_release2 == null || (str2 = secLinkHandler$anniex_release2.getPluginName()) == null) {
                            str2 = "";
                        }
                        ArgusWebDelegate argusWebDelegate2 = argusWebDelegate;
                        boolean z3 = z2;
                        String str3 = str;
                        calculateContext.this$0.recordCost(traceType, AspectContext.Companion.TraceStage.START, str2);
                        try {
                            try {
                                SecLinkPluginHandler secLinkHandler$anniex_release3 = argusWebDelegate2.getSecLinkHandler$anniex_release();
                                r8 = secLinkHandler$anniex_release3 != 0 ? secLinkHandler$anniex_release3.verifyShouldReloadUrl(z3, str3, argusWebDelegate2.getViewContext$anniex_release(), calculateContext) : null;
                                calculateContext.this$0.recordVerifyResult(str2, calculateContext.getVerifyResult().toString(), calculateContext.getMode());
                                if (calculateContext.getVerifyResult().isPass() && calculateContext.getVerifyResult().isReasonCodeUnset()) {
                                    AspectVerifyResult.onPass$default(calculateContext.getVerifyResult(), ArgusCommonVerifyReason.PASS_STRATEGY_CALCULATE, "strategyKey=" + str2, null, 4, null);
                                }
                            } catch (Exception e) {
                                ArgusLog.e$default(ArgusLog.INSTANCE, AspectContext.TAG, "trace ", null, e, 4, null);
                                AspectVerifyResult.onError$default(calculateContext.getVerifyResult(), ArgusCommonVerifyReason.TRY_CATCH_ERROR, e.toString(), null, 4, null);
                            }
                            return r8;
                        } finally {
                            calculateContext.this$0.recordCost(traceType, AspectContext.Companion.TraceStage.END, str2);
                        }
                    }
                };
                if (!z) {
                    return function0;
                }
                function0.invoke();
                return null;
            }
            if (!aspectContext.getCallerParams().isInnerHost$anniex_release()) {
                AspectVerifyResult.onError$default(aspectContext.getVerifyResult(), ArgusWebLoadVerifyReason.SEC_LINK_VERIFY_MODE_NOT_ENABLE, null, null, 6, null);
            }
        }
        return null;
    }

    public static final WebResourceResponse createBlockResponse(ArgusWebDelegate argusWebDelegate) {
        Intrinsics.checkNotNullParameter(argusWebDelegate, "<this>");
        return new WebResourceResponse("text/plain", UrlUtils.UTF_8, 403, "Request forbidden for seucrity reason", MapsKt.mapOf(TuplesKt.to("x-argus", "The request was intercepted because it posed a security risk")), new ByteArrayInputStream(new byte[0]));
    }

    public static final void showBlockToast(ArgusWebDelegate argusWebDelegate, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(argusWebDelegate, "<this>");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "msg");
        final WebView view = argusWebDelegate.getViewContext$anniex_release().getView();
        if (view != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ies.argus.aspect.ArgusWebDefaultDelegateKt$showBlockToast$1$1
                @Override // java.lang.Runnable
                public final void run() {
                    new AlertDialog.Builder(view.getContext()).setTitle(str).setMessage(str2).setPositiveButton("确认", (DialogInterface.OnClickListener) null).show();
                }
            });
        }
    }

    public static final void triggerAsyncReport(ArgusWebDelegate argusWebDelegate, AspectContext<?, ?> aspectContext) {
        Intrinsics.checkNotNullParameter(argusWebDelegate, "<this>");
        Intrinsics.checkNotNullParameter(aspectContext, "context");
        aspectContext.setViewContext$anniex_release(argusWebDelegate.getViewContext$anniex_release());
        ArgusMonitor.INSTANCE.asyncReportAspect(aspectContext);
    }

    public static final void matchPageFeId(ArgusWebDelegate argusWebDelegate, WebLoadUrlParams webLoadUrlParams) {
        Intrinsics.checkNotNullParameter(argusWebDelegate, "<this>");
        Intrinsics.checkNotNullParameter(webLoadUrlParams, "params");
        String loadUrlParentHost = webLoadUrlParams.getLoadUrlParentHost();
        if (loadUrlParentHost != null) {
            Long l = null;
            Iterator it = PermissionConfigV2Parser.getContentAuthConfigBasedHost$default(PermissionConfigV2Parser.INSTANCE, loadUrlParentHost, (String) null, 2, (Object) null).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AuthConfigV1Bean authConfigV1Bean = (AuthConfigV1Bean) it.next();
                Long feId = authConfigV1Bean.getFeId();
                if (feId != null && feId.longValue() > 0 && CommonUtils.INSTANCE.matchReg(webLoadUrlParams.getLoadUrl(), authConfigV1Bean.getPattern())) {
                    l = feId;
                    break;
                }
            }
            webLoadUrlParams.setFeId(l != null ? l.longValue() : ArgusFeId.NOT_MATCH.getLongValue());
        }
    }
}
