package com.bytedance.apm.block.trace;

import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class JankTracer {
    private static final int DEFAULT_END_TAG = 0;
    private static volatile JankTracer sInstance;
    private static volatile boolean sNeePostEnd;
    private volatile IJankCalculator mJankCalculator;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IJankCalculator {
        void collectEnd();

        void doFrame(long j, long[] jArr);

        boolean needFilter();
    }

    public void reportJank(JSONObject jSONObject) {
    }

    private JankTracer() {
    }

    public static JankTracer getInstance() {
        if (sInstance == null) {
            synchronized (JankTracer.class) {
                if (sInstance == null) {
                    sInstance = new JankTracer();
                }
            }
        }
        return sInstance;
    }

    public void setJankCalculator(IJankCalculator iJankCalculator) {
        if (iJankCalculator != null) {
            this.mJankCalculator = iJankCalculator;
        }
    }

    public void doFrame(final long[] jArr, final long j) {
        if (this.mJankCalculator == null) {
            return;
        }
        if (!this.mJankCalculator.needFilter()) {
            MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.JankTracer.1
                @Override // java.lang.Runnable
                public void run() {
                    JankTracer.this.mJankCalculator.doFrame(j, jArr);
                }
            });
            sNeePostEnd = true;
        } else if (sNeePostEnd) {
            MainThreadMonitor.getMonitor().mThreadWithBlockingQueue.post(new Runnable() { // from class: com.bytedance.apm.block.trace.JankTracer.2
                @Override // java.lang.Runnable
                public void run() {
                    JankTracer.this.mJankCalculator.collectEnd();
                }
            });
            sNeePostEnd = false;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static class DefaultJankCalculator implements IJankCalculator {
        @Override // com.bytedance.apm.block.trace.JankTracer.IJankCalculator
        public void collectEnd() {
        }

        @Override // com.bytedance.apm.block.trace.JankTracer.IJankCalculator
        public void doFrame(long j, long[] jArr) {
        }

        @Override // com.bytedance.apm.block.trace.JankTracer.IJankCalculator
        public boolean needFilter() {
            return false;
        }

        DefaultJankCalculator() {
        }
    }
}
