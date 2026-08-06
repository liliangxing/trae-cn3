package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.hihonor.push.sdk.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0916d {

    /* renamed from: a */
    public static volatile C0930h1 f694a;

    /* renamed from: b */
    public static final C0916d f695b = new C0916d();

    /* renamed from: a */
    public final void m759a(Context context) {
        if (f694a == null) {
            f694a = new C0930h1(context, "push");
        }
    }

    /* renamed from: b */
    public synchronized String m761b(Context context) {
        String str;
        m759a(context);
        str = "";
        SharedPreferences sharedPreferences = f694a.f725a;
        boolean z = true;
        if (sharedPreferences != null && sharedPreferences.contains("key_push_token")) {
            SharedPreferences sharedPreferences2 = f694a.f725a;
            if (sharedPreferences2 == null || !sharedPreferences2.contains("key_aes_gcm")) {
                z = false;
            }
            if (z) {
                SharedPreferences sharedPreferences3 = f694a.f725a;
                String string = sharedPreferences3 != null ? sharedPreferences3.getString("key_push_token", "") : "";
                SharedPreferences sharedPreferences4 = f694a.f725a;
                byte[] decode = Base64.decode(sharedPreferences4 != null ? sharedPreferences4.getString("key_aes_gcm", "") : "", 0);
                String str2 = "";
                if (!TextUtils.isEmpty(string) && decode != null && decode.length >= 16) {
                    try {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        String substring = string.substring(0, 24);
                        String substring2 = string.substring(24);
                        if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2)) {
                            cipher.init(2, secretKeySpec, new GCMParameterSpec(128, C0909b.m748a(substring)));
                            str2 = new String(cipher.doFinal(C0909b.m748a(substring2)), StandardCharsets.UTF_8);
                        }
                    } catch (Exception e) {
                        String str3 = "GCM decrypt data exception: " + e.getMessage();
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    f694a.m768a("key_aes_gcm");
                    f694a.m768a("key_push_token");
                } else {
                    str = str2;
                }
            } else {
                f694a.m768a("key_push_token");
            }
        }
        return str;
    }

    /* renamed from: a */
    public synchronized void m760a(Context context, String str) {
        byte[] bArr;
        byte[] bArr2;
        m759a(context);
        if (TextUtils.isEmpty(str)) {
            f694a.m768a("key_push_token");
        } else {
            String m744a = C0909b.m744a(context, context.getPackageName());
            byte[] m748a = C0909b.m748a("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22");
            byte[] m748a2 = C0909b.m748a(m744a);
            try {
                bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
            } catch (Exception unused) {
                bArr = new byte[0];
            }
            String encodeToString = Base64.encodeToString(C0909b.m750a(C0909b.m749a(C0909b.m750a(C0909b.m749a(m748a, -4), m748a2), 6), bArr), 0);
            boolean m769a = f694a.m769a("key_aes_gcm", encodeToString);
            byte[] decode = Base64.decode(encodeToString, 0);
            String str2 = "";
            if (!TextUtils.isEmpty(str) && decode != null && decode.length >= 16) {
                try {
                    try {
                        bArr2 = new byte[12];
                        new SecureRandom().nextBytes(bArr2);
                    } catch (Exception unused2) {
                        bArr2 = new byte[0];
                    }
                    byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr2));
                    byte[] doFinal = cipher.doFinal(bytes);
                    if (doFinal != null && doFinal.length != 0) {
                        str2 = C0909b.m745a(bArr2) + C0909b.m745a(doFinal);
                    }
                } catch (GeneralSecurityException e) {
                    String str3 = "GCM encrypt data error" + e.getMessage();
                }
            }
            if (m769a && !TextUtils.isEmpty(str2)) {
                f694a.m769a("key_push_token", str2);
            }
        }
    }
}
