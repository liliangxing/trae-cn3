package com.bytedance.ies.tools.prefetch;

import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00020\u0001B\u001d\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/NestedParam;", "Lcom/bytedance/ies/tools/prefetch/TypedParam;", "Ljava/util/SortedMap;", "", "value", "(Ljava/util/SortedMap;)V", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class NestedParam extends TypedParam<SortedMap<String, TypedParam<?>>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedParam(SortedMap<String, TypedParam<?>> value) {
        super(value, null);
        Intrinsics.checkParameterIsNotNull(value, "value");
    }
}
