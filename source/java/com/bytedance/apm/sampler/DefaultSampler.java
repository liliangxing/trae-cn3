package com.bytedance.apm.sampler;

import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.perf.PerfConfigManager;
import com.bytedance.apm.samplers.ISampleCheck;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultSampler implements ISampleCheck {
    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getLogTypeSwitch(String str) {
        return ApmDelegate.getInstance().getLogTypeSwitch(str);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getServiceSwitch(String str) {
        return ApmDelegate.getInstance().getServiceNameSwitch(str);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getMetricSwitch(String str) {
        return ApmDelegate.getInstance().getMetricsTypeSwitch(str);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfAllowSwitch(String str) {
        return PerfConfigManager.getInstance().getPerfAllowSwitch(str);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfFpsAllowSwitch(String str, String str2) {
        return PerfConfigManager.getInstance().getPerfFpsAllowSwitch(str, str2);
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfSecondStageSwitch(String str) {
        return PerfConfigManager.getInstance().getPerfSecondStageSwitch(str);
    }
}
