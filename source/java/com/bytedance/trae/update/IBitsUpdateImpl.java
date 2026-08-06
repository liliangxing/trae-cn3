package com.bytedance.trae.update;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.memory.dump.DumpFileController;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager;
import com.bytedance.trae.update.bits.impl.C0906R;
import com.bytedance.trae.update.dialogs.UpdateCheckDialog;
import com.bytedance.trae.update.dialogs.UpdateMainDialog;
import com.bytedance.trae.update.settings.UpdateSdkSettings;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.update.IAutoInstallApk;
import com.ss.android.update.ICurrentActivityCallback;
import com.ss.android.update.IEventReporter;
import com.ss.android.update.IRequestTagHeaderProvider;
import com.ss.android.update.IUpdateConfig;
import com.ss.android.update.IUpdateForceExit;
import com.ss.android.update.OnUpdateStatusChangedListener;
import com.ss.android.update.RequestTagHeaderManager;
import com.ss.android.update.UpdateConfig;
import com.ss.android.update.UpdateHelper;
import com.ss.android.update.UpdateLocalStrategy;
import com.ss.android.update.UpdateSDK;
import com.ss.android.update.UpdateStrategyInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IBitsUpdateImpl.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010!\u001a\u00020\u0007H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/trae/update/IBitsUpdateImpl;", "Lcom/bytedance/trae/update/IBitsUpdate;", "<init>", "()V", "saveFileDir", "", "sdkHasInit", "", "shouldCheckUpdate", "backGroundListener", "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "appCommonContext", "Lcom/bytedance/trae/update/TraeAppCommonContext;", "listener", "Lcom/ss/android/update/OnUpdateStatusChangedListener;", "checkUpdate", "", "autoCheck", "manualUpdateEnable", "autoCheckUpdate", "manualCheckUpdate", "tryInitSDK", "checkUpdateNow", "initSDK", "autoInstallApk", "file", "Ljava/io/File;", "authority", "createAutoInstallIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getSaveFilesDir", "isUpdating", "getUpdatePackageDir", "Companion", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IBitsUpdateImpl implements IBitsUpdate {
    private static final String TAG = "update_sdk";
    private ActivityStackManager.OnAppBackGroundListener backGroundListener;
    private OnUpdateStatusChangedListener listener;
    private String saveFileDir;
    private volatile boolean sdkHasInit;
    private boolean shouldCheckUpdate = true;
    private final TraeAppCommonContext appCommonContext = new TraeAppCommonContext();

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateConfig initSDK$lambda$7(UpdateConfig updateConfig) {
        return updateConfig;
    }

    @Override // com.bytedance.trae.update.IBitsUpdate
    public void checkUpdate(boolean autoCheck) {
        if (AppHost.Companion.getSupportCloudTest() || !UpdateSdkSettings.INSTANCE.getSdkUpdateEnable(true) || getSaveFilesDir() == null) {
            return;
        }
        if (autoCheck) {
            autoCheckUpdate();
        } else {
            manualCheckUpdate();
        }
    }

    @Override // com.bytedance.trae.update.IBitsUpdate
    public boolean manualUpdateEnable() {
        return UpdateSdkSettings.INSTANCE.getManualUpdateEnable(false);
    }

    private final void autoCheckUpdate() {
        if (this.shouldCheckUpdate) {
            this.shouldCheckUpdate = false;
            tryInitSDK();
            checkUpdateNow(true);
        }
    }

    private final void manualCheckUpdate() {
        tryInitSDK();
        UpdateHelper updateHelper = UpdateHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(updateHelper, "getInstance(...)");
        if (updateHelper.isUpdating()) {
            UpdateCheckDialog.INSTANCE.showProgressDialog();
        } else {
            checkUpdateNow(false);
        }
    }

    private final void tryInitSDK() {
        if (this.sdkHasInit) {
            return;
        }
        synchronized (this) {
            if (!this.sdkHasInit) {
                this.sdkHasInit = true;
                initSDK();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void checkUpdateNow(boolean autoCheck) {
        if (this.saveFileDir == null) {
            return;
        }
        final UpdateHelper updateHelper = UpdateHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(updateHelper, "getInstance(...)");
        updateHelper.setCustomUpdateDialog(UpdateMainDialog.INSTANCE, UpdateCheckDialog.INSTANCE);
        if (this.listener == null) {
            this.listener = new UpdateListener();
        }
        if (updateHelper.needPreDownload()) {
            updateHelper.startPreDownload();
        }
        updateHelper.startCheckUpdate(autoCheck ? 2 : 1, this.listener, autoCheck);
        ActivityStackManager.OnAppBackGroundListener onAppBackGroundListener = this.backGroundListener;
        if (onAppBackGroundListener == null) {
            onAppBackGroundListener = new ActivityStackManager.OnAppBackGroundListener() { // from class: com.bytedance.trae.update.IBitsUpdateImpl$checkUpdateNow$backListener$1$1
                public void onAppForeground() {
                }

                public void onAllActivityDestroyed() {
                    updateHelper.onExit();
                    this.shouldCheckUpdate = true;
                    updateHelper.onAllDialogDismiss();
                }

                public void onAppBackground() {
                    if (updateHelper.isForceUpdate()) {
                        this.shouldCheckUpdate = true;
                    }
                }
            };
            this.backGroundListener = onAppBackGroundListener;
        }
        AppHost.Companion.getActivityStackManager().addAppBackGroundListener(onAppBackGroundListener);
    }

    private final void initSDK() {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        UpdateSdkLogger updateSdkLogger = new UpdateSdkLogger();
        IEventReporter iEventReporter = new IEventReporter() { // from class: com.bytedance.trae.update.IBitsUpdateImpl$$ExternalSyntheticLambda0
            public final void onEvent(String str, JSONObject jSONObject) {
                IBitsUpdateImpl.initSDK$lambda$3(str, jSONObject);
            }
        };
        JsonObject updateFormalConfig = UpdateSdkSettings.INSTANCE.getUpdateFormalConfig();
        boolean asBoolean = (updateFormalConfig == null || (jsonElement3 = updateFormalConfig.get("new_strategy_enable")) == null) ? true : jsonElement3.getAsBoolean();
        int asInt = (updateFormalConfig == null || (jsonElement2 = updateFormalConfig.get("interval_version")) == null) ? 2 : jsonElement2.getAsInt();
        long asLong = (updateFormalConfig == null || (jsonElement = updateFormalConfig.get("update_delay_time")) == null) ? -1L : jsonElement.getAsLong();
        this.saveFileDir = getSaveFilesDir();
        final String str = AppHost.Companion.getApplication().getPackageName() + ".uri.key";
        UpdateStrategyInfo updateStrategyInfo = new UpdateStrategyInfo();
        updateStrategyInfo.updateNewStrategyEnable = asBoolean;
        updateStrategyInfo.intervalVersion = asInt;
        updateStrategyInfo.updateDelayTime = asLong;
        UpdateLocalStrategy updateLocalStrategy = new UpdateLocalStrategy();
        updateLocalStrategy.updateLocalStrategyEnable = true;
        final UpdateConfig build = new UpdateConfig.Builder().updateLocalStrategy(updateLocalStrategy).setAppCommonContext(this.appCommonContext).setIUpdateForceExit(new IUpdateForceExit() { // from class: com.bytedance.trae.update.IBitsUpdateImpl$$ExternalSyntheticLambda1
            public final void forceExitApp(Context context) {
                IBitsUpdateImpl.initSDK$lambda$4(IBitsUpdateImpl.this, context);
            }
        }).setICurrentActivityCallback(new ICurrentActivityCallback() { // from class: com.bytedance.trae.update.IBitsUpdateImpl$$ExternalSyntheticLambda2
            public final WeakReference getCurrentActivity() {
                WeakReference initSDK$lambda$5;
                initSDK$lambda$5 = IBitsUpdateImpl.initSDK$lambda$5();
                return initSDK$lambda$5;
            }
        }).setNotifyIcon(C0906R.drawable.trae_status_icon).setHideNotice(true).isUpdateActivityOff(true).setNotificationChannelName("App Update").setFormalAuthority(str).setUpdateStrategyInfo(updateStrategyInfo).dialogShowInterval(UpdateSdkSettings.INSTANCE.getDialogShowInterval(DumpFileController.HOUR)).newUiEnable(true).deviceId(IApplog.Companion.getDeviceId()).isLocalApp(false).setSaveFileDir(this.saveFileDir).setAutoInstallApk(new IAutoInstallApk() { // from class: com.bytedance.trae.update.IBitsUpdateImpl$$ExternalSyntheticLambda3
            public final void installApk(Context context, File file) {
                IBitsUpdateImpl.initSDK$lambda$6(IBitsUpdateImpl.this, str, context, file);
            }
        }).build();
        UpdateSDK.init(this.appCommonContext, new IUpdateConfig() { // from class: com.bytedance.trae.update.IBitsUpdateImpl$$ExternalSyntheticLambda4
            public final UpdateConfig getUpdateConfig() {
                UpdateConfig initSDK$lambda$7;
                initSDK$lambda$7 = IBitsUpdateImpl.initSDK$lambda$7(build);
                return initSDK$lambda$7;
            }
        }, updateSdkLogger, iEventReporter);
        RequestTagHeaderManager.setRequestTagHeaderProvider(new IRequestTagHeaderProvider() { // from class: com.bytedance.trae.update.IBitsUpdateImpl$$ExternalSyntheticLambda5
            public final Pair getRequestTagHeader() {
                Pair initSDK$lambda$8;
                initSDK$lambda$8 = IBitsUpdateImpl.initSDK$lambda$8();
                return initSDK$lambda$8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSDK$lambda$3(String str, JSONObject jSONObject) {
        IApplog.Companion companion = IApplog.Companion;
        Intrinsics.checkNotNull(str);
        companion.reportEvent(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSDK$lambda$4(IBitsUpdateImpl iBitsUpdateImpl, Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        iBitsUpdateImpl.shouldCheckUpdate = true;
        AppHost.Companion.getActivityStackManager().finishAllActivities();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeakReference initSDK$lambda$5() {
        return new WeakReference(AppHost.Companion.getActivityStackManager().getCurrentActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSDK$lambda$6(IBitsUpdateImpl iBitsUpdateImpl, String str, Context context, File file) {
        Intrinsics.checkNotNull(file);
        iBitsUpdateImpl.autoInstallApk(file, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair initSDK$lambda$8() {
        return new Pair("", "");
    }

    private final void autoInstallApk(File file, String authority) {
        ContextWrapper currentActivity = AppHost.Companion.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null) {
            currentActivity = AppHost.Companion.getApplication();
        }
        FLogger.INSTANCE.mo425d(TAG, "auto install apk context:" + currentActivity + ",file:" + file);
        currentActivity.startActivity(createAutoInstallIntent(currentActivity, file, authority));
    }

    private final Intent createAutoInstallIntent(Context context, File file, String authority) {
        Uri uriForFile = FileProvider.getUriForFile(context, authority, file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        intent.addFlags(268435457);
        return intent;
    }

    private final String getSaveFilesDir() {
        Application application = AppHost.Companion.getApplication();
        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(application, (String) null);
        Intrinsics.checkNotNullExpressionValue(externalFilesDirs, "getExternalFilesDirs(...)");
        String absolutePath = (externalFilesDirs.length == 0) ^ true ? new File(externalFilesDirs[0], MetricConstant.MONITOR_STAGE_UPDATE).getAbsolutePath() : null;
        if (absolutePath != null) {
            return absolutePath;
        }
        File externalCacheDir = application.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = application.getFilesDir();
        }
        if (externalCacheDir == null) {
            externalCacheDir = application.getCacheDir();
        }
        return externalCacheDir != null ? new File(externalCacheDir, MetricConstant.MONITOR_STAGE_UPDATE).getAbsolutePath() : absolutePath;
    }

    @Override // com.bytedance.trae.update.IBitsUpdate
    public boolean isUpdating() {
        tryInitSDK();
        return UpdateHelper.getInstance().isUpdating();
    }

    @Override // com.bytedance.trae.update.IBitsUpdate
    public String getUpdatePackageDir() {
        return getSaveFilesDir();
    }
}
