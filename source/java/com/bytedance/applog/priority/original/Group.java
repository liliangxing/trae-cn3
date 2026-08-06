package com.bytedance.applog.priority.original;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.applog.forward.EventForwardLoader;
import com.bytedance.applog.priority.Logger;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityConst;
import com.bytedance.applog.priority.PriorityHttpResponse;
import com.bytedance.applog.priority.original.Model;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Group.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0014\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\b\u0010#\u001a\u00020\u001eH\u0016J \u0010$\u001a\u00020\u001e2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&2\u0006\u0010(\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020+H\u0016J6\u0010,\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020'0.\u0012\u0004\u0012\u00020/0-2\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\u0014J\b\u00103\u001a\u00020+H\u0016J$\u00104\u001a\u00020/2\u0006\u00105\u001a\u0002062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020'0.H\u0002J\"\u00108\u001a\u0004\u0018\u00010\"2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020'H\u0016J\b\u0010>\u001a\u00020+H\u0016J\b\u0010?\u001a\u00020/H\u0016J\u0010\u0010@\u001a\u00020/2\u0006\u0010(\u001a\u00020\u0014H\u0016J\u001e\u0010A\u001a\u00020/2\u0006\u0010=\u001a\u00020'2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020<0CH\u0002J4\u0010D\u001a\u00020/2\u0006\u0010=\u001a\u00020'2\"\u0010E\u001a\u001e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0Fj\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<`GH\u0002J\"\u0010H\u001a\u00020/2\u0006\u00109\u001a\u00020:2\u0006\u0010I\u001a\u00020<2\b\u0010J\u001a\u0004\u0018\u00010'H\u0016J\u000e\u0010K\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0014J\b\u0010L\u001a\u00020<H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b\u001b\u0010\u001c¨\u0006M"}, d2 = {"Lcom/bytedance/applog/priority/original/Group;", "Lcom/bytedance/applog/priority/original/GroupInterface;", "databasePool", "Lcom/bytedance/applog/priority/original/DatabasePool;", "config", "Lcom/bytedance/applog/priority/original/Model$GroupConfig;", "logger", "Lcom/bytedance/applog/priority/Logger;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/applog/priority/PriorityCallback;", "(Lcom/bytedance/applog/priority/original/DatabasePool;Lcom/bytedance/applog/priority/original/Model$GroupConfig;Lcom/bytedance/applog/priority/Logger;Lcom/bytedance/applog/priority/PriorityCallback;)V", "getCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "getConfig", "()Lcom/bytedance/applog/priority/original/Model$GroupConfig;", "db", "Lcom/bytedance/applog/priority/original/DatabaseInterface;", "getLogger", "()Lcom/bytedance/applog/priority/Logger;", "nextReportTimeSec", "", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getRunning", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "workable", "getWorkable", "setWorkable", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "clear", "", "deleteEvents", "keys", "", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "destroy", "doWork", "header", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "runTimeSecs", "flush", "getEventCount", "", "getEventsBySizeAndCount", "Lkotlin/Pair;", "", "", "maxSize", "maxCount", "eventTtl", "groupId", "handleLogResponse", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/applog/priority/PriorityHttpResponse;", EventForwardLoader.KEY_EVENT_FORWARD_EVENTS, "insertEvent", "eventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "eventName", "", "json", "interval", "isEmpty", "isTimeout", "jsonContainsArray", "arr", "", "jsonContainsKvs", "kvs", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "match", "event", "paramJson", "setRunTime", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Group implements GroupInterface {
    private final PriorityCallback callback;
    private final Model.GroupConfig config;
    private final DatabaseInterface db;
    private final Logger logger;
    private long nextReportTimeSec;
    private final AtomicBoolean running;
    private AtomicBoolean workable;

    /* compiled from: Group.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Model.EventType.values().length];
            iArr[Model.EventType.V3.ordinal()] = 1;
            iArr[Model.EventType.V1.ordinal()] = 2;
            iArr[Model.EventType.LogData.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Model.GroupFrequencyAllow.values().length];
            iArr2[Model.GroupFrequencyAllow.Allow.ordinal()] = 1;
            iArr2[Model.GroupFrequencyAllow.BlockByBackoff.ordinal()] = 2;
            iArr2[Model.GroupFrequencyAllow.BlockByFrequency.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public Group(DatabasePool databasePool, Model.GroupConfig groupConfig, Logger logger, PriorityCallback priorityCallback) {
        Intrinsics.checkNotNullParameter(databasePool, "databasePool");
        Intrinsics.checkNotNullParameter(groupConfig, "config");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(priorityCallback, JsCallParser.VALUE_CALLBACK);
        this.config = groupConfig;
        this.logger = logger;
        this.callback = priorityCallback;
        this.db = databasePool.getDb(groupConfig.getPriority().getPriorityName());
        this.workable = new AtomicBoolean(true);
        this.running = new AtomicBoolean(false);
    }

    public final Model.GroupConfig getConfig() {
        return this.config;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final PriorityCallback getCallback() {
        return this.callback;
    }

    public final AtomicBoolean getWorkable() {
        return this.workable;
    }

    public final void setWorkable(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.workable = atomicBoolean;
    }

    public final AtomicBoolean getRunning() {
        return this.running;
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public int interval() {
        return this.config.getInterval();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public int groupId() {
        return this.config.getId();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public boolean isTimeout(long runTimeSecs) {
        if (this.workable.get()) {
            return this.config.getInterval() <= 0 || this.nextReportTimeSec <= runTimeSecs;
        }
        return false;
    }

    public final void setRunTime(long runTimeSecs) {
        this.nextReportTimeSec = runTimeSecs + this.config.getInterval();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public boolean isEmpty() {
        return this.db.isEmpty(this.config.getId());
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public Model.EventKey insertEvent(Model.EventType eventType, String eventName, JSONObject json) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(json, "json");
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        int utf8StringSize = CommonKt.getUtf8StringSize(jSONObject);
        if (this.config.getPriority().getMaxEventSize() < utf8StringSize) {
            int i = WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()];
            if (i == 1) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("params_cleared_by_event_size_limit", utf8StringSize);
                jSONObject2.put("max_event_size", this.config.getPriority().getMaxEventSize());
                json.put("params", jSONObject2);
            } else if (i == 2) {
                final Set of = SetsKt.setOf(new String[]{Api.COL_TAG, Api.COL_LABEL, SqliteDatabaseKt.colMonitorId, "event_stained"});
                Iterator<String> keys = json.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
                Iterator it = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(keys), new Function1<String, Boolean>() { // from class: com.bytedance.applog.priority.original.Group$insertEvent$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Boolean invoke(String str) {
                        return Boolean.valueOf(of.contains(str));
                    }
                })).iterator();
                while (it.hasNext()) {
                    json.remove((String) it.next());
                }
                json.put("params_cleared_by_event_size_limit", utf8StringSize);
                json.put("max_event_size", this.config.getPriority().getMaxEventSize());
            } else if (i == 3) {
                final Set of2 = SetsKt.setOf(new String[]{"log_type", SqliteDatabaseKt.colMonitorId, "event_stained"});
                Iterator<String> keys2 = json.keys();
                Intrinsics.checkNotNullExpressionValue(keys2, "json.keys()");
                Iterator it2 = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(keys2), new Function1<String, Boolean>() { // from class: com.bytedance.applog.priority.original.Group$insertEvent$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Boolean invoke(String str) {
                        return Boolean.valueOf(of2.contains(str));
                    }
                })).iterator();
                while (it2.hasNext()) {
                    json.remove((String) it2.next());
                }
                json.put("params_cleared_by_event_size_limit", utf8StringSize);
                json.put("max_event_size", this.config.getPriority().getMaxEventSize());
            } else {
                final Set of3 = SetsKt.setOf(new String[]{SqliteDatabaseKt.colMonitorId, "event_stained"});
                Iterator<String> keys3 = json.keys();
                Intrinsics.checkNotNullExpressionValue(keys3, "json.keys()");
                Iterator it3 = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(keys3), new Function1<String, Boolean>() { // from class: com.bytedance.applog.priority.original.Group$insertEvent$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Boolean invoke(String str) {
                        return Boolean.valueOf(of3.contains(str));
                    }
                })).iterator();
                while (it3.hasNext()) {
                    json.remove((String) it3.next());
                }
                json.put("params_cleared_by_event_size_limit", utf8StringSize);
                json.put("max_event_size", this.config.getPriority().getMaxEventSize());
            }
            jSONObject = json.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        }
        int id = this.config.getId();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = json.optInt("event_stained") > 0;
        String optString = json.optString(SqliteDatabaseKt.colMonitorId);
        if (optString == null) {
            optString = "";
        }
        return this.db.insert(new Model.EventKey(-1L, id, currentTimeMillis, eventType, z, optString, eventName), jSONObject);
    }

    public final Pair<Map<Model.EventKey, JSONObject>, Boolean> getEventsBySizeAndCount(long maxSize, int maxCount, long eventTtl) {
        return this.db.getBySizeAndCount(this.config.getId(), maxSize, maxCount, eventTtl);
    }

    public final void deleteEvents(Iterable<Model.EventKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.db.deleteAll(keys);
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public int getEventCount() {
        return this.db.count(this.config.getId());
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public void clear() {
        this.db.clear();
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public boolean match(Model.EventType eventType, String event, JSONObject paramJson) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.config.getSupportEventTypes().contains(eventType.getAlias())) {
            return false;
        }
        if (this.config.getFilter() == null) {
            return true;
        }
        if (Model.EventType.V3 != eventType) {
            return false;
        }
        if ((!this.config.getFilter().getEvents().isEmpty()) && this.config.getFilter().getEvents().contains(event)) {
            return true;
        }
        if (paramJson == null) {
            return false;
        }
        if (!this.config.getFilter().getParamKeys().isEmpty()) {
            List<List<String>> list = this.config.getFilter().getParamKeys().get(event);
            if (list != null) {
                List<List<String>> list2 = list;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        if (jsonContainsArray(paramJson, (List) it.next())) {
                            z4 = true;
                            break;
                        }
                    }
                }
                z4 = false;
                if (z4) {
                    return true;
                }
            }
            List<List<String>> list3 = this.config.getFilter().getParamKeys().get("*");
            if (list3 != null) {
                List<List<String>> list4 = list3;
                if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                    Iterator<T> it2 = list4.iterator();
                    while (it2.hasNext()) {
                        if (jsonContainsArray(paramJson, (List) it2.next())) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    return true;
                }
            }
        }
        if (!this.config.getFilter().getParamKeyValues().isEmpty()) {
            List<HashMap<String, String>> list5 = this.config.getFilter().getParamKeyValues().get(event);
            if (list5 != null) {
                List<HashMap<String, String>> list6 = list5;
                if (!(list6 instanceof Collection) || !list6.isEmpty()) {
                    Iterator<T> it3 = list6.iterator();
                    while (it3.hasNext()) {
                        if (jsonContainsKvs(paramJson, (HashMap) it3.next())) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    return true;
                }
            }
            List<HashMap<String, String>> list7 = this.config.getFilter().getParamKeyValues().get("*");
            if (list7 != null) {
                List<HashMap<String, String>> list8 = list7;
                if (!(list8 instanceof Collection) || !list8.isEmpty()) {
                    Iterator<T> it4 = list8.iterator();
                    while (it4.hasNext()) {
                        if (jsonContainsKvs(paramJson, (HashMap) it4.next())) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean jsonContainsArray(JSONObject json, List<String> arr) {
        Iterator<String> it = arr.iterator();
        while (it.hasNext()) {
            if (!json.has(it.next())) {
                return false;
            }
        }
        return true;
    }

    private final boolean jsonContainsKvs(JSONObject json, HashMap<String, String> kvs) {
        for (Map.Entry<String, String> entry : kvs.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "kvs.entries");
            String key = entry.getKey();
            String value = entry.getValue();
            if (!Intrinsics.areEqual(json.optString(key), value)) {
                Object opt = json.opt(key);
                if (!Intrinsics.areEqual(opt != null ? opt.toString() : null, value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        return "Group-" + this.config.getPriority().getPriorityName() + '-' + this.config.getId() + '-' + this.config.getInterval() + 's';
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0273, code lost:
    
        r0 = r18.logger;
        r2 = new java.lang.Object[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x027c, code lost:
    
        r2[0] = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x027e, code lost:
    
        r0.info("{} send log success and no more events", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0282, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0283, code lost:
    
        r1 = false;
     */
    @Override // com.bytedance.applog.priority.original.GroupInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doWork(Lazy<? extends JSONObject> header, long runTimeSecs) {
        boolean z;
        String str = "header";
        Intrinsics.checkNotNullParameter(header, "header");
        setRunTime(runTimeSecs);
        char c = 0;
        int i = 1;
        if (!this.running.compareAndSet(false, true)) {
            this.logger.err("{} run break for it is running...", this);
            return;
        }
        this.logger.info("{} start run...", this);
        try {
            int maxRequestPerMinute = this.config.getFrequency().getMaxRequestPerMinute();
            int i2 = 0;
            while (true) {
                if (i2 >= maxRequestPerMinute || !this.workable.get() || isEmpty()) {
                    break;
                }
                int i3 = WhenMappings.$EnumSwitchMapping$1[this.config.getFrequency().allow().ordinal()];
                if (i3 != i) {
                    if (i3 == 2) {
                        Logger logger = this.logger;
                        Object[] objArr = new Object[i];
                        objArr[c] = this;
                        logger.info("{} run blocked by backoff...", objArr);
                        break;
                    }
                    if (i3 == 3) {
                        Logger logger2 = this.logger;
                        Object[] objArr2 = new Object[i];
                        objArr2[c] = this;
                        logger2.info("{} run blocked by frequency...", objArr2);
                        break;
                    }
                } else {
                    Logger logger3 = this.logger;
                    Object[] objArr3 = new Object[2];
                    objArr3[c] = this;
                    objArr3[i] = Integer.valueOf(i2);
                    logger3.info("{} run allowed for the {} times...", objArr3);
                }
                long j = 1000;
                Pair<Map<Model.EventKey, JSONObject>, Boolean> eventsBySizeAndCount = getEventsBySizeAndCount(this.config.getPriority().getMaxRequestBodySize(), this.config.getPriority().getMaxRequestEventCnt(), this.config.getPriority().getEventTtl() * j);
                Map<Model.EventKey, ? extends JSONObject> map = (Map) eventsBySizeAndCount.component1();
                boolean booleanValue = ((Boolean) eventsBySizeAndCount.component2()).booleanValue();
                if (map.isEmpty()) {
                    Logger logger4 = this.logger;
                    Object[] objArr4 = new Object[i];
                    objArr4[c] = this;
                    logger4.info("{} run broken for no events", objArr4);
                    break;
                }
                if (header.getValue() == null) {
                    Logger logger5 = this.logger;
                    Object[] objArr5 = new Object[i];
                    objArr5[c] = this;
                    logger5.info("{} run blocked by header is empty!", objArr5);
                    break;
                }
                Logger logger6 = this.logger;
                Object[] objArr6 = new Object[2];
                objArr6[c] = this;
                objArr6[i] = Integer.valueOf(map.size());
                logger6.info("{} run with {} events...", objArr6);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (Map.Entry<Model.EventKey, ? extends JSONObject> entry : map.entrySet()) {
                    Model.EventKey key = entry.getKey();
                    JSONObject value = entry.getValue();
                    try {
                        int i4 = WhenMappings.$EnumSwitchMapping$0[key.getEventType().ordinal()];
                        if (i4 == i) {
                            jSONArray.put(value);
                        } else if (i4 == 2) {
                            jSONArray2.put(value);
                        } else if (i4 == 3) {
                            jSONArray3.put(value);
                        }
                        i = 1;
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        this.running.set(z);
                        throw th;
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, header.getValue());
                if (jSONArray.length() > 0) {
                    jSONObject.put(Api.KEY_V3, jSONArray);
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("event", jSONArray2);
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("log_data", jSONArray3);
                }
                JSONObject jSONObject2 = new JSONObject();
                String str2 = str;
                jSONObject2.put(PriorityConst.OPTIONS_KEY_BACKOFF_PRIORITY, this.config.getFrequency().getVersion().toJsonWithValue(Integer.valueOf(this.config.getId())));
                jSONObject2.put(PriorityConst.OPTIONS_KEY_GROUP_PRIORITY, this.config.getVersion().toJsonWithValue(Integer.valueOf(this.config.getId())));
                jSONObject2.put("event_priority_config", this.config.getPriority().getVersion().toJsonWithValue(this.config.getPriority().getPriorityName().name()));
                jSONObject.put(Api.KEY_OPTIONS, jSONObject2);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put(Api.KEY_LOCAL_TIME, System.currentTimeMillis() / j);
                jSONObject.put(Api.KEY_GEN_TIME, System.currentTimeMillis());
                Logger logger7 = this.logger;
                Object[] objArr7 = new Object[4];
                try {
                    objArr7[0] = this;
                    objArr7[1] = Integer.valueOf(jSONArray.length());
                    objArr7[2] = Integer.valueOf(jSONArray2.length());
                    objArr7[3] = Integer.valueOf(jSONArray3.length());
                    logger7.info("{} post log with {} v3、{} v1、{} log_data...", objArr7);
                    this.callback.monitorIncreaseStats("REPORT_REQUEST_COUNT", 1);
                    PriorityCallback priorityCallback = this.callback;
                    String reportUrl = this.config.getReportUrl();
                    String jSONObject3 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "packJson.toString()");
                    byte[] bytes = jSONObject3.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    PriorityHttpResponse doHttpPost = priorityCallback.doHttpPost(reportUrl, bytes);
                    Intrinsics.checkNotNullExpressionValue(doHttpPost, ApmTrafficStats.TTNET_RESPONSE);
                    if (handleLogResponse(doHttpPost, map) && !booleanValue) {
                        break;
                    }
                    i2++;
                    i = 1;
                    str = str2;
                    c = 0;
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
            }
            this.running.set(false);
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public void destroy() {
        this.workable.set(false);
    }

    @Override // com.bytedance.applog.priority.original.GroupInterface
    public void flush() {
        this.nextReportTimeSec = 0L;
    }

    private final boolean handleLogResponse(PriorityHttpResponse response, Map<Model.EventKey, ? extends JSONObject> events) {
        int code = response.getCode();
        if (200 <= code && code < 300) {
            this.config.getFrequency().handle2xx();
            this.logger.info("{} post log response success: {}", this, response);
            JSONObject jSONObject = new JSONObject(response.getData());
            if (Intrinsics.areEqual(jSONObject.optString("message"), "success") && Intrinsics.areEqual(jSONObject.optString("magic_tag"), "ss_app_log")) {
                deleteEvents(events.keySet());
                CommonKt.stageEvents(this.callback, "3F", events, this.config.getPriority().getPriorityName(), this.config.getId());
                this.callback.monitorIncreaseStats("priority_request_success_cnt", 1);
                this.logger.info("{} {} events deleted, remaining {} events.", this, Integer.valueOf(events.size()), Integer.valueOf(getEventCount()));
                this.config.getPriority().getEngine().setConfig(jSONObject);
                return true;
            }
            if (this.callback.isMonitorEnabled()) {
                this.callback.monitorError("post priority[" + this + "] log biz error", "response: " + response);
            }
            this.logger.err("{} post log response success but biz not ok!!!: " + response, this);
        } else {
            if (500 <= code && code < 600) {
                this.config.getFrequency().handle5xx();
                if (this.callback.isMonitorEnabled()) {
                    this.callback.monitorError("post priority[" + this + "] log 5xx error", "response: " + response);
                }
            } else {
                if (400 <= code && code < 500) {
                    this.config.getFrequency().handle4xx();
                    this.logger.err("{} post log response is 4xx -> {}", this, response);
                    if (this.callback.isMonitorEnabled()) {
                        this.callback.monitorError("post priority[" + this + "] log 4xx error", "response: " + response);
                    }
                } else {
                    this.logger.err("{} post log response is unknown error -> {}", this, response);
                    if (this.callback.isMonitorEnabled()) {
                        this.callback.monitorError("post priority[" + this + "] log unknown error", "response: " + response);
                    }
                }
            }
        }
        CommonKt.stageEvents(this.callback, "3B", events, this.config.getPriority().getPriorityName(), this.config.getId());
        this.callback.monitorIncreaseStats("priority_request_failed_cnt", 1);
        return false;
    }
}
