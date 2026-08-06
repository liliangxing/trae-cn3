package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.ICommonService;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLReportInfo;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.resourceloader.config.SessionInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.Identifier;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: RLReportController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/core/RLReportController;", "", "()V", "configMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getConfigMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "initRLConfig", "", "bid", "rlReportConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RLReportController {
    public static final RLReportController INSTANCE = new RLReportController();
    private static final ConcurrentHashMap<String, Boolean> configMap = new ConcurrentHashMap<>();

    private RLReportController() {
    }

    public final ConcurrentHashMap<String, Boolean> getConfigMap() {
        return configMap;
    }

    public final void initRLConfig(String bid) {
        if (bid == null) {
            bid = "default_bid";
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = configMap;
        if (concurrentHashMap.get(bid) == null || Intrinsics.areEqual(concurrentHashMap.get(bid), false)) {
            rlReportConfig(bid);
            concurrentHashMap.put(bid, true);
        }
    }

    private final void rlReportConfig(String bid) {
        RLLogger.INSTANCE.m21d("register rl report controller");
        final BulletLogger bulletLogger = BulletLogger.INSTANCE;
        bulletLogger.printLog("BulletCore init bid == " + bid, LogLevel.D, "XView");
        ResourceLoader.with$default(ResourceLoader.INSTANCE, bid, null, 2, null).getResourceConfig().setCommonService(new ICommonService() { // from class: com.bytedance.ies.bullet.core.RLReportController$rlReportConfig$1$1
            @Override // com.bytedance.ies.bullet.kit.resourceloader.monitor.ICommonService
            public void report(TaskConfig config, RLReportInfo info) {
                String url;
                Intrinsics.checkNotNullParameter(config, "config");
                Intrinsics.checkNotNullParameter(info, "info");
                IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(config.getMonitorBid(), IMonitorReportService.class);
                if (iMonitorReportService != null) {
                    ReportInfo reportInfo = new ReportInfo(info.getEventName(), null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
                    TaskContext taskContext = config.getTaskContext();
                    Identifier identifier = taskContext != null ? (Identifier) taskContext.getDependency(Identifier.class) : null;
                    if (identifier != null) {
                        reportInfo.setPageIdentifier(identifier);
                        reportInfo.setUrl(info.getUrl());
                    } else {
                        JSONObject category = info.getCategory();
                        if (category == null || (url = category.getString(SchemaConstants.QUERY_KEY_RES_URL)) == null) {
                            url = info.getUrl();
                        }
                        reportInfo.setUrl(url);
                    }
                    reportInfo.setPlatform(info.getPlatform());
                    reportInfo.setCategory(info.getCategory());
                    reportInfo.setMetrics(info.getMetrics());
                    reportInfo.setHighFrequency(info.getHighFrequency());
                    reportInfo.setCommon(info.getCommon());
                    reportInfo.setExtra(info.getExtra());
                    reportInfo.setVirtualAID(info.getVirtualAID());
                    reportInfo.setBizTag(info.getBizTag());
                    iMonitorReportService.report(reportInfo);
                }
            }
        });
        RLLogger.INSTANCE.setLogger(new Logger() { // from class: com.bytedance.ies.bullet.core.RLReportController$rlReportConfig$2
            @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
            /* renamed from: d */
            public void mo15d(String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                BulletLogger.this.printLog(msg, LogLevel.D, "XResourceLoader");
            }

            @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
            /* renamed from: w */
            public void mo18w(String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                BulletLogger.this.printLog(msg, LogLevel.W, "XResourceLoader");
            }

            @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
            /* renamed from: w */
            public void mo19w(String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                BulletLogger.this.printReject(tr, msg, "XResourceLoader");
            }

            @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
            /* renamed from: e */
            public void mo16e(String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                BulletLogger.this.printLog(msg, LogLevel.E, "XResourceLoader");
            }

            @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
            /* renamed from: e */
            public void mo17e(String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                BulletLogger.this.printReject(tr, msg, "XResourceLoader");
            }

            @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
            public void core(TaskConfig config, String msg) {
                SessionInfo sessionInfo;
                SessionInfo sessionInfo2;
                Intrinsics.checkNotNullParameter(config, "config");
                Intrinsics.checkNotNullParameter(msg, "msg");
                TaskContext taskContext = config.getTaskContext();
                if (taskContext != null && (sessionInfo = (SessionInfo) taskContext.getDependency(SessionInfo.class)) != null && sessionInfo.getSessionId() != null) {
                    BulletLogger bulletLogger2 = BulletLogger.this;
                    TaskContext taskContext2 = config.getTaskContext();
                    BulletLogger.printCoreLog$default(bulletLogger2, (taskContext2 == null || (sessionInfo2 = (SessionInfo) taskContext2.getDependency(SessionInfo.class)) == null) ? null : sessionInfo2.getSessionId(), msg, "XResourceLoader", null, 8, null);
                    return;
                }
                BulletLogger.this.printLog(msg, LogLevel.I, "XResourceLoader");
            }

            @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
            public void tridentCore(TaskConfig config, String msg, Map<String, ? extends Object> content) {
                SessionInfo sessionInfo;
                String sessionId;
                Intrinsics.checkNotNullParameter(config, "config");
                Intrinsics.checkNotNullParameter(msg, "msg");
                TaskContext taskContext = config.getTaskContext();
                if (taskContext == null || (sessionInfo = (SessionInfo) taskContext.getDependency(SessionInfo.class)) == null || (sessionId = sessionInfo.getSessionId()) == null) {
                    BulletLogger.this.printTridentLog(msg, (r17 & 2) != 0 ? null : content, (r17 & 4) != 0 ? LogLevel.I : LogLevel.I, (r17 & 8) != 0 ? "" : "XResourceLoader", null, (r17 & 32) != 0 ? "" : null, (r17 & 64) != 0 ? "" : null);
                } else {
                    BulletLogger.this.printTridentCoreLog(msg, (r15 & 2) != 0 ? null : content, (r15 & 4) != 0 ? LogLevel.I : LogLevel.I, (r15 & 8) != 0 ? "" : "XResourceLoader", (r15 & 16) != 0 ? "" : sessionId, (r15 & 32) != 0 ? "" : config.getResourceLoaderSession(), (r15 & 64) == 0 ? null : "");
                }
            }
        });
    }
}
