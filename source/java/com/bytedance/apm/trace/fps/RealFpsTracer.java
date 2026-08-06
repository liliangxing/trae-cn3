package com.bytedance.apm.trace.fps;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.trace.FrameTracer;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodItem;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RealFpsTracer {
    private static final int FACTOR = 10000;
    private static final long FAKE_FRAME_TIME = 10;
    private static final double HITCH_THRESHOLD = 8.33d;
    public static final int MIN_DROP_FRAME = 0;
    private static final int OFFSET_TO_MS = 100;
    public static final String REPORT_LIST_SIZEE = "report_list_size";
    public static final String SCROLL_DISTANCE = "distance";
    public static final String SCROLL_TIME = "total_scroll_time";
    public static final String SCROLL_VELOCITY = "velocity";
    private static final String TAG = "FpsTracer";
    private static FrameTracer sFrameTracer;
    private FrameTracer.BlockCollectItem blockCollectItem;
    private final boolean mCollectWhenNotHit;
    private final JSONObject mExtra;
    private FpsRecordView mFPSFpsRecordView;
    private volatile boolean mFPSState;
    private long mFirstFrameTime;
    private LinkedList<Integer> mFrameCostList;
    private volatile FpsTracer.IBlockTimeCallBack mIBlockTimeCallBack;
    private volatile FpsTracer.IDropFrameCallback mIDropFrameCallback;
    private FpsTracer.IFPSCallBack mIFPSCallBack;
    private FpsTracer.IFrameCallBack mIFrameCallBack;
    private volatile FpsTracer.IHtrFrmaeCallback mIHtrFrameCallback;
    private float mScrollDistanceX;
    private float mScrollDistanceY;
    private float mScrollSpeedX;
    private float mScrollSpeedY;
    private final String mType;
    private WindowManager mWindowManager;
    private long startTime;
    private HashMap<String, String> tags;
    private static final Long MONITOR_INTERVAL = 200L;
    private static final Long MAX_INTERVAL = 1000L;

    public RealFpsTracer(String str) {
        this(str, true);
    }

    public RealFpsTracer(String str, boolean z) {
        this(str, z, null);
    }

    public RealFpsTracer(String str, boolean z, JSONObject jSONObject) {
        this.mFPSState = false;
        this.blockCollectItem = new FrameTracer.BlockCollectItem();
        this.mIFrameCallBack = null;
        this.tags = new HashMap<>();
        this.mScrollSpeedX = 0.0f;
        this.mScrollSpeedY = 0.0f;
        this.mScrollDistanceX = 0.0f;
        this.mScrollDistanceY = 0.0f;
        this.startTime = 0L;
        this.mFirstFrameTime = 0L;
        this.mFPSFpsRecordView = null;
        this.mWindowManager = null;
        this.mType = str;
        this.mCollectWhenNotHit = z;
        this.mExtra = jSONObject;
        this.mFrameCostList = new LinkedList<>();
    }

    public void setDropFrameCallback(FpsTracer.IDropFrameCallback iDropFrameCallback) {
        this.mIDropFrameCallback = iDropFrameCallback;
    }

    public void setHtrFrameCallback(FpsTracer.IHtrFrmaeCallback iHtrFrmaeCallback) {
        this.mIHtrFrameCallback = iHtrFrmaeCallback;
    }

    public static void setFrameTracer(FrameTracer frameTracer) {
        sFrameTracer = frameTracer;
    }

    public void setIFrameCallBack(FpsTracer.IFrameCallBack iFrameCallBack) {
        this.mIFrameCallBack = iFrameCallBack;
    }

    public void setScrollSpeed(float f, float f2) {
        this.mScrollSpeedX = f;
        this.mScrollSpeedY = f2;
    }

    public void setScrollDistance(float f, float f2) {
        this.mScrollDistanceX = f;
        this.mScrollDistanceY = f2;
    }

    public boolean getMonitorFPSStatus() {
        return this.mFPSState;
    }

    public void setIFPSCallBack(FpsTracer.IFPSCallBack iFPSCallBack) {
        this.mIFPSCallBack = iFPSCallBack;
    }

    public void startRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.apm.trace.fps.RealFpsTracer.1
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                super.onScrollStateChanged(recyclerView2, i);
                if (i != 0) {
                    RealFpsTracer.this.start();
                } else {
                    RealFpsTracer.this.stop();
                }
            }
        });
    }

    public void addTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public void removeTag(String str) {
        this.tags.remove(str);
    }

    public void start() {
        if (this.mFPSState) {
            return;
        }
        if (this.mCollectWhenNotHit || isNeedTraceFps()) {
            resetScrollInfo();
            startHighJellyBean();
            FpsTracer.addScene(this.mType);
            this.startTime = SystemClock.uptimeMillis();
            this.mFPSState = true;
        }
    }

    private void resetScrollInfo() {
        this.mScrollSpeedX = 0.0f;
        this.mScrollSpeedY = 0.0f;
        this.mScrollDistanceX = 0.0f;
        this.mScrollDistanceY = 0.0f;
        this.startTime = 0L;
    }

    public synchronized void stop() {
        endHighJellyBean();
        FpsTracer.removeScene(this.mType);
    }

    private boolean isSampleHit() {
        return SamplerHelper.getPerfFpsAllowSwitch("fps", this.mType);
    }

    private boolean isFpsDropSampleHit() {
        return SamplerHelper.getPerfFpsAllowSwitch("fps_drop", this.mType);
    }

    public boolean isNeedTraceFps() {
        if (!MainThreadMonitor.getMonitor().isEnableLooperOpt()) {
            return ApmContext.isNeedSalvage() || isFpsDropSampleHit() || isSampleHit();
        }
        if (ApmContext.isNeedSalvage()) {
            return isFpsDropSampleHit() || isSampleHit();
        }
        return false;
    }

    private void startHighJellyBean() {
        if (sFrameTracer != null) {
            this.mFPSState = true;
            sFrameTracer.addFpsTracer(this);
        }
    }

    private void endHighJellyBean() {
        FrameTracer frameTracer = sFrameTracer;
        if (frameTracer != null) {
            frameTracer.removeFpsTracer(this);
            if (this.mFPSState) {
                doReportAndCalculateFps(this.startTime, SystemClock.uptimeMillis());
                this.mFPSState = false;
            }
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
        this.mFPSFpsRecordView.postDelayed(new Runnable() { // from class: com.bytedance.apm.trace.fps.RealFpsTracer.2
            @Override // java.lang.Runnable
            public void run() {
                if (RealFpsTracer.this.mFPSState) {
                    RealFpsTracer.this.mFPSFpsRecordView.invalidate();
                    RealFpsTracer.this.mFPSFpsRecordView.postDelayed(this, 10L);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateFps(Map<String, String> map, float f) {
        FpsTracer.IFPSCallBack iFPSCallBack = this.mIFPSCallBack;
        if (iFPSCallBack != null) {
            iFPSCallBack.fpsCallBack(f);
        }
        FpsAggregateManger.getInstance().aggregate(map, this.mType, f);
    }

    public void doDropCompute(long j) {
        if (j < 0) {
            return;
        }
        synchronized (this) {
            if (this.mFrameCostList.size() > 20000) {
                this.mFrameCostList.poll();
            }
            this.mFrameCostList.add(Integer.valueOf(((int) j) * 100));
        }
    }

    private void doReportAndCalculateFps(long j, long j2) {
        synchronized (this) {
            if (this.mFrameCostList.isEmpty()) {
                return;
            }
            int i = (this.mFirstFrameTime > 0L ? 1 : (this.mFirstFrameTime == 0L ? 0 : -1));
            this.mFirstFrameTime = 0L;
            final LinkedList<Integer> linkedList = this.mFrameCostList;
            this.mFrameCostList = new LinkedList<>();
            final FrameTracer.BlockCollectItem blockCollectItem = this.blockCollectItem;
            this.blockCollectItem = new FrameTracer.BlockCollectItem();
            final HashMap hashMap = new HashMap();
            hashMap.putAll(this.tags);
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.trace.fps.RealFpsTracer.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ListUtils.isEmpty(linkedList)) {
                            return;
                        }
                        float frameIntervalMillis = FpsUtil.getFrameIntervalMillis();
                        int refreshRate = FpsUtil.getRefreshRate();
                        int i2 = refreshRate - 1;
                        int i3 = i2 + 0 + 1;
                        int[] iArr = new int[i3];
                        int[] iArr2 = new int[i3];
                        int i4 = 0;
                        int i5 = 0;
                        int i6 = 0;
                        int i7 = 0;
                        for (Integer num : linkedList) {
                            int droppedCount = RealFpsTracer.getDroppedCount(num.intValue(), frameIntervalMillis);
                            if (droppedCount > 0) {
                                i5 += droppedCount;
                            }
                            int[] iArr3 = iArr;
                            if (num.intValue() >= 833.0d) {
                                i6 += num.intValue() / 100;
                            }
                            int max = Math.max(Math.min(droppedCount, i2), i4);
                            iArr3[max] = iArr3[max] + 1;
                            iArr2[max] = (int) (iArr2[max] + (num.intValue() / 100.0d));
                            i7 += num.intValue() / 100;
                            iArr = iArr3;
                            i5 = i5;
                            i4 = 0;
                        }
                        int[] iArr4 = iArr;
                        int size = ((linkedList.size() * 100) * refreshRate) / (linkedList.size() + i5);
                        hashMap.put(RealFpsTracer.REPORT_LIST_SIZEE, Integer.toString(linkedList.size()));
                        RealFpsTracer.this.calculateFps(hashMap, (float) (size / 100.0d));
                        int size2 = (int) ((linkedList.size() + i5) * frameIntervalMillis);
                        JSONObject jSONObject = new JSONObject();
                        for (int i8 = 0; i8 <= i2; i8++) {
                            if (iArr4[i8] > 0) {
                                jSONObject.put(String.valueOf(i8), iArr4[i8]);
                                int i9 = iArr4[i8];
                            }
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        for (int i10 = 0; i10 <= i2; i10++) {
                            if (iArr2[i10] > 0.1d) {
                                jSONObject2.put(String.valueOf(i10), iArr2[i10]);
                            }
                        }
                        if (RealFpsTracer.this.mIDropFrameCallback != null) {
                            RealFpsTracer.this.mIDropFrameCallback.dropFrame(JsonUtils.copyJson(jSONObject));
                        }
                        if (RealFpsTracer.this.mIBlockTimeCallBack != null) {
                            RealFpsTracer.this.mIBlockTimeCallBack.blockTimeCallBack(blockCollectItem.blockDuration, blockCollectItem.blockCount);
                        }
                        if (RealFpsTracer.this.mIHtrFrameCallback != null) {
                            RealFpsTracer.this.mIHtrFrameCallback.dropHtrFrame(JsonUtils.copyJson(jSONObject2), size2);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("scene", RealFpsTracer.this.mType);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(RealFpsTracer.SCROLL_TIME, i7);
                        jSONObject4.put("dur", size2);
                        jSONObject4.put("hitch_dur_dic", jSONObject2);
                        jSONObject4.put("hitch_dur", i6);
                        jSONObject4.put(RealFpsTracer.SCROLL_VELOCITY, RealFpsTracer.this.mScrollSpeedX + "," + RealFpsTracer.this.mScrollSpeedY);
                        jSONObject4.put(RealFpsTracer.SCROLL_DISTANCE, RealFpsTracer.this.mScrollDistanceX + "," + RealFpsTracer.this.mScrollDistanceY);
                        jSONObject4.put("frame_count", linkedList.size());
                        jSONObject4.put("drop_count", i5);
                        if (RealFpsTracer.this.mExtra != null) {
                            jSONObject4.put("extra", RealFpsTracer.this.mExtra);
                        }
                        jSONObject4.put(CommonKey.KEY_DROP_RATE, 1.0f - ((linkedList.size() * 1.0f) / ((int) (i7 / frameIntervalMillis))));
                        PerfData perfData = new PerfData("fps_drop", RealFpsTracer.this.mType, jSONObject, jSONObject3, jSONObject4);
                        CommonDataAssembly.wrapFilters(perfData, true);
                        perfData.filters.put(CommonKey.KEY_REFRESH_RATE, refreshRate);
                        Map map = hashMap;
                        if (map != null && !map.isEmpty()) {
                            for (Map.Entry entry : hashMap.entrySet()) {
                                perfData.filters.put((String) entry.getKey(), entry.getValue());
                            }
                        }
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

    public static long stackToString(List<MethodItem> list, StringBuilder sb) {
        long j = 0;
        for (MethodItem methodItem : list) {
            sb.append(methodItem.toString()).append('\n');
            if (j < methodItem.durTime) {
                j = methodItem.durTime;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getDroppedCount(int i, float f) {
        return i / ((int) (f * 100.0f));
    }

    public void doBlock(long j, boolean z) {
        this.blockCollectItem.collect(j, z);
    }

    public void setIBlockTimeCallBack(FpsTracer.IBlockTimeCallBack iBlockTimeCallBack) {
        this.mIBlockTimeCallBack = iBlockTimeCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class FpsRecordView extends View {
        private int mCounter;
        private long mStartTime;

        public FpsRecordView(Context context) {
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
            if (RealFpsTracer.this.mIFrameCallBack != null) {
                RealFpsTracer.this.mIFrameCallBack.onFrame(SystemClock.elapsedRealtime());
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
            if (elapsedRealtime > RealFpsTracer.MONITOR_INTERVAL.longValue()) {
                double longValue = (this.mCounter / elapsedRealtime) * RealFpsTracer.MAX_INTERVAL.longValue();
                if (RealFpsTracer.this.mIFPSCallBack != null) {
                    RealFpsTracer.this.mIFPSCallBack.fpsCallBack(longValue);
                }
                FpsAggregateManger.getInstance().aggregate(RealFpsTracer.this.tags, RealFpsTracer.this.mType, (float) longValue);
                RealFpsTracer.this.endLowJellyBean();
            }
        }
    }
}
