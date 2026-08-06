package com.ss.mediakit.image;

import java.io.InputStream;
import java.util.Map;

/* loaded from: classes7.dex */
public interface MDLCallback {
    int onFailure(int i, int i2, String str, Throwable th);

    int onHeaders(int i, int i2, Map<String, String> map);

    int onInfos(int i, String str, String str2);

    int onResponse(int i, InputStream inputStream, int i2);
}
