package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.api.params.ArgusMotionEventParams;
import com.bytedance.ies.argus.api.params.ArgusMotionEventRewritePayload;
import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.bean.ArgusMotionVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.AspectVerifyResult;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.strategy.BaseRewritePayload;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MotionStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2 \u0010\u0010\u001a\u001c0\u0011R\u0018\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/MotionStrategyProvider;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "()V", "bizSceneTag", "", "cacheEventMap", "", "", "hasInitScene", "", "calculate", "", "rule", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "strategyConfig", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "context", "Lcom/bytedance/ies/argus/bean/AspectContext$CalculateContext;", "Lcom/bytedance/ies/argus/bean/AspectContext;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "type", "Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MotionStrategyProvider extends BaseStrategyProvider {
    private String bizSceneTag;
    private Map<String, Integer> cacheEventMap = new LinkedHashMap();
    private boolean hasInitScene;

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public ArgusStrategyProviderType type() {
        return ArgusStrategyProviderType.MotionVerify;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider
    public void calculate(AspectConfigItem.AspectRuleItem rule, ContainerStrategyConfig strategyConfig, AspectContext<? extends BaseAspectParams<?>, ? extends BaseRewritePayload>.CalculateContext context) {
        MotionStrategyConfig motionVerify;
        Map<String, List<Long>> sceneMatchMap;
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseAspectParams<?> callerParams = context.getCallerParams();
        if (callerParams instanceof ArgusMotionEventParams) {
            if (!this.hasInitScene) {
                if (strategyConfig != null && (motionVerify = strategyConfig.getMotionVerify()) != null && (sceneMatchMap = motionVerify.getSceneMatchMap()) != null) {
                    Iterator<Map.Entry<String, List<Long>>> it = sceneMatchMap.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, List<Long>> next = it.next();
                        String key = next.getKey();
                        List<Long> value = next.getValue();
                        Long pageFeId = ((ArgusMotionEventParams) callerParams).getPageFeId();
                        if (pageFeId != null && value.contains(pageFeId)) {
                            this.bizSceneTag = key;
                            break;
                        }
                    }
                }
                this.hasInitScene = true;
            }
            String tag = ((ArgusMotionEventParams) callerParams).tag();
            if (this.cacheEventMap.containsKey(tag)) {
                return;
            }
            this.cacheEventMap.put(tag, 1);
            final String str = this.bizSceneTag;
            if (str != null) {
                context.setReportPlatform(ArgusReportPlatform.ONLY_TEA);
                AspectVerifyResult.onRewrite$default(context.getVerifyResult(), ArgusMotionVerifyReason.MATCH_SCENE, null, null, new Function1<BaseRewritePayload, Unit>() { // from class: com.bytedance.ies.argus.strategy.provider.client.MotionStrategyProvider$calculate$2$1
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
                        if (baseRewritePayload instanceof ArgusMotionEventRewritePayload) {
                            ((ArgusMotionEventRewritePayload) baseRewritePayload).setSceneTag(str);
                        }
                    }
                }, 6, null);
            }
        }
    }
}
