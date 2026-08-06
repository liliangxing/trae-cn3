package cn.com.chinatelecom.account.api.p006a;

import androidx.core.view.InputDeviceCompat;

/* renamed from: cn.com.chinatelecom.account.api.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0677c {

    /* renamed from: a */
    private static final char[] f121a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m187a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            char[] cArr = f121a;
            sb.append(cArr[(bArr[i] >> 4) & 15]).append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m188a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i] = (byte) digit;
        }
        return bArr;
    }
}
