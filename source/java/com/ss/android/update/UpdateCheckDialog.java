package com.ss.android.update;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateCheckDialog extends Dialog implements IUpdateCheckDialog {
    private static final String TAG = "UpdateCheckDialog";
    private static final String TYPE = "\n";
    private boolean isClick;
    private ImageView mCancelBtn;
    private LinearLayout mContentRoot;
    private Context mContext;
    private UpdateHelper mHelper;
    private TextView mUpdateBtn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateCheckDialog(Context context) {
        super(context);
        this.isClick = false;
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0749R.layout.update_check_dialog_layout);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(C0749R.drawable.transparent);
            window.setLayout(-2, -2);
            window.setGravity(17);
        }
        this.mUpdateBtn = (TextView) findViewById(C0749R.id.update_check_ok_btn);
        this.mCancelBtn = (ImageView) findViewById(C0749R.id.update_check_cancel_btn);
        this.mContentRoot = (LinearLayout) findViewById(C0749R.id.update_content_root);
        initData();
    }

    private void initData() {
        UpdateHelper updateHelper = UpdateHelper.getInstance();
        this.mHelper = updateHelper;
        if (updateHelper == null) {
            return;
        }
        final boolean canUseMarketUpdate = updateHelper.canUseMarketUpdate();
        String whatsNew = updateHelper.getWhatsNew();
        if (!TextUtils.isEmpty(whatsNew)) {
            if (whatsNew.contains("\n")) {
                for (String str : whatsNew.split("\n")) {
                    if (!TextUtils.isEmpty(str)) {
                        UpdateContentLinearLayout updateContentLinearLayout = new UpdateContentLinearLayout(this.mContext);
                        updateContentLinearLayout.bindUpdateContent(str);
                        this.mContentRoot.addView(updateContentLinearLayout);
                    }
                }
            } else {
                UpdateContentLinearLayout updateContentLinearLayout2 = new UpdateContentLinearLayout(this.mContext);
                updateContentLinearLayout2.bindUpdateContent(whatsNew);
                this.mContentRoot.addView(updateContentLinearLayout2);
            }
        }
        if (!TextUtils.isEmpty(this.mHelper.getMarketUpdateTips()) && canUseMarketUpdate) {
            if (this.mHelper.getMarketUpdateTips().contains("\n")) {
                this.mUpdateBtn.setText(this.mHelper.getMarketUpdateTips().replace("\n", ""));
            } else {
                this.mUpdateBtn.setText(this.mHelper.getMarketUpdateTips());
            }
        }
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateCheckDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateCheckDialog.this.mHelper.clickCloseButton(false);
                UpdateCheckDialog.this.isClick = true;
                UpdateCheckDialog.this.dismiss();
            }
        });
        this.mUpdateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateCheckDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (canUseMarketUpdate) {
                    UpdateCheckDialog.this.mHelper.updateWithMarket(UpdateCheckDialog.this.getContext());
                    UpdateCheckDialog.this.dismiss();
                    return;
                }
                if (UpdateCheckDialog.this.mHelper.isRealCurrentVersionOut()) {
                    UpdateCheckDialog.this.isClick = true;
                    UpdateCheckDialog.this.mHelper.cancelNotifyAvai();
                    File updateReadyApk = UpdateCheckDialog.this.mHelper.getUpdateReadyApk();
                    if (updateReadyApk != null) {
                        UpdateCheckDialog.this.mHelper.cancelNotifyReady();
                        UpdateCheckDialog.this.mHelper.installApk(UpdateCheckDialog.this.mContext, updateReadyApk);
                    } else {
                        UpdateCheckDialog.this.mHelper.startDownload();
                    }
                    UpdateCheckDialog.this.mHelper.clickUpdateButton(false);
                    UpdateCheckDialog.this.dismiss();
                    return;
                }
                UpdateCheckDialog.this.dismiss();
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ss.android.update.UpdateCheckDialog.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (UpdateCheckDialog.this.isClick) {
                    UpdateCheckDialog.this.isClick = false;
                } else {
                    UpdateCheckDialog.this.mHelper.clickCloseButton(false);
                }
            }
        });
    }

    @Override // com.ss.android.update.IUpdateCheckDialog
    public void showCheckDialog(int i) {
        show();
        this.mHelper.showUpdateDialogScene(false);
    }

    @Override // com.ss.android.update.IUpdateCheckDialog
    public boolean isShowCheckDialog() {
        return isShowing();
    }
}
