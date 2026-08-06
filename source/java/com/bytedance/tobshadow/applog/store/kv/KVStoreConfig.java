package com.bytedance.tobshadow.applog.store.kv;

/* loaded from: classes5.dex */
public class KVStoreConfig {
    public static final KVStoreConfig DEFAULT_CONFIG = new KVStoreConfig();
    public static final KVStoreConfig DEFAULT_SECURITY_CONFIG = new KVStoreConfig(true);
    public String aesKey;
    public boolean isSecurityMode;

    public KVStoreConfig() {
        this.isSecurityMode = false;
        this.aesKey = null;
    }

    public KVStoreConfig(boolean z) {
        this.aesKey = null;
        this.isSecurityMode = z;
    }

    public KVStoreConfig(boolean z, String str) {
        this.isSecurityMode = z;
        this.aesKey = str;
    }

    public static KVStoreConfig createCustomASEKeySecurityConfig(String str) {
        return new KVStoreConfig(true, str);
    }

    public String getAesKey() {
        return this.aesKey;
    }

    public boolean isSecurityMode() {
        return this.isSecurityMode;
    }
}
