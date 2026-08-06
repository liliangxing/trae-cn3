package com.bytedance.tracing.core;

import android.text.TextUtils;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.tracing.internal.LogData;
import com.bytedance.tracing.internal.TraceData;
import com.bytedance.tracing.internal.utils.RandomUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Deprecated
/* loaded from: classes5.dex */
public class Span {
    private static final String TAG = "Span";
    private SpanContext context;
    private boolean errorTag;
    private long finishTs;
    private List<LogData> logs;
    private String operationName;
    private long parentId;
    private long refId;
    private String serviceName;
    private long spanId;
    private long startTs;
    private Map<String, String> tags;
    private String threadName;
    private long traceId;

    public Span(SpanContext spanContext) {
        this.context = spanContext;
        this.traceId = spanContext.getTraceId();
        this.parentId = spanContext.getParentId();
        this.serviceName = spanContext.getService();
        this.operationName = spanContext.getOperationName();
        this.spanId = spanContext.getSpanId();
        this.refId = spanContext.getRefId();
    }

    public Span(String str, String str2) {
        this(str, str2, RandomUtil.uniqueId(), 0L, RandomUtil.uniqueId(), 0L);
    }

    public Span(String str, String str2, long j, long j2, long j3, long j4) {
        this.traceId = j;
        this.parentId = j2;
        this.serviceName = str;
        this.operationName = str2;
        this.spanId = j3;
        this.refId = j4;
    }

    public Span start() {
        this.startTs = System.currentTimeMillis();
        return this;
    }

    public void finish() {
        this.finishTs = System.currentTimeMillis();
        this.threadName = Thread.currentThread().getName();
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.tracing.core.Span.1
            @Override // java.lang.Runnable
            public void run() {
                CommonDataPipeline.getInstance().handle(new TraceData(Span.this));
            }
        });
    }

    public Span makeChild(String str) {
        return new Span(this.serviceName, str, this.traceId, this.spanId, RandomUtil.uniqueId(), 0L);
    }

    public Span makeChildAndRef(String str, long j) {
        return new Span(this.serviceName, str, this.traceId, this.spanId, RandomUtil.uniqueId(), j);
    }

    public Span addReference(long j) {
        this.refId = j;
        return this;
    }

    public Span addLog(String str) {
        if (str == null) {
            return this;
        }
        if (this.logs == null) {
            this.logs = new LinkedList();
        }
        this.logs.add(new LogData(System.currentTimeMillis(), str, null));
        return this;
    }

    public Span addLog(String str, Map<String, String> map) {
        if (str == null) {
            return this;
        }
        if (this.logs == null) {
            this.logs = new LinkedList();
        }
        this.logs.add(new LogData(System.currentTimeMillis(), str, map));
        return this;
    }

    public Span setErrorTag(String str) {
        return addTag("error", str);
    }

    public Span addTag(String str, String str2) {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        if (TextUtils.equals(str, "error")) {
            this.errorTag = true;
        }
        this.tags.put(str, str2);
        return this;
    }

    public long getStartTs() {
        return this.startTs;
    }

    public long getFinishTs() {
        return this.finishTs;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public List<LogData> getLogs() {
        return this.logs;
    }

    public boolean isErrorTag() {
        return this.errorTag;
    }

    public long getRefId() {
        return this.refId;
    }

    public long getTraceId() {
        return this.traceId;
    }

    public long getParentId() {
        return this.parentId;
    }

    public String getOperationName() {
        return this.operationName;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public long getSpanId() {
        return this.spanId;
    }

    public SpanContext getContext() {
        return this.context;
    }

    public String toString() {
        return "Span{traceId='" + this.traceId + "', parentId='" + this.parentId + "', serviceName='" + this.serviceName + "', operationName='" + this.operationName + "', spanId='" + this.spanId + "', refId='" + this.refId + "', startTs=" + this.startTs + ", finishTs=" + this.finishTs + ", threadName='" + this.threadName + "', tags=" + this.tags + ", logs=" + this.logs + ", errorTag=" + this.errorTag + AbstractJsonLexerKt.END_OBJ;
    }
}
