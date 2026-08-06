package com.bytedance.ug.sdk.deeplink;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ug.sdk.deeplink.api.IClipboardHandler;
import com.bytedance.ug.sdk.deeplink.api.IFissionHandler;
import com.bytedance.ug.sdk.deeplink.api.IService;
import com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi;
import com.bytedance.ug.sdk.deeplink.api.internal.IFissionInternalApi;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UgServiceManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00072\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0007¢\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u00020\u0000\"\b\b\u0000\u0010\n*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00072\u0006\u0010\u0012\u001a\u0002H\n¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ug/sdk/deeplink/UgServiceManager;", "", "()V", "TAG", "", "serviceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/bytedance/ug/sdk/deeplink/api/IService;", PrefetchRequestConfig.METHOD_GET, "T", "clazz", "logError", "", "(Ljava/lang/Class;Z)Lcom/bytedance/ug/sdk/deeplink/api/IService;", "getInternalApi", "(Ljava/lang/Class;)Lcom/bytedance/ug/sdk/deeplink/api/IService;", "register", "obj", "(Ljava/lang/Class;Lcom/bytedance/ug/sdk/deeplink/api/IService;)Lcom/bytedance/ug/sdk/deeplink/UgServiceManager;", "deeplink_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UgServiceManager {
    private static final String TAG = "UgServiceManager";
    public static final UgServiceManager INSTANCE = new UgServiceManager();
    private static final ConcurrentHashMap<Class<?>, IService> serviceMap = new ConcurrentHashMap<>();

    private UgServiceManager() {
    }

    public final <T extends IService> UgServiceManager register(Class<T> clazz, T obj) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        serviceMap.put(clazz, obj);
        return this;
    }

    public static /* synthetic */ IService get$default(UgServiceManager ugServiceManager, Class cls, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return ugServiceManager.get(cls, z);
    }

    public final <T extends IService> T get(Class<T> clazz, boolean logError) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        T t = (T) serviceMap.get(clazz);
        if (t != null) {
            return t;
        }
        if (!logError) {
            return null;
        }
        Logger.m447e(TAG, "The implementation of '" + clazz.getSimpleName() + "' not found, do you add the right dependency?");
        return null;
    }

    public final <T extends IService> T getInternalApi(Class<T> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        if (Intrinsics.areEqual(clazz, IClipboardInternalApi.class)) {
            IClipboardHandler iClipboardHandler = (IClipboardHandler) get(IClipboardHandler.class, false);
            IService clipboardInternalApi = iClipboardHandler != null ? iClipboardHandler.getClipboardInternalApi() : null;
            return clipboardInternalApi instanceof IService ? clipboardInternalApi : null;
        }
        if (!Intrinsics.areEqual(clazz, IFissionInternalApi.class)) {
            return null;
        }
        IFissionHandler iFissionHandler = (IFissionHandler) get(IFissionHandler.class, false);
        IService fissionInternalApi = iFissionHandler != null ? iFissionHandler.getFissionInternalApi() : null;
        return fissionInternalApi instanceof IService ? fissionInternalApi : null;
    }
}
