package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.theme.IdentityVerifyDialogTheme;
import com.bytedance.bdturing.theme.ThemeConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class IdentityDialogActivity extends AppCompatActivity {
    private static final String TAG = "IdentityDialogActivity";
    private TextView mCancel;
    private TextView mConfirm;
    private View mContentView;
    private DialogCallback mDialogCallback;
    private View mHorizontalDivideLine;
    private TextView mTvContent;
    private TextView mTvTitle;
    private View mVerticalDivideLine;

    /* renamed from: com_bytedance_bdturing_identityverify_IdentityDialogActivity__onStop$___twin___ */
    public void m170xc3166538() {
        super.onStop();
    }

    protected void onStop() {
        m169x4bc3afc3(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0603R.layout.bdturing_identity_dialog_activity);
        initView();
        bindData();
        initAction();
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

    /* JADX WARN: Multi-variable type inference failed */
    private void bindData() {
        IdentityVerifyDialogTheme identityVerifyDialogTheme;
        this.mDialogCallback = IdentityVerifyService.getInstance().getDialogCallback();
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
        marginLayoutParams.topMargin = dpToPix(this, identityVerifyDialogTheme.getTitleTopMargin());
        this.mTvTitle.setLayoutParams(marginLayoutParams);
        this.mTvContent.setTextSize(identityVerifyDialogTheme.getContentTextSize());
        this.mTvContent.setTextColor(identityVerifyDialogTheme.getContentTextColor());
        if (!TextUtils.isEmpty(identityVerifyDialogTheme.getContent())) {
            this.mTvContent.setText(identityVerifyDialogTheme.getContent());
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mTvContent.getLayoutParams();
        marginLayoutParams2.topMargin = dpToPix(this, identityVerifyDialogTheme.getContentTopMargin());
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
        int dpToPix = dpToPix(this, identityVerifyDialogTheme.getDivideLineHeight());
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

    private int dpToPix(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private void initAction() {
        this.mCancel.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.bdturing.identityverify.IdentityDialogActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IdentityDialogActivity.this.mDialogCallback != null) {
                    IdentityDialogActivity.this.mDialogCallback.onCancel();
                }
                IdentityDialogActivity.this.mDialogCallback = null;
                IdentityDialogActivity.this.finish();
            }
        });
        this.mConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.bdturing.identityverify.IdentityDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (IdentityDialogActivity.this.mDialogCallback != null) {
                    IdentityDialogActivity.this.mDialogCallback.onConfirm();
                }
                IdentityDialogActivity.this.mDialogCallback = null;
                IdentityDialogActivity.this.finish();
            }
        });
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    protected void onDestroy() {
        super.onDestroy();
        DialogCallback dialogCallback = this.mDialogCallback;
        if (dialogCallback != null) {
            dialogCallback.onCancel();
        }
        this.mDialogCallback = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_identityverify_IdentityDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m169x4bc3afc3(IdentityDialogActivity identityDialogActivity) {
        identityDialogActivity.m170xc3166538();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) identityDialogActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
