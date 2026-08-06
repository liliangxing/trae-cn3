package com.bytedance.ies.bullet.secure;

import com.bytedance.ies.bullet.base.settings.GeckoLoaderSecureConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.forest.ForestConfigCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoLoaderSecureManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/secure/GeckoLoaderSecureManager;", "", "()V", "mode", "", "getMode", "()I", "setMode", "(I)V", "updateConfig", "", "config", "Lcom/bytedance/ies/bullet/base/settings/GeckoLoaderSecureConfig;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GeckoLoaderSecureManager {
    public static final int MODE_DISABLE = 0;
    public static final int MODE_INTERCEPT = 2;
    public static final int MODE_REPORT_ONLY = 1;
    private static final String TAG = "GeckoLoaderSecureManager";
    private int mode;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<GeckoLoaderSecureManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<GeckoLoaderSecureManager>() { // from class: com.bytedance.ies.bullet.secure.GeckoLoaderSecureManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final GeckoLoaderSecureManager m551invoke() {
            return new GeckoLoaderSecureManager();
        }
    });

    /* compiled from: GeckoLoaderSecureManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/secure/GeckoLoaderSecureManager$Companion;", "", "()V", "MODE_DISABLE", "", "MODE_INTERCEPT", "MODE_REPORT_ONLY", "TAG", "", "instance", "Lcom/bytedance/ies/bullet/secure/GeckoLoaderSecureManager;", "getInstance", "()Lcom/bytedance/ies/bullet/secure/GeckoLoaderSecureManager;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GeckoLoaderSecureManager getInstance() {
            return (GeckoLoaderSecureManager) GeckoLoaderSecureManager.instance$delegate.getValue();
        }
    }

    public final int getMode() {
        return this.mode;
    }

    public final void setMode(int i) {
        this.mode = i;
    }

    public final void updateConfig(GeckoLoaderSecureConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "update GeckoLoaderSecure config, mode: " + config.getGeckoLoaderSecureMode(), null, null, 12, null);
        this.mode = config.getGeckoLoaderSecureMode();
        ForestConfigCenter.INSTANCE.getForestConfig().setGeckoCheckPathTraversalMode(config.getGeckoLoaderSecureMode());
    }
}
