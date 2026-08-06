package com.huawei.hms.opendevice;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;

/* compiled from: BaseUtil.java */
/* renamed from: com.huawei.hms.opendevice.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1196d {
    /* renamed from: a */
    public static String m1847a(byte[] bArr) {
        return HexUtil.byteArray2HexStr(bArr);
    }

    /* renamed from: a */
    public static byte[] m1848a(String str) {
        return HexUtil.hexStr2ByteArray(str);
    }
}
