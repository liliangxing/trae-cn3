package com.bytedance.lynx.service.security;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxSecurityPayloadBufferHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityPayloadBufferHelper;", "", "()V", "createLengthPrefixedBuffer", "Ljava/nio/ByteBuffer;", "buffers", "", "([Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxSecurityPayloadBufferHelper {
    public static final LynxSecurityPayloadBufferHelper INSTANCE = new LynxSecurityPayloadBufferHelper();

    private LynxSecurityPayloadBufferHelper() {
    }

    public final ByteBuffer createLengthPrefixedBuffer(ByteBuffer... buffers) {
        Intrinsics.checkNotNullParameter(buffers, "buffers");
        int i = 0;
        for (ByteBuffer byteBuffer : buffers) {
            i += byteBuffer.remaining();
        }
        int i2 = 4 + i;
        ByteBuffer order = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        order.putInt(i2);
        for (ByteBuffer byteBuffer2 : buffers) {
            order.put(byteBuffer2.duplicate().slice());
        }
        order.flip();
        Intrinsics.checkNotNullExpressionValue(order, "allocateDirect(totalLeng…     flip()\n            }");
        return order;
    }
}
