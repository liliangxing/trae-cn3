package com.bytedance.ies.xbridge.model.context;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: XContextProviderFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0088\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xbridge/model/context/XContextHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/xbridge/model/context/IXContextProvider;", "t", "(Ljava/lang/Object;)V", "ref", "Ljava/lang/Object;", "provideInstance", "()Ljava/lang/Object;", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class XContextHolder<T> implements IXContextProvider<T> {
    private T ref;

    public XContextHolder(T t) {
        this.ref = t;
    }

    @Override // com.bytedance.ies.xbridge.model.context.IXContextProvider
    public T provideInstance() {
        return this.ref;
    }

    @Override // com.bytedance.ies.xbridge.api.IReleasable
    public void release() {
        this.ref = null;
    }
}
