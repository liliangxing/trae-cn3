package com.bytedance.mt.protector.impl;

import android.net.Uri;
import com.bytedance.mt.protector.Protector;
import com.bytedance.mt.protector.ProtectorType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UriProtector extends BaseProtector<String> {
    private static ProtectorType protectorType = ProtectorType.URI;

    public static Uri parse(String str) {
        if (Protector.enable()) {
            try {
                return Uri.parse(str);
            } catch (Throwable th) {
                String str2 = (String) tryProtect(protectorType, th, String.class);
                if (str2 == null) {
                    throw th;
                }
                return Uri.parse(str2);
            }
        }
        return Uri.parse(str);
    }

    public static Set<String> getQueryParameterNames(Uri uri) {
        if (Protector.enable()) {
            try {
                return uri.getQueryParameterNames();
            } catch (Throwable th) {
                String str = (String) tryProtect(protectorType, th, String.class);
                if (str == null) {
                    throw th;
                }
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                return hashSet;
            }
        }
        return uri.getQueryParameterNames();
    }

    public static List<String> getQueryParameters(Uri uri, String str) {
        if (Protector.enable()) {
            try {
                return uri.getQueryParameters(str);
            } catch (Throwable th) {
                String str2 = (String) tryProtect(protectorType, th, String.class);
                if (str2 == null) {
                    throw th;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(str2);
                return arrayList;
            }
        }
        return uri.getQueryParameters(str);
    }

    public static String getQueryParameter(Uri uri, String str) {
        if (Protector.enable()) {
            try {
                return uri.getQueryParameter(str);
            } catch (Throwable th) {
                String str2 = (String) tryProtect(protectorType, th, String.class);
                if (str2 != null) {
                    return str2;
                }
                throw th;
            }
        }
        return uri.getQueryParameter(str);
    }
}
