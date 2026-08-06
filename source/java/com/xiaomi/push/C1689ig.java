package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.xiaomi.push.ig */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1689ig extends AbstractC1692ij {

    /* renamed from: a */
    protected InputStream f2798a;

    /* renamed from: a */
    protected OutputStream f2799a;

    protected C1689ig() {
        this.f2798a = null;
        this.f2799a = null;
    }

    public C1689ig(OutputStream outputStream) {
        this.f2798a = null;
        this.f2799a = outputStream;
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a */
    public int mo3408a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f2798a;
        if (inputStream == null) {
            throw new C1693ik(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new C1693ik(4);
        } catch (IOException e) {
            throw new C1693ik(0, e);
        }
    }

    @Override // com.xiaomi.push.AbstractC1692ij
    /* renamed from: a */
    public void mo3409a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f2799a;
        if (outputStream == null) {
            throw new C1693ik(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new C1693ik(0, e);
        }
    }
}
