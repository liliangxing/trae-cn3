package com.bytedance.notification.supporter.service;

import android.content.Context;

/* loaded from: classes4.dex */
public interface ISystemService {
    boolean curScreenIsOff();

    int getCurUid(Context context);

    Object getNotificationService();
}
