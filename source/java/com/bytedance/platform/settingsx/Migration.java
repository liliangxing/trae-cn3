package com.bytedance.platform.settingsx;

import java.util.Set;

/* loaded from: classes4.dex */
public interface Migration {
    boolean contains(String str);

    boolean getBoolean(String str);

    float getFloat(String str);

    int getInt(String str);

    long getLong(String str);

    String getString(String str);

    Set<String> getStringSet(String str);

    void putBoolean(String str, boolean z);

    void putFloat(String str, float f);

    void putInt(String str, int i);

    void putLong(String str, long j);

    void putString(String str, String str2);

    void putStringSet(String str, Set<String> set);
}
