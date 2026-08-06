package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.news.common.settings.api.DebugTeller;
import com.bytedance.news.common.settings.api.RequestService;
import com.bytedance.news.common.settings.api.SettingsAbReportService;
import com.bytedance.news.common.settings.api.SettingsLogService;
import com.bytedance.news.common.settings.api.SettingsReportingService;
import com.bytedance.news.common.settings.api.StorageFactory;
import com.bytedance.news.common.settings.api.model.SettingsRequestParamsModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IConfig {
    SettingsAbReportService getAbReportService();

    Context getContext();

    DebugTeller getDebugTeller();

    Executor getExecutor();

    int getMaxAppSettingSpCount();

    SettingsRequestParamsModel getRequestParamsModel();

    RequestService getRequestService();

    RequestV3Service getRequestV3Service();

    long getRetryInterval();

    SettingsLogService getSettingsLogService();

    SettingsReportingService getSettingsReportingService();

    SharedPreferences getSharedPreferences(Context context, String str, int i, boolean z);

    StorageFactory getStorageFactory();

    long getUpdateInterval();

    String getUpdateVersionCode();

    boolean ifRecordLocalSettingsDataInOneCache();

    boolean isLocalSettingsDataAsync();

    boolean isMainProcess();

    boolean isReportSettingDiff();

    boolean isReportSettingsStack();

    boolean useOneSpForAppSettings();

    boolean useReflect();
}
