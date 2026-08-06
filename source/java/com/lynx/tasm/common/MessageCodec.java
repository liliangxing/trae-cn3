package com.lynx.tasm.common;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface MessageCodec {
    Object decodeMessage(ByteBuffer byteBuffer);

    ByteBuffer encodeMessage(Object obj);
}
