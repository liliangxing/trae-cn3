package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: BundleUtil.java */
/* renamed from: com.huawei.hms.push.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1213c {
    /* renamed from: a */
    public static byte[] m1936a(Bundle bundle, String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            return byteArray == null ? new byte[0] : byteArray;
        } catch (Exception e) {
            HMSLog.m2120i(BundleUtil.TAG, "getByteArray exception" + e.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    public static String m1937b(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            HMSLog.m2120i(BundleUtil.TAG, "getString exception" + e.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static String m1938c(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            return string == null ? "" : string;
        } catch (Exception e) {
            HMSLog.m2120i(BundleUtil.TAG, "getString exception" + e.getMessage());
            return "";
        }
    }
}
