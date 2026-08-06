package com.ss.bytertc.base.media.screen;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.ContextUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ScreenAudioCaptureAndroid implements ScreenAudioCaptureObserver {
    private static final String TAG = "ScreenAudioCaptureAndroid";
    private Context mContext;
    private boolean mIsAudioCaptureWorking = false;
    private long mNativeCaptureObserver;

    @Override // com.ss.bytertc.base.media.screen.ScreenAudioCaptureObserver
    public void onAudioFrameCapture(byte[] audioFrame, int samples, int sampleRate, int channel) {
        RTCScreenAudioNativeFunctions.nativeOnAuidoFrameCaptured(this.mNativeCaptureObserver, audioFrame, samples, sampleRate, channel);
    }

    @Override // com.ss.bytertc.base.media.screen.ScreenAudioCaptureObserver
    public void onCapturerStarted() {
        RTCScreenAudioNativeFunctions.nativeOnCapturerStarted(this.mNativeCaptureObserver);
    }

    @Override // com.ss.bytertc.base.media.screen.ScreenAudioCaptureObserver
    public void onCapturerStopped() {
        RTCScreenAudioNativeFunctions.nativeOnCapturerStopped(this.mNativeCaptureObserver);
    }

    ScreenAudioCaptureAndroid(long nativeCaptureObserver) {
        this.mNativeCaptureObserver = nativeCaptureObserver;
    }

    public void startCapture() {
        try {
            this.mContext = ContextUtils.getApplicationContext();
            if (Build.VERSION.SDK_INT > 28 && ContextCompat.checkSelfPermission(this.mContext, "android.permission.RECORD_AUDIO") == 0) {
                ScreenAudioCaptureAndroidManager.INSTANCE().initialize(this.mContext, this);
                if (RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 6, null));
                }
                this.mIsAudioCaptureWorking = true;
                return;
            }
            RTCScreenAudioNativeFunctions.nativeOnCapturerError(this.mNativeCaptureObserver, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopCapture() {
        if (this.mIsAudioCaptureWorking) {
            try {
                if (Build.VERSION.SDK_INT > 28 && RXScreenCaptureService.serviceStarted.get()) {
                    Context context = this.mContext;
                    context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 7, null));
                }
                this.mIsAudioCaptureWorking = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        stopCapture();
        try {
            if (this.mContext == null || Build.VERSION.SDK_INT <= 28 || !RXScreenCaptureService.serviceStarted.get()) {
                return;
            }
            Context context = this.mContext;
            context.startForegroundService(RXScreenCaptureService.getServiceIntent(context, 8, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
