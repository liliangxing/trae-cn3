package com.ss.android.common.applog;

import com.bytedance.applog.log.AbsSingleton;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppLogNewMonitor {
    private static final AbsSingleton<MonitorV3Helper> monitor = new AbsSingleton<MonitorV3Helper>() { // from class: com.ss.android.common.applog.AppLogNewMonitor.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: create, reason: merged with bridge method [inline-methods] */
        public MonitorV3Helper m4147create(Object... objArr) {
            return new MonitorV3Helper();
        }
    };

    public static MonitorV3Helper getNewMonitor() {
        return (MonitorV3Helper) monitor.get(new Object[0]);
    }
}
