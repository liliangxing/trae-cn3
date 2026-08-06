package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.tobshadow.mpaas.IEncryptor;

/* renamed from: com.bytedance.tobshadow.bdtracker.i0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0440i0 implements IEncryptorType, IEncryptor {

    /* renamed from: a */
    public final IEncryptor f658a;

    /* renamed from: b */
    public final String f659b;

    public C0440i0(IEncryptor iEncryptor, String str) {
        this.f658a = iEncryptor;
        this.f659b = str;
    }

    @Override // com.bytedance.tobshadow.mpaas.IEncryptor
    public byte[] encrypt(byte[] bArr, int i) {
        IEncryptor iEncryptor = this.f658a;
        return iEncryptor == null ? bArr : iEncryptor.encrypt(bArr, i);
    }

    @Override // com.bytedance.tobshadow.applog.encryptor.IEncryptorType
    public String encryptorType() {
        return TextUtils.isEmpty(this.f659b) ? IEncryptorType.DEFAULT_ENCRYPTOR : this.f659b;
    }
}
