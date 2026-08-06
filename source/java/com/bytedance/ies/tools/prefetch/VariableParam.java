package com.bytedance.ies.tools.prefetch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/VariableParam;", "Lcom/bytedance/ies/tools/prefetch/TypedParam;", "", "value", "(Ljava/lang/String;)V", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class VariableParam extends TypedParam<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableParam(String value) {
        super(value, null);
        Intrinsics.checkParameterIsNotNull(value, "value");
    }
}
