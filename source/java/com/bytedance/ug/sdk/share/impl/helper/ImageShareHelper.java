package com.bytedance.ug.sdk.share.impl.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.impl.callback.ImageShareBitmapCallback;
import com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.LoadingUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import java.io.File;
import java.util.UUID;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageShareHelper {
    private final String TAG = "ImageShareHelper";

    public boolean isLocalUrl(String str) {
        return !HttpUtils.isUrl(str);
    }

    public void shareImage(ShareContent shareContent, ImageShareBitmapCallback imageShareBitmapCallback) {
        if (imageShareBitmapCallback == null) {
            return;
        }
        Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (topActivity == null) {
            imageShareBitmapCallback.onShareFailed();
            return;
        }
        String imageUrl = shareContent.getImageUrl();
        if (TextUtils.isEmpty(imageUrl)) {
            if (shareContent.getImage() != null) {
                imageShareBitmapCallback.onShareSuccess(shareContent.getImage());
                return;
            } else {
                imageShareBitmapCallback.onShareFailed();
                return;
            }
        }
        getImageBitmap(topActivity, shareContent, imageUrl, imageShareBitmapCallback);
    }

    public void getImageBitmap(final Context context, final ShareContent shareContent, String str, final ImageShareBitmapCallback imageShareBitmapCallback) {
        if (isLocalUrl(str)) {
            Bitmap bitmapFromSD = FileUtils.getBitmapFromSD(str);
            if (bitmapFromSD == null) {
                imageShareBitmapCallback.onShareFailed();
                return;
            } else {
                imageShareBitmapCallback.onShareSuccess(bitmapFromSD);
                return;
            }
        }
        LoadingUtils.showProgressDialog(shareContent);
        ShareConfigManager.getInstance().getImageBitmap(str, new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.impl.helper.ImageShareHelper.1
            @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
            public void onSuccess(Bitmap bitmap) {
                LoadingUtils.dismissProgressDialog();
                if (bitmap == null || bitmap.isRecycled()) {
                    ImageShareBitmapCallback imageShareBitmapCallback2 = imageShareBitmapCallback;
                    if (imageShareBitmapCallback2 != null) {
                        imageShareBitmapCallback2.onShareFailed();
                        return;
                    }
                    return;
                }
                ImageShareBitmapCallback imageShareBitmapCallback3 = imageShareBitmapCallback;
                if (imageShareBitmapCallback3 != null) {
                    imageShareBitmapCallback3.onShareSuccess(bitmap);
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
            public void onFailed() {
                LoadingUtils.dismissProgressDialog();
                ImageShareBitmapCallback imageShareBitmapCallback2 = imageShareBitmapCallback;
                if (imageShareBitmapCallback2 != null) {
                    imageShareBitmapCallback2.onShareFailed();
                }
                ToastUtils.showToast(context, shareContent, 4, C1010R.string.share_sdk_image_share_save_failed);
            }
        });
    }

    public void shareImage(final ShareContent shareContent, final ImageShareCallback imageShareCallback, boolean z) {
        final Activity topActivity;
        if (shareContent == null || TextUtils.isEmpty(shareContent.getImageUrl()) || (topActivity = ShareConfigManager.getInstance().getTopActivity()) == null) {
            return;
        }
        if (z) {
            ShareUtils.requestWritePermission(topActivity, shareContent, new RequestPermissionsCallback() { // from class: com.bytedance.ug.sdk.share.impl.helper.ImageShareHelper.2
                @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
                public void onGranted() {
                    ImageShareHelper imageShareHelper = ImageShareHelper.this;
                    ShareContent shareContent2 = shareContent;
                    imageShareHelper.saveImage(shareContent2, shareContent2.getImageUrl(), imageShareCallback, true);
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
                public void onDenied(String str) {
                    ImageShareCallback imageShareCallback2 = imageShareCallback;
                    if (imageShareCallback2 != null) {
                        imageShareCallback2.onShareFailed();
                    }
                    ToastUtils.showToast(topActivity, shareContent, 4, C1010R.string.share_sdk_image_share_save_failed);
                }
            });
        } else {
            saveImage(shareContent, shareContent.getImageUrl(), imageShareCallback, false);
        }
    }

    public void saveImage(ShareContent shareContent, String str, final ImageShareCallback imageShareCallback, final boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LoadingUtils.showProgressDialog(shareContent);
        ShareConfigManager.getInstance().getImageBitmap(str, new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.impl.helper.ImageShareHelper.3
            @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
            public void onSuccess(Bitmap bitmap) {
                String cacheFilePathDir;
                LoadingUtils.dismissProgressDialog();
                if (bitmap == null || bitmap.isRecycled()) {
                    ImageShareCallback imageShareCallback2 = imageShareCallback;
                    if (imageShareCallback2 != null) {
                        imageShareCallback2.onShareFailed();
                        return;
                    }
                    return;
                }
                String str2 = "share_image_" + System.currentTimeMillis() + ".jpeg";
                if (z) {
                    cacheFilePathDir = FileUtils.getAlbumDirPath();
                } else {
                    cacheFilePathDir = FileUtils.getCacheFilePathDir();
                }
                boolean saveBitmapToSD = FileUtils.saveBitmapToSD(bitmap, cacheFilePathDir, str2);
                Logger.m469i("ImageShareHelper", "saveImage saveBits = " + saveBitmapToSD + " , dir = " + cacheFilePathDir + " , path = " + str2);
                if (saveBitmapToSD) {
                    if (z) {
                        FileUtils.syncMediaToAlbum(ShareSdkManager.getInstance().getAppContext(), cacheFilePathDir + "/" + str2, true);
                    }
                    ImageShareCallback imageShareCallback3 = imageShareCallback;
                    if (imageShareCallback3 != null) {
                        imageShareCallback3.onShareSuccess(cacheFilePathDir + File.separator + str2);
                        return;
                    }
                    return;
                }
                ImageShareCallback imageShareCallback4 = imageShareCallback;
                if (imageShareCallback4 != null) {
                    imageShareCallback4.onShareFailed();
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
            public void onFailed() {
                LoadingUtils.dismissProgressDialog();
                ImageShareCallback imageShareCallback2 = imageShareCallback;
                if (imageShareCallback2 != null) {
                    imageShareCallback2.onShareFailed();
                }
            }
        });
    }

    @Deprecated
    public String getSaveImagePath(Bitmap bitmap) {
        String str = "share_image_" + System.currentTimeMillis() + ".jpeg";
        String cacheFilePathDir = FileUtils.getCacheFilePathDir();
        return FileUtils.saveBitmapToSD(bitmap, cacheFilePathDir, str) ? cacheFilePathDir + File.separator + str : "";
    }

    public String getSaveImagePathWithUUID(Bitmap bitmap) {
        String str = "share_image_" + UUID.randomUUID() + ".jpeg";
        String cacheFilePathDir = FileUtils.getCacheFilePathDir();
        return FileUtils.saveBitmapToSD(bitmap, cacheFilePathDir, str) ? cacheFilePathDir + File.separator + str : "";
    }
}
