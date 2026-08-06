package com.bytedance.ug.sdk.share.impl.p009ui.token.recognize;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.entity.RecognizeDialogClickType;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.api.p008ui.IRecognizeTokenDialog;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.utils.UIUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsTokenDialog extends SSDialog implements IRecognizeTokenDialog {
    protected final String SHARE_TIPS;
    private ImageView mCloseIcon;
    protected Activity mContext;
    protected Dialog mDialog;
    private IRecognizeTokenDialog.ITokenDialogCallback mDialogCallback;
    private Button mReadBt;
    protected TextView mTitleTV;
    protected TokenInfoBean mTokenInfoBean;

    public abstract int getLayoutId();

    public abstract void initActions();

    public abstract void initViews();

    public AbsTokenDialog(Activity activity) {
        super(activity, R.style.share_sdk_token_dialog);
        this.SHARE_TIPS = "此分享来自";
        this.mContext = activity;
        this.mDialog = this;
    }

    @Override // com.bytedance.ug.sdk.share.api.p008ui.IRecognizeTokenDialog
    public void initTokenDialog(TokenInfoBean tokenInfoBean, IRecognizeTokenDialog.ITokenDialogCallback iTokenDialogCallback) {
        this.mTokenInfoBean = tokenInfoBean;
        this.mDialogCallback = iTokenDialogCallback;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.setLayout(-1, -2);
        window.setGravity(17);
        this.mTitleTV = (TextView) findViewById(R.id.title);
        this.mCloseIcon = (ImageView) findViewById(R.id.close_icon);
        this.mReadBt = (Button) findViewById(R.id.token_btn);
        if (!TextUtils.isEmpty(this.mTokenInfoBean.getButtonText())) {
            this.mReadBt.setText(this.mTokenInfoBean.getButtonText());
        }
        this.mTitleTV.setText(this.mTokenInfoBean.getTitle());
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.recognize.AbsTokenDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbsTokenDialog.this.onCloseIconClicked();
            }
        });
        this.mReadBt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.recognize.AbsTokenDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbsTokenDialog.this.onReadbtnClicked();
            }
        });
        ((GradientDrawable) this.mReadBt.getBackground()).setColor(ShareConfigManager.getInstance().getTokenButtonBgColor());
        this.mReadBt.setTextColor(ShareConfigManager.getInstance().getTokenButtonTextColor());
        this.mTitleTV.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.recognize.AbsTokenDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbsTokenDialog.this.onReadbtnClicked();
            }
        });
        bindShareUserInfo();
        initViews();
        initActions();
    }

    protected void onCloseIconClicked() {
        IRecognizeTokenDialog.ITokenDialogCallback iTokenDialogCallback = this.mDialogCallback;
        if (iTokenDialogCallback != null) {
            iTokenDialogCallback.onClick(true, RecognizeDialogClickType.CLICK_TYPE_CLOSE, this.mTokenInfoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onReadbtnClicked() {
        IRecognizeTokenDialog.ITokenDialogCallback iTokenDialogCallback = this.mDialogCallback;
        if (iTokenDialogCallback != null) {
            iTokenDialogCallback.onClick(true, RecognizeDialogClickType.CLICK_TYPE_DETAIL, this.mTokenInfoBean);
        }
    }

    protected void bindShareUserInfo() {
        TextView textView = (TextView) findViewById(R.id.share_user_info);
        View findViewById = findViewById(R.id.share_user_info_layout);
        if (this.mTokenInfoBean.getShareUserInfo() != null && !TextUtils.isEmpty(this.mTokenInfoBean.getShareUserInfo().getName())) {
            UIUtils.setViewVisibility(textView, 0);
            textView.setText("此分享来自" + this.mTokenInfoBean.getShareUserInfo().getName());
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.recognize.AbsTokenDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AbsTokenDialog.this.mDialogCallback != null) {
                        AbsTokenDialog.this.mDialogCallback.onClick(true, RecognizeDialogClickType.CLICK_TYPE_USER_DETAIL, AbsTokenDialog.this.mTokenInfoBean);
                    }
                }
            });
            return;
        }
        UIUtils.setViewVisibility(findViewById, 8);
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog, android.app.Dialog, android.content.DialogInterface, com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel
    public void dismiss() {
        super.dismiss();
        IRecognizeTokenDialog.ITokenDialogCallback iTokenDialogCallback = this.mDialogCallback;
        if (iTokenDialogCallback != null) {
            iTokenDialogCallback.onDismiss();
        }
    }
}
