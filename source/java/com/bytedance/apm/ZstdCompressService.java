package com.bytedance.apm;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ZstdCompressService implements IZstdCompress {
    private ZstdDictCompress cacheCompressDict;
    private byte[] lastDict;
    private int lastLevel;
    private IZstdDict lastZstdDict;

    @Override // com.bytedance.services.apm.api.IZstdCompress
    public byte[] compress(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 == null) {
            return null;
        }
        if (this.cacheCompressDict == null || !Arrays.equals(bArr2, this.lastDict) || i != this.lastLevel) {
            this.cacheCompressDict = new ZstdDictCompress(bArr2, i);
            this.lastDict = bArr2;
            this.lastLevel = i;
        }
        return ZstdCompress.compress(bArr, this.cacheCompressDict);
    }

    @Override // com.bytedance.services.apm.api.IZstdCompress
    public byte[] compress(byte[] bArr, int i) {
        return ZstdCompress.compress(bArr, i);
    }
}
