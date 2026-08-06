package com.bytedance.crash.util;

import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;

/* loaded from: classes3.dex */
public class EncryptUtils {
    public static byte[] encrypt(byte[] bArr) {
        return TTEncryptUtils.encrypt(bArr, bArr.length);
    }
}
