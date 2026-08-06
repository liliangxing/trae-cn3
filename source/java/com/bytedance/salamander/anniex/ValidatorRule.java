package com.bytedance.salamander.anniex;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorCoreValidator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/salamander/anniex/ValidatorRule;", "", "field", "", "length", "", StrategyConstants.ACTION, "Lcom/bytedance/salamander/anniex/ValidationAction;", "(Ljava/lang/String;ILcom/bytedance/salamander/anniex/ValidationAction;)V", "getAction", "()Lcom/bytedance/salamander/anniex/ValidationAction;", "setAction", "(Lcom/bytedance/salamander/anniex/ValidationAction;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getLength", "()I", "setLength", "(I)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class ValidatorRule {
    public ValidationAction action;
    private String field;
    private int length;

    public String getField() {
        return this.field;
    }

    public void setField(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.field = str;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public ValidationAction getAction() {
        ValidationAction validationAction = this.action;
        if (validationAction != null) {
            return validationAction;
        }
        Intrinsics.throwUninitializedPropertyAccessException(StrategyConstants.ACTION);
        return null;
    }

    public void setAction(ValidationAction validationAction) {
        Intrinsics.checkNotNullParameter(validationAction, "<set-?>");
        this.action = validationAction;
    }

    public ValidatorRule(String field, int i, ValidationAction action) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(action, "action");
        this.field = "";
        setField(field);
        setLength(i);
        setAction(action);
    }
}
