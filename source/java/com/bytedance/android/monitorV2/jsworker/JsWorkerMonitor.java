package com.bytedance.android.monitorV2.jsworker;

import android.view.View;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.JSModuleWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsWorkerMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/jsworker/JsWorkerMonitor;", "", "()V", "getJsWorkerModule", "Lcom/bytedance/android/monitorV2/jsworker/JsWorkerModule;", "manager", "Lcom/bytedance/vmsdk/jsbridge/JSModuleManager;", "onWorkerAttachView", "", "view", "Landroid/view/View;", "onWorkerCreate", "onWorkerDestroy", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class JsWorkerMonitor {
    public static final JsWorkerMonitor INSTANCE = new JsWorkerMonitor();

    private JsWorkerMonitor() {
    }

    public final void onWorkerCreate(JSModuleManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            MonitorLog.m29i(LynxViewMonitor.TAG, "onWorkerCreate");
            if (manager.getModule("hybridMonitor") == null) {
                manager.registerModule("hybridMonitor", JsWorkerModule.class, (Object) null);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    public final void onWorkerAttachView(View view, JSModuleManager manager) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            MonitorLog.m29i(LynxViewMonitor.TAG, "onJsWorkerAttachView");
            JsWorkerModule jsWorkerModule = getJsWorkerModule(manager);
            if (jsWorkerModule != null) {
                jsWorkerModule.onAttachView(view);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    public final void onWorkerDestroy(JSModuleManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            MonitorLog.m29i(LynxViewMonitor.TAG, "onJsWorkerAttachView");
            JsWorkerModule jsWorkerModule = getJsWorkerModule(manager);
            if (jsWorkerModule != null) {
                jsWorkerModule.fireAllEvents();
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    private final JsWorkerModule getJsWorkerModule(JSModuleManager manager) {
        JSModuleWrapper module = manager.getModule("hybridMonitor");
        JSModule module2 = module != null ? module.getModule() : null;
        if (module2 == null || !(module2 instanceof JsWorkerModule)) {
            return null;
        }
        return (JsWorkerModule) module2;
    }
}
