package com.bytedance.lottie;

import android.graphics.Bitmap;
import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;

/* compiled from: ImageAssetDelegateAsync.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/lottie/ImageAssetDelegateAsync;", "Lcom/bytedance/lottie/ImageAssetDelegate;", "fetchBitmapAsync", "", "asset", "Lcom/bytedance/lottie/LottieImageAsset;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/lottie/LottieCallback;", "Landroid/graphics/Bitmap;", "bd-lottie_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public interface ImageAssetDelegateAsync extends ImageAssetDelegate {
    void fetchBitmapAsync(LottieImageAsset asset, LottieCallback<Bitmap> callback);
}
