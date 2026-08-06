package com.bytedance.android.monitorV2.lynx;

import com.bytedance.android.monitorV2.lynx.impl.LynxNavigationStore;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxViewMonitorCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/LynxViewMonitorCenter;", "", "()V", "prepareLynxViewNavigation", "", "lynxView", "Lcom/lynx/tasm/LynxView;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxViewMonitorCenter {
    public static final LynxViewMonitorCenter INSTANCE = new LynxViewMonitorCenter();

    private LynxViewMonitorCenter() {
    }

    public final void prepareLynxViewNavigation(LynxView lynxView) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        LynxNavigationStore.INSTANCE.preCreateLynxNavigation(lynxView);
    }
}
