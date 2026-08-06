package com.bytedance.trae.push.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushBody;
import com.bytedance.push.interfaze.ICustomNotificationBuilder;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.push.api.PushConst;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CustomNotificationBuilder.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0002J,\u0010\u001d\u001a\u00020\u0010*\u00020\u001e2\b\b\u0003\u0010\u001f\u001a\u00020\f2\b\b\u0003\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002J.\u0010#\u001a\u0004\u0018\u00010\u0010*\u00020\u001e2\b\b\u0003\u0010\u001f\u001a\u00020\f2\b\b\u0003\u0010 \u001a\u00020\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/trae/push/impl/CustomNotificationBuilder;", "Lcom/bytedance/push/interfaze/ICustomNotificationBuilder;", "<init>", "()V", "TAG", "", "CHANNEL_ID", "buildNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", PraiseDialogConstant.FROM, "", "model", "Lcom/bytedance/push/PushBody;", LynxImageService.CACHE_BITMAP, "Landroid/graphics/Bitmap;", "buildPushPendingIntent", "Landroid/app/PendingIntent;", "setNotificationIconStyle", "", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "pushBitmap", "pushBody", "setNotificationLargeImage", "setNotificationSmallImage", "setNotificationNoneImage", "getLauncherIconBitmap", "toBitmap", "Landroid/graphics/drawable/Drawable;", "width", "height", "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CustomNotificationBuilder implements ICustomNotificationBuilder {
    private static final int BIG_PIC_PRIORITY = 3;
    private static final int SMALL_PIC_PRIORITY = 4;
    private final String TAG = "CustomNotificationBuilder";
    private final String CHANNEL_ID = Configuration.NOTIFICATION_ID;

    @Override // com.bytedance.push.interfaze.ICustomNotificationBuilder
    public Notification buildNotification(Context context, int from, PushBody model, Bitmap bitmap) {
        String str;
        NotificationCompat.Builder showWhen = new NotificationCompat.Builder(AppHost.Companion.getApplication(), this.CHANNEL_ID).setContentIntent(buildPushPendingIntent(model, from)).setGroup(model != null ? model.groupId : null).setAutoCancel(true).setSmallIcon(AppHost.Companion.getAppIconId()).setContentTitle(model != null ? model.title : null).setContentText((model == null || (str = model.text) == null) ? null : StringsKt.replace$default(str, "\\n", "\n", false, 4, (Object) null)).setShowWhen(model != null && model.showWhen);
        Intrinsics.checkNotNullExpressionValue(showWhen, "setShowWhen(...)");
        setNotificationIconStyle(showWhen, bitmap, model);
        Notification build = showWhen.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final PendingIntent buildPushPendingIntent(PushBody model, int from) {
        Context applicationContext = AppHost.Companion.getApplication().getApplicationContext();
        Uri build = Uri.parse(model != null ? model.open_url : null).buildUpon().appendQueryParameter(PushConst.PUSH_KEY_IS_FROM_PUSH, RouterConstants.TRUE).appendQueryParameter(PushConst.PUSH_KEY_IS_FROM_CUSTOM_PUSH, RouterConstants.TRUE).build();
        PackageManager packageManager = AppHost.Companion.getApplication().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(AppHost.Companion.getApplication().getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(268468224);
        } else {
            launchIntentForPackage = null;
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setAction("android.intent.action.VIEW");
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.putExtra("push_body", model != null ? model.getOriginData() : null);
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.putExtra(PushConst.KEY_PUSH_MESSAGE_FROM, from);
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setPackage(AppHost.Companion.getApplication().getPackageName());
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setData(build);
        }
        if (model != null) {
            from = (int) model.f84id;
        }
        PendingIntent activity = PendingIntent.getActivity(applicationContext, from, launchIntentForPackage, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    private final void setNotificationIconStyle(NotificationCompat.Builder builder, Bitmap pushBitmap, PushBody pushBody) {
        if (pushBitmap == null || pushBody == null) {
            setNotificationNoneImage(builder);
            return;
        }
        int i = pushBody.imageType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        setNotificationNoneImage(builder);
                        return;
                    }
                }
            }
            setNotificationSmallImage(builder, pushBitmap);
            return;
        }
        setNotificationLargeImage(builder, pushBitmap);
    }

    private final void setNotificationLargeImage(NotificationCompat.Builder builder, Bitmap pushBitmap) {
        NotificationCompat.Style bigLargeIcon = new NotificationCompat.BigPictureStyle().bigPicture(pushBitmap).bigLargeIcon(getLauncherIconBitmap());
        Intrinsics.checkNotNullExpressionValue(bigLargeIcon, "bigLargeIcon(...)");
        builder.setStyle(bigLargeIcon).setLargeIcon(pushBitmap);
    }

    private final void setNotificationSmallImage(NotificationCompat.Builder builder, Bitmap pushBitmap) {
        builder.setLargeIcon(pushBitmap);
    }

    private final void setNotificationNoneImage(NotificationCompat.Builder builder) {
        builder.setLargeIcon(getLauncherIconBitmap());
    }

    private final Bitmap getLauncherIconBitmap() {
        try {
            Drawable applicationIcon = AppHost.Companion.getApplication().getPackageManager().getApplicationIcon(AppHost.Companion.getApplication().getApplicationInfo());
            Intrinsics.checkNotNullExpressionValue(applicationIcon, "getApplicationIcon(...)");
            return toBitmapOrNull$default(this, applicationIcon, 0, 0, null, 7, null);
        } catch (PackageManager.NameNotFoundException e) {
            FLogger.INSTANCE.mo426e(this.TAG, e.getMessage());
            return null;
        }
    }

    static /* synthetic */ Bitmap toBitmap$default(CustomNotificationBuilder customNotificationBuilder, Drawable drawable, int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            config = null;
        }
        return customNotificationBuilder.toBitmap(drawable, i, i2, config);
    }

    private final Bitmap toBitmap(Drawable drawable, int i, int i2, Bitmap.Config config) {
        Bitmap createScaledBitmap;
        String str;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                if (i == bitmapDrawable.getBitmap().getWidth() && i2 == bitmapDrawable.getBitmap().getHeight()) {
                    createScaledBitmap = bitmapDrawable.getBitmap();
                    str = "getBitmap(...)";
                } else {
                    createScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i, i2, true);
                    str = "createScaledBitmap(...)";
                }
                Intrinsics.checkNotNullExpressionValue(createScaledBitmap, str);
                return createScaledBitmap;
            }
        }
        int i3 = drawable.getBounds().left;
        int i4 = drawable.getBounds().top;
        int i5 = drawable.getBounds().right;
        int i6 = drawable.getBounds().bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i3, i4, i5, i6);
        return createBitmap;
    }

    static /* synthetic */ Bitmap toBitmapOrNull$default(CustomNotificationBuilder customNotificationBuilder, Drawable drawable, int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i3 & 2) != 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        if ((i3 & 4) != 0) {
            config = null;
        }
        return customNotificationBuilder.toBitmapOrNull(drawable, i, i2, config);
    }

    private final Bitmap toBitmapOrNull(Drawable drawable, int i, int i2, Bitmap.Config config) {
        if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null) {
            return null;
        }
        return toBitmap(drawable, i, i2, config);
    }
}
