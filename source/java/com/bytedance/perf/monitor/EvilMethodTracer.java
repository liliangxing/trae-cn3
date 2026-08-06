package com.bytedance.perf.monitor;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.AbsLooperObserver;
import com.bytedance.apm.block.EvilMethodSwitchListener;
import com.bytedance.apm.block.EvilMethodSwitchManager;
import com.bytedance.apm.block.FluencySceneManager;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.block.trace.MethodItem;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.EventData;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.logging.MethodLogger;
import com.bytedance.apm6.util.Tools;
import com.bytedance.monitor.collector.AbsLooperDispatchListener;
import com.bytedance.monitor.collector.IHyperMonitor;
import com.bytedance.monitor.collector.LooperDispatchMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.monitor.collector.Util;
import com.bytedance.perf.collector.TraceDataUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class EvilMethodTracer extends AbsLooperObserver implements EvilMethodSwitchListener {
    public static final String EVIL_METHOD_ANALYSE_EXCEPTION = "evil_method_analyse_exception";
    public static final String EVIL_METHOD_BEGIN = "evil_method_begin";
    public static final String EVIL_METHOD_DATA_NULL = "evil_method_data_null";
    public static final String EVIL_METHOD_END = "evil_method_end";
    public static final String EVIL_METHOD_SECTION = "evil_method_section";
    private static final String EVIL_METHOD_TAG = "method_tracer";
    public static final String EVIL_METHOD_TRACING = "evil_method_tracing";
    private static final long MASK_TIME_DURATION = 300;
    private static final String TAG = "EvilMethodTracer";
    private static long evilThresholdMs;
    public static boolean isEvilMethodTraceEnable;
    public static boolean isMethodTraced;
    private static volatile boolean isRegisterConfig;
    private static IBlockListener sBlockListener;
    private static EvilMethodTracer sEvilMethodTracer;
    private MethodCollector.IndexRecord indexRecord;
    private volatile boolean isHyperMode;
    private boolean isStartTrace;
    private MethodCollector.IndexRecord lastIndexRecord;
    private volatile long lastMaskTime;
    private volatile String mCurrentMsg;
    private AnalyseTask mLastTask;
    private boolean mLimitDepth;
    private long[] queueTypeCosts;

    public EvilMethodTracer() {
        this(false);
    }

    public EvilMethodTracer(boolean z) {
        this(false, false);
    }

    public EvilMethodTracer(boolean z, boolean z2) {
        this.isHyperMode = false;
        this.queueTypeCosts = new long[3];
        this.lastMaskTime = 0L;
        this.mLastTask = null;
        this.isStartTrace = false;
        this.mLimitDepth = z;
        if (!z2) {
            registerConfig();
        }
        if (sEvilMethodTracer == null) {
            sEvilMethodTracer = this;
        }
    }

    public static void setBlockListener(IBlockListener iBlockListener) {
        sBlockListener = iBlockListener;
    }

    public static EvilMethodTracer getEvilMethodTracer() {
        return sEvilMethodTracer;
    }

    public void onRefresh(boolean z, long j) {
        setEvilThresholdMs(j);
        isEvilMethodTraceEnable = z;
        if (z) {
            return;
        }
        Tools.runOnUiThread(new Runnable() { // from class: com.bytedance.perf.monitor.EvilMethodTracer.1
            @Override // java.lang.Runnable
            public void run() {
                MainThreadMonitor.getMonitor().removeObserver(EvilMethodTracer.this);
            }
        });
        MethodCollector.getInstance().onStop();
    }

    public synchronized void startTrace() {
        if (this.isStartTrace) {
            return;
        }
        if (isEvilMethodTraceEnable && isMethodTraced) {
            MainThreadMonitor.getMonitor().addObserver(this);
        }
        this.isStartTrace = true;
    }

    public synchronized void stopTrace() {
        if (this.isStartTrace) {
            if (isEvilMethodTraceEnable) {
                MainThreadMonitor.getMonitor().removeObserver(this);
            }
            this.isStartTrace = false;
        }
    }

    public void dispatchBegin(String str) {
        super.dispatchBegin(str);
        MethodCollector.i(1048574, AbsLooperDispatchListener.uptime);
        if (AbsLooperDispatchListener.uptime - this.lastMaskTime > 300) {
            this.lastIndexRecord = this.indexRecord;
            this.lastMaskTime = AbsLooperDispatchListener.uptime;
            this.indexRecord = MethodCollector.maskIndex("EvilMethodTracer#dispatchBegin", 0L);
            if (this.isHyperMode && this.lastIndexRecord != null) {
                try {
                    final long[] copyData = MethodCollector.getInstance().copyData(this.lastIndexRecord);
                    final long j = AbsLooperDispatchListener.uptime;
                    PerfMonitorManager.getInstance().getThreadWithHandler().post(new Runnable() { // from class: com.bytedance.perf.monitor.EvilMethodTracer.2
                        @Override // java.lang.Runnable
                        public void run() {
                            LinkedList linkedList = new LinkedList();
                            TraceDataUtils.structuredDataToStack(copyData, (LinkedList<MethodItem>) linkedList, true, AbsLooperDispatchListener.uptime);
                            TraceDataUtils.simplyTrimStack(linkedList, 5);
                            IHyperMonitor.ILogInstance logInstance = PerfMonitorManager.getInstance().getLogInstance();
                            if (logInstance != null && linkedList.size() > 2) {
                                logInstance.m109i(EvilMethodTracer.EVIL_METHOD_TAG, "in," + j);
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    logInstance.m109i(EvilMethodTracer.EVIL_METHOD_TAG, ((MethodItem) it.next()).toString());
                                }
                            }
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        }
        this.mCurrentMsg = str;
    }

    public void dispatchEnd(long j, long j2, long j3, long j4, boolean z) {
        String str;
        super.dispatchEnd(j, j2, j3, j4, z);
        MethodCollector.o(1048574, AbsLooperDispatchListener.uptime);
        AnalyseTask analyseTask = this.mLastTask;
        if (analyseTask != null) {
            analyseTask.blockFrame = z;
            this.mLastTask.blockInput = MainThreadMonitor.getMonitor().mainThreadInfo.isInputDelayed();
            com.bytedance.apm.thread.AsyncEventManager.getInstance().post(this.mLastTask);
            this.mLastTask = null;
        }
        if (MethodCollector.getInstance().isAlive()) {
            long j5 = j3 - j;
            if (j5 >= evilThresholdMs) {
                IBlockListener iBlockListener = sBlockListener;
                if (iBlockListener != null) {
                    iBlockListener.doBlock(j5, z);
                }
                reportEvilMethod(EVIL_METHOD_BEGIN);
                long[] copyData = MethodCollector.getInstance().copyData(this.indexRecord);
                if (copyData == null || copyData.length == 0) {
                    reportEvilMethod(EVIL_METHOD_DATA_NULL);
                    return;
                }
                long[] jArr = new long[3];
                System.arraycopy(this.queueTypeCosts, 0, jArr, 0, 3);
                String injectScene = FluencySceneManager.getInjectScene();
                if (TextUtils.isEmpty(injectScene)) {
                    str = ActivityLifeObserver.getInstance().getTopActivityClassName();
                } else {
                    str = injectScene + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
                }
                this.mLastTask = new AnalyseTask(ActivityLifeObserver.getInstance().isForeground(), str, copyData, jArr, j4 - j2, j5, j3, this.mCurrentMsg, System.currentTimeMillis(), "uuid", PerfMonitorManager.getInstance().getLastMessageItem());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportEvilMethod(final String str) {
        com.bytedance.apm.thread.AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.perf.monitor.EvilMethodTracer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(EvilMethodTracer.EVIL_METHOD_SECTION, str);
                    CommonDataPipeline.getInstance().handle(new EventData(EvilMethodTracer.EVIL_METHOD_TRACING, 0, (JSONObject) null, jSONObject, (JSONObject) null, (JSONObject) null));
                } catch (JSONException unused) {
                }
            }
        });
    }

    public synchronized void startHyperMode() {
        if (this.isHyperMode) {
            return;
        }
        this.isHyperMode = true;
    }

    public synchronized void stopHyperMode() {
        if (this.isHyperMode) {
            this.isHyperMode = false;
        }
    }

    public void registerConfig() {
        if (isRegisterConfig) {
            return;
        }
        EvilMethodSwitchManager.addListener(this);
        isRegisterConfig = true;
    }

    public static void setEvilThresholdMs(long j) {
        if (j < 70) {
            j = 1000;
        }
        evilThresholdMs = j;
    }

    public static void setIsEvilMethodTraceEnable(boolean z) {
        isEvilMethodTraceEnable = z;
    }

    public void setLimitDepth(boolean z) {
        this.mLimitDepth = z;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private class AnalyseTask implements Runnable {
        private boolean blockFrame;
        private boolean blockInput;
        long cost;
        long cpuCost;
        long[] data;
        long endMs;
        boolean isForeground;
        LooperDispatchMonitor.ScheduleItem item;
        String msg;
        long occurTime;
        long[] queueCost;
        String scene;
        String uuid;

        AnalyseTask(boolean z, String str, long[] jArr, long[] jArr2, long j, long j2, long j3, String str2, long j4, String str3, LooperDispatchMonitor.ScheduleItem scheduleItem) {
            this.isForeground = z;
            this.scene = str;
            this.cost = j2;
            this.cpuCost = j;
            this.data = jArr;
            this.queueCost = jArr2;
            this.endMs = j3;
            this.msg = str2;
            this.occurTime = j4;
            this.uuid = str3;
            this.item = scheduleItem;
        }

        void analyse() {
            try {
                LinkedList linkedList = new LinkedList();
                long[] jArr = this.data;
                if (jArr.length > 0) {
                    TraceDataUtils.structuredDataToStack(jArr, (LinkedList<MethodItem>) linkedList, true, this.endMs);
                    TraceDataUtils.trimStack(linkedList, 30, new TraceDataUtils.IStructuredDataFilter() { // from class: com.bytedance.perf.monitor.EvilMethodTracer.AnalyseTask.1
                        @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
                        public int getFilterMaxCount() {
                            return 60;
                        }

                        @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
                        public boolean isFilter(long j, int i) {
                            return j < ((long) (i * 5));
                        }

                        @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
                        public void fallback(List<MethodItem> list, int i) {
                            if (ApmContext.isDebugMode()) {
                                MethodLogger.w(EvilMethodTracer.TAG, "[fallback] size:%s targetSize:%s stack:%s", new Object[]{Integer.valueOf(i), 30, list});
                            }
                            ListIterator<MethodItem> listIterator = list.listIterator(Math.min(i, 30));
                            while (listIterator.hasNext()) {
                                listIterator.next();
                                listIterator.remove();
                            }
                        }
                    });
                }
                if (linkedList.size() <= 2) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                long max = Math.max(this.cost, TraceDataUtils.stackToString(linkedList, sb));
                String treeKey = TraceDataUtils.getTreeKey(linkedList, max);
                JSONObject jSONObject = new JSONObject();
                String sb2 = sb.toString();
                LooperDispatchMonitor.ScheduleItem scheduleItem = this.item;
                if (scheduleItem != null) {
                    scheduleItem.updateBlockInfo(this.uuid, null, null, sb2);
                }
                jSONObject.put(ReportConst.KEY_STACK, sb2);
                jSONObject.put("stack_key", treeKey);
                jSONObject.put(ReportConst.KEY_SCENE, this.scene);
                jSONObject.put("cost_time", max);
                jSONObject.put("cpu_cost", this.cpuCost);
                jSONObject.put("method_time", max);
                PerfMonitorManager perfMonitorManager = PerfMonitorManager.getInstance();
                long j = this.endMs;
                JSONObject dumpInfos = perfMonitorManager.dumpInfos(j - this.cost, j);
                MethodCollector methodCollector = MethodCollector.getInstance();
                long j2 = this.endMs;
                dumpInfos.put(ReportConst.KEY_EVIL_METHOD, methodCollector.getEvilMethod(j2 - this.cost, j2));
                jSONObject.put("custom", dumpInfos);
                jSONObject.put("message", Util.parseMessageKey(this.msg));
                jSONObject.put(ReportConst.KEY_TIMESTAMP, this.endMs);
                jSONObject.put(ReportConst.KEY_EVENT_TYPE, ReportConst.MONITOR_TYPE_EVIL_METHOD);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ReportConst.KEY_CRASH_SECTION, ApmContext.getTimeRange(this.occurTime));
                jSONObject2.put("block_frame", String.valueOf(this.blockFrame));
                jSONObject2.put("block_input", String.valueOf(this.blockInput));
                jSONObject2.put("trace_type", "message");
                jSONObject2.put("update_version_code", ApmContext.getHeaderInner().optString("update_version_code"));
                jSONObject.put(ReportConst.KEY_FILTER, jSONObject2);
                CommonDataPipeline.getInstance().handle(new ExceptionLogData(ReportConst.MONITOR_TYPE_DROP_FRAME_STACK, jSONObject));
                EvilMethodTracer.reportEvilMethod(EvilMethodTracer.EVIL_METHOD_END);
            } catch (Exception unused) {
                EvilMethodTracer.reportEvilMethod(EvilMethodTracer.EVIL_METHOD_ANALYSE_EXCEPTION);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            analyse();
        }
    }
}
