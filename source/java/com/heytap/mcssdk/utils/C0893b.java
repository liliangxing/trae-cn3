package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.heytap.mcssdk.p010a.C0871a;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.heytap.mcssdk.utils.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0893b {

    /* renamed from: a */
    public static String f618a = null;

    /* renamed from: b */
    public static final String f619b = "Y29tLm5lYXJtZS5tY3M=";

    /* renamed from: c */
    public static String f620c = "";

    /* renamed from: a */
    private static String m647a() {
        if (TextUtils.isEmpty(f620c)) {
            f620c = new String(C0871a.m551b(f619b));
        }
        byte[] m649a = m649a(m648a(f620c));
        return m649a != null ? new String(m649a, Charset.forName(Utf8Charset.NAME)) : "";
    }

    /* renamed from: a */
    public static byte[] m648a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes(Utf8Charset.NAME);
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    /* renamed from: a */
    public static byte[] m649a(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b = bArr[i];
            int i2 = i + 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m650b(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = AbstractC0894c.m653a(str, m647a());
            C0895d.m661b("sdkDecrypt desDecrypt des data " + str2);
            z = true;
        } catch (Exception e) {
            C0895d.m661b("sdkDecrypt DES excepiton " + e.toString());
            z = false;
        }
        if (TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            f618a = "AES";
            C0896e.m684c().m686a(f618a);
            C0895d.m661b("sdkDecrypt desDecrypt aes data " + str2);
            return str2;
        } catch (Exception e2) {
            C0895d.m661b("sdkDecrypt AES excepiton " + e2.toString());
            return str2;
        }
    }

    /* renamed from: c */
    public static String m651c(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            C0895d.m661b("sdkDecrypt aesDecrypt aes data " + str2);
            z = true;
        } catch (Exception e) {
            C0895d.m661b("sdkDecrypt AES excepiton " + e.toString());
            z = false;
        }
        if (TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = AbstractC0894c.m653a(str, m647a());
            f618a = "DES";
            C0896e.m684c().m686a(f618a);
            C0895d.m661b("sdkDecrypt aesDecrypt des data " + str2);
            return str2;
        } catch (Exception e2) {
            C0895d.m661b("sdkDecrypt DES excepiton " + e2.toString());
            return str2;
        }
    }

    /* renamed from: d */
    public static String m652d(String str) {
        C0895d.m661b("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(f618a)) {
            f618a = C0896e.m684c().m689b();
        }
        if ("DES".equals(f618a)) {
            C0895d.m661b("sdkDecrypt start DES");
            return m650b(str);
        }
        C0895d.m661b("sdkDecrypt start AES");
        return m651c(str);
    }
}
