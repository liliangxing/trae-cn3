package com.bytedance.lego.init.monitor;

import android.os.Looper;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.ServiceManagerProxy;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DelayTaskMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010 \u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010(\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010)\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lcom/bytedance/lego/init/monitor/DelayTaskMonitor;", "", "()V", "MONITOR_DELAY", "", "TAG", "TASK_END", "TASK_START", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Pair;", "", "onCreateEnd", "getOnCreateEnd", "()J", "setOnCreateEnd", "(J)V", "addDuration", "", "key", "cosTime", "getMonitorTag", "name", "isMainThread", "", "getTaskEndTag", "taskInfo", "Lcom/bytedance/lego/init/model/DelayTaskInfo;", "getTaskStartTag", "getTaskTag", "monitor", "value", "monitorCosTime", "monitorEvent", "category", "Lcom/bytedance/lego/init/monitor/Category;", "type", "extraLog", "Lorg/json/JSONObject;", "monitorTaskEnd", "monitorTaskStart", "sendDelayTaskMonitor", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DelayTaskMonitor {
    private static final String MONITOR_DELAY = "delay_task_monitor";
    private static final String TAG = "DelayTaskMonitor";
    private static final String TASK_END = "_TASKEND";
    private static final String TASK_START = "_TASKSTART";
    public static final DelayTaskMonitor INSTANCE = new DelayTaskMonitor();
    private static final CopyOnWriteArrayList<Pair<String, Long>> cosTimeList = new CopyOnWriteArrayList<>();
    private static long onCreateEnd = -1;

    private DelayTaskMonitor() {
    }

    public final long getOnCreateEnd() {
        return onCreateEnd;
    }

    public final void setOnCreateEnd(long j) {
        onCreateEnd = j;
    }

    public final void monitorTaskStart(DelayTaskInfo taskInfo, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        if (onCreateEnd < 0) {
            return;
        }
        addDuration(getTaskStartTag(taskInfo, isMainThread), System.currentTimeMillis() - onCreateEnd);
    }

    public final void monitorTaskEnd(DelayTaskInfo taskInfo, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        if (onCreateEnd < 0) {
            return;
        }
        addDuration(getTaskEndTag(taskInfo, isMainThread), System.currentTimeMillis() - onCreateEnd);
    }

    public final void monitorCosTime(DelayTaskInfo taskInfo, long cosTime, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        addDuration(getTaskTag(taskInfo, isMainThread), cosTime);
    }

    public final void monitor(String name, long value, boolean isMainThread) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        addDuration(getMonitorTag(name, isMainThread), value);
    }

    public final void monitorEvent(Category category, String type, JSONObject extraLog) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(extraLog, "extraLog");
        IApmAgent iApmAgent = (IApmAgent) ServiceManagerProxy.INSTANCE.getService(IApmAgent.class);
        if (iApmAgent == null) {
            InitLogger.INSTANCE.m88e(TAG, "ServiceManager.getService(IApmAgent::class.java) is null.");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(category.getValue(), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        extraLog.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        extraLog.put("isUIThread", Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
        iApmAgent.monitorEvent(MONITOR_DELAY, jSONObject, new JSONObject(), extraLog);
        InitLogger.d$default(InitLogger.INSTANCE, null, category.name() + ' ' + type + ' ' + extraLog.toString(), 1, null);
    }

    public final void sendDelayTaskMonitor() {
        IApmAgent iApmAgent = (IApmAgent) ServiceManagerProxy.INSTANCE.getService(IApmAgent.class);
        if (iApmAgent == null) {
            InitLogger.INSTANCE.m88e(TAG, "ServiceManager.getService(IApmAgent::class.java) is null.");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<T> it = cosTimeList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                jSONObject.put((String) pair.getFirst(), ((Number) pair.getSecond()).longValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        InitLogger.INSTANCE.m86d(TAG, "sendDelayTaskMonitor " + jSONObject);
        iApmAgent.monitorEvent(MONITOR_DELAY, new JSONObject(), jSONObject, new JSONObject());
        cosTimeList.clear();
    }

    private final String getMonitorTag(String name, boolean isMainThread) {
        if (isMainThread) {
            return InitMonitor.MAIN + name;
        }
        return InitMonitor.ASYNC + name;
    }

    private final String getTaskTag(DelayTaskInfo taskInfo, boolean isMainThread) {
        if (isMainThread) {
            return "Main:Task-" + taskInfo.taskId;
        }
        return "Async:Task-" + taskInfo.taskId;
    }

    private final String getTaskStartTag(DelayTaskInfo taskInfo, boolean isMainThread) {
        if (isMainThread) {
            return InitMonitor.MAIN + taskInfo.taskId + TASK_START;
        }
        return InitMonitor.ASYNC + taskInfo.taskId + TASK_START;
    }

    private final String getTaskEndTag(DelayTaskInfo taskInfo, boolean isMainThread) {
        if (isMainThread) {
            return InitMonitor.MAIN + taskInfo.taskId + TASK_END;
        }
        return InitMonitor.ASYNC + taskInfo.taskId + TASK_END;
    }

    private final void addDuration(String key, long cosTime) {
        cosTimeList.add(new Pair<>(key, Long.valueOf(cosTime)));
    }
}
