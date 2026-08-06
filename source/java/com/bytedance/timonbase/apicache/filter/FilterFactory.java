package com.bytedance.timonbase.apicache.filter;

import com.bytedance.timonbase.apicache.ApiArgs;
import com.bytedance.timonbase.commoncache.filter.ParametersFilter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilterFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/timonbase/apicache/filter/FilterFactory;", "", "()V", "globalFilters", "", "", "Lcom/bytedance/timonbase/commoncache/filter/ParametersFilter;", "Lcom/bytedance/timonbase/apicache/ApiArgs;", "getFilter", "name", "registerParametersFilter", "", "filter", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FilterFactory {
    public static final FilterFactory INSTANCE = new FilterFactory();
    private static final Map<String, ParametersFilter<ApiArgs>> globalFilters = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("android_id", AndroidIdFilter.INSTANCE)});

    private FilterFactory() {
    }

    public final void registerParametersFilter(String name, ParametersFilter<ApiArgs> filter) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(filter, "filter");
        globalFilters.put(name, filter);
    }

    public final ParametersFilter<ApiArgs> getFilter(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        return globalFilters.get(name);
    }
}
