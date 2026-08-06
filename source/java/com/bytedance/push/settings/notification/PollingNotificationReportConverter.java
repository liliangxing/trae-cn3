package com.bytedance.push.settings.notification;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PollingNotificationReportConverter implements ITypeConverter<PollingNotificationReport>, IDefaultValueProvider<PollingNotificationReport> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public PollingNotificationReport mo236to(String str) {
        PollingNotificationReport pollingNotificationReport = (PollingNotificationReport) GsonUtils.from(str, PollingNotificationReport.class);
        if (pollingNotificationReport != null) {
            return pollingNotificationReport;
        }
        Logger.m271e(getClass().getSimpleName(), "PollingNotificationReport is null");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(PollingNotificationReport pollingNotificationReport) {
        return GsonUtils.toJson(pollingNotificationReport);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public PollingNotificationReport create() {
        return new PollingNotificationReport();
    }
}
