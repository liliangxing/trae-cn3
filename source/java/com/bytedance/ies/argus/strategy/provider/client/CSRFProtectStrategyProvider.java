package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.api.params.LoadStaticResourceParams;
import com.bytedance.ies.argus.api.params.LoadStaticResourceRewritePayload;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.bean.ArgusCSRFProtectVerifyReason;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CSRFProtectStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/CSRFProtectStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CSRFProtectStrategyProvider extends BaseStrategyProvider {
    public static final String X_SECURITY_ARGUS = "x-security-argus";

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.CSRF_PROTECT;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        final BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        final BaseRewritePayload rewritePayload = verifyResult.getRewritePayload();
        if (!(callerParams instanceof LoadStaticResourceParams) || !(rewritePayload instanceof LoadStaticResourceRewritePayload)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
        } else {
            verifyResult.onRewrite(ArgusCSRFProtectVerifyReason.REWRITE_HEADER, null, null, new Function1<BaseRewritePayload, Unit>() { // from class: com.bytedance.ies.argus.strategy.provider.client.CSRFProtectStrategyProvider$calculate$1
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
                    Object obj;
                    String str;
                    String resourceType = ((LoadStaticResourceParams) callerParams).getResourceType();
                    ArgusInitConfig.AppEnv env = ArgusEnv.INSTANCE.getInstance().getEnv();
                    if (env == null || (obj = env.getAppId()) == null) {
                        obj = 0;
                    }
                    ArgusInitConfig.AppEnv env2 = ArgusEnv.INSTANCE.getInstance().getEnv();
                    if (env2 == null || (str = env2.getChannel()) == null) {
                        str = "";
                    }
                    ((LoadStaticResourceRewritePayload) rewritePayload).setRewriteHeaders(MapsKt.mapOf(TuplesKt.to(CSRFProtectStrategyProvider.X_SECURITY_ARGUS, "StaticResource/" + resourceType + '/' + ((LoadStaticResourceParams) callerParams).getResourcePoint() + " aid/" + obj + '/' + str + "/Android")));
                }
            });
        }
    }
}
