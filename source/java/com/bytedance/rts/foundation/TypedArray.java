package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypedArray.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B'\b\u0014\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/rts/foundation/TypedArray;", "", "length", "", "bytesPerElem", "(II)V", "arrayBuffer", "Lcom/bytedance/rts/foundation/ArrayBuffer;", "offset", "(Lcom/bytedance/rts/foundation/ArrayBuffer;III)V", "buffer", "getBuffer", "()Lcom/bytedance/rts/foundation/ArrayBuffer;", "byteLength", "getByteLength", "()I", "byteOffset", "getByteOffset", "getLength", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class TypedArray {
    private final ArrayBuffer buffer;
    private final int byteOffset;
    private final int bytesPerElem;
    private final int length;

    public final int getLength() {
        return this.length;
    }

    public final ArrayBuffer getBuffer() {
        return this.buffer;
    }

    public final int getByteLength() {
        return this.length * this.bytesPerElem;
    }

    public final int getByteOffset() {
        return this.byteOffset;
    }

    public TypedArray(int i, int i2) {
        this.length = i;
        this.bytesPerElem = i2;
        this.buffer = new ArrayBuffer(i * i2);
        this.byteOffset = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TypedArray(ArrayBuffer arrayBuffer, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(arrayBuffer, "arrayBuffer");
        this.length = i3;
        this.bytesPerElem = i;
        this.buffer = new ArrayBuffer(arrayBuffer, i2, i3 * i);
        this.byteOffset = i2;
    }
}
