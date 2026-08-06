package com.bytedance.applog.priority.original;

import com.bytedance.applog.forward.EventForwardLoader;
import com.bytedance.applog.priority.Logger;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.sampling.EventSampling;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.monitor.deviceperf.CpuMemoryPerfMetric;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.vcloud.strategy.IAppService;
import com.ss.android.pushmanager.PushCommonConstants;
import com.vivo.push.PushClientConstants;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Model.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u00020\u0001:\u000b\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applog/priority/original/Model;", "", "()V", "EventKey", "EventType", "FastMatchGroups", "GroupConfig", "GroupFrequency", "GroupFrequencyAllow", "PriorityConfig", "PriorityContext", "PriorityName", "Ser", "Version", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Model {

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$GroupFrequencyAllow;", "", "(Ljava/lang/String;I)V", "Allow", "BlockByFrequency", "BlockByBackoff", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum GroupFrequencyAllow {
        Allow,
        BlockByFrequency,
        BlockByBackoff
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$PriorityName;", "", "(Ljava/lang/String;I)V", "P0", "P1", "P2", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum PriorityName {
        P0,
        P1,
        P2
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$EventType;", "", "type", "", PushCommonConstants.KEY_ALIAS, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "getType", "()I", "V3", "V1", "LogData", "Launch", "Terminate", "Impression", "ForwardV3", "Unknown", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum EventType {
        V3(0, "event_v3"),
        V1(1, "event_v1"),
        LogData(2, "log_data"),
        Launch(3, "launch"),
        Terminate(4, "terminate"),
        Impression(5, "item_impression"),
        ForwardV3(6, "forward_v3"),
        Unknown(99, "unknown");


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String alias;
        private final int type;

        EventType(int i, String str) {
            this.type = i;
            this.alias = str;
        }

        public final String getAlias() {
            return this.alias;
        }

        public final int getType() {
            return this.type;
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$EventType$Companion;", "", "()V", "getEventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "type", "", PushCommonConstants.KEY_ALIAS, "", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final EventType getEventType(int type) {
                EventType eventType;
                EventType[] values = EventType.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        eventType = null;
                        break;
                    }
                    eventType = values[i];
                    if (eventType.getType() == type) {
                        break;
                    }
                    i++;
                }
                return eventType == null ? EventType.Unknown : eventType;
            }

            public final EventType getEventType(String alias) {
                EventType eventType;
                Intrinsics.checkNotNullParameter(alias, "alias");
                EventType[] values = EventType.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        eventType = null;
                        break;
                    }
                    eventType = values[i];
                    String alias2 = eventType.getAlias();
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    String lowerCase = alias.toLowerCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (Intrinsics.areEqual(alias2, lowerCase)) {
                        break;
                    }
                    i++;
                }
                return eventType == null ? EventType.Unknown : eventType;
            }
        }
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\tHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$PriorityContext;", "", "databasePool", "Lcom/bytedance/applog/priority/original/DatabasePool;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/applog/priority/PriorityCallback;", "logger", "Lcom/bytedance/applog/priority/Logger;", "defaultReportHost", "", "defaultReportPath", "(Lcom/bytedance/applog/priority/original/DatabasePool;Lcom/bytedance/applog/priority/PriorityCallback;Lcom/bytedance/applog/priority/Logger;Ljava/lang/String;Ljava/lang/String;)V", "getCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "getDatabasePool", "()Lcom/bytedance/applog/priority/original/DatabasePool;", "getDefaultReportHost", "()Ljava/lang/String;", "getDefaultReportPath", "getLogger", "()Lcom/bytedance/applog/priority/Logger;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class PriorityContext {
        private final PriorityCallback callback;
        private final DatabasePool databasePool;
        private final String defaultReportHost;
        private final String defaultReportPath;
        private final Logger logger;

        public static /* synthetic */ PriorityContext copy$default(PriorityContext priorityContext, DatabasePool databasePool, PriorityCallback priorityCallback, Logger logger, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                databasePool = priorityContext.databasePool;
            }
            if ((i & 2) != 0) {
                priorityCallback = priorityContext.callback;
            }
            PriorityCallback priorityCallback2 = priorityCallback;
            if ((i & 4) != 0) {
                logger = priorityContext.logger;
            }
            Logger logger2 = logger;
            if ((i & 8) != 0) {
                str = priorityContext.defaultReportHost;
            }
            String str3 = str;
            if ((i & 16) != 0) {
                str2 = priorityContext.defaultReportPath;
            }
            return priorityContext.copy(databasePool, priorityCallback2, logger2, str3, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final DatabasePool getDatabasePool() {
            return this.databasePool;
        }

        /* renamed from: component2, reason: from getter */
        public final PriorityCallback getCallback() {
            return this.callback;
        }

        /* renamed from: component3, reason: from getter */
        public final Logger getLogger() {
            return this.logger;
        }

        /* renamed from: component4, reason: from getter */
        public final String getDefaultReportHost() {
            return this.defaultReportHost;
        }

        /* renamed from: component5, reason: from getter */
        public final String getDefaultReportPath() {
            return this.defaultReportPath;
        }

        public final PriorityContext copy(DatabasePool databasePool, PriorityCallback callback, Logger logger, String defaultReportHost, String defaultReportPath) {
            Intrinsics.checkNotNullParameter(databasePool, "databasePool");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(logger, "logger");
            Intrinsics.checkNotNullParameter(defaultReportHost, "defaultReportHost");
            Intrinsics.checkNotNullParameter(defaultReportPath, "defaultReportPath");
            return new PriorityContext(databasePool, callback, logger, defaultReportHost, defaultReportPath);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PriorityContext)) {
                return false;
            }
            PriorityContext priorityContext = (PriorityContext) other;
            return Intrinsics.areEqual(this.databasePool, priorityContext.databasePool) && Intrinsics.areEqual(this.callback, priorityContext.callback) && Intrinsics.areEqual(this.logger, priorityContext.logger) && Intrinsics.areEqual(this.defaultReportHost, priorityContext.defaultReportHost) && Intrinsics.areEqual(this.defaultReportPath, priorityContext.defaultReportPath);
        }

        public int hashCode() {
            return (((((((this.databasePool.hashCode() * 31) + this.callback.hashCode()) * 31) + this.logger.hashCode()) * 31) + this.defaultReportHost.hashCode()) * 31) + this.defaultReportPath.hashCode();
        }

        public String toString() {
            return "PriorityContext(databasePool=" + this.databasePool + ", callback=" + this.callback + ", logger=" + this.logger + ", defaultReportHost=" + this.defaultReportHost + ", defaultReportPath=" + this.defaultReportPath + ')';
        }

        public PriorityContext(DatabasePool databasePool, PriorityCallback callback, Logger logger, String defaultReportHost, String defaultReportPath) {
            Intrinsics.checkNotNullParameter(databasePool, "databasePool");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(logger, "logger");
            Intrinsics.checkNotNullParameter(defaultReportHost, "defaultReportHost");
            Intrinsics.checkNotNullParameter(defaultReportPath, "defaultReportPath");
            this.databasePool = databasePool;
            this.callback = callback;
            this.logger = logger;
            this.defaultReportHost = defaultReportHost;
            this.defaultReportPath = defaultReportPath;
        }

        public final DatabasePool getDatabasePool() {
            return this.databasePool;
        }

        public final PriorityCallback getCallback() {
            return this.callback;
        }

        public final Logger getLogger() {
            return this.logger;
        }

        public final String getDefaultReportHost() {
            return this.defaultReportHost;
        }

        public final String getDefaultReportPath() {
            return this.defaultReportPath;
        }
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u001d\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$EventKey;", "", "dbId", "", "groupId", "", "ts", "eventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "eventStained", "", "monitorId", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "(JIJLcom/bytedance/applog/priority/original/Model$EventType;ZLjava/lang/String;Ljava/lang/String;)V", "getDbId", "()J", "setDbId", "(J)V", "getEventName", "()Ljava/lang/String;", "getEventStained", "()Z", "getEventType", "()Lcom/bytedance/applog/priority/original/Model$EventType;", "getGroupId", "()I", "getMonitorId", "getTs", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class EventKey {
        private long dbId;
        private final String eventName;
        private final boolean eventStained;
        private final EventType eventType;
        private final int groupId;
        private final String monitorId;
        private final long ts;

        public EventKey(long j, int i, long j2, EventType eventType, boolean z, String monitorId, String eventName) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(monitorId, "monitorId");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.dbId = j;
            this.groupId = i;
            this.ts = j2;
            this.eventType = eventType;
            this.eventStained = z;
            this.monitorId = monitorId;
            this.eventName = eventName;
        }

        public final long getDbId() {
            return this.dbId;
        }

        public final void setDbId(long j) {
            this.dbId = j;
        }

        public final int getGroupId() {
            return this.groupId;
        }

        public final long getTs() {
            return this.ts;
        }

        public final EventType getEventType() {
            return this.eventType;
        }

        public final boolean getEventStained() {
            return this.eventStained;
        }

        public final String getMonitorId() {
            return this.monitorId;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public String toString() {
            return "id=" + this.dbId + "|g=" + this.groupId + "|n=" + this.eventName + '|' + this.monitorId;
        }
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Version;", "", "version", "", "configIds", "Lorg/json/JSONArray;", "(ILorg/json/JSONArray;)V", "getVersion", "()I", "isNewFrom", "", PreloadConfig.KEY_OTHER, "toJson", "Lorg/json/JSONObject;", "toJsonWithValue", "value", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Version {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final JSONArray configIds;
        private final int version;

        public Version(int i, JSONArray jSONArray) {
            this.version = i;
            this.configIds = jSONArray;
        }

        public final int getVersion() {
            return this.version;
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Version$Companion;", "", "()V", "fromJson", "Lcom/bytedance/applog/priority/original/Model$Version;", "json", "Lorg/json/JSONObject;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Version fromJson(JSONObject json) {
                Intrinsics.checkNotNullParameter(json, "json");
                return new Version(json.optInt("version", 0), json.optJSONArray(EventSampling.KEY_CONFIG_IDS));
            }
        }

        public final JSONObject toJsonWithValue(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", this.version);
            jSONObject.put("value", value);
            JSONArray jSONArray = this.configIds;
            if (jSONArray != null) {
                jSONObject.put(EventSampling.KEY_CONFIG_IDS, jSONArray);
            }
            return jSONObject;
        }

        public final boolean isNewFrom(Version other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int i = this.version;
            int i2 = other.version;
            if (i > i2) {
                return true;
            }
            if (i < i2) {
                return false;
            }
            JSONArray jSONArray = this.configIds;
            String jSONArray2 = jSONArray != null ? jSONArray.toString() : null;
            JSONArray jSONArray3 = other.configIds;
            return !Intrinsics.areEqual(jSONArray2, jSONArray3 != null ? jSONArray3.toString() : null);
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", this.version);
            JSONArray jSONArray = this.configIds;
            if (jSONArray != null) {
                jSONObject.put(EventSampling.KEY_CONFIG_IDS, jSONArray);
            }
            return jSONObject;
        }
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$PriorityConfig;", "", IAppService.SOURCE_ENGINE, "Lcom/bytedance/applog/priority/original/Engine;", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "maxEventSize", "", "maxRequestBodySize", "maxRequestEventCnt", "", "eventTtl", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/applog/priority/PriorityCallback;", "(Lcom/bytedance/applog/priority/original/Engine;Lcom/bytedance/applog/priority/original/Model$Version;Lcom/bytedance/applog/priority/original/Model$PriorityName;JJIJLcom/bytedance/applog/priority/PriorityCallback;)V", "getCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "getEngine", "()Lcom/bytedance/applog/priority/original/Engine;", "getEventTtl", "()J", "getMaxEventSize", "getMaxRequestBodySize", "getMaxRequestEventCnt", "()I", "getPriorityName", "()Lcom/bytedance/applog/priority/original/Model$PriorityName;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class PriorityConfig {
        private final PriorityCallback callback;
        private final Engine engine;
        private final long eventTtl;
        private final long maxEventSize;
        private final long maxRequestBodySize;
        private final int maxRequestEventCnt;
        private final PriorityName priorityName;
        private final Version version;

        public PriorityConfig(Engine engine, Version version, PriorityName priorityName, long j, long j2, int i, long j3, PriorityCallback callback) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(priorityName, "priorityName");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.engine = engine;
            this.version = version;
            this.priorityName = priorityName;
            this.maxEventSize = j;
            this.maxRequestBodySize = j2;
            this.maxRequestEventCnt = i;
            this.eventTtl = j3;
            this.callback = callback;
        }

        public final Engine getEngine() {
            return this.engine;
        }

        public final Version getVersion() {
            return this.version;
        }

        public final PriorityName getPriorityName() {
            return this.priorityName;
        }

        public final long getMaxEventSize() {
            return this.maxEventSize;
        }

        public final long getMaxRequestBodySize() {
            return this.maxRequestBodySize;
        }

        public final int getMaxRequestEventCnt() {
            return this.maxRequestEventCnt;
        }

        public final long getEventTtl() {
            return this.eventTtl;
        }

        public final PriorityCallback getCallback() {
            return this.callback;
        }
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\rH\u0002J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\b\u0010%\u001a\u00020\"H\u0002R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$GroupFrequency;", "", "isRealtime", "", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "backoffRatio", "", "maxRequestPerMinute", "level", "Ljava/util/concurrent/atomic/AtomicInteger;", "levelSuccessCnt", "lastWindowTime", "", "lastCheckTime", "(ZLcom/bytedance/applog/priority/original/Model$Version;IILjava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;JJ)V", "MAX_BACKOFF_RATIO", "MAX_RECOVERY_COUNT", "getLevel", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setLevel", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getMaxRequestPerMinute", "()I", "setMaxRequestPerMinute", "(I)V", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", SccResult.LABEL_ALLOW, "Lcom/bytedance/applog/priority/original/Model$GroupFrequencyAllow;", "backoffAllow", "freqAllow", "checkTime", "handle2xx", "", "handle4xx", "handle5xx", "resetWindow", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class GroupFrequency {
        private final int MAX_BACKOFF_RATIO;
        private final int MAX_RECOVERY_COUNT;
        private final int backoffRatio;
        private final boolean isRealtime;
        private long lastCheckTime;
        private long lastWindowTime;
        private AtomicInteger level;
        private AtomicInteger levelSuccessCnt;
        private int maxRequestPerMinute;
        private final Version version;

        public final void handle4xx() {
        }

        public GroupFrequency(boolean z, Version version, int i, int i2, AtomicInteger level, AtomicInteger levelSuccessCnt, long j, long j2) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(levelSuccessCnt, "levelSuccessCnt");
            this.isRealtime = z;
            this.version = version;
            this.backoffRatio = i;
            this.maxRequestPerMinute = i2;
            this.level = level;
            this.levelSuccessCnt = levelSuccessCnt;
            this.lastWindowTime = j;
            this.lastCheckTime = j2;
            this.MAX_BACKOFF_RATIO = 10000;
            this.MAX_RECOVERY_COUNT = 5;
        }

        public final Version getVersion() {
            return this.version;
        }

        public final int getMaxRequestPerMinute() {
            return this.maxRequestPerMinute;
        }

        public final void setMaxRequestPerMinute(int i) {
            this.maxRequestPerMinute = i;
        }

        public final AtomicInteger getLevel() {
            return this.level;
        }

        public final void setLevel(AtomicInteger atomicInteger) {
            Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
            this.level = atomicInteger;
        }

        public final GroupFrequencyAllow allow() {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.lastCheckTime = currentTimeMillis;
            if (this.isRealtime) {
                if (this.level.get() > 0) {
                    long j = this.lastCheckTime;
                    if (j - this.lastWindowTime > 5) {
                        this.lastWindowTime = j;
                        return GroupFrequencyAllow.Allow;
                    }
                    return GroupFrequencyAllow.BlockByFrequency;
                }
                return GroupFrequencyAllow.Allow;
            }
            if (!freqAllow(currentTimeMillis)) {
                return GroupFrequencyAllow.BlockByFrequency;
            }
            if (!backoffAllow()) {
                return GroupFrequencyAllow.BlockByBackoff;
            }
            return GroupFrequencyAllow.Allow;
        }

        public final void handle5xx() {
            this.levelSuccessCnt.set(this.maxRequestPerMinute);
            this.lastWindowTime = this.lastCheckTime;
            if (this.level.incrementAndGet() > 4) {
                this.level.set(4);
            }
        }

        public final void handle2xx() {
            int incrementAndGet = this.levelSuccessCnt.incrementAndGet();
            if (this.level.get() > 0) {
                if (incrementAndGet >= this.MAX_RECOVERY_COUNT || this.isRealtime) {
                    this.level.set(0);
                }
            }
        }

        private final boolean freqAllow(long checkTime) {
            int i = this.level.get();
            if (i == 0) {
                if (checkTime - this.lastWindowTime >= 60) {
                    resetWindow();
                    return true;
                }
            } else {
                if (checkTime - this.lastWindowTime >= ((long) 60) * ((long) Math.pow(2.0d, (double) i))) {
                    resetWindow();
                    return true;
                }
            }
            return this.levelSuccessCnt.get() < this.maxRequestPerMinute;
        }

        private final boolean backoffAllow() {
            int i = this.backoffRatio;
            if (i == 0 || i == this.MAX_BACKOFF_RATIO || new SecureRandom().nextInt(this.MAX_BACKOFF_RATIO) > this.backoffRatio) {
                return true;
            }
            this.levelSuccessCnt.incrementAndGet();
            return false;
        }

        private final void resetWindow() {
            this.levelSuccessCnt.set(0);
            this.lastWindowTime = this.lastCheckTime;
        }
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u000fH\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$GroupConfig;", "", "id", "", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "interval", CpuMemoryPerfMetric.FREQUENCY, "Lcom/bytedance/applog/priority/original/Model$GroupFrequency;", "priority", "Lcom/bytedance/applog/priority/original/Model$PriorityConfig;", "filter", "Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "supportEventTypes", "", "", "reportUrl", "(ILcom/bytedance/applog/priority/original/Model$Version;ILcom/bytedance/applog/priority/original/Model$GroupFrequency;Lcom/bytedance/applog/priority/original/Model$PriorityConfig;Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;Ljava/util/List;Ljava/lang/String;)V", "getFilter", "()Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "getFrequency", "()Lcom/bytedance/applog/priority/original/Model$GroupFrequency;", "getId", "()I", "getInterval", "getPriority", "()Lcom/bytedance/applog/priority/original/Model$PriorityConfig;", "getReportUrl", "()Ljava/lang/String;", "getSupportEventTypes", "()Ljava/util/List;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "setMaxRequestFrequency", "", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class GroupConfig {
        private final Ser.SerGroupFilter filter;
        private final GroupFrequency frequency;
        private final int id;
        private final int interval;
        private final PriorityConfig priority;
        private final String reportUrl;
        private final List<String> supportEventTypes;
        private final Version version;

        public GroupConfig(int i, Version version, int i2, GroupFrequency frequency, PriorityConfig priority, Ser.SerGroupFilter serGroupFilter, List<String> supportEventTypes, String reportUrl) {
            Intrinsics.checkNotNullParameter(version, "version");
            Intrinsics.checkNotNullParameter(frequency, "frequency");
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(supportEventTypes, "supportEventTypes");
            Intrinsics.checkNotNullParameter(reportUrl, "reportUrl");
            this.id = i;
            this.version = version;
            this.interval = i2;
            this.frequency = frequency;
            this.priority = priority;
            this.filter = serGroupFilter;
            this.supportEventTypes = supportEventTypes;
            this.reportUrl = reportUrl;
            setMaxRequestFrequency();
        }

        public final int getId() {
            return this.id;
        }

        public final Version getVersion() {
            return this.version;
        }

        public final int getInterval() {
            return this.interval;
        }

        public final GroupFrequency getFrequency() {
            return this.frequency;
        }

        public final PriorityConfig getPriority() {
            return this.priority;
        }

        public final Ser.SerGroupFilter getFilter() {
            return this.filter;
        }

        public final List<String> getSupportEventTypes() {
            return this.supportEventTypes;
        }

        public final String getReportUrl() {
            return this.reportUrl;
        }

        public String toString() {
            return "GroupConfig-" + this.id;
        }

        private final void setMaxRequestFrequency() {
            if (this.interval <= 0) {
                this.frequency.setMaxRequestPerMinute(Integer.MAX_VALUE);
            } else {
                if (this.frequency.getMaxRequestPerMinute() > 0) {
                    return;
                }
                this.frequency.setMaxRequestPerMinute(RangesKt.coerceAtLeast(60 / this.interval, 10));
            }
        }
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J&\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$FastMatchGroups;", "", "groups", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/applog/priority/original/Group;", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "eventTypes", "", "Lcom/bytedance/applog/priority/original/Model$EventType;", "getGroups", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "v3All", "", "v3Names", "", "match", SchemaConstants.INNER_PARAM_EVENT_NAME, "eventType", "json", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class FastMatchGroups {
        private final Set<EventType> eventTypes;
        private final CopyOnWriteArrayList<Group> groups;
        private boolean v3All;
        private final Set<String> v3Names;

        /* compiled from: Model.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[EventType.values().length];
                iArr[EventType.V3.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public FastMatchGroups(CopyOnWriteArrayList<Group> groups) {
            Intrinsics.checkNotNullParameter(groups, "groups");
            this.groups = groups;
            this.v3Names = new LinkedHashSet();
            this.eventTypes = new LinkedHashSet();
            Iterator<Group> it = groups.iterator();
            while (it.hasNext()) {
                Group next = it.next();
                for (String str : next.getConfig().getSupportEventTypes()) {
                    if (Intrinsics.areEqual(str, EventType.V3.getAlias())) {
                        this.eventTypes.add(EventType.V3);
                        if (!this.v3All) {
                            Ser.SerGroupFilter filter = next.getConfig().getFilter();
                            if (filter != null) {
                                Set<String> events = filter.getEvents();
                                if (events.contains("*")) {
                                    this.v3All = true;
                                    this.v3Names.clear();
                                } else {
                                    Iterator<T> it2 = events.iterator();
                                    while (it2.hasNext()) {
                                        this.v3Names.add((String) it2.next());
                                    }
                                }
                                HashMap<String, List<List<String>>> paramKeys = filter.getParamKeys();
                                if (paramKeys.containsKey("*")) {
                                    this.v3All = true;
                                    this.v3Names.clear();
                                } else {
                                    Set<String> keySet = paramKeys.keySet();
                                    Intrinsics.checkNotNullExpressionValue(keySet, "this.keys");
                                    for (String e : keySet) {
                                        Set<String> set = this.v3Names;
                                        Intrinsics.checkNotNullExpressionValue(e, "e");
                                        set.add(e);
                                    }
                                }
                                HashMap<String, List<HashMap<String, String>>> paramKeyValues = filter.getParamKeyValues();
                                if (paramKeyValues.containsKey("*")) {
                                    this.v3All = true;
                                    this.v3Names.clear();
                                } else {
                                    Set<String> keySet2 = paramKeyValues.keySet();
                                    Intrinsics.checkNotNullExpressionValue(keySet2, "this.keys");
                                    for (String e2 : keySet2) {
                                        Set<String> set2 = this.v3Names;
                                        Intrinsics.checkNotNullExpressionValue(e2, "e");
                                        set2.add(e2);
                                    }
                                }
                                if (paramKeyValues == null) {
                                }
                            }
                            this.v3All = true;
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        this.eventTypes.add(EventType.INSTANCE.getEventType(str));
                    }
                }
            }
        }

        public final CopyOnWriteArrayList<Group> getGroups() {
            return this.groups;
        }

        public final Group match(String eventName, EventType eventType, Lazy<? extends JSONObject> json) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(json, "json");
            Object obj = null;
            if (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()] == 1) {
                if (!this.v3All && !this.v3Names.contains(eventName)) {
                    return null;
                }
                JSONObject optJSONObject = json.getValue().optJSONObject("params");
                Iterator<T> it = this.groups.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((Group) next).match(eventType, eventName, optJSONObject)) {
                        obj = next;
                        break;
                    }
                }
                return (Group) obj;
            }
            if (!this.eventTypes.contains(eventType)) {
                return null;
            }
            Iterator<T> it2 = this.groups.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (((Group) next2).match(eventType, "", null)) {
                    obj = next2;
                    break;
                }
            }
            return (Group) obj;
        }
    }

    /* compiled from: Model.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser;", "", "()V", "SerBackoffPriority", "SerBackoffPriorityList", "SerGroup", "SerGroupFilter", "SerGroups", "SerPriorityConfig", "SerPriorityConfigConfig", "SerPriorityConfigConfigItem", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Ser {

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerBackoffPriority;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "backoffRatio", "", "getBackoffRatio", "()I", "maxRequestFrequency", "getMaxRequestFrequency", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SerBackoffPriority {
            private final int backoffRatio;
            private final int maxRequestFrequency;

            public SerBackoffPriority(JSONObject json) {
                Intrinsics.checkNotNullParameter(json, "json");
                this.backoffRatio = json.optInt("backoff_ratio", 0);
                this.maxRequestFrequency = json.optInt("max_request_frequency", 10);
            }

            public final int getBackoffRatio() {
                return this.backoffRatio;
            }

            public final int getMaxRequestFrequency() {
                return this.maxRequestFrequency;
            }
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerBackoffPriorityList;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "backoffRatio", "", "getBackoffRatio", "()I", "maxRequestFrequency", "getMaxRequestFrequency", "priorityMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/applog/priority/original/Model$Ser$SerBackoffPriority;", "getPriorityMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SerBackoffPriorityList {
            private final int backoffRatio;
            private final int maxRequestFrequency;
            private final ConcurrentHashMap<Integer, SerBackoffPriority> priorityMap;
            private final Version version;

            public SerBackoffPriorityList(JSONObject json) {
                Intrinsics.checkNotNullParameter(json, "json");
                this.version = new Version(json.optInt("version", 0), json.optJSONArray(EventSampling.KEY_CONFIG_IDS));
                this.backoffRatio = json.optInt("backoff_ratio", 0);
                this.maxRequestFrequency = json.optInt("max_request_frequency", 10);
                this.priorityMap = new ConcurrentHashMap<>();
                JSONArray optJSONArray = json.optJSONArray("priorities");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject priority = optJSONArray.optJSONObject(i);
                        if (priority != null) {
                            Intrinsics.checkNotNullExpressionValue(priority, "priority");
                            int optInt = priority.optInt("global_priority");
                            if (optInt > 0) {
                                this.priorityMap.put(Integer.valueOf(optInt), new SerBackoffPriority(priority));
                            }
                        }
                    }
                }
            }

            public final Version getVersion() {
                return this.version;
            }

            public final int getBackoffRatio() {
                return this.backoffRatio;
            }

            public final int getMaxRequestFrequency() {
                return this.maxRequestFrequency;
            }

            public final ConcurrentHashMap<Integer, SerBackoffPriority> getPriorityMap() {
                return this.priorityMap;
            }
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfigItem;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "eventTtl", "", "getEventTtl", "()J", "getJson", "()Lorg/json/JSONObject;", "maxEventSize", "getMaxEventSize", "maxRequestBodySize", "getMaxRequestBodySize", "maxRequestEventCnt", "", "getMaxRequestEventCnt", "()I", "getDefaultInt", "key", "", "defaultValue", "getDefaultLong", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SerPriorityConfigConfigItem {
            private final long eventTtl;
            private final JSONObject json;
            private final long maxEventSize;
            private final long maxRequestBodySize;
            private final int maxRequestEventCnt;

            public SerPriorityConfigConfigItem(JSONObject json) {
                Intrinsics.checkNotNullParameter(json, "json");
                this.json = json;
                this.maxEventSize = getDefaultLong("max_event_size", 1048576L);
                this.maxRequestBodySize = getDefaultLong("max_request_body_size", ModelKt.DEFAULT_MAX_REQUEST_BODY_SIZE);
                this.maxRequestEventCnt = getDefaultInt("max_request_event_count", 2000);
                this.eventTtl = getDefaultLong("event_ttl", 604800L);
            }

            public final JSONObject getJson() {
                return this.json;
            }

            public final long getMaxEventSize() {
                return this.maxEventSize;
            }

            public final long getMaxRequestBodySize() {
                return this.maxRequestBodySize;
            }

            public final int getMaxRequestEventCnt() {
                return this.maxRequestEventCnt;
            }

            public final long getEventTtl() {
                return this.eventTtl;
            }

            private final long getDefaultLong(String key, long defaultValue) {
                long optLong = this.json.optLong(key);
                return optLong > 0 ? optLong : defaultValue;
            }

            private final int getDefaultInt(String key, int defaultValue) {
                int optInt = this.json.optInt(key);
                return optInt > 0 ? optInt : defaultValue;
            }
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfig;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "p0", "Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfigItem;", "getP0", "()Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfigItem;", "p1", "getP1", "p2", "getP2", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SerPriorityConfigConfig {
            private final SerPriorityConfigConfigItem p0;
            private final SerPriorityConfigConfigItem p1;
            private final SerPriorityConfigConfigItem p2;

            public SerPriorityConfigConfig(JSONObject json) {
                Intrinsics.checkNotNullParameter(json, "json");
                JSONObject optJSONObject = json.optJSONObject("P0");
                this.p0 = new SerPriorityConfigConfigItem(optJSONObject == null ? new JSONObject() : optJSONObject);
                JSONObject optJSONObject2 = json.optJSONObject("P1");
                this.p1 = new SerPriorityConfigConfigItem(optJSONObject2 == null ? new JSONObject() : optJSONObject2);
                JSONObject optJSONObject3 = json.optJSONObject("P2");
                this.p2 = new SerPriorityConfigConfigItem(optJSONObject3 == null ? new JSONObject() : optJSONObject3);
            }

            public final SerPriorityConfigConfigItem getP0() {
                return this.p0;
            }

            public final SerPriorityConfigConfigItem getP1() {
                return this.p1;
            }

            public final SerPriorityConfigConfigItem getP2() {
                return this.p2;
            }
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfig;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "config", "Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfig;", "getConfig", "()Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfig;", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SerPriorityConfig {
            private final SerPriorityConfigConfig config;
            private final Version version;

            public SerPriorityConfig(JSONObject json) {
                Intrinsics.checkNotNullParameter(json, "json");
                this.version = new Version(json.optInt("version", 0), json.optJSONArray(EventSampling.KEY_CONFIG_IDS));
                JSONObject optJSONObject = json.optJSONObject("config");
                this.config = new SerPriorityConfigConfig(optJSONObject == null ? new JSONObject() : optJSONObject);
            }

            public final Version getVersion() {
                return this.version;
            }

            public final SerPriorityConfigConfig getConfig() {
                return this.config;
            }
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tRq\u0010\n\u001ab\u0012\u0004\u0012\u00020\u0007\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\r0\f0\u000bj0\u0012\u0004\u0012\u00020\u0007\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\r0\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRE\u0010\u0010\u001a6\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f0\u000bj\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", EventForwardLoader.KEY_EVENT_FORWARD_EVENTS, "", "", "getEvents", "()Ljava/util/Set;", "paramKeyValues", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getParamKeyValues", "()Ljava/util/HashMap;", PushClientConstants.TAG_PARAM_KEYS, "getParamKeys", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SerGroupFilter {
            private final Set<String> events;
            private final HashMap<String, List<HashMap<String, String>>> paramKeyValues;
            private final HashMap<String, List<List<String>>> paramKeys;

            public SerGroupFilter(JSONObject json) {
                JSONObject jSONObject;
                Intrinsics.checkNotNullParameter(json, "json");
                this.events = new LinkedHashSet();
                this.paramKeys = new HashMap<>();
                this.paramKeyValues = new HashMap<>();
                JSONArray optJSONArray = json.optJSONArray(EventForwardLoader.KEY_EVENT_FORWARD_EVENTS);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String e = optJSONArray.optString(i);
                        String str = e;
                        if (!(str == null || str.length() == 0)) {
                            Set<String> set = this.events;
                            Intrinsics.checkNotNullExpressionValue(e, "e");
                            set.add(e);
                        }
                    }
                }
                JSONObject optJSONObject = json.optJSONObject("param_keys");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
                    while (keys.hasNext()) {
                        String key = keys.next();
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(key);
                        if (optJSONArray2 != null) {
                            Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(key)");
                            int length2 = optJSONArray2.length();
                            int i2 = 0;
                            while (i2 < length2) {
                                JSONArray andArr = optJSONArray2.optJSONArray(i2);
                                ArrayList arrayList2 = new ArrayList();
                                if (andArr != null) {
                                    Intrinsics.checkNotNullExpressionValue(andArr, "andArr");
                                    int length3 = andArr.length();
                                    jSONObject = optJSONObject;
                                    int i3 = 0;
                                    while (i3 < length3) {
                                        int i4 = length3;
                                        String value = andArr.optString(i3);
                                        String str2 = value;
                                        if (!(str2 == null || str2.length() == 0)) {
                                            Intrinsics.checkNotNullExpressionValue(value, "value");
                                            arrayList2.add(value);
                                        }
                                        i3++;
                                        length3 = i4;
                                    }
                                } else {
                                    jSONObject = optJSONObject;
                                }
                                arrayList.add(arrayList2);
                                i2++;
                                optJSONObject = jSONObject;
                            }
                        }
                        JSONObject jSONObject2 = optJSONObject;
                        HashMap<String, List<List<String>>> hashMap = this.paramKeys;
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, arrayList);
                        optJSONObject = jSONObject2;
                    }
                }
                JSONObject optJSONObject2 = json.optJSONObject("param_key_values");
                if (optJSONObject2 != null) {
                    Iterator<String> keys2 = optJSONObject2.keys();
                    Intrinsics.checkNotNullExpressionValue(keys2, "it.keys()");
                    while (keys2.hasNext()) {
                        String key2 = keys2.next();
                        ArrayList arrayList3 = new ArrayList();
                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray(key2);
                        if (optJSONArray3 != null) {
                            Intrinsics.checkNotNullExpressionValue(optJSONArray3, "optJSONArray(key)");
                            int length4 = optJSONArray3.length();
                            int i5 = 0;
                            while (i5 < length4) {
                                JSONObject value2 = optJSONArray3.optJSONObject(i5);
                                HashMap hashMap2 = new HashMap();
                                if (value2 != null) {
                                    Intrinsics.checkNotNullExpressionValue(value2, "value");
                                    Iterator<String> keys3 = value2.keys();
                                    Intrinsics.checkNotNullExpressionValue(keys3, "v.keys()");
                                    while (keys3.hasNext()) {
                                        String k = keys3.next();
                                        JSONObject jSONObject3 = optJSONObject2;
                                        Intrinsics.checkNotNullExpressionValue(k, "k");
                                        String optString = value2.optString(k);
                                        Intrinsics.checkNotNullExpressionValue(optString, "v.optString(k)");
                                        hashMap2.put(k, optString);
                                        optJSONObject2 = jSONObject3;
                                        keys2 = keys2;
                                    }
                                }
                                arrayList3.add(hashMap2);
                                i5++;
                                optJSONObject2 = optJSONObject2;
                                keys2 = keys2;
                            }
                        }
                        JSONObject jSONObject4 = optJSONObject2;
                        HashMap<String, List<HashMap<String, String>>> hashMap3 = this.paramKeyValues;
                        Intrinsics.checkNotNullExpressionValue(key2, "key");
                        hashMap3.put(key2, arrayList3);
                        optJSONObject2 = jSONObject4;
                        keys2 = keys2;
                    }
                }
            }

            public final Set<String> getEvents() {
                return this.events;
            }

            public final HashMap<String, List<List<String>>> getParamKeys() {
                return this.paramKeys;
            }

            public final HashMap<String, List<HashMap<String, String>>> getParamKeyValues() {
                return this.paramKeyValues;
            }
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerGroup;", "", "json", "Lorg/json/JSONObject;", "defaultReportHost", "", "defaultReportPath", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "eventPriority", "getEventPriority", "()Ljava/lang/String;", "filter", "Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "getFilter", "()Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "id", "", "getId", "()I", "interval", "getInterval", "reportHost", "getReportHost", "reportPath", "getReportPath", "supportEventTypes", "", "getSupportEventTypes", "()Ljava/util/List;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SerGroup {
            private final String eventPriority;
            private final SerGroupFilter filter;
            private final int id;
            private final int interval;
            private final String reportHost;
            private final String reportPath;
            private final List<String> supportEventTypes;

            public SerGroup(JSONObject json, String defaultReportHost, String defaultReportPath) {
                Intrinsics.checkNotNullParameter(json, "json");
                Intrinsics.checkNotNullParameter(defaultReportHost, "defaultReportHost");
                Intrinsics.checkNotNullParameter(defaultReportPath, "defaultReportPath");
                this.id = json.optInt("global_priority", 0);
                this.interval = RangesKt.coerceAtLeast(json.optInt("interval", 0), 0);
                String optString = json.optString("report_host", defaultReportHost);
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"report_host\", defaultReportHost)");
                this.reportHost = optString;
                String optString2 = json.optString("report_path", defaultReportPath);
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"report_path\", defaultReportPath)");
                this.reportPath = optString2;
                this.supportEventTypes = new ArrayList();
                String optString3 = json.optString("event_priority", "P2");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"event_priority\", \"P2\")");
                this.eventPriority = optString3;
                JSONObject optJSONObject = json.optJSONObject("filter");
                this.filter = optJSONObject != null ? new SerGroupFilter(optJSONObject) : null;
                JSONArray optJSONArray = json.optJSONArray("support_event_types");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String type = optJSONArray.optString(i);
                        String str = type;
                        if (!(str == null || str.length() == 0)) {
                            List<String> list = this.supportEventTypes;
                            Intrinsics.checkNotNullExpressionValue(type, "type");
                            Locale ROOT = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                            String lowerCase = type.toLowerCase(ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                            list.add(lowerCase);
                        }
                    }
                }
            }

            public final int getId() {
                return this.id;
            }

            public final int getInterval() {
                return this.interval;
            }

            public final String getReportHost() {
                return this.reportHost;
            }

            public final String getReportPath() {
                return this.reportPath;
            }

            public final List<String> getSupportEventTypes() {
                return this.supportEventTypes;
            }

            public final String getEventPriority() {
                return this.eventPriority;
            }

            public final SerGroupFilter getFilter() {
                return this.filter;
            }
        }

        /* compiled from: Model.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerGroups;", "", "json", "Lorg/json/JSONObject;", "defaultReportHost", "", "defaultReportPath", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "priorities", "", "Lcom/bytedance/applog/priority/original/Model$Ser$SerGroup;", "getPriorities", "()Ljava/util/List;", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class SerGroups {
            private final List<SerGroup> priorities;
            private final Version version;

            public SerGroups(JSONObject json, String defaultReportHost, String defaultReportPath) {
                Intrinsics.checkNotNullParameter(json, "json");
                Intrinsics.checkNotNullParameter(defaultReportHost, "defaultReportHost");
                Intrinsics.checkNotNullParameter(defaultReportPath, "defaultReportPath");
                this.version = new Version(json.optInt("version", 0), json.optJSONArray(EventSampling.KEY_CONFIG_IDS));
                this.priorities = new ArrayList();
                JSONArray optJSONArray = json.optJSONArray("priorities");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject priority = optJSONArray.optJSONObject(i);
                        if (priority != null) {
                            Intrinsics.checkNotNullExpressionValue(priority, "priority");
                            this.priorities.add(new SerGroup(priority, defaultReportHost, defaultReportPath));
                        }
                    }
                }
            }

            public final Version getVersion() {
                return this.version;
            }

            public final List<SerGroup> getPriorities() {
                return this.priorities;
            }
        }
    }
}
