package com.bytedance.common.model;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public enum ProcessEnum {
    MAIN(":main"),
    PUSH(":push"),
    PUSH_SERVICE(":pushservice"),
    SMP(":smp"),
    UNKNOWN(":unknown");

    public String processSuffix;

    ProcessEnum(String str) {
        this.processSuffix = str;
    }

    public static ProcessEnum parseProcess(String str, String str2) {
        if (TextUtils.equals(str2, str)) {
            return MAIN;
        }
        ProcessEnum processEnum = PUSH;
        if (str.endsWith(processEnum.processSuffix)) {
            return processEnum;
        }
        ProcessEnum processEnum2 = PUSH_SERVICE;
        if (str.endsWith(processEnum2.processSuffix)) {
            return processEnum2;
        }
        ProcessEnum processEnum3 = SMP;
        return str.endsWith(processEnum3.processSuffix) ? processEnum3 : UNKNOWN;
    }

    public static ProcessEnum parseProcess(String str) {
        ProcessEnum processEnum = MAIN;
        if (TextUtils.equals(str, processEnum.processSuffix)) {
            return processEnum;
        }
        ProcessEnum processEnum2 = PUSH;
        if (TextUtils.equals(str, processEnum2.processSuffix)) {
            return processEnum2;
        }
        ProcessEnum processEnum3 = PUSH_SERVICE;
        if (TextUtils.equals(str, processEnum3.processSuffix)) {
            return processEnum3;
        }
        ProcessEnum processEnum4 = SMP;
        return TextUtils.equals(str, processEnum4.processSuffix) ? processEnum4 : UNKNOWN;
    }
}
