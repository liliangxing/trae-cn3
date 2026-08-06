package com.bytedance.news.common.service.manager;

import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.bytedance.trae.apm.impl.ILaunchTraceImpl;
import com.bytedance.trae.settings.impl.SettingsConfigProviderImpl;
import com.service.middleware.applog.ApplogService;
import com.ss.android.common.applog.ApplogServiceImpl;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ServiceFinder {
    public static <T> T findService(Class<T> cls) {
        if (cls == ApplogService.class) {
            return (T) new ApplogServiceImpl();
        }
        if (cls == SettingsConfigProvider.class) {
            return (T) new SettingsConfigProviderImpl();
        }
        if (cls == ILaunchTrace.class) {
            return (T) new ILaunchTraceImpl();
        }
        return null;
    }
}
