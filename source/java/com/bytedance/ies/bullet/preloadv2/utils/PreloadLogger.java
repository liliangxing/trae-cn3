package com.bytedance.ies.bullet.preloadv2.utils;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.Metadata;

/* compiled from: PreloadLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/utils/PreloadLogger;", "", "()V", "TAG", "", "d", "", "message", "e", "i", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadLogger {
    public static final PreloadLogger INSTANCE = new PreloadLogger();
    private static final String TAG = "XPreload";

    private PreloadLogger() {
    }

    /* renamed from: d */
    public final void m41d(String message) {
        if (message != null) {
            HybridLogger.d$default(HybridLogger.INSTANCE, "XPreload", message, null, null, 12, null);
        }
    }

    /* renamed from: i */
    public final void m43i(String message) {
        if (message != null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XPreload", message, null, null, 12, null);
        }
    }

    /* renamed from: w */
    public final void m44w(String message) {
        if (message != null) {
            HybridLogger.w$default(HybridLogger.INSTANCE, "XPreload", message, null, null, 12, null);
        }
    }

    /* renamed from: e */
    public final void m42e(String message) {
        if (message != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "XPreload", message, null, null, 12, null);
        }
    }
}
