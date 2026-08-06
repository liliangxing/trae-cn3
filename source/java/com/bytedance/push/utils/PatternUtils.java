package com.bytedance.push.utils;

import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class PatternUtils {
    public static boolean inputMatchRegText(String str, String str2) {
        try {
            if (str == null || str2 == null) {
                Logger.w("PatternUtils", "[inputMatchRegText]return false because  input or reg is null,input:" + str + " reg:" + str2);
                return false;
            }
            return Pattern.compile(str2).matcher(str).find();
        } catch (Throwable th) {
            Logger.e("PatternUtils", "[match]inputMatchRegText match exception ", th);
            return false;
        }
    }
}
