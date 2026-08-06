package com.bytedance.ies.argus.strategy.provider.client;

import android.net.Uri;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusPrefetchVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.util.CommonUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PrefetchStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J,\u0010\u000e\u001a\u00020\u00042\u0010\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J,\u0010\u0013\u001a\u00020\u00042\u0010\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "checkLatch", "verifyResult", "Lcom/bytedance/ies/argus/bean/AspectVerifyResult;", "callerParams", "Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchCallerParams;", "checkPrefetch", "inWhiteList", "", "host", "", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PrefetchStrategyProvider extends BaseStrategyProvider {
    private static final String LATCH_INIT_JS_SUFFIX = "/latch.init.js";
    private static final String LATCH_PREFETCH_JS_SUFFIX = "/prefetch.js";
    private static final String PREFETCH_JSON_SUFFIX = "/prefetch.json";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> WHITE_DOMAIN_LIST = CollectionsKt.listOf(new String[]{"snssdk.com", "bytegecko.com", "amemv.com"});

    /* compiled from: PrefetchStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrefetchType.values().length];
            try {
                iArr[PrefetchType.PrefetchV2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrefetchType.Latch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.PrefetchWhiteList;
    }

    /* compiled from: PrefetchStrategyProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchStrategyProvider$Companion;", "", "()V", "LATCH_INIT_JS_SUFFIX", "", "LATCH_PREFETCH_JS_SUFFIX", "PREFETCH_JSON_SUFFIX", "WHITE_DOMAIN_LIST", "", "getWHITE_DOMAIN_LIST", "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getWHITE_DOMAIN_LIST() {
            return PrefetchStrategyProvider.WHITE_DOMAIN_LIST;
        }
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseAspectParams<?> callerParams = context.getCallerParams();
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        if (!(callerParams instanceof PrefetchCallerParams)) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.MISMATCH_PARAMS_TYPE, null, null, 6, null);
            return;
        }
        PrefetchCallerParams prefetchCallerParams = (PrefetchCallerParams) callerParams;
        int i = WhenMappings.$EnumSwitchMapping$0[prefetchCallerParams.getType().ordinal()];
        if (i == 1) {
            checkPrefetch(verifyResult, prefetchCallerParams, strategyConfig);
        } else {
            if (i != 2) {
                return;
            }
            checkLatch(verifyResult, prefetchCallerParams, strategyConfig);
        }
    }

    private final void checkPrefetch(AspectVerifyResult<? extends BaseRewritePayload> verifyResult, PrefetchCallerParams callerParams, ContainerStrategyConfig strategyConfig) {
        String url = callerParams.getUrl();
        if (url == null) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusPrefetchVerifyReason.PREFETCH_LOAD_OFFLINE_CONFIG, null, null, 6, null);
            return;
        }
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        CommonUtils commonUtils2 = CommonUtils.INSTANCE;
        Uri parse = Uri.parse(url);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        String clearQueryAndFragment = commonUtils.clearQueryAndFragment(commonUtils2.getCDN(parse));
        callerParams.setRealUrl(clearQueryAndFragment);
        boolean z = true;
        if ((clearQueryAndFragment == null || StringsKt.endsWith$default(clearQueryAndFragment, PREFETCH_JSON_SUFFIX, false, 2, (Object) null)) ? false : true) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusPrefetchVerifyReason.NOT_END_WITH_CORRECT_SUFFIX, null, null, 6, null);
            return;
        }
        String hostByUrl = CommonUtils.INSTANCE.getHostByUrl(clearQueryAndFragment);
        callerParams.setHost(hostByUrl);
        String str = hostByUrl;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusPrefetchVerifyReason.PREFETCH_HOST_UNPARSEABLE, null, null, 6, null);
        } else if (inWhiteList(strategyConfig, hostByUrl)) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusPrefetchVerifyReason.MATCH, null, null, 6, null);
        } else {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusPrefetchVerifyReason.NOT_MATCH, null, null, 6, null);
        }
    }

    private final void checkLatch(AspectVerifyResult<? extends BaseRewritePayload> verifyResult, PrefetchCallerParams callerParams, ContainerStrategyConfig strategyConfig) {
        String url = callerParams.getUrl();
        if (url == null) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusPrefetchVerifyReason.PREFETCH_LOAD_OFFLINE_CONFIG, null, null, 6, null);
            return;
        }
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        CommonUtils commonUtils2 = CommonUtils.INSTANCE;
        Uri parse = Uri.parse(url);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        String clearQueryAndFragment = commonUtils.clearQueryAndFragment(commonUtils2.getCDN(parse));
        callerParams.setRealUrl(clearQueryAndFragment);
        boolean z = true;
        if (((clearQueryAndFragment == null || StringsKt.endsWith$default(clearQueryAndFragment, LATCH_INIT_JS_SUFFIX, false, 2, (Object) null)) ? false : true) && !StringsKt.endsWith$default(clearQueryAndFragment, LATCH_PREFETCH_JS_SUFFIX, false, 2, (Object) null)) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusPrefetchVerifyReason.NOT_END_WITH_CORRECT_SUFFIX, null, null, 6, null);
            return;
        }
        String hostByUrl = CommonUtils.INSTANCE.getHostByUrl(callerParams.getUrl());
        callerParams.setHost(hostByUrl);
        String str = hostByUrl;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusPrefetchVerifyReason.PREFETCH_HOST_UNPARSEABLE, null, null, 6, null);
        } else if (inWhiteList(strategyConfig, hostByUrl)) {
            AspectVerifyResult.onPass$default(verifyResult, ArgusPrefetchVerifyReason.MATCH, null, null, 6, null);
        } else {
            AspectVerifyResult.onBlock$default(verifyResult, ArgusPrefetchVerifyReason.NOT_MATCH, null, null, 6, null);
        }
    }

    private final boolean inWhiteList(ContainerStrategyConfig strategyConfig, String host) {
        List<String> list;
        List<String> emptyList;
        boolean z;
        boolean z2;
        PrefetchStrategyConfig prefetch = strategyConfig != null ? strategyConfig.getPrefetch() : null;
        if (prefetch == null || (list = prefetch.getWhiteDomainList()) == null) {
            list = WHITE_DOMAIN_LIST;
        }
        if (prefetch == null || (emptyList = prefetch.getWhiteRegList()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<String> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            for (String str : list2) {
                if (StringsKt.endsWith$default(host, new StringBuilder(".").append(str).toString(), false, 2, (Object) null) || Intrinsics.areEqual(host, str)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return true;
        }
        List<String> list3 = emptyList;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (CommonUtils.INSTANCE.matchReg(host, (String) it.next())) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return z2;
    }
}
