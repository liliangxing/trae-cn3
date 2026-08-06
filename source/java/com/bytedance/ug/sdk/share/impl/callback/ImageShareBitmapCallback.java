package com.bytedance.ug.sdk.share.impl.callback;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public interface ImageShareBitmapCallback {
    void onShareFailed();

    void onShareSuccess(Bitmap bitmap);
}
