package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C0879b;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.hatool.e1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1138e1 {
    /* renamed from: a */
    public static String m1491a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2)) {
            return m1494a(str, str2, str3) ? str2 : str4;
        }
        C1182v.m1786f("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + str);
        return str4;
    }

    /* renamed from: a */
    public static boolean m1492a(String str) {
        return !m1493a(C0879b.f567k, str, 256);
    }

    /* renamed from: a */
    public static boolean m1493a(String str, String str2, int i) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder("checkString() Parameter is empty : ");
        } else {
            if (str2.length() <= i) {
                return true;
            }
            sb = new StringBuilder("checkString() Failure of parameter length check! Parameter:");
        }
        C1182v.m1786f("hmsSdk", sb.append(str).toString());
        return false;
    }

    /* renamed from: a */
    public static boolean m1494a(String str, String str2, String str3) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder("checkString() Parameter is null! Parameter:");
        } else {
            if (Pattern.compile(str3).matcher(str2).matches()) {
                return true;
            }
            sb = new StringBuilder("checkString() Parameter verification failure! Parameter:");
        }
        C1182v.m1786f("hmsSdk", sb.append(str).toString());
        return false;
    }

    /* renamed from: a */
    public static boolean m1495a(Map<String, String> map) {
        String str;
        if (map == null || map.size() == 0) {
            str = "onEvent() mapValue has not data.so,The data will be empty";
        } else if (map.size() == 1 && (map.get("constants") != null || map.get("_constants") != null)) {
            str = "checkMap() the key can't be constants or _constants";
        } else {
            if (map.size() <= 2048 && map.toString().length() <= 204800) {
                return true;
            }
            str = "checkMap Map data is too big! size: " + map.size() + " length: " + map.toString().length();
        }
        C1182v.m1786f("hmsSdk", str);
        return false;
    }
}
