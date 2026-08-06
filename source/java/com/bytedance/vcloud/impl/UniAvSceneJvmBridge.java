package com.bytedance.vcloud.impl;

import kotlin.Metadata;

/* compiled from: UniAvScene.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/vcloud/impl/UniAvSceneJvmBridge;", "Lcom/bytedance/vcloud/impl/UniAvSceneBridge;", "ptr", "", "(J)V", "close", "", "getPtr", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UniAvSceneJvmBridge implements UniAvSceneBridge {
    private long ptr;

    public UniAvSceneJvmBridge(long j) {
        this.ptr = j;
    }

    @Override // com.bytedance.vcloud.impl.UniAvSceneBridge
    public long getPtr() {
        return this.ptr;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        long j = this.ptr;
        if (j == 0) {
            return;
        }
        this.ptr = 0L;
        AVManagerJvmBridge.INSTANCE.decScene(j);
    }
}
