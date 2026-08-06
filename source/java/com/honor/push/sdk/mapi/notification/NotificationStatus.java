package com.honor.push.sdk.mapi.notification;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Bundle;

/* loaded from: classes6.dex */
public class NotificationStatus {
    public int a;
    public int b;
    public String c;
    public PendingIntent d;

    public NotificationStatus(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public NotificationStatus(Bundle bundle) {
        this.a = 10002;
        this.b = 8003002;
        this.c = "";
        if (bundle != null) {
            this.a = bundle.getInt("stateCode", 10002);
            this.b = bundle.getInt("errorCode", this.b);
            this.c = bundle.getString("errorMessage");
            this.d = (PendingIntent) bundle.getParcelable("data");
        }
    }

    public int getErrCode() {
        return this.b;
    }

    public String getErrMsg() {
        return this.c;
    }

    public int getStatusCode() {
        return this.a;
    }

    public void startResolutionForResult(Activity activity, int i) {
        PendingIntent pendingIntent;
        if (this.a != 10001 || activity == null || (pendingIntent = this.d) == null) {
            return;
        }
        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
    }
}
