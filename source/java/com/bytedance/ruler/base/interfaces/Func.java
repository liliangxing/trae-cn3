package com.bytedance.ruler.base.interfaces;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Func.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/ruler/base/interfaces/Func;", "", "symbol", "", "(Ljava/lang/String;)V", "getSymbol", "()Ljava/lang/String;", "execute", "params", "", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public abstract class Func {
    private final String symbol;

    public abstract Object execute(List<? extends Object> params);

    public Func(String symbol) {
        Intrinsics.checkParameterIsNotNull(symbol, "symbol");
        this.symbol = symbol;
    }

    public final String getSymbol() {
        return this.symbol;
    }
}
