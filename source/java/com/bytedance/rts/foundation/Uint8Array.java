package com.bytedance.rts.foundation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypedArray.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/rts/foundation/Uint8Array;", "Lcom/bytedance/rts/foundation/TypedArray;", "length", "", "(I)V", "buffer", "Lcom/bytedance/rts/foundation/ArrayBuffer;", "byteOffset", "(Lcom/bytedance/rts/foundation/ArrayBuffer;II)V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class Uint8Array extends TypedArray {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int BYTES_PER_ELEMENT = 1;

    public Uint8Array(int i) {
        super(i, 1);
    }

    /* compiled from: TypedArray.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/rts/foundation/Uint8Array$Companion;", "", "()V", "BYTES_PER_ELEMENT", "", "getBYTES_PER_ELEMENT", "()I", "create", "Lcom/bytedance/rts/foundation/Uint8Array;", "buffer", "Lcom/bytedance/rts/foundation/ArrayBuffer;", "byteOffset", "length", "(Lcom/bytedance/rts/foundation/ArrayBuffer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/rts/foundation/Uint8Array;", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getBYTES_PER_ELEMENT() {
            return Uint8Array.BYTES_PER_ELEMENT;
        }

        public static /* synthetic */ Uint8Array create$default(Companion companion, ArrayBuffer arrayBuffer, Integer num, Integer num2, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                num2 = null;
            }
            return companion.create(arrayBuffer, num, num2);
        }

        public final Uint8Array create(ArrayBuffer buffer, Integer byteOffset, Integer length) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            int intValue = byteOffset != null ? byteOffset.intValue() : 0;
            return new Uint8Array(buffer, intValue, length != null ? length.intValue() : (buffer.getByteLength() - intValue) / getBYTES_PER_ELEMENT());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8Array(ArrayBuffer buffer, int i, int i2) {
        super(buffer, BYTES_PER_ELEMENT, i, i2);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }
}
