package com.bytedance.ies.bullet.redirect.rule;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.redirect.data.RedirectRule;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuleStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/rule/RuleStrategy;", "", "type", "", "(I)V", "getType", "()I", "match", "", "redirectRule", "Lcom/bytedance/ies/bullet/redirect/data/RedirectRule;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class RuleStrategy {
    public static final int BLOCK = 3;
    public static final int Libra = 4;
    public static final int TIME = 2;
    public static final int UNKNOWN = -1;
    public static final int UNLIMITED = 0;
    public static final int VERSION = 1;
    private final int type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Integer, RuleStrategy> strategyMap = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(-1, new UnknownStrategy()), TuplesKt.to(0, new UnlimitedStrategy())});

    public abstract boolean match(RedirectRule redirectRule);

    public RuleStrategy(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    /* compiled from: RuleStrategy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/rule/RuleStrategy$Companion;", "", "()V", "BLOCK", "", "Libra", "TIME", NetworkStackConstant.UNKNOWN_TYPE, "UNLIMITED", "VERSION", "strategyMap", "", "Lcom/bytedance/ies/bullet/redirect/rule/RuleStrategy;", PrefetchRequestConfig.METHOD_GET, "strategyType", "register", "", "strategy", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void register(RuleStrategy strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            RuleStrategy.strategyMap.put(Integer.valueOf(strategy.getType()), strategy);
        }

        public final RuleStrategy get(int strategyType) {
            RuleStrategy ruleStrategy = (RuleStrategy) RuleStrategy.strategyMap.get(Integer.valueOf(strategyType));
            return ruleStrategy == null ? new UnknownStrategy() : ruleStrategy;
        }
    }
}
