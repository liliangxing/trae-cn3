package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;

/* loaded from: classes3.dex */
public interface ISettingRequestService {
    long getLastFetchTime();

    HybridSettingResponse stepOneFromLocal();

    HybridSettingResponse stepOneFromRequest();

    HybridSettingResponse stepTwo();
}
