package com.bytedance.android.monitorV2.hybridSetting.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: HybridSettingResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingResponse;", "", "()V", "allEventSample", "", "", "", "bidInfo", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo;", "checkFilter", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "duration", "hostWhiteSet", "", "settingId", "", "switchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "updateTime", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class HybridSettingResponse {
    public int duration;
    public long settingId;
    public long updateTime;
    public BidInfo bidInfo = new BidInfo();
    public SwitchConfig switchConfig = new SwitchConfig();
    public Map<String, Integer> allEventSample = new HashMap();
    public Set<String> hostWhiteSet = new HashSet();
    public CheckFilter checkFilter = new CheckFilter(null, null, null, 7, null);

    public String toString() {
        return "HybridSettingResponse{bidInfo=" + this.bidInfo + ", switchConfig=" + this.switchConfig + ", updateTime='" + this.updateTime + "', duration=" + this.duration + ", settingId=" + this.settingId + "', allEventSample=" + this.allEventSample + ", hostWhiteSet=" + this.hostWhiteSet + ", checkFilter=" + this.checkFilter + AbstractJsonLexerKt.END_OBJ;
    }
}
