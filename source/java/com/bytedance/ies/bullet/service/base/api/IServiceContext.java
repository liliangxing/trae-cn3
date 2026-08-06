package com.bytedance.ies.bullet.service.base.api;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IServiceContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u000f\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0016J#\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0011H\u0016¢\u0006\u0002\u0010\u0015J+\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00112\b\u0010\u0018\u001a\u0004\u0018\u0001H\u0013H\u0016¢\u0006\u0002\u0010\u0019R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "extra", "Lcom/bytedance/ies/bullet/service/base/api/IDependencyProvider;", "getExtra", "()Lcom/bytedance/ies/bullet/service/base/api/IDependencyProvider;", "isDebug", "", "()Z", "getAllDependency", "", "Ljava/lang/Class;", "getDependency", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "putDependency", "", "instance", "(Ljava/lang/Class;Ljava/lang/Object;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IServiceContext {
    Map<Class<?>, Object> getAllDependency();

    Context getContext();

    <T> T getDependency(Class<T> clazz);

    IDependencyProvider getExtra();

    boolean isDebug();

    <T> void putDependency(Class<T> clazz, T instance);

    void setContext(Context context);

    /* compiled from: IServiceContext.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static <T> void putDependency(IServiceContext iServiceContext, Class<T> clazz, T t) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            iServiceContext.getExtra().put(clazz, t);
        }

        public static <T> T getDependency(IServiceContext iServiceContext, Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (T) iServiceContext.getExtra().get(clazz);
        }

        public static Map<Class<?>, Object> getAllDependency(IServiceContext iServiceContext) {
            return iServiceContext.getExtra().getAll();
        }
    }
}
