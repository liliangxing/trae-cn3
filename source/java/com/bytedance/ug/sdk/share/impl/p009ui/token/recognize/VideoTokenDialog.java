package com.bytedance.ug.sdk.share.impl.p009ui.token.recognize;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoTokenDialog extends AbsTokenDialog {
    private ImageView mCoverImg;

    public VideoTokenDialog(Activity activity) {
        super(activity);
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.AbsTokenDialog
    public int getLayoutId() {
        return R.layout.share_sdk_video_login_token_dialog;
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.AbsTokenDialog
    public void initViews() {
        if (this.mTitleTV != null) {
            this.mTitleTV.setMaxLines(2);
        }
        this.mCoverImg = (ImageView) findViewById(R.id.cover_img);
        if (this.mTokenInfoBean.getPics() == null || this.mTokenInfoBean.getPics().size() <= 0) {
            return;
        }
        ShareConfigManager.getInstance().getImageBitmap(this.mTokenInfoBean.getPics().get(0).getUrl(), new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.recognize.VideoTokenDialog.1
            @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
            public void onFailed() {
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
            public void onSuccess(final Bitmap bitmap) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.recognize.VideoTokenDialog.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (VideoTokenDialog.this.mCoverImg == null || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        VideoTokenDialog.this.mCoverImg.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.token.recognize.AbsTokenDialog
    public void initActions() {
        ImageView imageView = this.mCoverImg;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.token.recognize.VideoTokenDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoTokenDialog.this.onReadbtnClicked();
            }
        });
    }
}
