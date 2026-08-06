package com.bytedance.realx.video.memory;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public interface RXVideoByteMemoryInterface extends RXVideoMemoryInterface {
    int getNumberOfPlanes();

    ByteBuffer getPlaneData(int plane);

    int getPlaneLineSize(int plane);
}
