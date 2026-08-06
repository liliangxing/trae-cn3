package com.bytedance.notification.supporter.service;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.service.manager.push.notification.AsyncImageDownloader;
import com.bytedance.notification.interfaze.ImageDownloadCallback;

/* loaded from: classes4.dex */
public interface IImageDownloadService {
    void asyncDownloadIcon(Context context, String str, String str2, boolean z, ImageDownloadCallback imageDownloadCallback);

    void asyncDownloadImage(String str, ImageDownloadCallback imageDownloadCallback);

    Bitmap downloadImage(String str);

    void setAsyncImageDownloader(AsyncImageDownloader asyncImageDownloader);
}
