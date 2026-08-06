package org.apache.commons.codec.language.bm;

import com.bytedance.android.anniex.pitaya.StrategyConstants;

/* loaded from: classes8.dex */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES(StrategyConstants.RULES);

    private final String name;

    RuleType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
