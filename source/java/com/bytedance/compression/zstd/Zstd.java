package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class Zstd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long errGeneric();

    public static native long getErrorCode(long j);

    public static native String getErrorName(long j);

    public static native long[] getFunAddressesBySymbols(String[] strArr);

    public static native boolean isError(long j);

    static {
        Native.load();
    }

    public static long getFunAddressBySymbol(String str) {
        long[] funAddressesBySymbols = getFunAddressesBySymbols(new String[]{str});
        if (funAddressesBySymbols == null || funAddressesBySymbols.length != 1) {
            return 0L;
        }
        return funAddressesBySymbols[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] extractArray(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray() || byteBuffer.arrayOffset() != 0) {
            throw new IllegalArgumentException("provided ByteBuffer lacks array or has non-zero arrayOffset");
        }
        return byteBuffer.array();
    }
}
