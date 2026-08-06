package com.bytedance.tracing.internal;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.tracing.core.Span;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TraceData implements ITypeData {
    private final String service;
    private final Span span;

    public String getSubTypeLabel() {
        return "tracing";
    }

    public String getTypeLabel() {
        return "tracing";
    }

    public boolean isSaveImmediately() {
        return false;
    }

    public boolean isUploadImmediately() {
        return false;
    }

    public boolean supportFetch() {
        return false;
    }

    public TraceData(Span span) {
        this.service = span.getServiceName();
        this.span = span;
    }

    public JSONObject packLog() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", TracingConstants.VALUE_TRACING);
            jSONObject.put(TracingConstants.KEY_TRACE_NAME, this.service);
            jSONObject.put("trace_id", this.span.getTraceId() + "");
            jSONObject.put(TracingConstants.KEY_SPAN_ID, this.span.getSpanId() + "");
            jSONObject.put(TracingConstants.KEY_OP_NAME, this.span.getOperationName());
            jSONObject.put(TracingConstants.KEY_PARENT_ID, this.span.getParentId() + "");
            jSONObject.put(TracingConstants.KEY_REF_ID, this.span.getRefId() + "");
            jSONObject.put(TracingConstants.KEY_START_TIMESTAMP, this.span.getStartTs());
            jSONObject.put(TracingConstants.KEY_END_TIMESTAMP, this.span.getFinishTs());
            Map<String, String> tags = this.span.getTags();
            if (tags != null && !tags.isEmpty()) {
                jSONObject.put(TracingConstants.KEY_TAGS, new JSONObject(this.span.getTags()));
            }
            List<LogData> logs = this.span.getLogs();
            if (!ListUtils.isEmpty(logs)) {
                JSONArray jSONArray = new JSONArray();
                Iterator<LogData> it = logs.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJson());
                }
                jSONObject.put(TracingConstants.KEY_LOGS, jSONArray);
            }
            jSONObject.put(TracingConstants.KEY_THREAD_NAME, this.span.getThreadName());
            jSONObject.put(TracingConstants.KEY_HIT_RULES, TraceSettings.getInstance().isErrorOrSampleHit(this.span.isErrorTag(), this.service));
            jSONObject.put(TracingConstants.KEY_SAMPLE_RATE, TraceSettings.getInstance().getSampleRate(this.service));
            jSONObject.put(TracingConstants.KEY_FINISH_FLAG, 1);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean isSampled(JSONObject jSONObject) {
        return TraceSettings.getInstance().isErrorOrSampleHit(this.span.isErrorTag(), this.service) != 0;
    }
}
