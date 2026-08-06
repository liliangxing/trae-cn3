package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.monitor.collector.IHyperMonitor;
import com.bytedance.monitor.collector.service.ServiceFollowBean;
import com.bytedance.monitor.collector.service.ServiceTrackMonitor;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LooperDispatchMonitor extends AbsMonitor {
    private static int CHECK_TIME_INTERVAL = 0;
    private static final int CHECK_TIME_SIZE = 300;
    private static int GET_STACK_THRESHOLD = 0;
    private static final int MILLION = 1000000;
    private static final int MIN_CACHE_POOL_SIZE = 10;
    private static final int MIN_TICK_TIME = 100;
    public static final String NO_MESSAGE_RUNNING = "no message running";
    private static final int SCHEDULE_TYPE_IDLE = 1;
    private static final int SCHEDULE_TYPE_MESSAGE = 8;
    private static final int SCHEDULE_TYPE_NORMAL = 9;
    private static final String TAG = "LooperDispatchMonitor";
    private static int dumpStackTicks;
    private static volatile IStackTracer sStackTracer;
    private volatile boolean belongJavaMessage;
    private Runnable checkTimeRunnable;
    private volatile boolean isRunning;
    private int mCachePoolSize;
    private CheckTimeItemList mCheckTimeItemList;
    private String mCurrentMsg;
    FrameCallback mFrameCallback;
    private long mLastCPUTime;
    private String mLastMsg;
    private long mLastSaveTime;
    private long mLastTrigTime;
    private AbsLooperDispatchListener mListener;
    private int mMainThreadId;
    private int mMsgCount;
    private volatile int mMsgNumFlag;
    private ScheduleItemList mScheduleItemList;
    private final ThreadWithHandler mThreadWithHandler;
    private int mTickTime;
    private boolean needFrameInfo;
    private static int[] mStartDumpStackTime = {600, 300};
    private static int[] mTickTimes = {200, 100};
    public static boolean sNeedCheckTime = false;
    public static boolean sCheckTimeLevelSwitch = false;
    public static boolean dumpStackTimeSwitch = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface FrameCallback {
        void doFrame(long[] jArr);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class FrameInfo {
        long animationsStart;
        long drawStart;
        long inputHandlingStart;
        long intendedVsync;
        long performTraversalsStart;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    protected void updateConfig(int i) {
    }

    static /* synthetic */ int access$1408(LooperDispatchMonitor looperDispatchMonitor) {
        int i = looperDispatchMonitor.mMsgCount;
        looperDispatchMonitor.mMsgCount = i + 1;
        return i;
    }

    public LooperDispatchMonitor(int i) {
        this(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IStackTracer getStackTracer() {
        return sStackTracer;
    }

    public static void setStackTracer(IStackTracer iStackTracer) {
        sStackTracer = iStackTracer;
    }

    public LooperDispatchMonitor(int i, boolean z) {
        super(i, MonitorType.LOOPER_MONITOR);
        this.mMsgCount = 0;
        this.mMsgNumFlag = 0;
        this.mCachePoolSize = 100;
        this.mTickTime = 200;
        this.mLastSaveTime = -1L;
        this.mLastTrigTime = -1L;
        this.mMainThreadId = -1;
        this.mLastCPUTime = -1L;
        this.isRunning = false;
        this.needFrameInfo = false;
        this.belongJavaMessage = false;
        this.checkTimeRunnable = new Runnable() { // from class: com.bytedance.monitor.collector.LooperDispatchMonitor.2
            private long tickStartTime;
            private long lastCheckTime = 0;
            private int lastMsgFlag = -1;
            private int tick = 0;
            private int lastDumpTick = 0;

            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                CheckTimeItem obtainScheduleItem = LooperDispatchMonitor.this.mCheckTimeItemList.obtainScheduleItem();
                if (this.lastMsgFlag == LooperDispatchMonitor.this.mMsgNumFlag) {
                    this.tick++;
                } else {
                    this.tick = 0;
                    this.lastDumpTick = 0;
                    this.tickStartTime = uptimeMillis;
                }
                this.lastMsgFlag = LooperDispatchMonitor.this.mMsgNumFlag;
                int i2 = this.tick;
                if (i2 > 0 && i2 - this.lastDumpTick >= LooperDispatchMonitor.dumpStackTicks && this.lastCheckTime != 0 && uptimeMillis - this.tickStartTime >= LooperDispatchMonitor.GET_STACK_THRESHOLD && LooperDispatchMonitor.this.belongJavaMessage) {
                    if (LooperDispatchMonitor.sStackTracer != null) {
                        obtainScheduleItem.stacks = LooperDispatchMonitor.this.getStackTracer().getStackTrace(Looper.getMainLooper().getThread());
                    } else {
                        obtainScheduleItem.stacks = Util.stackToString(Looper.getMainLooper().getThread().getStackTrace());
                    }
                    this.lastDumpTick = this.tick;
                }
                obtainScheduleItem.isMessage = LooperDispatchMonitor.this.belongJavaMessage;
                obtainScheduleItem.delay = (uptimeMillis - this.lastCheckTime) - LooperDispatchMonitor.CHECK_TIME_INTERVAL;
                obtainScheduleItem.startTime = uptimeMillis;
                long uptimeMillis2 = SystemClock.uptimeMillis();
                this.lastCheckTime = uptimeMillis2;
                obtainScheduleItem.cost = uptimeMillis2 - uptimeMillis;
                obtainScheduleItem.seqNum = LooperDispatchMonitor.this.mMsgNumFlag;
                LooperDispatchMonitor.this.mThreadWithHandler.postDelayed(LooperDispatchMonitor.this.checkTimeRunnable, LooperDispatchMonitor.CHECK_TIME_INTERVAL);
                LooperDispatchMonitor.this.mCheckTimeItemList.addItem(obtainScheduleItem);
            }
        };
        ServiceTrackMonitor.getInstance().start();
        this.mFrameCallback = new FrameCallback() { // from class: com.bytedance.monitor.collector.LooperDispatchMonitor.1
            @Override // com.bytedance.monitor.collector.LooperDispatchMonitor.FrameCallback
            public void doFrame(long[] jArr) {
                ScheduleItem currentItem;
                if (LooperDispatchMonitor.this.needFrameInfo && LooperDispatchMonitor.this.mScheduleItemList != null && (currentItem = LooperDispatchMonitor.this.mScheduleItemList.getCurrentItem()) != null && currentItem.type == 8) {
                    FrameInfo frameInfo = new FrameInfo();
                    if (jArr != null) {
                        frameInfo.intendedVsync = jArr[1];
                        frameInfo.inputHandlingStart = jArr[5];
                        frameInfo.animationsStart = jArr[6];
                        frameInfo.performTraversalsStart = jArr[7];
                        frameInfo.drawStart = jArr[8];
                    }
                    currentItem.frameInfo = frameInfo;
                }
            }
        };
        if (z || sNeedCheckTime) {
            ThreadWithHandler threadWithHandler = new ThreadWithHandler("looper_monitor__");
            this.mThreadWithHandler = threadWithHandler;
            threadWithHandler.start();
            diffIntervalStrategy();
            this.mCheckTimeItemList = new CheckTimeItemList(300);
            threadWithHandler.postDelayed(this.checkTimeRunnable, CHECK_TIME_INTERVAL);
            return;
        }
        this.mThreadWithHandler = null;
    }

    private void diffIntervalStrategy() {
        boolean z = dumpStackTimeSwitch;
        if (!z && sCheckTimeLevelSwitch) {
            int i = mTickTimes[1];
            CHECK_TIME_INTERVAL = i;
            int i2 = mStartDumpStackTime[0];
            GET_STACK_THRESHOLD = i2;
            dumpStackTicks = i2 / i;
            return;
        }
        if (!z && !sCheckTimeLevelSwitch) {
            int i3 = mTickTimes[0];
            CHECK_TIME_INTERVAL = i3;
            int i4 = mStartDumpStackTime[0];
            GET_STACK_THRESHOLD = i4;
            dumpStackTicks = i4 / i3;
            return;
        }
        if (z && sCheckTimeLevelSwitch) {
            int i5 = mTickTimes[1];
            CHECK_TIME_INTERVAL = i5;
            int i6 = mStartDumpStackTime[1];
            GET_STACK_THRESHOLD = i6;
            dumpStackTicks = i6 / i5;
            return;
        }
        if (!z || sCheckTimeLevelSwitch) {
            return;
        }
        int i7 = mTickTimes[0];
        CHECK_TIME_INTERVAL = i7;
        int i8 = mStartDumpStackTime[1];
        GET_STACK_THRESHOLD = i8;
        dumpStackTicks = i8 / i7;
    }

    public static void setDumpStackTicks(int i) {
        dumpStackTicks = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void startHyperMode() {
        super.startHyperMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void stopHyperMode() {
        super.stopHyperMode();
    }

    private void updateConfig() {
        int i = this.mRunMode;
        if (i == 0 || i == 1) {
            this.mCachePoolSize = 100;
            this.mTickTime = 300;
        } else if (i == 2 || i == 3) {
            this.mCachePoolSize = 300;
            this.mTickTime = 200;
        }
    }

    public void startDispatchMonitor() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        updateConfig();
        this.mScheduleItemList = new ScheduleItemList(this.mCachePoolSize);
        AbsLooperDispatchListener absLooperDispatchListener = new AbsLooperDispatchListener() { // from class: com.bytedance.monitor.collector.LooperDispatchMonitor.3
            @Override // com.bytedance.monitor.collector.AbsLooperDispatchListener
            public boolean isValid() {
                return true;
            }

            @Override // com.bytedance.monitor.collector.AbsLooperDispatchListener
            public void dispatchStart(String str) {
                LooperDispatchMonitor.this.belongJavaMessage = true;
                LooperDispatchMonitor.this.mCurrentMsg = str;
                super.dispatchStart(str);
                LooperDispatchMonitor.this.handleMessage(true, AbsLooperDispatchListener.uptime);
            }

            @Override // com.bytedance.monitor.collector.AbsLooperDispatchListener
            public void dispatchEnd(String str, Message message) {
                super.dispatchEnd(str, message);
                LooperDispatchMonitor.access$1408(LooperDispatchMonitor.this);
                LooperDispatchMonitor.this.handleMessage(false, AbsLooperDispatchListener.uptime);
                LooperDispatchMonitor looperDispatchMonitor = LooperDispatchMonitor.this;
                looperDispatchMonitor.mLastMsg = looperDispatchMonitor.mCurrentMsg;
                LooperDispatchMonitor.this.mCurrentMsg = LooperDispatchMonitor.NO_MESSAGE_RUNNING;
                LooperDispatchMonitor.this.belongJavaMessage = false;
            }
        };
        this.mListener = absLooperDispatchListener;
        LooperMonitor.register(absLooperDispatchListener);
        LooperUtil.getMessageObject(LooperUtil.getMainMessageQueue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(final boolean z, final long j) {
        int i = this.mMsgNumFlag + 1;
        this.mMsgNumFlag = i;
        this.mMsgNumFlag = i & 65535;
        this.needFrameInfo = false;
        if (this.mLastSaveTime < 0) {
            this.mLastSaveTime = j;
        }
        if (this.mLastTrigTime < 0) {
            this.mLastTrigTime = j;
        }
        if (this.mMainThreadId < 0) {
            this.mMainThreadId = Process.myTid();
            this.mLastCPUTime = SystemClock.currentThreadTimeMillis();
        }
        ServiceFollowBean currentService = ServiceTrackMonitor.getCurrentService();
        ServiceTrackMonitor.clearCurrentService();
        long j2 = j - this.mLastSaveTime;
        int i2 = this.mTickTime;
        if (j2 > i2 || currentService != null) {
            long j3 = this.mLastTrigTime;
            if (j - j3 <= i2 && currentService == null) {
                saveScheduleItem(9, j, this.mCurrentMsg);
            } else if (z) {
                if (this.mMsgCount == 0) {
                    saveScheduleItem(1, j, NO_MESSAGE_RUNNING);
                } else {
                    saveScheduleItem(9, j3, this.mLastMsg);
                    saveScheduleItem(1, j, NO_MESSAGE_RUNNING, false, null);
                }
            } else if (this.mMsgCount == 0) {
                saveScheduleItem(8, j, this.mCurrentMsg, true, currentService);
            } else {
                saveScheduleItem(9, j3, this.mLastMsg, false, null);
                saveScheduleItem(8, j, this.mCurrentMsg, true, currentService);
            }
        }
        this.mLastTrigTime = j;
        final String str = this.mCurrentMsg;
        if (this.isHyperMode) {
            final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            PerfMonitorManager.getInstance().mThreadWithHandler.post(new Runnable() { // from class: com.bytedance.monitor.collector.LooperDispatchMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    IHyperMonitor.ILogInstance logInstance = PerfMonitorManager.getInstance().getLogInstance();
                    if (logInstance == null) {
                        return;
                    }
                    if (z) {
                        logInstance.m109i(LooperDispatchMonitor.this.mCollectorType, j + "," + currentThreadTimeMillis + ",B|" + Util.parseMessageKey(str));
                    } else {
                        logInstance.m109i(LooperDispatchMonitor.this.mCollectorType, j + "," + currentThreadTimeMillis + ",E");
                    }
                }
            });
        }
    }

    private void saveScheduleItem(int i, long j, String str) {
        saveScheduleItem(i, j, str, true, null);
    }

    private void saveScheduleItem(int i, long j, String str, boolean z, ServiceFollowBean serviceFollowBean) {
        this.needFrameInfo = true;
        ScheduleItem obtainScheduleItem = this.mScheduleItemList.obtainScheduleItem(i);
        obtainScheduleItem.duration = j - this.mLastSaveTime;
        if (z) {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            obtainScheduleItem.cpuTime = currentThreadTimeMillis - this.mLastCPUTime;
            this.mLastCPUTime = currentThreadTimeMillis;
        } else {
            obtainScheduleItem.cpuTime = -1L;
        }
        obtainScheduleItem.messageCount = this.mMsgCount;
        obtainScheduleItem.dispatchMsg = str;
        obtainScheduleItem.mLastScheduleMsg = this.mLastMsg;
        obtainScheduleItem.startTime = this.mLastSaveTime;
        obtainScheduleItem.itemEndTime = j;
        obtainScheduleItem.lastTrigTime = this.mLastTrigTime;
        if (serviceFollowBean != null) {
            obtainScheduleItem.service = serviceFollowBean;
        }
        this.mScheduleItemList.addItem(obtainScheduleItem);
        this.mMsgCount = 0;
        this.mLastSaveTime = j;
    }

    public ScheduleItem getLastItem() {
        ScheduleItemList scheduleItemList = this.mScheduleItemList;
        if (scheduleItemList != null && this.needFrameInfo && scheduleItemList.getCurrentItem().type == 8) {
            return this.mScheduleItemList.getCurrentItem();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void start() {
        super.start();
        startDispatchMonitor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair<String, ?> dumpInfo() {
        return new Pair<>(this.mCollectorType, dumpMessages());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair<String, ?> dumpInfosRange(long j, long j2) {
        try {
            return new Pair<>(this.mCollectorType, dumpMessages());
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject dumpMessages() {
        long uptimeMillis = SystemClock.uptimeMillis();
        JSONObject jSONObject = new JSONObject();
        JSONArray dumpHistoryMsg = dumpHistoryMsg();
        JSONObject dumpCurrentMsg = dumpCurrentMsg(uptimeMillis);
        JSONArray dumpPendingMsg = dumpPendingMsg(100, uptimeMillis);
        try {
            jSONObject.put("history_message", dumpHistoryMsg);
            jSONObject.put("current_message", dumpCurrentMsg);
            jSONObject.put("pending_messages", dumpPendingMsg);
            jSONObject.put("check_time_info", dumpCheckTime());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public List<ScheduleItem> dumpHistoryMsgItem() {
        ScheduleItemList scheduleItemList = this.mScheduleItemList;
        if (scheduleItemList != null) {
            return scheduleItemList.dumpItemList();
        }
        return null;
    }

    public JSONArray dumpCheckTime() {
        CheckTimeItemList checkTimeItemList = this.mCheckTimeItemList;
        if (checkTimeItemList != null) {
            return checkTimeItemList.dumpItemList();
        }
        return null;
    }

    public JSONArray dumpHistoryMsg() {
        List<ScheduleItem> dumpItemList;
        JSONArray jSONArray = new JSONArray();
        try {
            dumpItemList = this.mScheduleItemList.dumpItemList();
        } catch (Throwable unused) {
        }
        if (dumpItemList == null) {
            return jSONArray;
        }
        int i = 0;
        for (ScheduleItem scheduleItem : dumpItemList) {
            if (scheduleItem != null) {
                i++;
                jSONArray.put(scheduleItem.toJson().put("id", i));
            }
        }
        return jSONArray;
    }

    public ScheduleItem dumpCurrentMsgItem(long j) {
        ScheduleItem scheduleItem = new ScheduleItem();
        scheduleItem.dispatchMsg = this.mCurrentMsg;
        scheduleItem.mLastScheduleMsg = this.mLastMsg;
        scheduleItem.duration = j - this.mLastTrigTime;
        scheduleItem.cpuTime = ProcMonitor.getCpuTime(this.mMainThreadId) - this.mLastCPUTime;
        scheduleItem.messageCount = this.mMsgCount;
        return scheduleItem;
    }

    private JSONObject dumpCurrentMsg(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", this.mCurrentMsg);
            jSONObject.put("currentMessageCost", j - this.mLastTrigTime);
            jSONObject.put("currentMessageCpu", ProcMonitor.getCpuTime(this.mMainThreadId) - this.mLastCPUTime);
            jSONObject.put("messageCount", this.mMsgCount);
            jSONObject.put(TraeAuthManager.STAGE_START, this.mLastTrigTime);
            jSONObject.put(MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE, j);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONArray dumpPendingMsg(int i, long j) {
        MessageQueue mainMessageQueue = LooperUtil.getMainMessageQueue();
        JSONArray jSONArray = new JSONArray();
        if (mainMessageQueue == null) {
            return jSONArray;
        }
        try {
            synchronized (mainMessageQueue) {
                Message messageObject = LooperUtil.getMessageObject(mainMessageQueue);
                if (messageObject == null) {
                    return jSONArray;
                }
                int i2 = 0;
                int i3 = 0;
                while (messageObject != null && i2 < i) {
                    i2++;
                    i3++;
                    JSONObject json = toJson(messageObject, j);
                    try {
                        json.put("id", i3);
                    } catch (JSONException unused) {
                    }
                    jSONArray.put(json);
                    messageObject = LooperUtil.getNextMessage(messageObject);
                }
                return jSONArray;
            }
        } catch (Throwable unused2) {
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class ScheduleItemList {
        ScheduleItem cachedItem;
        int poolSize;
        int position;
        List<ScheduleItem> scheduleItemList = new ArrayList();

        ScheduleItemList(int i) {
            this.poolSize = i;
        }

        ScheduleItem obtainScheduleItem(int i) {
            ScheduleItem scheduleItem = this.cachedItem;
            if (scheduleItem != null) {
                scheduleItem.type = i;
                ScheduleItem scheduleItem2 = this.cachedItem;
                this.cachedItem = null;
                return scheduleItem2;
            }
            ScheduleItem scheduleItem3 = new ScheduleItem();
            scheduleItem3.type = i;
            return scheduleItem3;
        }

        void addItem(ScheduleItem scheduleItem) {
            int size = this.scheduleItemList.size();
            int i = this.poolSize;
            if (size < i) {
                this.scheduleItemList.add(scheduleItem);
                this.position = this.scheduleItemList.size();
            } else {
                int i2 = this.position % i;
                this.position = i2;
                ScheduleItem scheduleItem2 = this.scheduleItemList.set(i2, scheduleItem);
                scheduleItem2.recycle();
                this.cachedItem = scheduleItem2;
                this.position++;
            }
            if (ApmAlogHelper.isFeedbackALogEnabled() && scheduleItem.needPrint()) {
                final String log = scheduleItem.toLog();
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.monitor.collector.LooperDispatchMonitor.ScheduleItemList.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ApmAlogHelper.feedbackI(MonitorType.LOOPER_MONITOR, log);
                    }
                });
            }
        }

        ScheduleItem getCurrentItem() {
            int i = this.position;
            if (i <= 0) {
                return null;
            }
            return this.scheduleItemList.get(i - 1);
        }

        List<ScheduleItem> dumpItemList() {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            if (this.scheduleItemList.size() == this.poolSize) {
                for (int i2 = this.position - 1; i2 < this.scheduleItemList.size(); i2++) {
                    arrayList.add(this.scheduleItemList.get(i2));
                }
                while (i < this.position - 1) {
                    arrayList.add(this.scheduleItemList.get(i));
                    i++;
                }
            } else {
                while (i < this.scheduleItemList.size()) {
                    arrayList.add(this.scheduleItemList.get(i));
                    i++;
                }
            }
            return arrayList;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class ScheduleItem {
        StackTraceElement[] blockStack;
        long cpuTime;
        String dispatchMsg;
        long duration;
        String evilMsg;
        FrameInfo frameInfo;
        long itemEndTime;
        long lastTrigTime;
        public String mLastScheduleMsg;
        int messageCount;
        StackTraceElement[] seriousBlockStack;
        ServiceFollowBean service;
        public long startTime;
        int type;
        String uuid;

        public void updateBlockInfo(String str, StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.uuid = str;
            }
            if (stackTraceElementArr != null) {
                this.blockStack = stackTraceElementArr;
            }
            if (stackTraceElementArr2 != null) {
                this.seriousBlockStack = stackTraceElementArr2;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.evilMsg = str2;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", Util.parseMessageKey(this.dispatchMsg));
                jSONObject.put("cpuDuration", this.cpuTime);
                jSONObject.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, this.duration);
                jSONObject.put("type", this.type);
                jSONObject.put("messageCount", this.messageCount);
                jSONObject.put("lastDuration", this.itemEndTime - this.lastTrigTime);
                jSONObject.put(TraeAuthManager.STAGE_START, this.startTime);
                jSONObject.put(MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE, this.itemEndTime);
                appendExtInfo(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public String toLog() {
            return "msg:" + Util.parseMessageKey(this.dispatchMsg) + ",cpuDuration:" + this.cpuTime + ",duration:" + this.duration + ",type:" + this.type + ",messageCount:" + this.messageCount + ",lastDuration:" + (this.itemEndTime - this.lastTrigTime) + ",start:" + this.startTime + ",end:" + this.itemEndTime;
        }

        boolean needPrint() {
            int i;
            return this.itemEndTime - this.lastTrigTime > 17 || this.duration > 400 || (i = this.messageCount) > 300 || i < 20 || this.type == 1 || this.cpuTime < 20;
        }

        private void appendExtInfo(JSONObject jSONObject) throws JSONException {
            StackTraceElement[] stackTraceElementArr = this.blockStack;
            if (stackTraceElementArr != null) {
                jSONObject.put("block_stack", Util.stackToString(stackTraceElementArr));
            }
            jSONObject.put("block_uuid", this.uuid);
            StackTraceElement[] stackTraceElementArr2 = this.seriousBlockStack;
            if (stackTraceElementArr2 != null) {
                jSONObject.put("sblock_stack", Util.stackToString(stackTraceElementArr2));
            }
            jSONObject.put("sblock_uuid", this.uuid);
            if (TextUtils.isEmpty(this.evilMsg)) {
                jSONObject.put("evil_msg", this.evilMsg);
            }
            jSONObject.put(ReportConst.KEY_BELONG_FRAME, this.frameInfo != null);
            FrameInfo frameInfo = this.frameInfo;
            if (frameInfo != null) {
                jSONObject.put("vsyncDelayTime", this.lastTrigTime - (frameInfo.intendedVsync / 1000000));
                jSONObject.put("doFrameTime", (this.frameInfo.inputHandlingStart / 1000000) - this.lastTrigTime);
                jSONObject.put("inputHandlingTime", (this.frameInfo.animationsStart / 1000000) - (this.frameInfo.inputHandlingStart / 1000000));
                jSONObject.put("animationsTime", (this.frameInfo.performTraversalsStart / 1000000) - (this.frameInfo.animationsStart / 1000000));
                jSONObject.put("performTraversalsTime", (this.frameInfo.drawStart / 1000000) - (this.frameInfo.performTraversalsStart / 1000000));
                jSONObject.put("drawTime", this.itemEndTime - (this.frameInfo.drawStart / 1000000));
            }
            ServiceFollowBean serviceFollowBean = this.service;
            if (serviceFollowBean != null) {
                jSONObject.put("service_name", serviceFollowBean.mServiceName);
                jSONObject.put("service_what", this.service.mWhat);
                jSONObject.put("service_time", this.service.mTimeStamp);
                jSONObject.put("service_thread", this.service.mThreadName);
                jSONObject.put("service_token", this.service.mToken);
            }
        }

        void recycle() {
            this.type = -1;
            this.messageCount = -1;
            this.duration = -1L;
            this.dispatchMsg = null;
            this.blockStack = null;
            this.seriousBlockStack = null;
            this.evilMsg = null;
            this.uuid = null;
            this.frameInfo = null;
            this.service = null;
            this.mLastScheduleMsg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class CheckTimeItemList {
        CheckTimeItem cachedItem;
        final List<CheckTimeItem> checkTimeItems;
        final int poolSize;
        private int position = 0;

        public CheckTimeItemList(int i) {
            this.poolSize = i;
            this.checkTimeItems = new ArrayList(i);
        }

        CheckTimeItem obtainScheduleItem() {
            CheckTimeItem checkTimeItem = this.cachedItem;
            if (checkTimeItem != null) {
                this.cachedItem = null;
                return checkTimeItem;
            }
            return new CheckTimeItem();
        }

        void addItem(CheckTimeItem checkTimeItem) {
            int size = this.checkTimeItems.size();
            int i = this.poolSize;
            if (size < i) {
                this.checkTimeItems.add(checkTimeItem);
                this.position = this.checkTimeItems.size();
                return;
            }
            int i2 = this.position % i;
            this.position = i2;
            CheckTimeItem checkTimeItem2 = this.checkTimeItems.set(i2, checkTimeItem);
            checkTimeItem2.recycle();
            this.cachedItem = checkTimeItem2;
            this.position++;
        }

        CheckTimeItem getCurrentItem() {
            int i = this.position;
            if (i > 0) {
                return this.checkTimeItems.get(i - 1);
            }
            if (i != 0) {
                return null;
            }
            return this.checkTimeItems.get(r0.size() - 1);
        }

        JSONArray dumpItemList() {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            if (this.checkTimeItems.size() == this.poolSize) {
                for (int i2 = this.position - 1; i2 < this.checkTimeItems.size(); i2++) {
                    jSONArray.put(this.checkTimeItems.get(i2).toJson());
                }
                while (i < this.position - 1) {
                    jSONArray.put(this.checkTimeItems.get(i).toJson());
                    i++;
                }
            } else {
                while (i < this.checkTimeItems.size()) {
                    jSONArray.put(this.checkTimeItems.get(i).toJson());
                    i++;
                }
            }
            return jSONArray;
        }

        List<CheckTimeItem> dumpItems() {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            if (this.checkTimeItems.size() == this.poolSize) {
                for (int i2 = this.position - 1; i2 < this.checkTimeItems.size(); i2++) {
                    arrayList.add(this.checkTimeItems.get(i2).copy());
                }
                while (i < this.position - 1) {
                    arrayList.add(this.checkTimeItems.get(i).copy());
                    i++;
                }
            } else {
                while (i < this.checkTimeItems.size()) {
                    arrayList.add(this.checkTimeItems.get(i).copy());
                    i++;
                }
            }
            return arrayList;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class Stack {
        boolean isIn;
        StackTraceElement stackTraceElement;
        long uptime;

        private Stack() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class CheckTimeItem {
        long cost;
        long delay;
        boolean isMessage;
        int seqNum;
        String stacks;
        long startTime;

        private CheckTimeItem() {
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("startTime", this.startTime);
                jSONObject.put("cost", this.cost);
                jSONObject.put("delay", this.delay);
                jSONObject.put("isMessage", String.valueOf(this.isMessage));
                jSONObject.put("seqNum", this.seqNum);
                jSONObject.put(ReportConst.KEY_STACK, this.stacks);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public String toLog() {
            StringBuilder sb = new StringBuilder("startTime:");
            sb.append(this.startTime).append(",cost:").append(this.cost).append(",delay:").append(this.delay).append(",belongMessage:").append(this.isMessage).append(",flag:").append(this.seqNum);
            return sb.toString();
        }

        void recycle() {
            this.startTime = -1L;
            this.cost = -1L;
            this.delay = -1L;
            this.seqNum = -1;
            this.stacks = null;
        }

        CheckTimeItem copy() {
            CheckTimeItem checkTimeItem = new CheckTimeItem();
            checkTimeItem.startTime = this.startTime;
            checkTimeItem.cost = this.cost;
            checkTimeItem.delay = this.delay;
            checkTimeItem.isMessage = this.isMessage;
            checkTimeItem.seqNum = this.seqNum;
            checkTimeItem.stacks = this.stacks;
            return checkTimeItem;
        }
    }

    private static JSONObject toJson(Message message, long j) {
        JSONObject jSONObject = new JSONObject();
        if (message == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("when", message.getWhen() - j);
            if (message.getCallback() != null) {
                jSONObject.put("callback", String.valueOf(message.getCallback()));
            }
            jSONObject.put("what", message.what);
            if (message.getTarget() != null) {
                jSONObject.put("target", String.valueOf(message.getTarget()));
            } else {
                jSONObject.put("barrier", message.arg1);
            }
            jSONObject.put("arg1", message.arg1);
            jSONObject.put("arg2", message.arg2);
            if (message.obj != null) {
                jSONObject.put("obj", String.valueOf(message.obj));
            }
            jSONObject.put(TraeAuthManager.STAGE_START, message.getWhen());
            jSONObject.put(MetricConstant.MONITOR_STAGE_LOAD_TEMPLATE, -1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
