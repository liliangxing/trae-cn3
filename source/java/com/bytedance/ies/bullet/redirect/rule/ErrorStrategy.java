package com.bytedance.ies.bullet.redirect.rule;

import com.bytedance.ies.bullet.redirect.data.RedirectRule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/rule/ErrorStrategy;", "Lcom/bytedance/ies/bullet/redirect/rule/RuleStrategy;", "ruleType", "", "msg", "", "(ILjava/lang/String;)V", "match", "", "redirectRule", "Lcom/bytedance/ies/bullet/redirect/data/RedirectRule;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ErrorStrategy extends RuleStrategy {
    private final String msg;
    private final int ruleType;

    public /* synthetic */ ErrorStrategy(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorStrategy(int i, String str) {
        super(i);
        Intrinsics.checkNotNullParameter(str, "msg");
        this.ruleType = i;
        this.msg = str;
    }

    @Override // com.bytedance.ies.bullet.redirect.rule.RuleStrategy
    public boolean match(RedirectRule redirectRule) {
        Intrinsics.checkNotNullParameter(redirectRule, "redirectRule");
        throw new IllegalStateException(("illegal rule for " + this.msg).toString());
    }
}
