package com.bytedance.crash.upload;

import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public class HttpOutputStream {
    private final CountableOutputStream mCountableOutputStream;
    private final boolean mGzip;
    private final OutputStream mImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpOutputStream(OutputStream outputStream, boolean z) throws IOException {
        CountableOutputStream countableOutputStream = new CountableOutputStream(outputStream);
        this.mCountableOutputStream = countableOutputStream;
        if (z) {
            this.mImpl = new ZipOutputStream(countableOutputStream);
        } else {
            this.mImpl = new WithoutCloseOutputStream(countableOutputStream);
        }
        this.mGzip = z;
    }

    public void write(byte[] bArr) throws IOException {
        this.mImpl.write(bArr);
    }

    public void write(String str) throws IOException {
        this.mImpl.write(str.getBytes());
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mImpl.write(bArr, i, i2);
    }

    public void close() throws IOException {
        if (this.mGzip) {
            ZipOutputStream zipOutputStream = (ZipOutputStream) this.mImpl;
            zipOutputStream.realFinish();
            zipOutputStream.realClose();
        } else {
            WithoutCloseOutputStream withoutCloseOutputStream = (WithoutCloseOutputStream) this.mImpl;
            withoutCloseOutputStream.flush();
            withoutCloseOutputStream.realClose();
        }
    }

    public long getCount() {
        return this.mCountableOutputStream.count();
    }

    public void writeZipFiles(List<File> list) throws IOException {
        FileUtils.zip(this.mImpl, list);
    }

    /* loaded from: classes3.dex */
    static class CountableOutputStream extends FilterOutputStream {
        private long mCount;

        public CountableOutputStream(OutputStream outputStream) {
            super(outputStream);
            this.mCount = 0L;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            this.mCount++;
            this.out.write(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mCount += i2;
            this.out.write(bArr, i, i2);
        }

        long count() {
            return this.mCount;
        }
    }

    /* loaded from: classes3.dex */
    static class ZipOutputStream extends GZIPOutputStream {
        @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
        public void finish() {
        }

        public ZipOutputStream(OutputStream outputStream) throws IOException {
            super(outputStream);
        }

        public void realClose() throws IOException {
            super.close();
        }

        public void realFinish() throws IOException {
            super.finish();
        }
    }

    /* loaded from: classes3.dex */
    static class WithoutCloseOutputStream extends DataOutputStream {
        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public WithoutCloseOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public void realClose() throws IOException {
            super.close();
        }
    }

    static byte[] wrapDeflateData(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    static byte[] wrapGzipData(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                NpthLog.w(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    FileSystemUtils.close(byteArrayOutputStream);
                }
            }
        }
    }
}
