package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.api.params.WebLoadPageType;
import com.bytedance.ies.argus.api.params.WebLoadRiskTag;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.api.params.WebLoadVerifySource;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.ArgusSwitch;
import com.bytedance.ies.argus.bean.ArgusWebLoadVerifyReason;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.UrlListVerifyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebLoadStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/WebLoadStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebLoadStrategyProvider extends BaseStrategyProvider {
    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.WebUrlListVerify;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        List<String> redirectBlackProtocol;
        List<String> redirectBlackUrlReg;
        UrlListVerifyHelper.InnerDomainVerifier innerDomainVerifier;
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        final BaseRewritePayload rewritePayload = verifyResult.getRewritePayload();
        if ((callerParams instanceof WebLoadUrlParams) && (rewritePayload instanceof WebLoadUrlRewritePayload)) {
            WebLoadUrlParams webLoadUrlParams = (WebLoadUrlParams) callerParams;
            final String loadUrl = webLoadUrlParams.getLoadUrl();
            final WebLoadConfig webUrlListVerify = strategyConfig != null ? strategyConfig.getWebUrlListVerify() : null;
            List<String> blackUrlReg = webUrlListVerify != null ? webUrlListVerify.getBlackUrlReg() : null;
            if (blackUrlReg != null && (blackUrlReg.isEmpty() ^ true)) {
                List<String> list = blackUrlReg;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (CommonUtils.INSTANCE.matchReg(loadUrl, (String) it.next())) {
                        AspectVerifyResult.onBlock$default(verifyResult, ArgusWebLoadVerifyReason.BLACK_URL_REG, null, new Function1<BaseRewritePayload, Unit>() { // from class: com.bytedance.ies.argus.strategy.provider.client.WebLoadStrategyProvider$calculate$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((BaseRewritePayload) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BaseRewritePayload baseRewritePayload) {
                                String str;
                                String riskInfoPage = WebLoadConfig.this.getRiskInfoPage();
                                if (riskInfoPage != null) {
                                    str = riskInfoPage + "?targetUrl=" + loadUrl;
                                } else {
                                    str = null;
                                }
                                ((WebLoadUrlRewritePayload) rewritePayload).setUrl(str);
                            }
                        }, 2, null);
                        break;
                    }
                    arrayList.add(Unit.INSTANCE);
                }
            }
            if (context.getCallingAspect() == ArgusWebViewAspect.WEB_REDIRECT) {
                if (webUrlListVerify != null && (redirectBlackUrlReg = webUrlListVerify.getRedirectBlackUrlReg()) != null) {
                    List<String> list2 = redirectBlackUrlReg;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (CommonUtils.INSTANCE.matchReg(loadUrl, (String) it2.next())) {
                            AspectVerifyResult.onBlock$default(verifyResult, ArgusWebLoadVerifyReason.BLACK_URL_REG, null, null, 6, null);
                            break;
                        }
                        arrayList2.add(Unit.INSTANCE);
                    }
                }
                String protocol = webLoadUrlParams.getProtocol();
                if (!webLoadUrlParams.getIsHttp() && protocol != null) {
                    if ((webUrlListVerify == null || (redirectBlackProtocol = webUrlListVerify.getRedirectBlackProtocol()) == null || !redirectBlackProtocol.contains(protocol)) ? false : true) {
                        AspectVerifyResult.onBlock$default(verifyResult, ArgusWebLoadVerifyReason.BLACK_PROTOCOL, null, null, 6, null);
                    }
                }
            }
            if (verifyResult.isBlock()) {
                WebLoadUrlParams.updateWebLoadVerifyResult$anniex_release$default(webLoadUrlParams, WebLoadVerifySource.Inner, WebLoadRiskTag.ShowRiskBlack, null, 4, null);
                return;
            }
            if (webLoadUrlParams.getIsHttp()) {
                if (webLoadUrlParams.isSecLinkPage()) {
                    AspectVerifyResult.onPass$default(verifyResult, ArgusWebLoadVerifyReason.ALREADY_SEC_LINK_PAGE, "close secLink", null, 4, null);
                    ((WebLoadUrlRewritePayload) rewritePayload).setSecLinkMode(new ArgusSwitch(0));
                    WebLoadUrlParams.updateWebLoadVerifyResult$anniex_release$default(webLoadUrlParams, WebLoadVerifySource.Extern, WebLoadRiskTag.ShowRiskUnknown, null, 4, null);
                    return;
                }
                final ContainerContext containerContext = context.getContainerContext();
                final String secLinkScene = containerContext != null ? containerContext.getSecLinkScene() : null;
                if (secLinkScene == null) {
                    AspectVerifyResult.onPass$default(verifyResult, ArgusWebLoadVerifyReason.NO_SEC_LINK_SCENE, null, null, 6, null);
                    return;
                }
                AspectVerifyResult.onRewrite$default(verifyResult, ArgusWebLoadVerifyReason.HIT_SEC_LINK_SCENE, secLinkScene, null, new Function1<BaseRewritePayload, Unit>() { // from class: com.bytedance.ies.argus.strategy.provider.client.WebLoadStrategyProvider$calculate$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((BaseRewritePayload) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BaseRewritePayload baseRewritePayload) {
                        ((WebLoadUrlRewritePayload) BaseRewritePayload.this).setSecLinkScene(secLinkScene);
                        ((WebLoadUrlRewritePayload) BaseRewritePayload.this).setSecLinkMode(containerContext.getSecLinkCheckMode());
                    }
                }, 4, null);
                if (webUrlListVerify == null || (innerDomainVerifier = webUrlListVerify.getInnerUrlVerifier()) == null) {
                    innerDomainVerifier = new UrlListVerifyHelper.InnerDomainVerifier();
                }
                if (innerDomainVerifier.verify(webLoadUrlParams.getLoadUrl(), webLoadUrlParams.getLoadUrlHost(), webLoadUrlParams.getLoadUrlParentHost())) {
                    AspectVerifyResult.onPass$default(verifyResult, ArgusWebLoadVerifyReason.WHITE_URL, "close secLink", null, 4, null);
                    ((WebLoadUrlRewritePayload) rewritePayload).setSecLinkMode(new ArgusSwitch(0));
                    webLoadUrlParams.updateWebLoadVerifyResult$anniex_release(WebLoadVerifySource.Inner, WebLoadRiskTag.PassInnerDomain, WebLoadPageType.WHITE_INNER);
                    return;
                }
                return;
            }
            return;
        }
        AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
    }
}
