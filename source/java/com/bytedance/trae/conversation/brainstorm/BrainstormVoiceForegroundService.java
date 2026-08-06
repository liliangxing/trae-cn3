package com.bytedance.trae.conversation.brainstorm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormVoiceForegroundService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;", "Landroid/app/Service;", "<init>", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "onDestroy", "", "startForegroundSafely", "micMuted", "", "foregroundServiceType", "createNotificationChannel", "buildNotification", "Landroid/app/Notification;", "buildContentIntent", "Landroid/app/PendingIntent;", "stopForegroundCompat", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormVoiceForegroundService extends Service {
    private static final String ACTION_START = "com.bytedance.trae.conversation.brainstorm.voice_fg.START";
    private static final String ACTION_STOP = "com.bytedance.trae.conversation.brainstorm.voice_fg.STOP";
    private static final String ACTION_UPDATE = "com.bytedance.trae.conversation.brainstorm.voice_fg.UPDATE";
    private static final String CHANNEL_ID = "brainstorm_voice_discussion";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_MIC_MUTED = "extra_mic_muted";
    private static final int NOTIFICATION_ID = 28041;
    private static final int REQUEST_RESTORE = 28042;
    private static final String TAG = "BrainstormVoiceFGS";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -540669514) {
                if (!action.equals(ACTION_STOP)) {
                    return 2;
                }
                stopForegroundCompat();
                stopSelf();
                return 2;
            }
            if (hashCode != 160864637) {
                if (hashCode != 419100942 || !action.equals(ACTION_START)) {
                    return 2;
                }
            } else if (!action.equals(ACTION_UPDATE)) {
                return 2;
            }
        }
        startForegroundSafely(intent != null ? intent.getBooleanExtra(EXTRA_MIC_MUTED, false) : false);
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        stopForegroundCompat();
        super.onDestroy();
    }

    private final void startForegroundSafely(boolean micMuted) {
        try {
            createNotificationChannel();
            Notification buildNotification = buildNotification(micMuted);
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(NOTIFICATION_ID, buildNotification, foregroundServiceType(micMuted));
            } else {
                startForeground(NOTIFICATION_ID, buildNotification);
            }
        } catch (Throwable th) {
            FLogger.INSTANCE.e(TAG, "startForeground failed, micMuted=" + micMuted, th);
            stopSelf();
        }
    }

    private final int foregroundServiceType(boolean micMuted) {
        if (Build.VERSION.SDK_INT < 29) {
            return 0;
        }
        return !micMuted ? 130 : 2;
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, getString(C0637R.string.trae_brainstorm_voice_notification_channel), 2);
        notificationChannel.setShowBadge(false);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private final Notification buildNotification(boolean micMuted) {
        int i;
        if (micMuted) {
            i = C0637R.string.trae_brainstorm_voice_notification_muted;
        } else {
            i = C0637R.string.trae_brainstorm_voice_notification_active;
        }
        Notification build = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(C0637R.drawable.trae_ic_brainstorm_mic).setContentTitle(getString(C0637R.string.trae_voice_discussing)).setContentText(getString(i)).setContentIntent(buildContentIntent()).setOngoing(true).setOnlyAlertOnce(true).setCategory(TracingConstants.KEY_TRACE_NAME).setPriority(-1).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final PendingIntent buildContentIntent() {
        Intent launchIntentForPackage;
        if (BrainstormSessionHolder.INSTANCE.isMinimized()) {
            launchIntentForPackage = new Intent(this, (Class<?>) BrainstormActivity.class);
            launchIntentForPackage.putExtra(BrainstormActivity.EXTRA_RESTORE_FROM_HOLDER, true);
        } else {
            launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage == null) {
                launchIntentForPackage = new Intent(this, (Class<?>) BrainstormActivity.class);
            }
        }
        launchIntentForPackage.addFlags(805437440);
        PendingIntent activity = PendingIntent.getActivity(this, REQUEST_RESTORE, launchIntentForPackage, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    private final void stopForegroundCompat() {
        stopForeground(1);
    }

    /* compiled from: BrainstormVoiceForegroundService.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;", "", "<init>", "()V", "TAG", "", "CHANNEL_ID", "NOTIFICATION_ID", "", "REQUEST_RESTORE", "ACTION_START", "ACTION_UPDATE", "ACTION_STOP", "EXTRA_MIC_MUTED", "start", "", "context", "Landroid/content/Context;", "micMuted", "update", "", "stop", "commandIntent", "Landroid/content/Intent;", "action", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean start(Context context, boolean micMuted) {
            Object obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            if (!micMuted && ContextCompat.checkSelfPermission(applicationContext, "android.permission.RECORD_AUDIO") != 0) {
                FLogger.INSTANCE.w(BrainstormVoiceForegroundService.TAG, "start refused: RECORD_AUDIO not granted");
                return false;
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                Intrinsics.checkNotNull(applicationContext);
                ContextCompat.startForegroundService(applicationContext, commandIntent(applicationContext, BrainstormVoiceForegroundService.ACTION_START, micMuted));
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                FLogger.INSTANCE.e(BrainstormVoiceForegroundService.TAG, "startForegroundService failed", th2);
            }
            return Result.isSuccess-impl(obj);
        }

        public final void update(Context context, boolean micMuted) {
            Object obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                Intrinsics.checkNotNull(applicationContext);
                obj = Result.constructor-impl(applicationContext.startService(commandIntent(applicationContext, BrainstormVoiceForegroundService.ACTION_UPDATE, micMuted)));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                FLogger.INSTANCE.w(BrainstormVoiceForegroundService.TAG, "update ignored: service is not running", th2);
            }
        }

        public final void stop(Context context) {
            Object obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                obj = Result.constructor-impl(Boolean.valueOf(applicationContext.stopService(new Intent(applicationContext, (Class<?>) BrainstormVoiceForegroundService.class))));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                FLogger.INSTANCE.w(BrainstormVoiceForegroundService.TAG, "stopService failed", th2);
            }
        }

        private final Intent commandIntent(Context context, String action, boolean micMuted) {
            Intent intent = new Intent(context, (Class<?>) BrainstormVoiceForegroundService.class);
            intent.setAction(action);
            intent.putExtra(BrainstormVoiceForegroundService.EXTRA_MIC_MUTED, micMuted);
            return intent;
        }
    }
}
