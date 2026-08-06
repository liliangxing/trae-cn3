package com.bytedance.ug.sdk.deeplink.helper;

import android.app.Activity;

/* loaded from: classes4.dex */
public interface IAppStatusListener {
    void onBack(Activity activity);

    void onFront(Activity activity);
}
