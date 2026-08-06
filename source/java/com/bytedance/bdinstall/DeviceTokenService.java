package com.bytedance.bdinstall;

import java.util.Map;

/* loaded from: classes3.dex */
public interface DeviceTokenService {
    Map<String, String> getRequestHeader();

    void updateToken(String str, Env env);
}
