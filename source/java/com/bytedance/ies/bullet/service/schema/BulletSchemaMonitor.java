package com.bytedance.ies.bullet.service.schema;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import com.bytedance.push.interfaze.ISignalReportService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: BulletSchemaMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016JX\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/BulletSchemaMonitor;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;", "bid", "", "(Ljava/lang/String;)V", IFrontierMonitor.KEY_LOG, "", "message", "report", ISignalReportService.BODY_KEY_EVENT, "Lcom/bytedance/ies/bullet/service/schema/SchemaMonitorEvent;", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "info", "", "error", LynxMonitorService.KEY_METRICS, "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletSchemaMonitor implements ISchemaMonitor {
    public static final String MONITOR_EVENT_CONVERT = "bdx_monitor_schema_convert";
    public static final String MONITOR_EVENT_GENERATE = "bdx_monitor_schema_generate";
    private final String bid;

    /* compiled from: BulletSchemaMonitor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SchemaMonitorEvent.values().length];
            try {
                iArr[SchemaMonitorEvent.CONVERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SchemaMonitorEvent.GENERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BulletSchemaMonitor(String str) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMonitor
    public void report(SchemaMonitorEvent event, ISchemaData schemaData, Map<String, String> info, Map<String, String> error, Map<String, Long> metrics) {
        String str;
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        Intrinsics.checkNotNullParameter(info, "info");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            str = MONITOR_EVENT_CONVERT;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = MONITOR_EVENT_GENERATE;
        }
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(this.bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(str, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
            reportInfo.setUrl(schemaData.getInnerOriginUrl().toString());
            String host = schemaData.getHost();
            boolean z = false;
            if (host != null && StringsKt.contains$default(host, "webview", false, 2, (Object) null)) {
                z = true;
            }
            reportInfo.setPlatform(z ? "web" : "lynx");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : info.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (error != null) {
                for (Map.Entry<String, String> entry2 : error.entrySet()) {
                    jSONObject.put(entry2.getKey(), entry2.getValue());
                }
            }
            reportInfo.setCategory(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            if (metrics != null) {
                for (Map.Entry<String, Long> entry3 : metrics.entrySet()) {
                    jSONObject2.put(entry3.getKey(), entry3.getValue().longValue());
                }
            }
            reportInfo.setMetrics(jSONObject2);
            iMonitorReportService.report(reportInfo);
        }
        StringBuilder append = new StringBuilder(str).append('{');
        if (error != null) {
            for (Map.Entry<String, String> entry4 : error.entrySet()) {
                append.append(entry4.getKey()).append(':').append(entry4.getValue()).append(';');
            }
        }
        if (metrics != null) {
            for (Map.Entry<String, Long> entry5 : metrics.entrySet()) {
                append.append(entry5.getKey()).append(':').append(entry5.getValue().longValue()).append(';');
            }
        }
        append.append('}');
        String sb = append.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "message.toString()");
        log(sb);
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMonitor
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BulletLogger.INSTANCE.printLog(message, LogLevel.I, "XSchema");
    }
}
