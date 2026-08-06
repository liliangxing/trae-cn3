package com.lynx.animax.base.bridge;

import java.util.HashMap;

/* loaded from: classes6.dex */
public interface ReadableMap {
    HashMap<String, Object> asHashMap();

    double getDouble(String str, double d);

    int getInt(String str, int i);

    long getLong(String str, long j);

    String getString(String str);

    ReadableType getType(String str);
}
