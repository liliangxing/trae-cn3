package com.bytedance.pia.core.api.services;

import com.bytedance.pia.core.api.PiaAppInfo;
import com.bytedance.pia.core.api.PiaCoreApi;

/* loaded from: classes4.dex */
public interface IPiaSettingService {
    void enableSetting(boolean z);

    void initialize(PiaAppInfo piaAppInfo, String str);

    static IPiaSettingService inst() {
        return (IPiaSettingService) PiaCoreApi.get(IPiaSettingService.class);
    }
}
