package com.bytedance.sdk.xbridge.cn.registry.core;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* compiled from: IBDXBridgeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u000f\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R#\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\b\u0002 \u0007*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u0006X\u0088\u000eø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/XWeakContextHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/sdk/xbridge/cn/registry/core/IXContextProvider;", "t", "(Ljava/lang/Object;)V", "ref", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "provideInstance", "()Ljava/lang/Object;", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class XWeakContextHolder<T> implements IXContextProvider<T> {
    private WeakReference<T> ref;

    public XWeakContextHolder(T t) {
        this.ref = t == null ? null : new WeakReference<>(t);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IXContextProvider
    public T provideInstance() {
        WeakReference<T> weakReference = this.ref;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IXContextProvider
    public void release() {
        WeakReference<T> weakReference = this.ref;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.ref = null;
    }
}
