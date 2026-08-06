package com.bytedance.ug.sdk.share.impl.p009ui.token.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.TokenShareInfo;
import com.bytedance.ug.sdk.share.api.p008ui.IImageTokenDialog;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.utils.UIUtils;
import com.bytedance.ug.sdk.share.impl.utils.ImageUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageTokenShareDialog extends SSDialog implements IImageTokenDialog {
    private static final int IMAGE_MATCH_HEIGHT_SIZE = 274;
    private static final int IMAGE_MATCH_WIDTH_SIZE = 220;
    private static final float SCALE_SIZE = 1.5f;
    private ImageView mCloseIcon;
    private IImageTokenDialog.ITokenDialogCallback mDialogCallback;
    private Bitmap mImageViewBitmap;
    private ScrollView mLongImageContainerView;
    private ImageView mLongImageView;
    private ShareContent mShareContent;
    private TextView mTipsView;
    private TextView mTitleView;
    private Button mToSaveAndShareBt;
    private ImageView mTokenImageView;
    private TokenShareInfo mTokenShareInfo;

    public ImageTokenShareDialog(Activity activity) {
        super(activity, R.style.share_sdk_token_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.share_sdk_image_token_share_dialog);
        Window window = getWindow();
        window.setLayout(-1, -2);
        window.setGravity(17);
        initViews();
    }

    private void initViews() {
        ImageView imageView = (ImageView) findViewById(R.id.close_icon);
        this.mCloseIcon = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.share.ImageTokenShareDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageTokenShareDialog.this.dismiss();
            }
        });
        Button button = (Button) findViewById(R.id.to_save_and_share_btn);
        this.mToSaveAndShareBt = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.share.ImageTokenShareDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageTokenShareDialog.this.mDialogCallback != null) {
                    ImageTokenShareDialog.this.mDialogCallback.onClick(true);
                }
            }
        });
        this.mTokenImageView = (ImageView) findViewById(R.id.token_image);
        this.mLongImageContainerView = (ScrollView) findViewById(R.id.token_long_image_container);
        this.mLongImageView = (ImageView) findViewById(R.id.token_long_imageview);
        Bitmap bitmap = this.mImageViewBitmap;
        if (bitmap != null) {
            if (((float) bitmap.getHeight()) * UIUtils.dip2Px(getContext(), 220.0f) > (((float) this.mImageViewBitmap.getWidth()) * SCALE_SIZE) * UIUtils.dip2Px(getContext(), 274.0f)) {
                this.mLongImageContainerView.setVisibility(0);
                this.mLongImageView.setImageBitmap(ImageUtils.compressBitmap(this.mImageViewBitmap));
                if (ShareConfigManager.getInstance().getLongImageOffsetY() != 0.0f) {
                    this.mLongImageView.setTranslationY(-ShareConfigManager.getInstance().getLongImageOffsetY());
                }
                this.mTokenImageView.setVisibility(8);
            } else {
                this.mTokenImageView.setVisibility(0);
                this.mTokenImageView.setImageBitmap(this.mImageViewBitmap);
                this.mLongImageContainerView.setVisibility(8);
            }
        }
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mTipsView = (TextView) findViewById(R.id.token_content);
        TokenShareInfo tokenShareInfo = this.mTokenShareInfo;
        if (tokenShareInfo != null) {
            String title = tokenShareInfo.getTitle();
            if (!TextUtils.isEmpty(title)) {
                this.mTitleView.setText(title);
            }
            String tips = this.mTokenShareInfo.getTips();
            if (!TextUtils.isEmpty(tips)) {
                this.mTipsView.setText(tips);
            } else {
                this.mTipsView.setVisibility(8);
            }
        }
        ((GradientDrawable) this.mToSaveAndShareBt.getBackground()).setColor(ShareConfigManager.getInstance().getTokenButtonBgColor());
        this.mToSaveAndShareBt.setTextColor(ShareConfigManager.getInstance().getTokenButtonTextColor());
    }

    @Override // com.bytedance.ug.sdk.share.api.p008ui.IImageTokenDialog
    public void initTokenDialog(ShareContent shareContent, IImageTokenDialog.ITokenDialogCallback iTokenDialogCallback) {
        this.mShareContent = shareContent;
        if (shareContent != null) {
            this.mImageViewBitmap = shareContent.getImage();
            if (this.mShareContent.getImageTokenShareInfo() != null) {
                this.mTokenShareInfo = this.mShareContent.getImageTokenShareInfo();
            } else {
                this.mTokenShareInfo = this.mShareContent.getTokenShareInfo();
            }
        }
        this.mDialogCallback = iTokenDialogCallback;
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog, android.app.Dialog, android.content.DialogInterface, com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel
    public void dismiss() {
        super.dismiss();
        IImageTokenDialog.ITokenDialogCallback iTokenDialogCallback = this.mDialogCallback;
        if (iTokenDialogCallback != null) {
            iTokenDialogCallback.onDismiss();
        }
    }

    @Override // android.app.Dialog, com.bytedance.ug.sdk.share.api.p008ui.IImageTokenDialog
    public boolean isShowing() {
        return super.isShowing();
    }
}
