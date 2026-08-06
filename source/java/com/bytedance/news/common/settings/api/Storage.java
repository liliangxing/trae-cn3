package com.bytedance.news.common.settings.api;

import java.util.Set;

/* loaded from: classes4.dex */
public interface Storage {
    void apply();

    void clear();

    boolean contains(String str);

    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z);

    float getFloat(String str);

    float getFloat(String str, float f);

    int getInt(String str);

    int getInt(String str, int i);

    long getLong(String str);

    long getLong(String str, long j);

    String getString(String str);

    String getString(String str, String str2);

    Set<String> getStringSet(String str);

    Set<String> getStringSet(String str, Set<String> set);

    void putBoolean(String str, boolean z);

    void putFloat(String str, float f);

    void putInt(String str, int i);

    void putLong(String str, long j);

    void putString(String str, String str2);

    void putStringSet(String str, Set<String> set);

    void remove(String str);
}
