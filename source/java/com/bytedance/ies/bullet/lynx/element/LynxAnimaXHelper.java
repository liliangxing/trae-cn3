package com.bytedance.ies.bullet.lynx.element;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxAnimaXHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/element/LynxAnimaXHelper;", "", "()V", "STATE_FAIL", "", "STATE_INIT", "STATE_SUCCESS", "TAG", "", "sAnimaXInstance", "sCreateUIMethod", "Ljava/lang/reflect/Method;", "sInitState", "Ljava/util/concurrent/atomic/AtomicInteger;", "createAnimaXUI", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "initReflection", "", "Landroid/content/Context;", "isES3Supported", "", "isState", "state", "mapLottieToAnimaX", "builder", "Lcom/lynx/tasm/LynxViewBuilder;", "toState", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxAnimaXHelper {
    private static final int STATE_FAIL = 2;
    private static final int STATE_INIT = 0;
    private static final int STATE_SUCCESS = 1;
    private static final String TAG = "LynxAnimaXHelper";
    private static Object sAnimaXInstance;
    private static Method sCreateUIMethod;
    public static final LynxAnimaXHelper INSTANCE = new LynxAnimaXHelper();
    private static final AtomicInteger sInitState = new AtomicInteger(0);

    private LynxAnimaXHelper() {
    }

    public final void mapLottieToAnimaX(LynxViewBuilder builder, Context context) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (isState(0)) {
            initReflection(context);
        }
        if (!isState(1)) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "mapLottieToAnimaX fail, init not success", null, null, 12, null);
            return;
        }
        try {
            builder.addBehavior(new Behavior() { // from class: com.bytedance.ies.bullet.lynx.element.LynxAnimaXHelper$mapLottieToAnimaX$1
                public LynxUI<?> createUI(LynxContext context2) {
                    LynxUI<?> createAnimaXUI;
                    Intrinsics.checkNotNullParameter(context2, "context");
                    createAnimaXUI = LynxAnimaXHelper.INSTANCE.createAnimaXUI(context2);
                    return createAnimaXUI;
                }
            });
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "mapLottieToAnimaX fail. e: " + e.getMessage(), null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LynxUI<?> createAnimaXUI(LynxContext context) {
        Object invoke;
        Class<?> cls;
        Method method;
        LynxUI<?> lynxUI = null;
        try {
            Object obj = sAnimaXInstance;
            if (obj != null && (cls = obj.getClass()) != null && (method = cls.getMethod(EventConstants.PARAM_SOURCE_INIT, new Class[0])) != null) {
                method.invoke(sAnimaXInstance, new Object[0]);
            }
            Method method2 = sCreateUIMethod;
            if (method2 != null && (invoke = method2.invoke(sAnimaXInstance, context)) != null) {
                if (!(invoke instanceof LynxUI)) {
                    invoke = null;
                }
                if (invoke != null) {
                    lynxUI = (LynxUI) invoke;
                }
            }
            if (lynxUI == null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "createAnimaXUI fail. createUI back with null", null, null, 12, null);
            }
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "createAnimaXUI fail. e: " + e.getMessage(), null, null, 12, null);
        }
        return lynxUI;
    }

    private final synchronized void initReflection(Context context) {
        Class<?> cls;
        if (!isState(1) && !isState(2)) {
            if (!isES3Supported(context)) {
                toState(2);
                HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "initAnimaXInstance fail, es version not support", null, null, 12, null);
                return;
            }
            try {
                Method method = Class.forName("com.lynx.animax.util.LynxAnimaX").getMethod("inst", new Class[0]);
                Method method2 = null;
                Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                sAnimaXInstance = invoke;
                if (invoke != null && (cls = invoke.getClass()) != null) {
                    method2 = cls.getMethod("createUI", LynxContext.class);
                }
                sCreateUIMethod = method2;
            } catch (Exception e) {
                HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "initAnimaXInstance fail, e: " + e.getMessage(), null, null, 12, null);
            }
            if (sAnimaXInstance != null && sCreateUIMethod != null) {
                toState(1);
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "initAnimaXInstance success", null, null, 12, null);
            } else {
                toState(2);
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "initAnimaXInstance fail, sAnimaXInstance: " + sAnimaXInstance + ", sCreateUIMethod: " + sCreateUIMethod, null, null, 12, null);
            }
        }
    }

    private final boolean isState(int state) {
        return sInitState.get() == state;
    }

    private final void toState(int state) {
        sInitState.set(state);
    }

    private final boolean isES3Supported(Context context) {
        if (context == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "isES3Supported fail, message: context is null", null, null, 12, null);
            return false;
        }
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) systemService).getDeviceConfigurationInfo();
            Intrinsics.checkNotNullExpressionValue(deviceConfigurationInfo, "am.deviceConfigurationInfo");
            return deviceConfigurationInfo.reqGlEsVersion >= 196608;
        } catch (Throwable th) {
            HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "isES3Supported fail, message: " + th.getMessage(), null, null, 12, null);
            return false;
        }
    }
}
