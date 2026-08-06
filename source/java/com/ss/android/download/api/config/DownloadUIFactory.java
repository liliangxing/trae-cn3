package com.ss.android.download.api.config;

import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.app.NotificationCompat;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface DownloadUIFactory {
    Notification buildNotification(NotificationCompat.Builder builder);

    Dialog showAlertDialog(DownloadAlertDialogInfo downloadAlertDialogInfo);

    void showToastWithDuration(Context context, String str, Drawable drawable, int i);
}
