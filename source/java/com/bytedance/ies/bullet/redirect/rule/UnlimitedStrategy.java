package com.bytedance.ies.bullet.redirect.rule;

import com.bytedance.ies.bullet.redirect.data.RedirectRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnlimitedStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/rule/UnlimitedStrategy;", "Lcom/bytedance/ies/bullet/redirect/rule/RuleStrategy;", "()V", "match", "", "redirectRule", "Lcom/bytedance/ies/bullet/redirect/data/RedirectRule;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UnlimitedStrategy extends RuleStrategy {
    @Override // com.bytedance.ies.bullet.redirect.rule.RuleStrategy
    public boolean match(RedirectRule redirectRule) {
        Intrinsics.checkNotNullParameter(redirectRule, "redirectRule");
        return true;
    }

    public UnlimitedStrategy() {
        super(0);
    }
}
