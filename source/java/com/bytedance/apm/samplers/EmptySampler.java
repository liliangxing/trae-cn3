package com.bytedance.apm.samplers;

/* loaded from: classes3.dex */
public class EmptySampler implements ISampleCheck {
    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getLogTypeSwitch(String str) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getMetricSwitch(String str) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfAllowSwitch(String str) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfFpsAllowSwitch(String str, String str2) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getPerfSecondStageSwitch(String str) {
        return false;
    }

    @Override // com.bytedance.apm.samplers.ISampleCheck
    public boolean getServiceSwitch(String str) {
        return false;
    }
}
