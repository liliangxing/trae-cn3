package com.bytedance.timonbase.apicache.filter;

import com.bytedance.timonbase.apicache.ApiArgs;
import com.bytedance.timonbase.commoncache.filter.ParametersFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidIdFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/timonbase/apicache/filter/AndroidIdFilter;", "Lcom/bytedance/timonbase/commoncache/filter/ParametersFilter;", "Lcom/bytedance/timonbase/apicache/ApiArgs;", "()V", "shouldCache", "", "args", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class AndroidIdFilter implements ParametersFilter<ApiArgs> {
    public static final AndroidIdFilter INSTANCE = new AndroidIdFilter();

    private AndroidIdFilter() {
    }

    @Override // com.bytedance.timonbase.commoncache.filter.ParametersFilter
    public boolean shouldCache(ApiArgs args) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(args, "args");
        Object[] parameters = args.getParameters();
        if (parameters != null) {
            if (!(parameters.length == 0)) {
                z = false;
                return z && args.getParameters().length >= 2 && Intrinsics.areEqual(args.getParameters()[1], "android_id");
            }
        }
        z = true;
        if (z) {
        }
    }
}
