package com.bytedance.android.monitorV2.hybridSetting;

import android.content.Context;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IHybridSettingManager {
    Map<String, Integer> getAllEventSample();

    BidInfo getBidInfo();

    CheckFilter getCheckFilter();

    int getDuration();

    Set<String> getHostWhiteSet();

    HybridSettingInitConfig getInitConfig();

    List<BidRegex> getRexList();

    long getSettingId();

    SwitchConfig getSwitch();

    long getUpdateTime();

    void init(Context context, boolean z);

    void loopUpdate();

    void parseSettings();

    void updateForDuration(int i);
}
