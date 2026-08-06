package com.bytedance.apm6.cpu.exception.normal;

import android.os.Looper;
import android.os.Process;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionJudgeHelper;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.CpuLoadCollector;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.cpu.exception.ThreadCpuExceptionUtils;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class NormalThreadDetectState extends BaseCpuExceptionState {
    private static final long DETECT_INTERVAL = 1000;
    private static final int LIMIT_STACK_DEPTH = 40;
    private static final int MAX_JUDGE_TIME = 30000;
    private CpuExceptionConfig config;
    private AsyncTask detectTask;
    private boolean isBackground;
    private List<Double> loadList;
    private long startTime;
    private List<ThreadExceptionItem> threadExceptionCacheList;
    private List<ThreadExceptionItem> threadExceptionReportList;

    public NormalThreadDetectState(CpuExceptionStateMachine cpuExceptionStateMachine) {
        super(cpuExceptionStateMachine);
        this.startTime = 0L;
        this.loadList = new CopyOnWriteArrayList();
        this.threadExceptionReportList = new CopyOnWriteArrayList();
        this.threadExceptionCacheList = new CopyOnWriteArrayList();
        this.detectTask = new AsyncTask(0L, 1000L) { // from class: com.bytedance.apm6.cpu.exception.normal.NormalThreadDetectState.1
            @Override // java.lang.Runnable
            public void run() {
                NormalThreadDetectState.this.judge();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judge() {
        if (CpuExceptionJudgeHelper.isNeedSkipJudge()) {
            reset();
            this.machine.onProcessDetect();
            return;
        }
        boolean judgeProcessLoad = judgeProcessLoad();
        if (System.currentTimeMillis() - this.startTime >= getMaxJudgeInterval()) {
            reactOnFinish();
        } else if (!judgeProcessLoad) {
            cpuExceptionLog("not over process threshold");
            this.threadExceptionCacheList.clear();
        } else {
            collectThreadException();
        }
    }

    private long getMaxJudgeInterval() {
        if (this.config == null) {
            return 30000L;
        }
        return r0.getThreadDetectInterval() * 1000;
    }

    private void collectThreadException() {
        boolean z;
        String dumpNativeStackTrace;
        if (this.threadExceptionCacheList.isEmpty()) {
            ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), this.threadExceptionCacheList);
            cpuExceptionLog("over process threshold, first collect thread info, list size: " + this.threadExceptionCacheList.size());
            return;
        }
        ThreadCpuExceptionUtils.filterThreads(Process.myPid(), this.threadExceptionCacheList, this.config.getMaxThreadCpuRate(), this.config.getMaxThreadCpuRateMap());
        cpuExceptionLog("over process threshold, second collect thread info, list size after filter is: " + this.threadExceptionCacheList.size());
        if (this.threadExceptionCacheList.isEmpty()) {
            return;
        }
        if (this.threadExceptionCacheList.size() > 10) {
            this.threadExceptionCacheList.clear();
            return;
        }
        if (CpuExceptionManager.getInstance().needFetchStack()) {
            ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
            int activeCount = threadGroup.activeCount();
            int i = activeCount + (activeCount / 2);
            Thread[] threadArr = new Thread[i];
            threadGroup.enumerate(threadArr);
            StringBuilder sb = new StringBuilder();
            ListIterator<ThreadExceptionItem> listIterator = this.threadExceptionCacheList.listIterator();
            while (listIterator.hasNext()) {
                ThreadExceptionItem next = listIterator.next();
                if (next != null) {
                    if (next.getThreadId() != Process.myPid()) {
                        for (int i2 = 0; i2 < i; i2++) {
                            Thread thread = threadArr[i2];
                            if (thread == null) {
                                break;
                            }
                            if (next.getThreadName().equals(thread.getName()) || (thread.getName().length() > 15 && next.getThreadName().equals(thread.getName().substring(0, 15)))) {
                                if (thread != Thread.currentThread()) {
                                    assembleStackAndAddToReport(next, thread, sb);
                                }
                                z = true;
                                if (!z && this.config.isCollectNativeThread() && (dumpNativeStackTrace = PerfMonitorManager.getInstance().dumpNativeStackTrace(next.getThreadId())) != null) {
                                    next.setStack(dumpNativeStackTrace);
                                    next.setWeight(String.format("%.2f", Double.valueOf(next.getCpuUsage() / this.config.getMaxThreadCpuRate())));
                                    this.threadExceptionReportList.add(next);
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            next.setStack(dumpNativeStackTrace);
                            next.setWeight(String.format("%.2f", Double.valueOf(next.getCpuUsage() / this.config.getMaxThreadCpuRate())));
                            this.threadExceptionReportList.add(next);
                        }
                    } else if (this.config.isCollectMainThread()) {
                        assembleStackAndAddToReport(next, Looper.getMainLooper().getThread(), sb);
                    }
                }
            }
        } else {
            ListIterator<ThreadExceptionItem> listIterator2 = this.threadExceptionCacheList.listIterator();
            while (listIterator2.hasNext()) {
                ThreadExceptionItem next2 = listIterator2.next();
                if (next2 != null && (next2.getThreadId() != Process.myPid() || this.config.isCollectMainThread())) {
                    next2.setWeight(String.format("%.2f", Double.valueOf(next2.getCpuUsage() / this.config.getMaxThreadCpuRate())));
                    this.threadExceptionReportList.add(next2);
                }
            }
        }
        Collections.sort(this.threadExceptionCacheList, new Comparator<ThreadExceptionItem>() { // from class: com.bytedance.apm6.cpu.exception.normal.NormalThreadDetectState.2
            @Override // java.util.Comparator
            public int compare(ThreadExceptionItem threadExceptionItem, ThreadExceptionItem threadExceptionItem2) {
                return (int) ((threadExceptionItem2.getCpuUsage() * 100.0d) - (threadExceptionItem.getCpuUsage() * 100.0d));
            }
        });
        LinkedList<ICpuDataService.ThreadCpuItem> linkedList = new LinkedList<>();
        for (ThreadExceptionItem threadExceptionItem : this.threadExceptionCacheList) {
            linkedList.add(new ICpuDataService.ThreadCpuItem(threadExceptionItem.getThreadName(), threadExceptionItem.getCpuUsage(), threadExceptionItem.getThreadId()));
        }
        CurrentCpuDataHolder.getInstance().refreshExceptionTopThreadData(linkedList);
        this.threadExceptionCacheList.clear();
    }

    private void assembleStackAndAddToReport(ThreadExceptionItem threadExceptionItem, Thread thread, StringBuilder sb) {
        int i = 0;
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            i++;
            sb.append("\tat ").append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
            if (i > 40) {
                break;
            }
        }
        threadExceptionItem.setStack(sb.toString());
        threadExceptionItem.setWeight(String.format("%.2f", Double.valueOf(threadExceptionItem.getCpuUsage() / this.config.getMaxThreadCpuRate())));
        this.threadExceptionReportList.add(threadExceptionItem);
        sb.setLength(0);
    }

    private void reactOnFinish() {
        String arrayToString;
        if (this.loadList.isEmpty() || this.threadExceptionReportList.isEmpty()) {
            cpuExceptionLog("finish collect, but no exception thread is found");
            reset();
            this.machine.onProcessDetect();
            return;
        }
        Iterator<Double> it = this.loadList.iterator();
        double d = 0.0d;
        double d2 = 0.0d;
        while (it.hasNext()) {
            double doubleValue = it.next().doubleValue();
            if (d2 < doubleValue) {
                d2 = doubleValue;
            }
            d += doubleValue;
        }
        cpuExceptionLog("report exception data, exception thread size is: " + this.threadExceptionReportList.size());
        double size = d / this.loadList.size();
        LinkedList linkedList = new LinkedList();
        String[] split = CpuExceptionJudgeHelper.getCacheScene().split("#");
        String str = null;
        if (this.isBackground) {
            if (!this.config.getBackSceneMaxSpeedMap().isEmpty()) {
                double d3 = 0.0d;
                for (String str2 : split) {
                    if (this.config.getBackSceneMaxSpeedMap().containsKey(str2)) {
                        double doubleValue2 = this.config.getBackSceneMaxSpeedMap().get(str2).doubleValue();
                        if (doubleValue2 >= 0.0d) {
                            if (d3 < doubleValue2) {
                                d3 = doubleValue2;
                                str = str2;
                            }
                            if (size > doubleValue2) {
                                linkedList.add(str2);
                            }
                        }
                    }
                }
                if (str != null && linkedList.contains(str)) {
                    linkedList.remove(str);
                    linkedList.add(0, str);
                }
            }
        } else if (!this.config.getForeSceneMaxSpeedMap().isEmpty()) {
            double d4 = 0.0d;
            for (String str3 : split) {
                if (this.config.getForeSceneMaxSpeedMap().containsKey(str3)) {
                    double doubleValue3 = this.config.getForeSceneMaxSpeedMap().get(str3).doubleValue();
                    if (doubleValue3 >= 0.0d) {
                        if (d4 < doubleValue3) {
                            str = str3;
                            d4 = doubleValue3;
                        }
                        if (size > doubleValue3) {
                            linkedList.add(str3);
                        }
                    }
                }
            }
            if (str != null && linkedList.contains(str)) {
                linkedList.remove(str);
                linkedList.add(0, str);
            }
        }
        if (!linkedList.isEmpty() || ((this.isBackground && size > this.config.getMaxProcessBackCpuSpeed()) || (!this.isBackground && size > this.config.getMaxProcessForeCpuSpeed()))) {
            CpuExceptionManager.getInstance().setLastExceptionTimestamp(System.currentTimeMillis());
            ApmCpuManager.ICpuExceptionListener exceptionListener = CpuExceptionManager.getInstance().getExceptionListener();
            if (exceptionListener != null) {
                exceptionListener.onException(size);
            }
            if (linkedList.isEmpty()) {
                if (!this.isBackground || size <= this.config.getMaxProcessBackCpuSpeed()) {
                    arrayToString = (this.isBackground || size <= this.config.getMaxProcessForeCpuSpeed()) ? "" : CpuNormalExceptionEvent.KEY_MAX_FOREGROUND;
                } else {
                    arrayToString = CpuNormalExceptionEvent.KEY_MAX_BACKGROUND;
                }
            } else {
                arrayToString = ListUtils.arrayToString(linkedList.toArray(), "#");
                if (this.isBackground && size > this.config.getMaxProcessBackCpuSpeed()) {
                    arrayToString = arrayToString + "#apm_max_background";
                } else if (!this.isBackground && size > this.config.getMaxProcessForeCpuSpeed()) {
                    arrayToString = arrayToString + "#apm_max_foreground";
                }
            }
            Monitor.record(new CpuNormalExceptionEvent(size, d2, this.threadExceptionReportList, arrayToString, this.isBackground));
        }
        reset();
        this.machine.onCoolDown();
    }

    private boolean judgeProcessLoad() {
        double collectSpeed = CpuLoadCollector.collectSpeed();
        this.loadList.add(Double.valueOf(collectSpeed));
        return CpuExceptionJudgeHelper.judge(this.config, collectSpeed, this.isBackground);
    }

    private void reset() {
        this.loadList.clear();
        this.threadExceptionReportList.clear();
        this.threadExceptionCacheList.clear();
        this.startTime = 0L;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig cpuExceptionConfig, boolean z) {
        super.onEnterThisState(cpuExceptionConfig, z);
        this.config = cpuExceptionConfig;
        this.startTime = System.currentTimeMillis();
        this.isBackground = z;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        reset();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean z) {
        super.onLifeCycleChange(z);
        reset();
        this.machine.onIdle();
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.THREAD_DETECT;
    }
}
