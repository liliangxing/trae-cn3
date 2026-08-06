package com.ss.android.update;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.ss.android.update.UpdateDialogBase;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateDialog extends UpdateDialogBase implements IUpdateMainDialog {
    private boolean isClicked;
    private final View.OnClickListener mBindAppListener;
    private SharedPreferences mSharePreferences;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateDialog(Context context, boolean z) {
        super(context);
        this.isClicked = false;
        this.mBindAppListener = new View.OnClickListener() { // from class: com.ss.android.update.UpdateDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
            }
        };
        this.mAutoUpdate = z;
        this.mSharePreferences = context.getSharedPreferences(IUpdateMainDialog.SP_DIALOG_UPGRADE, 0);
    }

    UpdateDialog(Context context) {
        this(context, false);
    }

    @Override // com.ss.android.update.UpdateDialogBase, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = UpdateHelper.getInstance().getUpdateReadyApk() != null;
        boolean z2 = UpdateHelper.getInstance().isForceUpdate() && this.mAutoUpdate;
        if (z2 && z) {
            onEvent("forcible_downloaded_show");
        } else if (z2 && !z) {
            onEvent("forcible_show");
        } else if (z) {
            onEvent("downloaded_show");
        } else {
            onEvent("show");
        }
        initData();
    }

    @Override // com.ss.android.update.UpdateDialogBase
    protected void initData() {
        final UpdateHelper updateHelper = UpdateHelper.getInstance();
        this.mHelper = updateHelper;
        if (updateHelper == null) {
            return;
        }
        this.isClicked = false;
        final boolean canUseMarketUpdate = this.mHelper.canUseMarketUpdate();
        final boolean z = updateHelper.getUpdateReadyApk() != null;
        boolean isUpdateApkPreDownloaded = updateHelper.isUpdateApkPreDownloaded();
        final boolean z2 = updateHelper.isForceUpdate() && this.mAutoUpdate;
        String parseWhatsNew = updateHelper.parseWhatsNew(updateHelper.getWhatsNew());
        String alreadyDownloadTips = updateHelper.getAlreadyDownloadTips();
        String title = updateHelper.getTitle();
        String updateButtonText = updateHelper.getUpdateButtonText();
        int i = C0749R.string.label_update_immediately;
        int i2 = C0749R.string.label_update_later;
        if (z2) {
            i = z ? C0749R.string.label_update_install : C0749R.string.label_update_now;
            i2 = C0749R.string.label_update_exit;
        }
        if (TextUtils.isEmpty(alreadyDownloadTips)) {
            alreadyDownloadTips = parseWhatsNew;
        }
        if (z) {
            parseWhatsNew = alreadyDownloadTips;
        }
        this.mTitleView.setText(title);
        this.mDownloadedHintView.setVisibility(isUpdateApkPreDownloaded ? 0 : 8);
        this.mDescriptionView.setText(parseWhatsNew);
        if (!TextUtils.isEmpty(updateButtonText)) {
            this.mUpdateBtnText.setText(updateButtonText);
        } else {
            this.mUpdateBtnText.setText(i);
        }
        this.mCancelBtn.setText(i2);
        if (canUseMarketUpdate) {
            String marketUpdateTips = this.mHelper.getMarketUpdateTips();
            if (!TextUtils.isEmpty(marketUpdateTips)) {
                this.mUpdateBtnText.setText(marketUpdateTips);
            }
        }
        this.mUpdateBtnText.setVisibility(0);
        this.mUpdateBgView.setVisibility(0);
        this.mUpdateProgressView.setVisibility(8);
        this.mUpdatingText.setVisibility(8);
        this.mUpdateProgressText.setVisibility(8);
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IUpdateConfig config;
                boolean z3 = z2;
                if (z3 && z) {
                    UpdateDialog.this.onEvent("forcible_downloaded_refuse");
                } else if (z3 && !z) {
                    UpdateDialog.this.onEvent("forcible_refuse");
                } else if (z) {
                    UpdateDialog.this.onEvent("downloaded_refuse");
                } else {
                    UpdateDialog.this.onEvent("refuse");
                }
                if (z2 && (config = UpdateSDK.getConfig()) != null) {
                    config.getUpdateConfig().getiUpdateForceExit().forceExitApp(UpdateDialog.this.getContext());
                }
                updateHelper.cancelCountDown();
                if (!z2 && !z) {
                    UpdateDialog.this.handleBindApp(updateHelper);
                }
                UpdateDialog.this.isClicked = true;
                updateHelper.clickCloseButton(UpdateDialog.this.mAutoUpdate);
                if (!z2) {
                    UpdateStrategyManager.getInstance().applyUpdateCancel();
                }
                UpdateDialog.this.dismiss();
            }
        });
        final boolean z3 = z2;
        final boolean z4 = z;
        this.mUpdateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (canUseMarketUpdate) {
                    UpdateDialog.this.mHelper.updateWithMarket(UpdateDialog.this.getContext());
                    UpdateDialog.this.dismiss();
                    return;
                }
                boolean z5 = z3;
                if (z5 && z4) {
                    UpdateDialog.this.onEvent("forcible_downloaded_accept");
                } else if (z5 && !z4) {
                    UpdateDialog.this.onEvent("forcible_accept");
                } else if (z4) {
                    UpdateDialog.this.onEvent("downloaded_accept");
                } else {
                    UpdateDialog.this.onEvent("accept");
                }
                updateHelper.cancelNotifyAvai();
                File updateReadyApk = updateHelper.getUpdateReadyApk();
                if (updateReadyApk != null) {
                    updateHelper.cancelNotifyReady();
                    UpdateFileProviderUtils.installApk(UpdateDialog.this.getContext(), updateReadyApk);
                } else {
                    updateHelper.startDownload();
                    if (z3) {
                        new UpdateDialogBase.UpdateProgressThread().start();
                    }
                }
                UpdateDialog.this.isClicked = true;
                updateHelper.clickUpdateButton(UpdateDialog.this.mAutoUpdate);
                if (!z3 && !z4) {
                    UpdateDialog.this.handleBindApp(updateHelper);
                }
                if (z3) {
                    return;
                }
                UpdateStrategyManager.getInstance().applyUpdateBySelf();
                UpdateDialog.this.dismiss();
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ss.android.update.UpdateDialog.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (UpdateDialog.this.isClicked) {
                    return;
                }
                updateHelper.clickCloseButton(UpdateDialog.this.mAutoUpdate);
            }
        });
        if (z2 || z) {
            return;
        }
        updateHelper.initBindApp();
        if (updateHelper.getBindAppChecked()) {
            this.mBindAppView.setSelected(true);
        } else {
            this.mBindAppView.setSelected(false);
        }
        if (updateHelper.getBindApp()) {
            this.mBindAppHintTextView.setText(updateHelper.getBindAppTips());
            this.mBindAppView.setVisibility(0);
        } else {
            this.mBindAppView.setVisibility(8);
        }
        this.mBindAppView.setOnClickListener(this.mBindAppListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBindApp(UpdateHelper updateHelper) {
        if (updateHelper == null) {
            return;
        }
        if (this.mBindAppView.isSelected()) {
            updateHelper.startBindAppDownload();
        } else {
            updateHelper.countDown();
        }
    }

    @Override // com.ss.android.update.IUpdateMainDialog, com.ss.android.update.IUpdateAlphaDialog
    public void isAutoUpdate(boolean z) {
        this.mAutoUpdate = z;
    }

    @Override // com.ss.android.update.IUpdateMainDialog
    public void showMainDialog(boolean z) {
        show();
        SharedPreferences sharedPreferences = this.mSharePreferences;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(IUpdateMainDialog.SP_KEY_LAST_SHOW_TIMESTAMP, System.currentTimeMillis());
            edit.apply();
        }
        this.mHelper.showUpdateDialogScene(this.mAutoUpdate);
    }

    @Override // com.ss.android.update.IUpdateMainDialog
    public boolean isShowMainDialog() {
        return isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEvent(String str) {
        JSONObject jSONObject = new JSONObject();
        Utils.safePutJsonKV(jSONObject, "label", str);
        EventReporter.onEvent(this.mEventName, jSONObject);
    }
}
