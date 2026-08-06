package com.bytedance.ies.argus.strategy;

import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ContainerStrategyConfig;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.ies.argus.bean.StrategyRule;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.repository.AspectConfigInfo;
import com.bytedance.ies.argus.repository.ContainerConfigItem;
import com.bytedance.ies.argus.repository.ContainerConfigModel;
import com.bytedance.ies.argus.repository.GlobalConfigModel;
import com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import com.bytedance.ies.argus.util.CommonUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GlobalStrategyManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\fH\u0002J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\fJ\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\fH\u0002J\u0006\u0010$\u001a\u00020\u001cJ\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/ies/argus/strategy/GlobalStrategyManager;", "", "()V", "TAG", "", "containerStrategyConfStorage", "", "Lcom/bytedance/ies/argus/bean/ContainerStrategyConfig;", "nativeExtendFuncAddress", "", "ruleStorage", "", "Lcom/bytedance/ies/argus/bean/StrategyRule;", "ttmCore", "Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "getTtmCore", "()Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "getAspectConfig", "Lcom/bytedance/ies/argus/repository/AspectConfigInfo;", "cId", "aspect", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "getDefaultAspectConfig", "getRule", "name", "version", "getStrategyConfig", "innerParseRule", "", "data", "Lorg/json/JSONObject;", "parseOnlineByteCode", "expr", "rule", "parseRuleByteCodeAddress", "saveRule", "setup", "triggerParseRule", "updateStrategyConfig", "Lcom/bytedance/ies/argus/repository/ContainerConfigModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GlobalStrategyManager {
    private static final String TAG = "GlobalStrategy";
    private static long nativeExtendFuncAddress;
    public static final GlobalStrategyManager INSTANCE = new GlobalStrategyManager();
    private static Map<String, ContainerStrategyConfig> containerStrategyConfStorage = MapsKt.emptyMap();
    private static Map<String, Map<String, StrategyRule>> ruleStorage = new LinkedHashMap();

    private GlobalStrategyManager() {
    }

    public final ITTMStrategyManager getTtmCore() {
        return ArgusTTMStrategyManagerWrapper.INSTANCE.getInstance().getTtmInstance();
    }

    public final void setup() {
        ArgusConfigManager.INSTANCE.getInstance().registerGlobalConfigCollector(new Function1<GlobalConfigModel, Unit>() { // from class: com.bytedance.ies.argus.strategy.GlobalStrategyManager$setup$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GlobalConfigModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GlobalConfigModel globalConfigModel) {
                Intrinsics.checkNotNullParameter(globalConfigModel, "conf");
                GlobalStrategyManager.INSTANCE.triggerParseRule(globalConfigModel.getData());
            }
        });
        ArgusConfigManager.INSTANCE.getInstance().registerContainerConfigCollector(new Function1<ContainerConfigModel, Unit>() { // from class: com.bytedance.ies.argus.strategy.GlobalStrategyManager$setup$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContainerConfigModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContainerConfigModel containerConfigModel) {
                Intrinsics.checkNotNullParameter(containerConfigModel, "it");
                GlobalStrategyManager.INSTANCE.updateStrategyConfig(containerConfigModel);
            }
        });
    }

    public final ContainerStrategyConfig getStrategyConfig(String cId) {
        ContainerStrategyConfig containerStrategyConfig = cId != null ? containerStrategyConfStorage.get(cId) : null;
        return containerStrategyConfig == null ? containerStrategyConfStorage.get("host") : containerStrategyConfig;
    }

    public final AspectConfigInfo getAspectConfig(String cId, IArgusAspect aspect) {
        Intrinsics.checkNotNullParameter(aspect, "aspect");
        if (cId == null) {
            return getDefaultAspectConfig(aspect);
        }
        ContainerConfigItem containerAspectRule = ArgusConfigManager.INSTANCE.getInstance().getContainerConfigProvider().getContainerAspectRule(cId);
        if (containerAspectRule != null) {
            return new AspectConfigInfo(cId, containerAspectRule.getAspectRules(aspect), null, 4, null);
        }
        return getDefaultAspectConfig(aspect);
    }

    private final AspectConfigInfo getDefaultAspectConfig(IArgusAspect aspect) {
        ContainerConfigItem containerAspectRule = ArgusConfigManager.INSTANCE.getInstance().getContainerConfigProvider().getContainerAspectRule("host");
        return new AspectConfigInfo("host", containerAspectRule != null ? containerAspectRule.getAspectRules(aspect) : null, null, 4, null);
    }

    private final void saveRule(StrategyRule rule) {
        String key = rule.getKey();
        if (ruleStorage.get(key) == null) {
            ruleStorage.put(key, new LinkedHashMap());
        }
        Map<String, StrategyRule> map = ruleStorage.get(key);
        if (map != null) {
            map.put(rule.getVersion(), rule);
        }
    }

    public final StrategyRule getRule(String name, String version) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(version, "version");
        Map<String, StrategyRule> map = ruleStorage.get(name);
        if (map != null) {
            return map.get(version);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerParseRule(final JSONObject data) {
        if (getTtmCore() == null) {
            ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "trigger parse ttm rule but ttmCore is null, try to register listener instead", null, 4, null);
            ArgusTTMStrategyManagerWrapper.INSTANCE.getInstance().registerTTMInitCallback(new Function0<Unit>() { // from class: com.bytedance.ies.argus.strategy.GlobalStrategyManager$triggerParseRule$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m620invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m620invoke() {
                    GlobalStrategyManager.INSTANCE.innerParseRule(data);
                }
            });
        } else {
            innerParseRule(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void innerParseRule(JSONObject data) {
        JSONObject optJSONObject = data.optJSONObject("strategy");
        if (optJSONObject == null) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "strategy is null", null, null, 12, null);
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("rules");
        if (optJSONObject2 == null) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "strategy rules is null", null, null, 12, null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<String> keys = optJSONObject2.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "rulesData.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next);
            if (optJSONObject3 != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject3, "optJSONObject(ruleName)");
                Iterator<String> keys2 = optJSONObject3.keys();
                Intrinsics.checkNotNullExpressionValue(keys2, "ruleData.keys()");
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject(next2);
                    StrategyRule.Builder builder = new StrategyRule.Builder();
                    Intrinsics.checkNotNullExpressionValue(next, "ruleName");
                    Intrinsics.checkNotNullExpressionValue(next2, "version");
                    StrategyRule build = builder.build(next, next2, optJSONObject4);
                    if (build != null) {
                        GlobalStrategyManager globalStrategyManager = INSTANCE;
                        globalStrategyManager.saveRule(build);
                        globalStrategyManager.parseRuleByteCodeAddress(build);
                    } else {
                        ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "parse " + next + " failed", null, null, 12, null);
                    }
                }
            }
        }
        ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "finish update strategy rule cost: " + (System.currentTimeMillis() - currentTimeMillis), null, 4, null);
    }

    private final void parseOnlineByteCode(String expr, StrategyRule rule) {
        String exprMd5 = rule.getExprMd5();
        String md5 = CommonUtils.INSTANCE.toMD5(expr);
        if (Intrinsics.areEqual(exprMd5, md5)) {
            ITTMStrategyManager ttmCore = getTtmCore();
            if (ttmCore != null) {
                rule.setByteCodeAddress(Long.valueOf(ttmCore.processTTMRuleByteCodeLong(expr, nativeExtendFuncAddress)));
                return;
            }
            return;
        }
        ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "parseOnlineByteCode mismatch md5: expectedMd5 is " + exprMd5 + ", but expr is " + md5, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStrategyConfig(ContainerConfigModel data) {
        long currentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ContainerConfigItem> entry : data.getConf().entrySet()) {
            String key = entry.getKey();
            ContainerStrategyConfig containerStrategyConfig = (ContainerStrategyConfig) ArgusGsonUtils.INSTANCE.safelyFromJSONObjectToClass(entry.getValue().getStrategyConf().getConf(), ContainerStrategyConfig.class);
            if (containerStrategyConfig != null) {
                linkedHashMap.put(key, containerStrategyConfig);
            }
        }
        containerStrategyConfStorage = MapsKt.toMap(linkedHashMap);
        ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "finish update container strategy config, cost: " + (System.currentTimeMillis() - currentTimeMillis), null, 4, null);
    }

    public final void parseRuleByteCodeAddress(StrategyRule rule) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        long currentTimeMillis = System.currentTimeMillis();
        if (rule.getExpr() != null) {
            INSTANCE.parseOnlineByteCode(rule.getExpr(), rule);
        } else {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "parse ttm byte code failed: rule.expr is null " + rule, null, null, 12, null);
        }
        ArgusLog.d$default(ArgusLog.INSTANCE, TAG, "parseRuleByteCodeAddress cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms, " + rule, null, 4, null);
    }
}
