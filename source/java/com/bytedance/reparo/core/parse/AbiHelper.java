package com.bytedance.reparo.core.parse;

/* loaded from: classes4.dex */
public interface AbiHelper {
    public static final int ABI_BITS_32 = 1;
    public static final int ABI_BITS_32_64 = 3;
    public static final int ABI_BITS_64 = 2;
    public static final int ABI_BITS_ERROR = -1;
    public static final int ABI_BITS_NULL = 0;

    String getHostAbi();

    int getHostApkAbiBits();
}
