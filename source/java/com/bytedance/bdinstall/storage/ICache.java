package com.bytedance.bdinstall.storage;

import java.util.List;

/* loaded from: classes3.dex */
public interface ICache {
    void cacheString(String str, String str2);

    void clear(List<String> list);

    String getCachedString(String str);

    String[] loadAccId(String[] strArr, String[] strArr2);

    String loadClientUdid(String str, String str2);

    String loadDeviceId(String str, String str2);

    String loadOpenUdid(String str, String str2);

    String loadSerialNumber(String str, String str2);

    String loadUdid(String str, String str2);
}
