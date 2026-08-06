package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityHttpResponse;
import com.bytedance.applog.priority.original.Model;
import com.bytedance.applog.server.Api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Worker.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 *2\u00060\u0001j\u0002`\u0002:\u0001*B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0016J1\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00122\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f2\u0006\u0010!\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010 2\u0006\u0010(\u001a\u00020)H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/applog/priority/original/Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "priorityContext", "Lcom/bytedance/applog/priority/original/Model$PriorityContext;", "sourceGroups", "", "Lcom/bytedance/applog/priority/original/Group;", "(Lcom/bytedance/applog/priority/original/Model$PriorityName;Lcom/bytedance/applog/priority/original/Model$PriorityContext;Ljava/util/List;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "groups", "Lcom/bytedance/applog/priority/original/GroupInterface;", "interval", "", "scheduler", "Ljava/util/concurrent/ScheduledFuture;", "createScheduler", "flush", "", "handleMissedGroups", "run", "runGroup", "g", "header", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "runTimeSecs", "(Lcom/bytedance/applog/priority/original/GroupInterface;Lkotlin/Lazy;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setGroups", "startWorkerTimer", "toString", "", "waitHeader", "cnt", "", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Worker implements Runnable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean newThreadEveryGroup;

    /* renamed from: coroutineScope$delegate, reason: from kotlin metadata */
    private final Lazy coroutineScope;
    private List<? extends GroupInterface> groups;
    private long interval;
    private final Model.PriorityContext priorityContext;
    private final Model.PriorityName priorityName;
    private ScheduledFuture<?> scheduler;

    /* compiled from: Worker.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Model.EventType.values().length];
            iArr[Model.EventType.V3.ordinal()] = 1;
            iArr[Model.EventType.V1.ordinal()] = 2;
            iArr[Model.EventType.LogData.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Worker(Model.PriorityName priorityName, Model.PriorityContext priorityContext, List<Group> list) {
        Intrinsics.checkNotNullParameter(priorityName, "priorityName");
        Intrinsics.checkNotNullParameter(priorityContext, "priorityContext");
        Intrinsics.checkNotNullParameter(list, "sourceGroups");
        this.priorityName = priorityName;
        this.priorityContext = priorityContext;
        List<Group> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Group) it.next()).getConfig().getInterval()));
        }
        this.interval = CommonKt.minInterval(CollectionsKt.toList(arrayList));
        this.groups = CollectionsKt.emptyList();
        this.coroutineScope = LazyKt.lazy(new Function0<CoroutineScope>() { // from class: com.bytedance.applog.priority.original.Worker$coroutineScope$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final CoroutineScope invoke() {
                return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()).plus((CoroutineExceptionHandler) new C0470x802a39fb(CoroutineExceptionHandler.Key, Worker.this)));
            }
        });
        setGroups(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) this.coroutineScope.getValue();
    }

    /* compiled from: Worker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applog/priority/original/Worker$Companion;", "", "()V", "newThreadEveryGroup", "", "getNewThreadEveryGroup", "()Z", "setNewThreadEveryGroup", "(Z)V", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getNewThreadEveryGroup() {
            return Worker.newThreadEveryGroup;
        }

        public final void setNewThreadEveryGroup(boolean z) {
            Worker.newThreadEveryGroup = z;
        }
    }

    public final void setGroups(List<Group> sourceGroups) {
        Intrinsics.checkNotNullParameter(sourceGroups, "sourceGroups");
        this.priorityContext.getLogger().info("{} upgrade by {} groups: {}...", this, Integer.valueOf(sourceGroups.size()), sourceGroups);
        Iterator<T> it = this.groups.iterator();
        while (it.hasNext()) {
            ((GroupInterface) it.next()).destroy();
        }
        this.priorityContext.getLogger().info("{} old groups destroyed completed!", this);
        if (newThreadEveryGroup) {
            List<Group> list = sourceGroups;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(new RunnableGroup((Group) it2.next(), this.priorityContext.getLogger(), this.priorityContext.getCallback()));
            }
            this.groups = CollectionsKt.toList(arrayList);
        } else {
            this.groups = sourceGroups;
            startWorkerTimer();
        }
        handleMissedGroups();
        this.priorityContext.getLogger().info("{} upgrade completed!", this);
    }

    public final void flush() {
        this.priorityContext.getLogger().info("{} start flush to run...", this);
        Iterator<T> it = this.groups.iterator();
        while (it.hasNext()) {
            ((GroupInterface) it.next()).flush();
        }
        ScheduledFuture<?> scheduledFuture = this.scheduler;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.scheduler = createScheduler();
    }

    private final void startWorkerTimer() {
        List<? extends GroupInterface> list = this.groups;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((GroupInterface) it.next()).interval()));
        }
        this.interval = CommonKt.minInterval(CollectionsKt.toList(arrayList));
        ScheduledFuture<?> scheduledFuture = this.scheduler;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture2 = this.scheduler;
        if (scheduledFuture2 != null && scheduledFuture2.isCancelled()) {
            this.priorityContext.getLogger().info("{} scheduler stop success!", this);
        }
        if (this.groups.isEmpty()) {
            this.priorityContext.getLogger().err("{} no scheduler for no group!!!", this);
        } else {
            this.scheduler = createScheduler();
        }
    }

    private final ScheduledFuture<?> createScheduler() {
        if (newThreadEveryGroup) {
            return null;
        }
        return Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(this, 0L, this.interval, TimeUnit.SECONDS);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.priorityContext.getLogger().info("================ {} start run ===============", this);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (!this.priorityContext.getCallback().isNetworkAvailable()) {
            this.priorityContext.getLogger().info("{} run with no network, now will skip...", this);
            return;
        }
        LocalLazy localLazy = new LocalLazy(new ValueLoader<JSONObject>() { // from class: com.bytedance.applog.priority.original.Worker$run$header$1
            @Override // com.bytedance.applog.priority.original.ValueLoader
            public JSONObject load() {
                Model.PriorityContext priorityContext;
                Model.PriorityContext priorityContext2;
                Model.PriorityContext priorityContext3;
                Model.PriorityContext priorityContext4;
                Model.PriorityContext priorityContext5;
                priorityContext = Worker.this.priorityContext;
                String headerJson = priorityContext.getCallback().getHeaderJson();
                if (headerJson != null) {
                    if (!(headerJson.length() == 0)) {
                        try {
                            return new JSONObject(headerJson);
                        } catch (Exception e) {
                            priorityContext3 = Worker.this.priorityContext;
                            if (priorityContext3.getCallback().isMonitorEnabled()) {
                                priorityContext5 = Worker.this.priorityContext;
                                priorityContext5.getCallback().monitorError("priority parse header error", e.toString());
                            }
                            priorityContext4 = Worker.this.priorityContext;
                            priorityContext4.getLogger().err("{} header parse error!", this);
                            return null;
                        }
                    }
                }
                priorityContext2 = Worker.this.priorityContext;
                priorityContext2.getLogger().info("{} run blocked by header is not ready!", this);
                return null;
            }
        });
        List<? extends GroupInterface> list = this.groups;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((GroupInterface) obj).isTimeout(currentTimeMillis)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        this.priorityContext.getLogger().info("{} start run {} groups...", this, Integer.valueOf(arrayList2.size()));
        BuildersKt.runBlocking$default((CoroutineContext) null, new Worker$run$1(this, arrayList2, localLazy, currentTimeMillis, null), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runGroup(GroupInterface groupInterface, Lazy<? extends JSONObject> lazy, long j, Continuation<? super Unit> continuation) {
        groupInterface.doWork(lazy, j);
        return Unit.INSTANCE;
    }

    public String toString() {
        return "Worker-" + this.priorityName.name();
    }

    private final void handleMissedGroups() {
        Set<Integer> allGroupIds = this.priorityContext.getDatabasePool().getDb(this.priorityName).getAllGroupIds();
        List<? extends GroupInterface> list = this.groups;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((GroupInterface) it.next()).groupId()));
        }
        Set set = CollectionsKt.toSet(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : allGroupIds) {
            if (true ^ set.contains(Integer.valueOf(((Number) obj).intValue()))) {
                arrayList2.add(obj);
            }
        }
        Set set2 = CollectionsKt.toSet(arrayList2);
        if (set2.isEmpty()) {
            this.priorityContext.getLogger().info("{} no any missed groups.", this);
            return;
        }
        this.priorityContext.getLogger().info("start to handle " + set2.size() + " missed groups...", new Object[0]);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(RangesKt.coerceAtMost(set2.size(), 3));
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            final int intValue = ((Number) it2.next()).intValue();
            final DatabaseInterface db = this.priorityContext.getDatabasePool().getDb(this.priorityName);
            newFixedThreadPool.submit(new Runnable() { // from class: com.bytedance.applog.priority.original.Worker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Worker.m430handleMissedGroups$lambda8(DatabaseInterface.this, intValue, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleMissedGroups$lambda-8, reason: not valid java name */
    public static final void m430handleMissedGroups$lambda8(DatabaseInterface databaseInterface, int i, Worker worker) {
        Intrinsics.checkNotNullParameter(databaseInterface, "$db");
        Intrinsics.checkNotNullParameter(worker, "this$0");
        Pair<HashMap<Model.EventKey, JSONObject>, Boolean> bySizeAndCount = databaseInterface.getBySizeAndCount(i, ModelKt.DEFAULT_MAX_REQUEST_BODY_SIZE, 2000, 604800000L);
        HashMap hashMap = (HashMap) bySizeAndCount.component1();
        boolean booleanValue = ((Boolean) bySizeAndCount.component2()).booleanValue();
        worker.priorityContext.getLogger().info("{} handle missed group: {} with {} events...", worker, Integer.valueOf(i), Integer.valueOf(hashMap.size()));
        if (hashMap.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        HashMap hashMap2 = hashMap;
        for (Map.Entry entry : hashMap2.entrySet()) {
            Model.EventKey eventKey = (Model.EventKey) entry.getKey();
            JSONObject jSONObject = (JSONObject) entry.getValue();
            int i2 = WhenMappings.$EnumSwitchMapping$0[eventKey.getEventType().ordinal()];
            if (i2 == 1) {
                jSONArray.put(jSONObject);
            } else if (i2 == 2) {
                jSONArray2.put(jSONObject);
            } else if (i2 == 3) {
                jSONArray3.put(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("header", worker.waitHeader(10));
        if (jSONArray.length() > 0) {
            jSONObject2.put(Api.KEY_V3, jSONArray);
        }
        if (jSONArray2.length() > 0) {
            jSONObject2.put("event", jSONArray2);
        }
        if (jSONArray3.length() > 0) {
            jSONObject2.put("log_data", jSONArray3);
        }
        worker.priorityContext.getLogger().info("{} post missed group:{} log with {} v3、{} v1、{} log_data...", worker, Integer.valueOf(i), Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()));
        worker.priorityContext.getCallback().monitorIncreaseStats("REPORT_REQUEST_COUNT", 1);
        worker.priorityContext.getCallback().monitorIncreaseStats("REPORT_REQUEST_MISS_GROUP_COUNT", 1);
        String buildPriorityReportUrl = CommonKt.buildPriorityReportUrl(i, worker.priorityContext.getDefaultReportHost(), worker.priorityContext.getDefaultReportPath());
        PriorityCallback callback = worker.priorityContext.getCallback();
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "packJson.toString()");
        byte[] bytes = jSONObject3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        PriorityHttpResponse doHttpPost = callback.doHttpPost(buildPriorityReportUrl, bytes);
        int code = doHttpPost.getCode();
        if (200 <= code && code < 300) {
            worker.priorityContext.getLogger().info("{} missed group: {} upload {} events success and deleted locally, remaining {} events.", worker, Integer.valueOf(i), Integer.valueOf(hashMap.size()), Integer.valueOf(databaseInterface.count(i)));
            Set keySet = hashMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "events.keys");
            databaseInterface.deleteAll(CollectionsKt.toList(keySet));
            CommonKt.stageEvents(worker.priorityContext.getCallback(), "3F", hashMap2, Model.PriorityName.P2, 0);
            worker.priorityContext.getCallback().monitorIncreaseStats("priority_request_success_cnt", 1);
            if (booleanValue) {
                return;
            }
            databaseInterface.destroy();
            return;
        }
        worker.priorityContext.getLogger().err("{} {} upload {} events failed for response is " + doHttpPost + '.', worker, databaseInterface, Integer.valueOf(hashMap.size()));
        CommonKt.stageEvents(worker.priorityContext.getCallback(), "3B", hashMap2, Model.PriorityName.P2, 0);
        worker.priorityContext.getCallback().monitorIncreaseStats("priority_request_failed_cnt", 1);
    }

    private final JSONObject waitHeader(int cnt) {
        String headerJson = this.priorityContext.getCallback().getHeaderJson();
        if (headerJson != null) {
            if (!(headerJson.length() == 0)) {
                return new JSONObject(headerJson);
            }
        }
        if (cnt <= 0) {
            return null;
        }
        Thread.sleep(300L);
        return waitHeader(cnt - 1);
    }
}
