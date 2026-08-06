package com.bytedance.push.settings;

/* loaded from: classes4.dex */
public interface Migration {
    boolean contains(String str);

    boolean getBoolean(String str);

    float getFloat(String str);

    int getInt(String str);

    long getLong(String str);

    String getString(String str);
}
