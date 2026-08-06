package com.lynx.tasm;

import com.lynx.tasm.common.LepusBuffer;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public abstract class PlatformCallBack {
    public static final double InvalidId = -1.0d;

    public abstract void onSuccess(Object obj);

    private void onDataBack(ByteBuffer byteBuffer) {
        onSuccess(LepusBuffer.INSTANCE.decodeMessage(byteBuffer));
    }
}
