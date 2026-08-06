package com.bytedance.gkfs.io.segmental;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SegmentalByteArray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0001\u001a\u0012\u0010\n\u001a\u00020\b*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"SEGMENT_SIZE", "", "TAG", "", "copyTo", "", "Ljava/io/InputStream;", "out", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "bufferSize", "readBytesSegmental", "size", "write", "", "Ljava/io/OutputStream;", "content", "geckox_noasanRelease"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class SegmentalByteArrayKt {
    private static final int SEGMENT_SIZE = 4096;
    private static final String TAG = "SegmentalByteArray";

    public static /* synthetic */ long copyTo$default(InputStream inputStream, SegmentalByteArray segmentalByteArray, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(inputStream, segmentalByteArray, i);
    }

    public static final long copyTo(InputStream copyTo, SegmentalByteArray out, int i) {
        Intrinsics.checkParameterIsNotNull(copyTo, "$this$copyTo");
        Intrinsics.checkParameterIsNotNull(out, "out");
        byte[] bArr = new byte[i];
        int read = copyTo.read(bArr);
        long j = 0;
        while (read >= 0) {
            out.copyFrom(bArr, 0, (int) j, read);
            j += read;
            read = copyTo.read(bArr);
        }
        return j;
    }

    public static final SegmentalByteArray readBytesSegmental(InputStream readBytesSegmental, int i) {
        Intrinsics.checkParameterIsNotNull(readBytesSegmental, "$this$readBytesSegmental");
        SegmentalByteArray segmentalByteArray = new SegmentalByteArray(i);
        copyTo$default(readBytesSegmental, segmentalByteArray, 0, 2, null);
        return segmentalByteArray;
    }

    public static final void write(OutputStream write, SegmentalByteArray content) throws IOException {
        Intrinsics.checkParameterIsNotNull(write, "$this$write");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Iterator<byte[]> it = content.iterator();
        while (it.hasNext()) {
            write.write(it.next());
        }
    }
}
