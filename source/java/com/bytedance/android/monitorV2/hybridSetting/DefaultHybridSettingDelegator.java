package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingResponse;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultHybridSettingDelegator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/DefaultHybridSettingDelegator;", "Lcom/bytedance/android/monitorV2/hybridSetting/IHybridSettingDelegator;", "hybridSetting", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingResponse;", "(Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingResponse;)V", "getBidInfo", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo;", "getCheckFilter", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "getDuration", "", "getEventSample", "", "", "getHostWhiteSet", "", "getSettingId", "", "getSwitchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "getUpdateTime", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DefaultHybridSettingDelegator implements IHybridSettingDelegator {
    private final HybridSettingResponse hybridSetting;

    public DefaultHybridSettingDelegator(HybridSettingResponse hybridSettingResponse) {
        Intrinsics.checkNotNullParameter(hybridSettingResponse, "hybridSetting");
        this.hybridSetting = hybridSettingResponse;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public BidInfo getBidInfo() {
        return this.hybridSetting.bidInfo;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public SwitchConfig getSwitchConfig() {
        return this.hybridSetting.switchConfig;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public long getUpdateTime() {
        return this.hybridSetting.updateTime;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public int getDuration() {
        return this.hybridSetting.duration;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public long getSettingId() {
        return this.hybridSetting.settingId;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public Map<String, Integer> getEventSample() {
        return this.hybridSetting.allEventSample;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public Set<String> getHostWhiteSet() {
        return this.hybridSetting.hostWhiteSet;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public CheckFilter getCheckFilter() {
        return this.hybridSetting.checkFilter;
    }
}
