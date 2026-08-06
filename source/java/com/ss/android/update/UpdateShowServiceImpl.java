package com.ss.android.update;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.common.dialog.AlertDialog;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateShowServiceImpl implements WeakHandler.IHandler {
    private static final String KEY_HINT_VERSION_DELAY_DAYS = "hint_version_delay_days";
    private static final String KEY_LAST_HINT_TIME = "last_hint_time";
    private static final String KEY_LAST_HINT_VERSION = "last_hint_version";
    private static final String KEY_PRE_DOWNLOAD_DELAY_DAYS = "pre_download_delay_days";
    private static final String KEY_PRE_DOWNLOAD_DELAY_SECOND = "pre_download_delay_second";
    private static final String KEY_PRE_DOWNLOAD_START_TIME = "pre_download_start_time";
    private static final String KEY_PRE_DOWNLOAD_VERSION = "pre_download_version";
    private static final String TAG = "UpdateShowServiceImpl";
    private int mHintVersionDelayDays;
    private IUpdateConfig mIUpdateConfig;
    private int mLastHintVersion;
    private long mLastHintVersionTime;
    private int mPreDownloadDelayDays;
    private long mPreDownloadStartTime;
    private int mPreDownloadVersion;
    private WeakReference<IUpdateCheckDialog> mUpdateCheckDialogs;
    private long mPreDownloadDelaySecond = -1;
    private WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    private UpdateService mUpdateService = UpdateSDK.getUpdateService();

    public void handleMsg(Message message) {
    }

    public void tryShowBigDialog(final boolean z) {
        WeakReference<Activity> currentActivity;
        final Activity activity;
        IUpdateConfig config = UpdateSDK.getConfig();
        this.mIUpdateConfig = config;
        final UpdateStrategyInfo updateStrategyInfo = config.getUpdateConfig().getUpdateStrategyInfo();
        if (updateStrategyInfo == null || (currentActivity = this.mIUpdateConfig.getUpdateConfig().getICurrentActivityCallback().getCurrentActivity()) == null || (activity = currentActivity.get()) == null || activity.isFinishing() || !this.mUpdateService.isCurrentVersionOut()) {
            return;
        }
        if (com.bytedance.common.utility.Logger.debug()) {
            com.bytedance.common.utility.Logger.i(TAG, "tryShowBigDialog");
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.ss.android.update.UpdateShowServiceImpl.1
            /* JADX WARN: Removed duplicated region for block: B:35:0x01d6  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0216  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str;
                String str2;
                long j;
                if (activity.isFinishing()) {
                    return;
                }
                UpdatePrefHelper updatePrefHelper = UpdatePrefHelper.getInstance(activity);
                long currentTimeMillis = System.currentTimeMillis();
                int versionCode = UpdateShowServiceImpl.this.mUpdateService.getVersionCode();
                UpdateShowServiceImpl.this.mPreDownloadVersion = updatePrefHelper.getPref(UpdateShowServiceImpl.KEY_PRE_DOWNLOAD_VERSION, 0);
                UpdateShowServiceImpl.this.mPreDownloadDelayDays = updatePrefHelper.getPref(UpdateShowServiceImpl.KEY_PRE_DOWNLOAD_DELAY_DAYS, 0);
                UpdateShowServiceImpl.this.mPreDownloadDelaySecond = updatePrefHelper.getPref(UpdateShowServiceImpl.KEY_PRE_DOWNLOAD_DELAY_SECOND, -1L);
                UpdateShowServiceImpl.this.mPreDownloadStartTime = updatePrefHelper.getPref(UpdateShowServiceImpl.KEY_PRE_DOWNLOAD_START_TIME, 0L);
                UpdateShowServiceImpl.this.mLastHintVersion = updatePrefHelper.getPref(UpdateShowServiceImpl.KEY_LAST_HINT_VERSION, 0);
                UpdateShowServiceImpl.this.mHintVersionDelayDays = updatePrefHelper.getPref(UpdateShowServiceImpl.KEY_HINT_VERSION_DELAY_DAYS, 0);
                UpdateShowServiceImpl.this.mLastHintVersionTime = updatePrefHelper.getPref(UpdateShowServiceImpl.KEY_LAST_HINT_TIME, 0L);
                if (UpdateShowServiceImpl.this.mUpdateService.needPreDownload()) {
                    if (versionCode != UpdateShowServiceImpl.this.mPreDownloadVersion) {
                        UpdateShowServiceImpl.this.mPreDownloadVersion = versionCode;
                        UpdateShowServiceImpl updateShowServiceImpl = UpdateShowServiceImpl.this;
                        updateShowServiceImpl.mPreDownloadDelayDays = updateShowServiceImpl.mUpdateService.getPreDownloadDelayDays();
                        UpdateShowServiceImpl updateShowServiceImpl2 = UpdateShowServiceImpl.this;
                        UpdateService updateService = updateShowServiceImpl2.mUpdateService;
                        str = UpdateShowServiceImpl.KEY_LAST_HINT_TIME;
                        updateShowServiceImpl2.mPreDownloadDelaySecond = updateService.getPreDownloadDelaySecond();
                        UpdateShowServiceImpl.this.mPreDownloadStartTime = currentTimeMillis;
                        updatePrefHelper.setPref(UpdateShowServiceImpl.KEY_PRE_DOWNLOAD_VERSION, UpdateShowServiceImpl.this.mPreDownloadVersion);
                        updatePrefHelper.setPref(UpdateShowServiceImpl.KEY_PRE_DOWNLOAD_DELAY_DAYS, UpdateShowServiceImpl.this.mPreDownloadDelayDays);
                        updatePrefHelper.setPref(UpdateShowServiceImpl.KEY_PRE_DOWNLOAD_DELAY_SECOND, UpdateShowServiceImpl.this.mPreDownloadDelaySecond);
                        updatePrefHelper.setPref(UpdateShowServiceImpl.KEY_PRE_DOWNLOAD_START_TIME, UpdateShowServiceImpl.this.mPreDownloadStartTime);
                    } else {
                        str = UpdateShowServiceImpl.KEY_LAST_HINT_TIME;
                    }
                    if (com.bytedance.common.utility.Logger.debug()) {
                        com.bytedance.common.utility.Logger.i(UpdateShowServiceImpl.TAG, "need pre download, version " + UpdateShowServiceImpl.this.mPreDownloadVersion + ", delay " + UpdateShowServiceImpl.this.mPreDownloadDelayDays + ", delay s " + UpdateShowServiceImpl.this.mPreDownloadDelaySecond + ", start " + UpdateShowServiceImpl.this.mPreDownloadStartTime);
                    }
                    if (UpdateShowServiceImpl.this.mUpdateService.getUpdateReadyApk() == null && NetworkUtils.isWifi(activity)) {
                        UpdateShowServiceImpl.this.mUpdateService.startPreDownload();
                        if (com.bytedance.common.utility.Logger.debug()) {
                            com.bytedance.common.utility.Logger.i(UpdateShowServiceImpl.TAG, "begin pre download");
                        }
                    }
                } else {
                    str = UpdateShowServiceImpl.KEY_LAST_HINT_TIME;
                }
                if (UpdateShowServiceImpl.this.mUpdateService.isClientStrategyEnable()) {
                    if (UpdateShowServiceImpl.this.mPreDownloadDelaySecond != -1) {
                        if (UpdateShowServiceImpl.this.mUpdateService.needPreDownload() && currentTimeMillis - UpdateShowServiceImpl.this.mPreDownloadStartTime < UpdateShowServiceImpl.this.mPreDownloadDelaySecond * 1000) {
                            if (com.bytedance.common.utility.Logger.debug()) {
                                com.bytedance.common.utility.Logger.i(UpdateShowServiceImpl.TAG, "in ore download delay second");
                            }
                            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
                            return;
                        }
                    } else if (UpdateShowServiceImpl.this.mUpdateService.needPreDownload()) {
                        str2 = ", start ";
                        if (currentTimeMillis - UpdateShowServiceImpl.this.mPreDownloadStartTime < UpdateShowServiceImpl.this.mPreDownloadDelayDays * 24 * 3600 * 1000) {
                            if (com.bytedance.common.utility.Logger.debug()) {
                                com.bytedance.common.utility.Logger.i(UpdateShowServiceImpl.TAG, "in pre download delay");
                            }
                            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
                            return;
                        }
                        if (com.bytedance.common.utility.Logger.debug()) {
                            com.bytedance.common.utility.Logger.i(UpdateShowServiceImpl.TAG, "hint version " + UpdateShowServiceImpl.this.mLastHintVersion + ", delay " + UpdateShowServiceImpl.this.mHintVersionDelayDays + str2 + UpdateShowServiceImpl.this.mLastHintVersionTime);
                        }
                        if (!UpdateShowServiceImpl.this.mUpdateService.isForceUpdate()) {
                            if (versionCode != UpdateShowServiceImpl.this.mLastHintVersion) {
                                UpdateShowServiceImpl.this.mHintVersionDelayDays = 0;
                                j = 0;
                                UpdateShowServiceImpl.this.mLastHintVersionTime = 0L;
                            } else {
                                j = 0;
                            }
                            if (currentTimeMillis - UpdateShowServiceImpl.this.mLastHintVersionTime < (updateStrategyInfo.updateDelayTime > j ? updateStrategyInfo.updateDelayTime : UpdateShowServiceImpl.this.mHintVersionDelayDays * 24 * 3600 * 1000)) {
                                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
                                return;
                            }
                            if (!NetworkUtils.isWifi(activity)) {
                                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
                                return;
                            } else if (updateStrategyInfo.updateDelayTime <= 0) {
                                if (UpdateShowServiceImpl.this.mHintVersionDelayDays <= 0) {
                                    UpdateShowServiceImpl.this.mHintVersionDelayDays = 1;
                                } else {
                                    UpdateShowServiceImpl.this.mHintVersionDelayDays *= 2;
                                    if (UpdateShowServiceImpl.this.mHintVersionDelayDays > 16) {
                                        UpdateShowServiceImpl.this.mHintVersionDelayDays = 16;
                                    }
                                }
                            }
                        }
                    }
                    str2 = ", start ";
                    if (com.bytedance.common.utility.Logger.debug()) {
                    }
                    if (!UpdateShowServiceImpl.this.mUpdateService.isForceUpdate()) {
                    }
                }
                UpdateShowServiceImpl.this.mLastHintVersion = versionCode;
                UpdateShowServiceImpl.this.mLastHintVersionTime = currentTimeMillis;
                updatePrefHelper.setPref(UpdateShowServiceImpl.KEY_LAST_HINT_VERSION, UpdateShowServiceImpl.this.mLastHintVersion);
                updatePrefHelper.setPref(UpdateShowServiceImpl.KEY_HINT_VERSION_DELAY_DAYS, UpdateShowServiceImpl.this.mHintVersionDelayDays);
                updatePrefHelper.setPref(str, UpdateShowServiceImpl.this.mLastHintVersionTime);
                UpdateShowServiceImpl.this.mUpdateService.showUpdateDialog(2, activity, z);
            }
        }, this.mUpdateService.getLatency() * 1000);
    }

    public void tryShowCheckDialog(int i) {
        Activity activity;
        IUpdateConfig config = UpdateSDK.getConfig();
        this.mIUpdateConfig = config;
        WeakReference<Activity> currentActivity = config.getUpdateConfig().getICurrentActivityCallback().getCurrentActivity();
        if (currentActivity == null || (activity = currentActivity.get()) == null || activity.isFinishing()) {
            return;
        }
        if (i == -2) {
            showCheckDialog(activity, -2, C0749R.string.check_dialog_none_title);
        } else if (i == -1) {
            showCheckDialog(activity, -1, C0749R.string.check_dialog_error_title);
        } else {
            if (i != 1) {
                return;
            }
            this.mUpdateService.showUpdateDialog(1, activity, false);
        }
    }

    private void showCheckDialog(Activity activity, int i, int i2) {
        WeakReference<IUpdateCheckDialog> weakReference = this.mUpdateCheckDialogs;
        if (weakReference != null) {
            IUpdateCheckDialog iUpdateCheckDialog = weakReference.get();
            if (iUpdateCheckDialog != null) {
                if (iUpdateCheckDialog.isShowCheckDialog()) {
                    return;
                }
                iUpdateCheckDialog.showCheckDialog(i);
                return;
            }
            new AlertDialog.Builder(activity).setTitle(i2).setMessage(C0749R.string.check_dialog_none_message).setPositiveButton(C0749R.string.check_dialog_confirm, (DialogInterface.OnClickListener) null).show();
            return;
        }
        new AlertDialog.Builder(activity).setTitle(i2).setMessage(C0749R.string.check_dialog_none_message).setPositiveButton(C0749R.string.check_dialog_confirm, (DialogInterface.OnClickListener) null).show();
    }

    public void setUpdateCheckDialogs(IUpdateCheckDialog iUpdateCheckDialog) {
        this.mUpdateCheckDialogs = new WeakReference<>(iUpdateCheckDialog);
    }
}
