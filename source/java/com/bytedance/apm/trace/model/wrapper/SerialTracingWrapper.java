package com.bytedance.apm.trace.model.wrapper;

import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.api.TracingContext;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SerialTracingWrapper extends AbsTracingWrapper {
    private AtomicBoolean isStartTrace;
    protected TracingWrapperRecord record;
    private Map<String, Deque<ITracingSpan>> spanCacheMap;
    private Map<String, Deque<ITracingWindowSpan>> windowSpanCacheMap;

    public SerialTracingWrapper(TracingContext tracingContext) {
        super(tracingContext);
        this.isStartTrace = new AtomicBoolean(false);
        this.spanCacheMap = new LinkedHashMap();
        this.windowSpanCacheMap = new LinkedHashMap();
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void start() {
        if (this.isStartTrace.get()) {
            return;
        }
        super.start();
        TracingWrapperRecord tracingWrapperRecord = new TracingWrapperRecord();
        this.record = tracingWrapperRecord;
        tracingWrapperRecord.startTrace();
        this.isStartTrace.set(true);
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void startWithCross() {
        if (this.isStartTrace.get()) {
            return;
        }
        super.startWithCross();
        TracingWrapperRecord tracingWrapperRecord = new TracingWrapperRecord();
        this.record = tracingWrapperRecord;
        tracingWrapperRecord.startTrace();
        this.isStartTrace.set(true);
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void end() {
        if (this.isStartTrace.get()) {
            this.isStartTrace.set(false);
            super.end();
            this.record.endTrace();
        }
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void end(long j) {
        if (this.isStartTrace.get()) {
            this.isStartTrace.set(false);
            super.end(j);
            this.record.endTrace();
        }
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void cancel() {
        if (this.isStartTrace.get()) {
            this.isStartTrace.set(false);
            super.cancel();
            this.record.endTrace();
        }
    }

    @Override // com.bytedance.apm.trace.model.wrapper.AbsTracingWrapper, com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void addTracingTag(String str, String str2) {
        if (this.isStartTrace.get()) {
            super.addTracingTag(str, str2);
        }
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public ITracingWindowSpan createWindowSpan(String str) {
        if (!this.isStartTrace.get()) {
            LaunchAnalysisContext.getInstance().logE(str + " is start after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return null;
        }
        checkInvokeThread(this.currentThreadId);
        ITracingWindowSpan createWindowSpan = this.tracingContext.createWindowSpan(str);
        if (createWindowSpan != null) {
            Deque<ITracingWindowSpan> deque = this.windowSpanCacheMap.get(str);
            if (deque == null) {
                deque = new LinkedList<>();
                this.windowSpanCacheMap.put(str, deque);
            }
            deque.push(createWindowSpan);
        }
        return createWindowSpan;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void endWindowSpan(String str, long j, long j2) {
        if (!this.isStartTrace.get()) {
            LaunchAnalysisContext.getInstance().logE(str + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return;
        }
        checkInvokeThread(this.currentThreadId);
        Deque<ITracingWindowSpan> deque = this.windowSpanCacheMap.get(str);
        ITracingWindowSpan pop = (deque == null || deque.isEmpty()) ? null : deque.pop();
        if (pop != null) {
            this.record.startSpan(pop);
            pop.endWindowSpan(j, j2);
            this.record.endSpan();
        }
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void createAndEndWindowSpan(String str, long j, long j2) {
        if (!this.isStartTrace.get()) {
            LaunchAnalysisContext.getInstance().logE(str + " is create after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return;
        }
        checkInvokeThread(this.currentThreadId);
        ITracingWindowSpan createWindowSpan = this.tracingContext.createWindowSpan(str);
        if (createWindowSpan != null) {
            this.record.startSpan(createWindowSpan);
            createWindowSpan.endWindowSpan(j, j2);
            this.record.endSpan();
        }
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public ITracingSpan startSpan(String str) {
        if (!this.isStartTrace.get()) {
            LaunchAnalysisContext.getInstance().logE(str + " is start after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return null;
        }
        checkInvokeThread(this.currentThreadId);
        ITracingSpan createSpan = this.tracingContext.createSpan(str);
        if (createSpan != null) {
            Deque<ITracingSpan> deque = this.spanCacheMap.get(str);
            if (deque == null) {
                deque = new LinkedList<>();
                this.spanCacheMap.put(str, deque);
            }
            deque.push(createSpan);
            this.record.startSpan(createSpan);
            createSpan.startSpan();
        }
        return createSpan;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void endSpan(String str) {
        if (!this.isStartTrace.get()) {
            LaunchAnalysisContext.getInstance().logE(str + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return;
        }
        checkInvokeThread(this.currentThreadId);
        Deque<ITracingSpan> deque = this.spanCacheMap.get(str);
        ITracingSpan pop = (deque == null || deque.isEmpty()) ? null : deque.pop();
        if (pop != null) {
            pop.endSpan();
            this.record.endSpan();
        }
    }
}
