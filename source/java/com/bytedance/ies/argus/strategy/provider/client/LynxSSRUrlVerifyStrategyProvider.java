package com.bytedance.ies.argus.strategy.provider.client;

import android.net.Uri;
import com.bytedance.ies.argus.api.params.AboutToRequestLynxSSRUrlParams;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusLynxSSRUrlVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.RegUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LynxSSRUrlVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/LynxSSRUrlVerifyStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxSSRUrlVerifyStrategyProvider extends BaseStrategyProvider {
    public static final String TAG = "LynxSSRUrlVerifyStrategyProvider";

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.LynxSSRUrlVerify;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        List<String> emptyList;
        List<String> emptyList2;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        if (!(callerParams instanceof AboutToRequestLynxSSRUrlParams)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
            return;
        }
        LynxSSRUrlVerifyStrategyConfig lynxSSRUrlVerify = strategyConfig != null ? strategyConfig.getLynxSSRUrlVerify() : null;
        if (lynxSSRUrlVerify == null || (emptyList = lynxSSRUrlVerify.getAllowHostList()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        if (lynxSSRUrlVerify == null || (emptyList2 = lynxSSRUrlVerify.getAllowRegList()) == null) {
            emptyList2 = CollectionsKt.emptyList();
        }
        if (emptyList.isEmpty() && emptyList2.isEmpty()) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSSRUrlVerifyReason.CONFIG_IS_EMPTY, null, null, 6, null);
            return;
        }
        AboutToRequestLynxSSRUrlParams aboutToRequestLynxSSRUrlParams = (AboutToRequestLynxSSRUrlParams) callerParams;
        String removeQuery = CommonUtils.INSTANCE.removeQuery(aboutToRequestLynxSSRUrlParams.getSsrUrl());
        Uri parse = Uri.parse(removeQuery);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        String host = parse.getHost();
        if (host == null) {
            host = "";
        }
        aboutToRequestLynxSSRUrlParams.setHost(host);
        List<String> list = emptyList;
        boolean z3 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (String str : list) {
                if (StringsKt.endsWith$default(host, new StringBuilder(".").append(str).toString(), false, 2, (Object) null) || Intrinsics.areEqual(host, str)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            List<String> list2 = emptyList2;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (RegUtils.INSTANCE.matchReg(removeQuery, (String) it.next())) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                z3 = false;
            }
        }
        if (z3) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusLynxSSRUrlVerifyReason.MATCH, null, null, 6, null);
        } else {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "ssr url " + removeQuery + " not in allow list", null, null, 12, null);
            AspectVerifyResult.onBlock$default(verifyResult, ArgusLynxSSRUrlVerifyReason.NOT_MATCH, null, null, 6, null);
        }
    }
}
