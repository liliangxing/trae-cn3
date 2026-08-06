package com.bytedance.security.android.aopcheck.reporter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/security/android/aopcheck/reporter/ReportManager;", "", "()V", "mLock", "mReporters", "", "Lcom/bytedance/security/android/aopcheck/reporter/IReporter;", "addReporter", "", "reporter", "report", "serviceName", "", "event", "Lcom/bytedance/security/android/aopcheck/reporter/IEvent;", "reportInit", "duration", "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class ReportManager {
    public static final ReportManager INSTANCE = new ReportManager();
    private static final List<IReporter> mReporters = new ArrayList();
    private static final Object mLock = new Object();

    private ReportManager() {
    }

    public final void addReporter(IReporter reporter) {
        Intrinsics.checkParameterIsNotNull(reporter, "reporter");
        mReporters.add(reporter);
    }

    public final void report(String serviceName, IEvent event) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        Intrinsics.checkParameterIsNotNull(event, "event");
        synchronized (mLock) {
            Iterator<T> it = mReporters.iterator();
            while (it.hasNext()) {
                ((IReporter) it.next()).doReport(event);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void reportInit(long duration) {
        synchronized (mLock) {
            Iterator<T> it = mReporters.iterator();
            while (it.hasNext()) {
                ((IReporter) it.next()).doReportInitEvnt(duration);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
