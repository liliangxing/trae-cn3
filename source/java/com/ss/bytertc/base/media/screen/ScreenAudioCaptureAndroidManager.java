package com.ss.bytertc.base.media.screen;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class ScreenAudioCaptureAndroidManager extends MediaProjection.Callback {
    private static final int NUM_SAMPLES_PER_READ = 1024;
    private static final int SAMPLE_RATE = 48000;
    private int mAudioMode;
    private AudioRecord mAudioRecord;
    private ScreenAudioCaptureObserver mCaptureObserver;
    private WeakReference<Context> mContextRef;
    private boolean mIsDisposed;
    private volatile boolean mIsRecording;
    private MediaProjection mMediaProjection;
    private Thread mRecordingThread;
    private Handler sHandler;
    private HandlerThread sHandlerThread;

    /* loaded from: classes7.dex */
    private static final class HOLDER {
        private static final ScreenAudioCaptureAndroidManager INSTANCE = new ScreenAudioCaptureAndroidManager();

        private HOLDER() {
        }
    }

    public static ScreenAudioCaptureAndroidManager INSTANCE() {
        return HOLDER.INSTANCE;
    }

    private ScreenAudioCaptureAndroidManager() {
        HandlerThread handlerThread = new HandlerThread("sdk-audio-share");
        this.sHandlerThread = handlerThread;
        handlerThread.start();
        this.sHandler = new Handler(this.sHandlerThread.getLooper());
        this.mIsRecording = false;
        this.mCaptureObserver = null;
        this.mAudioRecord = null;
        this.mRecordingThread = null;
        this.mIsDisposed = false;
    }

    private void checkNotDisposed() {
        if (this.mIsDisposed) {
            throw new RuntimeException("screen audio capturer is disposed.");
        }
    }

    public void initialize(final Context applicationContext, final ScreenAudioCaptureObserver captureObserver) {
        if (captureObserver == null) {
            throw new RuntimeException("audio capture observer not set.");
        }
        this.mCaptureObserver = captureObserver;
        this.mContextRef = new WeakReference<>(applicationContext);
        this.mIsDisposed = false;
    }

    private void setMusicMode(boolean music) {
        AudioManager audioManager = (AudioManager) this.mContextRef.get().getSystemService("audio");
        try {
            if (music) {
                this.mAudioMode = audioManager.getMode();
                audioManager.setMode(0);
            } else {
                audioManager.setMode(this.mAudioMode);
            }
        } catch (Exception e) {
            Log.e("ScreenAudioCapture", music + ", " + e.getMessage());
        }
    }

    public void startAudioCapture(final MediaProjection projection) {
        checkNotDisposed();
        this.sHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.ScreenAudioCaptureAndroidManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ScreenAudioCaptureAndroidManager.this.m9459x92e51708(projection);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startAudioCapture_, reason: merged with bridge method [inline-methods] */
    public void m9459x92e51708(MediaProjection projection) {
        if (Build.VERSION.SDK_INT > 28 && !this.mIsRecording) {
            this.mMediaProjection = projection;
            if (projection == null) {
                return;
            }
            try {
                AudioRecord build = new AudioRecord.Builder().setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(SAMPLE_RATE).setChannelMask(16).build()).setBufferSizeInBytes(2048).setAudioPlaybackCaptureConfig(new AudioPlaybackCaptureConfiguration.Builder(this.mMediaProjection).addMatchingUsage(1).addMatchingUsage(14).addMatchingUsage(0).build()).build();
                this.mAudioRecord = build;
                if (build.getState() == 0) {
                    Log.e("ScreenAudioCapture", "audioRecord init fail, permission: " + hasPermissions(this.mContextRef.get(), "android.permission.RECORD_AUDIO"));
                    this.mAudioRecord = null;
                    return;
                }
                this.mMediaProjection.registerCallback(this, this.sHandler);
                this.mCaptureObserver.onCapturerStarted();
                setMusicMode(true);
                this.mIsRecording = true;
                this.mAudioRecord.startRecording();
                Thread thread = new Thread(new Runnable() { // from class: com.ss.bytertc.base.media.screen.ScreenAudioCaptureAndroidManager$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenAudioCaptureAndroidManager.this.doRun();
                    }
                });
                this.mRecordingThread = thread;
                thread.start();
                setMusicMode(false);
            } catch (UnsupportedOperationException e) {
                Log.e("ScreenAudioCapture", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRun() {
        AudioRecord audioRecord;
        short[] sArr = new short[1024];
        while (this.mIsRecording && (audioRecord = this.mAudioRecord) != null) {
            if (audioRecord.read(sArr, 0, 1024) >= 0) {
                byte[] short2byte = short2byte(sArr);
                ScreenAudioCaptureObserver screenAudioCaptureObserver = this.mCaptureObserver;
                if (screenAudioCaptureObserver == null) {
                    return;
                } else {
                    screenAudioCaptureObserver.onAudioFrameCapture(short2byte, 1024, SAMPLE_RATE, 1);
                }
            }
        }
    }

    public void dispose() {
        this.mIsDisposed = true;
    }

    @Override // android.media.projection.MediaProjection.Callback
    public void onStop() {
        super.onStop();
        stopAudioCapture_();
    }

    public void stopAudioCapture() {
        checkNotDisposed();
        MediaProjection mediaProjection = this.mMediaProjection;
        if (mediaProjection != null) {
            mediaProjection.unregisterCallback(this);
        }
        this.sHandler.removeCallbacksAndMessages(null);
        this.sHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.ScreenAudioCaptureAndroidManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ScreenAudioCaptureAndroidManager.this.stopAudioCapture_();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAudioCapture_() {
        if (Build.VERSION.SDK_INT > 28 && this.mIsRecording) {
            this.mIsRecording = false;
            AudioRecord audioRecord = this.mAudioRecord;
            if (audioRecord != null) {
                audioRecord.stop();
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
            this.mCaptureObserver.onCapturerStopped();
            this.mMediaProjection = null;
        }
    }

    private byte[] short2byte(short[] sData) {
        int length = sData.length;
        byte[] bArr = new byte[length * 2];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            short s = sData[i];
            bArr[i2] = (byte) (s & 255);
            bArr[i2 + 1] = (byte) (s >> 8);
            sData[i] = 0;
        }
        return bArr;
    }

    private static boolean hasPermissions(Context context, String... perms) {
        for (String str : perms) {
            if (!selfPermissionGranted(context, str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean selfPermissionGranted(Context context, String permission) {
        if (context.getApplicationInfo().targetSdkVersion >= 23) {
            if (context.checkSelfPermission(permission) == 0) {
                return true;
            }
        } else if (ContextCompat.checkSelfPermission(context, permission) == 0) {
            return true;
        }
        return false;
    }
}
