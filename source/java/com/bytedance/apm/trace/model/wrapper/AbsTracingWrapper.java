package com.bytedance.apm.trace.model.wrapper;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.apm.trace.api.wrapper.ITracingWrapper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsTracingWrapper implements ITracingWrapper {
    protected long currentThreadId;
    private long startThreadId;
    protected final TracingContext tracingContext;

    public AbsTracingWrapper(TracingContext tracingContext) {
        this.tracingContext = tracingContext;
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void start() {
        long id = Thread.currentThread().getId();
        this.currentThreadId = id;
        this.startThreadId = id;
        this.tracingContext.start();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void startWithCross() {
        long id = Thread.currentThread().getId();
        this.currentThreadId = id;
        this.startThreadId = id;
        this.tracingContext.startWithCross();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void end() {
        checkInvokeThread(this.startThreadId);
        this.tracingContext.end();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void end(long j) {
        checkInvokeThread(this.startThreadId);
        this.tracingContext.end(j);
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void cancel() {
        checkInvokeThread(this.startThreadId);
        this.tracingContext.cancel();
    }

    @Override // com.bytedance.apm.trace.api.wrapper.ITracingWrapper
    public void addTracingTag(String str, String str2) {
        this.tracingContext.addTracingTag(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkInvokeThread(long j) {
        if (ApmContext.isDebugMode() && Thread.currentThread().getId() != j) {
            throw new IllegalStateException("ITracingWrapper start() should invoke in same thread as end()");
        }
    }
}
