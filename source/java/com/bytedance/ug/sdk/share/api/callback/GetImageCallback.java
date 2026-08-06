package com.bytedance.ug.sdk.share.api.callback;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public interface GetImageCallback {
    void onFailed();

    void onSuccess(Bitmap bitmap);
}
