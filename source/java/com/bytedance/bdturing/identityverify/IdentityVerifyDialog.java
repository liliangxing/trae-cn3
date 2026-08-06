package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.theme.IdentityVerifyDialogTheme;
import com.bytedance.bdturing.theme.ThemeConfig;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class IdentityVerifyDialog extends Dialog {
    private TextView mCancel;
    private TextView mConfirm;
    private View mContentView;
    protected Activity mContext;
    private DialogCallback mDialogCallback;
    private View mHorizontalDivideLine;
    private TextView mTvContent;
    private TextView mTvTitle;
    private View mVerticalDivideLine;

    public IdentityVerifyDialog(Activity activity, DialogCallback dialogCallback) {
        super(activity, C0603R.style.BdTuring_Identify_Dialog);
        this.mContext = activity;
        this.mDialogCallback = dialogCallback;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0603R.layout.bdturing_identity_verify_dialog_layout);
        initView();
        bindData();
        initAction();
    }

    private void bindData() {
        IdentityVerifyDialogTheme identityVerifyDialogTheme;
        ThemeConfig themeConfig = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getThemeConfig() : null;
        if (themeConfig == null || (identityVerifyDialogTheme = themeConfig.getIdentityVerifyDialogTheme()) == null) {
            return;
        }
        this.mTvTitle.setTextSize(identityVerifyDialogTheme.getTitleTextSize());
        this.mTvTitle.setTextColor(identityVerifyDialogTheme.getTitleTextColor());
        if (!TextUtils.isEmpty(identityVerifyDialogTheme.getTitle())) {
            this.mTvTitle.setText(identityVerifyDialogTheme.getTitle());
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTvTitle.getLayoutParams();
        marginLayoutParams.topMargin = dpToPix(getContext(), identityVerifyDialogTheme.getTitleTopMargin());
        this.mTvTitle.setLayoutParams(marginLayoutParams);
        this.mTvContent.setTextSize(identityVerifyDialogTheme.getContentTextSize());
        this.mTvContent.setTextColor(identityVerifyDialogTheme.getContentTextColor());
        if (!TextUtils.isEmpty(identityVerifyDialogTheme.getContent())) {
            this.mTvContent.setText(identityVerifyDialogTheme.getContent());
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mTvContent.getLayoutParams();
        marginLayoutParams2.topMargin = dpToPix(getContext(), identityVerifyDialogTheme.getContentTopMargin());
        this.mTvContent.setLayoutParams(marginLayoutParams2);
        this.mCancel.setTextSize(identityVerifyDialogTheme.getCancelTextSize());
        this.mCancel.setTextColor(identityVerifyDialogTheme.getCancelTextColor());
        if (!TextUtils.isEmpty(identityVerifyDialogTheme.getCancelText())) {
            this.mCancel.setText(identityVerifyDialogTheme.getCancelText());
        }
        if (identityVerifyDialogTheme.getCancelBtnBg() != null) {
            this.mCancel.setBackground(identityVerifyDialogTheme.getCancelBtnBg());
        }
        this.mConfirm.setTextSize(identityVerifyDialogTheme.getConfirmTextSize());
        this.mConfirm.setTextColor(identityVerifyDialogTheme.getConfirmTextColor());
        if (!TextUtils.isEmpty(identityVerifyDialogTheme.getConfirmText())) {
            this.mConfirm.setText(identityVerifyDialogTheme.getConfirmText());
        }
        if (identityVerifyDialogTheme.getConfirmBtnBg() != null) {
            this.mConfirm.setBackground(identityVerifyDialogTheme.getConfirmBtnBg());
        }
        this.mHorizontalDivideLine.setBackgroundColor(identityVerifyDialogTheme.getDivideLineColor());
        int dpToPix = dpToPix(getContext(), identityVerifyDialogTheme.getDivideLineHeight());
        ViewGroup.LayoutParams layoutParams = this.mHorizontalDivideLine.getLayoutParams();
        layoutParams.height = dpToPix;
        this.mHorizontalDivideLine.setLayoutParams(layoutParams);
        this.mVerticalDivideLine.setBackgroundColor(identityVerifyDialogTheme.getDivideLineColor());
        ViewGroup.LayoutParams layoutParams2 = this.mVerticalDivideLine.getLayoutParams();
        layoutParams2.width = dpToPix;
        this.mVerticalDivideLine.setLayoutParams(layoutParams2);
        if (identityVerifyDialogTheme.getDialogBg() != null) {
            this.mContentView.setBackground(identityVerifyDialogTheme.getDialogBg());
        }
    }

    private void initView() {
        this.mHorizontalDivideLine = findViewById(C0603R.id.v_divide_line_h);
        this.mVerticalDivideLine = findViewById(C0603R.id.v_divide_line_v);
        this.mTvTitle = (TextView) findViewById(C0603R.id.tv_dlg_title);
        this.mTvContent = (TextView) findViewById(C0603R.id.tv_dlg_content);
        this.mCancel = (TextView) findViewById(C0603R.id.tv_dlg_cancel);
        this.mConfirm = (TextView) findViewById(C0603R.id.tv_dlg_confirm);
        this.mContentView = findViewById(C0603R.id.root_view);
    }

    private void initAction() {
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.bdturing.identityverify.IdentityVerifyDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (IdentityVerifyDialog.this.mDialogCallback != null) {
                    IdentityVerifyDialog.this.mDialogCallback.onCancel();
                }
            }
        });
        this.mCancel.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.bdturing.identityverify.IdentityVerifyDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IdentityVerifyDialog.this.mDialogCallback != null) {
                    IdentityVerifyDialog.this.mDialogCallback.onCancel();
                }
                IdentityVerifyDialog.this.safeDismiss();
            }
        });
        this.mConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.bdturing.identityverify.IdentityVerifyDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IdentityVerifyDialog.this.mDialogCallback != null) {
                    IdentityVerifyDialog.this.mDialogCallback.onConfirm();
                    IdentityVerifyDialog.this.safeDismiss();
                }
            }
        });
    }

    public boolean isViewValid() {
        return !this.mContext.isFinishing();
    }

    public Activity getHostActivity() {
        return this.mContext;
    }

    @Override // android.app.Dialog
    public void show() {
        if (isViewValid()) {
            super.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeDismiss() {
        try {
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int dpToPix(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
