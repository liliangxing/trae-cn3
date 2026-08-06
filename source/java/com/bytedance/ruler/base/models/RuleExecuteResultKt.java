package com.bytedance.ruler.base.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuleExecuteResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"isSuccess", "", "Lcom/bytedance/ruler/base/models/ExprResponse;", "toRuleExecuteResult", "Lcom/bytedance/ruler/base/models/RuleExecuteResult;", "ruleModel", "Lcom/bytedance/ruler/base/models/RuleModel;", "ruler-base_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RuleExecuteResultKt {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r10.getResult(), true) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final RuleExecuteResult toRuleExecuteResult(ExprResponse exprResponse, RuleModel ruleModel) {
        Intrinsics.checkParameterIsNotNull(exprResponse, "$this$toRuleExecuteResult");
        Intrinsics.checkParameterIsNotNull(ruleModel, "ruleModel");
        boolean z = exprResponse.getCode() == 0;
        return new RuleExecuteResult(exprResponse.getCode(), exprResponse.getMsg(), null, exprResponse.getThrowable(), z ? ruleModel.getConf() : null, 4, null);
    }

    public static final boolean isSuccess(ExprResponse exprResponse) {
        Intrinsics.checkParameterIsNotNull(exprResponse, "$this$isSuccess");
        return exprResponse.getCode() == 0 && Intrinsics.areEqual(exprResponse.getResult(), true);
    }
}
