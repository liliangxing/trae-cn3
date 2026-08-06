package com.bytedance.forest;

import android.content.Context;
import com.bytedance.geckox.loader.GeckoResLoader;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\bH\u0002J\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/forest/SessionManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sessionId2Loaders", "", "Lkotlin/Pair;", "", "Lcom/bytedance/geckox/loader/GeckoResLoader;", "closeSession", "", "sessionId", "generateSessionId", "getGeckoResLoader", "accessKey", "rootDir", "Ljava/io/File;", "openSession", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SessionManager {
    private final Context context;
    private final Map<Pair<String, String>, GeckoResLoader> sessionId2Loaders;

    public SessionManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        this.sessionId2Loaders = new LinkedHashMap();
    }

    public final void closeSession(String sessionId) {
        Intrinsics.checkParameterIsNotNull(sessionId, "sessionId");
        synchronized (this.sessionId2Loaders) {
            Iterator<Map.Entry<Pair<String, String>, GeckoResLoader>> it = this.sessionId2Loaders.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Pair<String, String>, GeckoResLoader> next = it.next();
                if (Intrinsics.areEqual((String) next.getKey().getFirst(), sessionId)) {
                    next.getValue().release();
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ String openSession$default(SessionManager sessionManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return sessionManager.openSession(str);
    }

    public final String openSession(String sessionId) {
        return sessionId != null ? sessionId : generateSessionId();
    }

    private final String generateSessionId() {
        return String.valueOf(System.currentTimeMillis()) + "-" + UUID.randomUUID().toString();
    }

    public final GeckoResLoader getGeckoResLoader(String sessionId, String accessKey, File rootDir) {
        Intrinsics.checkParameterIsNotNull(sessionId, "sessionId");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(rootDir, "rootDir");
        Pair<String, String> pair = TuplesKt.to(sessionId, accessKey);
        synchronized (this.sessionId2Loaders) {
            Map<Pair<String, String>, GeckoResLoader> map = this.sessionId2Loaders;
            GeckoResLoader geckoResLoader = map.get(pair);
            if (geckoResLoader != null) {
                return geckoResLoader;
            }
            GeckoResLoader geckoResLoader2 = new GeckoResLoader(this.context, accessKey, rootDir);
            map.put(pair, geckoResLoader2);
            return geckoResLoader2;
        }
    }
}
