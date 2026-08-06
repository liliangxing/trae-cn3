package com.ss.ttm.utils;

import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class InitConfig {
    static final int Chain = 0;
    static final int Copy = 1;
    static ConfigFactory gFactory;
    private static volatile boolean mHasTriedGetMethod;
    static Method sMethodCreate;
    private boolean committed = false;
    private ConfigAPI mNative;

    public static void setFactory(ConfigFactory f) {
        gFactory = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InitConfig(long handle, int t) {
        this.mNative = null;
        ConfigFactory configFactory = gFactory;
        if (configFactory != null) {
            this.mNative = configFactory.createConfig(handle, t);
            return;
        }
        if (!mHasTriedGetMethod) {
            synchronized (InitConfig.class) {
                if (!mHasTriedGetMethod) {
                    mHasTriedGetMethod = true;
                    try {
                        sMethodCreate = Class.forName("com.ss.ttm.utils.ConfigImpl").getDeclaredMethod("create", Long.TYPE, Integer.TYPE);
                    } catch (Exception unused) {
                        sMethodCreate = null;
                    }
                }
            }
        }
        Method method = sMethodCreate;
        if (method == null) {
            return;
        }
        try {
            method.setAccessible(true);
            this.mNative = (ConfigAPI) sMethodCreate.invoke(null, Long.valueOf(handle), Integer.valueOf(t));
        } catch (Exception unused2) {
        }
    }

    public long nativeHandle() {
        ConfigAPI configAPI = this.mNative;
        if (configAPI == null) {
            return 0L;
        }
        return configAPI.nativeHandle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void commit() {
        this.committed = true;
    }

    public void setIntValue(int key, int value) {
        ConfigAPI configAPI = this.mNative;
        if (configAPI == null || this.committed) {
            return;
        }
        configAPI.setIntValue(key, value);
    }

    public int getIntValue(int key, int dValue) {
        ConfigAPI configAPI = this.mNative;
        return configAPI != null ? configAPI.getIntValue(key, dValue) : dValue;
    }

    public void release() {
        ConfigAPI configAPI = this.mNative;
        this.mNative = null;
        if (configAPI != null) {
            configAPI.release();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }
}
