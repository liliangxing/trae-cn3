package com.bytedance.rts.foundation;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArrayBuffer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J#\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/rts/foundation/ArrayBuffer;", "", "byteLength", "", "(I)V", "arrayBuffer", "offset", "(Lcom/bytedance/rts/foundation/ArrayBuffer;II)V", "buffer", "Ljava/nio/ByteBuffer;", "getBuffer$lib_release", "()Ljava/nio/ByteBuffer;", "getByteLength", "()I", "slice", "begin", "end", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/rts/foundation/ArrayBuffer;", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ArrayBuffer {
    private final ByteBuffer buffer;
    private final int byteLength;

    /* renamed from: getBuffer$lib_release, reason: from getter */
    public final ByteBuffer getBuffer() {
        return this.buffer;
    }

    public final int getByteLength() {
        return this.byteLength;
    }

    public ArrayBuffer(int i) {
        this.byteLength = i;
        ByteBuffer allocate = ByteBuffer.allocate(i);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(byteLength)");
        this.buffer = allocate;
    }

    public ArrayBuffer(ArrayBuffer arrayBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(arrayBuffer, "arrayBuffer");
        ByteBuffer sliceBuffer = ArrayBufferKt.sliceBuffer(arrayBuffer.buffer, i, i2);
        this.buffer = sliceBuffer;
        this.byteLength = sliceBuffer.capacity();
    }

    public static /* synthetic */ ArrayBuffer slice$default(ArrayBuffer arrayBuffer, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return arrayBuffer.slice(num, num2);
    }

    public final ArrayBuffer slice(Integer begin, Integer end) {
        int i = 0;
        int intValue = begin != null ? begin.intValue() : 0;
        int i2 = this.byteLength;
        if (intValue < (-i2)) {
            intValue = 0;
        } else if (intValue < 0) {
            intValue += i2;
        } else if (intValue >= i2) {
            return new ArrayBuffer(0);
        }
        if (end != null) {
            i2 = end.intValue();
        }
        int i3 = this.byteLength;
        if (i2 < (-i3)) {
            i2 = 0;
        } else if (i2 < 0) {
            i2 += i3;
        } else if (i2 > i3) {
            i2 = i3;
        }
        if (intValue >= i2) {
            return new ArrayBuffer(0);
        }
        int i4 = i2 - intValue;
        ArrayBuffer arrayBuffer = new ArrayBuffer(i4);
        if (i4 >= 0) {
            while (true) {
                arrayBuffer.buffer.put(this.buffer.get(i));
                if (i == i4) {
                    break;
                }
                i++;
            }
        }
        return arrayBuffer;
    }
}
