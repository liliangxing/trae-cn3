package com.bytedance.ug.sdk.share.impl.p009ui.token.share;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.TokenShareInfo;
import com.bytedance.ug.sdk.share.api.p008ui.IShareTokenDialog;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.utils.UIUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TokenShareDialog extends SSDialog implements IShareTokenDialog {
    private ImageView mCloseIcon;
    private IShareTokenDialog.ITokenDialogCallback mDialogCallback;
    private TextView mTipsTV;
    private TextView mTitleTV;
    private Button mToCopyBt;
    private TextView mTokenContentTV;
    private TokenShareInfo mTokenShareInfo;

    public TokenShareDialog(Activity activity) {
        super(activity, R.style.share_sdk_token_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.share_sdk_token_share_dialog);
        Window window = getWindow();
        window.setLayout(-1, -2);
        window.setGravity(17);
        initViews();
    }

    private void initViews() {
        this.mTitleTV = (TextView) findViewById(R.id.title);
        this.mCloseIcon = (ImageView) findViewById(R.id.close_icon);
        this.mTokenContentTV = (TextView) findViewById(R.id.token_content);
        this.mToCopyBt = (Button) findViewById(R.id.to_copy_btn);
        this.mTipsTV = (TextView) findViewById(R.id.tips);
        TokenShareInfo tokenShareInfo = this.mTokenShareInfo;
        if (tokenShareInfo != null) {
            if (!TextUtils.isEmpty(tokenShareInfo.getTitle())) {
                this.mTitleTV.setText(this.mTokenShareInfo.getTitle());
            }
            if (!TextUtils.isEmpty(this.mTokenShareInfo.getDescription())) {
                this.mTokenContentTV.setText(this.mTokenShareInfo.getDescription());
                this.mTokenContentTV.setLineSpacing(0.0f, 1.1f);
            }
            if (TextUtils.isEmpty(this.mTokenShareInfo.getTips())) {
                UIUtils.setViewVisibility(this.mTipsTV, 4);
            } else {
                this.mTipsTV.setText(this.mTokenShareInfo.getTips());
            }
        }
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.share.TokenShareDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TokenShareDialog.this.dismiss();
            }
        });
        this.mToCopyBt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.share.TokenShareDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TokenShareDialog.this.mDialogCallback != null) {
                    TokenShareDialog.this.mDialogCallback.onClick(true);
                }
            }
        });
        ((GradientDrawable) this.mToCopyBt.getBackground()).setColor(ShareConfigManager.getInstance().getTokenButtonBgColor());
        this.mToCopyBt.setTextColor(ShareConfigManager.getInstance().getTokenButtonTextColor());
    }

    @Override // com.bytedance.ug.sdk.share.api.p008ui.IShareTokenDialog
    public void initTokenDialog(ShareContent shareContent, IShareTokenDialog.ITokenDialogCallback iTokenDialogCallback) {
        if (shareContent != null) {
            this.mTokenShareInfo = shareContent.getTokenShareInfo();
        }
        this.mDialogCallback = iTokenDialogCallback;
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog, android.app.Dialog, android.content.DialogInterface, com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel
    public void dismiss() {
        super.dismiss();
        IShareTokenDialog.ITokenDialogCallback iTokenDialogCallback = this.mDialogCallback;
        if (iTokenDialogCallback != null) {
            iTokenDialogCallback.onDismiss();
        }
    }
}
