package com.bytedance.android.anniex.lite.flow.base;

import android.util.LruCache;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAnnieXDispatchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/AnnieXDispatchManagerCache;", "", "()V", "dispatchMapBySessionId", "Landroid/util/LruCache;", "", "Lcom/bytedance/android/anniex/lite/flow/base/BaseAnnieXDispatchManager;", "maxDispatchManagerCount", "", "getDispatchManager", "sessionId", "putDispatchManager", "", "dispatchManager", "removeDispatchManager", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXDispatchManagerCache {
    public static final AnnieXDispatchManagerCache INSTANCE = new AnnieXDispatchManagerCache();
    private static final LruCache<String, BaseAnnieXDispatchManager> dispatchMapBySessionId;
    private static final int maxDispatchManagerCount;

    private AnnieXDispatchManagerCache() {
    }

    static {
        int annieXFlowCacheSize = IConditionCallKt.annieXFlowCacheSize();
        maxDispatchManagerCount = annieXFlowCacheSize;
        dispatchMapBySessionId = new LruCache<>(annieXFlowCacheSize);
    }

    public final synchronized BaseAnnieXDispatchManager getDispatchManager(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return dispatchMapBySessionId.get(sessionId);
    }

    public final synchronized void removeDispatchManager(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        dispatchMapBySessionId.remove(sessionId);
    }

    public final synchronized void putDispatchManager(String sessionId, BaseAnnieXDispatchManager dispatchManager) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(dispatchManager, "dispatchManager");
        dispatchMapBySessionId.put(sessionId, dispatchManager);
    }
}
