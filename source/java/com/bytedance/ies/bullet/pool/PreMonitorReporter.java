package com.bytedance.ies.bullet.pool;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.push.event.sync.ISignalReportConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PreMonitorReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bJ8\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\bJ8\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\bJM\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/pool/PreMonitorReporter;", "", "()V", "reportPreRenderClear", "", "schema", "Landroid/net/Uri;", ISignalReportConstants.KEY_REASON, "", "maxSize", "", "nowSize", "bid", "reportPreRenderCreate", "status", "failMessage", "reportPreRenderFetch", "identifier", "reportPreRenderPUse", "prerenderAllowed", "", "cacheTime", "", "freeMemory", "(Landroid/net/Uri;Ljava/lang/String;ZIILjava/lang/String;JLjava/lang/Long;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreMonitorReporter {
    public static final PreMonitorReporter INSTANCE = new PreMonitorReporter();

    private PreMonitorReporter() {
    }

    public final void reportPreRenderPUse(Uri schema, String status, boolean prerenderAllowed, int maxSize, int nowSize, String bid, long cacheTime, Long freeMemory) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ReportInfo reportInfo = new ReportInfo("bdx_monitor_xpool_use_pre_render", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(new BulletLoadUriIdentifier(schema));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        jSONObject.put("prerender_allow", prerenderAllowed);
        jSONObject.put("bid", bid);
        jSONObject.put("max_count", maxSize);
        jSONObject.put("remaining_count", maxSize - nowSize);
        jSONObject.put("cache_time", cacheTime);
        if (freeMemory != null) {
            freeMemory.longValue();
            jSONObject.put("freeMemory", freeMemory + "MB");
        }
        reportInfo.setCategory(jSONObject);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportPreRenderCreate(Uri schema, String status, int maxSize, int nowSize, String failMessage, String bid) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ReportInfo reportInfo = new ReportInfo("bdx_monitor_xpool_create_view", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(new BulletLoadUriIdentifier(schema));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        if (failMessage != null) {
            jSONObject.put("failed_message", failMessage);
        }
        jSONObject.put("max_count", maxSize);
        jSONObject.put("remaining_count", maxSize - nowSize);
        reportInfo.setCategory(jSONObject);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportPreRenderClear(Uri schema, String reason, int maxSize, int nowSize, String bid) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
        Intrinsics.checkNotNullParameter(bid, "bid");
        ReportInfo reportInfo = new ReportInfo("bdx_monitor_xpool_clear_view", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(new BulletLoadUriIdentifier(schema));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ISignalReportConstants.KEY_REASON, reason);
        jSONObject.put("max_count", maxSize);
        jSONObject.put("remaining_count", maxSize - nowSize);
        reportInfo.setCategory(jSONObject);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }

    public final void reportPreRenderFetch(Uri schema, String status, int maxSize, int nowSize, String identifier, String bid) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ReportInfo reportInfo = new ReportInfo("bdx_monitor_xpool_fetch_view", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setPageIdentifier(new BulletLoadUriIdentifier(schema));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", status);
        jSONObject.put("identifier", identifier);
        jSONObject.put("max_count", maxSize);
        jSONObject.put("remaining_count", maxSize - nowSize);
        reportInfo.setCategory(jSONObject);
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            iMonitorReportService.report(reportInfo);
        }
    }
}
