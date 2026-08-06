package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* compiled from: PrefetchLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchLogger;", "", "()V", "TAG", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "message", "e", RXScreenCaptureService.KEY_INDEX, "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchLogger {
    public static final PrefetchLogger INSTANCE = new PrefetchLogger();
    public static final String TAG = "XPrefetch";

    private PrefetchLogger() {
    }

    public final void d(String message) {
        if (message != null) {
            HybridLogger.d$default(HybridLogger.INSTANCE, "XPrefetch", message, null, null, 12, null);
        }
    }

    public final void i(String message) {
        if (message != null) {
            HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", message, null, null, 12, null);
        }
    }

    public final void w(String message) {
        if (message != null) {
            HybridLogger.w$default(HybridLogger.INSTANCE, "XPrefetch", message, null, null, 12, null);
        }
    }

    public final void e(String message) {
        if (message != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", message, null, null, 12, null);
        }
    }
}
