package com.ss.android.deviceregister.core.cache.internal;

import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;

/* loaded from: classes7.dex */
public abstract class CacheHelper {
    private CacheHelper mSuccessor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface ICacheAgent<L> {
        boolean checkValid(L l);

        L getCache();

        boolean isValueEqual(L l, L l2);

        L load(L l, L l2, CacheHelper cacheHelper);

        void restoreCache(L l);
    }

    protected abstract void cacheString(String str, String str2);

    protected abstract String getCachedString(String str);

    private CacheHelper getSuccessor() {
        return this.mSuccessor;
    }

    public void setSuccessor(CacheHelper cacheHelper) {
        this.mSuccessor = cacheHelper;
    }

    public String loadDeviceId(String str, String str2) {
        return (String) load(str, str2, new ICacheAgent<String>() { // from class: com.ss.android.deviceregister.core.cache.internal.CacheHelper.1
            @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper.ICacheAgent
            public String getCache() {
                return CacheHelper.this.getCachedString("device_id");
            }

            @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper.ICacheAgent
            public boolean checkValid(String str3) {
                return !TextUtils.isEmpty(str3);
            }

            @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper.ICacheAgent
            public void restoreCache(String str3) {
                CacheHelper.this.cacheString("device_id", str3);
            }

            @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper.ICacheAgent
            public String load(String str3, String str4, CacheHelper cacheHelper) {
                return cacheHelper == null ? str3 : cacheHelper.loadDeviceId(str3, str4);
            }

            @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper.ICacheAgent
            public boolean isValueEqual(String str3, String str4) {
                return StringUtils.equal(str3, str4);
            }
        });
    }

    private <T> T load(T t, T t2, ICacheAgent<T> iCacheAgent) {
        boolean z;
        if (iCacheAgent == null) {
            throw new IllegalArgumentException("agent == null");
        }
        CacheHelper successor = getSuccessor();
        T cache = iCacheAgent.getCache();
        boolean checkValid = iCacheAgent.checkValid(t);
        boolean checkValid2 = iCacheAgent.checkValid(cache);
        if (!checkValid && checkValid2) {
            t = cache;
        }
        if (successor != null) {
            T load = iCacheAgent.load(t, t2, successor);
            if (!iCacheAgent.isValueEqual(load, cache)) {
                iCacheAgent.restoreCache(load);
            }
            return load;
        }
        if (checkValid || checkValid2) {
            t2 = t;
            z = false;
        } else {
            z = true;
        }
        if ((z && iCacheAgent.checkValid(t2)) || (checkValid && !iCacheAgent.isValueEqual(t2, cache))) {
            iCacheAgent.restoreCache(t2);
        }
        return t2;
    }

    public void clear(String str) {
        CacheHelper successor = getSuccessor();
        if (successor != null) {
            successor.clear(str);
        }
    }
}
