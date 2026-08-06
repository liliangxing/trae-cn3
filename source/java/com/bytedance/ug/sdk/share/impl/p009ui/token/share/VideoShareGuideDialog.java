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
import com.bytedance.ug.sdk.share.api.p008ui.IVideoGuideDialog;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.utils.DebouncingOnClickListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoShareGuideDialog extends SSDialog implements IVideoGuideDialog {
    private String mBtnText;
    private ImageView mCloseIv;
    private TextView mContentTv;
    private Button mContinueBtn;
    private IVideoGuideDialog.ITokenDialogCallback mDialogCallback;
    private String mTips;
    private String mTitle;
    private TextView mTitleTv;

    public VideoShareGuideDialog(Activity activity) {
        super(activity, R.style.share_sdk_token_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.share_sdk_video_share_dialog);
        Window window = getWindow();
        window.setLayout(-1, -2);
        window.setGravity(17);
        initViews();
    }

    private void initViews() {
        ImageView imageView = (ImageView) findViewById(R.id.share_close_iv);
        this.mCloseIv = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.share.VideoShareGuideDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoShareGuideDialog.this.dismiss();
            }
        });
        Button button = (Button) findViewById(R.id.continue_btn);
        this.mContinueBtn = button;
        button.setOnClickListener(new DebouncingOnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.share.VideoShareGuideDialog.2
            @Override // com.bytedance.ug.sdk.share.impl.p009ui.utils.DebouncingOnClickListener
            public void doClick(View view) {
                if (VideoShareGuideDialog.this.mDialogCallback != null) {
                    VideoShareGuideDialog.this.mDialogCallback.onClick(true);
                }
            }
        });
        this.mTitleTv = (TextView) findViewById(R.id.share_title_tv);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTv.setText(this.mTitle);
        }
        this.mContentTv = (TextView) findViewById(R.id.share_content_tv);
        if (!TextUtils.isEmpty(this.mTips)) {
            this.mContentTv.setText(this.mTips);
        }
        if (!TextUtils.isEmpty(this.mBtnText)) {
            this.mContinueBtn.setText(this.mBtnText);
        }
        ((GradientDrawable) this.mContinueBtn.getBackground()).setColor(ShareConfigManager.getInstance().getTokenButtonBgColor());
        this.mContinueBtn.setTextColor(ShareConfigManager.getInstance().getTokenButtonTextColor());
    }

    @Override // com.bytedance.ug.sdk.share.api.p008ui.IVideoGuideDialog
    public void initTokenDialog(ShareContent shareContent, IVideoGuideDialog.ITokenDialogCallback iTokenDialogCallback) {
        this.mTitle = this.mContext.getString(R.string.share_sdk_video_share_dialog_title);
        String shareChannelName = ShareChannelType.getShareChannelName(shareContent.getShareChanelType());
        this.mTips = String.format(this.mContext.getString(R.string.share_sdk_video_share_dialog_tips), shareChannelName, shareChannelName);
        this.mBtnText = this.mContext.getString(R.string.share_sdk_save_and_share);
        this.mDialogCallback = iTokenDialogCallback;
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog, android.app.Dialog, android.content.DialogInterface, com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel
    public void dismiss() {
        super.dismiss();
        IVideoGuideDialog.ITokenDialogCallback iTokenDialogCallback = this.mDialogCallback;
        if (iTokenDialogCallback != null) {
            iTokenDialogCallback.onDismiss();
        }
    }
}
