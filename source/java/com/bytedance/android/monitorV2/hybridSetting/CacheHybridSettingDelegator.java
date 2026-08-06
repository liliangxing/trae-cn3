package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.hybridSetting.localcache.LocalHybridSettingManager;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheHybridSettingDelegator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/CacheHybridSettingDelegator;", "Lcom/bytedance/android/monitorV2/hybridSetting/IHybridSettingDelegator;", "()V", "bidInfo", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo;", "checkFilter", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "duration", "", "eventSample", "", "", "hostWhiteSet", "", "settingId", "", "switchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "updateTime", "ensureBasicPropertyInit", "", "getBidInfo", "getCheckFilter", "getDuration", "getEventSample", "getHostWhiteSet", "getSettingId", "getSwitchConfig", "getUpdateTime", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CacheHybridSettingDelegator implements IHybridSettingDelegator {
    private BidInfo bidInfo;
    private CheckFilter checkFilter;
    private int duration;
    private Map<String, Integer> eventSample;
    private Set<String> hostWhiteSet;
    private long settingId;
    private SwitchConfig switchConfig;
    private long updateTime;

    public CacheHybridSettingDelegator() {
        ensureBasicPropertyInit();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public BidInfo getBidInfo() {
        if (this.bidInfo == null) {
            synchronized (this) {
                if (this.bidInfo == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.bidInfo = LocalHybridSettingManager.getBidInfo();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = hashMap;
                    BidInfo bidInfo = this.bidInfo;
                    if (bidInfo == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bidInfo");
                        bidInfo = null;
                    }
                    hashMap2.put(InternalWatcher.PARAM_SETTING_PARSE_BID_COUNT, Long.valueOf(bidInfo.bidInfoMap.size()));
                    HashMap hashMap3 = hashMap;
                    BidInfo bidInfo2 = this.bidInfo;
                    if (bidInfo2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bidInfo");
                        bidInfo2 = null;
                    }
                    hashMap3.put(InternalWatcher.PARAM_SETTING_PARSE_REGEX_COUNT, Long.valueOf(bidInfo2.regexList.size()));
                    hashMap.put(InternalWatcher.PARAM_SETTING_PARSE_TIME, Long.valueOf(currentTimeMillis2));
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put(InternalWatcher.PARAM_SETTING_PARSE_TYPE, "parcel");
                    InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_SETTING_PARSE_PERF, hashMap4, hashMap);
                    MonitorLog.m26d("CacheHybridSettingDelegator", "getBidInfo cost: " + currentTimeMillis2);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        BidInfo bidInfo3 = this.bidInfo;
        if (bidInfo3 != null) {
            return bidInfo3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bidInfo");
        return null;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public SwitchConfig getSwitchConfig() {
        if (this.switchConfig == null) {
            synchronized (this) {
                if (this.switchConfig == null) {
                    this.switchConfig = LocalHybridSettingManager.getSwitchConfig();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        SwitchConfig switchConfig = this.switchConfig;
        if (switchConfig != null) {
            return switchConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("switchConfig");
        return null;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public int getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public long getSettingId() {
        return this.settingId;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public Map<String, Integer> getEventSample() {
        if (this.eventSample == null) {
            synchronized (this) {
                if (this.eventSample == null) {
                    this.eventSample = LocalHybridSettingManager.getEventSample();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Map<String, Integer> map = this.eventSample;
        if (map != null) {
            return map;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventSample");
        return null;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public Set<String> getHostWhiteSet() {
        if (this.hostWhiteSet == null) {
            synchronized (this) {
                if (this.hostWhiteSet == null) {
                    this.hostWhiteSet = LocalHybridSettingManager.getHostList();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Set<String> set = this.hostWhiteSet;
        if (set != null) {
            return set;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hostWhiteSet");
        return null;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingDelegator
    public CheckFilter getCheckFilter() {
        if (this.checkFilter == null) {
            synchronized (this) {
                if (this.checkFilter == null) {
                    this.checkFilter = LocalHybridSettingManager.getCheckFilter();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        CheckFilter checkFilter = this.checkFilter;
        if (checkFilter != null) {
            return checkFilter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("checkFilter");
        return null;
    }

    private final void ensureBasicPropertyInit() {
        this.updateTime = LocalHybridSettingManager.getUpdateTime();
        this.duration = LocalHybridSettingManager.getDuration();
        this.settingId = LocalHybridSettingManager.getSettingId();
    }
}
