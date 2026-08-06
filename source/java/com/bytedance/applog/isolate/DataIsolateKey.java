package com.bytedance.applog.isolate;

/* loaded from: classes3.dex */
public enum DataIsolateKey {
    USER_ID("user_id");

    private final String key;

    DataIsolateKey(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }

    public static DataIsolateKey fromKey(String str) {
        for (DataIsolateKey dataIsolateKey : values()) {
            if (dataIsolateKey.getKey().equals(str)) {
                return dataIsolateKey;
            }
        }
        return null;
    }
}
