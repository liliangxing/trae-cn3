package com.bytedance.lottie;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public interface ImageAssetDelegate {
    Bitmap fetchBitmap(LottieImageAsset lottieImageAsset);

    void onBitmapExpired();
}
