package com.bytedance.push.interfaze;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.push.PushBody;

/* loaded from: classes4.dex */
public interface ICustomNotificationBuilder {
    Notification buildNotification(Context context, int i, PushBody pushBody, Bitmap bitmap);
}
