package com.bytedance.news.common.settings.api;

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
}
