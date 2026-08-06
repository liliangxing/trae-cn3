package com.bytedance.push.settings.notification;

import android.app.NotificationChannel;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.push.settings.common.SerializableItem;

/* loaded from: classes4.dex */
public class NotificationChannelSerializable implements SerializableItem {
    private NotificationChannel mNotificationChannel;

    public NotificationChannelSerializable(NotificationChannel notificationChannel) {
        this.mNotificationChannel = notificationChannel;
    }

    public NotificationChannelSerializable() {
    }

    public NotificationChannel getNotificationChannel() {
        return this.mNotificationChannel;
    }

    public boolean equals(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            return TextUtils.equals(notificationChannel.getId(), this.mNotificationChannel.getId());
        }
        return false;
    }

    @Override // com.bytedance.push.settings.common.SerializableItem
    public void fromString(String str) {
        byte[] decode = Base64.decode(str, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationChannel = (NotificationChannel) NotificationChannel.CREATOR.createFromParcel(obtain);
        }
    }

    @Override // com.bytedance.push.settings.common.SerializableItem
    public String toStr() {
        Parcel obtain = Parcel.obtain();
        this.mNotificationChannel.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return Base64.encodeToString(marshall, 0);
    }
}
