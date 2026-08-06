package com.ss.android.update;

import android.content.Context;
import android.content.Intent;
import com.bytedance.news.common.service.manager.IService;
import java.io.File;

/* loaded from: classes7.dex */
public interface UpdateService extends IService {
    public static final String REASON_ALPHA_UPDATE_BG_DOWNLOAD = "reason_alpha_pkg_update_bg_download";
    public static final String REASON_APK_IS_PRE_DOWNLOAD = "apk_is_pre_download";
    public static final String REASON_CHECK_VERSION_CODE_FAIL = "reason_check_version_code_fail";
    public static final String REASON_CONTEXT_IS_NULL = "context_is_null";
    public static final String REASON_DIALOG_IS_ALREADY_SHOWN = "dialog_is_already_shown";
    public static final String REASON_IN_LOGIN_ACTIVITY = "activity_is_newaccountloginactivity";
    public static final String REASON_LACK_INFORMATION_NORMAL = "reason_lack_information_normal";
    public static final String REASON_LOCAL_BLOCK_DIALOG = "reason_local_block_dialog";
    public static final String REASON_LOCAL_LIMIT_BLOCK_DIALOG = "reason_local_limit_block_dialog";
    public static final String REASON_LOCAL_OUT_OF_HOUSE = "reason_local_out_of_house";
    public static final String REASON_NETWORK_IS_NOT_WIFI = "network_is_not_wifi";
    public static final String REASON_NEW_STRATEGY_INTERVAL_VERSION = "new_strategy_interval_version_";
    public static final String REASON_NEW_STRATEGY_NOT_ENABLE = "new_strategy_not_enable";
    public static final String REASON_NEW_STRATEGY_NOT_SHOW_FORMAL_DIALOG = "new_strategy_not_show_formal_dialog";
    public static final String REASON_NEW_STRATEGY_VERSION_IS_SAME = "new_strategy_version_is_same";
    public static final String REASON_NOT_ACTIVE = "activity_is_not_active";
    public static final String REASON_NO_BUTTON_TEXT = "reason_no_button_text";
    public static final String REASON_NO_LOCAL_GUIDE = "reason_no_local_guide";
    public static final String REASON_NO_NORMAL_GUIDE = "reason_no_normal_guide";
    public static final String REASON_NO_ORIENTAL_DIALOG = "reason_no_oriental_dialog";
    public static final String REASON_OLD_STRATEGY_DELAY_DAYS = "old_strategy_delay_days_";
    public static final String REASON_OTHER_DIALOG_SHOWING = "reason_other_update_dialog_showing";
    public static final String REASON_VERSION_IS_NOT_MATCH = "version_is_not_match";
    public static final int UPDATE_DIALOG_ACCEPT = 2;
    public static final int UPDATE_DIALOG_OTHER = 0;
    public static final int UPDATE_DIALOG_REFUSE = 3;
    public static final int UPDATE_DIALOG_SHOW = 1;

    void cancelDownload();

    void cancelNotifyAvai();

    void cancelNotifyReady();

    void checkUpdate(int i, int i2, OnUpdateStatusChangedListener onUpdateStatusChangedListener, boolean z);

    @Deprecated
    void checkUpdate(int i, OnUpdateStatusChangedListener onUpdateStatusChangedListener);

    void checkUpdate(int i, OnUpdateStatusChangedListener onUpdateStatusChangedListener, boolean z);

    void clickCloseAlphaButton(boolean z);

    void clickCloseButton(boolean z);

    void clickOpenAlphaButton(boolean z);

    void clickUpdateButton(boolean z);

    void exitUpdate();

    boolean formalUpdateEnable();

    String getDownloadingUrl();

    Intent getIntentForLocalApp();

    String getLastVersion();

    int getLatency();

    int getOfficial();

    @Deprecated
    int getPreDownloadDelayDays();

    long getPreDownloadDelaySecond();

    void getProgress(DownloadInfo downloadInfo);

    int getReleaseRuleId();

    String getUpdateButtonText();

    File getUpdateReadyApk();

    String getUpdateTitle();

    String getVerboseAppName();

    int getVersionCode();

    String getWhatsNew();

    @Deprecated
    boolean isCanUpdate();

    boolean isCanUpdate(boolean z);

    boolean isClientStrategyEnable();

    boolean isCurrentVersionOut();

    boolean isForceUpdate();

    boolean isInstallAlphaApp();

    boolean isLocalApp();

    boolean isRealCurrentVersionOut();

    boolean isShowUpdateDialog();

    boolean isShowingUpdateAvailDialog();

    boolean isShowingUpdateCheckDialog();

    boolean isUpdateApkPreDownloaded();

    boolean isUpdating();

    boolean needPreDownload();

    void noShowDialogEvent(String str);

    String parseWhatsNew(String str);

    void removeUpdateStatusListener(OnUpdateStatusChangedListener onUpdateStatusChangedListener);

    void reportDialogInfo(int i, boolean z);

    void setAppExtra(String str);

    void setCheckSignature(boolean z);

    void setCustomUpdateAlphaDialog(IUpdateAlphaDialog iUpdateAlphaDialog);

    void setCustomUpdateDialog(IUpdateMainDialog iUpdateMainDialog, IUpdateCheckDialog iUpdateCheckDialog);

    void showUpdateAlphaDialogScene(boolean z);

    void showUpdateDialog(int i, Context context, boolean z);

    void showUpdateDialogScene(boolean z);

    void startDownload();

    void startPreDownload();
}
