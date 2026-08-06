package com.bytedance.tobshadow.applog.store.kv;

import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public interface IKVStore {
    IKVStore clear();

    boolean contains(String str);

    Map<String, ?> getAll();

    boolean getBoolean(String str, boolean z);

    int getInt(String str, int i);

    long getLong(String str, long j);

    String getString(String str, String str2);

    Set<String> getStringSet(String str, Set<String> set);

    IKVStore putBoolean(String str, boolean z);

    IKVStore putInt(String str, int i);

    IKVStore putLong(String str, long j);

    IKVStore putString(String str, String str2);

    IKVStore putStringSet(String str, Set<String> set);

    IKVStore remove(String str);
}
