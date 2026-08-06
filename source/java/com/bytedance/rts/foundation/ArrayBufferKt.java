package com.bytedance.rts.foundation;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArrayBuffer.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¨\u0006\u0006"}, d2 = {"sliceBuffer", "Ljava/nio/ByteBuffer;", "buffer", "start", "", "length", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ArrayBufferKt {
    public static final ByteBuffer sliceBuffer(ByteBuffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int position = buffer.position();
        int limit = buffer.limit();
        buffer.position(i);
        buffer.limit(i + i2);
        ByteBuffer res = buffer.slice();
        buffer.position(position);
        buffer.limit(limit);
        Intrinsics.checkNotNullExpressionValue(res, "res");
        return res;
    }
}
