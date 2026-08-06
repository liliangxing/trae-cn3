package com.bytedance.vmsdk.inspector_new.server.websocket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
class WriteHandler {
    private final BufferedOutputStream mBufferedOutput;

    public WriteHandler(OutputStream outputStream) {
        this.mBufferedOutput = new BufferedOutputStream(outputStream, 1024);
    }

    public synchronized void write(Frame frame, WriteCallback writeCallback) {
        try {
            frame.writeTo(this.mBufferedOutput);
            this.mBufferedOutput.flush();
            writeCallback.onSuccess();
        } catch (IOException e) {
            writeCallback.onFailure(e);
        }
    }
}
