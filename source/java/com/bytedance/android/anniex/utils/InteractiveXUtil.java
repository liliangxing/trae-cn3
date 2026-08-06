package com.bytedance.android.anniex.utils;

import android.net.Uri;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.ies.bullet.lynx.impl.PhysicsKryptonRuntimeServiceImpl;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InteractiveXUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/anniex/utils/InteractiveXUtil;", "", "()V", "injectMotionPhysics", "", "annieXLynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "useMotion", "", "uri", "Landroid/net/Uri;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class InteractiveXUtil {
    public static final InteractiveXUtil INSTANCE = new InteractiveXUtil();

    private InteractiveXUtil() {
    }

    public final boolean useMotion(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return uri.getBooleanQueryParameter("use_motion", false);
    }

    public final void injectMotionPhysics(AnnieXLynxView annieXLynxView) {
        Intrinsics.checkNotNullParameter(annieXLynxView, "annieXLynxView");
        PhysicsKryptonRuntimeServiceImpl physicsKryptonRuntimeServiceImpl = new PhysicsKryptonRuntimeServiceImpl();
        LynxKryptonHelper lynxKryptonHelper = LynxKryptonUtils.getLynxKryptonHelper(annieXLynxView);
        if (lynxKryptonHelper != null) {
            lynxKryptonHelper.registerService(PhysicsKryptonRuntimeServiceImpl.class, physicsKryptonRuntimeServiceImpl);
        }
    }
}
