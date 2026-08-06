package com.bytedance.android.monitorV2.hybridSetting;

import android.content.Context;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultHybridSettingManager implements IHybridSettingManager {
    private static volatile DefaultHybridSettingManager instance;
    private BidInfo bidInfo;
    private CheckFilter checkFilter;
    private Map<String, Integer> customEventSample;
    private Set<String> hostWhiteSet;
    private SwitchConfig switchConfig;
    private long updateTime = 0;
    private int duration = 0;
    private long settingId = 0;

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public HybridSettingInitConfig getInitConfig() {
        return null;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void init(Context context, boolean z) {
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void loopUpdate() {
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void parseSettings() {
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public void updateForDuration(int i) {
    }

    public static DefaultHybridSettingManager getInstance() {
        if (instance == null) {
            synchronized (DefaultHybridSettingManager.class) {
                if (instance == null) {
                    instance = new DefaultHybridSettingManager();
                }
            }
        }
        return instance;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public BidInfo getBidInfo() {
        if (this.bidInfo == null) {
            this.bidInfo = new BidInfo();
        }
        return this.bidInfo;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public SwitchConfig getSwitch() {
        if (this.switchConfig == null) {
            this.switchConfig = new SwitchConfig();
        }
        return this.switchConfig;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public List<BidRegex> getRexList() {
        return new ArrayList();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public int getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public long getSettingId() {
        return this.settingId;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public Map<String, Integer> getAllEventSample() {
        if (this.customEventSample == null) {
            this.customEventSample = new HashMap();
        }
        return this.customEventSample;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public Set<String> getHostWhiteSet() {
        if (this.hostWhiteSet == null) {
            this.hostWhiteSet = new HashSet();
        }
        return this.hostWhiteSet;
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager
    public CheckFilter getCheckFilter() {
        if (this.checkFilter == null) {
            this.checkFilter = new CheckFilter();
        }
        return this.checkFilter;
    }
}
