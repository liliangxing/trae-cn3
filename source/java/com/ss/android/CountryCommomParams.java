package com.ss.android;

import com.bytedance.common.utility.StringUtils;

/* loaded from: classes7.dex */
public class CountryCommomParams {
    private static String sAppLanguage;
    private static String sAppRegion;
    private static String sGoogleAID;

    public static void setGoogleAID(String str) {
        if (StringUtils.isEmpty(str) || str.equals(sGoogleAID)) {
            return;
        }
        sGoogleAID = str;
    }

    public static void setAppLanguage(String str) {
        if (StringUtils.isEmpty(str) || str.equals(sAppLanguage)) {
            return;
        }
        sAppLanguage = str;
    }

    public static void setAppRegion(String str) {
        if (StringUtils.isEmpty(str) || str.equals(sAppRegion)) {
            return;
        }
        sAppRegion = str;
    }

    public static String getAppLanguage() {
        return sAppLanguage;
    }

    public static String getAppRegion() {
        return sAppRegion;
    }
}
