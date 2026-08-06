package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import kotlin.Metadata;

/* compiled from: IMonitorReportService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IMonitorReportService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getMonitorConfig", "Lcom/bytedance/ies/bullet/service/base/MonitorConfig;", "report", "", "info", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IMonitorReportService extends IBulletService {
    MonitorConfig getMonitorConfig();

    void report(ReportInfo info);
}
