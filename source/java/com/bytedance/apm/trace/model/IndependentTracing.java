package com.bytedance.apm.trace.model;

import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.tracing.internal.TracingData;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class IndependentTracing extends AbsTracing {
    private AtomicBoolean isFinish;

    public IndependentTracing(TracingContext tracingContext) {
        super(tracingContext);
        this.isFinish = new AtomicBoolean(false);
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void endTrace(long j) {
        if (this.isFinish.get()) {
            return;
        }
        this.isFinish.set(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_timestamp", this.startTs);
            jSONObject.put("finish_timestamp", System.currentTimeMillis());
            jSONObject.put("is_finished", 1);
            jSONObject.put("report_mode", 0);
            jSONObject.put("log_type", "tracer");
            packageCommonParam(jSONObject, false);
            CommonDataPipeline.getInstance().handle(new TracingData(jSONObject, this.context.getService(), false, "tracing"));
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void finishSpan(long j, JSONObject jSONObject, boolean z) {
        if (jSONObject == null || this.isFinish.get()) {
            return;
        }
        try {
            packageCommonParam(jSONObject, z);
            CommonDataPipeline.getInstance().handle(new TracingData(jSONObject, this.context.getService(), z, "tracing"));
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void cancelTrace() {
        this.isFinish.set(true);
    }
}
