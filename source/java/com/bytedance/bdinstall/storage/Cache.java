package com.bytedance.bdinstall.storage;

import android.text.TextUtils;
import com.bytedance.bdinstall.Utils;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Cache implements ICache {
    private Cache mSuccessor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface ICacheAgent<L> {
        boolean checkValid(L l);

        L getCache();

        boolean isValueEqual(L l, L l2);

        L load(L l, L l2, Cache cache);

        void restoreCache(L l);
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public abstract void cacheString(String str, String str2);

    protected abstract void cacheStringArray(String str, String[] strArr);

    @Override // com.bytedance.bdinstall.storage.ICache
    public abstract String getCachedString(String str);

    protected abstract String[] getCachedStringArray(String str);

    private Cache getSuccessor() {
        return this.mSuccessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSuccessor(Cache cache) {
        this.mSuccessor = cache;
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadOpenUdid(String str, String str2) {
        return (String) load(str, str2, new ICacheAgent<String>() { // from class: com.bytedance.bdinstall.storage.Cache.1
            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String getCache() {
                return Cache.this.getCachedString("openudid");
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean checkValid(String str3) {
                return Utils.isValidUDID(str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public void restoreCache(String str3) {
                Cache.this.cacheString("openudid", str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String load(String str3, String str4, Cache cache) {
                return cache == null ? str3 : cache.loadOpenUdid(str3, str4);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean isValueEqual(String str3, String str4) {
                return Utils.equal(str3, str4);
            }
        });
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadClientUdid(String str, String str2) {
        return (String) load(str, str2, new ICacheAgent<String>() { // from class: com.bytedance.bdinstall.storage.Cache.2
            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String getCache() {
                return Cache.this.getCachedString("clientudid");
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean checkValid(String str3) {
                return Utils.isValidUDID(str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public void restoreCache(String str3) {
                Cache.this.cacheString("clientudid", str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String load(String str3, String str4, Cache cache) {
                return cache == null ? str3 : cache.loadClientUdid(str3, str4);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean isValueEqual(String str3, String str4) {
                return Utils.equal(str3, str4);
            }
        });
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadSerialNumber(String str, String str2) {
        return (String) load(str, str2, new ICacheAgent<String>() { // from class: com.bytedance.bdinstall.storage.Cache.3
            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String getCache() {
                return Cache.this.getCachedString("serial_number");
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean checkValid(String str3) {
                return (TextUtils.isEmpty(str3) || TextUtils.equals(str3, "unknown")) ? false : true;
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public void restoreCache(String str3) {
                Cache.this.cacheString("serial_number", str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String load(String str3, String str4, Cache cache) {
                return cache == null ? str3 : cache.loadSerialNumber(str3, str4);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean isValueEqual(String str3, String str4) {
                return Utils.equal(str3, str4);
            }
        });
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String[] loadAccId(String[] strArr, String[] strArr2) {
        return (String[]) load(strArr, strArr2, new ICacheAgent<String[]>() { // from class: com.bytedance.bdinstall.storage.Cache.4
            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String[] getCache() {
                return Cache.this.getCachedStringArray("sim_serial_number");
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean checkValid(String[] strArr3) {
                return strArr3 != null && strArr3.length > 0;
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public void restoreCache(String[] strArr3) {
                Cache.this.cacheStringArray("sim_serial_number", strArr3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String[] load(String[] strArr3, String[] strArr4, Cache cache) {
                return cache == null ? strArr3 : cache.loadAccId(strArr3, strArr4);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean isValueEqual(String[] strArr3, String[] strArr4) {
                if (strArr3 == strArr4) {
                    return true;
                }
                if (strArr3 == null || strArr4 == null || strArr3.length != strArr4.length) {
                    return false;
                }
                for (String str : strArr3) {
                    boolean z = false;
                    for (String str2 : strArr4) {
                        z = Utils.equal(str2, str) || z;
                    }
                    if (!z) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadUdid(String str, String str2) {
        return (String) load(str, str2, new ICacheAgent<String>() { // from class: com.bytedance.bdinstall.storage.Cache.5
            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String getCache() {
                return Cache.this.getCachedString("udid");
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean checkValid(String str3) {
                return Utils.isValidUDID(str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public void restoreCache(String str3) {
                Cache.this.cacheString("udid", str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String load(String str3, String str4, Cache cache) {
                return cache == null ? str3 : cache.loadUdid(str3, str4);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean isValueEqual(String str3, String str4) {
                return Utils.equal(str3, str4);
            }
        });
    }

    @Override // com.bytedance.bdinstall.storage.ICache
    public String loadDeviceId(String str, String str2) {
        return (String) load(str, str2, new ICacheAgent<String>() { // from class: com.bytedance.bdinstall.storage.Cache.6
            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String getCache() {
                return Cache.this.getCachedString("device_id");
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean checkValid(String str3) {
                return !TextUtils.isEmpty(str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public void restoreCache(String str3) {
                Cache.this.cacheString("device_id", str3);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public String load(String str3, String str4, Cache cache) {
                return cache == null ? str3 : cache.loadDeviceId(str3, str4);
            }

            @Override // com.bytedance.bdinstall.storage.Cache.ICacheAgent
            public boolean isValueEqual(String str3, String str4) {
                return Utils.equal(str3, str4);
            }
        });
    }

    private <T> T load(T t, T t2, ICacheAgent<T> iCacheAgent) {
        boolean z;
        if (iCacheAgent == null) {
            throw new IllegalArgumentException("agent == null");
        }
        Cache successor = getSuccessor();
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

    @Override // com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> list) {
        Cache successor = getSuccessor();
        if (successor != null) {
            successor.clear(list);
        }
    }
}
