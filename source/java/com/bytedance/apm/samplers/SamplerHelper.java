package com.bytedance.apm.samplers;

/* loaded from: classes3.dex */
public class SamplerHelper {
    private static ISampleCheck sSampler = new EmptySampler();

    public static void setSampler(ISampleCheck iSampleCheck) {
        sSampler = iSampleCheck;
    }

    public static boolean getLogTypeSwitch(String str) {
        return sSampler.getLogTypeSwitch(str);
    }

    public static boolean getServiceSwitch(String str) {
        return sSampler.getServiceSwitch(str);
    }

    public static boolean getMetricSwitch(String str) {
        return sSampler.getMetricSwitch(str);
    }

    public static boolean getPerfAllowSwitch(String str) {
        return sSampler.getPerfAllowSwitch(str);
    }

    public static boolean getPerfFpsAllowSwitch(String str, String str2) {
        return sSampler.getPerfFpsAllowSwitch(str, str2);
    }

    public static boolean getPerfSecondStageSwitch(String str) {
        return sSampler.getPerfSecondStageSwitch(str);
    }
}
