package com.bytedance.news.common.settings;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.news.common.settings.api.DebugTeller;
import com.bytedance.news.common.settings.api.RequestService;
import com.bytedance.news.common.settings.api.SettingsAbReportService;
import com.bytedance.news.common.settings.api.SettingsLogService;
import com.bytedance.news.common.settings.api.SettingsReportingService;
import com.bytedance.news.common.settings.api.SharedPreferencesService;
import com.bytedance.news.common.settings.api.StorageFactory;
import com.bytedance.news.common.settings.api.model.SettingsRequestParamsModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.bytedance.news.common.settings.internal.IConfig;
import com.bytedance.news.common.settings.storage.SharedFreferenceStorageFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class SettingsConfig implements IConfig {
    private Context context;
    private Extras extras;
    private RequestService requestService;

    private SettingsConfig(Context context, RequestService requestService, Extras extras) {
        this.context = context;
        this.requestService = requestService;
        this.extras = extras;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public Context getContext() {
        return this.context;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public RequestService getRequestService() {
        return this.requestService;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public StorageFactory getStorageFactory() {
        return this.extras.storageFactory;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public Executor getExecutor() {
        return this.extras.executor;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public long getUpdateInterval() {
        return this.extras.updateInterval;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public long getRetryInterval() {
        return this.extras.retryInterval;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public String getUpdateVersionCode() {
        return this.extras.updateVersionCode;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public SharedPreferences getSharedPreferences(Context context, String str, int i, boolean z) {
        if (this.extras.preferencesService != null) {
            return this.extras.preferencesService.getSharedPreferences(context, str, i, z);
        }
        return null;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public SettingsLogService getSettingsLogService() {
        return this.extras.settingsLogService;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public boolean isMainProcess() {
        return this.extras.isMainProcess;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public boolean useReflect() {
        return this.extras.useReflect;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public boolean useOneSpForAppSettings() {
        return this.extras.useOneSpForAppSettings;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public SettingsAbReportService getAbReportService() {
        return this.extras.settingsAbReportService;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public int getMaxAppSettingSpCount() {
        return this.extras.maxAppSettingSpCount;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public boolean isReportSettingsStack() {
        return this.extras.isReportSettingsStack;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public DebugTeller getDebugTeller() {
        return this.extras.debugTeller;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public SettingsRequestParamsModel getRequestParamsModel() {
        return this.extras.requestParamsModel;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public RequestV3Service getRequestV3Service() {
        return this.extras.requestV3Service;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public boolean ifRecordLocalSettingsDataInOneCache() {
        return this.extras.ifRecordLocalSettingsDataInOneCache;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public SettingsReportingService getSettingsReportingService() {
        return this.extras.settingsReportingService;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public boolean isReportSettingDiff() {
        return this.extras.reportSettingDiffEnable;
    }

    @Override // com.bytedance.news.common.settings.internal.IConfig
    public boolean isLocalSettingsDataAsync() {
        return this.extras.isLocalSettingsDataAsync;
    }

    public String getId() {
        return this.extras.id;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setId(String str) {
        this.extras.id = str;
    }

    public void setOneSpForAppSettings(boolean z) {
        this.extras.useOneSpForAppSettings = z;
    }

    public void setReportSettingsStack(boolean z) {
        this.extras.isReportSettingsStack = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class Extras {
        public DebugTeller debugTeller;
        public Executor executor;
        public String id;
        public boolean ifRecordLocalSettingsDataInOneCache;
        public boolean isLocalSettingsDataAsync;
        public boolean isMainProcess;
        public boolean isReportSettingsStack;
        public int maxAppSettingSpCount;
        public SharedPreferencesService preferencesService;
        public boolean reportSettingDiffEnable;
        public SettingsRequestParamsModel requestParamsModel;
        public RequestV3Service requestV3Service;
        public long retryInterval;
        public SettingsAbReportService settingsAbReportService;
        public SettingsLogService settingsLogService;
        public SettingsReportingService settingsReportingService;
        public StorageFactory storageFactory;
        public long updateInterval;
        public String updateVersionCode;
        public boolean useOneSpForAppSettings;
        public boolean useReflect;

        private Extras() {
            this.isMainProcess = true;
            this.useReflect = true;
        }
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private static final long DEFAULT_RETRY_INTERVAL = 120000;
        private static final long DEFAULT_UPDATE_INTERVAL = 3600000;
        private Context context;
        private Executor executor;
        private boolean ifRecordLocalSettingsDataInOneCache;
        private boolean isReportSettingsStack;
        private int maxAppSettingSpCount;
        private SharedPreferencesService preferencesService;
        private boolean reportSettingDiffEnable;
        private SettingsRequestParamsModel requestParamsModel;
        private RequestService requestService;
        private RequestV3Service requestV3Service;
        private SettingsAbReportService settingsAbReportService;
        private SettingsLogService settingsLogService;
        private SettingsReportingService settingsReportingService;
        private StorageFactory storageFactory;
        private String updateVersionCode;
        private boolean useOneSpForAppSettings;
        private long updateInterval = -1;
        private long retryInterval = -1;
        private boolean isMainProcess = true;
        private boolean useReflect = true;
        private DebugTeller debugTeller = null;
        private boolean isLocalSettingsDataAsync = true;

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder storageFactory(StorageFactory storageFactory) {
            this.storageFactory = storageFactory;
            return this;
        }

        public Builder requestService(RequestService requestService) {
            this.requestService = requestService;
            return this;
        }

        public Builder executor(Executor executor) {
            this.executor = executor;
            return this;
        }

        public Builder updateInterval(long j) {
            this.updateInterval = j;
            return this;
        }

        public Builder retryInterval(long j) {
            this.retryInterval = j;
            return this;
        }

        @Deprecated
        public Builder updateVersionCode(String str) {
            this.updateVersionCode = str;
            return this;
        }

        public Builder sharePreferencesService(SharedPreferencesService sharedPreferencesService) {
            this.preferencesService = sharedPreferencesService;
            return this;
        }

        public Builder settingsLogService(SettingsLogService settingsLogService) {
            this.settingsLogService = settingsLogService;
            return this;
        }

        public Builder isMainProcess(boolean z) {
            this.isMainProcess = z;
            return this;
        }

        public Builder useReflect(boolean z) {
            this.useReflect = z;
            return this;
        }

        public Builder useOneSpForAppSettings(boolean z) {
            this.useOneSpForAppSettings = z;
            return this;
        }

        public Builder setAbReportService(SettingsAbReportService settingsAbReportService) {
            this.settingsAbReportService = settingsAbReportService;
            return this;
        }

        public Builder maxAppSettingSpCount(int i) {
            this.maxAppSettingSpCount = i;
            return this;
        }

        public Builder isReportSettingsStack(boolean z) {
            this.isReportSettingsStack = z;
            return this;
        }

        public Builder debugTeller(DebugTeller debugTeller) {
            this.debugTeller = debugTeller;
            return this;
        }

        public Builder requestParamsModel(SettingsRequestParamsModel settingsRequestParamsModel) {
            this.requestParamsModel = settingsRequestParamsModel;
            return this;
        }

        public Builder requestV3Service(RequestV3Service requestV3Service) {
            this.requestV3Service = requestV3Service;
            return this;
        }

        public Builder ifRecordLocalSettingsDataInOneCache(boolean z) {
            this.ifRecordLocalSettingsDataInOneCache = z;
            return this;
        }

        public Builder settingsReportingService(SettingsReportingService settingsReportingService) {
            this.settingsReportingService = settingsReportingService;
            return this;
        }

        public Builder reportSettingDiffEnable(boolean z) {
            this.reportSettingDiffEnable = z;
            return this;
        }

        public Builder isLocalSettingsDataAsync(boolean z) {
            this.isLocalSettingsDataAsync = z;
            return this;
        }

        public SettingsConfig build() {
            if (this.context == null) {
                throw new IllegalArgumentException("context不能为空");
            }
            if (this.requestService == null) {
                throw new IllegalArgumentException("requestService不能为空");
            }
            if (this.storageFactory == null) {
                this.storageFactory = new SharedFreferenceStorageFactory();
            }
            if (this.executor == null) {
                this.executor = Executors.newCachedThreadPool();
            }
            if (this.updateInterval < 0) {
                this.updateInterval = 3600000L;
            }
            if (this.retryInterval < 0) {
                this.retryInterval = 120000L;
            }
            Extras extras = new Extras();
            extras.storageFactory = this.storageFactory;
            extras.executor = this.executor;
            extras.updateInterval = this.updateInterval;
            extras.retryInterval = this.retryInterval;
            extras.updateVersionCode = this.updateVersionCode;
            extras.preferencesService = this.preferencesService;
            extras.settingsLogService = this.settingsLogService;
            extras.isMainProcess = this.isMainProcess;
            extras.useReflect = this.useReflect;
            extras.useOneSpForAppSettings = this.useOneSpForAppSettings;
            extras.settingsAbReportService = this.settingsAbReportService;
            extras.maxAppSettingSpCount = this.maxAppSettingSpCount;
            extras.isReportSettingsStack = this.isReportSettingsStack;
            extras.debugTeller = this.debugTeller;
            extras.requestParamsModel = this.requestParamsModel;
            extras.requestV3Service = this.requestV3Service;
            extras.ifRecordLocalSettingsDataInOneCache = this.ifRecordLocalSettingsDataInOneCache;
            extras.settingsReportingService = this.settingsReportingService;
            extras.reportSettingDiffEnable = this.reportSettingDiffEnable;
            extras.isLocalSettingsDataAsync = this.isLocalSettingsDataAsync;
            if (this.context instanceof Application) {
                return new SettingsConfig(this.context, this.requestService, extras);
            }
            return new SettingsConfig(this.context.getApplicationContext(), this.requestService, extras);
        }
    }
}
