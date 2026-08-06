package com.bytedance.vmsdk.inspector_new.server.websocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class WebSocketSession implements SimpleSession {
    private final SimpleEndpoint mEndpoint;
    private final ReadHandler mReadHandler;
    private volatile boolean mSentClose;
    private final WriteHandler mWriteHandler;
    private AtomicBoolean mIsOpen = new AtomicBoolean(false);
    private final ReadCallback mReadCallback = new ReadCallback() { // from class: com.bytedance.vmsdk.inspector_new.server.websocket.WebSocketSession.1
        private void handlePong(byte[] bArr, int i) {
        }

        @Override // com.bytedance.vmsdk.inspector_new.server.websocket.ReadCallback
        public void onCompleteFrame(byte b, byte[] bArr, int i) {
            if (b == 1) {
                handleTextFrame(bArr, i);
                return;
            }
            if (b != 2) {
                switch (b) {
                    case 8:
                        handleClose(bArr, i);
                        return;
                    case 9:
                        handlePing(bArr, i);
                        return;
                    case 10:
                        handlePong(bArr, i);
                        return;
                    default:
                        WebSocketSession.this.signalError(new IOException("Unsupported frame opcode=" + ((int) b)));
                        return;
                }
            }
            handleBinaryFrame(bArr, i);
        }

        private void handleClose(byte[] bArr, int i) {
            int i2;
            String str;
            if (i >= 2) {
                i2 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                str = i > 2 ? new String(bArr, 2, i - 2) : null;
            } else {
                i2 = 1006;
                str = "Unparseable close frame";
            }
            if (!WebSocketSession.this.mSentClose) {
                WebSocketSession.this.sendClose(1000, "Received close frame");
            }
            WebSocketSession.this.markAndSignalClosed(i2, str);
        }

        private void handlePing(byte[] bArr, int i) {
            WebSocketSession.this.doWrite(FrameHelper.createPongFrame(bArr, i));
        }

        private void handleTextFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(bArr, 0, i));
        }

        private void handleBinaryFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, bArr, i);
        }
    };
    private final WriteCallback mErrorForwardingWriteCallback = new WriteCallback() { // from class: com.bytedance.vmsdk.inspector_new.server.websocket.WebSocketSession.2
        @Override // com.bytedance.vmsdk.inspector_new.server.websocket.WriteCallback
        public void onSuccess() {
        }

        @Override // com.bytedance.vmsdk.inspector_new.server.websocket.WriteCallback
        public void onFailure(IOException iOException) {
            WebSocketSession.this.signalError(iOException);
        }
    };

    public WebSocketSession(InputStream inputStream, OutputStream outputStream, SimpleEndpoint simpleEndpoint) {
        this.mReadHandler = new ReadHandler(inputStream, simpleEndpoint);
        this.mWriteHandler = new WriteHandler(outputStream);
        this.mEndpoint = simpleEndpoint;
    }

    public void handle() throws IOException {
        markAndSignalOpen();
        try {
            this.mReadHandler.readLoop(this.mReadCallback);
        } catch (EOFException unused) {
            markAndSignalClosed(1011, "EOF while reading");
        } catch (IOException e) {
            markAndSignalClosed(1006, null);
            throw e;
        }
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleSession
    public void sendText(String str) {
        doWrite(FrameHelper.createTextFrame(str));
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleSession
    public void sendBinary(byte[] bArr) {
        doWrite(FrameHelper.createBinaryFrame(bArr));
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleSession
    public void close(int i, String str) {
        sendClose(i, str);
        markAndSignalClosed(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendClose(int i, String str) {
        doWrite(FrameHelper.createCloseFrame(i, str));
        markSentClose();
    }

    void markSentClose() {
        this.mSentClose = true;
    }

    void markAndSignalOpen() {
        if (this.mIsOpen.getAndSet(true)) {
            return;
        }
        this.mEndpoint.onOpen(this);
    }

    void markAndSignalClosed(int i, String str) {
        if (this.mIsOpen.getAndSet(false)) {
            this.mEndpoint.onClose(this, i, str);
        }
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleSession
    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWrite(Frame frame) {
        if (signalErrorIfNotOpen()) {
            return;
        }
        this.mWriteHandler.write(frame, this.mErrorForwardingWriteCallback);
    }

    private boolean signalErrorIfNotOpen() {
        if (isOpen()) {
            return false;
        }
        signalError(new IOException("Session is closed"));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalError(IOException iOException) {
        this.mEndpoint.onError(this, iOException);
    }
}
