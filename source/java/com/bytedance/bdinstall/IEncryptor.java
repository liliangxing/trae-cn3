package com.bytedance.bdinstall;

import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;

/* loaded from: classes3.dex */
public interface IEncryptor {
    byte[] encrypt(byte[] bArr, int i);

    /* loaded from: classes3.dex */
    public static class DefaultEncryptor implements IEncryptor {
        @Override // com.bytedance.bdinstall.IEncryptor
        public byte[] encrypt(byte[] bArr, int i) {
            try {
                return TTEncryptUtils.encrypt(bArr, i);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }
}
