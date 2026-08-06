package com.bytedance.apm.trace.model;

import android.os.Process;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.tracing.internal.TraceSettings;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsTracing {
    protected TracingContext context;
    protected long startTs;
    protected Map<String, String> tags = new ConcurrentHashMap();
    protected List<String> spanTagKeyList = new CopyOnWriteArrayList();

    public abstract void cancelTrace();

    public abstract void endTrace(long j);

    public abstract void finishSpan(long j, JSONObject jSONObject, boolean z);

    public AbsTracing(TracingContext tracingContext) {
        this.context = tracingContext;
    }

    public void addTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public void startTrace(long j) {
        this.startTs = j;
    }

    public ITracingSpan createSpan(String str) {
        return new TracingSpan(str, "tracer_span", this);
    }

    public ITracingWindowSpan createWindowSpan(String str) {
        return new TracingSpan(str, "tracer_window_span", this);
    }

    public ITracingSpan createSpan(String str, long j) {
        return new TracingSpan(str, "tracer_span", this, j);
    }

    public ITracingWindowSpan createWindowSpan(String str, long j) {
        return new TracingSpan(str, "tracer_window_span", this, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void packageCommonParam(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("service", this.context.getService());
        jSONObject.put(ReportConst.ValidationReport.TRACE_ID, this.context.getTraceId() + "");
        if (this.context.isForceTrace()) {
            jSONObject.put(CommonKey.KEY_HIT_RULES, 1);
            jSONObject.put("sample_rate", 1);
        } else {
            jSONObject.put(CommonKey.KEY_HIT_RULES, TraceSettings.getInstance().isErrorOrSampleHit(z, this.context.getService()));
            jSONObject.put("sample_rate", TraceSettings.getInstance().getSampleRate(this.context.getService()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addSpanTagKey(String str) {
        if (this.spanTagKeyList.contains(str)) {
            return;
        }
        this.spanTagKeyList.add(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkTagKey() {
        if (ApmContext.isDebugMode()) {
            for (String str : this.spanTagKeyList) {
                if (this.tags.containsKey(str)) {
                    LaunchAnalysisContext.getInstance().logE("span's tag key can't be same as trace's tag key: " + str);
                    Process.killProcess(Process.myPid());
                }
            }
        }
    }
}
