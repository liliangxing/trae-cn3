package com.bytedance.ies.bullet.service.base.api;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IServiceContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\nH&J#\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\bH\u0016¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\bH\u0016¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "", "serviceContext", "Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "getServiceContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "getAllDependency", "", "Ljava/lang/Class;", "getBid", "", "getDependency", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "getService", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IServiceToken {
    Map<Class<?>, Object> getAllDependency();

    String getBid();

    <T> T getDependency(Class<T> clazz);

    <T extends IBulletService> T getService(Class<T> clazz);

    IServiceContext getServiceContext();

    /* compiled from: IServiceContext.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static <T extends IBulletService> T getService(IServiceToken iServiceToken, Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (T) ServiceCenter.INSTANCE.instance().get(iServiceToken.getBid(), clazz);
        }

        public static <T> T getDependency(IServiceToken iServiceToken, Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (T) iServiceToken.getServiceContext().getDependency(clazz);
        }

        public static Map<Class<?>, Object> getAllDependency(IServiceToken iServiceToken) {
            return iServiceToken.getServiceContext().getAllDependency();
        }
    }
}
