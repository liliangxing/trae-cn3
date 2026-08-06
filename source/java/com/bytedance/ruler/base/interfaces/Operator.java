package com.bytedance.ruler.base.interfaces;

import com.bytedance.ruler.base.models.ExprException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Operator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000fJ\"\u0010\u0011\u001a\u00020\u00122\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ruler/base/interfaces/Operator;", "", "symbol", "", "priority", "", "argsLength", "(Ljava/lang/String;II)V", "getArgsLength", "()I", "getPriority", "getSymbol", "()Ljava/lang/String;", "execute", "params", "", "getParamsType", "validateParams", "", "isValidateNullParam", "", "Companion", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public abstract class Operator {
    public static final String PARAM_TYPE_BOOLEAN = "param_type_boolean";
    public static final String PARAM_TYPE_DOUBLE = "param_type_double";
    public static final String PARAM_TYPE_NUMBER = "param_type_number";
    public static final String PARAM_TYPE_OTHER = "param_type_other";
    private final int argsLength;
    private final int priority;
    private final String symbol;

    public abstract Object execute(List<? extends Object> params);

    public Operator(String symbol, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(symbol, "symbol");
        this.symbol = symbol;
        this.priority = i;
        this.argsLength = i2;
    }

    public final int getArgsLength() {
        return this.argsLength;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public static /* synthetic */ void validateParams$default(Operator operator, List list, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateParams");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        operator.validateParams(list, z);
    }

    public final void validateParams(List<? extends Object> params, boolean isValidateNullParam) {
        List<? extends Object> list = params;
        if (list == null || list.isEmpty()) {
            throw new ExprException(101, "params error: params isNullOrEmpty");
        }
        int size = params.size();
        int i = this.argsLength;
        if (size < i) {
            throw new ExprException(101, "params error: params.size() < operator.argsLength");
        }
        if (isValidateNullParam) {
            for (int i2 = 0; i2 < i; i2++) {
                if (params.get(i2) == null) {
                    throw new ExprException(101, "params error: param is null");
                }
            }
        }
    }

    public final String getParamsType(List<? extends Object> params) {
        boolean z;
        boolean z2;
        List<? extends Object> list = params;
        boolean z3 = false;
        if (list == null || list.isEmpty()) {
            z = false;
            z2 = false;
        } else {
            int i = this.argsLength;
            boolean z4 = true;
            z = true;
            z2 = false;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = params.get(i2);
                if (!(obj instanceof Number)) {
                    z4 = false;
                }
                if (!(obj instanceof Boolean)) {
                    z = false;
                }
                if ((obj instanceof Float) || (obj instanceof Double)) {
                    z2 = true;
                }
            }
            z3 = z4;
        }
        return z3 ? z2 ? PARAM_TYPE_DOUBLE : PARAM_TYPE_NUMBER : z ? PARAM_TYPE_BOOLEAN : PARAM_TYPE_OTHER;
    }
}
