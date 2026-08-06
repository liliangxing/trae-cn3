package com.vivo.push.util;

import org.bouncycastle.math.ec.Tnaf;

/* compiled from: CryptographicTool.java */
/* loaded from: classes7.dex */
public final class j {
    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (bArr[i] ^ Tnaf.POW_2_WIDTH);
        }
        return new String(cArr);
    }
}
