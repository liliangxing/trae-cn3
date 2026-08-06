package com.bytedance.bdturing.comonui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.bdturing.R;

/* loaded from: classes3.dex */
public class PermissionAlertDialog extends Dialog {
    private boolean mCancelable;
    private View mContentView;
    protected Activity mContext;
    private TuringAlertDialogCallBack mDialogCallback;
    private View mHorizontalDivideLine;
    private TextView mLeftBtn;
    private AlertDialogParam mParam;
    private TextView mRightBtn;
    private AlertDialogTheme mTheme;
    private TextView mTvContent;
    private TextView mTvTitle;
    private View mVerticalDivideLine;

    public PermissionAlertDialog(Activity activity, AlertDialogParam alertDialogParam, boolean z, TuringAlertDialogCallBack turingAlertDialogCallBack) {
        this(activity, alertDialogParam, null, z, turingAlertDialogCallBack);
    }

    public PermissionAlertDialog(Activity activity, AlertDialogParam alertDialogParam, AlertDialogTheme alertDialogTheme, boolean z, TuringAlertDialogCallBack turingAlertDialogCallBack) {
        super(activity, R.style.BdTuring_Alert_Dialog);
        this.mContext = activity;
        this.mDialogCallback = turingAlertDialogCallBack;
        this.mParam = alertDialogParam;
        this.mTheme = alertDialogTheme;
        this.mCancelable = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bdturing_permission_dialog_layout);
        initWindow();
        initView();
        setTheme();
        bindData();
        initAction();
    }

    private void initWindow() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
    }

    private void setTheme() {
        AlertDialogTheme alertDialogTheme = this.mTheme;
        if (alertDialogTheme == null) {
            return;
        }
        this.mTvTitle.setTextSize(alertDialogTheme.getTitleTextSize());
        this.mTvTitle.setTextColor(this.mTheme.getTitleTextColor());
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTvTitle.getLayoutParams();
        marginLayoutParams.topMargin = dpToPix(getContext(), this.mTheme.getTitleTopMargin());
        this.mTvTitle.setLayoutParams(marginLayoutParams);
        this.mTvContent.setTextSize(this.mTheme.getContentTextSize());
        this.mTvContent.setTextColor(this.mTheme.getContentTextColor());
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mTvContent.getLayoutParams();
        marginLayoutParams2.topMargin = dpToPix(getContext(), this.mTheme.getContentTopMargin());
        this.mTvContent.setLayoutParams(marginLayoutParams2);
        this.mLeftBtn.setTextSize(this.mTheme.getCancelTextSize());
        this.mLeftBtn.setTextColor(this.mTheme.getCancelTextColor());
        if (this.mTheme.getCancelBtnBg() != null) {
            this.mLeftBtn.setBackground(this.mTheme.getCancelBtnBg());
        }
        this.mRightBtn.setTextSize(this.mTheme.getConfirmTextSize());
        this.mRightBtn.setTextColor(this.mTheme.getConfirmTextColor());
        if (this.mTheme.getConfirmBtnBg() != null) {
            this.mRightBtn.setBackground(this.mTheme.getConfirmBtnBg());
        }
        this.mHorizontalDivideLine.setBackgroundColor(this.mTheme.getDivideLineColor());
        int dpToPix = dpToPix(getContext(), this.mTheme.getDivideLineHeight());
        ViewGroup.LayoutParams layoutParams = this.mHorizontalDivideLine.getLayoutParams();
        layoutParams.height = dpToPix;
        this.mHorizontalDivideLine.setLayoutParams(layoutParams);
        this.mVerticalDivideLine.setBackgroundColor(this.mTheme.getDivideLineColor());
        ViewGroup.LayoutParams layoutParams2 = this.mVerticalDivideLine.getLayoutParams();
        layoutParams2.width = dpToPix;
        this.mVerticalDivideLine.setLayoutParams(layoutParams2);
        if (this.mTheme.getDialogBg() != null) {
            this.mContentView.setBackground(this.mTheme.getDialogBg());
        }
    }

    private void bindData() {
        if (!TextUtils.isEmpty(this.mParam.title)) {
            this.mTvTitle.setText(this.mParam.title);
        }
        if (!TextUtils.isEmpty(this.mParam.contentText)) {
            this.mTvContent.setText(this.mParam.contentText);
        }
        if (!TextUtils.isEmpty(this.mParam.lefBtnText)) {
            this.mLeftBtn.setText(this.mParam.lefBtnText);
        }
        if (TextUtils.isEmpty(this.mParam.rightBtnText)) {
            return;
        }
        this.mRightBtn.setText(this.mParam.rightBtnText);
    }

    private void initView() {
        this.mHorizontalDivideLine = findViewById(R.id.v_divide_line_h);
        this.mVerticalDivideLine = findViewById(R.id.v_divide_line_v);
        this.mTvTitle = (TextView) findViewById(R.id.tv_dlg_title);
        this.mTvContent = (TextView) findViewById(R.id.tv_dlg_content);
        this.mLeftBtn = (TextView) findViewById(R.id.tv_alert_dlg_left);
        this.mRightBtn = (TextView) findViewById(R.id.tv_alert_dlg_right);
        this.mContentView = findViewById(R.id.root_view);
        setCancelable(this.mCancelable);
    }

    private void initAction() {
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.bdturing.comonui.PermissionAlertDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (PermissionAlertDialog.this.mDialogCallback != null) {
                    PermissionAlertDialog.this.mDialogCallback.onCancel();
                }
            }
        });
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.bdturing.comonui.PermissionAlertDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PermissionAlertDialog.this.mDialogCallback != null) {
                    PermissionAlertDialog.this.mDialogCallback.onLeftBtnClick();
                }
            }
        });
        this.mRightBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.bdturing.comonui.PermissionAlertDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PermissionAlertDialog.this.mDialogCallback != null) {
                    PermissionAlertDialog.this.mDialogCallback.onRightBtnClick();
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

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int dpToPix(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
