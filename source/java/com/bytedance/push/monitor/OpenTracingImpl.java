package com.bytedance.push.monitor;

import com.bytedance.apm.trace.api.ITracingSpan;
import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.apm.trace.api.TracingMode;
import com.bytedance.push.monitor.opentracing.ITracingMonitor;
import com.bytedance.push.utils.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class OpenTracingImpl implements ITracingMonitor {
    private ITracingSpan mInitSpan;
    private ITracingSpan mRequestSenderSpan;
    private ITracingSpan mSenderCheckSpan;
    private ITracingSpan mStartSpan;
    private Map<Integer, ITracingSpan> mRegisterSenderSpans = new ConcurrentHashMap();
    private TimeOutScheduler timeoutScheduler = new TimeOutScheduler();
    private final TracingContext tracingContext = new TracingContext("ug_push_launch", TracingMode.BATCH, true);
    private AtomicBoolean mEndStart = new AtomicBoolean(false);

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public void startInit() {
        this.tracingContext.start();
        ITracingSpan createSpan = this.tracingContext.createSpan("ttpush_init");
        if (createSpan != null) {
            createSpan.startSpan();
            this.mInitSpan = createSpan;
        } else {
            Logger.m270e("error when create init span, tracingContext not start or has end?");
        }
    }

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public void endInit() {
        ITracingSpan iTracingSpan;
        this.mInitSpan.endSpan();
        ITracingSpan createSpan = this.tracingContext.createSpan("ttpush_start");
        if (createSpan != null && (iTracingSpan = this.mInitSpan) != null) {
            createSpan.setParentId(iTracingSpan.getSpanId());
            createSpan.startSpan();
        }
        this.mStartSpan = createSpan;
        this.timeoutScheduler.runWhenTimeout(TimeUnit.MINUTES.toMillis(2L), new Runnable() { // from class: com.bytedance.push.monitor.OpenTracingImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (OpenTracingImpl.this.mStartSpan != null && OpenTracingImpl.this.mEndStart.compareAndSet(false, true)) {
                        OpenTracingImpl.this.mStartSpan.addTag("error", "not call push start method after 2 min");
                        OpenTracingImpl.this.mStartSpan.endSpan();
                        OpenTracingImpl.this.ensureTracingFinish();
                    }
                }
            }
        });
    }

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public void start() {
        synchronized (this) {
            if (this.mStartSpan != null && this.mEndStart.compareAndSet(false, true)) {
                this.mStartSpan.endSpan();
            }
            this.timeoutScheduler.cancelTimeout();
        }
    }

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public void startRequestSender() {
        ITracingSpan createSpan = this.tracingContext.createSpan("ttpush_request_sender");
        if (this.mStartSpan != null && createSpan != null) {
            createSpan.startSpan();
            createSpan.setParentId(this.mStartSpan.getSpanId());
        } else {
            Logger.m270e("error when create requestSenderSpan, tracingContext not start? or has end? or you haven't call BDPush#getPushService()#init method?");
        }
        this.mRequestSenderSpan = createSpan;
    }

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public void endRequestSender(boolean z, int i, String str) {
        ITracingSpan iTracingSpan = this.mRequestSenderSpan;
        if (iTracingSpan == null) {
            Logger.m270e("error internal. mRequestSenderSpan is null");
            return;
        }
        if (!z) {
            iTracingSpan.addTag("error", "errorCode: " + i + ", errorMsg:" + str);
        }
        this.mRequestSenderSpan.endSpan();
    }

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public void startSenderCheck(String str, boolean z) {
        ITracingSpan createSpan = this.tracingContext.createSpan("ttpush_sender_check_valid");
        if (this.mStartSpan == null || createSpan == null) {
            Logger.m270e("error when create senderCheckSpan, tracingContext not start? or has end? or you haven't call BDPush#getPushService()#init method?");
            return;
        }
        createSpan.startSpan();
        createSpan.addLog("sender = " + str + ", fromServer  = " + z);
        ITracingSpan iTracingSpan = this.mRequestSenderSpan;
        if (iTracingSpan != null) {
            createSpan.setParentId(iTracingSpan.getSpanId());
        } else {
            createSpan.setParentId(this.mStartSpan.getSpanId());
        }
        this.mSenderCheckSpan = createSpan;
    }

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public void endSenderCheck(String str, boolean z) {
        ITracingSpan iTracingSpan = this.mSenderCheckSpan;
        if (iTracingSpan == null) {
            Logger.m270e("error internal. mSenderCheckSpan is null");
            return;
        }
        if (!z) {
            iTracingSpan.addTag("error", "sender = " + str + ", fromServer  = false");
        }
        this.mSenderCheckSpan.endSpan();
    }

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public void startRegisterSender(final int i) {
        ITracingSpan createSpan = this.tracingContext.createSpan("ttpush_register_sender_for_type_" + i);
        if (createSpan == null) {
            Logger.m270e("error when create startRegisterSender, tracingContext not start? or has end? or you haven't call BDPush#getPushService()#init method?");
            return;
        }
        createSpan.startSpan();
        ITracingSpan iTracingSpan = this.mSenderCheckSpan;
        if (iTracingSpan != null) {
            createSpan.setParentId(iTracingSpan.getSpanId());
        }
        this.mRegisterSenderSpans.put(Integer.valueOf(i), createSpan);
        this.timeoutScheduler.runWhenTimeout(TimeUnit.MINUTES.toMillis(1L), new Runnable() { // from class: com.bytedance.push.monitor.OpenTracingImpl.2
            @Override // java.lang.Runnable
            public void run() {
                OpenTracingImpl.this.endRegisterSender(false, i, 108, "register " + i + " timeout");
            }
        });
    }

    @Override // com.bytedance.push.monitor.opentracing.ITracingMonitor
    public synchronized void endRegisterSender(boolean z, int i, int i2, String str) {
        ITracingSpan remove = this.mRegisterSenderSpans.remove(Integer.valueOf(i));
        if (remove != null) {
            if (!z) {
                remove.addTag("error", "pushType:" + i + ", errorCode: " + i2 + ", errorMsg:" + str);
            }
            remove.endSpan();
            if (this.mRegisterSenderSpans.isEmpty()) {
                ensureTracingFinish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureTracingFinish() {
        this.tracingContext.end();
        this.timeoutScheduler.cancelTimeout();
    }
}
