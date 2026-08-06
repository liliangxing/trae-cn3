package com.bytedance.push.notification;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.service.manager.push.notification.AsyncImageDownloader;
import com.bytedance.android.service.manager.push.notification.ImageDownloadCallback;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.img.ImageDownloader;
import com.bytedance.push.img.Request;

/* loaded from: classes4.dex */
public class AsyncImageDownloadWrapper implements AsyncImageDownloader, Handler.Callback {
    private Handler mHandler;
    private final ImageDownloader mImageDownloader;

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public AsyncImageDownloadWrapper(ImageDownloader imageDownloader) {
        this.mImageDownloader = imageDownloader;
    }

    @Override // com.bytedance.android.service.manager.push.notification.AsyncImageDownloader
    public void asyncDownloadImage(final Request request, final ImageDownloadCallback imageDownloadCallback) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.notification.AsyncImageDownloadWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap bitmap;
                try {
                    bitmap = AsyncImageDownloadWrapper.this.mImageDownloader.downloadImage(request);
                } catch (Throwable th) {
                    th.printStackTrace();
                    bitmap = null;
                }
                AsyncImageDownloadWrapper.this.mHandler.post(new Runnable() { // from class: com.bytedance.push.notification.AsyncImageDownloadWrapper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null && !bitmap2.isRecycled()) {
                            imageDownloadCallback.onSuccess(bitmap);
                        } else {
                            imageDownloadCallback.onFailed();
                        }
                    }
                });
            }
        });
    }

    @Override // com.bytedance.push.img.ImageDownloader
    public Bitmap downloadImage(Request request) {
        return this.mImageDownloader.downloadImage(request);
    }
}
