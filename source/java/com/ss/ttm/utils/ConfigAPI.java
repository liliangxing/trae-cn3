package com.ss.ttm.utils;

/* loaded from: classes7.dex */
abstract class ConfigAPI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getIntValue(int key, int dValue);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long nativeHandle();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void release();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setIntValue(int key, int value);
}
