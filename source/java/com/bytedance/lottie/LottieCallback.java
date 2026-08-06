package com.bytedance.lottie;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: LottieCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/lottie/LottieCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onFailed", "", "onSuccess", "t", "(Ljava/lang/Object;)V", "bd-lottie_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public interface LottieCallback<T> {
    void onFailed();

    void onSuccess(T t);
}
