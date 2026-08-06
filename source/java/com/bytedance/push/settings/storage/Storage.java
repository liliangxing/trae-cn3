package com.bytedance.push.settings.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.push.settings.IDataChangedListener;

/* loaded from: classes4.dex */
public interface Storage {
    boolean contains(String str);

    SharedPreferences.Editor edit();

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

    void registerValChanged(Context context, String str, String str2, IDataChangedListener iDataChangedListener);

    void unregisterValChanged(IDataChangedListener iDataChangedListener);
}
