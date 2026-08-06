package com.ss.android.update;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* loaded from: classes7.dex */
public class UpdateConfig {
    private String addedQuery;
    private AppCommonContext appContext;
    private IAutoInstallApk autoInstallApk;
    private boolean canAlphaBgDownload;
    private String deviceId;
    private long dialogShowInterval;
    private OnDownloadStatusChangedListener downloadStatusListener;
    private String formalAuthority;
    private ICurrentActivityCallback iCurrentActivityCallback;
    private IUpdateForceExit iUpdateForceExit;
    private boolean isHideNotice;
    private boolean isLandscapeEnabled;
    private boolean isLocalApp;
    private boolean isUpdateActivityOff;
    private boolean isUpdateEnabled;
    private String localAppPackageName;
    private ExecutorService mExecutorService;
    private boolean newUiEnable;
    private String notificationChannelName;
    private int notifyIcon;
    private String saveFileDir;
    private String updateActivityClassName;
    private UpdateCityInfo updateCityInfo;
    private UpdateLocalStrategy updateLocalStrategy;
    private UpdateStrategyInfo updateStrategyInfo;
    private boolean usePackageNameInCheckVersion;

    public UpdateConfig() {
        this.dialogShowInterval = 3600000L;
        this.usePackageNameInCheckVersion = true;
        this.addedQuery = "";
        this.canAlphaBgDownload = false;
        this.isUpdateEnabled = true;
        this.isLandscapeEnabled = false;
        this.isHideNotice = false;
    }

    private UpdateConfig(Builder builder) {
        this.dialogShowInterval = 3600000L;
        this.usePackageNameInCheckVersion = true;
        this.addedQuery = "";
        this.canAlphaBgDownload = false;
        this.isUpdateEnabled = true;
        this.isLandscapeEnabled = false;
        this.isHideNotice = false;
        this.notifyIcon = builder.notifyIcon;
        this.appContext = builder.appContext;
        this.formalAuthority = builder.formalAuthority;
        this.updateStrategyInfo = builder.updateStrategyInfo;
        this.iUpdateForceExit = builder.iUpdateForceExit;
        this.iCurrentActivityCallback = builder.iCurrentActivityCallback;
        this.updateActivityClassName = builder.updateActivityClassName;
        this.isLocalApp = builder.isLocalApp;
        this.updateCityInfo = builder.updateCityInfo;
        this.newUiEnable = builder.newUiEnable;
        this.updateLocalStrategy = builder.updateLocalStrategy;
        this.localAppPackageName = builder.localAppPackageName;
        this.deviceId = builder.deviceId;
        this.dialogShowInterval = builder.dialogShowInterval;
        this.mExecutorService = builder.executorService;
        this.isUpdateActivityOff = builder.isUpdateActivityOff;
        this.usePackageNameInCheckVersion = builder.usePackageNameInCheckVersion;
        this.addedQuery = builder.addedQuery;
        this.canAlphaBgDownload = builder.canAlphaBgDownload;
        this.isUpdateEnabled = builder.isUpdateEnabled;
        this.isLandscapeEnabled = builder.isLandscapeEnabled;
        this.notificationChannelName = builder.notificationChannelName;
        this.autoInstallApk = builder.autoInstallApk;
        this.downloadStatusListener = builder.downloadStatusListener;
        this.saveFileDir = builder.saveFileDir;
        this.isHideNotice = builder.isHideNotice;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {
        private AppCommonContext appContext;
        private IAutoInstallApk autoInstallApk;
        private String deviceId;
        private OnDownloadStatusChangedListener downloadStatusListener;
        private ExecutorService executorService;
        private String formalAuthority;
        private IUpdateForceExit iUpdateForceExit;
        private boolean isLocalApp;
        private boolean isUpdateActivityOff;
        private String localAppPackageName;
        private boolean newUiEnable;
        private String notificationChannelName;
        private int notifyIcon;
        private String saveFileDir;
        private String updateActivityClassName;
        private UpdateCityInfo updateCityInfo;
        private UpdateLocalStrategy updateLocalStrategy;
        private UpdateStrategyInfo updateStrategyInfo;
        private ICurrentActivityCallback iCurrentActivityCallback = new ICurrentActivityCallback() { // from class: com.ss.android.update.UpdateConfig.Builder.1
            @Override // com.ss.android.update.ICurrentActivityCallback
            public WeakReference<Activity> getCurrentActivity() {
                return null;
            }
        };
        private long dialogShowInterval = 3600000;
        private boolean usePackageNameInCheckVersion = true;
        private String addedQuery = "";
        private boolean canAlphaBgDownload = false;
        private boolean isUpdateEnabled = true;
        private boolean isLandscapeEnabled = false;
        private boolean isHideNotice = false;

        public Builder setNotifyIcon(int i) {
            this.notifyIcon = i;
            return this;
        }

        public Builder setAppCommonContext(AppCommonContext appCommonContext) {
            this.appContext = appCommonContext;
            return this;
        }

        public Builder setFormalAuthority(String str) {
            this.formalAuthority = str;
            return this;
        }

        public Builder setUpdateStrategyInfo(UpdateStrategyInfo updateStrategyInfo) {
            this.updateStrategyInfo = updateStrategyInfo;
            return this;
        }

        public Builder setIUpdateForceExit(IUpdateForceExit iUpdateForceExit) {
            this.iUpdateForceExit = iUpdateForceExit;
            return this;
        }

        public Builder setICurrentActivityCallback(ICurrentActivityCallback iCurrentActivityCallback) {
            this.iCurrentActivityCallback = iCurrentActivityCallback;
            return this;
        }

        public Builder setUpdateActivityClassName(String str) {
            this.updateActivityClassName = str;
            return this;
        }

        public Builder isUpdateActivityOff(boolean z) {
            this.isUpdateActivityOff = z;
            return this;
        }

        public Builder isLocalApp(boolean z) {
            this.isLocalApp = z;
            return this;
        }

        public Builder updateCityInfo(UpdateCityInfo updateCityInfo) {
            this.updateCityInfo = updateCityInfo;
            return this;
        }

        public Builder newUiEnable(boolean z) {
            this.newUiEnable = z;
            return this;
        }

        public Builder updateLocalStrategy(UpdateLocalStrategy updateLocalStrategy) {
            this.updateLocalStrategy = updateLocalStrategy;
            return this;
        }

        public Builder localAppPackageName(String str) {
            this.localAppPackageName = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder dialogShowInterval(long j) {
            this.dialogShowInterval = j;
            return this;
        }

        public Builder executorService(ExecutorService executorService) {
            this.executorService = executorService;
            return this;
        }

        public Builder usePackageNameInCheckVersion(boolean z) {
            this.usePackageNameInCheckVersion = z;
            return this;
        }

        public Builder addedQuery(String str) {
            this.addedQuery = str;
            return this;
        }

        public Builder canAlphaBgDownload(boolean z) {
            this.canAlphaBgDownload = z;
            return this;
        }

        public Builder setUpdateEnabled(boolean z) {
            this.isUpdateEnabled = z;
            return this;
        }

        public Builder isLandscapeEnabled(boolean z) {
            this.isLandscapeEnabled = z;
            return this;
        }

        public Builder setNotificationChannelName(String str) {
            this.notificationChannelName = str;
            return this;
        }

        public Builder setAutoInstallApk(IAutoInstallApk iAutoInstallApk) {
            this.autoInstallApk = iAutoInstallApk;
            return this;
        }

        public Builder setDownloadStatusListener(OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
            this.downloadStatusListener = onDownloadStatusChangedListener;
            return this;
        }

        public Builder setSaveFileDir(String str) {
            this.saveFileDir = str;
            return this;
        }

        public Builder setHideNotice(boolean z) {
            this.isHideNotice = z;
            return this;
        }

        public UpdateConfig build() {
            return new UpdateConfig(this);
        }
    }

    public int getNotifyIcon() {
        return this.notifyIcon;
    }

    public AppCommonContext getAppContext() {
        AppCommonContext appCommonContext = this.appContext;
        if (appCommonContext != null) {
            return appCommonContext;
        }
        throw new IllegalArgumentException("appContext can not null");
    }

    public String getFormalAuthority() {
        if (TextUtils.isEmpty(this.formalAuthority)) {
            throw new IllegalArgumentException("formalAuthority can not empty");
        }
        return this.formalAuthority;
    }

    public UpdateStrategyInfo getUpdateStrategyInfo() {
        UpdateStrategyInfo updateStrategyInfo = this.updateStrategyInfo;
        if (updateStrategyInfo != null) {
            return updateStrategyInfo;
        }
        throw new IllegalArgumentException("updateStrategyInfo can not null");
    }

    public IUpdateForceExit getiUpdateForceExit() {
        IUpdateForceExit iUpdateForceExit = this.iUpdateForceExit;
        if (iUpdateForceExit != null) {
            return iUpdateForceExit;
        }
        throw new IllegalArgumentException("iUpdateForceExit can not null");
    }

    public ICurrentActivityCallback getICurrentActivityCallback() {
        ICurrentActivityCallback iCurrentActivityCallback = this.iCurrentActivityCallback;
        if (iCurrentActivityCallback != null) {
            return iCurrentActivityCallback;
        }
        throw new IllegalArgumentException("iCurrentActivityCallback can not null");
    }

    public String getUpdateActivityClassName() {
        return this.updateActivityClassName;
    }

    public boolean isUpdateActivityOff() {
        return this.isUpdateActivityOff;
    }

    public boolean isLocalApp() {
        return this.isLocalApp;
    }

    public UpdateCityInfo getUpdateCityInfo() {
        return this.updateCityInfo;
    }

    public boolean isNewUiEnable() {
        return this.newUiEnable;
    }

    public UpdateLocalStrategy getUpdateLocalStrategy() {
        return this.updateLocalStrategy;
    }

    public String getLocalAppPackageName() {
        return this.localAppPackageName;
    }

    public String getDeviceId() {
        String str = this.deviceId;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("deviceId can not null");
    }

    public long getDialogShowInterval() {
        return this.dialogShowInterval;
    }

    public ExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    public boolean usePackageNameInCheckVersion() {
        return this.usePackageNameInCheckVersion;
    }

    public String getAddedQuery() {
        return this.addedQuery;
    }

    public boolean canAlphaBgDownload() {
        return this.canAlphaBgDownload;
    }

    public boolean isUpdateEnabled() {
        return this.isUpdateEnabled;
    }

    public boolean isLandscapeEnabled() {
        return this.isLandscapeEnabled;
    }

    public String getNotificationChannelName() {
        return this.notificationChannelName;
    }

    public IAutoInstallApk getAutoInstallApk() {
        return this.autoInstallApk;
    }

    public OnDownloadStatusChangedListener getDownloadStatusListener() {
        return this.downloadStatusListener;
    }

    public String getSaveFileDir() {
        return this.saveFileDir;
    }

    public boolean isHideNotice() {
        return this.isHideNotice;
    }
}
