package com.bytedance.apm.samplers;

/* loaded from: classes3.dex */
public interface ISampleCheck {
    boolean getLogTypeSwitch(String str);

    boolean getMetricSwitch(String str);

    boolean getPerfAllowSwitch(String str);

    boolean getPerfFpsAllowSwitch(String str, String str2);

    boolean getPerfSecondStageSwitch(String str);

    boolean getServiceSwitch(String str);
}
