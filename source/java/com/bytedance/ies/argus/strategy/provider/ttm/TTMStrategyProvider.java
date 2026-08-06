package com.bytedance.ies.argus.strategy.provider.ttm;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.bean.StrategyRule;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.GlobalStrategyManager;
import com.bytedance.ies.argus.strategy.ITTMDataHandler;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.tiktok.ttm.TTMCore;
import com.tiktok.ttm.TTMInput;
import com.tiktok.ttm.TTMOutput;
import com.tiktok.ttm.TTMParamData;
import com.tiktok.ttm.ttmparam.ITTMParamData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTMStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2 \u0010\t\u001a\u001c0\nR\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u000bH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\t\u001a\u000e0\nR\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/ttm/TTMStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "initTTMData", "Lcom/tiktok/ttm/ttmparam/ITTMParamData;", "ruleName", "", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TTMStrategyProvider extends BaseStrategyProvider {
    public static final String TAG = "TTMStrategyProvider";

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        AspectVerifyResult<? extends BaseRewritePayload> verifyResult = context.getVerifyResult();
        String name = rule.getName();
        String version = rule.getVersion();
        if (GlobalStrategyManager.INSTANCE.getTtmCore() == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.TTM_IS_NOT_ENABLED, null, null, 6, null);
            return;
        }
        if (name == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.TTM_RULE_NAME_IS_NULL, null, null, 6, null);
            return;
        }
        if (version == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.TTM_RULE_VERSION_IS_NULL, null, null, 6, null);
            return;
        }
        StrategyRule rule2 = GlobalStrategyManager.INSTANCE.getRule(name, version);
        if (rule2 == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.TTM_RULE_INFO_IS_NULL, null, null, 6, null);
            return;
        }
        Long byteCodeAddress = rule2.getByteCodeAddress();
        if (byteCodeAddress == null) {
            GlobalStrategyManager.INSTANCE.parseRuleByteCodeAddress(rule2);
            byteCodeAddress = rule2.getByteCodeAddress();
        }
        if (byteCodeAddress == null) {
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.TTM_RULE_ADDRESS_IS_NULL, null, null, 6, null);
            return;
        }
        TTMInput tTMInput = new TTMInput();
        tTMInput.machineCodeAddress = byteCodeAddress.longValue();
        tTMInput.paramType = TTMInput.ParamType.TYPE_MAP;
        tTMInput.paramData = new TTMParamData(initTTMData(name, context));
        TTMOutput execute = TTMCore.getInstance().execute(tTMInput);
        ArgusLog.d$default(ArgusLog.INSTANCE, TAG, "ttm_output: " + execute.getMsg() + ' ' + execute.getData(), null, 4, null);
        if (execute.getType() == TTMOutput.ReturnType.ERROR) {
            String str = "run " + name + '#' + version + " got " + execute.getMsg() + ' ' + execute.getData();
            AspectVerifyResult.onError$default(verifyResult, ArgusCommonVerifyReason.RUN_TTM_ERROR, str, null, 4, null);
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, str, null, null, 12, null);
        }
    }

    private final ITTMParamData initTTMData(final String ruleName, final AspectContext<?, ?>.CalculateContext context) {
        return new ITTMParamData(context, ruleName) { // from class: com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyProvider$initTTMData$1

            /* renamed from: callerParams$delegate, reason: from kotlin metadata */
            private final Lazy callerParams;

            /* renamed from: rewritePayload$delegate, reason: from kotlin metadata */
            private final Lazy rewritePayload;

            /* renamed from: ttmContainerContext$delegate, reason: from kotlin metadata */
            private final Lazy ttmContainerContext;

            /* renamed from: ttmViewContext$delegate, reason: from kotlin metadata */
            private final Lazy ttmViewContext;

            /* renamed from: verifyResult$delegate, reason: from kotlin metadata */
            private final Lazy verifyResult;

            public int getType() {
                return 10;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.callerParams = LazyKt.lazy(new Function0<ArgusTTMParamData>() { // from class: com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyProvider$initTTMData$1$callerParams$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final ArgusTTMParamData m624invoke() {
                        return new ArgusTTMParamData(context.getCallerParams());
                    }
                });
                this.verifyResult = LazyKt.lazy(new Function0<ArgusTTMParamData>() { // from class: com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyProvider$initTTMData$1$verifyResult$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final ArgusTTMParamData m628invoke() {
                        return new ArgusTTMParamData(new AspectVerifyResult.TTMDataHandler(context.getVerifyResult(), ruleName));
                    }
                });
                this.rewritePayload = LazyKt.lazy(new Function0<ArgusTTMParamData>() { // from class: com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyProvider$initTTMData$1$rewritePayload$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final ArgusTTMParamData m625invoke() {
                        Object rewritePayload = context.getVerifyResult().getRewritePayload();
                        if (rewritePayload != null) {
                            return new ArgusTTMParamData((ITTMDataHandler) rewritePayload);
                        }
                        return null;
                    }
                });
                this.ttmContainerContext = LazyKt.lazy(new Function0<ArgusTTMParamData>() { // from class: com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyProvider$initTTMData$1$ttmContainerContext$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final ArgusTTMParamData m626invoke() {
                        ContainerContext containerContext = context.getContainerContext();
                        if (containerContext != null) {
                            return new ArgusTTMParamData(containerContext);
                        }
                        return null;
                    }
                });
                this.ttmViewContext = LazyKt.lazy(new Function0<ArgusTTMParamData>() { // from class: com.bytedance.ies.argus.strategy.provider.ttm.TTMStrategyProvider$initTTMData$1$ttmViewContext$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final ArgusTTMParamData m627invoke() {
                        BaseViewContext<?> viewContext = context.getViewContext();
                        if (viewContext != null) {
                            return new ArgusTTMParamData(viewContext);
                        }
                        return null;
                    }
                });
            }

            private final ArgusTTMParamData getCallerParams() {
                return (ArgusTTMParamData) this.callerParams.getValue();
            }

            private final ArgusTTMParamData getVerifyResult() {
                return (ArgusTTMParamData) this.verifyResult.getValue();
            }

            private final ArgusTTMParamData getRewritePayload() {
                return (ArgusTTMParamData) this.rewritePayload.getValue();
            }

            private final ArgusTTMParamData getTtmContainerContext() {
                return (ArgusTTMParamData) this.ttmContainerContext.getValue();
            }

            private final ArgusTTMParamData getTtmViewContext() {
                return (ArgusTTMParamData) this.ttmViewContext.getValue();
            }

            public Object getInputData() {
                return 10;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            public ITTMParamData getObjectItem(String key) {
                Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
                switch (key.hashCode()) {
                    case -1556604943:
                        if (key.equals("container_context")) {
                            return getTtmContainerContext();
                        }
                        return null;
                    case -1346395627:
                        if (key.equals("view_context")) {
                            return getTtmViewContext();
                        }
                        return null;
                    case -995427962:
                        if (key.equals("params")) {
                            return getCallerParams();
                        }
                        return null;
                    case -934426595:
                        if (key.equals("result")) {
                            return getVerifyResult();
                        }
                        return null;
                    case 100589:
                        if (key.equals(ReportConst.JSBConfigParam.ENV)) {
                            return new ArgusTTMParamData(ArgusEnv.INSTANCE.getInstance().getTtmParam$anniex_release());
                        }
                        return null;
                    case 200895963:
                        if (key.equals("rewrite_payload")) {
                            return getRewritePayload();
                        }
                        return null;
                    default:
                        return null;
                }
            }
        };
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.TTMACHINE;
    }
}
