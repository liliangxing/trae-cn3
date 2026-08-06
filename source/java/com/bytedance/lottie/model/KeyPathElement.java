package com.bytedance.lottie.model;

import com.bytedance.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes4.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback);

    void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2);
}
