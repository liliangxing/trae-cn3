package com.lynx.tasm.fluency;

import android.os.SystemClock;
import android.view.Choreographer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.DeviceUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxFpsTracer {
    private static final int MIN_DROP_FRAME = 0;
    private static final int OFFSET_TO_MS = 100;
    private static final String TAG = "LynxFpsTracer";
    private static final double TIME_MS_TO_NS = 1000000.0d;
    private static final double TIME_S_TO_MS = 1000.0d;
    private static final double mDesiredFrameInterval = 0.016666666666666666d;
    private final WeakReference<LynxContext> mContext;
    private Choreographer.FrameCallback mFrameCallback;
    private IFluencyCallback mIFluencyCallback;
    private long mMonitorDur;
    private long mStartTime;
    private volatile boolean mFPSState = false;
    private long mStartTimeNanos = -1;
    private long mLastFrameNanos = -1;
    private int mCounter = 0;
    private int mMaxRefreshRate = -1;
    private LinkedList<Long> mFrameCostList = new LinkedList<>();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IFluencyCallback {
        void report(LynxFpsRawMetrics lynxFpsRawMetrics);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LynxFpsRawMetrics {
        public int drop1;
        public long drop1Duration;
        public int drop25;
        public long drop25Duration;
        public int drop3;
        public long drop3Duration;
        public int drop7;
        public long drop7Duration;
        public long duration;
        public int fps;
        public int frames;
        public int maximumFrames;
    }

    static /* synthetic */ int access$104(LynxFpsTracer lynxFpsTracer) {
        int i = lynxFpsTracer.mCounter + 1;
        lynxFpsTracer.mCounter = i;
        return i;
    }

    public LynxFpsTracer(LynxContext lynxContext) {
        this.mContext = new WeakReference<>(lynxContext);
    }

    public void setFluencyCallback(IFluencyCallback iFluencyCallback) {
        this.mIFluencyCallback = iFluencyCallback;
    }

    public void start() {
        if (this.mFPSState) {
            return;
        }
        startInternal();
        this.mFPSState = true;
    }

    public void stop() {
        if (this.mFPSState) {
            endInternal();
            this.mFPSState = false;
        }
    }

    private void startInternal() {
        this.mFrameCostList.clear();
        this.mStartTimeNanos = -1L;
        this.mLastFrameNanos = -1L;
        this.mCounter = 0;
        this.mFrameCallback = new Choreographer.FrameCallback() { // from class: com.lynx.tasm.fluency.LynxFpsTracer.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (LynxFpsTracer.this.mStartTimeNanos == -1) {
                    LynxFpsTracer.this.mStartTimeNanos = j;
                }
                LynxFpsTracer.access$104(LynxFpsTracer.this);
                if (LynxFpsTracer.this.mFPSState) {
                    Choreographer.getInstance().postFrameCallback(this);
                }
                LynxFpsTracer lynxFpsTracer = LynxFpsTracer.this;
                lynxFpsTracer.doDropCompute(lynxFpsTracer.mLastFrameNanos, j);
                LynxFpsTracer.this.mLastFrameNanos = j;
            }
        };
        try {
            this.mStartTime = SystemClock.elapsedRealtime();
            Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
        } catch (Exception unused) {
            this.mFPSState = false;
            this.mStartTimeNanos = -1L;
            this.mLastFrameNanos = -1L;
            this.mCounter = 0;
            this.mFrameCallback = null;
            this.mStartTime = -1L;
        }
    }

    private void endInternal() {
        this.mMonitorDur = SystemClock.elapsedRealtime() - this.mStartTime;
        if (this.mFrameCallback != null) {
            Choreographer.getInstance().removeFrameCallback(this.mFrameCallback);
        }
        doReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDropCompute(long j, long j2) {
        if (this.mLastFrameNanos <= 0) {
            return;
        }
        double d = (j2 - j) / TIME_MS_TO_NS;
        if (((long) d) <= 0) {
            return;
        }
        if (this.mMaxRefreshRate == -1) {
            this.mMaxRefreshRate = getRefreshRate();
        }
        if (this.mFrameCostList.size() > 20000) {
            this.mFrameCostList.poll();
        }
        this.mFrameCostList.add(Long.valueOf((long) (d * 100.0d)));
    }

    private void doReport() {
        int i;
        IFluencyCallback iFluencyCallback;
        LynxFpsRawMetrics lynxFpsRawMetrics = new LynxFpsRawMetrics();
        lynxFpsRawMetrics.duration = this.mMonitorDur;
        if (this.mLastFrameNanos - this.mStartTimeNanos <= 0 || (i = this.mCounter) <= 1) {
            return;
        }
        lynxFpsRawMetrics.fps = (int) ((((i - 1) * TIME_MS_TO_NS) * TIME_S_TO_MS) / r1);
        lynxFpsRawMetrics.maximumFrames = this.mMaxRefreshRate;
        this.mMaxRefreshRate = -1;
        if (this.mFrameCostList.isEmpty()) {
            return;
        }
        LinkedList<Long> linkedList = this.mFrameCostList;
        this.mFrameCostList = new LinkedList<>();
        if (!linkedList.isEmpty()) {
            int i2 = lynxFpsRawMetrics.maximumFrames - 1;
            for (Long l : linkedList) {
                int max = Math.max(Math.min(getDroppedCount(l, 16.666666666666668d), i2), 0);
                long longValue = (l.longValue() / 100) - ((long) 16.666666666666668d);
                lynxFpsRawMetrics.frames++;
                if (max >= 1) {
                    lynxFpsRawMetrics.drop1++;
                    lynxFpsRawMetrics.drop1Duration += longValue;
                    if (max >= 3) {
                        lynxFpsRawMetrics.drop3++;
                        lynxFpsRawMetrics.drop3Duration += longValue;
                        if (max >= 7) {
                            lynxFpsRawMetrics.drop7++;
                            lynxFpsRawMetrics.drop7Duration += longValue;
                            if (max >= 25) {
                                lynxFpsRawMetrics.drop25++;
                                lynxFpsRawMetrics.drop25Duration += longValue;
                            }
                        }
                    }
                }
            }
        }
        LynxContext lynxContext = this.mContext.get();
        if (lynxContext == null || !lynxContext.enableEventReporter() || (iFluencyCallback = this.mIFluencyCallback) == null) {
            return;
        }
        iFluencyCallback.report(lynxFpsRawMetrics);
    }

    private int getDroppedCount(Long l, double d) {
        return (int) (((l.longValue() + (r6 - 1)) / ((int) (d * 100.0d))) - 1);
    }

    int getRefreshRate() {
        LynxContext lynxContext = this.mContext.get();
        if (lynxContext != null) {
            return getRoundedRate(DeviceUtils.getRefreshRate(lynxContext));
        }
        return 60;
    }

    private int getRoundedRate(float f) {
        if (Math.abs(f - 60.0f) < 5.1f) {
            return 60;
        }
        if (Math.abs(f - 90.0f) < 5.1f) {
            return 90;
        }
        if (Math.abs(f - 120.0f) < 5.1f) {
            return 120;
        }
        return (int) f;
    }
}
