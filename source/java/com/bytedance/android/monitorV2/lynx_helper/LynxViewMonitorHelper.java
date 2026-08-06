package com.bytedance.android.monitorV2.lynx_helper;

import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.config.LynxViewMonitorConfig;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxViewMonitorHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx_helper/LynxViewMonitorHelper;", "", "()V", "registerLynxMonitor", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "lynxMonitorConfig", "Lcom/bytedance/android/monitorV2/lynx/config/LynxViewMonitorConfig;", "unregisterLynxMonitor", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewMonitorHelper {
    public static final LynxViewMonitorHelper INSTANCE = new LynxViewMonitorHelper();

    private LynxViewMonitorHelper() {
    }

    @JvmStatic
    public static final void registerLynxMonitor(LynxView lynxView, LynxViewMonitorConfig lynxMonitorConfig) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        Intrinsics.checkNotNullParameter(lynxMonitorConfig, "lynxMonitorConfig");
        if (lynxMonitorConfig.getEnableMonitor()) {
            LynxViewMonitor.INSTANCE.getINSTANCE().registerLynxViewMonitor(lynxView, lynxMonitorConfig);
        }
    }

    @JvmStatic
    public static final void unregisterLynxMonitor(LynxView lynxView) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        LynxViewMonitor.INSTANCE.getINSTANCE().unregisterLynxViewMonitor(lynxView);
    }
}
