package com.bytedance.lego.init.monitor;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.InitTaskDispatcher;
import com.bytedance.lego.init.ServiceManagerProxy;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.model.PeriodTaskInfo;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.platform.thread.Constants;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.ILaunchTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* compiled from: InitMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0014H\u0002J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u00101\u001a\u00020\u00042\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u000e\u00102\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0004J\u001e\u00103\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020/2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000fJ\u001e\u00103\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000fJ\u001e\u00103\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000fJ\u0016\u00104\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fJ\u001e\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020:J\u0016\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020:J\u0016\u0010?\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fJ\u0016\u0010@\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fJ\u0016\u0010A\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fJ\b\u0010B\u001a\u00020\u000fH\u0002J\u0006\u0010C\u001a\u00020\u001fJ\u000e\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0004J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020\u0014H\u0002J\b\u0010J\u001a\u00020\u001fH\u0002J\u0006\u0010K\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/bytedance/lego/init/monitor/InitMonitor;", "", "()V", "ALL_FEED_FIRST_SHOWN", "", "ASYNC", "INIT_SCHEDULER", "MAIN", "MONITOR_INIT", "MONITOR_INIT_EXCEPTION", "TASKDISPATCHER_INIT", "TASK_END_SUFFIX", "TASK_START_SUFFIX", "WAIT_ASYNC_TASK_INIT", "alreadyFeedShown", "", "alreadyUpload", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "", "launchTraceService", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "getLaunchTraceService", "()Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService$delegate", "Lkotlin/Lazy;", "onAttachBaseTime", "timeoutTaskList", "", "addDuration", "", "key", "cosTime", "ensureNotReachHere", "t", "", "msg", "getMonitorEndTag", "name", "isMainThread", "getMonitorStartTag", "getMonitorTag", "getPeriodTaskTag", "taskInfo", "Lcom/bytedance/lego/init/model/PeriodTaskInfo;", "getTaskEndTag", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "getTaskStartTag", "getTaskTag", "monitor", "monitorCosTime", "monitorEnd", "monitorEvent", "category", "Lcom/bytedance/lego/init/monitor/Category;", "type", "extraLog", "Lorg/json/JSONObject;", "monitorLog", "logType", "Lcom/bytedance/lego/init/monitor/LogType;", "logExtr", "monitorStart", "monitorTaskEnd", "monitorTaskStart", "monitorTaskTimeout", "onAttachBase", "onFeedFirstShown", "needUploadTask", "onTaskTimeout", "taskId", "sendStartUpTimeAsync", "delay", "sendStartUpTimeAsyncInternal", "sendStartUpTimeImmediately", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitMonitor {
    public static final String ASYNC = "Async:";
    public static final String MAIN = "Main:";
    private static final String MONITOR_INIT = "init_task_monitor";
    private static final String MONITOR_INIT_EXCEPTION = "init_task_exception_monitor";
    public static final String TASKDISPATCHER_INIT = "InitTaskDispatcher.init";
    public static final String TASK_END_SUFFIX = "##TASKEND";
    public static final String TASK_START_SUFFIX = "##TASKSTART";
    public static final String WAIT_ASYNC_TASK_INIT = "wait_async_task_init";
    private static volatile boolean alreadyFeedShown;
    private static volatile boolean alreadyUpload;
    private static long onAttachBaseTime;
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitMonitor.class), "launchTraceService", "getLaunchTraceService()Lcom/bytedance/services/apm/api/ILaunchTrace;"))};
    public static final InitMonitor INSTANCE = new InitMonitor();
    private static final CopyOnWriteArrayList<Pair<String, Long>> cosTimeList = new CopyOnWriteArrayList<>();
    private static final List<String> timeoutTaskList = new ArrayList();

    /* renamed from: launchTraceService$delegate, reason: from kotlin metadata */
    private static final Lazy launchTraceService = LazyKt.lazy(new Function0<ILaunchTrace>() { // from class: com.bytedance.lego.init.monitor.InitMonitor$launchTraceService$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ILaunchTrace m702invoke() {
            return (ILaunchTrace) ServiceManagerProxy.INSTANCE.getService(ILaunchTrace.class);
        }
    });
    private static final String ALL_FEED_FIRST_SHOWN = ALL_FEED_FIRST_SHOWN;
    private static final String ALL_FEED_FIRST_SHOWN = ALL_FEED_FIRST_SHOWN;
    private static final String INIT_SCHEDULER = INIT_SCHEDULER;
    private static final String INIT_SCHEDULER = INIT_SCHEDULER;

    private final ILaunchTrace getLaunchTraceService() {
        Lazy lazy = launchTraceService;
        KProperty kProperty = $$delegatedProperties[0];
        return (ILaunchTrace) lazy.getValue();
    }

    private InitMonitor() {
    }

    public final void onAttachBase() {
        onAttachBaseTime = System.currentTimeMillis();
        FeedShowTaskMonitor.INSTANCE.onAttachBase();
        ILaunchTrace launchTraceService2 = getLaunchTraceService();
        if (launchTraceService2 != null) {
            launchTraceService2.startTrace();
        }
    }

    public final void monitorCosTime(InitTaskInfo taskInfo, long cosTime, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        addDuration(getTaskTag(taskInfo, isMainThread), cosTime);
    }

    public final void monitorCosTime(PeriodTaskInfo taskInfo, long cosTime, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        addDuration(getPeriodTaskTag(taskInfo, isMainThread), cosTime);
    }

    public final void monitorCosTime(String name, long cosTime, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        addDuration(getMonitorTag(name, isMainThread), cosTime);
    }

    public final void monitorTaskStart(InitTaskInfo taskInfo, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        addDuration(getTaskStartTag(taskInfo, isMainThread), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace launchTraceService2 = getLaunchTraceService();
        if (launchTraceService2 != null) {
            launchTraceService2.startSpan(taskInfo.moduleName, taskInfo.taskId);
        }
    }

    public final void monitorTaskEnd(InitTaskInfo taskInfo, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        addDuration(getTaskEndTag(taskInfo, isMainThread), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace launchTraceService2 = getLaunchTraceService();
        if (launchTraceService2 != null) {
            launchTraceService2.endSpan(taskInfo.moduleName, taskInfo.taskId);
        }
    }

    public final void monitorStart(String name, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        addDuration(getMonitorStartTag(name, isMainThread), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace launchTraceService2 = getLaunchTraceService();
        if (launchTraceService2 != null) {
            launchTraceService2.startSpan(INIT_SCHEDULER, name);
        }
    }

    public final void monitorEnd(String name, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        addDuration(getMonitorEndTag(name, isMainThread), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace launchTraceService2 = getLaunchTraceService();
        if (launchTraceService2 != null) {
            launchTraceService2.endSpan(INIT_SCHEDULER, name);
        }
    }

    public final void monitor(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        addDuration(name, System.currentTimeMillis() - onAttachBaseTime);
    }

    private final synchronized void addDuration(String key, long cosTime) {
        if (alreadyFeedShown) {
            return;
        }
        cosTimeList.add(new Pair<>(key, Long.valueOf(cosTime)));
    }

    private final String getTaskTag(InitTaskInfo taskInfo, boolean isMainThread) {
        if (isMainThread) {
            return "Main:Task-" + taskInfo.taskId;
        }
        return "Async:Task-" + taskInfo.taskId;
    }

    private final String getPeriodTaskTag(PeriodTaskInfo taskInfo, boolean isMainThread) {
        if (isMainThread) {
            return MAIN + taskInfo.getTaskId();
        }
        return ASYNC + taskInfo.getTaskId();
    }

    private final String getMonitorTag(String name, boolean isMainThread) {
        if (isMainThread) {
            return MAIN + name;
        }
        return ASYNC + name;
    }

    private final String getTaskStartTag(InitTaskInfo taskInfo, boolean isMainThread) {
        if (isMainThread) {
            return MAIN + taskInfo.taskId + TASK_START_SUFFIX;
        }
        return ASYNC + taskInfo.taskId + TASK_START_SUFFIX;
    }

    private final String getTaskEndTag(InitTaskInfo taskInfo, boolean isMainThread) {
        if (isMainThread) {
            return MAIN + taskInfo.taskId + TASK_END_SUFFIX;
        }
        return ASYNC + taskInfo.taskId + TASK_END_SUFFIX;
    }

    private final String getMonitorStartTag(String name, boolean isMainThread) {
        if (isMainThread) {
            return MAIN + name + TASK_START_SUFFIX;
        }
        return ASYNC + name + TASK_START_SUFFIX;
    }

    private final String getMonitorEndTag(String name, boolean isMainThread) {
        if (isMainThread) {
            return MAIN + name + TASK_END_SUFFIX;
        }
        return ASYNC + name + TASK_END_SUFFIX;
    }

    public final void onFeedFirstShown(boolean needUploadTask) {
        Class<?> cls;
        try {
            long currentTimeMillis = System.currentTimeMillis() - onAttachBaseTime;
            boolean monitorTaskTimeout = currentTimeMillis <= ((long) 30000) ? monitorTaskTimeout() : false;
            if (!needUploadTask) {
                ILaunchTrace launchTraceService2 = getLaunchTraceService();
                if (launchTraceService2 != null) {
                    launchTraceService2.cancelTrace();
                }
                cosTimeList.clear();
                return;
            }
            ILaunchTrace launchTraceService3 = getLaunchTraceService();
            if (launchTraceService3 != null) {
                Activity mainActivity$initscheduler_release = InitScheduler.getMainActivity$initscheduler_release();
                launchTraceService3.endTrace(2, (mainActivity$initscheduler_release == null || (cls = mainActivity$initscheduler_release.getClass()) == null) ? null : cls.getName(), 20000L);
            }
            addDuration(ALL_FEED_FIRST_SHOWN, currentTimeMillis);
            InitLogger.d$default(InitLogger.INSTANCE, null, "onFeedFirstShown: cos " + currentTimeMillis + " ms.", 1, null);
            if (monitorTaskTimeout) {
                return;
            }
            sendStartUpTimeAsync(Constants.TASK_RUN_THRESHOLD);
        } catch (Exception e) {
            Throwable th = e;
            ensureNotReachHere(th, "ON_FEED_FIRST_SHOW_EXCEPTION");
            Category category = Category.OTHER_EXCEPTION;
            String name = e.getClass().getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "e.javaClass.name");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("exception_detail", Log.getStackTraceString(th));
            jSONObject.put("exception_detail", jSONObject2);
            monitorEvent(category, name, jSONObject);
        }
    }

    public final void monitorEvent(Category category, String type, JSONObject extraLog) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(extraLog, "extraLog");
        IApmAgent iApmAgent = (IApmAgent) ServiceManagerProxy.INSTANCE.getService(IApmAgent.class);
        if (iApmAgent != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(category.getValue(), type);
            } catch (Exception e) {
                e.printStackTrace();
            }
            extraLog.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
            extraLog.put("isUIThread", Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
            iApmAgent.monitorEvent(MONITOR_INIT, jSONObject, new JSONObject(), extraLog);
            InitLogger.d$default(InitLogger.INSTANCE, null, category.name() + ' ' + type + ' ' + extraLog.toString(), 1, null);
        }
    }

    public final void onTaskTimeout(String taskId) {
        Intrinsics.checkParameterIsNotNull(taskId, "taskId");
        try {
            timeoutTaskList.add(taskId);
        } catch (Exception e) {
            e.printStackTrace();
            InitLogger initLogger = InitLogger.INSTANCE;
            String stackTraceString = Log.getStackTraceString(e);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            InitLogger.e$default(initLogger, null, stackTraceString, 1, null);
        }
    }

    private final boolean monitorTaskTimeout() {
        try {
            List<String> list = timeoutTaskList;
            if (list.isEmpty()) {
                return false;
            }
            for (String str : list) {
                INSTANCE.monitorEvent(Category.TASK_TIMEOUT_EXCEPTION_REAL, InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout() + ':' + str, new JSONObject());
                InitLogger.d$default(InitLogger.INSTANCE, null, "TaskTimeout: " + str + ", " + InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout(), 1, null);
            }
            sendStartUpTimeAsyncInternal();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            InitLogger initLogger = InitLogger.INSTANCE;
            String stackTraceString = Log.getStackTraceString(e);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            InitLogger.e$default(initLogger, null, stackTraceString, 1, null);
            return false;
        }
    }

    public final void ensureNotReachHere(Throwable t, String msg) {
        Intrinsics.checkParameterIsNotNull(t, "t");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        IEnsure iEnsure = (IEnsure) ServiceManagerProxy.INSTANCE.getService(IEnsure.class);
        if (iEnsure != null) {
            iEnsure.ensureNotReachHere(t, msg);
        }
        IApmAgent iApmAgent = (IApmAgent) ServiceManagerProxy.INSTANCE.getService(IApmAgent.class);
        if (iApmAgent != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("EnsureNotReachHere", msg);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("detail", Log.getStackTraceString(t));
            iApmAgent.monitorEvent(MONITOR_INIT_EXCEPTION, jSONObject, jSONObject2, jSONObject3);
        }
    }

    public final void monitorLog(LogType logType, JSONObject logExtr) {
        Intrinsics.checkParameterIsNotNull(logType, "logType");
        Intrinsics.checkParameterIsNotNull(logExtr, "logExtr");
        IApmAgent iApmAgent = (IApmAgent) ServiceManagerProxy.INSTANCE.getService(IApmAgent.class);
        if (iApmAgent != null) {
            iApmAgent.monitorLog(logType.name(), logExtr);
            InitLogger.d$default(InitLogger.INSTANCE, null, logType.name() + " " + logExtr.toString(), 1, null);
        }
    }

    public final void ensureNotReachHere(Throwable t) {
        Intrinsics.checkParameterIsNotNull(t, "t");
        IEnsure iEnsure = (IEnsure) ServiceManagerProxy.INSTANCE.getService(IEnsure.class);
        if (iEnsure != null) {
            iEnsure.ensureNotReachHere(t);
        }
    }

    private final void sendStartUpTimeAsync(long delay) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.lego.init.monitor.InitMonitor$sendStartUpTimeAsync$1
            @Override // java.lang.Runnable
            public final void run() {
                InitMonitor$sendStartUpTimeAsync$1$runnable$1 initMonitor$sendStartUpTimeAsync$1$runnable$1 = new Runnable() { // from class: com.bytedance.lego.init.monitor.InitMonitor$sendStartUpTimeAsync$1$runnable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            InitMonitor.INSTANCE.sendStartUpTimeAsyncInternal();
                        } catch (Exception e) {
                            InitMonitor initMonitor = InitMonitor.INSTANCE;
                            Category category = Category.OTHER_EXCEPTION;
                            String name = e.getClass().getName();
                            Intrinsics.checkExpressionValueIsNotNull(name, "e.javaClass.name");
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("exception_detail", Log.getStackTraceString(e));
                            jSONObject.put("exception_detail", jSONObject2);
                            initMonitor.monitorEvent(category, name, jSONObject);
                        }
                    }
                };
                ThreadPoolExecutor executorServiceOrNull$initscheduler_release = InitScheduler.INSTANCE.getExecutorServiceOrNull$initscheduler_release();
                if (executorServiceOrNull$initscheduler_release == null || executorServiceOrNull$initscheduler_release.submit(initMonitor$sendStartUpTimeAsync$1$runnable$1) == null) {
                    InitMonitor initMonitor = InitMonitor.INSTANCE;
                    new Thread(initMonitor$sendStartUpTimeAsync$1$runnable$1).start();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }, delay);
    }

    public final synchronized void sendStartUpTimeImmediately() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("curTime", System.currentTimeMillis() - onAttachBaseTime);
            Iterator<T> it = cosTimeList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str = (String) pair.first;
                Object obj = pair.second;
                Intrinsics.checkExpressionValueIsNotNull(obj, "it.second");
                jSONObject.put(str, ((Number) obj).longValue());
            }
            InitLogger initLogger = InitLogger.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "metric.toString()");
            initLogger.m86d("sendStartUpTimeImmediately", jSONObject2);
            IApmAgent iApmAgent = (IApmAgent) ServiceManagerProxy.INSTANCE.getService(IApmAgent.class);
            if (iApmAgent != null) {
                iApmAgent.monitorEvent(MONITOR_INIT, new JSONObject(), jSONObject, new JSONObject());
            }
        } catch (Exception e) {
            InitLogger initLogger2 = InitLogger.INSTANCE;
            String stackTraceString = Log.getStackTraceString(e);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            InitLogger.d$default(initLogger2, null, stackTraceString, 1, null);
            Category category = Category.OTHER_EXCEPTION;
            String str2 = "sendStartUpTimeImmediately" + e.getClass().getName();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("exception_detail", Log.getStackTraceString(e));
            jSONObject3.put("exception_detail", jSONObject4);
            monitorEvent(category, str2, jSONObject3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void sendStartUpTimeAsyncInternal() {
        if (alreadyUpload) {
            return;
        }
        alreadyUpload = true;
        IApmAgent iApmAgent = (IApmAgent) ServiceManagerProxy.INSTANCE.getService(IApmAgent.class);
        if (iApmAgent != null) {
            alreadyFeedShown = true;
            JSONObject jSONObject = new JSONObject();
            try {
                Iterator<T> it = cosTimeList.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    String str = (String) pair.first;
                    Object obj = pair.second;
                    Intrinsics.checkExpressionValueIsNotNull(obj, "it.second");
                    jSONObject.put(str, ((Number) obj).longValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            InitLogger initLogger = InitLogger.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "metric.toString()");
            initLogger.m86d("sendStartUpTimeAsync", jSONObject2);
            InitTaskDispatcher.INSTANCE.beforeSendMonitor();
            iApmAgent.monitorEvent(MONITOR_INIT, new JSONObject(), jSONObject, new JSONObject());
            cosTimeList.clear();
        }
    }
}
