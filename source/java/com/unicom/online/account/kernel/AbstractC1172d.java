package com.unicom.online.account.kernel;

import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;

/* renamed from: com.unicom.online.account.kernel.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1172d {
    /* renamed from: a */
    public static String m510a() {
        try {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            if (hashSet.size() > 0) {
                Object[] array = hashSet.toArray();
                int min = Math.min(array.length, 5);
                for (int i = 0; i < min; i++) {
                    sb.append((String) array[i]);
                    if (i < min - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                }
                sb3.append("&private_ip=" + sb.toString());
            }
            if (hashSet2.size() > 0) {
                Object[] array2 = hashSet2.toArray();
                int min2 = Math.min(array2.length, 5);
                for (int i2 = 0; i2 < min2; i2++) {
                    String str = (String) array2[i2];
                    if (str.contains("%")) {
                        str = str.substring(0, str.indexOf("%"));
                    }
                    sb2.append(str);
                    if (i2 < min2 - 1) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                }
                sb3.append("&private_ip_v6=" + sb2.toString());
            }
            return sb3.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
