package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.webx.core.webview.WebViewContainer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchSessionContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchSessionManager;", "", "()V", "sessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchSessionContext;", WebViewContainer.EVENT_destroy, "", "sessionId", "getOrCreateContext", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchSessionManager {
    public static final PrefetchSessionManager INSTANCE = new PrefetchSessionManager();
    private static final ConcurrentHashMap<String, PrefetchSessionContext> sessionMap = new ConcurrentHashMap<>();

    private PrefetchSessionManager() {
    }

    public final PrefetchSessionContext getOrCreateContext(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        ConcurrentHashMap<String, PrefetchSessionContext> concurrentHashMap = sessionMap;
        if (concurrentHashMap.size() > 10) {
            PrefetchLogger.INSTANCE.w("Session 可能存在泄漏");
        }
        PrefetchSessionContext prefetchSessionContext = concurrentHashMap.get(sessionId);
        if (prefetchSessionContext == null) {
            prefetchSessionContext = new PrefetchSessionContext();
        }
        concurrentHashMap.put(sessionId, prefetchSessionContext);
        return prefetchSessionContext;
    }

    public final void destroy(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        sessionMap.remove(sessionId);
    }
}
