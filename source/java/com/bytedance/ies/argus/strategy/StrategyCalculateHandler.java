package com.bytedance.ies.argus.strategy;

import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.ies.argus.bean.ArgusSwitch;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.bytedance.ies.argus.util.CommonUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: StrategyCalculateHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0002R'\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/strategy/StrategyCalculateHandler;", "", "depend", "Lcom/bytedance/ies/argus/strategy/ICalculateHandlerDepend;", "(Lcom/bytedance/ies/argus/strategy/ICalculateHandlerDepend;)V", "clientStrategyProviderMap", "", "", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "getClientStrategyProviderMap", "()Ljava/util/Map;", "clientStrategyProviderMap$delegate", "Lkotlin/Lazy;", "getDepend", "()Lcom/bytedance/ies/argus/strategy/ICalculateHandlerDepend;", "calculate", "", "aspectContext", "Lcom/bytedance/ies/argus/bean/AspectContext;", "getStrategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "cId", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class StrategyCalculateHandler {
    public static final String TAG = "StrategyCalculateHandler";

    /* renamed from: clientStrategyProviderMap$delegate, reason: from kotlin metadata */
    private final Lazy clientStrategyProviderMap;
    private final ICalculateHandlerDepend depend;

    public StrategyCalculateHandler(ICalculateHandlerDepend iCalculateHandlerDepend) {
        Intrinsics.checkNotNullParameter(iCalculateHandlerDepend, "depend");
        this.depend = iCalculateHandlerDepend;
        this.clientStrategyProviderMap = LazyKt.lazy(new Function0<Map<String, ? extends BaseStrategyProvider>>() { // from class: com.bytedance.ies.argus.strategy.StrategyCalculateHandler$clientStrategyProviderMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final Map<String, BaseStrategyProvider> invoke() {
                List<BaseStrategyProvider> clientStrategyProvider = StrategyCalculateHandler.this.getDepend().getClientStrategyProvider();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(clientStrategyProvider, 10)), 16));
                for (Object obj : clientStrategyProvider) {
                    linkedHashMap.put(((BaseStrategyProvider) obj).name(), obj);
                }
                return linkedHashMap;
            }
        });
    }

    public final ICalculateHandlerDepend getDepend() {
        return this.depend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContainerStrategyConfig getStrategyConfig(String cId) {
        return GlobalStrategyManager.INSTANCE.getStrategyConfig(cId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, BaseStrategyProvider> getClientStrategyProviderMap() {
        return (Map) this.clientStrategyProviderMap.getValue();
    }

    public final void calculate(AspectContext<?, ?> aspectContext) {
        BaseStrategyProvider strategyProvider;
        Intrinsics.checkNotNullParameter(aspectContext, "aspectContext");
        AspectConfigItem aspectConfig = aspectContext.getAspectConfig();
        AspectVerifyResult<?> verifyResult = aspectContext.getVerifyResult();
        if (aspectConfig == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, null, 6, null);
            return;
        }
        if (new ArgusSwitch(Integer.valueOf(aspectConfig.getSwitch())).getEnable()) {
            List<AspectConfigItem.AspectRuleItem> rules = aspectConfig.getRules();
            if (rules.isEmpty()) {
                AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.STRATEGY_RULE_LIST_IS_EMPTY, null, null, 6, null);
                return;
            }
            for (AspectConfigItem.AspectRuleItem aspectRuleItem : rules) {
                String name = aspectRuleItem.getName();
                AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext calculateContext = new AspectContext.CalculateContext(aspectContext, CommonUtils.INSTANCE.toSwitch(aspectRuleItem.getSwitch()));
                AspectContext.Companion.TraceType traceType = AspectContext.Companion.TraceType.CALCULATE;
                String str = name == null ? ArgusConstants.NULL_PLACE_HOLDER : name;
                ((AspectContext.CalculateContext) calculateContext).this$0.recordCost(traceType, AspectContext.Companion.TraceStage.START, str);
                try {
                    try {
                        AspectVerifyResult verifyResult2 = calculateContext.getVerifyResult();
                        if (name == null) {
                            AspectVerifyResult.onError$default(verifyResult2, ArgusCommonVerifyReason.STRATEGY_RULE_NAME_IS_NULL, null, null, 6, null);
                        } else {
                            StrategyCalculateHandler strategyCalculateHandler = this;
                            if (Intrinsics.areEqual(aspectRuleItem.getRuleType(), AspectConfigItem.StrategyRuleType.CLIENT.getStr())) {
                                strategyProvider = (BaseStrategyProvider) getClientStrategyProviderMap().get(name);
                                if (strategyProvider == null) {
                                    AspectVerifyResult.onError$default(verifyResult2, ArgusCommonVerifyReason.CLIENT_STRATEGY_PROVIDER_NOT_FOUND, "name is :" + name, null, 4, null);
                                }
                            } else {
                                strategyProvider = ArgusTTMStrategyManagerWrapper.INSTANCE.getInstance().getStrategyProvider();
                                if (strategyProvider == null) {
                                    AspectVerifyResult.onError$default(verifyResult2, ArgusCommonVerifyReason.TTM_STRATEGY_PROVIDER_NOT_FOUND, null, null, 6, null);
                                }
                            }
                            if (strategyProvider != null) {
                                strategyProvider.calculate(aspectRuleItem, getStrategyConfig(aspectContext.getArgusBizId()), calculateContext);
                            }
                        }
                        ((AspectContext.CalculateContext) calculateContext).this$0.recordVerifyResult(str, calculateContext.getVerifyResult().toString(), calculateContext.getMode());
                        if (calculateContext.getVerifyResult().isPass() && calculateContext.getVerifyResult().isReasonCodeUnset()) {
                            AspectVerifyResult.onPass$default(calculateContext.getVerifyResult(), ArgusCommonVerifyReason.PASS_STRATEGY_CALCULATE, "strategyKey=" + str, null, 4, null);
                        }
                    } catch (Exception e) {
                        ArgusLog.e$default(ArgusLog.INSTANCE, AspectContext.TAG, "trace ", null, e, 4, null);
                        AspectVerifyResult.onError$default(calculateContext.getVerifyResult(), ArgusCommonVerifyReason.TRY_CATCH_ERROR, e.toString(), null, 4, null);
                    }
                    ((AspectContext.CalculateContext) calculateContext).this$0.recordCost(traceType, AspectContext.Companion.TraceStage.END, str);
                    if (verifyResult.getInterrupt()) {
                        return;
                    }
                } catch (Throwable th) {
                    ((AspectContext.CalculateContext) calculateContext).this$0.recordCost(traceType, AspectContext.Companion.TraceStage.END, str);
                    throw th;
                }
            }
        }
    }
}
