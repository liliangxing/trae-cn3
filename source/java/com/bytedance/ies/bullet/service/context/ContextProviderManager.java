package com.bytedance.ies.bullet.service.context;

import android.util.Log;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.model.context.IContextProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextProviderManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u001a\u0010\f\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0006J1\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\b\u0010\u0012\u001a\u0004\u0018\u0001H\u000f¢\u0006\u0002\u0010\u0013J0\u0010\u0014\u001a\u00020\n\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0016J1\u0010\u0017\u001a\u00020\n\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00112\b\u0010\u0012\u001a\u0004\u0018\u0001H\u000f¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0018\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/context/ContextProviderManager;", "", "()V", "providerFactoryMap", "", "", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getProviderFactory", "sessionId", "mergeProviderFactory", "", "sessionIdNeedMerge", "register", "providerFactory", "registerHolder", "T", "clazz", "Ljava/lang/Class;", "item", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)V", "registerProvider", "provider", "Lcom/bytedance/ies/bullet/core/model/context/IContextProvider;", "registerWeakHolder", "unRegister", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ContextProviderManager {
    public static final ContextProviderManager INSTANCE = new ContextProviderManager();
    private static Map<String, ContextProviderFactory> providerFactoryMap = new LinkedHashMap();

    public final <T> void registerHolder(String sessionId, Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
    }

    public final <T> void registerProvider(String sessionId, Class<T> clazz, IContextProvider<? extends T> provider) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    public final <T> void registerWeakHolder(String sessionId, Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
    }

    private ContextProviderManager() {
    }

    public final void register(String sessionId, ContextProviderFactory providerFactory) {
        if (sessionId != null) {
            if (providerFactory == null) {
                providerFactory = new ContextProviderFactory();
            }
            providerFactoryMap.put(sessionId, providerFactory);
        }
        Log.d("LeakLeak", "ContextProviderManager register: " + sessionId + ' ' + providerFactoryMap.size());
    }

    public final void unRegister(String sessionId) {
        if (sessionId != null) {
            providerFactoryMap.remove(sessionId);
        }
        Log.d("LeakLeak", "ContextProviderManager unRegister: " + sessionId + ' ' + providerFactoryMap.size());
    }

    public final ContextProviderFactory getProviderFactory(String sessionId) {
        if (sessionId != null) {
            ContextProviderFactory contextProviderFactory = providerFactoryMap.get(sessionId);
            return contextProviderFactory == null ? new ContextProviderFactory() : contextProviderFactory;
        }
        return new ContextProviderFactory();
    }

    public final void mergeProviderFactory(String sessionId, String sessionIdNeedMerge) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionIdNeedMerge, "sessionIdNeedMerge");
        getProviderFactory(sessionId).merge(getProviderFactory(sessionIdNeedMerge));
    }
}
