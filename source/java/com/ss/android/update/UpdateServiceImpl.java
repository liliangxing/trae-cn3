package com.ss.android.update;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateServiceImpl implements UpdateService {
    private UpdateHelper mUpdateHelper = UpdateHelper.getInstance();

    @Override // com.ss.android.update.UpdateService
    public void setCheckSignature(boolean z) {
        this.mUpdateHelper.setCheckSignature(z);
    }

    @Override // com.ss.android.update.UpdateService
    public void cancelNotifyAvai() {
        this.mUpdateHelper.cancelNotifyAvai();
    }

    @Override // com.ss.android.update.UpdateService
    public void cancelNotifyReady() {
        this.mUpdateHelper.cancelNotifyReady();
    }

    @Override // com.ss.android.update.UpdateService
    public void cancelDownload() {
        this.mUpdateHelper.cancelDownload();
    }

    @Override // com.ss.android.update.UpdateService
    public void startDownload() {
        this.mUpdateHelper.startDownload();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isUpdating() {
        return this.mUpdateHelper.isUpdating();
    }

    @Override // com.ss.android.update.UpdateService
    public File getUpdateReadyApk() {
        return this.mUpdateHelper.getUpdateReadyApk();
    }

    @Override // com.ss.android.update.UpdateService
    public String getWhatsNew() {
        return this.mUpdateHelper.getWhatsNew();
    }

    @Override // com.ss.android.update.UpdateService
    public String getUpdateTitle() {
        return this.mUpdateHelper.getTitle();
    }

    @Override // com.ss.android.update.UpdateService
    public String getLastVersion() {
        return this.mUpdateHelper.getLastVersion();
    }

    @Override // com.ss.android.update.UpdateService
    public void getProgress(DownloadInfo downloadInfo) {
        this.mUpdateHelper.getProgress(downloadInfo);
    }

    @Override // com.ss.android.update.UpdateService
    public String getVerboseAppName() {
        return this.mUpdateHelper.getVerboseAppName();
    }

    @Override // com.ss.android.update.UpdateService
    public int getReleaseRuleId() {
        return this.mUpdateHelper.getReleaseRuleId();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isForceUpdate() {
        return this.mUpdateHelper.isForceUpdate();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCurrentVersionOut() {
        return this.mUpdateHelper.isCurrentVersionOut();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isRealCurrentVersionOut() {
        return this.mUpdateHelper.isRealCurrentVersionOut();
    }

    @Override // com.ss.android.update.UpdateService
    public int getVersionCode() {
        return this.mUpdateHelper.getVersionCode();
    }

    @Override // com.ss.android.update.UpdateService
    public String getDownloadingUrl() {
        return this.mUpdateHelper.getDownloadingUrl();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean needPreDownload() {
        return this.mUpdateHelper.needPreDownload();
    }

    @Override // com.ss.android.update.UpdateService
    public int getPreDownloadDelayDays() {
        return this.mUpdateHelper.getPreDownloadDelayDays();
    }

    @Override // com.ss.android.update.UpdateService
    public long getPreDownloadDelaySecond() {
        return this.mUpdateHelper.getPreDownloadDelaySecond();
    }

    @Override // com.ss.android.update.UpdateService
    public void startPreDownload() {
        this.mUpdateHelper.startPreDownload();
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateDialog(int i, Context context, boolean z) {
        if (i == 2 || i == -2) {
            this.mUpdateHelper.showUpdateAvailDialog(context, z);
            return;
        }
        if (i == 1 || i == -1) {
            this.mUpdateHelper.showUpdateCheckDialog(context);
        } else if (i == 3 || i == -3) {
            this.mUpdateHelper.showOpenAlphaDialog(z);
        }
    }

    @Override // com.ss.android.update.UpdateService
    public int getLatency() {
        return this.mUpdateHelper.getLatency();
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int i, OnUpdateStatusChangedListener onUpdateStatusChangedListener) {
        this.mUpdateHelper.startCheckUpdate(i, onUpdateStatusChangedListener);
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int i, OnUpdateStatusChangedListener onUpdateStatusChangedListener, boolean z) {
        this.mUpdateHelper.startCheckUpdate(i, onUpdateStatusChangedListener, z);
    }

    @Override // com.ss.android.update.UpdateService
    public void removeUpdateStatusListener(OnUpdateStatusChangedListener onUpdateStatusChangedListener) {
        this.mUpdateHelper.removeUpdateStatusListener(onUpdateStatusChangedListener);
    }

    @Override // com.ss.android.update.UpdateService
    public void exitUpdate() {
        this.mUpdateHelper.onExit();
    }

    @Override // com.ss.android.update.UpdateService
    public String parseWhatsNew(String str) {
        return this.mUpdateHelper.parseWhatsNew(str);
    }

    @Override // com.ss.android.update.UpdateService
    public void setCustomUpdateDialog(IUpdateMainDialog iUpdateMainDialog, IUpdateCheckDialog iUpdateCheckDialog) {
        this.mUpdateHelper.setCustomUpdateDialog(iUpdateMainDialog, iUpdateCheckDialog);
    }

    @Override // com.ss.android.update.UpdateService
    public int getOfficial() {
        return this.mUpdateHelper.getOfficial();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowUpdateDialog() {
        return UpdateStrategyManager.getInstance().isShowUpdateDialog();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowingUpdateCheckDialog() {
        return this.mUpdateHelper.isShowingUpdateCheckDialog();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isShowingUpdateAvailDialog() {
        return this.mUpdateHelper.isShowingUpdateAvailDialog();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isInstallAlphaApp() {
        return UpdateAlphaManager.inst().isInstallAlphaApp();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean formalUpdateEnable() {
        return this.mUpdateHelper.formalUpdateEnable();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isUpdateApkPreDownloaded() {
        return this.mUpdateHelper.isUpdateApkPreDownloaded();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCanUpdate() {
        return this.mUpdateHelper.isCanUpdate();
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isCanUpdate(boolean z) {
        return this.mUpdateHelper.isCanUpdate(z);
    }

    @Override // com.ss.android.update.UpdateService
    public void setAppExtra(String str) {
        this.mUpdateHelper.setAppExtra(str);
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isClientStrategyEnable() {
        return this.mUpdateHelper.isClientStrategyEnable();
    }

    @Override // com.ss.android.update.UpdateService
    public void noShowDialogEvent(String str) {
        UpdateEventUtils.noShowDialogEvent(str);
    }

    @Override // com.ss.android.update.UpdateService
    public void reportDialogInfo(int i, boolean z) {
        this.mUpdateHelper.reportDialogInfo(i, z);
    }

    @Override // com.ss.android.update.UpdateService
    public void setCustomUpdateAlphaDialog(IUpdateAlphaDialog iUpdateAlphaDialog) {
        this.mUpdateHelper.setCustomUpdateAlphaDialog(iUpdateAlphaDialog);
    }

    @Override // com.ss.android.update.UpdateService
    public void checkUpdate(int i, int i2, OnUpdateStatusChangedListener onUpdateStatusChangedListener, boolean z) {
        this.mUpdateHelper.startCheckUpdate(i, i2, onUpdateStatusChangedListener, z);
    }

    @Override // com.ss.android.update.UpdateService
    public Intent getIntentForLocalApp() {
        return this.mUpdateHelper.getIntentForLocalApp();
    }

    @Override // com.ss.android.update.UpdateService
    public String getUpdateButtonText() {
        return this.mUpdateHelper.getUpdateButtonText();
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateDialogScene(boolean z) {
        this.mUpdateHelper.showUpdateDialogScene(z);
    }

    @Override // com.ss.android.update.UpdateService
    public void showUpdateAlphaDialogScene(boolean z) {
        this.mUpdateHelper.showUpdateAlphaDialogScene(z);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickUpdateButton(boolean z) {
        this.mUpdateHelper.clickUpdateButton(z);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickCloseButton(boolean z) {
        this.mUpdateHelper.clickCloseButton(z);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickOpenAlphaButton(boolean z) {
        this.mUpdateHelper.clickOpenAlphaButton(z);
    }

    @Override // com.ss.android.update.UpdateService
    public void clickCloseAlphaButton(boolean z) {
        this.mUpdateHelper.clickCloseAlphaButton(z);
    }

    @Override // com.ss.android.update.UpdateService
    public boolean isLocalApp() {
        UpdateHelper updateHelper = this.mUpdateHelper;
        return updateHelper != null && updateHelper.isLocalApp();
    }
}
