package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* renamed from: com.huawei.agconnect.config.impl.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0980f implements IDecrypt {

    /* renamed from: a */
    private SecretKey f841a;

    /* renamed from: b */
    private final C0978d f842b;

    /* renamed from: c */
    private boolean f843c = false;

    public C0980f(C0978d c0978d) {
        this.f842b = c0978d;
    }

    /* renamed from: a */
    private void m811a() {
        try {
            this.f841a = C0984j.m816a(this.f842b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.e("AGC_LocalResource", "Exception when reading the 'K&I' for 'Config'. error is " + e.getMessage());
            this.f841a = null;
        }
        this.f843c = true;
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        StringBuilder append;
        if (!this.f843c) {
            m811a();
        }
        if (this.f841a == null || TextUtils.isEmpty(str)) {
            append = new StringBuilder("decrypt exception: secretKey = ").append(this.f841a).append("raw = ");
        } else {
            try {
                return new String(C0984j.m817a(this.f841a, Hex.decodeHexString(str)), Utf8Charset.NAME);
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e) {
                append = new StringBuilder("decrypt exception:");
                str = e.getMessage();
            }
        }
        Log.e("AGC_LocalResource", append.append(str).toString());
        return str2;
    }
}
