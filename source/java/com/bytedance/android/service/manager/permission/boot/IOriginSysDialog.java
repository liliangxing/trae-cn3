package com.bytedance.android.service.manager.permission.boot;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.common.push.interfaze.RequestResultCallback;

/* loaded from: classes3.dex */
public interface IOriginSysDialog extends RequestResultCallback {
    int getPushType();

    void onActivityResult(int i, int i2, Intent intent);

    void showOriginSysDialog(Activity activity, RequestResultCallback requestResultCallback);
}
