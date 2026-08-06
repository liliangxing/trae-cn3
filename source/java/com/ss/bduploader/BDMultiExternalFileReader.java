package com.ss.bduploader;

/* loaded from: classes7.dex */
public interface BDMultiExternalFileReader {
    void closeFileWithIndex(int i);

    long multiGetValue(int i, int i2);

    int openFileWithIndex(int i);

    int readSliceByOffset(long j, byte[] bArr, int i, int i2, int i3);
}
