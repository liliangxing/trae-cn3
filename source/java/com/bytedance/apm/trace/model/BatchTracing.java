package com.bytedance.apm.trace.model;

import android.util.Log;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.tracing.internal.BatchTracingLogWrapUtils;
import com.bytedance.tracing.internal.TraceSettings;
import com.bytedance.tracing.internal.TracingData;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatchTracing extends AbsTracing {
    private AtomicBoolean isFinish;
    private List<JSONObject> spanCacheData;
    private List<Long> spanIdCache;

    public BatchTracing(TracingContext tracingContext) {
        super(tracingContext);
        this.spanCacheData = new CopyOnWriteArrayList();
        this.spanIdCache = new CopyOnWriteArrayList();
        this.isFinish = new AtomicBoolean(false);
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void endTrace(long j) {
        if (this.isFinish.get()) {
            return;
        }
        this.isFinish.set(true);
        try {
            try {
                checkTagKey();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("start_timestamp", this.startTs);
                jSONObject.put("finish_timestamp", j);
                jSONObject.put("is_finished", 1);
                jSONObject.put("report_mode", 1);
                jSONObject.put("insert_mode", 2);
                jSONObject.put("log_type", "tracer");
                packageCommonParam(jSONObject, false);
                if (this.tags != null && !this.tags.isEmpty()) {
                    jSONObject.put("tags", new JSONObject(this.tags));
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                Iterator<JSONObject> it = this.spanCacheData.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                LaunchAnalysisContext.getInstance().logD(BatchTracingLogWrapUtils.wrapData(jSONArray) + "");
                CommonDataPipeline.getInstance().handle(new TracingData(BatchTracingLogWrapUtils.wrapData(jSONArray), this.context.getService(), false, "batch_tracing"));
            } catch (JSONException e) {
                Logger.m87e("TracingData", "error when BatchTracing end trace: " + e.getLocalizedMessage());
            }
        } finally {
            this.spanCacheData.clear();
        }
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void finishSpan(long j, JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        if (this.isFinish.get()) {
            LaunchAnalysisContext.getInstance().logE(jSONObject + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return;
        }
        if (this.spanIdCache.contains(Long.valueOf(j))) {
            return;
        }
        try {
            if (this.context.isForceTrace() || TraceSettings.getInstance().isErrorOrSampleHit(z, this.context.getService()) != 0) {
                packageCommonParam(jSONObject, z);
                this.spanCacheData.add(jSONObject);
                this.spanIdCache.add(Long.valueOf(j));
            }
        } catch (Throwable th) {
            Log.e("TracingData", "error: " + th.getLocalizedMessage());
        }
    }

    @Override // com.bytedance.apm.trace.model.AbsTracing
    public void cancelTrace() {
        this.isFinish.set(true);
        this.spanCacheData.clear();
        this.spanIdCache.clear();
    }
}
