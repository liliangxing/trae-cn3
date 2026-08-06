package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntry;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ILynxPerformanceReportProcessor.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/ILynxPerformanceReportProcessor;", "", "canProcess", "", "entry", "Lcom/lynx/tasm/performance/performanceobserver/PerformanceEntry;", "onInitialize", "", "context", "Landroid/content/Context;", "processPerformanceEntry", "", "", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ILynxPerformanceReportProcessor {

    /* compiled from: ILynxPerformanceReportProcessor.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onInitialize(ILynxPerformanceReportProcessor iLynxPerformanceReportProcessor, Context context) {
        }
    }

    boolean canProcess(PerformanceEntry entry);

    void onInitialize(Context context);

    Map<String, Object> processPerformanceEntry(PerformanceEntry entry);
}
