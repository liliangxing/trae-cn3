package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* compiled from: StringUtils.java */
/* renamed from: com.huawei.hms.opendevice.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1206n {
    /* renamed from: a */
    public static boolean m1900a(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
