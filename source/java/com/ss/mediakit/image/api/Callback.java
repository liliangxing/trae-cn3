package com.ss.mediakit.image.api;

import java.io.InputStream;
import java.util.Map;

/* loaded from: classes7.dex */
public interface Callback {
    default void onCancellation() {
    }

    default void onFailure(int i, int i2, String str, Throwable th) {
    }

    default void onHeaders(int i, int i2, Map<String, String> map) {
    }

    default void onInfos(int i, String str, String str2) {
    }

    default void onResponse(int i, InputStream inputStream, int i2) {
    }
}
