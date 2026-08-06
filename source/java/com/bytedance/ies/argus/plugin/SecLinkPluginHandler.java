package com.bytedance.ies.argus.plugin;

import android.webkit.WebView;
import com.bytedance.ies.argus.api.params.WebLoadPageType;
import com.bytedance.ies.argus.api.params.WebLoadRiskTag;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.api.params.WebLoadVerifySource;
import com.bytedance.ies.argus.aspect.eventCenter.WebViewContext;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusSwitch;
import com.bytedance.ies.argus.bean.ArgusWebLoadVerifyReason;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.webx.seclink.SecLinkFacade;
import com.bytedance.webx.seclink.base.ISecLinkStrategy;
import com.bytedance.webx.seclink.base.SecLinkCheckCallback;
import com.bytedance.webx.seclink.config.AppSecConfig;
import com.bytedance.webx.seclink.request.CheckUrlResponse;
import com.bytedance.webx.seclink.util.SecLinkHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: SecLinkPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00050\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cJ8\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0016\u0010$\u001a\u00120%R\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cR\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006'"}, d2 = {"Lcom/bytedance/ies/argus/plugin/SecLinkPluginHandler;", "Lcom/bytedance/ies/argus/plugin/ISecurePluginHandler;", "type", "Lcom/bytedance/ies/argus/plugin/SecurePluginType;", "cId", "", "(Lcom/bytedance/ies/argus/plugin/SecurePluginType;Ljava/lang/String;)V", "config", "Lcom/bytedance/ies/argus/plugin/SecLinkPluginConfig;", "getConfig", "()Lcom/bytedance/ies/argus/plugin/SecLinkPluginConfig;", "config$delegate", "Lkotlin/Lazy;", "defaultScene", "defaultVerifyMode", "", "Ljava/lang/Integer;", "buildSecLinkMiddlePage", "url", "scene", "shouldUseSync", "", "aspect", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "shouldVerify", "Lkotlin/Pair;", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlParams;", "Lcom/bytedance/ies/argus/api/params/WebLoadUrlRewritePayload;", "verifyShouldReloadUrl", "buildMiddlePage", "checkScene", "viewContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/WebViewContext;", "calculateContext", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SecLinkPluginHandler extends ISecurePluginHandler {
    public static final String BIZ_TAG = "argus";
    public static final int DEFAULT_BLACK_RISK_LEVEL = 9;
    public static final int DEFAULT_SEC_LINK_GRADE = 0;

    /* renamed from: config$delegate, reason: from kotlin metadata */
    private final Lazy config;
    private final String defaultScene;
    private final Integer defaultVerifyMode;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<String> secLinkHost$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.argus.plugin.SecLinkPluginHandler$Companion$secLinkHost$2
        public final String invoke() {
            String initSecLinkHost;
            initSecLinkHost = SecLinkPluginHandler.INSTANCE.initSecLinkHost();
            if (initSecLinkHost != null) {
                if (initSecLinkHost.length() > 0) {
                    return initSecLinkHost;
                }
            }
            return null;
        }
    });

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecLinkPluginHandler(SecurePluginType securePluginType, final String str) {
        super(securePluginType, str);
        Intrinsics.checkNotNullParameter(securePluginType, "type");
        this.config = LazyKt.lazy(new Function0<SecLinkPluginConfig>() { // from class: com.bytedance.ies.argus.plugin.SecLinkPluginHandler$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SecLinkPluginConfig m615invoke() {
                SecLinkPluginConfig secLink;
                ContainerPluginConf containerConfig = PluginManager.INSTANCE.getInstance().getContainerConfig(str);
                return (containerConfig == null || (secLink = containerConfig.getSecLink()) == null) ? new SecLinkPluginConfig(null, null, null, false, false, 31, null) : secLink;
            }
        });
        this.defaultScene = getConfig().getCheckScene();
        this.defaultVerifyMode = getConfig().getVerifyMode();
    }

    private final SecLinkPluginConfig getConfig() {
        return (SecLinkPluginConfig) this.config.getValue();
    }

    public final Pair<ArgusSwitch, String> shouldVerify(AspectContext<WebLoadUrlParams, WebLoadUrlRewritePayload> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WebLoadUrlParams callerParams = context.getCallerParams();
        String secLinkScene = callerParams.getSecLinkScene();
        if (secLinkScene == null) {
            secLinkScene = this.defaultScene;
        }
        if (secLinkScene != null) {
            ArgusSwitch secLinkCheckMode = callerParams.getSecLinkCheckMode();
            if (secLinkCheckMode == null) {
                secLinkCheckMode = new ArgusSwitch(this.defaultVerifyMode);
            }
            return new Pair<>(secLinkCheckMode, secLinkScene);
        }
        return new Pair<>(new ArgusSwitch(0), "");
    }

    public final boolean shouldUseSync(IArgusAspect aspect) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        if (aspect == ArgusWebViewAspect.LOAD_URL) {
            return getConfig().getFirstUseSync();
        }
        if (aspect == ArgusWebViewAspect.WEB_REDIRECT) {
            return getConfig().getRedirectUseSync();
        }
        return false;
    }

    public final String verifyShouldReloadUrl(boolean buildMiddlePage, final String checkScene, WebViewContext viewContext, AspectContext<WebLoadUrlParams, WebLoadUrlRewritePayload>.CalculateContext calculateContext) {
        WebView view;
        Integer firstLoadMaxRiskLevel;
        Integer redirectMaxRiskLevel;
        SecLinkCheckCallback secLinkCheckCallback;
        Intrinsics.checkNotNullParameter(checkScene, "checkScene");
        Intrinsics.checkNotNullParameter(viewContext, "viewContext");
        Intrinsics.checkNotNullParameter(calculateContext, "calculateContext");
        WebLoadUrlParams callerParams = calculateContext.getCallerParams();
        Pair<ISecLinkStrategy, String> secLinkStrategy = viewContext.getSecLinkStrategy();
        if ((secLinkStrategy == null || !Intrinsics.areEqual(secLinkStrategy.getSecond(), checkScene)) && (view = viewContext.getView()) != null) {
            viewContext.setSecLinkStrategy(new Pair<>(SecLinkFacade.generateAsyncStrategy(view, checkScene), checkScene));
        }
        AspectVerifyResult<WebLoadUrlRewritePayload> verifyResult = calculateContext.getVerifyResult();
        final String loadUrl = callerParams.getLoadUrl();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (buildMiddlePage) {
            AspectVerifyResult.onRewrite$default(verifyResult, ArgusWebLoadVerifyReason.REWRITE_BY_SEC_LINK, "use sync", null, new Function1<WebLoadUrlRewritePayload, Unit>() { // from class: com.bytedance.ies.argus.plugin.SecLinkPluginHandler$verifyShouldReloadUrl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((WebLoadUrlRewritePayload) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(WebLoadUrlRewritePayload webLoadUrlRewritePayload) {
                    String buildSecLinkMiddlePage;
                    Intrinsics.checkNotNullParameter(webLoadUrlRewritePayload, "rewritePayload");
                    Ref.ObjectRef<String> objectRef2 = objectRef;
                    buildSecLinkMiddlePage = this.buildSecLinkMiddlePage(loadUrl, checkScene);
                    objectRef2.element = buildSecLinkMiddlePage;
                    webLoadUrlRewritePayload.setUrl((String) objectRef.element);
                }
            }, 4, null);
        } else {
            CheckUrlResponse checkUrlResponse = (CheckUrlResponse) SecLinkHelper.checkUrlSafely(loadUrl, checkScene, 0, true, BIZ_TAG).get();
            WebLoadUrlRewritePayload rewritePayload = verifyResult.getRewritePayload();
            if (rewritePayload != null && (secLinkCheckCallback = rewritePayload.getSecLinkCheckCallback()) != null) {
                secLinkCheckCallback.onGetSecLinkCheckResult(viewContext.getView(), checkUrlResponse);
            }
            int i = -1;
            boolean z = checkUrlResponse.isNeedShowPage() || (calculateContext.getCallingAspect() != ArgusWebViewAspect.WEB_REDIRECT ? !((firstLoadMaxRiskLevel = getConfig().getFirstLoadMaxRiskLevel()) == null || checkUrlResponse.getRisk() <= (i = firstLoadMaxRiskLevel.intValue())) : !((redirectMaxRiskLevel = getConfig().getRedirectMaxRiskLevel()) == null || checkUrlResponse.getRisk() <= (i = redirectMaxRiskLevel.intValue())));
            verifyResult.addExtra("seclink_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("checkScene", checkScene), TuplesKt.to("intercept", Boolean.valueOf(z)), TuplesKt.to("isNeedShowPage", Boolean.valueOf(checkUrlResponse.isNeedShowPage())), TuplesKt.to("level", Integer.valueOf(checkUrlResponse.getRisk())), TuplesKt.to("limitLevel", Integer.valueOf(i))}));
            if (z) {
                AspectVerifyResult.onRewrite$default(verifyResult, ArgusWebLoadVerifyReason.REWRITE_BY_SEC_LINK, "use async,needShow=" + checkUrlResponse.isNeedShowPage() + ",limit=" + i + ",server=" + checkUrlResponse.getRisk(), null, new Function1<WebLoadUrlRewritePayload, Unit>() { // from class: com.bytedance.ies.argus.plugin.SecLinkPluginHandler$verifyShouldReloadUrl$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((WebLoadUrlRewritePayload) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(WebLoadUrlRewritePayload webLoadUrlRewritePayload) {
                        String buildSecLinkMiddlePage;
                        Intrinsics.checkNotNullParameter(webLoadUrlRewritePayload, "rewritePayload");
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        buildSecLinkMiddlePage = this.buildSecLinkMiddlePage(loadUrl, checkScene);
                        objectRef2.element = buildSecLinkMiddlePage;
                        webLoadUrlRewritePayload.setUrl((String) objectRef.element);
                    }
                }, 4, null);
                if (checkUrlResponse.getRisk() == 9) {
                    WebLoadUrlParams.updateWebLoadVerifyResult$anniex_release$default(callerParams, WebLoadVerifySource.SecLink, WebLoadRiskTag.ShowRiskBlack, null, 4, null);
                } else {
                    callerParams.updateWebLoadVerifyResult$anniex_release(WebLoadVerifySource.SecLink, WebLoadRiskTag.ShowRiskGrey, WebLoadPageType.GREY_SEC_LINK);
                }
            } else {
                AspectVerifyResult.onPass$default(verifyResult, ArgusWebLoadVerifyReason.PASS_BY_SEC_LINK_SERVER, null, null, 6, null);
                WebLoadUrlParams.updateWebLoadVerifyResult$anniex_release$default(callerParams, WebLoadVerifySource.SecLink, WebLoadRiskTag.PassPluginVerify, null, 4, null);
            }
        }
        return (String) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildSecLinkMiddlePage(String url, String scene) {
        String buildSecLink = SecLinkHelper.buildSecLink(url, scene, BIZ_TAG);
        Intrinsics.checkNotNullExpressionValue(buildSecLink, "buildSecLink(\n          …        BIZ_TAG\n        )");
        return buildSecLink;
    }

    /* compiled from: SecLinkPlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/plugin/SecLinkPluginHandler$Companion;", "", "()V", "BIZ_TAG", "", "DEFAULT_BLACK_RISK_LEVEL", "", "DEFAULT_SEC_LINK_GRADE", "secLinkHost", "getSecLinkHost", "()Ljava/lang/String;", "secLinkHost$delegate", "Lkotlin/Lazy;", "initSecLinkHost", "isSecLinkPage", "", "url", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getSecLinkHost() {
            return (String) SecLinkPluginHandler.secLinkHost$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String initSecLinkHost() {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                String verifyHost = SecLinkFacade.getVerifyHost();
                if (verifyHost == null) {
                    AppSecConfig linkConfig = SecLinkFacade.getLinkConfig();
                    verifyHost = linkConfig != null ? linkConfig.getHost() : null;
                }
                obj = Result.constructor-impl(verifyHost);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return (String) (Result.isFailure-impl(obj) ? null : obj);
        }

        public final boolean isSecLinkPage(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            try {
                String secLinkHost = getSecLinkHost();
                if (secLinkHost != null) {
                    return StringsKt.startsWith$default(url, secLinkHost, false, 2, (Object) null);
                }
                return false;
            } catch (Exception e) {
                ArgusLog.e$default(ArgusLog.INSTANCE, SecLinkPlugin.TAG, "get seclink host error: " + e, null, null, 12, null);
                return false;
            }
        }
    }
}
