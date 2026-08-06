package com.bytedance.android.service.manager.push.notification;

import com.bytedance.push.img.ImageDownloader;
import com.bytedance.push.img.Request;

/* loaded from: classes3.dex */
public interface AsyncImageDownloader extends ImageDownloader {
    void asyncDownloadImage(Request request, ImageDownloadCallback imageDownloadCallback);
}
