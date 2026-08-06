package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatternProtector extends BaseProtector<String> {
    private static ProtectorType protectorType = ProtectorType.PATTERN;

    @ProtectorMethod(exceptions = {Exception.class})
    public static Pattern compile(String str) {
        if (Protector.enable()) {
            try {
                return Pattern.compile(str);
            } catch (Throwable th) {
                String str2 = (String) tryProtect(protectorType, th, String.class);
                if (str2 == null) {
                    throw th;
                }
                return Pattern.compile(str2);
            }
        }
        return Pattern.compile(str);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static Pattern compile(String str, int i) {
        if (Protector.enable()) {
            try {
                return Pattern.compile(str, i);
            } catch (Throwable th) {
                String str2 = (String) tryProtect(protectorType, th, String.class);
                if (str2 == null) {
                    throw th;
                }
                return Pattern.compile(str2, i);
            }
        }
        return Pattern.compile(str, i);
    }

    @ProtectorMethod(exceptions = {Exception.class})
    public static boolean matches(String str, CharSequence charSequence) {
        if (Protector.enable()) {
            try {
                return Pattern.matches(str, charSequence);
            } catch (Throwable th) {
                Boolean bool = (Boolean) tryProtect(protectorType, th, Boolean.class);
                if (bool == null) {
                    throw th;
                }
                return bool.booleanValue();
            }
        }
        return Pattern.matches(str, charSequence);
    }
}
