package com.bytedance.lego.init.monitor;

import android.util.Pair;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.ServiceManagerProxy;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* compiled from: IdleTaskMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u001e\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001aJ\u0016\u0010#\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001aJ\u0016\u0010$\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001aJ\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0006\u0010&\u001a\u00020\u0016J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/lego/init/monitor/IdleTaskMonitor;", "", "()V", "ASYNC", "", "MAIN", "MONITOR_DELAY", "TAG", "TASK_END_SUFFIX", "TASK_START_SUFFIX", "applicationStartTime", "", "iApmAgent", "Lcom/bytedance/services/apm/api/IApmAgent;", "getIApmAgent", "()Lcom/bytedance/services/apm/api/IApmAgent;", "iApmAgent$delegate", "Lkotlin/Lazy;", "idleTaskCostTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "addDuration", "", "key", "cosTime", "checkCreateEndTimeValid", "", "getTaskEndTag", "taskId", "isMainThread", "getTaskStartTag", "getTaskTag", "monitorCostTime", "costTime", "uiThread", "monitorTaskEnd", "monitorTaskStart", "preTag", "sendIdleTaskTaskMonitor", "setApplicationStartTime", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IdleTaskMonitor {
    private static final String ASYNC = "Async:";
    private static final String MAIN = "Main:";
    private static final String MONITOR_DELAY = "idle_task_monitor";
    private static final String TAG = "IdleTaskMonitor";
    private static final String TASK_END_SUFFIX = "##TASKEND";
    private static final String TASK_START_SUFFIX = "##TASKSTART";
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IdleTaskMonitor.class), "iApmAgent", "getIApmAgent()Lcom/bytedance/services/apm/api/IApmAgent;"))};
    public static final IdleTaskMonitor INSTANCE = new IdleTaskMonitor();
    private static final CopyOnWriteArrayList<Pair<String, Long>> idleTaskCostTimeList = new CopyOnWriteArrayList<>();

    /* renamed from: iApmAgent$delegate, reason: from kotlin metadata */
    private static final Lazy iApmAgent = LazyKt.lazy(new Function0<IApmAgent>() { // from class: com.bytedance.lego.init.monitor.IdleTaskMonitor$iApmAgent$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IApmAgent m701invoke() {
            return (IApmAgent) ServiceManagerProxy.INSTANCE.getService(IApmAgent.class);
        }
    });
    private static long applicationStartTime = -1;

    private final IApmAgent getIApmAgent() {
        Lazy lazy = iApmAgent;
        KProperty kProperty = $$delegatedProperties[0];
        return (IApmAgent) lazy.getValue();
    }

    private final String preTag(boolean isMainThread) {
        return isMainThread ? "Main:" : "Async:";
    }

    private IdleTaskMonitor() {
    }

    public final void setApplicationStartTime(long applicationStartTime2) {
        applicationStartTime = applicationStartTime2;
    }

    public final void monitorTaskStart(String taskId, boolean uiThread) {
        Intrinsics.checkParameterIsNotNull(taskId, "taskId");
        if (checkCreateEndTimeValid()) {
            addDuration(getTaskStartTag(taskId, uiThread), System.currentTimeMillis() - applicationStartTime);
        }
    }

    public final void monitorTaskEnd(String taskId, boolean uiThread) {
        Intrinsics.checkParameterIsNotNull(taskId, "taskId");
        if (checkCreateEndTimeValid()) {
            addDuration(getTaskEndTag(taskId, uiThread), System.currentTimeMillis() - applicationStartTime);
        }
    }

    public final void monitorCostTime(String taskId, long costTime, boolean uiThread) {
        Intrinsics.checkParameterIsNotNull(taskId, "taskId");
        addDuration(getTaskTag(taskId, uiThread), costTime);
    }

    public final void sendIdleTaskTaskMonitor() {
        if (getIApmAgent() == null) {
            InitLogger.INSTANCE.m88e(TAG, "ServiceManager.getService(IApmAgent::class.java) is null.");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<T> it = idleTaskCostTimeList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str = (String) pair.first;
                Object obj = pair.second;
                Intrinsics.checkExpressionValueIsNotNull(obj, "it.second");
                jSONObject.put(str, ((Number) obj).longValue());
            }
        } catch (Throwable unused) {
        }
        InitLogger.INSTANCE.m86d(TAG, "sendIdleTaskMonitor " + jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("category", InitScheduler.INSTANCE.getINIT_SCHEDULER_CATEGORY$initscheduler_release());
        IApmAgent iApmAgent2 = getIApmAgent();
        if (iApmAgent2 != null) {
            iApmAgent2.monitorEvent(MONITOR_DELAY, jSONObject2, jSONObject, new JSONObject());
        }
        idleTaskCostTimeList.clear();
    }

    private final boolean checkCreateEndTimeValid() {
        return applicationStartTime > 0;
    }

    private final String getTaskStartTag(String taskId, boolean isMainThread) {
        return preTag(isMainThread) + taskId + "##TASKSTART";
    }

    private final String getTaskEndTag(String taskId, boolean isMainThread) {
        return preTag(isMainThread) + taskId + "##TASKEND";
    }

    private final String getTaskTag(String taskId, boolean isMainThread) {
        return preTag(isMainThread) + "Task-" + taskId;
    }

    private final void addDuration(String key, long cosTime) {
        idleTaskCostTimeList.add(new Pair<>(key, Long.valueOf(cosTime)));
    }
}
