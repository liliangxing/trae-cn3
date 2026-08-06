package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;

/* loaded from: classes6.dex */
public class f implements IDecrypt {
    private SecretKey a;
    private final d b;
    private boolean c = false;

    public f(d dVar) {
        this.b = dVar;
    }

    private void a() {
        try {
            this.a = j.a(this.b);
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.e("AGC_LocalResource", "Exception when reading the 'K&I' for 'Config'. error is " + e.getMessage());
            this.a = null;
        }
        this.c = true;
    }

    @Override // com.huawei.agconnect.config.IDecrypt
    public String decrypt(String str, String str2) {
        StringBuilder append;
        if (!this.c) {
            a();
        }
        if (this.a == null || TextUtils.isEmpty(str)) {
            append = new StringBuilder("decrypt exception: secretKey = ").append(this.a).append("raw = ");
        } else {
            try {
                return new String(j.a(this.a, Hex.decodeHexString(str)), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e) {
                append = new StringBuilder("decrypt exception:");
                str = e.getMessage();
            }
        }
        Log.e("AGC_LocalResource", append.append(str).toString());
        return str2;
    }
}
