package org.bouncycastle.est;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class CTEBase64InputStream extends InputStream {
    protected boolean end;
    protected final Long max;
    protected long read;
    protected int rp;
    protected final InputStream src;
    protected int wp;
    protected final byte[] rawBuf = new byte[1024];
    protected final byte[] data = new byte[768];
    protected final OutputStream dataOutputStream = new OutputStream() { // from class: org.bouncycastle.est.CTEBase64InputStream.1
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            byte[] bArr = CTEBase64InputStream.this.data;
            CTEBase64InputStream cTEBase64InputStream = CTEBase64InputStream.this;
            int i2 = cTEBase64InputStream.wp;
            cTEBase64InputStream.wp = i2 + 1;
            bArr[i2] = (byte) i;
        }
    };

    public CTEBase64InputStream(InputStream inputStream, Long l) {
        this.src = inputStream;
        this.max = l;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.src.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        org.bouncycastle.util.encoders.Base64.decode(r11.rawBuf, 0, r2, r11.dataOutputStream);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        throw new java.io.IOException("Decode Base64 Content-Transfer-Encoding: " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int pullFromSrc() throws IOException {
        int read;
        if (this.read >= this.max.longValue()) {
            return -1;
        }
        int i = 0;
        do {
            read = this.src.read();
            if (read >= 33 || read == 13 || read == 10) {
                byte[] bArr = this.rawBuf;
                if (i >= bArr.length) {
                    throw new IOException("Content Transfer Encoding, base64 line length > 1024");
                }
                bArr[i] = (byte) read;
                this.read++;
                i++;
            } else if (read >= 0) {
                this.read++;
            }
            if (read <= -1 || i >= this.rawBuf.length || read == 10) {
                break;
            }
        } while (this.read < this.max.longValue());
        if (read == -1) {
            return -1;
        }
        return this.wp;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.rp == this.wp) {
            this.rp = 0;
            this.wp = 0;
            int pullFromSrc = pullFromSrc();
            if (pullFromSrc == -1) {
                return pullFromSrc;
            }
        }
        byte[] bArr = this.data;
        int i = this.rp;
        this.rp = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }
}
