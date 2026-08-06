package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* renamed from: com.huawei.agconnect.config.impl.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0979e implements IDecrypt {

    /* renamed from: a */
    private final ConfigReader f838a;

    /* renamed from: b */
    private SecretKey f839b;

    /* renamed from: c */
    private boolean f840c = false;

    public C0979e(ConfigReader configReader) {
        this.f838a = configReader;
    }

    /* renamed from: a */
    private void m808a() {
        try {
            this.f839b = C0984j.m816a(new C0978d(this.f838a.getString("/code/code1", null), this.f838a.getString("/code/code2", null), this.f838a.getString("/code/code3", null), this.f838a.getString("/code/code4", null), "PBKDF2WithHmacSHA1", 10000));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("AGC_Mark", "Exception when reading the 'K&I' for 'Config'.");
            this.f839b = null;
        }
        this.f840c = true;
    }

    /* renamed from: a */
    public static boolean m809a(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    /* renamed from: b */
    private String m810b(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        } catch (IllegalStateException | IndexOutOfBoundsException unused) {
            Log.e("AGC_Mark", "getRawString exception");
            return "";
        }
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        String str3;
        if (!this.f840c) {
            m808a();
        }
        if (this.f839b == null) {
            str3 = "mKey is null, return default value";
        } else {
            if (!m809a(str)) {
                return str2;
            }
            try {
                return new String(C0984j.m817a(this.f839b, Hex.decodeHexString(m810b(str))), Utf8Charset.NAME);
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException unused) {
                str3 = "UnsupportedEncodingException||GeneralSecurityException||IllegalArgumentException";
            }
        }
        Log.e("AGC_Mark", str3);
        return str2;
    }
}
