package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import kotlin.Metadata;

/* compiled from: Interfaces.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IMonitor;", "", "onConfigLoaded", "", "succeed", "", "errorMsg", "", "onDataFetched", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "hitState", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess$HitState;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IMonitor {
    void onConfigLoaded(boolean succeed, String errorMsg);

    void onDataFetched(PrefetchRequest request, long duration, boolean succeed, PrefetchProcess.HitState hitState);
}
