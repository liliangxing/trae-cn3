package com.bytedance.applog.priority.original;

import android.content.Context;
import com.bytedance.applog.priority.Logger;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityConst;
import com.bytedance.applog.priority.original.Model;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: Engine.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u00015B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\b\u0010&\u001a\u0004\u0018\u00010'J\u0006\u0010(\u001a\u00020$J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020'J\u0006\u0010+\u001a\u00020,J$\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020'02J\u000e\u00103\u001a\u00020$2\u0006\u00101\u001a\u00020'J\b\u00104\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/applog/priority/original/Engine;", "", "context", "Landroid/content/Context;", "appId", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/applog/priority/PriorityCallback;", "logger", "Lcom/bytedance/applog/priority/Logger;", "defaultReportHost", "defaultReportPath", "(Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/applog/priority/PriorityCallback;Lcom/bytedance/applog/priority/Logger;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "backOffConfigVersion", "Lcom/bytedance/applog/priority/original/Model$Version;", "getCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "config", "Lcom/bytedance/applog/priority/original/Config;", "getContext", "()Landroid/content/Context;", "databasePool", "Lcom/bytedance/applog/priority/original/DatabasePool;", "fastMatchGroups", "Lcom/bytedance/applog/priority/original/Model$FastMatchGroups;", "groupConfigVersion", "getLogger", "()Lcom/bytedance/applog/priority/Logger;", "priorityConfigVersion", "workerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "Lcom/bytedance/applog/priority/original/Worker;", "clearEvents", "", "flush", "getVersionConfig", "Lorg/json/JSONObject;", "init", "initConfig", "configJson", "isEmpty", "", "onEvent", "eventName", "eventType", "", "json", "Lkotlin/Lazy;", "setConfig", "toString", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Engine {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appId;
    private Model.Version backOffConfigVersion;
    private final PriorityCallback callback;
    private final Config config;
    private final Context context;
    private final DatabasePool databasePool;
    private final String defaultReportHost;
    private final String defaultReportPath;
    private Model.FastMatchGroups fastMatchGroups;
    private Model.Version groupConfigVersion;
    private final Logger logger;
    private Model.Version priorityConfigVersion;
    private ConcurrentHashMap<Model.PriorityName, Worker> workerMap;

    public Engine(Context context, String str, PriorityCallback priorityCallback, Logger logger, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(priorityCallback, JsCallParser.VALUE_CALLBACK);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(str2, "defaultReportHost");
        Intrinsics.checkNotNullParameter(str3, "defaultReportPath");
        this.context = context;
        this.appId = str;
        this.callback = priorityCallback;
        this.logger = logger;
        this.defaultReportHost = str2;
        this.defaultReportPath = str3;
        this.workerMap = new ConcurrentHashMap<>(3);
        this.fastMatchGroups = new Model.FastMatchGroups(new CopyOnWriteArrayList());
        this.config = new Config(context, str);
        this.databasePool = new DatabasePool(context, str);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final PriorityCallback getCallback() {
        return this.callback;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    /* compiled from: Engine.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applog/priority/original/Engine$Companion;", "", "()V", "create", "Lcom/bytedance/applog/priority/original/Engine;", "ctx", "Landroid/content/Context;", "appId", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/applog/priority/PriorityCallback;", "logger", "Lcom/bytedance/applog/priority/Logger;", "defaultReportHost", "defaultReportPath", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Engine create(Context ctx, String appId, PriorityCallback callback, Logger logger, String defaultReportHost, String defaultReportPath) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(callback, JsCallParser.VALUE_CALLBACK);
            Intrinsics.checkNotNullParameter(logger, "logger");
            Intrinsics.checkNotNullParameter(defaultReportHost, "defaultReportHost");
            Intrinsics.checkNotNullParameter(defaultReportPath, "defaultReportPath");
            logger.info("priority engine create with app id: " + appId + "...", new Object[0]);
            return new Engine(ctx, appId, callback, logger, defaultReportHost, defaultReportPath);
        }
    }

    public final void init() {
        JSONObject jSONObject = this.config.get();
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        initConfig(jSONObject);
    }

    public final boolean isEmpty() {
        return this.fastMatchGroups.getGroups().isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void initConfig(JSONObject configJson) {
        Unit unit;
        Unit unit2;
        Model.GroupFrequency groupFrequency;
        Model.PriorityConfig priorityConfig;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(configJson, "configJson");
        int i = 0;
        boolean z = true;
        this.logger.info("{} init with config: {}...", this, configJson);
        JSONObject optJSONObject = configJson.optJSONObject(PriorityConst.RESPONSE_KEY_BACKOFF_CONFIG);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        Model.Ser.SerBackoffPriorityList serBackoffPriorityList = new Model.Ser.SerBackoffPriorityList(optJSONObject);
        this.backOffConfigVersion = serBackoffPriorityList.getVersion();
        JSONObject optJSONObject2 = configJson.optJSONObject("event_priority_config");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        Model.Ser.SerPriorityConfig serPriorityConfig = new Model.Ser.SerPriorityConfig(optJSONObject2);
        this.priorityConfigVersion = serPriorityConfig.getVersion();
        JSONObject optJSONObject3 = configJson.optJSONObject(PriorityConst.RESPONSE_KEY_GROUP_LIST);
        if (optJSONObject3 == null) {
            optJSONObject3 = new JSONObject();
        }
        Model.Ser.SerGroups serGroups = new Model.Ser.SerGroups(optJSONObject3, this.defaultReportHost, this.defaultReportPath);
        this.groupConfigVersion = serGroups.getVersion();
        Model.PriorityConfig priorityConfig2 = new Model.PriorityConfig(this, serPriorityConfig.getVersion(), Model.PriorityName.P0, serPriorityConfig.getConfig().getP0().getMaxEventSize(), serPriorityConfig.getConfig().getP0().getMaxRequestBodySize(), serPriorityConfig.getConfig().getP0().getMaxRequestEventCnt(), serPriorityConfig.getConfig().getP0().getEventTtl(), this.callback);
        Model.PriorityConfig priorityConfig3 = new Model.PriorityConfig(this, serPriorityConfig.getVersion(), Model.PriorityName.P1, serPriorityConfig.getConfig().getP1().getMaxEventSize(), serPriorityConfig.getConfig().getP1().getMaxRequestBodySize(), serPriorityConfig.getConfig().getP1().getMaxRequestEventCnt(), serPriorityConfig.getConfig().getP1().getEventTtl(), this.callback);
        Model.PriorityConfig priorityConfig4 = new Model.PriorityConfig(this, serPriorityConfig.getVersion(), Model.PriorityName.P2, serPriorityConfig.getConfig().getP2().getMaxEventSize(), serPriorityConfig.getConfig().getP2().getMaxRequestBodySize(), serPriorityConfig.getConfig().getP2().getMaxRequestEventCnt(), serPriorityConfig.getConfig().getP2().getEventTtl(), this.callback);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Model.Ser.SerGroup serGroup : serGroups.getPriorities()) {
            Model.Ser.SerBackoffPriority serBackoffPriority = serBackoffPriorityList.getPriorityMap().get(Integer.valueOf(serGroup.getId()));
            if (serBackoffPriority != null) {
                groupFrequency = new Model.GroupFrequency(serGroup.getInterval() <= 0 ? z : i, serBackoffPriorityList.getVersion(), serBackoffPriority.getBackoffRatio(), serBackoffPriority.getMaxRequestFrequency(), new AtomicInteger(i), new AtomicInteger(i), 0L, 0L);
            } else {
                groupFrequency = new Model.GroupFrequency(serGroup.getInterval() <= 0 ? z : i, serBackoffPriorityList.getVersion(), serBackoffPriorityList.getBackoffRatio(), serBackoffPriorityList.getMaxRequestFrequency(), new AtomicInteger(i), new AtomicInteger(i), 0L, 0L);
            }
            String buildPriorityReportUrl = CommonKt.buildPriorityReportUrl(serGroup.getId(), serGroup.getReportHost(), serGroup.getReportPath());
            String eventPriority = serGroup.getEventPriority();
            if (Intrinsics.areEqual(eventPriority, Model.PriorityName.P0.name())) {
                priorityConfig = priorityConfig2;
                arrayList = arrayList4;
                Group group = new Group(this.databasePool, new Model.GroupConfig(serGroup.getId(), serGroups.getVersion(), serGroup.getInterval(), groupFrequency, priorityConfig2, serGroup.getFilter(), serGroup.getSupportEventTypes(), buildPriorityReportUrl), this.logger, this.callback);
                arrayList2.add(group);
                copyOnWriteArrayList.add(group);
            } else {
                priorityConfig = priorityConfig2;
                arrayList = arrayList4;
                if (Intrinsics.areEqual(eventPriority, Model.PriorityName.P1.name())) {
                    Group group2 = new Group(this.databasePool, new Model.GroupConfig(serGroup.getId(), serGroups.getVersion(), serGroup.getInterval(), groupFrequency, priorityConfig3, serGroup.getFilter(), serGroup.getSupportEventTypes(), buildPriorityReportUrl), this.logger, this.callback);
                    arrayList3.add(group2);
                    copyOnWriteArrayList.add(group2);
                } else {
                    Group group3 = new Group(this.databasePool, new Model.GroupConfig(serGroup.getId(), serGroups.getVersion(), serGroup.getInterval(), groupFrequency, priorityConfig4, serGroup.getFilter(), serGroup.getSupportEventTypes(), buildPriorityReportUrl), this.logger, this.callback);
                    arrayList.add(group3);
                    copyOnWriteArrayList.add(group3);
                    priorityConfig2 = priorityConfig;
                    arrayList4 = arrayList;
                    i = 0;
                    z = true;
                }
            }
            priorityConfig2 = priorityConfig;
            arrayList4 = arrayList;
            i = 0;
            z = true;
        }
        ArrayList arrayList5 = arrayList4;
        Model.PriorityContext priorityContext = new Model.PriorityContext(this.databasePool, this.callback, this.logger, this.defaultReportHost, this.defaultReportPath);
        Worker worker = this.workerMap.get(Model.PriorityName.P0);
        Unit unit3 = null;
        if (worker != null) {
            worker.setGroups(arrayList2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Engine engine = this;
            this.workerMap.put(Model.PriorityName.P0, new Worker(Model.PriorityName.P0, priorityContext, arrayList2));
        }
        Worker worker2 = this.workerMap.get(Model.PriorityName.P1);
        if (worker2 != null) {
            worker2.setGroups(arrayList3);
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            Engine engine2 = this;
            this.workerMap.put(Model.PriorityName.P1, new Worker(Model.PriorityName.P1, priorityContext, arrayList3));
        }
        Worker worker3 = this.workerMap.get(Model.PriorityName.P2);
        if (worker3 != null) {
            worker3.setGroups(arrayList5);
            unit3 = Unit.INSTANCE;
        }
        if (unit3 == null) {
            Engine engine3 = this;
            this.workerMap.put(Model.PriorityName.P2, new Worker(Model.PriorityName.P2, priorityContext, arrayList5));
        }
        this.logger.info("{} init success!", this);
        this.fastMatchGroups = new Model.FastMatchGroups(copyOnWriteArrayList);
    }

    public final void setConfig(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.has(PriorityConst.RESPONSE_KEY_BACKOFF_CONFIG) || json.has("event_priority_config") || json.has(PriorityConst.RESPONSE_KEY_GROUP_LIST)) {
            JSONObject jSONObject = this.config.get();
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (!(setConfig$replaceIfNewConfig(this, json, jSONObject, PriorityConst.RESPONSE_KEY_GROUP_LIST) || (setConfig$replaceIfNewConfig(this, json, jSONObject, "event_priority_config") || setConfig$replaceIfNewConfig(this, json, jSONObject, PriorityConst.RESPONSE_KEY_BACKOFF_CONFIG)))) {
                this.logger.info("{} upgrade broken for same config!", this);
                return;
            }
            Config config = this.config;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "finalJson.toString()");
            config.save(jSONObject2);
            initConfig(jSONObject);
        }
    }

    private static final boolean setConfig$replaceIfNewConfig(Engine engine, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Unit unit;
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return false;
        }
        JSONObject optJSONObject2 = jSONObject2.optJSONObject(str);
        if (optJSONObject2 != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONObject2, "optJSONObject(key)");
            if (!Model.Version.INSTANCE.fromJson(optJSONObject).isNewFrom(Model.Version.INSTANCE.fromJson(optJSONObject2))) {
                unit = Unit.INSTANCE;
            } else {
                jSONObject2.put(str, optJSONObject);
                return true;
            }
        } else {
            unit = null;
        }
        if (unit != null) {
            return false;
        }
        jSONObject2.put(str, optJSONObject);
        return true;
    }

    public final boolean onEvent(String eventName, int eventType, Lazy<? extends JSONObject> json) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(json, "json");
        this.logger.info("{} onEvent: {} -> {}", this, eventName, Integer.valueOf(eventType));
        Model.EventType eventType2 = Model.EventType.INSTANCE.getEventType(eventType);
        Group match = this.fastMatchGroups.match(eventName, eventType2, json);
        if (match == null) {
            return false;
        }
        CommonKt.stageEvent(this.callback, "2A", eventType, (JSONObject) json.getValue(), match.getConfig().getPriority().getPriorityName(), match.getConfig().getId());
        this.logger.info("{} priority event: {} inserted with key: {}!", this, eventName, match.insertEvent(eventType2, eventName, (JSONObject) json.getValue()));
        CommonKt.stageEvent(this.callback, "2F", eventType, (JSONObject) json.getValue(), match.getConfig().getPriority().getPriorityName(), match.getConfig().getId());
        return true;
    }

    public final void flush() {
        Iterator<Worker> it = this.workerMap.values().iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    public final void clearEvents() {
        this.logger.info("{} clearEvents!", this);
        this.config.clear();
        Iterator<Group> it = this.fastMatchGroups.getGroups().iterator();
        while (it.hasNext()) {
            Group next = it.next();
            next.clear();
            this.logger.info("{} -> {} cleared!", this, next);
        }
    }

    public final JSONObject getVersionConfig() {
        if (this.backOffConfigVersion == null && this.priorityConfigVersion == null && this.groupConfigVersion == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Model.Version version = this.backOffConfigVersion;
        if (version != null) {
            jSONObject.put(PriorityConst.OPTIONS_KEY_BACKOFF_PRIORITY, version.toJson());
        }
        Model.Version version2 = this.priorityConfigVersion;
        if (version2 != null) {
            jSONObject.put("event_priority_config", version2.toJson());
        }
        Model.Version version3 = this.groupConfigVersion;
        if (version3 != null) {
            jSONObject.put(PriorityConst.OPTIONS_KEY_GROUP_PRIORITY, version3.toJson());
        }
        return jSONObject;
    }

    public String toString() {
        return "Engine-" + this.appId;
    }
}
