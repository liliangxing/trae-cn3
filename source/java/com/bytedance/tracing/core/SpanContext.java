package com.bytedance.tracing.core;

import com.bytedance.tracing.internal.utils.RandomUtil;

@Deprecated
/* loaded from: classes5.dex */
public class SpanContext {
    private final String operationName;
    private long parentId;
    private long refId;
    private final String service;
    private final long spanId;
    private final long traceId;
    private Tracer tracer;

    /* loaded from: classes5.dex */
    public static final class Builder {
    }

    SpanContext(String str, long j, long j2, String str2, long j3, long j4) {
        this.service = str;
        this.traceId = j;
        this.parentId = j2;
        this.operationName = str2;
        this.spanId = j3;
        this.refId = j4;
    }

    public SpanContext(String str, String str2) {
        this.service = str;
        this.operationName = str2;
        this.traceId = RandomUtil.uniqueId();
        this.spanId = RandomUtil.uniqueId();
    }

    public synchronized Tracer getTracer() {
        if (this.tracer == null) {
            this.tracer = new Tracer(this);
        }
        return this.tracer;
    }

    public SpanContext makeChild(String str) {
        return new SpanContext(this.service, this.traceId, this.spanId, str, RandomUtil.uniqueId(), 0L);
    }

    public SpanContext makeChildAndRef(String str, long j) {
        return new SpanContext(this.service, this.traceId, this.spanId, str, RandomUtil.uniqueId(), j);
    }

    public String toString() {
        return "SpanContext{service='" + this.service + "', traceId='" + this.traceId + "', parentId='" + this.parentId + "', operationName='" + this.operationName + "', spanId='" + this.spanId + "'}";
    }

    public String getService() {
        return this.service;
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

    public long getSpanId() {
        return this.spanId;
    }

    public long getRefId() {
        return this.refId;
    }
}
