package com.bytedance.ies.bullet.service.monitor;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.webview.IHybridMonitor;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletMonitorIntercept;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.IReporter;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.Identifier;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.monitor.intercept.BulletSlardarIntercept;
import com.bytedance.ies.bullet.service.monitor.intercept.BulletTeaReporter;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MonitorReportService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0017\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J2\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/MonitorReportService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/IMonitorReportService;", "reporter", "Lcom/bytedance/ies/bullet/service/base/IReporter;", "config", "Lcom/bytedance/ies/bullet/service/base/MonitorConfig;", "(Lcom/bytedance/ies/bullet/service/base/IReporter;Lcom/bytedance/ies/bullet/service/base/MonitorConfig;)V", "(Lcom/bytedance/ies/bullet/service/base/MonitorConfig;)V", "singleExecutorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "checkFormat", "", "info", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "getMonitorConfig", "onBeforeRealReport", "report", "mergeCategory", "Lorg/json/JSONObject;", "platform", "", "url", "identifier", "Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MonitorReportService extends BaseBulletService implements IMonitorReportService {
    private static final int FULL_SAMPLE_LEVEL = 0;
    private static final int LUCKY_SPECIAL_SAMPLE_LEVEL = 6;
    private static final int P2_SAMPLE_LEVEL = 2;
    private static final String moduleName = "Monitor-Report";
    private final MonitorConfig config;
    private final ExecutorService singleExecutorService;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<MonitorReportService> FallbackDefault$delegate = LazyKt.lazy(new Function0<MonitorReportService>() { // from class: com.bytedance.ies.bullet.service.monitor.MonitorReportService$Companion$FallbackDefault$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MonitorReportService m559invoke() {
            MonitorConfig monitorConfig = new MonitorConfig(null, 1, null);
            try {
                final Method method = Class.forName("com.ss.android.common.lib.AppLogNewUtils").getMethod("onEventV3", String.class, JSONObject.class);
                monitorConfig.setTeaReporter(new Function2<String, JSONObject, Unit>() { // from class: com.bytedance.ies.bullet.service.monitor.MonitorReportService$Companion$FallbackDefault$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((String) obj, (JSONObject) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String str, JSONObject jSONObject) {
                        try {
                            method.invoke(null, str, jSONObject);
                        } catch (Exception unused) {
                            BulletLogger.INSTANCE.printLog("default tea reporter failed", LogLevel.E, "Monitor-Report");
                        }
                    }
                });
                BulletLogger.INSTANCE.printLog("hook default tea reporter success: com.ss.android.common.lib.AppLogNewUtils.onEventV3", LogLevel.I, "Monitor-Report");
            } catch (Exception unused) {
                BulletLogger.INSTANCE.printLog("hook default tea reporter failed: com.ss.android.common.lib.AppLogNewUtils.onEventV3", LogLevel.E, "Monitor-Report");
                if (BulletEnv.INSTANCE.getInstance().getDebuggable()) {
                    HybridMultiMonitor.getInstance().customReport(new CustomInfo.Builder("bdx_monitor_tea_reporter_inject").setBid("bullet_custom_bid").setSample(0).build());
                }
            }
            return new MonitorReportService(monitorConfig);
        }
    });

    @Deprecated(message = "仅兼容 Lucky, 请勿使用")
    public void onBeforeRealReport(ReportInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
    }

    public MonitorReportService(MonitorConfig monitorConfig) {
        Intrinsics.checkNotNullParameter(monitorConfig, "config");
        this.config = monitorConfig;
        HybridMultiMonitor.getInstance().registerReportInterceptor(BulletSlardarIntercept.INSTANCE);
        this.singleExecutorService = Executors.newSingleThreadExecutor();
    }

    /* compiled from: MonitorReportService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/MonitorReportService$Companion;", "", "()V", "FULL_SAMPLE_LEVEL", "", "FallbackDefault", "Lcom/bytedance/ies/bullet/service/monitor/MonitorReportService;", "getFallbackDefault", "()Lcom/bytedance/ies/bullet/service/monitor/MonitorReportService;", "FallbackDefault$delegate", "Lkotlin/Lazy;", "LUCKY_SPECIAL_SAMPLE_LEVEL", "P2_SAMPLE_LEVEL", "moduleName", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MonitorReportService getFallbackDefault() {
            return (MonitorReportService) MonitorReportService.FallbackDefault$delegate.getValue();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "不推荐使用 reporter/config.customReporter，推荐使用 config.intercept")
    public MonitorReportService(final IReporter iReporter, MonitorConfig monitorConfig) {
        this(monitorConfig);
        Intrinsics.checkNotNullParameter(iReporter, "reporter");
        Intrinsics.checkNotNullParameter(monitorConfig, "config");
        monitorConfig.setCustomReporter(new Function4<String, Integer, JSONObject, JSONObject, Unit>() { // from class: com.bytedance.ies.bullet.service.monitor.MonitorReportService.1
            {
                super(4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((String) obj, ((Number) obj2).intValue(), (JSONObject) obj3, (JSONObject) obj4);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
                IReporter.this.report(str, i, jSONObject, jSONObject2);
            }
        });
    }

    @Override // com.bytedance.ies.bullet.service.base.IMonitorReportService
    /* renamed from: getMonitorConfig, reason: from getter */
    public MonitorConfig getConfig() {
        return this.config;
    }

    @Override // com.bytedance.ies.bullet.service.base.IMonitorReportService
    public void report(final ReportInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        MonitorSettingsConfig monitorSettingsConfig = iBulletSettingsService != null ? (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class) : null;
        if (this.config.getLogSwitch()) {
            boolean z = false;
            if (monitorSettingsConfig != null && !monitorSettingsConfig.getLogSwitch()) {
                z = true;
            }
            if (!z) {
                this.singleExecutorService.submit(new Runnable() { // from class: com.bytedance.ies.bullet.service.monitor.MonitorReportService$report$1
                    /* JADX WARN: Removed duplicated region for block: B:21:0x00ae A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:37:0x0103 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x0126 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:48:0x015c A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:51:0x0176  */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x018e A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x01f3 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:68:0x020b A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:69:0x012d A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:76:0x0147 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:3:0x0005, B:5:0x0025, B:6:0x002b, B:8:0x003d, B:9:0x0043, B:11:0x007f, B:13:0x008b, B:15:0x0096, B:17:0x009e, B:19:0x00a6, B:21:0x00ae, B:22:0x00c3, B:24:0x00cc, B:26:0x00dc, B:28:0x00e7, B:29:0x00ed, B:32:0x00f4, B:35:0x00f7, B:37:0x0103, B:38:0x0108, B:40:0x011a, B:45:0x0126, B:46:0x0154, B:48:0x015c, B:49:0x0166, B:52:0x0177, B:55:0x0186, B:57:0x018e, B:58:0x0194, B:60:0x01f3, B:62:0x01ff, B:63:0x0207, B:64:0x0218, B:68:0x020b, B:69:0x012d, B:71:0x013b, B:76:0x0147, B:81:0x0085), top: B:2:0x0005 }] */
                    /* JADX WARN: Removed duplicated region for block: B:77:0x0152  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void run() {
                        String url;
                        String str;
                        JSONObject category;
                        JSONObject common;
                        MonitorConfig monitorConfig;
                        BulletMonitorIntercept intercept;
                        String bizTag;
                        boolean z2;
                        MonitorConfig monitorConfig2;
                        boolean z3;
                        String str2;
                        MonitorConfig monitorConfig3;
                        String virtualAID;
                        Integer sampleLevel;
                        MonitorConfig monitorConfig4;
                        MonitorConfig monitorConfig5;
                        MonitorConfig monitorConfig6;
                        MonitorConfig monitorConfig7;
                        MonitorConfig monitorConfig8;
                        MonitorConfig monitorConfig9;
                        try {
                            BulletLogger bulletLogger = BulletLogger.INSTANCE;
                            StringBuilder append = new StringBuilder("report ").append(ReportInfo.this.getEventName()).append(", url ");
                            Identifier pageIdentifier = ReportInfo.this.getPageIdentifier();
                            StringBuilder append2 = append.append(pageIdentifier != null ? pageIdentifier.getIdentifierUrl() : null).append(", fullUrl ");
                            Identifier pageIdentifier2 = ReportInfo.this.getPageIdentifier();
                            bulletLogger.printLog(append2.append(pageIdentifier2 != null ? pageIdentifier2.getFullUrl() : null).append(", category ").append(ReportInfo.this.getCategory()).append(" metrics  ").append(ReportInfo.this.getMetrics()).toString(), LogLevel.I, "Monitor-Report");
                            this.checkFormat(ReportInfo.this);
                            ReportInfo reportInfo = ReportInfo.this;
                            Identifier pageIdentifier3 = reportInfo.getPageIdentifier();
                            if (pageIdentifier3 == null || (url = pageIdentifier3.getIdentifierUrl()) == null) {
                                url = ReportInfo.this.getUrl();
                            }
                            reportInfo.setUrl(url);
                            String platform = ReportInfo.this.getPlatform();
                            if (platform == null) {
                                Identifier pageIdentifier4 = ReportInfo.this.getPageIdentifier();
                                if (pageIdentifier4 == null) {
                                    str = null;
                                    category = ReportInfo.this.getCategory();
                                    if (category != null) {
                                        MonitorReportService monitorReportService = this;
                                        monitorConfig9 = monitorReportService.config;
                                        monitorReportService.mergeCategory(category, monitorConfig9, str, ReportInfo.this.getUrl(), ReportInfo.this.getPageIdentifier());
                                    }
                                    common = ReportInfo.this.getCommon();
                                    if (common != null) {
                                        monitorConfig8 = this.config;
                                        JSONObject wrap = JsonUtilsKt.wrap(common, monitorConfig8.getCommon());
                                        if (wrap != null) {
                                            Identifier pageIdentifier5 = ReportInfo.this.getPageIdentifier();
                                            wrap.put("platform", (pageIdentifier5 != null ? pageIdentifier5.getKitType() : null) == KitType.LYNX ? 3 : 0);
                                        }
                                    }
                                    monitorConfig = this.config;
                                    intercept = monitorConfig.getIntercept();
                                    if (intercept != null) {
                                        intercept.onReport(ReportInfo.this);
                                    }
                                    this.onBeforeRealReport(ReportInfo.this);
                                    bizTag = ReportInfo.this.getBizTag();
                                    if (bizTag != null && bizTag.length() != 0) {
                                        z2 = false;
                                        if (z2) {
                                            str2 = ReportInfo.this.getBizTag();
                                        } else {
                                            monitorConfig2 = this.config;
                                            String bizTag2 = monitorConfig2.getBizTag();
                                            if (bizTag2 != null && bizTag2.length() != 0) {
                                                z3 = false;
                                                if (z3) {
                                                    monitorConfig3 = this.config;
                                                    str2 = monitorConfig3.getBizTag();
                                                } else {
                                                    str2 = "bullet_custom_bid";
                                                }
                                            }
                                            z3 = true;
                                            if (z3) {
                                            }
                                        }
                                        virtualAID = ReportInfo.this.getVirtualAID();
                                        if (virtualAID == null) {
                                            monitorConfig7 = this.config;
                                            virtualAID = monitorConfig7.getVirtualAID();
                                        }
                                        int i = Intrinsics.areEqual(ReportInfo.this.getHighFrequency(), true) ? 2 : 0;
                                        if (Intrinsics.areEqual(this.getBid(), BidConstants.LUCKY)) {
                                            i = 6;
                                        }
                                        sampleLevel = ReportInfo.this.getSampleLevel();
                                        if (sampleLevel != null) {
                                            i = sampleLevel.intValue();
                                        }
                                        CustomInfo.Builder monitorId = new CustomInfo.Builder(ReportInfo.this.getEventName()).setUrl(ReportInfo.this.getUrl()).setCategory(ReportInfo.this.getCategory()).setMetric(ReportInfo.this.getMetrics()).setExtra(ReportInfo.this.getExtra()).setCommon(ReportInfo.this.getCommon()).setBid(str2).setVirtualAID(virtualAID).setSample(i).setMonitorId(ReportInfo.this.getMonitorId());
                                        monitorConfig4 = this.config;
                                        if (monitorConfig4.getCustomReporter() == null) {
                                            monitorConfig6 = this.config;
                                            final Function4<String, Integer, JSONObject, JSONObject, Unit> customReporter = monitorConfig6.getCustomReporter();
                                            monitorId.setMonitor(customReporter != null ? new IHybridMonitor(customReporter) { // from class: com.bytedance.ies.bullet.service.monitor.MonitorReportService$sam$com_bytedance_android_monitorV2_webview_IHybridMonitor$0
                                                private final /* synthetic */ Function4 function;

                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    Intrinsics.checkNotNullParameter(customReporter, "function");
                                                    this.function = customReporter;
                                                }

                                                public final /* synthetic */ void monitorStatusAndDuration(String str3, int i2, JSONObject jSONObject, JSONObject jSONObject2) {
                                                    this.function.invoke(str3, Integer.valueOf(i2), jSONObject, jSONObject2);
                                                }
                                            } : null);
                                        } else {
                                            BulletTeaReporter bulletTeaReporter = BulletTeaReporter.INSTANCE;
                                            monitorConfig5 = this.config;
                                            bulletTeaReporter.reportTea(monitorConfig5, ReportInfo.this, str2, virtualAID);
                                        }
                                        HybridMultiMonitor.getInstance().customReport(monitorId.build());
                                    }
                                    z2 = true;
                                    if (z2) {
                                    }
                                    virtualAID = ReportInfo.this.getVirtualAID();
                                    if (virtualAID == null) {
                                    }
                                    if (Intrinsics.areEqual(ReportInfo.this.getHighFrequency(), true)) {
                                    }
                                    if (Intrinsics.areEqual(this.getBid(), BidConstants.LUCKY)) {
                                    }
                                    sampleLevel = ReportInfo.this.getSampleLevel();
                                    if (sampleLevel != null) {
                                    }
                                    CustomInfo.Builder monitorId2 = new CustomInfo.Builder(ReportInfo.this.getEventName()).setUrl(ReportInfo.this.getUrl()).setCategory(ReportInfo.this.getCategory()).setMetric(ReportInfo.this.getMetrics()).setExtra(ReportInfo.this.getExtra()).setCommon(ReportInfo.this.getCommon()).setBid(str2).setVirtualAID(virtualAID).setSample(i).setMonitorId(ReportInfo.this.getMonitorId());
                                    monitorConfig4 = this.config;
                                    if (monitorConfig4.getCustomReporter() == null) {
                                    }
                                    HybridMultiMonitor.getInstance().customReport(monitorId2.build());
                                }
                                platform = pageIdentifier4.getStatisticPlatform();
                            }
                            str = platform;
                            category = ReportInfo.this.getCategory();
                            if (category != null) {
                            }
                            common = ReportInfo.this.getCommon();
                            if (common != null) {
                            }
                            monitorConfig = this.config;
                            intercept = monitorConfig.getIntercept();
                            if (intercept != null) {
                            }
                            this.onBeforeRealReport(ReportInfo.this);
                            bizTag = ReportInfo.this.getBizTag();
                            if (bizTag != null) {
                                z2 = false;
                                if (z2) {
                                }
                                virtualAID = ReportInfo.this.getVirtualAID();
                                if (virtualAID == null) {
                                }
                                if (Intrinsics.areEqual(ReportInfo.this.getHighFrequency(), true)) {
                                }
                                if (Intrinsics.areEqual(this.getBid(), BidConstants.LUCKY)) {
                                }
                                sampleLevel = ReportInfo.this.getSampleLevel();
                                if (sampleLevel != null) {
                                }
                                CustomInfo.Builder monitorId22 = new CustomInfo.Builder(ReportInfo.this.getEventName()).setUrl(ReportInfo.this.getUrl()).setCategory(ReportInfo.this.getCategory()).setMetric(ReportInfo.this.getMetrics()).setExtra(ReportInfo.this.getExtra()).setCommon(ReportInfo.this.getCommon()).setBid(str2).setVirtualAID(virtualAID).setSample(i).setMonitorId(ReportInfo.this.getMonitorId());
                                monitorConfig4 = this.config;
                                if (monitorConfig4.getCustomReporter() == null) {
                                }
                                HybridMultiMonitor.getInstance().customReport(monitorId22.build());
                            }
                            z2 = true;
                            if (z2) {
                            }
                            virtualAID = ReportInfo.this.getVirtualAID();
                            if (virtualAID == null) {
                            }
                            if (Intrinsics.areEqual(ReportInfo.this.getHighFrequency(), true)) {
                            }
                            if (Intrinsics.areEqual(this.getBid(), BidConstants.LUCKY)) {
                            }
                            sampleLevel = ReportInfo.this.getSampleLevel();
                            if (sampleLevel != null) {
                            }
                            CustomInfo.Builder monitorId222 = new CustomInfo.Builder(ReportInfo.this.getEventName()).setUrl(ReportInfo.this.getUrl()).setCategory(ReportInfo.this.getCategory()).setMetric(ReportInfo.this.getMetrics()).setExtra(ReportInfo.this.getExtra()).setCommon(ReportInfo.this.getCommon()).setBid(str2).setVirtualAID(virtualAID).setSample(i).setMonitorId(ReportInfo.this.getMonitorId());
                            monitorConfig4 = this.config;
                            if (monitorConfig4.getCustomReporter() == null) {
                            }
                            HybridMultiMonitor.getInstance().customReport(monitorId222.build());
                        } catch (Exception e) {
                            BulletLogger.INSTANCE.printLog("report failed, " + e.getMessage(), LogLevel.E, "Monitor-Report");
                        }
                    }
                });
                return;
            }
        }
        BulletLogger.INSTANCE.printLog("report blocked: config " + this.config.getLogSwitch() + ", settings " + (monitorSettingsConfig != null ? Boolean.valueOf(monitorSettingsConfig.getLogSwitch()) : null), LogLevel.I, moduleName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkFormat(ReportInfo info) {
        if (info.getCategory() == null) {
            info.setCategory(new JSONObject());
        }
        if (info.getMetrics() == null) {
            info.setMetrics(new JSONObject());
        }
        if (info.getCommon() == null) {
            info.setCommon(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject mergeCategory(JSONObject jSONObject, MonitorConfig monitorConfig, String str, String str2, Identifier identifier) {
        JSONObject extraMonitorParams;
        jSONObject.put("_bid", getBid());
        jSONObject.put("_container", monitorConfig.getContainerName());
        jSONObject.put("_bullet_sdk_version", "9.0.0");
        jSONObject.put("hybrid_platform", str);
        jSONObject.put("url", str2);
        jSONObject.put("_full_url", identifier != null ? identifier.getFullUrl() : null);
        if (identifier != null && (extraMonitorParams = identifier.getExtraMonitorParams()) != null) {
            JsonUtilsKt.wrap(jSONObject, extraMonitorParams);
        }
        return JsonUtilsKt.wrap(jSONObject, monitorConfig.getCategory());
    }
}
