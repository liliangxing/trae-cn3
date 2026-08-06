package com.bytedance.push.utils;

import android.util.Log;
import com.bytedance.security.Sword.Sword;

/* loaded from: classes4.dex */
public class EncryptUtils {
    public static byte[] decrypt(byte[] bArr) {
        return decrypt(bArr, 0);
    }

    public static byte[] decrypt(byte[] bArr, int i) {
        if (bArr != null && bArr.length != 0) {
            try {
                return Sword.clientUnpackedBase64(new String(bArr, i, bArr.length - i));
            } catch (Throwable th) {
                Logger.e("decrypt error:" + Log.getStackTraceString(th));
            }
        }
        return null;
    }
}
