package com.ss.android.socialbase.downloader.md5;

import java.io.IOException;

/* loaded from: classes7.dex */
public interface IRandomAccess {
    void close() throws IOException;

    long length() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;

    void seek(long j, long j2) throws IOException;
}
