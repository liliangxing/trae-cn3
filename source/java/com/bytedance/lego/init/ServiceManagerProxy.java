package com.bytedance.lego.init;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.news.common.service.manager.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceManagerProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0016¢\u0006\u0002\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/lego/init/ServiceManagerProxy;", "Lcom/bytedance/lego/init/IServiceManagerProxy;", "()V", "proxy", "getProxy$initscheduler_release", "()Lcom/bytedance/lego/init/IServiceManagerProxy;", "setProxy$initscheduler_release", "(Lcom/bytedance/lego/init/IServiceManagerProxy;)V", "getService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class ServiceManagerProxy implements IServiceManagerProxy {
    public static final ServiceManagerProxy INSTANCE = new ServiceManagerProxy();
    private static IServiceManagerProxy proxy;

    private ServiceManagerProxy() {
    }

    public final IServiceManagerProxy getProxy$initscheduler_release() {
        return proxy;
    }

    public final void setProxy$initscheduler_release(IServiceManagerProxy iServiceManagerProxy) {
        proxy = iServiceManagerProxy;
    }

    @Override // com.bytedance.lego.init.IServiceManagerProxy
    public <T> T getService(Class<T> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        IServiceManagerProxy iServiceManagerProxy = proxy;
        if (iServiceManagerProxy == null) {
            return (T) ServiceManager.getService(clazz);
        }
        if (iServiceManagerProxy != null) {
            return (T) iServiceManagerProxy.getService(clazz);
        }
        return null;
    }
}
