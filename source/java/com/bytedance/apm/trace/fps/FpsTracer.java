package com.bytedance.apm.trace.fps;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedance.apm.block.FluencySceneManager;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FpsTracer {
    private static final int FACTOR = 10000;
    private static final long FAKE_FRAME_TIME = 10;
    private static final int MIN_DROP_FRAME = 0;
    private static final String MODIFY_SCENE_TIPS = "modify scene on work thread.";
    private static final int OFFSET_TO_MS = 100;
    private static final String SCROLL_SPEED = "scroll_speed";
    private static final String SCROLL_TIME = "total_scroll_time";
    private static final String TAG = "FpsTracer";
    private static boolean sFullFpsTracer;
    private boolean mCollectWhenNotHit;
    private int mCounter;
    private final JSONObject mExtra;
    private FPSRecordView mFPSFpsRecordView;
    private volatile boolean mFPSState;
    private Choreographer.FrameCallback mFrameCallback;
    private LinkedList<Integer> mFrameCostList;
    private IDropFrameCallback mIDropFrameCallback;
    private IFPSCallBack mIFPSCallBack;
    private IFrameCallBack mIFrameCallBack;
    private IHtrFrmaeCallback mIHtrFrameCallback;
    private long mLastFrameNanos;
    private RealFpsTracer mRealFpsTracer;
    private float mScrollDistanceX;
    private float mScrollDistanceY;
    private float mScrollSpeedX;
    private float mScrollSpeedY;
    private long mStartTimeNanos;
    private String mType;
    private WindowManager mWindowManager;
    private HashMap<String, String> tags;
    private static final Long MONITOR_INTERVAL = 200L;
    private static final Long MAX_INTERVAL = 1000L;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IBlockTimeCallBack {
        void blockTimeCallBack(long j, int i);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IDropFrameCallback {
        void dropFrame(JSONObject jSONObject);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IFPSCallBack {
        void fpsCallBack(double d);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IFrameCallBack {
        void onFrame(long j);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IHtrFrmaeCallback {
        void dropHtrFrame(JSONObject jSONObject, int i);
    }

    static /* synthetic */ int access$604(FpsTracer fpsTracer) {
        int i = fpsTracer.mCounter + 1;
        fpsTracer.mCounter = i;
        return i;
    }

    public FpsTracer(String str) {
        this(str, true);
    }

    public FpsTracer(String str, boolean z) {
        this(str, z, null);
    }

    public FpsTracer(String str, boolean z, JSONObject jSONObject) {
        this.mFPSState = false;
        this.mIFrameCallBack = null;
        this.tags = new HashMap<>();
        this.mScrollSpeedX = 0.0f;
        this.mScrollSpeedY = 0.0f;
        this.mScrollDistanceX = 0.0f;
        this.mScrollDistanceY = 0.0f;
        this.mFPSFpsRecordView = null;
        this.mWindowManager = null;
        this.mStartTimeNanos = -1L;
        this.mLastFrameNanos = -1L;
        this.mCounter = 0;
        this.mExtra = jSONObject;
        if (sFullFpsTracer) {
            this.mRealFpsTracer = new RealFpsTracer(str, z, jSONObject);
            return;
        }
        this.mType = str;
        this.mCollectWhenNotHit = z;
        this.mFrameCostList = new LinkedList<>();
    }

    public void setDropFrameCallback(IDropFrameCallback iDropFrameCallback) {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.setDropFrameCallback(iDropFrameCallback);
        }
        this.mIDropFrameCallback = iDropFrameCallback;
    }

    public void setHtrFrameCallback(IHtrFrmaeCallback iHtrFrmaeCallback) {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.setHtrFrameCallback(iHtrFrmaeCallback);
        }
        this.mIHtrFrameCallback = iHtrFrmaeCallback;
    }

    public void addTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public void removeTag(String str) {
        this.tags.remove(str);
    }

    public void setIFrameCallBack(IFrameCallBack iFrameCallBack) {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.setIFrameCallBack(iFrameCallBack);
        }
        this.mIFrameCallBack = iFrameCallBack;
    }

    public void setScrollSpeed(float f, float f2) {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.setScrollSpeed(f, f2);
        } else {
            this.mScrollSpeedX = f;
            this.mScrollSpeedY = f2;
        }
    }

    public void setScrollDistance(float f, float f2) {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.setScrollDistance(f, f2);
        } else {
            this.mScrollDistanceX = f;
            this.mScrollDistanceY = f2;
        }
    }

    public boolean getMonitorFPSStatus() {
        return this.mFPSState;
    }

    public void setIFPSCallBack(IFPSCallBack iFPSCallBack) {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.setIFPSCallBack(iFPSCallBack);
        }
        this.mIFPSCallBack = iFPSCallBack;
    }

    public void setIBlockTimeCallBack(IBlockTimeCallBack iBlockTimeCallBack) {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.setIBlockTimeCallBack(iBlockTimeCallBack);
        }
    }

    public static void setFullFpsTracer(boolean z) {
        sFullFpsTracer = z;
    }

    public void startRecyclerView(RecyclerView recyclerView) {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.startRecyclerView(recyclerView);
        } else {
            if (recyclerView == null) {
                return;
            }
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.apm.trace.fps.FpsTracer.1
                public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                    super.onScrollStateChanged(recyclerView2, i);
                    if (i != 0) {
                        FpsTracer.this.start();
                    } else {
                        FpsTracer.this.stop();
                    }
                }
            });
        }
    }

    public void start() {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.start();
            return;
        }
        if (this.mFPSState) {
            return;
        }
        if (this.mCollectWhenNotHit || isNeedTraceFps()) {
            resetScrollInfo();
            startHighJellyBean();
            addScene(this.mType);
            this.mFPSState = true;
        }
    }

    private void resetScrollInfo() {
        this.mScrollSpeedX = 0.0f;
        this.mScrollSpeedY = 0.0f;
        this.mScrollDistanceX = 0.0f;
        this.mScrollDistanceY = 0.0f;
    }

    public synchronized void stop() {
        RealFpsTracer realFpsTracer = this.mRealFpsTracer;
        if (realFpsTracer != null) {
            realFpsTracer.stop();
        } else {
            endHighJellyBean();
            removeScene(this.mType);
        }
    }

    private boolean isSampleHit() {
        return SamplerHelper.getPerfFpsAllowSwitch("fps", this.mType);
    }

    private boolean isFpsDropSampleHit() {
        return SamplerHelper.getPerfFpsAllowSwitch("fps_drop", this.mType);
    }

    public boolean isNeedTraceFps() {
        return ApmContext.isNeedSalvage() && (isFpsDropSampleHit() || isSampleHit());
    }

    private void startHighJellyBean() {
        synchronized (this) {
            this.mFrameCostList.clear();
        }
        startJellyBean();
    }

    private void endHighJellyBean() {
        if (this.mFPSState) {
            calculateFps();
            if (this.mFrameCallback != null) {
                Choreographer.getInstance().removeFrameCallback(this.mFrameCallback);
            }
            doReport();
            this.mFPSState = false;
        }
    }

    private void startLowJellyBean() {
        this.mFPSFpsRecordView.mStartTime = -1L;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        layoutParams.gravity = 51;
        layoutParams.flags = 24;
        layoutParams.height = 1;
        layoutParams.width = 1;
        try {
            this.mWindowManager.removeView(this.mFPSFpsRecordView);
        } catch (Exception unused) {
        }
        this.mWindowManager.addView(this.mFPSFpsRecordView, layoutParams);
        this.mFPSFpsRecordView.postDelayed(new Runnable() { // from class: com.bytedance.apm.trace.fps.FpsTracer.2
            @Override // java.lang.Runnable
            public void run() {
                if (FpsTracer.this.mFPSState) {
                    FpsTracer.this.mFPSFpsRecordView.invalidate();
                    FpsTracer.this.mFPSFpsRecordView.postDelayed(this, 10L);
                }
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endLowJellyBean() {
        if (this.mFPSState) {
            try {
                this.mWindowManager.removeView(this.mFPSFpsRecordView);
                this.mFPSFpsRecordView.mStartTime = -1L;
                this.mFPSFpsRecordView.mCounter = 0;
            } catch (Exception unused) {
            }
            this.mFPSState = false;
        }
    }

    private void startJellyBean() {
        this.mStartTimeNanos = -1L;
        this.mLastFrameNanos = -1L;
        this.mCounter = 0;
        this.mFrameCallback = new Choreographer.FrameCallback() { // from class: com.bytedance.apm.trace.fps.FpsTracer.3
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (FpsTracer.this.mStartTimeNanos == -1) {
                    FpsTracer.this.mStartTimeNanos = j;
                }
                if (FpsTracer.this.mIFrameCallBack != null) {
                    FpsTracer.this.mIFrameCallBack.onFrame(j / BatteryFactorConfig.WIFI_BPS);
                }
                FpsTracer.access$604(FpsTracer.this);
                if (FpsTracer.this.mFPSState) {
                    Choreographer.getInstance().postFrameCallback(this);
                }
                FpsTracer fpsTracer = FpsTracer.this;
                fpsTracer.doDropCompute(fpsTracer.mLastFrameNanos, j);
                FpsTracer.this.mLastFrameNanos = j;
            }
        };
        try {
            Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
        } catch (Exception unused) {
            this.mFPSState = false;
            this.mStartTimeNanos = -1L;
            this.mLastFrameNanos = -1L;
            this.mCounter = 0;
            this.mFrameCallback = null;
        }
    }

    private void calculateFps() {
        int i;
        long j = this.mLastFrameNanos - this.mStartTimeNanos;
        if (j <= 0 || (i = this.mCounter) <= 1) {
            return;
        }
        long j2 = ((((i - 1) * 1000) * 1000) * 1000) / j;
        IFPSCallBack iFPSCallBack = this.mIFPSCallBack;
        if (iFPSCallBack != null) {
            iFPSCallBack.fpsCallBack(j2);
        }
        FpsAggregateManger.getInstance().aggregate(this.tags, this.mType, (float) j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDropCompute(long j, long j2) {
        if (this.mLastFrameNanos <= 0) {
            return;
        }
        long j3 = j2 - j;
        if (j3 / BatteryFactorConfig.WIFI_BPS <= 0) {
            return;
        }
        synchronized (this) {
            if (this.mFrameCostList.size() > 20000) {
                this.mFrameCostList.poll();
            }
            this.mFrameCostList.add(Integer.valueOf(((int) j3) / 10000));
        }
    }

    private void doReport() {
        synchronized (this) {
            if (this.mFrameCostList.isEmpty()) {
                return;
            }
            final LinkedList<Integer> linkedList = this.mFrameCostList;
            this.mFrameCostList = new LinkedList<>();
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.fps.FpsTracer.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ListUtils.isEmpty(linkedList)) {
                            return;
                        }
                        float frameIntervalMillis = FpsUtil.getFrameIntervalMillis();
                        int refreshRate = FpsUtil.getRefreshRate();
                        int i = refreshRate - 1;
                        int[] iArr = new int[i + 0 + 1];
                        int i2 = 0;
                        for (Integer num : linkedList) {
                            int max = Math.max(Math.min(FpsTracer.getDroppedCount(num.intValue(), frameIntervalMillis), i), 0);
                            iArr[max] = iArr[max] + 1;
                            i2 += num.intValue() / 100;
                        }
                        JSONObject jSONObject = new JSONObject();
                        for (int i3 = 0; i3 <= i; i3++) {
                            if (iArr[i3] > 0) {
                                jSONObject.put(String.valueOf(i3), iArr[i3]);
                            }
                        }
                        if (FpsTracer.this.mIDropFrameCallback != null) {
                            FpsTracer.this.mIDropFrameCallback.dropFrame(JsonUtils.copyJson(jSONObject));
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("scene", FpsTracer.this.mType);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("total_scroll_time", i2);
                        jSONObject3.put(RealFpsTracer.SCROLL_VELOCITY, FpsTracer.this.mScrollSpeedX + "," + FpsTracer.this.mScrollSpeedY);
                        jSONObject3.put(RealFpsTracer.SCROLL_DISTANCE, FpsTracer.this.mScrollDistanceX + "," + FpsTracer.this.mScrollDistanceY);
                        if (FpsTracer.this.mExtra != null) {
                            jSONObject3.put("extra", FpsTracer.this.mExtra);
                        }
                        jSONObject3.put(CommonKey.KEY_DROP_RATE, 1.0f - ((linkedList.size() * 1.0f) / ((int) (i2 / frameIntervalMillis))));
                        PerfData perfData = new PerfData("fps_drop", FpsTracer.this.mType, jSONObject, jSONObject2, jSONObject3);
                        CommonDataAssembly.wrapFilters(perfData, true);
                        perfData.filters.put(CommonKey.KEY_REFRESH_RATE, refreshRate);
                        CommonDataPipeline.getInstance().handle(perfData);
                    } catch (Exception e) {
                        if (ApmContext.isDebugMode()) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static String getInjectScene() {
        return FluencySceneManager.getInjectScene();
    }

    public static void addScene(String str) {
        FluencySceneManager.addScene(str);
    }

    public static void removeScene(String str) {
        FluencySceneManager.removeScene(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getDroppedCount(int i, float f) {
        int i2 = (int) (f * 100.0f);
        return ((i + (i2 - 1)) / i2) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class FPSRecordView extends View {
        private int mCounter;
        private long mStartTime;

        public FPSRecordView(Context context) {
            super(context);
            this.mStartTime = -1L;
            this.mCounter = 0;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.mStartTime == -1) {
                this.mStartTime = SystemClock.elapsedRealtime();
                this.mCounter = 0;
            } else {
                this.mCounter++;
            }
            if (FpsTracer.this.mIFrameCallBack != null) {
                FpsTracer.this.mIFrameCallBack.onFrame(SystemClock.elapsedRealtime());
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
            if (elapsedRealtime > FpsTracer.MONITOR_INTERVAL.longValue()) {
                double longValue = (this.mCounter / elapsedRealtime) * FpsTracer.MAX_INTERVAL.longValue();
                if (FpsTracer.this.mIFPSCallBack != null) {
                    FpsTracer.this.mIFPSCallBack.fpsCallBack(longValue);
                }
                FpsAggregateManger.getInstance().aggregate(FpsTracer.this.tags, FpsTracer.this.mType, (float) longValue);
                FpsTracer.this.endLowJellyBean();
            }
        }
    }
}
