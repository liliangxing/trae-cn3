package com.ss.bduploader;

import android.util.Log;

/* loaded from: classes7.dex */
public class BDExternalFileReaderBridge {
    private static final String TAG = "ttmn";

    int readSlice(Object obj, int i, byte[] bArr, int i2) {
        Log.e(TAG, "try to read end");
        if (obj == null || bArr == null || i2 == 0) {
            Log.e(TAG, "try to read end fail");
            return 0;
        }
        int readSlice = ((BDExternalFileReader) obj).readSlice(i, bArr, i2);
        Log.e(TAG, "try to read end");
        return readSlice;
    }

    int readSliceByOffset(Object obj, long j, byte[] bArr, int i, int i2) {
        Log.e(TAG, "try to read end");
        if (obj == null || bArr == null || i == 0) {
            Log.e(TAG, "try to read end fail");
            return 0;
        }
        int readSliceByOffset = ((BDExternalFileReader) obj).readSliceByOffset(j, bArr, i, i2);
        Log.e(TAG, "try to read end");
        return readSliceByOffset;
    }

    int multiReadSliceByOffset(Object obj, long j, byte[] bArr, int i, int i2, int i3) {
        Log.e(TAG, "try to read end");
        if (obj == null || bArr == null || i2 == 0 || i < 0) {
            Log.e(TAG, "try to read end fail");
            return 0;
        }
        int readSliceByOffset = ((BDMultiExternalFileReader) obj).readSliceByOffset(j, bArr, i, i2, i3);
        Log.e(TAG, "try to read end");
        return readSliceByOffset;
    }

    long getCrc32ByOffset(Object obj, long j, int i) {
        Log.e(TAG, "try to read end");
        if (obj == null) {
            Log.e(TAG, "try to read end fail");
            return 0L;
        }
        long crc32ByOffset = ((BDExternalFileReader) obj).getCrc32ByOffset(j, i);
        Log.e(TAG, "try to read end");
        return crc32ByOffset;
    }

    long getValue(Object obj, int i) {
        Log.e(TAG, "try to get value");
        if (obj == null) {
            Log.e(TAG, "try to get value fail");
            return -1L;
        }
        long value = ((BDExternalFileReader) obj).getValue(i);
        Log.e(TAG, "try to get value end");
        return value;
    }

    long multiGetValue(Object obj, int i, int i2) {
        Log.e(TAG, "try to get value");
        if (obj == null) {
            Log.e(TAG, "try to get value fail");
            return -1L;
        }
        long multiGetValue = ((BDMultiExternalFileReader) obj).multiGetValue(i, i2);
        Log.e(TAG, "try to get value end");
        return multiGetValue;
    }

    void cancel(Object obj) {
        Log.e(TAG, "try to cancel");
        if (obj == null) {
            Log.e(TAG, "try to cancel end fail");
        } else {
            ((BDExternalFileReader) obj).cancel();
            Log.e(TAG, "try to cancel end");
        }
    }

    int openFileWithIndex(Object obj, int i) {
        Log.e(TAG, "try to openFile");
        if (obj == null) {
            Log.e(TAG, "try to openFile end fail");
            return -1;
        }
        Log.e(TAG, "try to openFile end");
        return ((BDMultiExternalFileReader) obj).openFileWithIndex(i);
    }

    void closeFileWithIndex(Object obj, int i) {
        Log.e(TAG, "try to closeFile");
        if (obj == null) {
            Log.e(TAG, "try to closeFile end fail");
        } else {
            Log.e(TAG, "try to closeFile end");
            ((BDMultiExternalFileReader) obj).closeFileWithIndex(i);
        }
    }
}
