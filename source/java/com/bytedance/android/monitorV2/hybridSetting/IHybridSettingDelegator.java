package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: IHybridSettingDelegator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u000eH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/IHybridSettingDelegator;", "", "getBidInfo", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo;", "getCheckFilter", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "getDuration", "", "getEventSample", "", "", "getHostWhiteSet", "", "getSettingId", "", "getSwitchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "getUpdateTime", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface IHybridSettingDelegator {
    BidInfo getBidInfo();

    CheckFilter getCheckFilter();

    int getDuration();

    Map<String, Integer> getEventSample();

    Set<String> getHostWhiteSet();

    long getSettingId();

    SwitchConfig getSwitchConfig();

    long getUpdateTime();
}
