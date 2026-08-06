package com.bytedance.ruler.base.models;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ruler.base.interfaces.Func;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AbsValidator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\f2\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\nH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R$\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ruler/base/models/AbsValidator;", "", "()V", "ruleExecBreak", "", "getRuleExecBreak", "()Z", "selectStrategyBreak", "getSelectStrategyBreak", StrategyConstants.STRATEGIES, "", "", "", "Lcom/bytedance/ruler/base/models/RuleHardCodeModel;", "getStrategies", "()Ljava/util/Map;", "selectStrategy", "params", "needBreak", "extraFunctions", "Lcom/bytedance/ruler/base/interfaces/Func;", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public abstract class AbsValidator {
    public abstract boolean getRuleExecBreak();

    public abstract boolean getSelectStrategyBreak();

    public abstract Map<String, List<RuleHardCodeModel>> getStrategies();

    public abstract List<String> selectStrategy(Map<String, ?> params, boolean needBreak, Map<String, ? extends Func> extraFunctions);
}
