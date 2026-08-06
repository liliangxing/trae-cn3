package com.bytedance.apm.block;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.listener.IBlockListener;
import com.bytedance.apm.logging.MethodLogger;
import com.bytedance.apm.perf.PerfDataCenter;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.common.util.JellyBeanV16Compat;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.monitor.collector.AbsLooperDispatchListener;
import com.bytedance.monitor.collector.LooperDispatchMonitor;
import com.bytedance.monitor.collector.LooperUtil;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.monitor.collector.SamplingStackUtil;
import com.bytedance.monitor.collector.Util;
import com.bytedance.sliver.Sliver;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class StackThread {
    private static final String INVALID_STACK = "Invalid Stack\n";
    private static final int LIMIT_STACK_DEPTH = 40;
    private static final long MAX_SAVE_LOG_NUM = 60;
    private static final long MAX_SAVE_LOG_TIME = 60000;
    private static final String TAG = "StackThread";
    private static long evilThresholdMs = 1000;
    private static boolean isNativePollOnceEnable;
    private static boolean isSamplingStackEnable;
    private static volatile StackThread sINSTANCE;
    private BlockRecord mCurrentRecord;
    private ThreadWithHandler mThreadWithHandler;
    private volatile boolean mWithSeriousBlock = false;
    private volatile boolean mIgnoreInvalidStack = false;
    private long mBlockInterval = PerfConsts.DEFAULT_BLOCK_INTERVAL_MS;
    private long mSeriousBlockInterval = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
    private boolean dumpingPollOnceStack = false;
    private boolean mEnableDumpStack = true;
    private final StringBuilder catonDumpSb = new StringBuilder(1200);
    private final StringBuilder catonSeriousDumpSb = new StringBuilder(1200);

    /* renamed from: sb */
    private final StringBuilder f38sb = new StringBuilder(1200);
    private BlockRecord mLastBlockRecord = null;
    private volatile boolean belongDump = false;
    private volatile boolean enableGfxMonitor = false;
    private boolean isNeedMonitorBlock = true;
    private boolean isNeedMonitorSeriousBlock = true;
    private LinkedList<ExceptionLogData> mBlockLogData = new LinkedList<>();
    private boolean isSliverDump = false;
    private IBlockListener mBlockListener = null;
    private final Runnable mRunnable = new Runnable() { // from class: com.bytedance.apm.block.StackThread.1
        private void printBlockStackTrack(StackTraceElement[] stackTraceElementArr) {
            if (stackTraceElementArr == null) {
                return;
            }
            TimeoutException timeoutException = new TimeoutException("main thread task execute more than " + StackThread.this.mBlockInterval + "ms");
            timeoutException.setStackTrace(stackTraceElementArr);
            Logger.m194e(StackThread.TAG, "block detected", timeoutException);
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] split;
            int length;
            if (StackThread.this.mCurrentRecord == null) {
                return;
            }
            try {
                StackThread.this.mCurrentRecord.reset();
                int i = 0;
                if (StackThread.this.isSliverDump) {
                    String stackTrace = Sliver.getStackTrace(Looper.getMainLooper().getThread());
                    if (stackTrace.contains(StackThread.this.mBlockDetectorClassName)) {
                        return;
                    }
                    String[] split2 = stackTrace.split("\\)\\n");
                    StackThread.this.catonDumpSb.setLength(0);
                    int length2 = split2.length;
                    while (i < length2) {
                        String str = split2[i];
                        String str2 = "";
                        char[] charArray = str.toCharArray();
                        if (charArray != null && charArray.length != 0) {
                            if (charArray[charArray.length - 1] == '(' && (length = (split = str.split("\\.")).length) > 2) {
                                str2 = split[length - 2];
                            }
                            StackThread.this.catonDumpSb.append("\tat " + str).append(str2).append(".java:1").append(")\n");
                        }
                        i++;
                    }
                    StackThread.this.mCurrentRecord.trace = StackThread.this.catonDumpSb.toString();
                    if (ApmContext.isDebugMode()) {
                        Logger.m193e(StackThread.TAG, "block detected: " + StackThread.this.catonDumpSb.toString());
                        return;
                    }
                    return;
                }
                StackTraceElement[] stackTrace2 = Looper.getMainLooper().getThread().getStackTrace();
                if (stackTrace2[0].getClassName().startsWith(StackThread.this.mBlockDetectorClassName)) {
                    return;
                }
                StackThread.this.mCurrentRecord.traceTime = System.currentTimeMillis();
                StackThread.this.mCurrentRecord.stackTrace = stackTrace2;
                if (ApmContext.isDebugMode()) {
                    printBlockStackTrack(stackTrace2);
                }
                StackThread.this.catonDumpSb.setLength(0);
                int length3 = stackTrace2.length;
                while (i < length3) {
                    StackTraceElement stackTraceElement = stackTrace2[i];
                    StackThread.this.catonDumpSb.append("\tat " + stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
                    i++;
                }
                StackThread.this.mCurrentRecord.trace = StackThread.this.catonDumpSb.toString();
            } catch (Throwable th) {
                MonitorCoreExceptionManager.getInstance().ensureNotReachHere(th, "block_deal_exception");
            }
        }
    };
    private final Runnable mSeriousBlockRunnable = new Runnable() { // from class: com.bytedance.apm.block.StackThread.2
        @Override // java.lang.Runnable
        public void run() {
            String[] split;
            int length;
            try {
                if (StackThread.this.mCurrentRecord == null) {
                    return;
                }
                if (StackThread.this.isSliverDump) {
                    String stackTrace = Sliver.getStackTrace(Looper.getMainLooper().getThread());
                    if (stackTrace.contains(StackThread.this.mBlockDetectorClassName)) {
                        return;
                    }
                    String[] split2 = stackTrace.split("\\)\\n");
                    StackThread.this.catonSeriousDumpSb.setLength(0);
                    for (String str : split2) {
                        String str2 = "";
                        char[] charArray = str.toCharArray();
                        if (charArray != null && charArray.length != 0) {
                            if (charArray[charArray.length - 1] == '(' && (length = (split = str.split("\\.")).length) > 2) {
                                str2 = split[length - 2];
                            }
                            StackThread.this.catonSeriousDumpSb.append("\tat " + str).append(str2).append(".java:1").append(")\n");
                        }
                    }
                    StackThread.this.mCurrentRecord.trace = StackThread.this.catonSeriousDumpSb.toString();
                    StackThread.this.mCurrentRecord.traceTime2 = System.currentTimeMillis();
                    StackThread.this.mCurrentRecord.cpuInfo = PerfDataCenter.getInstance().getCpuInfo();
                    StackThread.this.mCurrentRecord.memoryInfo = StackThread.this.getMemoryInfo();
                    StackThread.this.mCurrentRecord.isSeriousBlock = true;
                    return;
                }
                StackTraceElement[] stackTrace2 = Looper.getMainLooper().getThread().getStackTrace();
                if (stackTrace2[0].getClassName().startsWith(StackThread.this.mBlockDetectorClassName)) {
                    return;
                }
                StackThread.this.mCurrentRecord.traceTime2 = System.currentTimeMillis();
                StackThread.this.mCurrentRecord.stackTrace2 = stackTrace2;
                StackThread.this.mCurrentRecord.cpuInfo = PerfDataCenter.getInstance().getCpuInfo();
                StackThread.this.mCurrentRecord.memoryInfo = StackThread.this.getMemoryInfo();
                StackThread.this.mCurrentRecord.isSeriousBlock = true;
            } catch (Throwable th) {
                MonitorCoreExceptionManager.getInstance().ensureNotReachHere(th, "serious_block_deal_exception");
            }
        }
    };
    private final String mBlockDetectorClassName = StackThread.class.getName();

    private StackThread() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StackThread getInstance() {
        if (sINSTANCE == null) {
            synchronized (StackThread.class) {
                if (sINSTANCE == null) {
                    sINSTANCE = new StackThread();
                }
            }
        }
        return sINSTANCE;
    }

    public void init() {
        ThreadWithHandler threadWithHandler = new ThreadWithHandler(TAG);
        this.mThreadWithHandler = threadWithHandler;
        threadWithHandler.start();
    }

    public void setSliverDump(boolean z) {
        this.isSliverDump = z;
    }

    public static void setEvilThresholdMs(long j) {
        if (j < 70) {
            j = 1000;
        }
        evilThresholdMs = j;
    }

    public static void setIsSamplingStackEnable(boolean z) {
        isSamplingStackEnable = z;
    }

    public void setEnableGfxMonitor(boolean z) {
        this.enableGfxMonitor = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getMemoryInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            Context context = ApmContext.getContext();
            if (context != null) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                jSONObject.put("availMem", memoryInfo.availMem);
                jSONObject.put("lowMemory", memoryInfo.lowMemory);
                jSONObject.put("threshold", memoryInfo.threshold);
                jSONObject.put("totalMem", JellyBeanV16Compat.getTotalMem(memoryInfo));
            }
            Runtime runtime = Runtime.getRuntime();
            jSONObject.put("max_memory", runtime.maxMemory());
            jSONObject.put("free_memory", runtime.freeMemory());
            jSONObject.put("total_memory", runtime.totalMemory());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public void printStart(String str) {
        try {
            if (this.mThreadWithHandler.isReady()) {
                if (isNativePollOnceEnable && this.dumpingPollOnceStack) {
                    this.mCurrentRecord.endTime = AbsLooperDispatchListener.uptime;
                    if (this.mCurrentRecord.endTime - this.mCurrentRecord.beginTime > this.mBlockInterval) {
                        this.mCurrentRecord.isPollOnce = true;
                        this.mCurrentRecord.belongFrame = false;
                        this.mCurrentRecord.belongDump = this.belongDump;
                        handleSingleStack(this.mCurrentRecord.getCopy());
                    }
                }
                if (this.mLastBlockRecord != null && MainThreadMonitor.getMonitor().mainThreadInfo.isInputDelayed()) {
                    this.mLastBlockRecord.delayInputEvent = true;
                }
                BlockRecord blockRecord = this.mCurrentRecord;
                if (blockRecord == null) {
                    this.mCurrentRecord = new BlockRecord(AbsLooperDispatchListener.uptime, str);
                } else {
                    blockRecord.reset(AbsLooperDispatchListener.uptime, str);
                }
                if (this.mEnableDumpStack) {
                    this.mThreadWithHandler.postDelayed(this.mRunnable, this.mBlockInterval);
                    if (this.mWithSeriousBlock && this.isNeedMonitorSeriousBlock) {
                        this.mThreadWithHandler.postDelayed(this.mSeriousBlockRunnable, this.mSeriousBlockInterval);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void printEnd(boolean z) {
        Message messageObject;
        try {
            if (this.mThreadWithHandler.isReady()) {
                BlockRecord blockRecord = this.mLastBlockRecord;
                if (blockRecord != null) {
                    if (z) {
                        blockRecord.delayDoFrame = true;
                    }
                    dealBlockRecord(this.mLastBlockRecord);
                    this.mLastBlockRecord = null;
                }
                BlockRecord blockRecord2 = this.mCurrentRecord;
                if (blockRecord2 != null && blockRecord2.beginTime >= 0 && this.mCurrentRecord.endTime == -1) {
                    this.mCurrentRecord.endTime = AbsLooperDispatchListener.uptime;
                    if (this.mEnableDumpStack) {
                        this.mThreadWithHandler.removeCallbacks(this.mRunnable);
                        this.mThreadWithHandler.removeCallbacks(this.mSeriousBlockRunnable);
                    }
                    if (this.mCurrentRecord.endTime - this.mCurrentRecord.beginTime > this.mBlockInterval) {
                        fillScene(this.mCurrentRecord);
                        this.mCurrentRecord.currentTime = System.currentTimeMillis();
                        if (!this.mEnableDumpStack) {
                            this.mCurrentRecord.ignoreStack = true;
                        }
                        this.mCurrentRecord.belongFrame = z;
                        this.mCurrentRecord.belongDump = this.belongDump;
                        handleSingleStack(this.mCurrentRecord.getCopy());
                        if (this.mCurrentRecord.endTime - this.mCurrentRecord.beginTime > this.mSeriousBlockInterval && z && this.enableGfxMonitor) {
                            GFXInfo.getDisplayList();
                        }
                    }
                    if (isSamplingStackEnable && this.mCurrentRecord.endTime - this.mCurrentRecord.beginTime > evilThresholdMs) {
                        if (TextUtils.isEmpty(this.mCurrentRecord.lastScene)) {
                            fillScene(this.mCurrentRecord);
                        }
                        if (this.mCurrentRecord.currentTime == 0) {
                            this.mCurrentRecord.currentTime = System.currentTimeMillis();
                        }
                        reportStackTrace(z, this.mCurrentRecord.getCopy());
                    }
                    if (!isNativePollOnceEnable || (messageObject = LooperUtil.getMessageObject(LooperUtil.getMainMessageQueue())) == null) {
                        return;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (messageObject.getTarget() == null || messageObject.getWhen() >= uptimeMillis) {
                        return;
                    }
                    this.dumpingPollOnceStack = true;
                    this.mCurrentRecord.reset(uptimeMillis, null);
                    this.mThreadWithHandler.postDelayed(this.mRunnable, this.mBlockInterval);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void setNeedMonitorBlock(boolean z) {
        this.isNeedMonitorBlock = z;
    }

    public void setNeedMonitorSeriousBlock(boolean z) {
        this.isNeedMonitorSeriousBlock = z;
    }

    public void setBlockInterval(long j) {
        if (j < 70) {
            j = PerfConsts.DEFAULT_BLOCK_INTERVAL_MS;
        }
        this.mBlockInterval = j;
        checkBlockInterval();
    }

    public void setSeriousBlockInterval(long j) {
        if (j < this.mBlockInterval) {
            j = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
        }
        this.mSeriousBlockInterval = j;
        checkBlockInterval();
    }

    public void setEnableDumpStack(boolean z) {
        this.mEnableDumpStack = z;
    }

    private void checkBlockInterval() {
        long j = this.mSeriousBlockInterval;
        long j2 = this.mBlockInterval;
        if (j < j2) {
            this.mSeriousBlockInterval = j2 + 50;
        }
    }

    public void setWithSeriousBlock(boolean z) {
        this.mWithSeriousBlock = z;
    }

    public void setIgnoreInvalidStack(boolean z) {
        this.mIgnoreInvalidStack = z;
    }

    public void setBlockListener(IBlockListener iBlockListener) {
        this.mBlockListener = iBlockListener;
    }

    private StackTraceElement[] buildStack(StackTraceElement[] stackTraceElementArr) {
        return stackTraceElementArr != null ? stackTraceElementArr : new StackTraceElement[]{new StackTraceElement(INVALID_STACK, "a", "a.java", 1)};
    }

    private void handleSingleStack(BlockRecord blockRecord) {
        if (blockRecord == null) {
            return;
        }
        if (!blockRecord.isValid) {
            blockRecord.reset();
        }
        blockRecord.isSeriousBlock = blockRecord.endTime - blockRecord.beginTime >= this.mSeriousBlockInterval;
        LooperDispatchMonitor.ScheduleItem lastMessageItem = PerfMonitorManager.getInstance().getLastMessageItem();
        if (lastMessageItem != null) {
            lastMessageItem.updateBlockInfo("uuid", buildStack(blockRecord.stackTrace), blockRecord.isSeriousBlock ? buildStack(blockRecord.stackTrace2) : null, (String) null);
        }
        if (blockRecord.isPollOnce) {
            dealBlockRecord(blockRecord);
        } else {
            this.mLastBlockRecord = blockRecord;
        }
    }

    private void dealBlockRecord(final BlockRecord blockRecord) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.block.StackThread.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                if (blockRecord.endTime - blockRecord.beginTime > StackThread.this.mSeriousBlockInterval && SamplerHelper.getPerfSecondStageSwitch("serious_block_monitor")) {
                    StackThread.this.mCurrentRecord.perfInfo = PerfMonitorManager.getInstance().dumpInfos(blockRecord.beginTime, blockRecord.endTime);
                }
                if (blockRecord.isErrorStack || blockRecord.trace == null || blockRecord.ignoreStack) {
                    if (StackThread.this.mIgnoreInvalidStack) {
                        return;
                    } else {
                        blockRecord.trace = StackThread.INVALID_STACK;
                    }
                }
                if (blockRecord.endTime - blockRecord.beginTime <= StackThread.this.mSeriousBlockInterval || blockRecord.isSeriousBlock || !StackThread.this.mEnableDumpStack) {
                    z = false;
                } else {
                    blockRecord.memoryInfo = StackThread.this.getMemoryInfo();
                    blockRecord.cpuInfo = PerfDataCenter.getInstance().getCpuInfo();
                    z = true;
                    blockRecord.isSeriousBlock = true;
                }
                try {
                    String parseMessageKey = Util.parseMessageKey(blockRecord.msg);
                    StackThread.this.reportBlock(blockRecord.belongFrame, blockRecord, parseMessageKey);
                    if (blockRecord.isSeriousBlock && StackThread.this.mWithSeriousBlock && StackThread.this.mEnableDumpStack) {
                        StackThread.this.reportSeriousBlock(blockRecord, parseMessageKey, z);
                    }
                    StackThread.this.reportMessageKey(blockRecord, parseMessageKey);
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportBlock(boolean z, BlockRecord blockRecord, String str) throws JSONException {
        if (this.isNeedMonitorBlock) {
            JSONObject packRecord = packRecord(blockRecord);
            packRecord.put("stack", blockRecord.trace);
            packRecord.put("message", str);
            packRecord.put(CommonKey.KEY_IGNORE_STACK, this.mCurrentRecord.ignoreStack);
            packRecord.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_LAG);
            packRecord.put("filters", getFilterJson(z, blockRecord, str));
            packRecord.put("custom", getCustomJson());
            ExceptionLogData exceptionLogData = new ExceptionLogData("block_monitor", packRecord, blockRecord.beginTime);
            checkAndPutLogData(exceptionLogData);
            CommonDataPipeline.getInstance().handle(exceptionLogData);
            IBlockListener iBlockListener = this.mBlockListener;
            if (iBlockListener != null) {
                iBlockListener.onBlockDetect(blockRecord.msg, blockRecord.endTime - blockRecord.beginTime, blockRecord.lastScene, blockRecord.trace);
            }
        }
    }

    private void checkAndPutLogData(ExceptionLogData exceptionLogData) {
        while (this.mBlockLogData.size() != 0) {
            if (exceptionLogData.crashTime() - this.mBlockLogData.getFirst().crashTime() >= 0 && exceptionLogData.crashTime() - this.mBlockLogData.getFirst().crashTime() <= 60000) {
                if (this.mBlockLogData.size() <= 60) {
                    break;
                } else {
                    this.mBlockLogData.removeFirst();
                }
            } else {
                this.mBlockLogData.removeFirst();
            }
        }
        this.mBlockLogData.addLast(exceptionLogData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0172 A[LOOP:1: B:24:0x0170->B:25:0x0172, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportSeriousBlock(BlockRecord blockRecord, String str, boolean z) throws JSONException {
        JSONObject jSONObject;
        if (this.isNeedMonitorSeriousBlock) {
            Logger.m193e(TAG, "reportSeriousBlock :" + blockRecord.trace);
            JSONObject filterJson = getFilterJson(blockRecord.belongFrame, blockRecord, str);
            filterJson.put(CommonKey.KEY_SERIOUS_BLOCK_UUID, "empty");
            JSONObject packRecord = packRecord(blockRecord);
            packRecord.put("message", str);
            if (blockRecord.stackTrace != null && blockRecord.stackTrace2 != null) {
                int length = blockRecord.stackTrace.length;
                int length2 = blockRecord.stackTrace2.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= Math.min(length, length2)) {
                        break;
                    }
                    int i3 = (length - i) - 1;
                    int i4 = (length2 - i) - 1;
                    if (blockRecord.stackTrace[i3].equals(blockRecord.stackTrace2[i4])) {
                        i2++;
                        i++;
                    } else if (isSameMethod(blockRecord.stackTrace[i3], blockRecord.stackTrace2[i4])) {
                        i2++;
                    }
                }
                if (i2 == 0) {
                    filterJson.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, SchedulerSupport.NONE);
                } else if (i2 == length && i2 == length2) {
                    filterJson.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, "full");
                } else {
                    filterJson.put(CommonKey.KEY_SERIOUS_STACK_COINCIDE, "part");
                    this.f38sb.setLength(0);
                    int i5 = 0;
                    while (i5 <= length - i2) {
                        this.f38sb.append("\tat ").append(blockRecord.stackTrace[i5].getClassName()).append(".").append(blockRecord.stackTrace[i5].getMethodName()).append("(").append(blockRecord.stackTrace[i5].getFileName()).append(":").append(blockRecord.stackTrace[i5].getLineNumber()).append(")\n");
                        i5++;
                        filterJson = filterJson;
                    }
                    jSONObject = filterJson;
                    packRecord.put(CommonKey.KEY_STACK1, this.f38sb.toString());
                    this.f38sb.setLength(0);
                    for (int i6 = 0; i6 <= length2 - i2; i6++) {
                        this.f38sb.append("\tat ").append(blockRecord.stackTrace2[i6].getClassName()).append(".").append(blockRecord.stackTrace2[i6].getMethodName()).append("(").append(blockRecord.stackTrace2[i6].getFileName()).append(":").append(blockRecord.stackTrace2[i6].getLineNumber()).append(")\n");
                    }
                    packRecord.put(CommonKey.KEY_STACK2, this.f38sb.toString());
                    this.f38sb.setLength(0);
                    while (i2 > 0) {
                        int i7 = length - i2;
                        this.f38sb.append("\tat ").append(blockRecord.stackTrace[i7].getClassName()).append(".").append(blockRecord.stackTrace[i7].getMethodName()).append("(").append(blockRecord.stackTrace[i7].getFileName()).append(":").append(blockRecord.stackTrace[i7].getLineNumber()).append(")\n");
                        i2--;
                    }
                    packRecord.put("stack", this.f38sb.length() != 0 ? blockRecord.trace : this.f38sb.toString());
                    filterJson = jSONObject;
                    filterJson.put(CommonKey.KEY_SERIOUS_BLOCK_UUID, blockRecord.uuid);
                }
                jSONObject = filterJson;
                this.f38sb.setLength(0);
                while (i2 > 0) {
                }
                packRecord.put("stack", this.f38sb.length() != 0 ? blockRecord.trace : this.f38sb.toString());
                filterJson = jSONObject;
                filterJson.put(CommonKey.KEY_SERIOUS_BLOCK_UUID, blockRecord.uuid);
            }
            if (this.isSliverDump) {
                packRecord.put("stack", blockRecord.trace);
                filterJson.put(CommonKey.KEY_SERIOUS_BLOCK_UUID, blockRecord.uuid);
            }
            packRecord.put(CommonKey.KEY_STACK_COST, blockRecord.traceTime2 - blockRecord.traceTime);
            packRecord.put("filters", filterJson);
            packRecord.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_SERIOUS_LAG);
            packRecord.put(CommonKey.KEY_BLOCK_LOOPER_INFO, blockRecord.looperMessages);
            packRecord.put(CommonKey.KEY_BLOCK_CPU_INFO, blockRecord.cpuInfo);
            packRecord.put(CommonKey.KEY_BLOCK_MEMORY_INFO, blockRecord.memoryInfo);
            packRecord.put("custom", blockRecord.perfInfo);
            packRecord.put(CommonKey.KEY_BLOCK_ERROR_INFO, z);
            ExceptionLogData exceptionLogData = new ExceptionLogData("serious_block_monitor", packRecord, blockRecord.beginTime);
            checkAndPutLogData(exceptionLogData);
            CommonDataPipeline.getInstance().handle(exceptionLogData);
            IBlockListener iBlockListener = this.mBlockListener;
            if (iBlockListener != null) {
                iBlockListener.onSeriousBlockDetect(blockRecord.msg, blockRecord.endTime - blockRecord.beginTime, blockRecord.lastScene, blockRecord.trace);
            }
        }
    }

    private void reportStackTrace(final boolean z, final BlockRecord blockRecord) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.block.StackThread.4
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                String dumpStackTrace = PerfMonitorManager.getInstance().dumpStackTrace(blockRecord.beginTime, blockRecord.endTime);
                StringBuilder sb = new StringBuilder();
                long j = blockRecord.endTime - blockRecord.beginTime;
                if (TextUtils.isEmpty(dumpStackTrace)) {
                    return;
                }
                String trimStack = SamplingStackUtil.trimStack(dumpStackTrace, sb, 1000, j);
                if (ApmContext.isDebugMode()) {
                    MethodLogger.m100w(StackThread.TAG, "%s", dumpStackTrace);
                }
                try {
                    jSONObject.put("stack", sb.toString());
                    jSONObject.put("stack_key", trimStack);
                    jSONObject.put("scene", blockRecord.lastScene);
                    jSONObject.put("cost_time", j);
                    jSONObject.put("method_time", j);
                    jSONObject.put("monitor_type", "sampling");
                    jSONObject.put("message", Util.parseMessageKey(blockRecord.msg));
                    jSONObject.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_EVIL_METHOD);
                    JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson(true);
                    perfFiltersJson.put(CommonKey.KEY_CRASH_SECTION, ApmContext.getTimeRange(StackThread.this.mCurrentRecord.currentTime));
                    perfFiltersJson.put(CommonKey.KEY_BELONG_FRAME, String.valueOf(z));
                    perfFiltersJson.put("monitor_type", "sample");
                    jSONObject.put("filters", perfFiltersJson);
                    CommonDataPipeline.getInstance().handle(new ExceptionLogData("drop_frame_stack", jSONObject));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportMessageKey(BlockRecord blockRecord, String str) throws JSONException {
        if (PerfConfig.isReportMessage()) {
            JSONObject packRecord = packRecord(blockRecord);
            JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson(true);
            perfFiltersJson.put(CommonKey.KEY_CRASH_SECTION, ApmContext.getTimeRange(blockRecord.currentTime));
            perfFiltersJson.put(CommonKey.KEY_BELONG_FRAME, String.valueOf(blockRecord.belongFrame));
            perfFiltersJson.put(CommonKey.KEY_BELONG_DUMP, String.valueOf(blockRecord.belongDump));
            perfFiltersJson.put(CommonKey.KEY_BLOCK_STACK_TYPE, "messageKey");
            packRecord.put("filters", perfFiltersJson);
            packRecord.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_LAG);
            packRecord.put("stack", "at " + str + ".*(a.java:-1)");
            ExceptionLogData exceptionLogData = new ExceptionLogData("block_monitor", packRecord);
            exceptionLogData.forceSample();
            CommonDataPipeline.getInstance().handle(exceptionLogData);
        }
    }

    private JSONObject getFilterJson(boolean z, BlockRecord blockRecord, String str) throws JSONException {
        JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson(true);
        perfFiltersJson.put(CommonKey.KEY_CRASH_SECTION, ApmContext.getTimeRange(blockRecord.currentTime));
        perfFiltersJson.put(CommonKey.KEY_BELONG_FRAME, String.valueOf(z));
        perfFiltersJson.put(CommonKey.KEY_BELONG_DUMP, String.valueOf(blockRecord.belongDump));
        perfFiltersJson.put(CommonKey.KEY_BLOCK_INPUT, String.valueOf(blockRecord.delayInputEvent));
        perfFiltersJson.put(CommonKey.KEY_BLOCK_FRAME, String.valueOf(blockRecord.delayDoFrame));
        perfFiltersJson.put(CommonKey.KEY_BLOCK_MESSAGE, str);
        perfFiltersJson.put(CommonKey.KEY_BLOCK_STACK_TYPE, "stack");
        perfFiltersJson.put(CommonKey.KEY_BLOCK_UUID, blockRecord.uuid);
        perfFiltersJson.put(CommonKey.KEY_BELONG_POLL_ONCE, String.valueOf(blockRecord.isPollOnce));
        Map<String, String> tags = BlockDetectorUtil.getTags();
        if (tags != null && !tags.isEmpty()) {
            for (Map.Entry<String, String> entry : tags.entrySet()) {
                perfFiltersJson.put(entry.getKey(), entry.getValue());
            }
        }
        return perfFiltersJson;
    }

    private JSONObject getCustomJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, String> tags = BlockDetectorUtil.getTags();
            if (tags != null && !tags.isEmpty()) {
                for (Map.Entry<String, String> entry : tags.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private JSONObject packRecord(BlockRecord blockRecord) {
        long j = blockRecord.endTime - blockRecord.beginTime;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", blockRecord.currentTime);
            jSONObject.put("crash_time", blockRecord.currentTime);
            jSONObject.put("is_main_process", ApmContext.isMainProcess());
            jSONObject.put("process_name", ApmContext.getCurrentProcessName());
            jSONObject.put(CommonKey.KEY_BLOCK_DURATION, j);
            jSONObject.put(CommonKey.KEY_LAST_SCENE, blockRecord.lastScene);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void fillScene(BlockRecord blockRecord) {
        String injectScene = FpsTracer.getInjectScene();
        if (TextUtils.isEmpty(injectScene)) {
            blockRecord.lastScene = ActivityLifeObserver.getInstance().getTopActivityClassName();
        } else {
            blockRecord.lastScene = injectScene + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
        }
    }

    static boolean isSameMethod(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (stackTraceElement == stackTraceElement2) {
            return true;
        }
        if (stackTraceElement == null || stackTraceElement2 == null) {
            return false;
        }
        return stackTraceElement.getClassName().equals(stackTraceElement2.getClassName()) && objectEquals(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && objectEquals(stackTraceElement.getFileName(), stackTraceElement2.getFileName());
    }

    static boolean objectEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void forceReportLogData() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.block.StackThread.5
            @Override // java.lang.Runnable
            public void run() {
                StackThread.this.reportPerfInfo(uptimeMillis);
                Iterator it = StackThread.this.mBlockLogData.iterator();
                while (it.hasNext()) {
                    ExceptionLogData exceptionLogData = (ExceptionLogData) it.next();
                    try {
                        exceptionLogData.getLogJson().getJSONObject("filters").put(CommonKey.KEY_BEFORE_ANR, "true");
                        exceptionLogData.forceSample();
                    } catch (Throwable unused) {
                    }
                    CommonDataPipeline.getInstance().handle(exceptionLogData);
                }
                StackThread.this.mBlockLogData.clear();
            }
        });
    }

    void sigQuit() {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.block.StackThread.6
            @Override // java.lang.Runnable
            public void run() {
                StackThread.this.belongDump = true;
            }
        });
    }

    void sigQuitEnd() {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.block.StackThread.7
            @Override // java.lang.Runnable
            public void run() {
                StackThread.this.belongDump = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPerfInfo(long j) {
        try {
            String evilMethod = MethodCollector.getInstance().getEvilMethod(0L, j);
            if (TextUtils.isEmpty(evilMethod)) {
                return;
            }
            JSONObject dumpInfos = PerfMonitorManager.getInstance().dumpInfos();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_main_process", ApmContext.isMainProcess());
            jSONObject.put(CommonKey.KEY_BLOCK_DURATION, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
            jSONObject.put("stack", evilMethod);
            jSONObject.put("stack_key", "1048574\n");
            jSONObject.put("scene", AnrManager.ANR_ROOT_DIR);
            jSONObject.put("cost_time", PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
            jSONObject.put("method_time", PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
            jSONObject.put("message", AnrManager.ANR_ROOT_DIR);
            jSONObject.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_EVIL_METHOD);
            JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson(true);
            perfFiltersJson.put(CommonKey.KEY_CRASH_SECTION, ApmContext.getTimeRange(System.currentTimeMillis()));
            perfFiltersJson.put("trace_type", "ANR");
            jSONObject.put("custom", dumpInfos);
            jSONObject.put("filters", perfFiltersJson);
            CommonDataPipeline.getInstance().handle(new ExceptionLogData("drop_frame_stack", jSONObject));
        } catch (Throwable unused) {
        }
    }
}
