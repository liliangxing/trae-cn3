package com.bytedance.timonbase.scene.silenceimpl;

import android.view.View;
import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.report.TMMetric;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.bytedance.timonbase.utils.WindowManagerGlobalUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowManagerGlobalInfiltrator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/timonbase/scene/silenceimpl/WindowManagerGlobalInfiltrator;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "infiltrate", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WindowManagerGlobalInfiltrator {
    public static final WindowManagerGlobalInfiltrator INSTANCE = new WindowManagerGlobalInfiltrator();
    private static final String TAG = "WindowManagerGlobalInfiltrator";

    private WindowManagerGlobalInfiltrator() {
    }

    public final void infiltrate() {
        TMMetric.reportSilentInit$default(TMMetric.INSTANCE, 0, null, 2, null);
        if (TMEnv.INSTANCE.getEnableClipboardCompliance()) {
            if (WindowManagerGlobalUtil.INSTANCE.isHookSuccess()) {
                WindowManagerGlobalUtil.INSTANCE.addCallback(new WindowManagerGlobalUtil.Callback() { // from class: com.bytedance.timonbase.scene.silenceimpl.WindowManagerGlobalInfiltrator$infiltrate$1
                    @Override // com.bytedance.timonbase.utils.WindowManagerGlobalUtil.Callback
                    public void onRootViewRemoved(View view) {
                        Intrinsics.checkParameterIsNotNull(view, "view");
                        WindowManagerGlobalUtil.Callback.DefaultImpls.onRootViewRemoved(this, view);
                    }

                    @Override // com.bytedance.timonbase.utils.WindowManagerGlobalUtil.Callback
                    public void onRootViewAdded(View view) {
                        Intrinsics.checkParameterIsNotNull(view, "view");
                        DecorViewInfiltrator.INSTANCE.infiltrateFor(view);
                    }
                });
                return;
            } else {
                ScenesDetector.INSTANCE.infiltratorErrorHappen("infiltrate: WindowManagerGlobalUtil init failed", -2);
                return;
            }
        }
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Field declaredField = cls.getDeclaredField("mViews");
            Intrinsics.checkExpressionValueIsNotNull(declaredField, "mViewsField");
            declaredField.setAccessible(true);
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Object obj = declaredField.get(invoke);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<android.view.View>");
            }
            declaredField.set(invoke, new AdHocListForInfiltration((ArrayList) obj));
        } catch (Exception e) {
            TMLogger tMLogger = TMLogger.INSTANCE;
            String str = TAG;
            Intrinsics.checkExpressionValueIsNotNull(str, "TAG");
            tMLogger.m222e(str, e.getMessage(), e.getCause());
            TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.silenceimpl.WindowManagerGlobalInfiltrator$infiltrate$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1076invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1076invoke() {
                    TimonFoundation.INSTANCE.getExceptionMonitor().monitorThrowable(e, "Timon_Silent_initFailed", MapsKt.emptyMap());
                }
            });
            ScenesDetector.INSTANCE.infiltratorErrorHappen("infiltrate:" + e.getMessage(), -2);
        }
    }
}
