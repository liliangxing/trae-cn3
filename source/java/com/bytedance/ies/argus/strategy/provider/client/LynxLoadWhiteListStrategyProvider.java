package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.api.params.LynxSignVerifyCallerParams;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusLynxSignVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxLoadWhiteListStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/LynxLoadWhiteListStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxLoadWhiteListStrategyProvider extends BaseStrategyProvider {
    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.LynxLoadWhiteList;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        LynxLoadWhiteListConfig lynxLoadWhiteList;
        Map<String, FeLimitLoadSourceInfo> feLimitLoadSourceConfig;
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        if (!(callerParams instanceof LynxSignVerifyCallerParams)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
            return;
        }
        if (strategyConfig == null || (lynxLoadWhiteList = strategyConfig.getLynxLoadWhiteList()) == null || (feLimitLoadSourceConfig = lynxLoadWhiteList.getFeLimitLoadSourceConfig()) == null) {
            return;
        }
        LynxSignVerifyCallerParams lynxSignVerifyCallerParams = (LynxSignVerifyCallerParams) callerParams;
        FeLimitLoadSourceInfo feLimitLoadSourceInfo = feLimitLoadSourceConfig.get(String.valueOf(lynxSignVerifyCallerParams.getFeId()));
        if (feLimitLoadSourceInfo != null) {
            if (feLimitLoadSourceInfo.getOnlyVerifyMainTemplate() && lynxSignVerifyCallerParams.getTasmType() != ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE) {
                AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.FE_PAGE_LOAD_LIMIT_SOURCE_PASS_NOT_MAIN_TEMPLATE, null, null, 6, null);
                return;
            }
            List<String> cidList = feLimitLoadSourceInfo.getCidList();
            if (cidList != null) {
                BaseViewContext<?> viewContext = context.getViewContext();
                if ((viewContext != null ? viewContext.getView() : null) == null) {
                    AspectVerifyResult.onError$default(verifyResult, ArgusLynxSignVerifyReason.FE_PAGE_LOAD_LIMIT_SOURCE_ABNORMAL_PASS_NO_VIEW, null, null, 6, null);
                } else if (cidList.contains(context.getArgusId())) {
                    AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSignVerifyReason.FE_PAGE_LOAD_LIMIT_SOURCE_PASS, null, null, 6, null);
                } else {
                    AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSignVerifyReason.FORBID_FE_PAGE_LOAD_SOURCE, "expect argusCId in " + cidList + ", but get " + context.getArgusId(), null, 4, null);
                }
            }
        }
    }
}
