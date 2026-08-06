package com.ss.bytertc.base.media.screen;

import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Build;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.engine.utils.LogUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ScreenVideoCaptureAndroid {
    private static final int ScreenCaptureModelMediaProjection = 0;
    private static final int ScreenCaptureModelMediaProjectionWithForegroundService = 1;
    private static final String TAG = "ScreenVideoCaptureAndroid";
    private long mNativeCaptureObserver;
    private EglBase.Context sharedEglGroup;
    private VideoCapturer mVideoCapturer = null;
    private boolean mIsVideoCaptureInited = false;
    private boolean mIsVideoCaptureWorking = false;
    private EglBase cameraEglBase = null;
    private Intent mCaptureScreenIntent = null;
    private CapturerObserver localCapturerObserver = new CapturerObserver() { // from class: com.ss.bytertc.base.media.screen.ScreenVideoCaptureAndroid.1
        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onCapturerFormatSelected(int width, int height, int minFramerate, int maxFramerate, int pixelFormat) {
        }

        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onCapturerStarted(final boolean b) {
            if (b) {
                RTCScreenVideoNativeFunctions.nativeOnCapturerStarted(ScreenVideoCaptureAndroid.this.mNativeCaptureObserver);
            } else {
                RTCScreenVideoNativeFunctions.nativeOnCapturerError(ScreenVideoCaptureAndroid.this.mNativeCaptureObserver, 0, "start error");
            }
        }

        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onCapturerStopped() {
            RTCScreenVideoNativeFunctions.nativeOnCapturerStopped(ScreenVideoCaptureAndroid.this.mNativeCaptureObserver);
        }

        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onCapturerError(String errorMsg) {
            RTCScreenVideoNativeFunctions.nativeOnCapturerError(ScreenVideoCaptureAndroid.this.mNativeCaptureObserver, 0, errorMsg);
        }

        @Override // com.ss.bytertc.base.media.CapturerObserver
        public void onFrameCaptured(VideoFrame videoFrame) {
            RTCScreenVideoNativeFunctions.nativeOnFrameCaptured(ScreenVideoCaptureAndroid.this.mNativeCaptureObserver, videoFrame);
        }
    };

    ScreenVideoCaptureAndroid(long nativeCaptureObserver, EglBase.Context ctx) {
        this.sharedEglGroup = null;
        this.mNativeCaptureObserver = nativeCaptureObserver;
        this.sharedEglGroup = ctx;
    }

    public void startCapture(int width, int height, int frameRate, Intent intent) {
        if (intent == null) {
            LogUtil.m216e(TAG, "startCapture failed, intent is null");
            return;
        }
        this.mCaptureScreenIntent = intent;
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null) {
            videoCapturer.dispose();
            this.mVideoCapturer = null;
            this.mIsVideoCaptureInited = false;
            this.mIsVideoCaptureWorking = false;
        }
        RTCScreenVideoNativeFunctions.nativeOnCapturerSetType(this.mNativeCaptureObserver, Build.VERSION.SDK_INT > 28 ? 1 : 0);
        this.mVideoCapturer = createVideoCapturer(this.mCaptureScreenIntent);
        if (this.cameraEglBase == null) {
            this.cameraEglBase = EglBase.create(this.sharedEglGroup);
        }
        VideoCapturer videoCapturer2 = this.mVideoCapturer;
        if (videoCapturer2 != null) {
            ((ScreenCapturerAndroid) videoCapturer2).initialize(this.cameraEglBase.getEglBaseContext(), ContextUtils.getApplicationContext(), this.localCapturerObserver);
            this.mIsVideoCaptureInited = true;
            startVideoCapture(width, height, frameRate);
        } else {
            this.mIsVideoCaptureInited = false;
            this.mIsVideoCaptureWorking = false;
        }
    }

    public void stopCapture() {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            try {
                videoCapturer.stopCapture();
                this.mIsVideoCaptureWorking = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeCaptureFormat(int width, int height, int frameRate) {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null && this.mIsVideoCaptureInited && this.mIsVideoCaptureWorking) {
            videoCapturer.changeCaptureFormat(width, height, frameRate);
        }
    }

    public void release() {
        if (this.mVideoCapturer != null) {
            stopCapture();
            this.mVideoCapturer.dispose();
            this.mVideoCapturer = null;
        }
        EglBase eglBase = this.cameraEglBase;
        if (eglBase != null) {
            eglBase.release();
            this.cameraEglBase = null;
        }
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
        this.sharedEglGroup = null;
        this.mCaptureScreenIntent = null;
    }

    private VideoCapturer createVideoCapturer(Intent mediaProjectionPermissionResultData) {
        try {
            return new ScreenCapturerAndroid(mediaProjectionPermissionResultData, new MediaProjection.Callback() { // from class: com.ss.bytertc.base.media.screen.ScreenVideoCaptureAndroid.2
                @Override // android.media.projection.MediaProjection.Callback
                public void onStop() {
                    LogUtil.m216e(ScreenVideoCaptureAndroid.TAG, "User revoked permission to capture the screen.");
                    if (ScreenVideoCaptureAndroid.this.mVideoCapturer == null || !ScreenVideoCaptureAndroid.this.mIsVideoCaptureInited || !ScreenVideoCaptureAndroid.this.mIsVideoCaptureWorking || ScreenVideoCaptureAndroid.this.localCapturerObserver == null) {
                        return;
                    }
                    ScreenVideoCaptureAndroid.this.localCapturerObserver.onCapturerError("media projection unexpected exit when capture screen video");
                }
            });
        } catch (IllegalArgumentException e) {
            LogUtil.m216e(TAG, "Create VideoCapture fail : " + e.getMessage());
            return null;
        }
    }

    private void startVideoCapture(int width, int height, int fps) {
        VideoCapturer videoCapturer = this.mVideoCapturer;
        if (videoCapturer != null) {
            try {
                videoCapturer.startCapture(width, height, fps);
                this.mIsVideoCaptureWorking = true;
            } catch (IllegalArgumentException e) {
                LogUtil.m216e(TAG, "VideoCapture startCapture fail : " + e.getMessage());
            }
        }
    }
}
