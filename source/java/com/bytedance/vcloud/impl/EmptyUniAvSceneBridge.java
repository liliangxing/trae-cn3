package com.bytedance.vcloud.impl;

import kotlin.Metadata;

/* compiled from: UniAvSceneBridge.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/vcloud/impl/EmptyUniAvSceneBridge;", "Lcom/bytedance/vcloud/impl/UniAvSceneBridge;", "()V", "close", "", "getPtr", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmptyUniAvSceneBridge implements UniAvSceneBridge {
    public static final EmptyUniAvSceneBridge INSTANCE = new EmptyUniAvSceneBridge();

    @Override // java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.vcloud.impl.UniAvSceneBridge
    public long getPtr() {
        return 0L;
    }

    private EmptyUniAvSceneBridge() {
    }
}
