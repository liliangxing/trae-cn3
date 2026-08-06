package com.bytedance.gkfs.storage.io;

import com.bytedance.bdturing.EventReport;
import com.bytedance.gkfs.GkFSLogger;
import com.bytedance.gkfs.io.segmental.SegmentalByteArray;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CombinedChunkOutputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\"\u0010\r\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/gkfs/storage/io/CombinedChunkOutputStream;", "Ljava/io/OutputStream;", "writeSize", "", "buffer", "Lcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;", "(ILcom/bytedance/gkfs/storage/io/GkFSBlockBuffer;)V", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "totalWriteSize", EventReport.DIALOG_CLOSE, "", "flush", "write", "content", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "write$geckox_noasanRelease", "b", "", "off", "len", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CombinedChunkOutputStream extends OutputStream {
    private final GkFSBlockBuffer buffer;
    private final GkFSLogger logger;
    private int totalWriteSize;
    private final int writeSize;

    public CombinedChunkOutputStream(int i, GkFSBlockBuffer gkFSBlockBuffer) {
        Intrinsics.checkParameterIsNotNull(gkFSBlockBuffer, "buffer");
        this.writeSize = i;
        this.buffer = gkFSBlockBuffer;
        this.logger = new GkFSLogger();
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        write(new byte[b]);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) {
        int i;
        if (b == null) {
            throw new NullPointerException();
        }
        if (off < 0 || off > b.length || len < 0 || (i = off + len) > b.length || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        if (this.totalWriteSize >= this.writeSize) {
            throw new IOException("Already write " + this.totalWriteSize);
        }
        this.buffer.write(b, off, len);
        this.totalWriteSize += len;
    }

    public final void write$geckox_noasanRelease(SegmentalByteArray content) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        this.buffer.prepareToWrite(content.getSize());
        Iterator<byte[]> it = content.iterator();
        while (it.hasNext()) {
            write(it.next());
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        GkFSLogger.d$default(this.logger, "CombinedChunkOutputStream", "Stream closed, totalWriteSize=" + this.totalWriteSize, 0, false, 12, null);
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.buffer.flush();
    }
}
