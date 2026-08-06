package com.bytedance.ug.sdk.share.image.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.image.manager.HiddenWartermarkDepend;
import com.bytedance.ug.sdk.share.impl.cache.ShareCacheManager;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageSaveUtils {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ImageSaveCallback {
        void onResult(boolean z);
    }

    public static boolean saveBitmapWithHiddenStr(Context context, ShareContent shareContent) {
        if (context != null && shareContent != null && shareContent.getImage() != null) {
            writeHiddenWatermark(shareContent);
            String str = "share_image_" + System.currentTimeMillis() + ".jpeg";
            String albumDirPath = FileUtils.getAlbumDirPath();
            if (FileUtils.saveBitmapToSD(shareContent.getImage(), albumDirPath, str)) {
                String str2 = albumDirPath + File.separator + str;
                FileUtils.syncMediaToAlbum(context, str2, true);
                MediaScannerConnection.scanFile(context, new String[]{str2}, new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension(".jpeg")}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.bytedance.ug.sdk.share.image.utils.ImageSaveUtils.1
                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                    public void onScanCompleted(String str3, Uri uri) {
                    }
                });
                ShareCacheManager.getInstance().updateSaveAlbumMediaCache(str, false);
                shareContent.setImageUrl(str2);
                return true;
            }
            Logger.m469i("ImageSaveUtils", "saveBitmapWithHiddenStr saveBitmapToSD false , dir = " + albumDirPath + " , path = " + str);
        }
        return false;
    }

    public static boolean writeHiddenWatermark(ShareContent shareContent) {
        String description;
        Bitmap copy;
        if (shareContent.getImageTokenShareInfo() != null) {
            description = shareContent.getImageTokenShareInfo().getDescription();
        } else {
            description = shareContent.getTokenShareInfo() != null ? shareContent.getTokenShareInfo().getDescription() : "";
        }
        String str = description;
        try {
            if (!enableHiddenWatermark(shareContent) || TextUtils.isEmpty(str)) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (shareContent.getImage().getConfig() != Bitmap.Config.ARGB_8888 && (copy = shareContent.getImage().copy(Bitmap.Config.ARGB_8888, false)) != null) {
                shareContent.setImage(copy);
            }
            boolean addHiddenString = HiddenWartermarkDepend.addHiddenString(shareContent.getImage(), str);
            try {
                ShareEvent.sendHiddenWriteEvent(shareContent, addHiddenString, str, addHiddenString ? 0 : 1, System.currentTimeMillis() - currentTimeMillis);
            } catch (Throwable unused) {
            }
            return addHiddenString;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static boolean enableHiddenWatermark(ShareContent shareContent) {
        if (shareContent.getFromChannel() == ShareChannelType.LONG_IMAGE) {
            return ShareConfigManager.getInstance().enableLongImageHiddenWaterMark();
        }
        return ShareConfigManager.getInstance().enableHostHiddenWaterMark();
    }

    public static boolean saveBitmapToAlbum(final Activity activity, final ShareContent shareContent, final ImageSaveCallback imageSaveCallback) {
        if (activity != null && shareContent != null && shareContent.getImage() != null) {
            ShareUtils.requestWritePermission(activity, shareContent, new RequestPermissionsCallback() { // from class: com.bytedance.ug.sdk.share.image.utils.ImageSaveUtils.2
                @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
                public void onGranted() {
                    boolean saveBitmapWithHiddenStr = ImageSaveUtils.saveBitmapWithHiddenStr(activity, shareContent);
                    ImageSaveCallback imageSaveCallback2 = imageSaveCallback;
                    if (imageSaveCallback2 != null) {
                        imageSaveCallback2.onResult(saveBitmapWithHiddenStr);
                    }
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
                public void onDenied(String str) {
                    ImageSaveCallback imageSaveCallback2 = imageSaveCallback;
                    if (imageSaveCallback2 != null) {
                        imageSaveCallback2.onResult(false);
                    }
                }
            });
            return true;
        }
        if (imageSaveCallback != null) {
            imageSaveCallback.onResult(false);
        }
        return false;
    }
}
