package com.ss.bytertc.base.media.screen;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RXScreenCaptureService extends Service {
    private static final String ACTION = "ACTION";
    public static final int COMMAND_AUDIO_DISPOSE = 8;
    public static final int COMMAND_AUDIO_START = 6;
    public static final int COMMAND_AUDIO_STOP = 7;
    public static final int COMMAND_CHANGE_CAPTURE_FORMAT = 3;
    public static final int COMMAND_DISPOSE = 5;
    public static final int COMMAND_INVALID = -1;
    public static final int COMMAND_LAUNCH = 0;
    public static final int COMMAND_ON_FRAME = 4;
    public static final int COMMAND_START = 1;
    public static final int COMMAND_STOP = 2;
    public static final int COMMAND_STOP_SERVICE = 9;
    private static final String DATA = "DATA";
    public static final String KEY_CONTENT_TEXT = "contentText";
    public static final String KEY_HASHCODE = "hc";
    public static final String KEY_HEIGHT = "h";
    public static final String KEY_IFRAMERATE = "if";
    public static final String KEY_INDEX = "i";
    public static final String KEY_LARGE_ICON = "largei";
    public static final String KEY_LAUNCH_ACTIVITY = "activity";
    public static final String KEY_MIN_FRAMERATE = "minfr";
    public static final String KEY_PICO_CREATE_MEDIA_PROJECTION = "pico_create_media_projection";
    public static final String KEY_PICO_NEED_CAPTURE_2D_TEXTURE = "pico_need_capture_2d_texture";
    public static final String KEY_PICO_NOT_CHECK_ORIENTATION = "pico_not_check_orientation";
    public static final String KEY_PICO_VIRTUAL_DISPLAY_DPI = "pico_virtual_display_dpi";
    public static final String KEY_PICO_VIRTUAL_DISPLAY_FLAG = "pico_virtual_display_flags";
    public static final String KEY_PICO_VIRTUAL_DISPLAY_NAME = "pico_virtual_display_name";
    public static final String KEY_RESULT_DATA = "PermissionResult";
    public static final String KEY_SMALL_ICON = "largei";
    public static final String KEY_WIDTH = "w";
    public static final String METHOD_PICO_CREATE_MEDIA_PROJECTION = "createMediaProjection";
    private static final String TAG = "RXScreenCaptureService";
    public static AtomicBoolean serviceStarted = new AtomicBoolean(false);
    String mContentText;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    String mLaunchActivity;
    private MediaProjection mMediaProjection;
    private MediaProjectionManager mMediaProjectionManager;
    private Intent mPermissionReulstData;
    int mLargeIcon = -1;
    int mSmallIcon = -1;
    private boolean mPicoCreateMediaProjection = false;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static Intent getServiceIntent(Context context, int command, Intent data) {
        Intent intent = new Intent(context, (Class<?>) RXScreenCaptureService.class);
        intent.putExtra(ACTION, command);
        if (data != null) {
            intent.putExtra(DATA, data);
        }
        return intent;
    }

    private static int getCommand(Intent intent) {
        if (intent == null) {
            return -1;
        }
        return intent.getIntExtra(ACTION, -1);
    }

    private static Intent getData(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Intent) intent.getParcelableExtra(DATA);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        serviceStarted.compareAndSet(false, true);
        try {
            RXLogging.w(TAG, String.format("[ScreenCapture] RXScreenCaptureService::onCreate success!", new Object[0]));
            HandlerThread handlerThread = new HandlerThread(TAG);
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper());
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            stopMediaProjection();
            stopForeground(true);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        serviceStarted.compareAndSet(true, false);
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        switch (getCommand(intent)) {
            case 0:
                startLaunch(intent);
                return 2;
            case 1:
                startCapture(intent);
                return 2;
            case 2:
                stopCapture(intent);
                return 2;
            case 3:
                changeCaptureFormat(intent);
                return 2;
            case 4:
            default:
                return 2;
            case 5:
                dispose(intent);
                return 2;
            case 6:
                startAudioCapture();
                return 2;
            case 7:
                stopAudioCapture();
                return 2;
            case 8:
                audioDispose();
                return 2;
            case 9:
                stop();
                return 2;
        }
    }

    private void startLaunch(Intent intent) {
        Intent data = getData(intent);
        if (data == null) {
            return;
        }
        this.mLargeIcon = data.getIntExtra("largei", -1);
        this.mSmallIcon = data.getIntExtra("largei", -1);
        this.mLaunchActivity = data.getStringExtra(KEY_LAUNCH_ACTIVITY);
        this.mContentText = data.getStringExtra(KEY_CONTENT_TEXT);
        this.mPicoCreateMediaProjection = data.getBooleanExtra(KEY_PICO_CREATE_MEDIA_PROJECTION, false);
        if (TextUtils.isEmpty(this.mLaunchActivity)) {
            return;
        }
        int i = this.mLargeIcon;
        if (i == -1 && this.mSmallIcon == -1) {
            return;
        }
        if (this.mSmallIcon == -1) {
            this.mSmallIcon = i;
        }
        if (i == -1) {
            this.mLargeIcon = this.mSmallIcon;
        }
        this.mPermissionReulstData = (Intent) data.getParcelableExtra(KEY_RESULT_DATA);
        createNotificationChannel();
    }

    private void startCapture(Intent intent) {
        Intent data = getData(intent);
        if (data == null) {
            return;
        }
        createOrGetMediaProjection();
        final int intExtra = data.getIntExtra("w", 0);
        final int intExtra2 = data.getIntExtra(KEY_HEIGHT, 0);
        final int intExtra3 = data.getIntExtra(KEY_IFRAMERATE, 0);
        final int intExtra4 = data.getIntExtra(KEY_MIN_FRAMERATE, 0);
        if (this.mHandlerThread != null) {
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.RXScreenCaptureService$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    RXScreenCaptureService.this.m206x1fb3e03b(intExtra, intExtra2, intExtra3, intExtra4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startCapture$0$com-ss-bytertc-base-media-screen-RXScreenCaptureService */
    public /* synthetic */ void m206x1fb3e03b(int i, int i2, int i3, int i4) {
        ScreenCaptureAndroidManager.INSTANCE().startCapture(i, i2, i3, i4, this.mMediaProjection);
    }

    private void stopCapture(Intent intent) {
        if (this.mHandlerThread != null) {
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.RXScreenCaptureService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ScreenCaptureAndroidManager.INSTANCE().stopCapture();
                }
            });
        }
    }

    private void changeCaptureFormat(Intent intent) {
        Intent data = getData(intent);
        if (data == null) {
            return;
        }
        final int intExtra = data.getIntExtra("w", 0);
        final int intExtra2 = data.getIntExtra(KEY_HEIGHT, 0);
        final int intExtra3 = data.getIntExtra(KEY_IFRAMERATE, 0);
        if (this.mHandlerThread != null) {
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.RXScreenCaptureService$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ScreenCaptureAndroidManager.INSTANCE().changeCaptureFormat(intExtra, intExtra2, intExtra3);
                }
            });
        }
    }

    private void dispose(Intent intent) {
        Intent data = getData(intent);
        if (data == null) {
            return;
        }
        final int intExtra = data.getIntExtra(KEY_HASHCODE, 0);
        if (this.mHandlerThread != null) {
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.RXScreenCaptureService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ScreenCaptureAndroidManager.INSTANCE().dispose(intExtra);
                }
            });
        }
    }

    private void startAudioCapture() {
        createOrGetMediaProjection();
        if (this.mHandlerThread != null) {
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.RXScreenCaptureService$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    RXScreenCaptureService.this.m205xf0cc7973();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startAudioCapture$4$com-ss-bytertc-base-media-screen-RXScreenCaptureService */
    public /* synthetic */ void m205xf0cc7973() {
        ScreenAudioCaptureAndroidManager.INSTANCE().startAudioCapture(this.mMediaProjection);
    }

    private void stopAudioCapture() {
        if (this.mHandlerThread != null) {
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.RXScreenCaptureService$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    ScreenAudioCaptureAndroidManager.INSTANCE().stopAudioCapture();
                }
            });
        }
    }

    private void audioDispose() {
        if (this.mHandlerThread != null) {
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.RXScreenCaptureService$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    ScreenAudioCaptureAndroidManager.INSTANCE().dispose();
                }
            });
        }
    }

    private void stop() {
        serviceStarted.compareAndSet(true, false);
        if (this.mHandlerThread != null) {
            this.mHandler.post(new Runnable() { // from class: com.ss.bytertc.base.media.screen.RXScreenCaptureService$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    RXScreenCaptureService.this.m207xc805b240();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$stop$7$com-ss-bytertc-base-media-screen-RXScreenCaptureService */
    public /* synthetic */ void m207xc805b240() {
        stopMediaProjection();
        stopForeground(true);
        stopSelf();
    }

    private void stopMediaProjection() {
        if (this.mMediaProjection != null) {
            RXLogging.w(TAG, String.format("[ScreenCapture] stopMediaProjection!", new Object[0]));
            this.mMediaProjection.stop();
            this.mMediaProjection = null;
        }
    }

    private void createOrGetMediaProjection() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (this.mMediaProjection == null) {
            if (this.mMediaProjectionManager == null && applicationContext != null) {
                this.mMediaProjectionManager = (MediaProjectionManager) applicationContext.getSystemService("media_projection");
            }
            MediaProjectionManager mediaProjectionManager = this.mMediaProjectionManager;
            if (mediaProjectionManager != null) {
                this.mMediaProjection = mediaProjectionManager.getMediaProjection(-1, this.mPermissionReulstData);
            }
            if (this.mMediaProjection == null && this.mPicoCreateMediaProjection) {
                Log.i("createOrGetMediaProjection", "mediaProjection is null, try to use pico private interface on pico os platform");
                try {
                    this.mMediaProjection = (MediaProjection) MediaProjectionManager.class.getMethod(METHOD_PICO_CREATE_MEDIA_PROJECTION, new Class[0]).invoke(this.mMediaProjectionManager, new Object[0]);
                } catch (Exception e) {
                    Log.w("createOrGetMediaProjection", "mediaProjection is null, use pico private interface failed", e);
                    this.mMediaProjection = null;
                }
            }
        }
    }

    private void createNotificationChannel() {
        Class<?> cls;
        try {
            cls = Class.forName(this.mLaunchActivity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        if (cls == null) {
            return;
        }
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, cls), Build.VERSION.SDK_INT > 30 ? 201326592 : 134217728)).setLargeIcon(BitmapFactory.decodeResource(getResources(), this.mLargeIcon)).setSmallIcon(this.mSmallIcon).setContentText(this.mContentText).setWhen(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("notification_id");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("notification_id", "notification_name", 2));
        }
        Notification build = builder.build();
        build.defaults = 1;
        if (Build.VERSION.SDK_INT >= 33) {
            startForeground(110, build, 32);
        } else {
            startForeground(110, build);
        }
    }
}
