package com.ss.android.deviceregister.core.cache;

import org.json.JSONArray;

/* loaded from: classes7.dex */
public interface IDeviceRegisterParameter {
    void clear(String str);

    String getClientUDID();

    String getDeviceId();

    String getOpenUdid(boolean z);

    String getSerialNumber();

    String[] getSimSerialNumbers();

    String getUdId();

    JSONArray getUdIdList();

    void updateDeviceId(String str);
}
