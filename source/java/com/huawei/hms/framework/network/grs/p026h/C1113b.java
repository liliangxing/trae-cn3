package com.huawei.hms.framework.network.grs.p026h;

import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.bytedance.webx.addr.AddressParam;
import com.bytedance.webx.seclink.setting.SettingConfig;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.framework.network.grs.h.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1113b {

    /* renamed from: a */
    private static final String f1375a = "b";

    /* renamed from: b */
    private static final Pattern f1376b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: a */
    public static String m1367a(String str) {
        return m1368a(str, "SHA-256");
    }

    /* renamed from: a */
    private static String m1368a(String str, String str2) {
        String str3;
        String str4;
        try {
            try {
                return m1369a(MessageDigest.getInstance(str2).digest(str.getBytes(Utf8Charset.NAME)));
            } catch (NoSuchAlgorithmException unused) {
                str3 = f1375a;
                str4 = "encrypt NoSuchAlgorithmException";
                Logger.m1189w(str3, str4);
                return null;
            }
        } catch (UnsupportedEncodingException unused2) {
            str3 = f1375a;
            str4 = "encrypt UnsupportedEncodingException";
        }
    }

    /* renamed from: a */
    private static String m1369a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append(AddressParam.TYPE_DISAPPROVE);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m1370b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 1;
        if (str.length() == 1) {
            return SettingConfig.SPECIAL_SCHEME;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            String str2 = str.charAt(i2) + "";
            if (f1376b.matcher(str2).matches()) {
                if (i % 2 == 0) {
                    str2 = SettingConfig.SPECIAL_SCHEME;
                }
                i++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }
}
