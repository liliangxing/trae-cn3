package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorCoreValidator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eB/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/salamander/anniex/ValidationResult;", "VALUE", "", "success", "", "(Z)V", "reason", "", "code", "Lcom/bytedance/salamander/anniex/ValidateResultCode;", "fieldLength", "", "(ZLjava/lang/String;Lcom/bytedance/salamander/anniex/ValidateResultCode;I)V", "field", "(ZLjava/lang/String;Lcom/bytedance/salamander/anniex/ValidateResultCode;Ljava/lang/Object;)V", "(ZLjava/lang/String;Lcom/bytedance/salamander/anniex/ValidateResultCode;ILjava/lang/Object;)V", "validatedField", "Ljava/lang/Object;", "getCode", "", "getFieldLength", "getValue", "()Ljava/lang/Object;", "getValueWhenSuccess", "isInvalidInput", "isSuccess", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class ValidationResult<VALUE> {
    private ValidateResultCode code;
    private int fieldLength;
    private String reason;
    private boolean success;
    private VALUE validatedField;

    public ValidationResult(boolean z) {
        this.code = ValidateResultCode.Fail;
        this.success = z;
    }

    public ValidationResult(boolean z, String reason, ValidateResultCode code, int i) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(code, "code");
        ValidateResultCode validateResultCode = ValidateResultCode.Fail;
        this.success = z;
        this.reason = reason;
        this.code = code;
        this.fieldLength = i;
    }

    public ValidationResult(boolean z, String reason, ValidateResultCode code, VALUE value) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(code, "code");
        ValidateResultCode validateResultCode = ValidateResultCode.Fail;
        this.success = z;
        this.reason = reason;
        this.code = code;
        this.validatedField = value;
    }

    public ValidationResult(boolean z, String reason, ValidateResultCode code, int i, VALUE value) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(code, "code");
        ValidateResultCode validateResultCode = ValidateResultCode.Fail;
        this.success = z;
        this.reason = reason;
        this.code = code;
        this.fieldLength = i;
        this.validatedField = value;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean isInvalidInput() {
        return this.code == ValidateResultCode.Invalid_input;
    }

    public VALUE getValueWhenSuccess() {
        if (this.success) {
            return this.validatedField;
        }
        return null;
    }

    public VALUE getValue() {
        return this.validatedField;
    }

    public long getCode() {
        return this.code.getValue();
    }

    public int getFieldLength() {
        return this.fieldLength;
    }
}
