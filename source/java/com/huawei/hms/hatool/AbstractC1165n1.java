package com.huawei.hms.hatool;

import android.util.Pair;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.huawei.hms.hatool.n1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1165n1 {
    /* renamed from: a */
    public static long m1645a(String str, long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j))).getTime();
        } catch (ParseException unused) {
            C1182v.m1786f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0L;
        }
    }

    /* renamed from: a */
    public static Pair<String, String> m1646a(String str) {
        String str2;
        String str3;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] split = str.split("-");
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new Pair<>(str2, str3);
    }

    /* renamed from: a */
    public static String m1647a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    /* renamed from: a */
    public static String m1648a(String str, String str2) {
        return "_default_config_tag".equals(str) ? str : str + "-" + str2;
    }

    /* renamed from: a */
    public static String m1649a(String str, String str2, String str3) {
        return ("_default_config_tag".equals(str) ? new StringBuilder("_default_config_tag#") : new StringBuilder().append(str).append("-").append(str2).append("#")).append(str3).toString();
    }

    /* renamed from: a */
    public static Set<String> m1650a(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if ("_default_config_tag".equals(str)) {
                hashSet.add("_default_config_tag");
            } else {
                String str2 = str + "-oper";
                String str3 = str + "-maint";
                hashSet.add(str2);
                hashSet.add(str3);
                hashSet.add(str + "-diffprivacy");
            }
        }
        return hashSet;
    }
}
