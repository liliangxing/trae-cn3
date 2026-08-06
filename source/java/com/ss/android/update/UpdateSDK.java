package com.ss.android.update;

import com.bytedance.services.app.common.context.api.AppCommonContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateSDK {
    private static AppCommonContext appCommonContext;
    private static IUpdateConfig config;
    private static UpdateService updateService;

    public static void init(AppCommonContext appCommonContext2, IUpdateConfig iUpdateConfig, IUpdateLogger iUpdateLogger, IEventReporter iEventReporter) {
        Logger.setUpLogger(iUpdateLogger);
        EventReporter.setupReporter(iEventReporter);
        appCommonContext = appCommonContext2;
        config = iUpdateConfig;
        updateService = new UpdateServiceImpl();
    }

    public static IUpdateConfig getConfig() {
        return config;
    }

    public static AppCommonContext getAppCommonContext() {
        return appCommonContext;
    }

    public static UpdateService getUpdateService() {
        return updateService;
    }
}
