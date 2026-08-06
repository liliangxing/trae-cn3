package com.bytedance.apm.trace.api;

import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.model.AbsTracing;
import com.bytedance.apm.trace.model.BatchTracing;
import com.bytedance.apm.trace.model.cross.NativeSpan;
import com.bytedance.apm.trace.model.cross.TracingCrossManager;
import com.bytedance.tracing.internal.utils.RandomUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TracingContext {
    private final boolean forceTrace;
    private boolean isEnd;
    private boolean isStart;
    private boolean isWithCross;
    private final String service;
    private long startTs;
    private final long traceId;
    private AbsTracing tracing;
    private final TracingMode tracingMode;

    public TracingContext(String str, TracingMode tracingMode) {
        this(str, tracingMode, false);
    }

    public TracingContext(String str, TracingMode tracingMode, boolean z) {
        this.service = str;
        this.traceId = RandomUtil.uniqueId();
        this.tracingMode = tracingMode;
        this.forceTrace = z;
    }

    public synchronized void start() {
        if (this.isStart) {
            return;
        }
        rawStart(false);
    }

    public synchronized void startWithCross() {
        if (this.isStart) {
            return;
        }
        this.isWithCross = true;
        rawStart(true);
    }

    private void rawStart(boolean z) {
        this.tracing = parseTracingMode(this.tracingMode);
        long currentTimeMillis = System.currentTimeMillis();
        this.startTs = currentTimeMillis;
        this.tracing.startTrace(currentTimeMillis);
        this.isStart = true;
        if (z) {
            TracingCrossManager.registerCross(this.traceId, this);
        }
    }

    public synchronized void end() {
        if (!this.isEnd && this.isStart) {
            final long currentTimeMillis = System.currentTimeMillis();
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.api.TracingContext.1
                @Override // java.lang.Runnable
                public void run() {
                    TracingContext.this.tracing.endTrace(currentTimeMillis);
                    TracingContext.this.tracing = null;
                }
            });
            this.isEnd = true;
            if (this.isWithCross) {
                TracingCrossManager.unRegisterCross(this.traceId);
            }
        }
    }

    public synchronized void end(long j) {
        if (!this.isEnd && this.isStart) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.startTs > j) {
                cancel();
            } else {
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.api.TracingContext.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TracingContext.this.tracing.endTrace(currentTimeMillis);
                        TracingContext.this.tracing = null;
                    }
                });
            }
            this.isEnd = true;
            if (this.isWithCross) {
                TracingCrossManager.unRegisterCross(this.traceId);
            }
        }
    }

    public synchronized void cancel() {
        if (!this.isEnd && this.isStart) {
            this.tracing.cancelTrace();
            this.tracing = null;
            this.isEnd = true;
            if (this.isWithCross) {
                TracingCrossManager.unRegisterCross(this.traceId);
            }
        }
    }

    public synchronized ITracingSpan createSpan(String str) {
        if (!this.isEnd && this.isStart) {
            return this.tracing.createSpan(str);
        }
        LaunchAnalysisContext.getInstance().logE(str + " is start after Trace finish or before Trace begin, it will be ignore!!!!");
        return null;
    }

    public synchronized ITracingWindowSpan createWindowSpan(String str) {
        if (!this.isEnd && this.isStart) {
            return this.tracing.createWindowSpan(str);
        }
        LaunchAnalysisContext.getInstance().logE(str + " is start after Trace finish or before Trace begin, it will be ignore!!!!");
        return null;
    }

    public synchronized void addTracingTag(String str, String str2) {
        if (!this.isEnd && this.isStart) {
            this.tracing.addTag(str, str2);
        }
    }

    public synchronized void assembleAsChild(String str, ArrayList<NativeSpan> arrayList) {
        if (!this.isEnd && this.isStart) {
            Iterator<NativeSpan> it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                NativeSpan next = it.next();
                if (next != null) {
                    ITracingWindowSpan parseToSpan = next.parseToSpan(this.tracing);
                    if (z) {
                        parseToSpan.setParentId(Long.parseLong(str));
                    }
                    parseToSpan.endWindowSpan(next.getStartTime(), next.getFinishTime());
                    z = false;
                }
            }
        }
    }

    public synchronized void assembleAsReference(String str, ArrayList<NativeSpan> arrayList) {
        if (!this.isEnd && this.isStart) {
            Iterator<NativeSpan> it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                NativeSpan next = it.next();
                if (next != null) {
                    ITracingWindowSpan parseToSpan = next.parseToSpan(this.tracing);
                    if (z) {
                        parseToSpan.setReferenceId(Long.parseLong(str));
                    }
                    parseToSpan.endWindowSpan(next.getStartTime(), next.getFinishTime());
                    z = false;
                }
            }
        }
    }

    public String getService() {
        return this.service;
    }

    public long getTraceId() {
        return this.traceId;
    }

    public boolean isForceTrace() {
        return this.forceTrace;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.apm.trace.api.TracingContext$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$apm$trace$api$TracingMode;

        static {
            int[] iArr = new int[TracingMode.values().length];
            $SwitchMap$com$bytedance$apm$trace$api$TracingMode = iArr;
            try {
                iArr[TracingMode.BATCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private AbsTracing parseTracingMode(TracingMode tracingMode) {
        if (AnonymousClass3.$SwitchMap$com$bytedance$apm$trace$api$TracingMode[tracingMode.ordinal()] != 1) {
            return null;
        }
        return new BatchTracing(this);
    }
}
