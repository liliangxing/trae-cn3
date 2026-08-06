package com.bytedance.compression.zstd;

/* loaded from: classes3.dex */
abstract class SharedDictBase extends AutoCloseBase {
    protected void finalize() {
        close();
    }
}
