package com.bytedance.bdinstall;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class AbsDeviceTokenService implements DeviceTokenService {
    protected abstract String getDeviceToken();

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public Map<String, String> getRequestHeader() {
        String deviceToken = getDeviceToken();
        HashMap hashMap = new HashMap();
        if (deviceToken == null) {
            deviceToken = "";
        }
        hashMap.put("x-tt-dt", deviceToken);
        return hashMap;
    }
}
