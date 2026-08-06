package com.bytedance.ies.bullet.service.base.api;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IServiceContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&J+\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\b\u0010\u000b\u001a\u0004\u0018\u0001H\u0003H&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/IDependencyProvider;", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getAll", "", "put", "", "instance", "(Ljava/lang/Class;Ljava/lang/Object;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IDependencyProvider {
    <T> T get(Class<T> clazz);

    Map<Class<?>, Object> getAll();

    <T> void put(Class<T> clazz, T instance);
}
