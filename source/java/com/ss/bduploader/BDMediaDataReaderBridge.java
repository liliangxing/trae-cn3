package com.ss.bduploader;

import android.util.Log;

/* loaded from: classes7.dex */
public class BDMediaDataReaderBridge {
    int open(Object obj, int i) {
        if (obj == null) {
            Log.e("ttmn", "try to open failed");
            return 0;
        }
        return ((BDMediaDataReader) obj).open(i);
    }

    int read(Object obj, int i, long j, byte[] bArr, int i2) {
        if (obj == null || bArr == null || i2 == 0) {
            Log.e("ttmn", "try to read end fail");
            return 0;
        }
        return ((BDMediaDataReader) obj).read(i, j, bArr, i2);
    }

    int close(Object obj, int i) {
        if (obj == null || i < 0) {
            Log.e("ttmn", "try to close fail");
            return 0;
        }
        return ((BDMediaDataReader) obj).close(i);
    }

    long getValue(Object obj, int i, int i2) {
        if (obj == null) {
            Log.e("ttmn", "try to get value fail");
            return -1L;
        }
        return ((BDMediaDataReader) obj).getValue(i, i2);
    }
}
