package com.bytedance.apm6.java_alloc;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class Trace {
    byte[] buffer = new byte[4096];
    byte[] buffer2 = new byte[4096];
    int position;
    ByteBuffer stream;

    public void onTrace(ITraceReader iTraceReader) {
        if (iTraceReader == null) {
            return;
        }
        int traceLength = getTraceLength();
        for (int i = 0; i < traceLength; i++) {
            if (!iTraceReader.onItem(this.buffer, JavaAllocCollector.fillStringBytes(this.stream, this.buffer), this.buffer2, JavaAllocCollector.fillStringBytes(this.stream, this.buffer2), this.stream.getInt())) {
                return;
            }
        }
    }

    public int getTraceLength() {
        this.stream.position(this.position);
        return this.stream.getInt();
    }

    public void setStream(ByteBuffer byteBuffer) {
        this.stream = byteBuffer;
        this.position = byteBuffer.position();
    }
}
