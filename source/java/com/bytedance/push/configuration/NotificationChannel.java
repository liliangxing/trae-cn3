package com.bytedance.push.configuration;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class NotificationChannel {
    public final String id;
    public final String name;

    public NotificationChannel(String str, String str2) {
        this.name = str;
        this.id = str2;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.name)) ? false : true;
    }
}
