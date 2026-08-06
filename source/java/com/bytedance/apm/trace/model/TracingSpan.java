package com.bytedance.apm.trace.model;

import android.text.TextUtils;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.tracing.internal.LogData;
import com.bytedance.tracing.internal.utils.RandomUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TracingSpan implements ITracingSpan, ITracingWindowSpan {
    private long endTime;
    private boolean errorTag;
    private final String logType;
    private List<LogData> logs;
    private long parentId;
    private long referenceId;
    private final long spanId;
    private final String spanName;
    private long startTime;
    private Map<String, String> tags;
    private String threadName;
    private final AbsTracing tracing;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TracingSpan(String str, String str2, AbsTracing absTracing) {
        this(str, str2, absTracing, RandomUtil.uniqueId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TracingSpan(String str, String str2, AbsTracing absTracing, long j) {
        this.spanName = str;
        this.tracing = absTracing;
        this.logType = str2;
        this.spanId = j;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan setParentId(long j) {
        this.parentId = j;
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan setThreadName(String str) {
        this.threadName = str;
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan setReferenceId(long j) {
        this.referenceId = j;
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingWindowSpan
    public void endWindowSpan(long j, long j2) {
        String str = this.threadName;
        if (str == null || str.isEmpty()) {
            this.threadName = Thread.currentThread().getName();
        }
        this.startTime = j;
        this.endTime = j2;
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.model.TracingSpan.1
            @Override // java.lang.Runnable
            public void run() {
                TracingSpan.this.tracing.finishSpan(TracingSpan.this.spanId, TracingSpan.this.packageData(), TracingSpan.this.errorTag);
            }
        });
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpan
    public void endSpan() {
        String str = this.threadName;
        if (str == null || str.isEmpty()) {
            this.threadName = Thread.currentThread().getName();
        }
        this.endTime = System.currentTimeMillis();
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.model.TracingSpan.2
            @Override // java.lang.Runnable
            public void run() {
                TracingSpan.this.tracing.finishSpan(TracingSpan.this.spanId, TracingSpan.this.packageData(), TracingSpan.this.errorTag);
            }
        });
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpan
    public void startSpan() {
        this.startTime = System.currentTimeMillis();
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan addTag(String str, String str2) {
        this.tracing.addSpanTagKey(str);
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        if (TextUtils.equals(str, "error")) {
            this.errorTag = true;
        }
        this.tags.put(str, str2);
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan addLog(String str) {
        if (str == null) {
            return this;
        }
        if (this.logs == null) {
            this.logs = new LinkedList();
        }
        this.logs.add(new LogData(System.currentTimeMillis(), str, (Map) null));
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public ITracingSpan addLog(String str, Map<String, String> map) {
        if (str == null) {
            return this;
        }
        if (this.logs == null) {
            this.logs = new LinkedList();
        }
        this.logs.add(new LogData(System.currentTimeMillis(), str, map));
        return this;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public void setErrorTag(String str) {
        this.errorTag = true;
        this.tags.put("error", str);
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getSpanId() {
        return this.spanId;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getParentId() {
        return this.parentId;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getReferenceId() {
        return this.referenceId;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public TracingContext getTracingContext() {
        return this.tracing.context;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public String getSpanName() {
        return this.spanName;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public long getFinishTime() {
        return this.endTime;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public List<LogData> getLogs() {
        return this.logs;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public Map<String, String> getTags() {
        return this.tags;
    }

    @Override // com.bytedance.apm.trace.api.ITracingSpanAbility
    public String getThreadName() {
        return this.threadName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject packageData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", this.logType);
            jSONObject.put("span_id", this.spanId + "");
            jSONObject.put("operation_name", this.spanName);
            if (this.parentId != 0) {
                jSONObject.put("parent_id", this.parentId + "");
            }
            if (this.referenceId != 0) {
                jSONObject.put("reference_id", this.referenceId + "");
            }
            jSONObject.put("start_timestamp", this.startTime);
            jSONObject.put("finish_timestamp", this.endTime);
            Map<String, String> map = this.tags;
            if (map != null && !map.isEmpty()) {
                jSONObject.put("tags", new JSONObject(this.tags));
            }
            if (!ListUtils.isEmpty(this.logs)) {
                JSONArray jSONArray = new JSONArray();
                Iterator<LogData> it = this.logs.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJson());
                }
                jSONObject.put("logs", jSONArray);
            }
            jSONObject.put("thread_id", this.threadName);
            jSONObject.put("is_finished", 1);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
