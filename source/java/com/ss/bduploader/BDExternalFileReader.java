package com.ss.bduploader;

/* loaded from: classes7.dex */
public interface BDExternalFileReader {
    public static final int KeyIsGetAvailableFileSize = 4;
    public static final int KeyIsGetFileSize = 0;
    public static final int KeyIsGetHeaderSize = 2;
    public static final int KeyIsGetOffset = 1;
    public static final int ReadSliceEnd = 0;
    public static final int ReadSliceError = -1;
    public static final int ReadSliceErrorIsCancel = -2;

    void cancel();

    long getCrc32ByOffset(long j, int i);

    long getValue(int i);

    int readSlice(int i, byte[] bArr, int i2);

    int readSliceByOffset(long j, byte[] bArr, int i, int i2);
}
