package com.bytedance.tracing.core;

import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.tracing.internal.TraceSettings;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes5.dex */
public class Tracer {
    private long finishTs;
    private String serviceName;
    private long startTs;
    private Map<String, String> tags;
    private long traceId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tracer(SpanContext spanContext) {
        this.serviceName = spanContext.getService();
        this.traceId = spanContext.getTraceId();
    }

    public void start() {
        this.startTs = System.currentTimeMillis();
    }

    public void addTag(String str, String str2) {
        if (this.tags == null) {
            this.tags = new ConcurrentHashMap();
        }
        this.tags.put(str, str2);
    }

    public void removeTag(String str) {
        Map<String, String> map = this.tags;
        if (map != null) {
            map.remove(str);
        }
    }

    public void finish() {
        this.finishTs = System.currentTimeMillis();
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.tracing.core.Tracer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("service", Tracer.this.serviceName);
                    jSONObject.put("trace_id", Tracer.this.traceId);
                    jSONObject.put(TracingConstants.KEY_START_TIMESTAMP, Tracer.this.startTs);
                    jSONObject.put(TracingConstants.KEY_END_TIMESTAMP, Tracer.this.finishTs);
                    jSONObject.put(TracingConstants.KEY_SAMPLE_RATE, TraceSettings.getInstance().getSampleRate(Tracer.this.serviceName));
                    jSONObject.put(TracingConstants.KEY_FINISH_FLAG, 1);
                    jSONObject.put(TracingConstants.KEY_REPORT_MODE, 0);
                    CommonDataPipeline.getInstance().handle(new ExceptionLogData(TracingConstants.TRACE_LOG_TYPE, jSONObject));
                } catch (JSONException unused) {
                }
            }
        });
    }
}
