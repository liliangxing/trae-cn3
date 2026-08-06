package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes7.dex */
public class ig extends ij {
    protected InputStream a;

    /* renamed from: a, reason: collision with other field name */
    protected OutputStream f894a;

    protected ig() {
        this.a = null;
        this.f894a = null;
    }

    public ig(OutputStream outputStream) {
        this.a = null;
        this.f894a = outputStream;
    }

    @Override // com.xiaomi.push.ij
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.a;
        if (inputStream == null) {
            throw new ik(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new ik(4);
        } catch (IOException e) {
            throw new ik(0, e);
        }
    }

    @Override // com.xiaomi.push.ij
    /* renamed from: a, reason: collision with other method in class */
    public void mo10100a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f894a;
        if (outputStream == null) {
            throw new ik(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new ik(0, e);
        }
    }
}
