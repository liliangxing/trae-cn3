package com.ss.android.message;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes7.dex */
public interface IPushLifeCycleListener {
    void onNotifyDestroy();

    void onNotifyServiceCreate(Context context);

    void onNotifyServiceStart(Intent intent);
}
