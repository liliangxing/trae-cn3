package com.bytedance.gkfs.storage.io;

import com.bytedance.gkfs.storage.ChunkBlockIndexingInfo;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CombinedChunkInputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/gkfs/storage/io/CombinedChunkInputStream;", "Ljava/io/InputStream;", "indexingInfo", "Lcom/bytedance/gkfs/storage/ChunkBlockIndexingInfo;", "buffer", "Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;", "(Lcom/bytedance/gkfs/storage/ChunkBlockIndexingInfo;Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;)V", "pos", "", "available", "", "read", "b", "", "off", "len", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CombinedChunkInputStream extends InputStream {
    private final GkFSBlockBuffer buffer;
    private final ChunkBlockIndexingInfo indexingInfo;
    private long pos;

    public CombinedChunkInputStream(ChunkBlockIndexingInfo chunkBlockIndexingInfo, GkFSBlockBuffer gkFSBlockBuffer) {
        Intrinsics.checkParameterIsNotNull(chunkBlockIndexingInfo, "indexingInfo");
        Intrinsics.checkParameterIsNotNull(gkFSBlockBuffer, "buffer");
        this.indexingInfo = chunkBlockIndexingInfo;
        this.buffer = gkFSBlockBuffer;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        Integer valueOf = Integer.valueOf(read(bArr, 0, 1));
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return -1;
        }
        valueOf.intValue();
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) {
        if (b == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || len > b.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        int min = Math.min(len, available);
        this.buffer.read(this.pos + this.indexingInfo.getOffset(), b, off, min);
        this.pos += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() {
        return (int) (this.indexingInfo.getSize() - this.pos);
    }
}
