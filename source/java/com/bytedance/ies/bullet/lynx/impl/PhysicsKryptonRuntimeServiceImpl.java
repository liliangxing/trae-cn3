package com.bytedance.ies.bullet.lynx.impl;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import com.bytedance.ies.bullet.lynx.util.GoldenFingerBindHelper;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhysicsKryptonRuntimeServiceImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/impl/PhysicsKryptonRuntimeServiceImpl;", "Lcom/lynx/canvas/KryptonService;", "()V", "jsEnv", "", "Ljava/lang/Long;", "onBootstrap", "", "kryptonApp", "Lcom/lynx/canvas/KryptonApp;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PhysicsKryptonRuntimeServiceImpl extends KryptonService {
    private Long jsEnv;

    public void onBootstrap(KryptonApp kryptonApp) {
        Intrinsics.checkNotNullParameter(kryptonApp, "kryptonApp");
        super.onBootstrap(kryptonApp);
        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_MOTION, "PhysicsKryptonRuntimeServiceImpl onBootstrap run" + kryptonApp.getJsEnv(), null, null, 12, null);
        Long valueOf = Long.valueOf(kryptonApp.getJsEnv());
        this.jsEnv = valueOf;
        if (valueOf != null) {
            GoldenFingerBindHelper.INSTANCE.callBindMotion(valueOf.longValue());
        }
    }
}
