package com.ss.android.socialbase.downloader.utils;

import com.ss.android.socialbase.downloader.md5.IRandomAccess;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadFileRandomAccess implements IRandomAccess {
    private static final int BUFFER_SIZE = 8192;
    private final FileChannel accessFile;
    private final ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
    private final FileInputStream inputStream;

    public DownloadFileRandomAccess(FileInputStream fileInputStream) throws FileNotFoundException {
        this.inputStream = fileInputStream;
        this.accessFile = fileInputStream.getChannel();
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public long length() throws IOException {
        return this.accessFile.size();
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.accessFile.read(this.byteBuffer);
        if (read != -1) {
            this.byteBuffer.flip();
            this.byteBuffer.get(bArr, 0, read);
            this.byteBuffer.clear();
        }
        return read;
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public void seek(long j, long j2) throws IOException {
        this.accessFile.position(j);
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public void close() throws IOException {
        DownloadUtils.safeClose(this.accessFile, this.inputStream);
    }
}
