package com.bytedance.ies.bullet.core.model.context;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextProviderFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u0003B(\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R!\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006¢\u0006\u0002\b\u0007X\u0088\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u0088\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/core/model/context/WeakHostContextHolder;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lcom/bytedance/ies/bullet/core/model/context/IContextProvider;", "host", "provider", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "ref", "Ljava/lang/ref/WeakReference;", "provideInstance", "()Ljava/lang/Object;", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WeakHostContextHolder<T, R> implements IContextProvider<R> {
    private final Function1<T, R> provider;
    private WeakReference<T> ref;

    /* JADX WARN: Multi-variable type inference failed */
    public WeakHostContextHolder(T t, Function1<? super T, ? extends R> provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.provider = provider;
        this.ref = new WeakReference<>(t);
    }

    @Override // com.bytedance.ies.bullet.core.model.context.IContextProvider
    public R provideInstance() {
        T t;
        WeakReference<T> weakReference = this.ref;
        if (weakReference == null || (t = weakReference.get()) == null) {
            return null;
        }
        return this.provider.invoke(t);
    }

    @Override // com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
        WeakReference<T> weakReference = this.ref;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.ref = null;
    }
}
