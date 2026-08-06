package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.Logger;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.original.Model;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* compiled from: Group.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J \u0010\u001b\u001a\u00020\u00192\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\"\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020#H\u0016J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020 H\u0016J\"\u00100\u001a\u00020.2\u0006\u0010'\u001a\u00020(2\u0006\u00101\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u00020*H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00066"}, d2 = {"Lcom/bytedance/applog/priority/original/RunnableGroup;", "Lcom/bytedance/applog/priority/original/GroupInterface;", "Ljava/lang/Runnable;", "group", "Lcom/bytedance/applog/priority/original/Group;", "logger", "Lcom/bytedance/applog/priority/Logger;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/applog/priority/PriorityCallback;", "(Lcom/bytedance/applog/priority/original/Group;Lcom/bytedance/applog/priority/Logger;Lcom/bytedance/applog/priority/PriorityCallback;)V", "getCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "executors", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutors", "()Ljava/util/concurrent/ScheduledExecutorService;", "getGroup", "()Lcom/bytedance/applog/priority/original/Group;", "getLogger", "()Lcom/bytedance/applog/priority/Logger;", "timer", "Ljava/util/concurrent/ScheduledFuture;", "getTimer", "()Ljava/util/concurrent/ScheduledFuture;", "clear", "", "destroy", "doWork", "header", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "runTimeSecs", "", "flush", "getEventCount", "", "groupId", "insertEvent", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "eventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "eventName", "", "json", "interval", "isEmpty", "", "isTimeout", "match", "event", "paramJson", "minInterval", "run", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RunnableGroup implements GroupInterface, Runnable {
    private final PriorityCallback callback;
    private final ScheduledExecutorService executors;
    private final Group group;
    private final Logger logger;
    private final ScheduledFuture<?> timer;

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public boolean isTimeout(long runTimeSecs) {
        return false;
    }

    public RunnableGroup(Group group, Logger logger, PriorityCallback priorityCallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(priorityCallback, JsCallParser.VALUE_CALLBACK);
        this.group = group;
        this.logger = logger;
        this.callback = priorityCallback;
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        this.executors = newSingleThreadScheduledExecutor;
        ScheduledFuture<?> scheduleWithFixedDelay = newSingleThreadScheduledExecutor.scheduleWithFixedDelay(this, 0L, minInterval(), TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(scheduleWithFixedDelay, "executors.scheduleWithFi…), TimeUnit.SECONDS\n    )");
        this.timer = scheduleWithFixedDelay;
    }

    public final PriorityCallback getCallback() {
        return this.callback;
    }

    public final Group getGroup() {
        return this.group;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final ScheduledExecutorService getExecutors() {
        return this.executors;
    }

    public final ScheduledFuture<?> getTimer() {
        return this.timer;
    }

    private final long minInterval() {
        return RangesKt.coerceAtLeast(1L, this.group.getConfig().getInterval());
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public int interval() {
        return this.group.interval();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public int groupId() {
        return this.group.groupId();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public boolean isEmpty() {
        return this.group.isEmpty();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public Model.EventKey insertEvent(Model.EventType eventType, String eventName, JSONObject json) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(json, "json");
        return this.group.insertEvent(eventType, eventName, json);
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public int getEventCount() {
        return this.group.getEventCount();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public void clear() {
        this.group.clear();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public boolean match(Model.EventType eventType, String event, JSONObject paramJson) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(event, "event");
        return this.group.match(eventType, event, paramJson);
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public void doWork(Lazy<? extends JSONObject> header, long runTimeSecs) {
        Intrinsics.checkNotNullParameter(header, "header");
        this.group.doWork(header, runTimeSecs);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.logger.info("================ {} start run ===============", this);
        if (!this.callback.isNetworkAvailable()) {
            this.logger.info("{} run with no network, now will skip...", this);
        } else {
            doWork(new LocalLazy(new ValueLoader<JSONObject>() { // from class: com.bytedance.applog.priority.original.RunnableGroup$run$header$1
                @Override // com.bytedance.applog.priority.original.ValueLoader
                public JSONObject load() {
                    String headerJson = RunnableGroup.this.getCallback().getHeaderJson();
                    if (headerJson != null) {
                        if (!(headerJson.length() == 0)) {
                            try {
                                return new JSONObject(headerJson);
                            } catch (Exception e) {
                                if (RunnableGroup.this.getCallback().isMonitorEnabled()) {
                                    RunnableGroup.this.getCallback().monitorError("priority parse header error", e.toString());
                                }
                                RunnableGroup.this.getLogger().err("{} header parse error!", this);
                                return null;
                            }
                        }
                    }
                    RunnableGroup.this.getLogger().info("{} run blocked by header is not ready!", this);
                    return null;
                }
            }), System.currentTimeMillis());
        }
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public void destroy() {
        this.timer.cancel(true);
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public void flush() {
        this.group.flush();
        this.executors.submit(new Runnable() { // from class: com.bytedance.applog.priority.original.RunnableGroup$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RunnableGroup.m429flush$lambda0(RunnableGroup.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: flush$lambda-0, reason: not valid java name */
    public static final void m429flush$lambda0(RunnableGroup runnableGroup) {
        Intrinsics.checkNotNullParameter(runnableGroup, "this$0");
        runnableGroup.run();
    }

    public String toString() {
        return "RunnableGroup(" + this.group + ')';
    }
}
