package com.bytedance.apm.trace.model.wrapper;

import android.os.Looper;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.ITracingSpanAbility;
import com.bytedance.apm.trace.api.ITracingWindowSpan;
import com.bytedance.apm.trace.api.TracingContext;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ParallelTracingWrapper extends AbsTracingWrapper {
    private AtomicBoolean isStartTrace;
    protected TracingWrapperRecord record;
    private ThreadLocal<Map<String, Deque<ITracingSpan>>> spanCacheMap;
    private ThreadLocal<Map<String, Deque<ITracingWindowSpan>>> windowSpanCacheMap;

    public ParallelTracingWrapper(TracingContext tracingContext) {
        super(tracingContext);
        this.isStartTrace = new AtomicBoolean(false);
        ThreadLocal<Map<String, Deque<ITracingSpan>>> threadLocal = new ThreadLocal<>();
        this.spanCacheMap = threadLocal;
        threadLocal.set(new LinkedHashMap());
        ThreadLocal<Map<String, Deque<ITracingWindowSpan>>> threadLocal2 = new ThreadLocal<>();
        this.windowSpanCacheMap = threadLocal2;
        threadLocal2.set(new LinkedHashMap());
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
        ITracingWindowSpan createWindowSpan = this.tracingContext.createWindowSpan(str);
        if (createWindowSpan != null) {
            Map<String, Deque<ITracingWindowSpan>> map = this.windowSpanCacheMap.get();
            if (map == null) {
                map = new LinkedHashMap<>();
                this.windowSpanCacheMap.set(map);
            }
            Deque<ITracingWindowSpan> deque = map.get(str);
            if (deque == null) {
                deque = new LinkedList<>();
                map.put(str, deque);
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
        Map<String, Deque<ITracingWindowSpan>> map = this.windowSpanCacheMap.get();
        if (map == null) {
            map = new LinkedHashMap<>();
            this.windowSpanCacheMap.set(map);
        }
        Deque<ITracingWindowSpan> deque = map.get(str);
        ITracingWindowSpan pop = (deque == null || deque.isEmpty()) ? null : deque.pop();
        if (pop != null) {
            buildWindowSpanGraph(pop);
            pop.endWindowSpan(j, j2);
        }
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void createAndEndWindowSpan(String str, long j, long j2) {
        if (!this.isStartTrace.get()) {
            LaunchAnalysisContext.getInstance().logE(str + " is create after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return;
        }
        ITracingWindowSpan createWindowSpan = this.tracingContext.createWindowSpan(str);
        if (createWindowSpan != null) {
            buildWindowSpanGraph(createWindowSpan);
            createWindowSpan.endWindowSpan(j, j2);
        }
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public ITracingSpan startSpan(String str) {
        if (!this.isStartTrace.get()) {
            LaunchAnalysisContext.getInstance().logE(str + " is start after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return null;
        }
        ITracingSpan createSpan = this.tracingContext.createSpan(str);
        if (createSpan != null) {
            Map<String, Deque<ITracingSpan>> map = this.spanCacheMap.get();
            if (map == null) {
                map = new LinkedHashMap<>();
                this.spanCacheMap.set(map);
            }
            Deque<ITracingSpan> deque = map.get(str);
            if (deque == null) {
                deque = new LinkedList<>();
                map.put(str, deque);
            }
            deque.push(createSpan);
            if (isInvokeInMainThread()) {
                this.record.startSpan(createSpan);
                createSpan.startSpan();
            } else {
                ITracingSpanAbility currentTopSpan = this.record.getCurrentTopSpan();
                if (currentTopSpan == null) {
                    currentTopSpan = this.record.getCurrentPopSpan();
                }
                if (currentTopSpan != null) {
                    createSpan.setParentId(currentTopSpan.getSpanId());
                }
                createSpan.startSpan();
            }
        }
        return createSpan;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void endSpan(String str) {
        if (!this.isStartTrace.get()) {
            LaunchAnalysisContext.getInstance().logE(str + " is end after Trace finish not Trace not being !!!!!, it will be ignore!!!!");
            return;
        }
        Map<String, Deque<ITracingSpan>> map = this.spanCacheMap.get();
        if (map == null) {
            map = new LinkedHashMap<>();
            this.spanCacheMap.set(map);
        }
        Deque<ITracingSpan> deque = map.get(str);
        ITracingSpan pop = (deque == null || deque.isEmpty()) ? null : deque.pop();
        if (pop != null) {
            pop.endSpan();
            if (isInvokeInMainThread()) {
                this.record.endSpan();
            }
        }
    }

    private boolean isInvokeInMainThread() {
        return Looper.myLooper() != null && Looper.getMainLooper().equals(Looper.myLooper());
    }

    private void buildWindowSpanGraph(ITracingWindowSpan iTracingWindowSpan) {
        if (iTracingWindowSpan.getParentId() != 0) {
            return;
        }
        ITracingSpanAbility currentTopSpan = this.record.getCurrentTopSpan();
        if (currentTopSpan == null) {
            currentTopSpan = this.record.getCurrentPopSpan();
        }
        if (currentTopSpan != null) {
            iTracingWindowSpan.setParentId(currentTopSpan.getSpanId());
        }
    }
}
