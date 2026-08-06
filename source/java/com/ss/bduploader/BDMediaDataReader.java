package com.ss.bduploader;

/* loaded from: classes7.dex */
public interface BDMediaDataReader {
    public static final int KeyIsGetFileCrc32 = 1;
    public static final int KeyIsGetFileSize = 0;
    public static final int ReadFileEnd = 0;
    public static final int ReadFileError = -1;

    int close(int i);

    long getValue(int i, int i2);

    int open(int i);

    int read(int i, long j, byte[] bArr, int i2);
}
