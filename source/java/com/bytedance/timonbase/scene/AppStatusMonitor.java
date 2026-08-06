package com.bytedance.timonbase.scene;

import android.app.ActivityManager;
import android.app.Application;
import com.bytedance.timonbase.scene.lifecycle.ForegroundHolder;
import com.bytedance.timonbase.scene.lifecycle.ProcessLifecycle;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppStatusMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J$\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/timonbase/scene/AppStatusMonitor;", "", "()V", "initialize", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mApplication", "Landroid/app/Application;", "getMApplication$timonbase_release", "()Landroid/app/Application;", "setMApplication$timonbase_release", "(Landroid/app/Application;)V", "deInitialize", "", "getProcessLifecycle", "Lcom/bytedance/timonbase/scene/lifecycle/ProcessLifecycle;", "application", "canUseRunningAppProcesses", "", "initForeground", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppStatusMonitor {
    public static final AppStatusMonitor INSTANCE = new AppStatusMonitor();
    private static AtomicBoolean initialize = new AtomicBoolean(false);
    private static volatile Application mApplication;

    private AppStatusMonitor() {
    }

    public final Application getMApplication$timonbase_release() {
        return mApplication;
    }

    public final void setMApplication$timonbase_release(Application application) {
        mApplication = application;
    }

    public static /* synthetic */ void initialize$default(Application application, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        initialize(application, z, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        if (r2 != null) goto L28;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void initialize(Application application, boolean canUseRunningAppProcesses, boolean initForeground) {
        List<ActivityManager.AppTask> appTasks;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Intrinsics.checkParameterIsNotNull(application, "application");
        if (initialize.get()) {
            return;
        }
        synchronized (INSTANCE) {
            mApplication = application;
            Object systemService = application.getSystemService("activity");
            Object obj = null;
            if (!(systemService instanceof ActivityManager)) {
                systemService = null;
            }
            ActivityManager activityManager = (ActivityManager) systemService;
            boolean z = false;
            if (!canUseRunningAppProcesses) {
                if (activityManager != null && (appTasks = activityManager.getAppTasks()) != null) {
                    Iterator<T> it = appTasks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        ActivityManager.AppTask appTask = (ActivityManager.AppTask) next;
                        Intrinsics.checkExpressionValueIsNotNull(appTask, "it");
                        if (appTask.getTaskInfo().baseActivity != null) {
                            obj = next;
                            break;
                        }
                    }
                    obj = (ActivityManager.AppTask) obj;
                }
                if (obj != null) {
                    z = true;
                }
                ProcessLifecycle.INSTANCE.initialize$timonbase_release(application);
                ForegroundHolder.INSTANCE.init(application, z);
                initialize.set(true);
                Unit unit = Unit.INSTANCE;
            } else if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<T> it2 = runningAppProcesses.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next2;
                    String[] strArr = runningAppProcessInfo.pkgList;
                    Intrinsics.checkExpressionValueIsNotNull(strArr, "it.pkgList");
                    if (ArraysKt.contains(strArr, application.getPackageName()) && runningAppProcessInfo.importance <= 100) {
                        obj = next2;
                        break;
                    }
                }
                obj = (ActivityManager.RunningAppProcessInfo) obj;
            }
        }
    }

    @JvmStatic
    public static final ProcessLifecycle getProcessLifecycle() {
        return ProcessLifecycle.INSTANCE;
    }

    @JvmStatic
    public static final void deInitialize() {
        Application application;
        if (mApplication == null || (application = mApplication) == null) {
            return;
        }
        ProcessLifecycle.INSTANCE.deInitialize$timonbase_release(application);
    }
}
