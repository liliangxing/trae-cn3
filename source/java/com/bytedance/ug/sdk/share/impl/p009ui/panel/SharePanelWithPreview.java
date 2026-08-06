package com.bytedance.ug.sdk.share.impl.p009ui.panel;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.impl.utils.ImageUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SharePanelWithPreview extends GeneralSharePanel {
    private Bitmap mBitmap;
    private ImageView mLongImageView;
    private ShareContent mShareContent;

    public SharePanelWithPreview(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.GeneralSharePanel
    public void initViews() {
        super.initViews();
        ShareContent shareContent = this.mPanelContent.getShareContent();
        this.mShareContent = shareContent;
        Bitmap image = shareContent.getImage();
        this.mBitmap = image;
        if (image != null) {
            if (this.mWindow != null) {
                this.mWindow.setLayout(-1, -1);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
            layoutParams.height = -1;
            this.mRootView.setLayoutParams(layoutParams);
            this.mLongImageView = (ImageView) ((ViewStub) findViewById(R.id.long_image_layout)).inflate().findViewById(R.id.long_image_view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.GeneralSharePanel
    public void initData() {
        super.initData();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mLongImageView.setImageBitmap(ImageUtils.compressBitmap(bitmap));
        }
    }
}
