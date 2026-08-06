package com.bytedance.notification.supporter.impl;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Vibrator;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.notification.R;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.interfaze.INotificationShowListener;
import com.bytedance.notification.supporter.service.INotificationReminderService;
import com.bytedance.platform.thread.Constants;
import com.bytedance.push.Configuration;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationReminderServiceImpl implements INotificationReminderService {
    private static final String REMINDER_TYPE_ALL = "all";
    private static final String REMINDER_TYPE_BRIGHT_SCREEN = "bright_screen";
    private static final String REMINDER_TYPE_SOUND = "sound";
    private static final String REMINDER_TYPE_VIBRATION = "vibration";
    private boolean mAllowVibrate;
    private AudioManager mAudioManager;
    private Field mChannelIdField;
    private Context mContext;
    private Handler mHandler;
    private MediaPlayer mMediaPlayer;
    private NotificationManager mNotificationManager;
    private Uri mNotificationSound;
    private int mNotificationSoundMode;
    private PowerManager mPowerManager;
    private long[] mVibrationPattern;
    private Vibrator mVibrator;
    private final String TAG = "NotificationReminderServiceImpl";
    private final String IMPORTANT_PUSH_CHANNEL_ID = "important_push";
    private final String FIELD_NOTIFICATION_CHANNEL_ID = "mChannelId";
    private final int SOUND_WHEN_MEDIA_NOT_MUTE = 0;
    private final int SOUND_WHEN_MEDIA_BIGGER_SYSTEM = 1;
    private final long[] DEFAULT_VIBRATION = {300, 200, 300, 200};
    private final long[] DEFAULT_VV_VIBRATION = {0, 200, 300, 200};

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public @interface ReminderType {
    }

    public NotificationReminderServiceImpl(Context context) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mContext = context;
        handler.post(new Runnable() { // from class: com.bytedance.notification.supporter.impl.NotificationReminderServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                NotificationReminderServiceImpl notificationReminderServiceImpl = NotificationReminderServiceImpl.this;
                notificationReminderServiceImpl.mAudioManager = (AudioManager) notificationReminderServiceImpl.mContext.getSystemService("audio");
            }
        });
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
        this.mNotificationSoundMode = ((PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class)).getNotificationSoundMode();
        try {
            Field declaredField = Notification.class.getDeclaredField("mChannelId");
            this.mChannelIdField = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        this.mMediaPlayer = new MediaPlayer();
        this.mVibrator = (Vibrator) this.mContext.getSystemService("vibrator");
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
    }

    @Override // com.bytedance.notification.supporter.service.INotificationReminderService
    public void showNotificationWithReminder(long j, PushNotificationExtra pushNotificationExtra, Notification notification, INotificationShowListener iNotificationShowListener) {
        Field field;
        if (iNotificationShowListener == null) {
            Logger.m278w("NotificationReminderServiceImpl", "[showNotificationWithReminder]notificationShowListener is null, do nothing");
            return;
        }
        if (pushNotificationExtra == null || !pushNotificationExtra.useSelfReminder() || Build.VERSION.SDK_INT < 26) {
            Logger.m268d("NotificationReminderServiceImpl", "[showNotificationWithReminder]useSelfReminder is false,show notification directly");
            iNotificationShowListener.show();
            return;
        }
        checkDeviceStatus(j, this.mContext, pushNotificationExtra);
        if (!pushNotificationExtra.useSelfReminder()) {
            Logger.m268d("NotificationReminderServiceImpl", "[showNotificationWithReminder]useSelfReminder after checkDeviceStatus is false,show notification directly");
            iNotificationShowListener.show();
            return;
        }
        if (!handleNotificationChannel(this.mContext)) {
            Logger.m268d("NotificationReminderServiceImpl", "[showNotificationWithReminder]important notification channel is null,show notification directly");
            iNotificationShowListener.show();
            return;
        }
        Logger.m268d("NotificationReminderServiceImpl", "[showNotificationWithReminder]everything is ready,reminder user cur notification");
        if (pushNotificationExtra.mBrightScreen) {
            Logger.m268d("NotificationReminderServiceImpl", "[showNotificationWithReminder]mBrightScreen is true,wakeup screen");
            wakeupScreen(j, pushNotificationExtra.mBrightScreen);
        }
        if ((pushNotificationExtra.mUseSound || pushNotificationExtra.mUseVibration) && (field = this.mChannelIdField) != null) {
            try {
                field.set(notification, "important_push");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Logger.m268d("NotificationReminderServiceImpl", "[showNotificationWithReminder]show notification to notification bar");
        iNotificationShowListener.show();
        if (!TextUtils.equals(notification.getChannelId(), "important_push")) {
            Logger.m268d("NotificationReminderServiceImpl", "[showNotificationWithReminder]notification.getChannelId is not IMPORTANT_PUSH_CHANNEL_ID,maybe change channel failed,cancel reminder");
        } else if (ToolUtils.isTargetBrandDevice(ToolUtils.OPPO)) {
            playSound(j, pushNotificationExtra.mUseSound);
            playVibration(j, pushNotificationExtra.mUseVibration);
        } else {
            playVibration(j, pushNotificationExtra.mUseVibration);
            playSound(j, pushNotificationExtra.mUseSound);
        }
    }

    private void playVibration(long j, boolean z) {
        if (!z) {
            Logger.m268d("NotificationReminderServiceImpl", "[playVibration]enable is false,do nothing");
            return;
        }
        Vibrator vibrator = this.mVibrator;
        if (vibrator == null) {
            onReminderResult(j, REMINDER_TYPE_VIBRATION, false, "vibrator is null");
            return;
        }
        if (this.mVibrationPattern == null) {
            onReminderResult(j, REMINDER_TYPE_VIBRATION, false, "vibration pattern is null");
            return;
        }
        if (!vibrator.hasVibrator()) {
            onReminderResult(j, REMINDER_TYPE_VIBRATION, false, "cur device not support vibration");
            return;
        }
        Logger.m268d("NotificationReminderServiceImpl", "[playVibration]final play vibration");
        try {
            this.mVibrator.cancel();
            this.mVibrator.vibrate(this.mVibrationPattern, -1, new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
            onReminderResult(j, REMINDER_TYPE_VIBRATION, true, "success");
        } catch (Throwable th) {
            Logger.m272e("NotificationReminderServiceImpl", "[playSound]error when play vibration ", th);
            onReminderResult(j, REMINDER_TYPE_VIBRATION, false, "exception:" + th.getMessage());
        }
    }

    private void playSound(long j, boolean z) {
        if (!z) {
            Logger.m278w("NotificationReminderServiceImpl", "[playSound]enable is false,do nothing");
            return;
        }
        if (this.mNotificationSound == null) {
            Logger.m278w("NotificationReminderServiceImpl", "[playSound]mNotificationSound is null,do nothing");
            onReminderResult(j, REMINDER_TYPE_SOUND, false, "notification sound is null");
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            onReminderResult(j, REMINDER_TYPE_SOUND, false, "media player is null");
            return;
        }
        if (mediaPlayer.isPlaying()) {
            onReminderResult(j, REMINDER_TYPE_SOUND, false, "media player is playing");
            return;
        }
        Logger.m268d("NotificationReminderServiceImpl", "[playSound]final play sound with mNotificationSound:" + this.mNotificationSound);
        try {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDataSource(this.mContext, this.mNotificationSound);
            this.mMediaPlayer.prepare();
            this.mMediaPlayer.start();
            onReminderResult(j, REMINDER_TYPE_SOUND, true, "success");
        } catch (Throwable th) {
            Logger.m272e("NotificationReminderServiceImpl", "[playSound]error when play sound ", th);
            onReminderResult(j, REMINDER_TYPE_SOUND, false, "exception:" + th.getMessage());
        }
    }

    private void wakeupScreen(long j, boolean z) {
        if (!z) {
            Logger.m278w("NotificationReminderServiceImpl", "[wakeupScreen]enable is false,do nothing");
            return;
        }
        PowerManager powerManager = this.mPowerManager;
        if (powerManager == null) {
            Logger.m278w("NotificationReminderServiceImpl", "[wakeupScreen]mPowerManager is null,do nothing");
            onReminderResult(j, REMINDER_TYPE_BRIGHT_SCREEN, false, "power manager is null");
            return;
        }
        if (powerManager.isScreenOn()) {
            Logger.m278w("NotificationReminderServiceImpl", "[wakeupScreen]cur is screen on,do nothing");
            onReminderResult(j, REMINDER_TYPE_BRIGHT_SCREEN, false, "cur is screen on");
            return;
        }
        Logger.m268d("NotificationReminderServiceImpl", "[playSound]final wakeup screen");
        try {
            PowerManager.WakeLock newWakeLock = this.mPowerManager.newWakeLock(268435466, "BDPush:NotificationReminderServiceImpl");
            newWakeLock.acquire(Constants.TASK_WAIT_THRESHOLD);
            newWakeLock.release();
            onReminderResult(j, REMINDER_TYPE_BRIGHT_SCREEN, true, "success");
        } catch (Throwable th) {
            onReminderResult(j, REMINDER_TYPE_BRIGHT_SCREEN, false, "exception:" + th.getMessage());
            Logger.m272e("NotificationReminderServiceImpl", "[playSound]error when wakeup screen ", th);
        }
    }

    private boolean handleNotificationChannel(Context context) {
        if (this.mNotificationManager.getNotificationChannel("important_push") == null) {
            NotificationChannel notificationChannel = new NotificationChannel("important_push", context.getString(R.string.important_push_notification_channel_name), 4);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            notificationChannel.enableLights(true);
            this.mNotificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationChannel notificationChannel2 = this.mNotificationManager.getNotificationChannel("important_push");
        return notificationChannel2 != null && notificationChannel2.getImportance() > 0;
    }

    private void checkDeviceStatus(long j, Context context, PushNotificationExtra pushNotificationExtra) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Uri uri = null;
        boolean z = true;
        boolean z2 = true;
        for (NotificationChannel notificationChannel : notificationManager.getNotificationChannels()) {
            Logger.m268d("NotificationReminderServiceImpl", ((Object) notificationChannel.getName()) + ":" + notificationChannel.getImportance() + " " + notificationChannel.getSound() + " " + notificationChannel.shouldVibrate());
            if (notificationChannel.getSound() != null) {
                uri = notificationChannel.getSound();
                z = false;
            }
            if (notificationChannel.shouldVibrate()) {
                z2 = false;
            }
        }
        Logger.m268d("NotificationReminderServiceImpl", "[onReminderResult]allOfSoundIsNull:" + z + " allOfVibrateIsNull:" + z2);
        NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(Configuration.NOTIFICATION_ID);
        if (ToolUtils.areNotificationsEnabled(context) != 1) {
            onReminderResult(j, "all", false, "notification are not enabled");
            pushNotificationExtra.mUseSound = false;
            pushNotificationExtra.mUseVibration = false;
            pushNotificationExtra.mBrightScreen = false;
            return;
        }
        if (notificationChannel2 == null || notificationChannel2.getImportance() == 0) {
            onReminderResult(j, "all", false, "push channel is close");
            pushNotificationExtra.mUseSound = false;
            pushNotificationExtra.mUseVibration = false;
            pushNotificationExtra.mBrightScreen = false;
            return;
        }
        this.mNotificationSound = notificationChannel2.getSound();
        long[] vibrationPattern = notificationChannel2.getVibrationPattern();
        if (vibrationPattern != null) {
            this.mVibrationPattern = vibrationPattern;
        }
        this.mAllowVibrate = notificationChannel2.shouldVibrate();
        if (this.mNotificationSound == null) {
            if (!z) {
                onReminderResult(j, REMINDER_TYPE_SOUND, false, "notification sound is null");
                pushNotificationExtra.mUseSound = false;
            } else if (uri != null) {
                this.mNotificationSound = uri;
            } else {
                this.mNotificationSound = Uri.parse("content://settings/system/notification_sound");
            }
        }
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null) {
            onReminderResult(j, REMINDER_TYPE_SOUND, false, "audio manager is null");
            pushNotificationExtra.mUseSound = false;
            return;
        }
        int streamVolume = audioManager.getStreamVolume(1);
        int ringerMode = this.mAudioManager.getRingerMode();
        if (pushNotificationExtra.mUseSound) {
            if (ringerMode < 2) {
                onReminderResult(j, REMINDER_TYPE_SOUND, false, "ringerMode<=RINGER_MODE_NORMAL,ringerMode is " + ringerMode);
                pushNotificationExtra.mUseSound = false;
            } else if (streamVolume <= 0) {
                onReminderResult(j, REMINDER_TYPE_SOUND, false, "systemVolume<=0,systemVolume is " + streamVolume);
                pushNotificationExtra.mUseSound = false;
            } else {
                int streamVolume2 = this.mAudioManager.getStreamVolume(3);
                int i = this.mNotificationSoundMode;
                if (i == 0) {
                    if (streamVolume2 <= 0) {
                        onReminderResult(j, REMINDER_TYPE_SOUND, false, "mediaVolume<=0 when mNotificationSoundMode==SOUND_WHEN_MEDIA_NOT_MUTE,mediaVolume is " + streamVolume2);
                        pushNotificationExtra.mUseSound = false;
                    }
                } else if (i != 1) {
                    onReminderResult(j, REMINDER_TYPE_SOUND, false, "NotificationSoundMode is invalid,NotificationSoundMode is " + this.mNotificationSoundMode);
                    pushNotificationExtra.mUseSound = false;
                } else if (streamVolume2 < streamVolume) {
                    onReminderResult(j, REMINDER_TYPE_SOUND, false, "mediaVolume<=systemVolume when mNotificationSoundMode==SOUND_WHEN_MEDIA_BIGGER_SYSTEM,mediaVolume is " + streamVolume2);
                    pushNotificationExtra.mUseSound = false;
                }
            }
        }
        if (!this.mAllowVibrate && z2) {
            this.mAllowVibrate = true;
        }
        if (!this.mAllowVibrate) {
            onReminderResult(j, REMINDER_TYPE_VIBRATION, false, "push channel's vibrate be closed");
            pushNotificationExtra.mUseVibration = false;
            return;
        }
        if (ringerMode < 1) {
            onReminderResult(j, REMINDER_TYPE_VIBRATION, false, "ringerMode<=RINGER_MODE_VIBRATE,ringerMode is " + ringerMode);
            pushNotificationExtra.mUseVibration = false;
            return;
        }
        if (!this.mVibrator.hasVibrator()) {
            onReminderResult(j, REMINDER_TYPE_VIBRATION, false, "cur device not support vibrate");
            pushNotificationExtra.mUseVibration = false;
        } else if (pushNotificationExtra.mUseVibration && this.mVibrationPattern == null) {
            if (ToolUtils.isTargetBrandDevice(ToolUtils.VIVO)) {
                this.mVibrationPattern = this.DEFAULT_VV_VIBRATION;
            } else {
                this.mVibrationPattern = this.DEFAULT_VIBRATION;
            }
        }
    }

    private void onReminderResult(long j, String str, boolean z, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", j);
            jSONObject.put(com.bytedance.notification.Constants.EVENT_PARAMS_KEY_REMINDER_TYPE, str);
            jSONObject.put("result", z);
            jSONObject.put(com.bytedance.notification.Constants.EVENT_PARAMS_KEY_ERROR_MSG, str2);
        } catch (JSONException e) {
            Logger.m272e("NotificationReminderServiceImpl", "[onReminderResult]error when onReminderResult ", e);
        }
        Logger.m268d("NotificationReminderServiceImpl", "[onReminderResult]" + jSONObject);
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3(com.bytedance.notification.Constants.EVENT_NAME_REMINDER_RESULT, jSONObject);
    }
}
