package com.bytedance.pia.core.metrics;

import com.bytedance.pia.core.api.monitor.IPiaTracer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class TracerAdapter implements IPiaTracer {
    private static final Map<String, String> compat;
    private final IPiaTracer origin;

    public TracerAdapter(IPiaTracer iPiaTracer) {
        this.origin = iPiaTracer;
    }

    static {
        HashMap hashMap = new HashMap();
        compat = hashMap;
        hashMap.put(TraceEvent.WARMUP_START, "pia_warmup_start");
        hashMap.put(TraceEvent.WARMUP_END, "pia_warmup_end");
        hashMap.put(TraceEvent.INITIALIZE_START, "pia_initialize_start");
        hashMap.put(TraceEvent.REQUEST_HTML_START, "pia_request_html_start");
        hashMap.put(TraceEvent.REQUEST_HTML_END, "pia_request_html_end");
        hashMap.put(TraceEvent.INTERCEPT_HTML_START, "pia_intercept_html_start");
        hashMap.put(TraceEvent.INTERCEPT_HTML_END, "pia_intercept_html_end");
        hashMap.put(TraceEvent.MANIFEST_PARSE_END, "pia_manifest_parsed");
        hashMap.put(TraceEvent.REQUEST_WORKER_START, "pia_request_worker_start");
        hashMap.put(TraceEvent.REQUEST_WORKER_END, "pia_request_worker_end");
    }

    @Override // com.bytedance.pia.core.api.monitor.IPiaTracer
    public void report(String str, long j) {
        this.origin.report(str, j);
        String str2 = compat.get(str);
        if (str2 != null) {
            this.origin.report(str2, j);
        }
    }

    @Override // com.bytedance.pia.core.api.monitor.IPiaTracer
    public void reportExtra(String str, Object obj) {
        this.origin.reportExtra(str, obj);
    }
}
