package com.ss.ttm.utils;

import com.ss.ttm.player.TTPlayer;

/* loaded from: classes7.dex */
public class ConfigImpl extends ConfigAPI {
    private long mHandle;

    private static native long _nativeCopy(long handle);

    private static native long _nativeCreate(long handle);

    private static native int _nativeGetInt(long handle, int key, int dValue);

    private static native void _nativeRelease(long handle);

    private static native void _nativeSetInt(long handle, int key, int value);

    static {
        TTPlayer.getAppPath();
    }

    static ConfigAPI create(long handle, int t) {
        return new ConfigImpl(handle, t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigImpl(long handle, int t) {
        this.mHandle = 0L;
        if (t == 0) {
            this.mHandle = _nativeCreate(handle);
        } else if (t == 1) {
            this.mHandle = _nativeCopy(handle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ss.ttm.utils.ConfigAPI
    public void setIntValue(int key, int value) {
        long j = this.mHandle;
        if (j != 0) {
            _nativeSetInt(j, key, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ss.ttm.utils.ConfigAPI
    public int getIntValue(int key, int dValue) {
        long j = this.mHandle;
        return j != 0 ? _nativeGetInt(j, key, dValue) : dValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ss.ttm.utils.ConfigAPI
    public long nativeHandle() {
        return this.mHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ss.ttm.utils.ConfigAPI
    public void release() {
        long j = this.mHandle;
        if (j != 0) {
            this.mHandle = 0L;
            _nativeRelease(j);
        }
    }
}
