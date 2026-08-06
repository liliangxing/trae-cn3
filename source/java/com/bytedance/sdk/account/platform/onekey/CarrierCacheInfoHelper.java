package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import com.bytedance.sdk.account.platform.onekey.carrier.AbsCarrierCacheInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarrierCacheInfoHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/account/platform/onekey/CarrierCacheInfoHelper;", "", "()V", "cacheMap", "", "", "Lcom/bytedance/sdk/account/platform/onekey/carrier/AbsCarrierCacheInfo;", "cleanCarrierCacheInfo", "", "context", "Landroid/content/Context;", "subscriptionId", "getCarrierCacheInfo", "saveCarrierCacheInfo", "onekeyInfoCache", "account-platform-onekey-login_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CarrierCacheInfoHelper {
    public static final CarrierCacheInfoHelper INSTANCE = new CarrierCacheInfoHelper();
    private static final Map<Integer, AbsCarrierCacheInfo> cacheMap = new LinkedHashMap();

    private CarrierCacheInfoHelper() {
    }

    public final AbsCarrierCacheInfo getCarrierCacheInfo(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return getCarrierCacheInfo(NetworkTypeHelper.getDefaultDataSubscriptionId(context));
    }

    public final AbsCarrierCacheInfo getCarrierCacheInfo(int subscriptionId) {
        return cacheMap.get(Integer.valueOf(subscriptionId));
    }

    public final void saveCarrierCacheInfo(AbsCarrierCacheInfo onekeyInfoCache) {
        Intrinsics.checkParameterIsNotNull(onekeyInfoCache, "onekeyInfoCache");
        cacheMap.put(Integer.valueOf(onekeyInfoCache.getSubscriptionId()), onekeyInfoCache);
    }

    public final void cleanCarrierCacheInfo(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        cleanCarrierCacheInfo(NetworkTypeHelper.getDefaultDataSubscriptionId(context));
    }

    public final void cleanCarrierCacheInfo(int subscriptionId) {
        cacheMap.remove(Integer.valueOf(subscriptionId));
    }
}
