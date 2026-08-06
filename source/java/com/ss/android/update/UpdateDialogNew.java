package com.ss.android.update;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.update.UpdateDialogNewBase;
import com.ss.android.update.UpdateEventUtils;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateDialogNew extends UpdateDialogNewBase implements IUpdateMainDialog {
    private static final String TAG = "UpdateCheckDialog";
    private IUpdateConfig iUpdateConfig;
    private boolean isClicked;
    private final View.OnClickListener mBindAppListener;
    private SharedPreferences mSharePreferences;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateDialogNew(Context context, boolean z) {
        super(context, z);
        this.isClicked = false;
        this.mBindAppListener = new View.OnClickListener() { // from class: com.ss.android.update.UpdateDialogNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
            }
        };
        init(context);
    }

    UpdateDialogNew(Context context) {
        super(context);
        this.isClicked = false;
        this.mBindAppListener = new View.OnClickListener() { // from class: com.ss.android.update.UpdateDialogNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setSelected(!view.isSelected());
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mSharePreferences = context.getSharedPreferences(IUpdateMainDialog.SP_DIALOG_UPGRADE, 0);
    }

    @Override // com.ss.android.update.UpdateDialogNewBase, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        this.iUpdateConfig = UpdateSDK.getConfig();
    }

    @Override // com.ss.android.update.UpdateDialogNewBase
    void initData() {
        super.initData();
        final UpdateHelper updateHelper = UpdateHelper.getInstance();
        this.mHelper = updateHelper;
        if (updateHelper == null) {
            return;
        }
        this.isClicked = false;
        final boolean z = updateHelper.isForceUpdate() && this.mAutoUpdate;
        final boolean z2 = updateHelper.getUpdateReadyApk() != null;
        final boolean canUseMarketUpdate = this.mHelper.canUseMarketUpdate();
        String alreadyDownloadTips = updateHelper.getAlreadyDownloadTips();
        String whatsNew = updateHelper.getWhatsNew();
        String updateButtonText = updateHelper.getUpdateButtonText();
        if (!z2) {
            alreadyDownloadTips = whatsNew;
        }
        if (!TextUtils.isEmpty(alreadyDownloadTips)) {
            this.mContentRoot.removeAllViews();
            if (alreadyDownloadTips.contains(UpdateDialogNewBase.TYPE)) {
                for (String str : alreadyDownloadTips.split(UpdateDialogNewBase.TYPE)) {
                    if (!TextUtils.isEmpty(str)) {
                        UpdateContentLinearLayout updateContentLinearLayout = new UpdateContentLinearLayout(this.mContext);
                        updateContentLinearLayout.bindUpdateContent(str);
                        this.mContentRoot.addView(updateContentLinearLayout);
                    }
                }
            } else {
                UpdateContentLinearLayout updateContentLinearLayout2 = new UpdateContentLinearLayout(this.mContext);
                updateContentLinearLayout2.bindUpdateContent(alreadyDownloadTips);
                this.mContentRoot.addView(updateContentLinearLayout2);
            }
        }
        String marketUpdateTips = this.mHelper.getMarketUpdateTips();
        if (TextUtils.isEmpty(marketUpdateTips) || !canUseMarketUpdate) {
            if (z) {
                this.mUpdateBtn.setText(z2 ? C0749R.string.update_install : C0749R.string.update_download);
            }
        } else if (marketUpdateTips.contains(UpdateDialogNewBase.TYPE)) {
            this.mUpdateBtn.setText(marketUpdateTips.replace(UpdateDialogNewBase.TYPE, ""));
        } else {
            this.mUpdateBtn.setText(marketUpdateTips);
        }
        if (!TextUtils.isEmpty(updateButtonText)) {
            this.mUpdateBtn.setText(updateButtonText);
        }
        String lastVersion = this.mHelper.getLastVersion();
        if (!TextUtils.isEmpty(lastVersion)) {
            this.mUpdateVersion.setText(lastVersion);
            UIUtils.setViewVisibility(this.mUpdateVersion, 0);
        } else {
            UIUtils.setViewVisibility(this.mUpdateVersion, 4);
        }
        String title = this.mHelper.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mUpdateTitle.setText(title);
        } else if (this.mHelper.isForceUpdate()) {
            this.mUpdateTitle.setText(C0749R.string.update_title_force);
        } else {
            this.mUpdateTitle.setText(C0749R.string.update_title_normal);
        }
        if (!z && !z2) {
            updateHelper.initBindApp();
            if (updateHelper.getBindAppChecked()) {
                this.mBindAppView.setSelected(true);
            } else {
                this.mBindAppView.setSelected(false);
            }
            if (updateHelper.getBindApp()) {
                this.mBindAppHintTextView.setText(updateHelper.getBindAppTips());
                UIUtils.setViewVisibility(this.mBindAppView, 0);
            } else {
                UIUtils.setViewVisibility(this.mBindAppView, 8);
            }
            this.mBindAppView.setOnClickListener(this.mBindAppListener);
        }
        if (this.mBgAutoDownloadView != null) {
            if (this.mBindAppView.getVisibility() == 0 || !UpdateAlphaManager.inst().alphaBgAutoDownloadEnable()) {
                this.mBgAutoDownloadView.setVisibility(8);
                this.mBgAutoDownloadView.setSelected(false);
            } else {
                this.mBgAutoDownloadView.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateDialogNew.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        view.setSelected(!view.isSelected());
                    }
                });
                this.mBgAutoDownloadView.setVisibility(0);
                if (UpdateAlphaManager.inst().getUserRefuseBgDownload()) {
                    this.mBgAutoDownloadView.setSelected(false);
                } else {
                    this.mBgAutoDownloadView.setSelected(true);
                }
                String bgDownloadCheckboxText = UpdateAlphaManager.inst().getBgDownloadCheckboxText();
                if (this.mBgAutoDownloadTextView != null && !TextUtils.isEmpty(bgDownloadCheckboxText)) {
                    this.mBgAutoDownloadTextView.setText(bgDownloadCheckboxText);
                }
            }
        }
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateDialogNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z) {
                    IUpdateConfig config = UpdateSDK.getConfig();
                    if (config != null) {
                        config.getUpdateConfig().getiUpdateForceExit().forceExitApp(UpdateDialogNew.this.getContext());
                    }
                } else {
                    UpdateStrategyManager.getInstance().applyUpdateCancel();
                }
                if (!z && !z2) {
                    UpdateDialogNew.this.handleBindApp(updateHelper);
                }
                if (UpdateDialogNew.this.mBgAutoDownloadView != null && UpdateDialogNew.this.mBgAutoDownloadView.getVisibility() == 0) {
                    UpdateEventUtils.alphaUpdateBgDownloadEvent(8, null, UpdateEventUtils.ParamsBuilder.begin().add("permission_status", String.valueOf(UpdateAlphaManager.inst().getUserAgreeBgDownloadRaw())).end());
                }
                UpdateDialogNew.this.isClicked = true;
                updateHelper.clickCloseButton(UpdateDialogNew.this.mAutoUpdate);
                UpdateDialogNew.this.stopAin();
            }
        });
        this.mUpdateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateDialogNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (canUseMarketUpdate) {
                    UpdateDialogNew.this.mHelper.updateWithMarket(UpdateDialogNew.this.getContext());
                    UpdateDialogNew.this.stopAin();
                    return;
                }
                if (!NetworkUtils.isNetworkAvailable(UpdateDialogNew.this.getContext())) {
                    Toast.makeText(UpdateDialogNew.this.getContext(), "网络未连接", 1).show();
                    return;
                }
                if (UpdateDialogNew.this.mBgAutoDownloadView != null && UpdateDialogNew.this.mBgAutoDownloadView.getVisibility() == 0) {
                    UpdateAlphaManager.inst().setUserAgreeBgDownload(UpdateDialogNew.this.mBgAutoDownloadView.isSelected());
                    UpdateEventUtils.alphaUpdateBgDownloadEvent(7, null, UpdateEventUtils.ParamsBuilder.begin().add("permission_status", String.valueOf(UpdateDialogNew.this.mBgAutoDownloadView.isSelected() ? 1 : 2)).end());
                }
                if (!UpdateDialogNew.this.mHelper.isRealCurrentVersionOut()) {
                    UpdateDialogNew.this.stopAin();
                    return;
                }
                UpdateDialogNew.this.isClick = true;
                UpdateDialogNew.this.mHelper.cancelNotifyAvai();
                File updateReadyApk = UpdateDialogNew.this.mHelper.getUpdateReadyApk();
                if (updateReadyApk != null) {
                    UpdateDialogNew.this.mHelper.cancelNotifyReady();
                    UpdateDialogNew.this.mHelper.installApk(UpdateDialogNew.this.mContext, updateReadyApk);
                } else {
                    UpdateDialogNew.this.mHelper.startDownload();
                    if (z) {
                        new UpdateDialogNewBase.UpdateProgressThread().start();
                        UpdateDialogNew.this.refreshProgress(0, 100);
                    }
                }
                UpdateDialogNew.this.isClicked = true;
                updateHelper.clickUpdateButton(UpdateDialogNew.this.mAutoUpdate);
                if (!z && !z2) {
                    UpdateDialogNew.this.handleBindApp(updateHelper);
                }
                if (z) {
                    return;
                }
                UIUtils.displayToast(UpdateDialogNew.this.mContext, C0749R.string.update_downloading_bg);
                UpdateStrategyManager.getInstance().applyUpdateBySelf();
                UpdateDialogNew.this.stopAin();
            }
        });
        setDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ss.android.update.UpdateDialogNew.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (UpdateDialogNew.this.isClicked) {
                    return;
                }
                UpdateDialogNew.this.mHelper.clickCloseButton(UpdateDialogNew.this.mAutoUpdate);
            }
        });
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

    @Override // com.ss.android.update.UpdateDialogNewBase, com.ss.android.update.IUpdateMainDialog, com.ss.android.update.IUpdateAlphaDialog
    public void isAutoUpdate(boolean z) {
        this.mAutoUpdate = z;
    }

    @Override // com.ss.android.update.UpdateDialogNewBase, com.ss.android.update.IUpdateMainDialog
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

    @Override // com.ss.android.update.UpdateDialogNewBase, com.ss.android.update.IUpdateMainDialog
    public boolean isShowMainDialog() {
        return isShowing();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        IUpdateConfig iUpdateConfig;
        super.onBackPressed();
        if (!UpdateHelper.getInstance().isForceUpdate() || (iUpdateConfig = this.iUpdateConfig) == null) {
            return;
        }
        iUpdateConfig.getUpdateConfig().getiUpdateForceExit().forceExitApp(getContext());
    }
}
