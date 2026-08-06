package com.bytedance.ies.bullet.service.monitor.intercept;

import com.bytedance.android.monitorV2.base.IReportInterceptor;
import com.bytedance.ies.bullet.service.base.BulletMonitorIntercept;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: BulletSlardarIntercept.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/intercept/BulletSlardarIntercept;", "Lcom/bytedance/android/monitorV2/base/IReportInterceptor;", "()V", "onReport", "", "serviceName", "", "eventType", "containerType", "data", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletSlardarIntercept implements IReportInterceptor {
    public static final BulletSlardarIntercept INSTANCE = new BulletSlardarIntercept();

    private BulletSlardarIntercept() {
    }

    public void onReport(String serviceName, String eventType, String containerType, JSONObject data) {
        JSONObject optJSONObject;
        String str = null;
        JSONObject optJSONObject2 = data != null ? data.optJSONObject("extra") : null;
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("client_category")) != null) {
            str = optJSONObject.optString("_bid");
        }
        if (str == null) {
            str = "default_bid";
        }
        MonitorReportService monitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(str, IMonitorReportService.class);
        if (monitorReportService == null) {
            monitorReportService = MonitorReportService.INSTANCE.getFallbackDefault();
        }
        BulletMonitorIntercept intercept = monitorReportService.getConfig().getIntercept();
        if (intercept != null) {
            intercept.onReport(serviceName, eventType, containerType, data);
        }
    }
}
