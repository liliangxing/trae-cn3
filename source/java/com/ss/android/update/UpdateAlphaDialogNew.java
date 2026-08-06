package com.ss.android.update;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateAlphaDialogNew extends UpdateDialogNewBase implements IUpdateAlphaDialog {
    private IUpdateConfig iUpdateConfig;
    private boolean isClicked;

    UpdateAlphaDialogNew(Context context) {
        super(context);
        this.isClicked = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateAlphaDialogNew(Context context, boolean z) {
        super(context);
        this.isClicked = false;
        this.mAutoUpdate = z;
    }

    @Override // com.ss.android.update.UpdateDialogNewBase, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.iUpdateConfig = UpdateSDK.getConfig();
    }

    @Override // com.ss.android.update.UpdateDialogNewBase
    void initData() {
        String[] split;
        String alphaDialogInstallText;
        super.initData();
        final UpdateHelper updateHelper = UpdateHelper.getInstance();
        this.mHelper = updateHelper;
        if (updateHelper == null) {
            return;
        }
        this.isClicked = false;
        int i = C0749R.string.label_update_open_title;
        String alphaDialogTitle = UpdateAlphaManager.inst().getAlphaDialogTitle();
        String title = this.mHelper.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mUpdateTitle.setText(title);
        } else if (TextUtils.isEmpty(alphaDialogTitle)) {
            this.mUpdateTitle.setText(i);
        } else {
            this.mUpdateTitle.setText(alphaDialogTitle);
        }
        String alphaDialogDesc = UpdateAlphaManager.inst().getAlphaDialogDesc();
        String whatsNew = this.mHelper.getWhatsNew();
        int i2 = UpdateAlphaManager.inst().isInstallAlphaApp() ? C0749R.string.update_title_open_alpha : C0749R.string.update_download;
        String string = this.mContext.getResources().getString(C0749R.string.label_update_open_desc);
        if (!TextUtils.isEmpty(whatsNew)) {
            split = whatsNew.split(UpdateDialogNewBase.TYPE);
        } else if (TextUtils.isEmpty(alphaDialogDesc)) {
            split = string.split(UpdateDialogNewBase.TYPE);
        } else {
            split = alphaDialogDesc.split(UpdateDialogNewBase.TYPE);
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                UpdateContentLinearLayout updateContentLinearLayout = new UpdateContentLinearLayout(this.mContext);
                updateContentLinearLayout.bindUpdateContent(str);
                this.mContentRoot.addView(updateContentLinearLayout);
            }
        }
        if (UpdateAlphaManager.inst().isInstallAlphaApp()) {
            alphaDialogInstallText = UpdateAlphaManager.inst().getAlphaDialogOpenText();
        } else {
            alphaDialogInstallText = UpdateAlphaManager.inst().getAlphaDialogInstallText();
        }
        String updateButtonText = this.mHelper.getUpdateButtonText();
        if (!TextUtils.isEmpty(updateButtonText)) {
            this.mUpdateBtn.setText(updateButtonText);
        } else if (TextUtils.isEmpty(alphaDialogInstallText)) {
            this.mUpdateBtn.setText(i2);
        } else {
            this.mUpdateBtn.setText(alphaDialogInstallText);
        }
        String lastVersion = this.mHelper.getLastVersion();
        if (!TextUtils.isEmpty(lastVersion)) {
            this.mUpdateVersion.setText(lastVersion);
            UIUtils.setViewVisibility(this.mUpdateVersion, 0);
        } else {
            UIUtils.setViewVisibility(this.mUpdateVersion, 4);
        }
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateAlphaDialogNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateAlphaDialogNew.this.isClicked = true;
                updateHelper.clickCloseAlphaButton(UpdateAlphaDialogNew.this.mAutoUpdate);
                if (UpdateAlphaManager.inst().isForceOpenAlphaEnable() && UpdateAlphaDialogNew.this.iUpdateConfig != null) {
                    UpdateAlphaDialogNew.this.iUpdateConfig.getUpdateConfig().getiUpdateForceExit().forceExitApp(UpdateAlphaDialogNew.this.getContext());
                }
                UpdateAlphaDialogNew.this.stopAin();
            }
        });
        this.mUpdateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateAlphaDialogNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent launchIntentForPackage;
                UpdateAlphaDialogNew.this.isClicked = true;
                updateHelper.clickOpenAlphaButton(UpdateAlphaDialogNew.this.mAutoUpdate);
                try {
                    if (UpdateAlphaManager.inst().isInstallAlphaApp()) {
                        Context context = UpdateAlphaDialogNew.this.getContext();
                        PackageManager packageManager = context.getPackageManager();
                        if (UpdateAlphaDialogNew.this.iUpdateConfig != null && UpdateAlphaDialogNew.this.iUpdateConfig.getUpdateConfig() != null) {
                            String localAppPackageName = UpdateAlphaDialogNew.this.iUpdateConfig.getUpdateConfig().getLocalAppPackageName();
                            if (!TextUtils.isEmpty(localAppPackageName) && (launchIntentForPackage = packageManager.getLaunchIntentForPackage(localAppPackageName)) != null) {
                                context.startActivity(launchIntentForPackage);
                            }
                        }
                        UpdateAlphaDialogNew.this.stopAin();
                        return;
                    }
                    updateHelper.cancelNotifyAvai();
                    File updateReadyApk = updateHelper.getUpdateReadyApk(true);
                    if (updateReadyApk != null) {
                        updateHelper.cancelNotifyReady();
                        UpdateFileProviderUtils.installApk(UpdateAlphaDialogNew.this.getContext(), updateReadyApk);
                        UpdateAlphaDialogNew.this.stopAin();
                    } else {
                        updateHelper.startDownload(true);
                        if (UpdateAlphaManager.inst().isForceOpenAlphaEnable()) {
                            new UpdateDialogNewBase.UpdateProgressThread().start();
                            UpdateAlphaDialogNew.this.refreshProgress(0, 100);
                        } else {
                            UpdateAlphaDialogNew.this.stopAin();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    UpdateAlphaDialogNew.this.stopAin();
                }
            }
        });
        setDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ss.android.update.UpdateAlphaDialogNew.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (UpdateAlphaDialogNew.this.isClicked) {
                    return;
                }
                UpdateAlphaDialogNew.this.mHelper.clickCloseAlphaButton(UpdateAlphaDialogNew.this.mAutoUpdate);
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        UpdateAlphaManager.inst().markAlphaDialogShown();
    }

    @Override // com.ss.android.update.UpdateDialogNewBase, com.ss.android.update.IUpdateMainDialog, com.ss.android.update.IUpdateAlphaDialog
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
