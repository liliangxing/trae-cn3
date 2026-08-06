package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.api.params.ArgusOnWebViewCreatedParams;
import com.bytedance.ies.argus.api.params.ArgusOnWebViewCreatedRewritePayload;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.ArgusWebViewCSRFUAStrategyVerifyReason;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WebViewCSRFUAStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/WebViewCSRFUAStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebViewCSRFUAStrategyProvider extends BaseStrategyProvider {
    private static final String CSRF_UA = "BytedanceWebview/d8a21c6";
    private static final String TAG = "WebViewCSRFUAStrategyProvider";

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.WebViewCSRFUA;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        final BaseRewritePayload rewritePayload = verifyResult.getRewritePayload();
        if (!(callerParams instanceof ArgusOnWebViewCreatedParams) || !(rewritePayload instanceof ArgusOnWebViewCreatedRewritePayload)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
            return;
        }
        context.getReportParams().setReportPlatform(ArgusReportPlatform.NONE);
        ArgusOnWebViewCreatedParams argusOnWebViewCreatedParams = (ArgusOnWebViewCreatedParams) callerParams;
        String originUserAgent = argusOnWebViewCreatedParams.getOriginUserAgent();
        String enterFrom = argusOnWebViewCreatedParams.getEnterFrom();
        ArgusInitConfig.AppEnv env = ArgusEnv.INSTANCE.getInstance().getEnv();
        String appId = env != null ? env.getAppId() : null;
        if (appId == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusWebViewCSRFUAStrategyVerifyReason.APPID_IS_NULL, null, null, 6, null);
            return;
        }
        String str = originUserAgent;
        List split$default = StringsKt.split$default(str, new String[]{" "}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        boolean contains = arrayList2.contains(CSRF_UA);
        boolean contains2 = arrayList2.contains("aid/" + appId);
        boolean contains3 = arrayList2.contains("argus_biz/" + enterFrom);
        if (contains && contains2 && contains3) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusWebViewCSRFUAStrategyVerifyReason.UA_CONTAINS_ALL_PART, null, null, 6, null);
            return;
        }
        if (originUserAgent != null) {
            final StringBuilder sb = new StringBuilder(StringsKt.trim(str).toString());
            if (!contains2) {
                sb.append(" aid/" + appId);
            }
            if (!contains3) {
                sb.append(" argus_biz/" + enterFrom);
            }
            if (!contains) {
                sb.append(" BytedanceWebview/d8a21c6");
            }
            AspectVerifyResult.onRewrite$default(verifyResult, ArgusWebViewCSRFUAStrategyVerifyReason.REWRITE_UA, null, null, new Function1<BaseRewritePayload, Unit>() { // from class: com.bytedance.ies.argus.strategy.provider.client.WebViewCSRFUAStrategyProvider$calculate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((BaseRewritePayload) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(BaseRewritePayload baseRewritePayload) {
                    ((ArgusOnWebViewCreatedRewritePayload) BaseRewritePayload.this).setNewUserAgent(sb.toString());
                    ArgusLog.i$default(ArgusLog.INSTANCE, "WebViewCSRFUAStrategyProvider", "rewrite ua to " + ((Object) sb), null, 4, null);
                }
            }, 6, null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
