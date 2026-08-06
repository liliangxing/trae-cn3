package com.bytedance.notification.supporter.impl;

import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.UserHandle;
import com.bytedance.notification.supporter.service.ISystemService;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: classes4.dex */
public class SystemServiceImpl implements ISystemService {
    private KeyguardManager mKeyguardManager;
    private final String TAG = "SystemServiceImpl";
    private Object mNotificationService = null;
    private int mUid = -1;

    public SystemServiceImpl(Context context) {
        this.mKeyguardManager = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.bytedance.notification.supporter.service.ISystemService
    public Object getNotificationService() {
        if (this.mNotificationService == null) {
            try {
                this.mNotificationService = DoubleReflectUtils.getMethod(NotificationManager.class, "getService", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable th) {
                Logger.e("SystemServiceImpl", "error when get mNotificationService ", th);
            }
        }
        return this.mNotificationService;
    }

    @Override // com.bytedance.notification.supporter.service.ISystemService
    public int getCurUid(Context context) {
        if (this.mUid == -1) {
            try {
                this.mUid = ((Integer) DoubleReflectUtils.getMethod(UserHandle.class, "getIdentifier", new Class[0]).invoke(DoubleReflectUtils.getMethod(Context.class, "getUser", new Class[0]).invoke(context, new Object[0]), new Object[0])).intValue();
            } catch (Throwable th) {
                Logger.e("SystemServiceImpl", "error when get mCurUid ", th);
            }
        }
        return this.mUid;
    }

    @Override // com.bytedance.notification.supporter.service.ISystemService
    public boolean curScreenIsOff() {
        return this.mKeyguardManager.inKeyguardRestrictedInputMode();
    }
}
