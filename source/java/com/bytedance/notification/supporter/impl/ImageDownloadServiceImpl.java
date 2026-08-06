package com.bytedance.notification.supporter.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import com.bytedance.android.service.manager.push.notification.AsyncImageDownloader;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.notification.interfaze.ImageDownloadCallback;
import com.bytedance.notification.supporter.PushNotificationSupporter;
import com.bytedance.notification.supporter.service.IIconFileService;
import com.bytedance.notification.supporter.service.IImageDownloadService;
import com.bytedance.notification.utils.NotificationLogger;
import com.bytedance.push.img.Request;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageDownloadServiceImpl implements IImageDownloadService {
    private String TAG = "ImageDownloadService";
    private AsyncImageDownloader mAsyncImageDownloader;

    @Override // com.bytedance.notification.supporter.service.IImageDownloadService
    public void setAsyncImageDownloader(AsyncImageDownloader asyncImageDownloader) {
        this.mAsyncImageDownloader = asyncImageDownloader;
    }

    @Override // com.bytedance.notification.supporter.service.IImageDownloadService
    public void asyncDownloadIcon(final Context context, final String str, final String str2, final boolean z, final ImageDownloadCallback imageDownloadCallback) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.notification.supporter.impl.ImageDownloadServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageDownloadServiceImpl.this.asyncDownloadIconInternal(context, str, str2, z, imageDownloadCallback);
                }
            });
        } else {
            asyncDownloadIconInternal(context, str, str2, z, imageDownloadCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncDownloadIconInternal(Context context, final String str, String str2, boolean z, final ImageDownloadCallback imageDownloadCallback) {
        final IIconFileService iconFileService = PushNotificationSupporter.get().getIconFileService(context);
        if (z) {
            NotificationLogger.m150d(this.TAG, "forceUpdateIcon is true, start download icon");
            asyncDownloadImage(str2, new ImageDownloadCallback() { // from class: com.bytedance.notification.supporter.impl.ImageDownloadServiceImpl.2
                @Override // com.bytedance.notification.interfaze.ImageDownloadCallback
                public void onResult(Bitmap bitmap) {
                    if (bitmap != null) {
                        iconFileService.saveTargetPkgIcon(str, bitmap);
                    }
                    imageDownloadCallback.onResult(bitmap);
                }
            });
            return;
        }
        NotificationLogger.m150d(this.TAG, "forceUpdateIcon is false, try to get icon from file");
        Bitmap targetPkgIcon = iconFileService.getTargetPkgIcon(str);
        if (targetPkgIcon != null) {
            NotificationLogger.m150d(this.TAG, "get icon from file success");
            imageDownloadCallback.onResult(targetPkgIcon);
        } else {
            NotificationLogger.m150d(this.TAG, "get icon from file failed,start download and cache");
            asyncDownloadImage(str2, new ImageDownloadCallback() { // from class: com.bytedance.notification.supporter.impl.ImageDownloadServiceImpl.3
                @Override // com.bytedance.notification.interfaze.ImageDownloadCallback
                public void onResult(Bitmap bitmap) {
                    if (bitmap != null) {
                        NotificationLogger.m150d(ImageDownloadServiceImpl.this.TAG, "download icon success ,cache to file");
                        iconFileService.saveTargetPkgIcon(str, bitmap);
                    }
                    imageDownloadCallback.onResult(bitmap);
                }
            });
        }
    }

    @Override // com.bytedance.notification.supporter.service.IImageDownloadService
    public void asyncDownloadImage(String str, final ImageDownloadCallback imageDownloadCallback) {
        AsyncImageDownloader asyncImageDownloader = this.mAsyncImageDownloader;
        if (asyncImageDownloader == null) {
            imageDownloadCallback.onResult(null);
        } else {
            asyncImageDownloader.asyncDownloadImage(new Request(Uri.parse(str), 0, 0, null), new com.bytedance.android.service.manager.push.notification.ImageDownloadCallback() { // from class: com.bytedance.notification.supporter.impl.ImageDownloadServiceImpl.4
                public void onSuccess(Bitmap bitmap) {
                    imageDownloadCallback.onResult(bitmap);
                }

                public void onFailed() {
                    imageDownloadCallback.onResult(null);
                }
            });
        }
    }

    @Override // com.bytedance.notification.supporter.service.IImageDownloadService
    public Bitmap downloadImage(String str) {
        return this.mAsyncImageDownloader.downloadImage(new Request(Uri.parse(str), 0, 0, null));
    }
}
