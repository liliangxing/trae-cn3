package com.bytedance.ruler.base.models;

import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: RuleExecuteResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ruler/base/models/RuleExecuteResult;", "", "code", "", "msg", "", "ruleModel", "Lcom/bytedance/ruler/base/models/RuleModel;", "error", "", "result", "Lcom/google/gson/JsonElement;", "(ILjava/lang/String;Lcom/bytedance/ruler/base/models/RuleModel;Ljava/lang/Throwable;Lcom/google/gson/JsonElement;)V", "getCode", "()I", "getError", "()Ljava/lang/Throwable;", "getMsg", "()Ljava/lang/String;", "getResult", "()Lcom/google/gson/JsonElement;", "getRuleModel", "()Lcom/bytedance/ruler/base/models/RuleModel;", "setRuleModel", "(Lcom/bytedance/ruler/base/models/RuleModel;)V", "toString", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class RuleExecuteResult {
    private final int code;
    private final Throwable error;
    private final String msg;
    private final JsonElement result;
    private RuleModel ruleModel;

    public RuleExecuteResult() {
        this(0, null, null, null, null, 31, null);
    }

    public RuleExecuteResult(int i, String str, RuleModel ruleModel, Throwable th, JsonElement jsonElement) {
        this.code = i;
        this.msg = str;
        this.ruleModel = ruleModel;
        this.error = th;
        this.result = jsonElement;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RuleExecuteResult(int i, String str, RuleModel ruleModel, Throwable th, JsonElement jsonElement, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, r10, r1, r2, r0);
        String str2;
        RuleModel ruleModel2;
        Throwable th2;
        i = (i2 & 1) != 0 ? -1 : i;
        JsonElement jsonElement2 = null;
        if ((i2 & 2) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i2 & 4) != 0) {
            ruleModel2 = null;
        } else {
            ruleModel2 = ruleModel;
        }
        if ((i2 & 8) != 0) {
            th2 = null;
        } else {
            th2 = th;
        }
        if ((i2 & 16) != 0) {
        } else {
            jsonElement2 = jsonElement;
        }
    }

    public final String getMsg() {
        return this.msg;
    }

    public final RuleModel getRuleModel() {
        return this.ruleModel;
    }

    public final void setRuleModel(RuleModel ruleModel) {
        this.ruleModel = ruleModel;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final JsonElement getResult() {
        return this.result;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("[code = ").append(this.code).append(", ruleModel=");
        RuleModel ruleModel = this.ruleModel;
        return append.append(ruleModel != null ? ruleModel.toString() : null).append(", msg = ").append(this.msg).append(", error = ").append(this.error).append(", result = ").append(this.result).append(AbstractJsonLexerKt.END_LIST).toString();
    }
}
