package com.bytedance.android.tools.superkv;

import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public interface IDataStore {
    Boolean getBoolean(String str);

    Boolean getBoolean(String str, boolean z);

    byte[] getBytes(String str);

    Double getDouble(String str);

    Double getDouble(String str, double d);

    Float getFloat(String str);

    Float getFloat(String str, float f);

    Integer getInteger(String str);

    Integer getInteger(String str, int i);

    Long getLong(String str);

    Long getLong(String str, long j);

    String getString(String str);

    String getString(String str, String str2);

    List<String> getStringList(String str);

    List<String> getStringList(String str, List<String> list);

    void putBoolean(String str, boolean z);

    void putBytes(String str, byte[] bArr);

    void putDouble(String str, double d);

    void putFloat(String str, float f);

    void putInteger(String str, int i);

    void putLong(String str, long j);

    void putString(String str, String str2);

    void putStringList(String str, Collection<String> collection);

    void remove(String str);
}
