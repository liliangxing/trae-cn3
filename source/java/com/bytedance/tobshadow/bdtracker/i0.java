package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.tobshadow.mpaas.IEncryptor;

/* loaded from: classes5.dex */
public class i0 implements IEncryptorType, IEncryptor {
    public final IEncryptor a;
    public final String b;

    public i0(IEncryptor iEncryptor, String str) {
        this.a = iEncryptor;
        this.b = str;
    }

    @Override // com.bytedance.tobshadow.mpaas.IEncryptor
    public byte[] encrypt(byte[] bArr, int i) {
        IEncryptor iEncryptor = this.a;
        return iEncryptor == null ? bArr : iEncryptor.encrypt(bArr, i);
    }

    @Override // com.bytedance.tobshadow.applog.encryptor.IEncryptorType
    public String encryptorType() {
        return TextUtils.isEmpty(this.b) ? IEncryptorType.DEFAULT_ENCRYPTOR : this.b;
    }
}
