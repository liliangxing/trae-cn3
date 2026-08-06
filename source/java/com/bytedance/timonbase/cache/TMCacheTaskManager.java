package com.bytedance.timonbase.cache;

import com.bytedance.timonbase.TMEnv;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMCacheTaskManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/timonbase/cache/TMCacheTaskManager;", "", "()V", "MAX_DELAY_CHECK", "", "MAX_REPORT_SIZE", "delayReportBeforeBasicModeEnableTasks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "delayReportTasks", "delayCheck", "runnable", "delayReport", "flushApiCallCache", "flushCache", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class TMCacheTaskManager {
    private static final int MAX_DELAY_CHECK = 40;
    private static final int MAX_REPORT_SIZE = 100;
    public static final TMCacheTaskManager INSTANCE = new TMCacheTaskManager();
    private static final CopyOnWriteArrayList<Function0<Unit>> delayReportTasks = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<Function0<Unit>> delayReportBeforeBasicModeEnableTasks = new CopyOnWriteArrayList<>();

    private TMCacheTaskManager() {
    }

    public final void delayReport(Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        if (TMEnv.INSTANCE.getInitialed()) {
            runnable.invoke();
            return;
        }
        CopyOnWriteArrayList<Function0<Unit>> copyOnWriteArrayList = delayReportTasks;
        if (copyOnWriteArrayList.size() < 100) {
            copyOnWriteArrayList.add(runnable);
        }
    }

    public final void delayCheck(Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        if (TMEnv.INSTANCE.getRulerHardCodeReady()) {
            runnable.invoke();
            return;
        }
        CopyOnWriteArrayList<Function0<Unit>> copyOnWriteArrayList = delayReportBeforeBasicModeEnableTasks;
        if (copyOnWriteArrayList.size() < 40) {
            copyOnWriteArrayList.add(runnable);
        }
    }

    public final void flushCache() {
        CopyOnWriteArrayList<Function0<Unit>> copyOnWriteArrayList = delayReportTasks;
        if (copyOnWriteArrayList.size() > 0) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
            delayReportTasks.clear();
        }
    }

    public final void flushApiCallCache() {
        if (TMEnv.INSTANCE.getBasicModeEnable()) {
            CopyOnWriteArrayList<Function0<Unit>> copyOnWriteArrayList = delayReportBeforeBasicModeEnableTasks;
            if (copyOnWriteArrayList.size() > 0) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                delayReportBeforeBasicModeEnableTasks.clear();
            }
        }
    }
}
