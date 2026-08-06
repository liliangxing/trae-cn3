package com.bytedance.pia.core.cache;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPiaCacheProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isValid", "", "Lcom/bytedance/pia/core/cache/IPiaCacheProvider;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class IPiaCacheProviderKt {
    public static final boolean isValid(IPiaCacheProvider iPiaCacheProvider) {
        Intrinsics.checkNotNullParameter(iPiaCacheProvider, "<this>");
        Number expire = iPiaCacheProvider.getCacheConfig().getExpire();
        return (expire == null || TextUtils.isEmpty(iPiaCacheProvider.getCacheConfig().getVersion()) || TextUtils.isEmpty(iPiaCacheProvider.getCacheContent()) || expire.longValue() <= System.currentTimeMillis()) ? false : true;
    }
}
