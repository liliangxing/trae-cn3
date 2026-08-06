package com.ss.android.update;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.ss.android.update.UpdateDialogBase;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateAlphaDialog extends UpdateDialogBase implements IUpdateAlphaDialog {
    private IUpdateConfig iUpdateConfig;
    private boolean isClicked;

    UpdateAlphaDialog(Context context) {
        super(context);
        this.isClicked = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateAlphaDialog(Context context, boolean z) {
        super(context);
        this.isClicked = false;
        this.mAutoUpdate = z;
    }

    @Override // com.ss.android.update.UpdateDialogBase, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.iUpdateConfig = UpdateSDK.getConfig();
    }

    @Override // com.ss.android.update.UpdateDialogBase
    void initData() {
        String alphaDialogInstallText;
        final UpdateHelper updateHelper = UpdateHelper.getInstance();
        this.mHelper = updateHelper;
        if (updateHelper == null) {
            return;
        }
        this.isClicked = false;
        int i = C0749R.string.label_update_open_title;
        int i2 = UpdateAlphaManager.inst().isInstallAlphaApp() ? C0749R.string.label_update_open : C0749R.string.label_update_open_download;
        int i3 = UpdateAlphaManager.inst().isForceOpenAlphaEnable() ? C0749R.string.label_update_open_exit : C0749R.string.label_update_open_later;
        int i4 = C0749R.string.label_update_open_desc_old;
        String alphaDialogTitle = UpdateAlphaManager.inst().getAlphaDialogTitle();
        String title = this.mHelper.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mTitleView.setText(title);
        } else if (TextUtils.isEmpty(alphaDialogTitle)) {
            this.mTitleView.setText(i);
        } else {
            this.mTitleView.setText(alphaDialogTitle);
        }
        this.mDownloadedHintView.setVisibility(8);
        String alphaDialogDesc = UpdateAlphaManager.inst().getAlphaDialogDesc();
        String whatsNew = this.mHelper.getWhatsNew();
        if (!TextUtils.isEmpty(whatsNew)) {
            this.mDescriptionView.setText(whatsNew);
        } else if (TextUtils.isEmpty(alphaDialogDesc)) {
            this.mDescriptionView.setText(i4);
        } else {
            this.mDescriptionView.setText(alphaDialogDesc);
        }
        if (UpdateAlphaManager.inst().isInstallAlphaApp()) {
            alphaDialogInstallText = UpdateAlphaManager.inst().getAlphaDialogOpenText();
        } else {
            alphaDialogInstallText = UpdateAlphaManager.inst().getAlphaDialogInstallText();
        }
        String updateButtonText = this.mHelper.getUpdateButtonText();
        if (!TextUtils.isEmpty(updateButtonText)) {
            this.mUpdateBtnText.setText(updateButtonText);
        } else if (TextUtils.isEmpty(alphaDialogInstallText)) {
            this.mUpdateBtnText.setText(i2);
        } else {
            this.mUpdateBtnText.setText(alphaDialogInstallText);
        }
        this.mCancelBtn.setText(i3);
        this.mUpdateBtnText.setVisibility(0);
        this.mUpdateBgView.setVisibility(0);
        this.mUpdateProgressView.setVisibility(8);
        this.mUpdatingText.setVisibility(8);
        this.mUpdateProgressText.setVisibility(8);
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateAlphaDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateAlphaDialog.this.isClicked = true;
                updateHelper.clickCloseAlphaButton(UpdateAlphaDialog.this.mAutoUpdate);
                if (UpdateAlphaManager.inst().isForceOpenAlphaEnable() && UpdateAlphaDialog.this.iUpdateConfig != null) {
                    UpdateAlphaDialog.this.iUpdateConfig.getUpdateConfig().getiUpdateForceExit().forceExitApp(UpdateAlphaDialog.this.getContext());
                }
                UpdateAlphaDialog.this.dismiss();
            }
        });
        this.mUpdateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateAlphaDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent launchIntentForPackage;
                UpdateAlphaDialog.this.isClicked = true;
                updateHelper.clickOpenAlphaButton(UpdateAlphaDialog.this.mAutoUpdate);
                try {
                    if (UpdateAlphaManager.inst().isInstallAlphaApp()) {
                        Context context = UpdateAlphaDialog.this.getContext();
                        PackageManager packageManager = context.getPackageManager();
                        if (UpdateAlphaDialog.this.iUpdateConfig != null && UpdateAlphaDialog.this.iUpdateConfig.getUpdateConfig() != null) {
                            String localAppPackageName = UpdateAlphaDialog.this.iUpdateConfig.getUpdateConfig().getLocalAppPackageName();
                            if (!TextUtils.isEmpty(localAppPackageName) && (launchIntentForPackage = packageManager.getLaunchIntentForPackage(localAppPackageName)) != null) {
                                context.startActivity(launchIntentForPackage);
                            }
                        }
                        UpdateAlphaDialog.this.dismiss();
                        return;
                    }
                    updateHelper.cancelNotifyAvai();
                    File updateReadyApk = updateHelper.getUpdateReadyApk(true);
                    if (updateReadyApk != null) {
                        updateHelper.cancelNotifyReady();
                        UpdateFileProviderUtils.installApk(UpdateAlphaDialog.this.getContext(), updateReadyApk);
                        UpdateAlphaDialog.this.dismiss();
                    } else {
                        updateHelper.startDownload(true);
                        if (UpdateAlphaManager.inst().isForceOpenAlphaEnable()) {
                            new UpdateDialogBase.UpdateProgressThread().start();
                        } else {
                            UpdateAlphaDialog.this.dismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    UpdateAlphaDialog.this.dismiss();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ss.android.update.UpdateAlphaDialog.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (UpdateAlphaDialog.this.isClicked) {
                    return;
                }
                updateHelper.clickCloseAlphaButton(UpdateAlphaDialog.this.mAutoUpdate);
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        UpdateAlphaManager.inst().markAlphaDialogShown();
    }

    @Override // com.ss.android.update.IUpdateAlphaDialog
    public void isAutoUpdate(boolean z) {
        this.mAutoUpdate = z;
    }

    @Override // com.ss.android.update.IUpdateAlphaDialog
    public void showAlphaDialog() {
        show();
        this.mHelper.showUpdateAlphaDialogScene(this.mAutoUpdate);
    }

    @Override // com.ss.android.update.IUpdateAlphaDialog
    public boolean isShowAlphaDialog() {
        return isShowing();
    }
}
