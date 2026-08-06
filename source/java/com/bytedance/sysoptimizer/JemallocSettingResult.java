package com.bytedance.sysoptimizer;

/* loaded from: classes5.dex */
public class JemallocSettingResult {
    public int exitCode;
    public String optionName;
    public String rawValue;
    public String settingValue;

    public JemallocSettingResult(String str, String str2, String str3, int i) {
        this.optionName = str;
        this.rawValue = str2;
        this.exitCode = i;
        this.settingValue = str3;
    }
}
