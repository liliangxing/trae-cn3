package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.api.params.InjectLoginStateParams;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusLoginStateSourceVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* compiled from: LoginStateSourceVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/LoginStateSourceVerifyStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LoginStateSourceVerifyStrategyProvider extends BaseStrategyProvider {
    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.LoginStateSourceVerify;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        List<String> emptyList;
        List<String> emptyList2;
        boolean z;
        LoginStateSourceVerifyStrategyConfig loginStateSourceVerify;
        LoginStateSourceVerifyStrategyConfig loginStateSourceVerify2;
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        if (!(callerParams instanceof InjectLoginStateParams)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
            return;
        }
        if (strategyConfig == null || (loginStateSourceVerify2 = strategyConfig.getLoginStateSourceVerify()) == null || (emptyList = loginStateSourceVerify2.getWhiteUrlRegList()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        if (strategyConfig == null || (loginStateSourceVerify = strategyConfig.getLoginStateSourceVerify()) == null || (emptyList2 = loginStateSourceVerify.getWhiteUrlPrefixList()) == null) {
            emptyList2 = CollectionsKt.emptyList();
        }
        if (emptyList.isEmpty() && emptyList2.isEmpty()) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLoginStateSourceVerifyReason.CONFIG_IS_EMPTY, null, null, 6, null);
            return;
        }
        String sourceUrl = ((InjectLoginStateParams) callerParams).getSourceUrl();
        boolean z2 = false;
        if (!StringsKt.startsWith$default(sourceUrl, "https://", false, 2, (Object) null)) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLoginStateSourceVerifyReason.NOT_HTTPS, null, null, 6, null);
            return;
        }
        List<String> list = emptyList2;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (StringsKt.startsWith(sourceUrl, (String) it.next(), true)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusLoginStateSourceVerifyReason.MATCH, null, null, 6, null);
            return;
        }
        List<String> list2 = emptyList;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (new Regex((String) it2.next(), RegexOption.IGNORE_CASE).matches(sourceUrl)) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusLoginStateSourceVerifyReason.MATCH, null, null, 6, null);
        } else {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLoginStateSourceVerifyReason.NOT_MATCH, null, null, 6, null);
        }
    }
}
