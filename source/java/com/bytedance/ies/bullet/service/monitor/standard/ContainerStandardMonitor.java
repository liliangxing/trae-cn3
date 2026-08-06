package com.bytedance.ies.bullet.service.monitor.standard;

import android.view.View;
import com.bytedance.android.monitorV2.standard.ContainerError;
import com.bytedance.android.monitorV2.standard.ContainerStandardApi;
import com.bytedance.android.monitorV2.standard.ContainerType;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerStandardMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004J8\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/standard/ContainerStandardMonitor;", "", "()V", "TYPE_LYNX", "", "TYPE_WEB", "moduleName", "schemaLogMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "addContext", "", "monitorId", "key", "value", "attach", "sessionId", "view", "Landroid/view/View;", "type", "batchCollect", "data", "Lorg/json/JSONObject;", "collect", "field", "enableCollect", "", "invalidateID", "reportError", "errCode", "errorMsg", "virtualAid", MetricConstant.FIELD_BIZ, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ContainerStandardMonitor {
    private static final String TYPE_LYNX = "lynx";
    private static final String TYPE_WEB = "web";
    private static final String moduleName = "Monitor-Standard";
    public static final ContainerStandardMonitor INSTANCE = new ContainerStandardMonitor();
    private static final ConcurrentHashMap<String, Integer> schemaLogMap = new ConcurrentHashMap<>(16);

    private ContainerStandardMonitor() {
    }

    private final boolean enableCollect() {
        MonitorReportService monitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(IMonitorReportService.class);
        if (monitorReportService == null) {
            monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
        }
        MonitorConfig config = monitorReportService.getConfig();
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        MonitorSettingsConfig monitorSettingsConfig = iBulletSettingsService != null ? (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class) : null;
        if (config.getLogSwitch()) {
            return true;
        }
        return monitorSettingsConfig != null ? monitorSettingsConfig.getLogSwitch() : true;
    }

    public final void collect(String sessionId, String field, Object data) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(data, "data");
        if (enableCollect()) {
            BulletLogger.INSTANCE.printLog("collect_" + sessionId + '_' + field, LogLevel.I, moduleName);
            if (Intrinsics.areEqual(field, "schema") || Intrinsics.areEqual(field, MetricConstant.ROUTER_OPEN)) {
                ConcurrentHashMap<String, Integer> concurrentHashMap = schemaLogMap;
                if (concurrentHashMap.contains(sessionId)) {
                    return;
                } else {
                    concurrentHashMap.put(sessionId, 1);
                }
            }
            if (data instanceof String) {
                ContainerStandardApi.INSTANCE.collectString(sessionId, field, (String) data);
                return;
            }
            if (data instanceof Boolean) {
                ContainerStandardApi.INSTANCE.collectBoolean(sessionId, field, ((Boolean) data).booleanValue());
                return;
            }
            if (data instanceof Integer) {
                ContainerStandardApi.INSTANCE.collectInt(sessionId, field, ((Integer) data).intValue());
            } else if (data instanceof Long) {
                ContainerStandardApi.INSTANCE.collectLong(sessionId, field, ((Long) data).longValue());
            } else {
                ContainerStandardApi.INSTANCE.collectString(sessionId, field, data.toString());
            }
        }
    }

    public final void batchCollect(String sessionId, JSONObject data) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(data, "data");
        ContainerStandardApi.INSTANCE.batchCollect(sessionId, data);
    }

    public final void attach(String sessionId, View view, String type) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
        if (enableCollect()) {
            BulletLogger.INSTANCE.printLog("attach_" + sessionId + '_' + type, LogLevel.I, moduleName);
            ContainerType containerType = Intrinsics.areEqual(type, "lynx") ? true : Intrinsics.areEqual(type, "web") ? new ContainerType(view, type) : null;
            if (containerType != null) {
                ContainerStandardApi.INSTANCE.attach(sessionId, containerType);
            }
        }
    }

    public final void invalidateID(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (enableCollect()) {
            BulletLogger.INSTANCE.printLog("invalidateID_" + sessionId, LogLevel.I, moduleName);
            ContainerStandardApi.INSTANCE.invalidateID(sessionId);
            schemaLogMap.remove(sessionId);
        }
    }

    public final void reportError(View view, String sessionId, int errCode, String errorMsg, String virtualAid, String biz) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(virtualAid, "virtualAid");
        Intrinsics.checkNotNullParameter(biz, MetricConstant.FIELD_BIZ);
        if (enableCollect()) {
            BulletLogger.INSTANCE.printLog("reportError_" + sessionId + '_' + errCode + '_' + errorMsg, LogLevel.I, moduleName);
            ContainerStandardApi.INSTANCE.reportContainerError(view, sessionId, new ContainerError(errCode, errorMsg, virtualAid, biz));
        }
    }

    public final void addContext(String monitorId, String key, String value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ContainerStandardApi.INSTANCE.addContext(monitorId, key, value);
    }
}
