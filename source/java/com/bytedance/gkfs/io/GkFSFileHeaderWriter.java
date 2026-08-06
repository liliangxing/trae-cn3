package com.bytedance.gkfs.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta_io.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¨\u0006\f"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFileHeaderWriter;", "", "()V", "write", "", "outputStream", "Ljava/io/OutputStream;", "originSize", "", "chunks", "", "Lcom/bytedance/gkfs/io/GkFSChunkMeta;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSFileHeaderWriter {
    public static final GkFSFileHeaderWriter INSTANCE = new GkFSFileHeaderWriter();

    private GkFSFileHeaderWriter() {
    }

    public final void write(OutputStream outputStream, long originSize, List<GkFSChunkMeta> chunks) throws IOException {
        char[] cArr;
        Intrinsics.checkParameterIsNotNull(outputStream, "outputStream");
        Intrinsics.checkParameterIsNotNull(chunks, "chunks");
        cArr = Meta_ioKt.MAGIC_NUMBER;
        Iterator it = ArrayIteratorsKt.iterator(cArr);
        while (it.hasNext()) {
            Meta_ioKt.writeChar(outputStream, ((Character) it.next()).charValue());
        }
        Meta_ioKt.writeUChar(outputStream, 1);
        Meta_ioKt.writeULong(outputStream, originSize);
        Meta_ioKt.writeUShort(outputStream, chunks.size());
        for (GkFSChunkMeta gkFSChunkMeta : chunks) {
            Meta_ioKt.writeChunkId(outputStream, gkFSChunkMeta.getId());
            Meta_ioKt.writeUInt(outputStream, (int) gkFSChunkMeta.getOffset());
        }
    }
}
