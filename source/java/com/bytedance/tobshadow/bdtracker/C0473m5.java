package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.security.MessageDigest;
import java.util.Collections;

/* renamed from: com.bytedance.tobshadow.bdtracker.m5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0473m5 {

    /* renamed from: a */
    public static final char[] f820a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m533a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return m535b(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m534a(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    return m535b(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m535b(byte[] bArr) {
        if (bArr == null) {
            LoggerImpl.global().warn(Collections.singletonList("DigestUtils"), "bytes is null", new Object[0]);
            return null;
        }
        int length = bArr.length;
        if (length + 0 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i = length * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = bArr[i3 + 0] & 255;
            int i5 = i2 + 1;
            char[] cArr2 = f820a;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }
}
