package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntry;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxDefaultPerformanceReportProcessor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/LynxDefaultPerformanceReportProcessor;", "Lcom/bytedance/lynx/service/reporter/performance/ILynxPerformanceReportProcessor;", "()V", "canProcess", "", "entry", "Lcom/lynx/tasm/performance/performanceobserver/PerformanceEntry;", "processPerformanceEntry", "", "", "", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxDefaultPerformanceReportProcessor implements ILynxPerformanceReportProcessor {
    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    public void onInitialize(Context context) {
        ILynxPerformanceReportProcessor.DefaultImpls.onInitialize(this, context);
    }

    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    public boolean canProcess(PerformanceEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return Intrinsics.areEqual(entry.entryType, "js_blocking");
    }

    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    public Map<String, Object> processPerformanceEntry(PerformanceEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        LynxPerformanceReportProcessorUtils lynxPerformanceReportProcessorUtils = LynxPerformanceReportProcessorUtils.INSTANCE;
        HashMap<String, Object> hashMap = entry.toHashMap();
        Intrinsics.checkNotNullExpressionValue(hashMap, "entry.toHashMap()");
        return lynxPerformanceReportProcessorUtils.processEntry(hashMap, "Start", LynxTimingPerformanceReportProcessor.KEY_END_SUFFIX, null);
    }
}
