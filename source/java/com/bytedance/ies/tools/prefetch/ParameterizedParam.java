package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.tools.prefetch.TypedParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ParameterizedParam;", "Lcom/bytedance/ies/tools/prefetch/TypedParam;", "", "Lcom/bytedance/ies/tools/prefetch/TypedParam$WithSpecifiedType;", "value", "dataType", "(Ljava/lang/String;Ljava/lang/String;)V", "getDataType", "()Ljava/lang/String;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class ParameterizedParam extends TypedParam<String> implements TypedParam.WithSpecifiedType {
    private final String dataType;

    @Override // com.bytedance.ies.tools.prefetch.TypedParam.WithSpecifiedType
    public String getDataType() {
        return this.dataType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParameterizedParam(String value, String dataType) {
        super(value, null);
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(dataType, "dataType");
        this.dataType = dataType;
    }
}
