package com.bytedance.ies.bullet.service.base.impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.base.api.IInstanceProvider;
import kotlin.Metadata;

/* compiled from: DefaultDependencyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\r\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/DefaultInstanceProvider;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/bullet/service/base/api/IInstanceProvider;", "instance", "(Ljava/lang/Object;)V", "getInstance", "()Ljava/lang/Object;", "Ljava/lang/Object;", "provideInstance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultInstanceProvider<T> implements IInstanceProvider<T> {
    private final T instance;

    public DefaultInstanceProvider(T t) {
        this.instance = t;
    }

    public final T getInstance() {
        return this.instance;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IInstanceProvider
    public T provideInstance() {
        return this.instance;
    }
}
