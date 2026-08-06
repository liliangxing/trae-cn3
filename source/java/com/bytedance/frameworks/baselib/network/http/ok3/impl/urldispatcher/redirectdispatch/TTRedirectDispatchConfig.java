package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.redirectdispatch;

import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig;

/* loaded from: classes2.dex */
public class TTRedirectDispatchConfig extends TTHostPathRuleBaseTNCConfig<TTRedirectDispatchValue> {
    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig
    public String getConfigRootKey() {
        return "ttnet_redirect_dp";
    }

    @Override // com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathRuleBaseTNCConfig
    public TTRedirectDispatchValue parseHostPathValue(Object obj) {
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num == null) {
            return null;
        }
        TTRedirectDispatchValue tTRedirectDispatchValue = new TTRedirectDispatchValue();
        tTRedirectDispatchValue.enabled = num.intValue() == 1;
        return tTRedirectDispatchValue;
    }
}
