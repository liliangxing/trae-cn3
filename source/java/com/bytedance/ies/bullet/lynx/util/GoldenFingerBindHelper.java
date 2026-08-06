package com.bytedance.ies.bullet.lynx.util;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoldenFingerBindHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/util/GoldenFingerBindHelper;", "", "()V", "COMPRESS_PACKAGE", "", "MOTION_PACKAGE", "compressClass", "Ljava/lang/Class;", "motionClass", "callBindKtx2", "", "jsEnv", "", "callBindMotion", "callUnbindKtx2", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GoldenFingerBindHelper {
    private static volatile Class<?> compressClass;
    private static volatile Class<?> motionClass;
    public static final GoldenFingerBindHelper INSTANCE = new GoldenFingerBindHelper();
    private static final String MOTION_PACKAGE = "com.bytedance.interaction.game.ext.motion.MotionSdk";
    private static final String COMPRESS_PACKAGE = "com.bytedance.interaction.game.ext.compress.MotionCompressSdk";

    private GoldenFingerBindHelper() {
    }

    public final void callBindMotion(long jsEnv) {
        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_MOTION, "callBindMotion call", null, null, 12, null);
        try {
            if (motionClass == null) {
                Class<?> cls = Class.forName(MOTION_PACKAGE);
                Intrinsics.checkNotNullExpressionValue(cls, "forName(MOTION_PACKAGE)");
                motionClass = cls;
            }
            Class<?> cls2 = motionClass;
            Class<?> cls3 = null;
            if (cls2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motionClass");
                cls2 = null;
            }
            Object obj = cls2.getDeclaredField("INSTANCE").get(null);
            Class<?> cls4 = motionClass;
            if (cls4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motionClass");
            } else {
                cls3 = cls4;
            }
            cls3.getDeclaredMethod("nativeBindMotion", Long.TYPE).invoke(obj, Long.valueOf(jsEnv));
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_MOTION, "motion bind error:" + e.getMessage(), null, null, 12, null);
        }
    }

    public final void callBindKtx2(long jsEnv) {
        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_MOTION, "callBindKtx2 call", null, null, 12, null);
        try {
            if (compressClass == null) {
                Class<?> cls = Class.forName(COMPRESS_PACKAGE);
                Intrinsics.checkNotNullExpressionValue(cls, "forName(COMPRESS_PACKAGE)");
                compressClass = cls;
            }
            Class<?> cls2 = compressClass;
            Class<?> cls3 = null;
            if (cls2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compressClass");
                cls2 = null;
            }
            Object obj = cls2.getDeclaredField("INSTANCE").get(null);
            Class<?> cls4 = compressClass;
            if (cls4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compressClass");
            } else {
                cls3 = cls4;
            }
            cls3.getDeclaredMethod("nativeBindKTX2", Long.TYPE).invoke(obj, Long.valueOf(jsEnv));
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_MOTION, "ktx2 bind error:" + e.getMessage(), null, null, 12, null);
        }
    }

    public final void callUnbindKtx2(long jsEnv) {
        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_MOTION, "callUnbindKtx2 call,jsEnv:" + jsEnv, null, null, 12, null);
        try {
            if (compressClass == null) {
                Class<?> cls = Class.forName(COMPRESS_PACKAGE);
                Intrinsics.checkNotNullExpressionValue(cls, "forName(COMPRESS_PACKAGE)");
                compressClass = cls;
            }
            Class<?> cls2 = compressClass;
            Class<?> cls3 = null;
            if (cls2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compressClass");
                cls2 = null;
            }
            Object obj = cls2.getDeclaredField("INSTANCE").get(null);
            Class<?> cls4 = compressClass;
            if (cls4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compressClass");
            } else {
                cls3 = cls4;
            }
            cls3.getDeclaredMethod("nativeUnBindKTX2", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_MOTION, "ktx2 unbind error:" + e.getMessage(), null, null, 12, null);
        }
    }
}
