package com.bytedance.security.android.aopcheck.reporter;

import kotlin.Metadata;

/* compiled from: IReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/security/android/aopcheck/reporter/IReporter;", "", "doReport", "", "event", "Lcom/bytedance/security/android/aopcheck/reporter/IEvent;", "doReportInitEvnt", "duration", "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public interface IReporter {
    void doReport(IEvent event);

    void doReportInitEvnt(long duration);
}
