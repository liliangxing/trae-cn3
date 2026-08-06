package com.bytedance.ug.sdk.share.channel.imageshare.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.share_image_token.R;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.image.action.ImageTokenShareAction;
import com.bytedance.ug.sdk.share.image.utils.ImageConfigUtils;
import com.bytedance.ug.sdk.share.image.utils.ImageSaveUtils;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.share.AbstractShare;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageShare extends AbstractShare {
    public ImageShare(Context context) {
        super(context);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean doShare(ShareContent shareContent) {
        this.mShareContent = shareContent;
        if (ImageConfigUtils.hideSaveImagePreviewDialog()) {
            return saveImage(shareContent);
        }
        return ImageTokenShareAction.getInstance().shareTo(this.mContext, ShareChannelType.IMAGE_SHARE, shareContent);
    }

    private boolean saveImage(final ShareContent shareContent) {
        if (shareContent.getImage() == null) {
            if (TextUtils.isEmpty(shareContent.getHiddenImageUrl())) {
                showSaveResult(false, shareContent);
                return false;
            }
            ShareConfigManager.getInstance().getImageBitmap(shareContent.getHiddenImageUrl(), new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.channel.imageshare.impl.ImageShare.1
                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onSuccess(Bitmap bitmap) {
                    shareContent.setImage(bitmap);
                    ImageShare.this.saveBitmapToAlbum(shareContent);
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onFailed() {
                    ImageShare.this.showSaveResult(false, shareContent);
                }
            });
            return true;
        }
        return saveBitmapToAlbum(shareContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveBitmapToAlbum(final ShareContent shareContent) {
        return ImageSaveUtils.saveBitmapToAlbum(ShareConfigManager.getInstance().getTopActivity(), shareContent, new ImageSaveUtils.ImageSaveCallback() { // from class: com.bytedance.ug.sdk.share.channel.imageshare.impl.ImageShare.2
            @Override // com.bytedance.ug.sdk.share.image.utils.ImageSaveUtils.ImageSaveCallback
            public void onResult(boolean z) {
                ImageShare.this.showSaveResult(z, shareContent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSaveResult(boolean z, ShareContent shareContent) {
        if (z) {
            ToastUtils.showToast(this.mContext, shareContent, 8, R.string.share_sdk_had_saved_to_album);
        } else {
            ToastUtils.showToast(this.mContext, shareContent, 9, R.string.share_sdk_image_share_save_failed);
        }
        ShareResult.sendShareStatus(z ? 10000 : ShareResult.SHARE_FAILED, shareContent);
    }
}
