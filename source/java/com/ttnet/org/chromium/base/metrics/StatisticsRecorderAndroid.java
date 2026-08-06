package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: classes7.dex */
public final class StatisticsRecorderAndroid {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface Natives {
        String toJson(int i);
    }

    private StatisticsRecorderAndroid() {
    }

    public static String toJson(int i) {
        return StatisticsRecorderAndroidJni.get().toJson(i);
    }
}
