package com.bytedance.gkfs.io.segmental;

import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SegmentalByteArrayInputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\"\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/gkfs/io/segmental/SegmentalByteArrayInputStream;", "Ljava/io/InputStream;", "buf", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "(Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;)V", "pos", "", "available", SettingV2Monitor.REPORT_TYPE_READ, "b", "", "off", "len", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class SegmentalByteArrayInputStream extends InputStream {
    private final SegmentalByteArray buf;
    private int pos;

    public SegmentalByteArrayInputStream(SegmentalByteArray buf) {
        Intrinsics.checkParameterIsNotNull(buf, "buf");
        this.buf = buf;
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        int i;
        if (this.pos < this.buf.getSize()) {
            SegmentalByteArray segmentalByteArray = this.buf;
            int i2 = this.pos;
            this.pos = i2 + 1;
            i = segmentalByteArray.get(i2) & UByte.MAX_VALUE;
        } else {
            i = -1;
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b, int off, int len) {
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
        SegmentalByteArray segmentalByteArray = this.buf;
        int i = this.pos;
        segmentalByteArray.copyInto(b, off, i, i + min);
        this.pos += min;
        return min;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.buf.getSize() - this.pos;
    }
}
