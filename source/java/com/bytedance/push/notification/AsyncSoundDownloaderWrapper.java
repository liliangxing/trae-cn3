package com.bytedance.push.notification;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.sound.SoundDownloader;

/* loaded from: classes4.dex */
public class AsyncSoundDownloaderWrapper {
    private Handler mHandler;
    private final SoundDownloader mSoundDownloader;

    public AsyncSoundDownloaderWrapper(SoundDownloader soundDownloader) {
        this.mSoundDownloader = soundDownloader;
    }

    public void downloadSound(final String str, final String str2, final SoundDownloadCallback soundDownloadCallback) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.notification.AsyncSoundDownloaderWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                final boolean downLoadSound = AsyncSoundDownloaderWrapper.this.mSoundDownloader.downLoadSound(str, str2);
                if (soundDownloadCallback == null) {
                    return;
                }
                AsyncSoundDownloaderWrapper.this.mHandler.post(new Runnable() { // from class: com.bytedance.push.notification.AsyncSoundDownloaderWrapper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (downLoadSound) {
                            soundDownloadCallback.onSuccess(str2);
                        } else {
                            soundDownloadCallback.onFailed();
                        }
                    }
                });
            }
        });
    }
}
