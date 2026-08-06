package com.bytedance.ies.bullet.core.monitor;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletMonitorContext;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.monitor.reliability.ReliabilityReporter;
import com.bytedance.ies.bullet.service.monitor.timeline.TimelineReporter;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* compiled from: BulletTracert.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0004J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J:\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aJ\u001e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u001e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000eJ\u0010\u0010 \u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J.\u0010!\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004J8\u0010!\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u0004J.\u0010&\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004J8\u0010&\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ies/bullet/core/monitor/BulletTracert;", "", "()V", "SCHEMA_KEY_SESSION_ID", "", "SubModule", "monitorContextMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/bullet/core/BulletMonitorContext;", "associateSession", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "initTime", "", "getMonitorContext", "monitorId", "getOrCreateContext", "schema", "disableCreate", "", "initTimeline", "tracertId", "sdkType", "inject", "category", "", LynxMonitorService.KEY_METRICS, "injectCategory", "key", "value", "injectMetrics", "supportAdvancedMonitor", "triggerReport", "status", "errorMessage", "errStage", "bid", "triggerReportFailedWithoutSchema", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletTracert {
    public static final String SCHEMA_KEY_SESSION_ID = "__x_session_id";
    private static final String SubModule = "Monitor-Tracert";
    public static final BulletTracert INSTANCE = new BulletTracert();
    private static final ConcurrentHashMap<String, BulletMonitorContext> monitorContextMap = new ConcurrentHashMap<>();

    private BulletTracert() {
    }

    static /* synthetic */ BulletMonitorContext getOrCreateContext$default(BulletTracert bulletTracert, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return bulletTracert.getOrCreateContext(str, z);
    }

    private final BulletMonitorContext getOrCreateContext(String schema, boolean disableCreate) {
        BulletMonitorContext bulletMonitorContext;
        try {
            Uri parse = Uri.parse(schema);
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            String safeGetQueryParameter = ExtKt.safeGetQueryParameter(parse, "__x_session_id");
            if (safeGetQueryParameter == null) {
                safeGetQueryParameter = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(safeGetQueryParameter, "randomUUID().toString()");
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ConcurrentHashMap<String, BulletMonitorContext> concurrentHashMap = monitorContextMap;
            objectRef.element = concurrentHashMap.get(safeGetQueryParameter);
            if (objectRef.element != null || disableCreate) {
                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                StringBuilder append = new StringBuilder("Tracert getContext, disableCreate ").append(disableCreate).append(", monitorId ");
                BulletMonitorContext bulletMonitorContext2 = (BulletMonitorContext) objectRef.element;
                BulletLogger.printLog$default(bulletLogger, append.append(bulletMonitorContext2 != null ? bulletMonitorContext2.getMonitorId() : null).append(", schema ").append(schema).toString(), null, null, 6, null);
                bulletMonitorContext = (BulletMonitorContext) objectRef.element;
            } else {
                objectRef.element = new BulletMonitorContext(safeGetQueryParameter);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "Tracert createContext, monitorId " + ((BulletMonitorContext) objectRef.element).getMonitorId() + ", schema " + schema, null, null, 6, null);
                concurrentHashMap.put(safeGetQueryParameter, objectRef.element);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.ies.bullet.core.monitor.BulletTracert$getOrCreateContext$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConcurrentHashMap concurrentHashMap2;
                        if (((BulletMonitorContext) objectRef.element).getSessionId() == null) {
                            concurrentHashMap2 = BulletTracert.monitorContextMap;
                            concurrentHashMap2.remove(((BulletMonitorContext) objectRef.element).getMonitorId());
                        }
                    }
                }, 300000);
                bulletMonitorContext = (BulletMonitorContext) objectRef.element;
            }
            return bulletMonitorContext;
        } catch (Exception unused) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "invalid url in BulletTracert", null, null, 6, null);
            return null;
        }
    }

    public final boolean supportAdvancedMonitor(String schema) {
        return schema != null && Uri.parse(schema).getBooleanQueryParameter("enable_advanced_monitor", true);
    }

    public final BulletMonitorContext getMonitorContext(String monitorId) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        return monitorContextMap.get(monitorId);
    }

    public final String initTimeline(String schema, String tracertId, String sdkType) {
        String monitorId;
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(tracertId, "tracertId");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        boolean z = false;
        BulletMonitorContext orCreateContext$default = getOrCreateContext$default(this, schema, false, 2, null);
        if (orCreateContext$default != null && orCreateContext$default.getInUse()) {
            z = true;
        }
        if (z) {
            return "";
        }
        if (orCreateContext$default != null) {
            BulletMonitorContext.init$default(orCreateContext$default, tracertId, sdkType, null, 4, null);
        }
        return (orCreateContext$default == null || (monitorId = orCreateContext$default.getMonitorId()) == null) ? "" : monitorId;
    }

    public final void associateSession(BulletContext bulletContext, long initTime) {
        String safeGetQueryParameter;
        BulletMonitorContext remove;
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        if (supportAdvancedMonitor(String.valueOf(bulletContext.getLoadUri()))) {
            Uri loadUri = bulletContext.getLoadUri();
            if (loadUri != null && (safeGetQueryParameter = ExtKt.safeGetQueryParameter(loadUri, "__x_session_id")) != null && (remove = monitorContextMap.remove(safeGetQueryParameter)) != null) {
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "use oldMonitorContext with monitorId " + remove.getMonitorId(), null, null, 6, null);
                Intrinsics.checkNotNullExpressionValue(remove, "_monitorContext");
                bulletContext.setMonitorContext(remove);
                bulletContext.getOptimizeContext().init(remove.getCategory());
            }
            bulletContext.getMonitorContext().setSessionId(bulletContext.getSessionId());
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "Tracert associate sessionId " + bulletContext.getSessionId() + " with monitorId " + bulletContext.getMonitorContext().getMonitorId(), null, null, 6, null);
            if (bulletContext.getMonitorContext().getInUse()) {
                return;
            }
            bulletContext.getMonitorContext().init("undefine", "bullet", Long.valueOf(initTime));
        }
    }

    public final boolean injectCategory(String schema, String key, String value) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(key, value);
        Unit unit = Unit.INSTANCE;
        return inject(schema, linkedHashMap, null);
    }

    public final boolean injectMetrics(String schema, String key, long value) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(key, "key");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(key, Long.valueOf(value));
        Unit unit = Unit.INSTANCE;
        return inject(schema, null, linkedHashMap);
    }

    public final boolean inject(String schema, Map<String, ? extends Object> category, Map<String, ? extends Object> metrics) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        BulletMonitorContext orCreateContext = getOrCreateContext(schema, false);
        if (orCreateContext == null) {
            return false;
        }
        if (category == null) {
            category = MapsKt.emptyMap();
        }
        JSONObject jSONObject = new JSONObject(category);
        if (metrics == null) {
            metrics = MapsKt.emptyMap();
        }
        return orCreateContext.inject(jSONObject, new JSONObject(metrics));
    }

    public static /* synthetic */ void triggerReportFailedWithoutSchema$default(BulletTracert bulletTracert, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = "activitySDK";
        }
        bulletTracert.triggerReportFailedWithoutSchema(str, str2, str3, str4);
    }

    public final void triggerReportFailedWithoutSchema(String tracertId, String sdkType, String errorMessage, String errStage) {
        Intrinsics.checkNotNullParameter(tracertId, "tracertId");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        triggerReportFailedWithoutSchema(tracertId, sdkType, errorMessage, errStage, "default_bid");
    }

    public static /* synthetic */ void triggerReportFailedWithoutSchema$default(BulletTracert bulletTracert, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = "activitySDK";
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            str5 = "default_bid";
        }
        bulletTracert.triggerReportFailedWithoutSchema(str, str2, str6, str7, str5);
    }

    public final void triggerReportFailedWithoutSchema(String tracertId, String sdkType, String errorMessage, String errStage, String bid) {
        Intrinsics.checkNotNullParameter(tracertId, "tracertId");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ReliabilityReporter reliabilityReporter = ReliabilityReporter.INSTANCE;
        AbsBulletMonitorCallback.ErrStage errStage2 = AbsBulletMonitorCallback.ErrStage.Business;
        if (errorMessage == null) {
            errorMessage = "";
        }
        reliabilityReporter.reportLoadFail(errStage2, errorMessage, bid, tracertId, sdkType);
    }

    public static /* synthetic */ void triggerReport$default(BulletTracert bulletTracert, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = "activitySDK";
        }
        bulletTracert.triggerReport(str, z, str2, str3);
    }

    public final void triggerReport(String schema, boolean status, String errorMessage, String errStage) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        triggerReport(schema, status, errorMessage, errStage, "default_bid");
    }

    public static /* synthetic */ void triggerReport$default(BulletTracert bulletTracert, String str, boolean z, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = "activitySDK";
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = "default_bid";
        }
        bulletTracert.triggerReport(str, z, str5, str6, str4);
    }

    public final void triggerReport(String schema, boolean status, String errorMessage, String errStage, String bid) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(bid, "bid");
        BulletMonitorContext orCreateContext$default = getOrCreateContext$default(this, schema, false, 2, null);
        if (orCreateContext$default != null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "Tracert triggerReport " + orCreateContext$default.getMonitorId(), null, null, 6, null);
            if (status) {
                TimelineReporter.INSTANCE.reportReUseTimeline(orCreateContext$default.getCategory(), orCreateContext$default.getMetric(), bid);
            } else {
                ReliabilityReporter reliabilityReporter = ReliabilityReporter.INSTANCE;
                JSONObject category = orCreateContext$default.getCategory();
                JSONObject metric = orCreateContext$default.getMetric();
                AbsBulletMonitorCallback.ErrStage errStage2 = AbsBulletMonitorCallback.ErrStage.Business;
                if (errorMessage == null) {
                    errorMessage = "";
                }
                reliabilityReporter.reportLoadFail(schema, category, metric, errStage2, errorMessage, bid);
            }
            orCreateContext$default.setInUse(false);
        }
    }
}
