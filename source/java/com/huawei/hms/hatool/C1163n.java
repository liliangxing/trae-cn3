package com.huawei.hms.hatool;

import android.util.Pair;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.hatool.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1163n {

    /* renamed from: a */
    public static final Charset f1525a = Charset.forName(Utf8Charset.NAME);

    /* renamed from: a */
    public static Pair<byte[], String> m1639a(String str, int i) {
        if (str == null || str.length() < i) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, i);
        return new Pair<>(HexUtil.hexStr2ByteArray(substring), str.substring(i));
    }

    /* renamed from: a */
    public static String m1640a(String str, String str2) {
        Pair<byte[], String> m1639a = m1639a(str, 32);
        return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray((String) m1639a.second), HexUtil.hexStr2ByteArray(str2), (byte[]) m1639a.first), f1525a);
    }

    /* renamed from: a */
    public static String m1641a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
            if (hexStr2ByteArray.length >= 16) {
                return HexUtil.byteArray2HexStr(AesGcm.encrypt(bArr, hexStr2ByteArray));
            }
            str2 = "key length is not right";
        }
        C1182v.m1778b("AesCipher", str2);
        return "";
    }

    /* renamed from: b */
    public static String m1642b(String str, String str2) {
        return HexUtil.byteArray2HexStr(AesCbc.encrypt(str.getBytes(f1525a), HexUtil.hexStr2ByteArray(str2)));
    }
}
